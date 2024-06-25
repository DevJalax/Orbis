package com.scm.Supply.chain.apis.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.scm.Supply.chain.apis.Entity.Document;
import com.scm.Supply.chain.apis.Service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
	
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestParam("name") String name,
                                                  @RequestParam("type") String type,
                                                  @RequestParam("file") MultipartFile file) {
        try {
            Document document = documentService.createDocument(
                name,
                type,
                file.getContentType(),
                file.getBytes()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(document);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id,
                                                  @RequestParam("name") String name,
                                                  @RequestParam("type") String type,
                                                  @RequestParam("file") MultipartFile file) throws Exception {
        try {
            Document document = documentService.updateDocument(
                id,
                name,
                type,
                file.getContentType(),
                file.getBytes()
            );
            return ResponseEntity.ok(document);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Document>> getDocumentsByType(@PathVariable String type) {
        List<Document> documents = documentService.getDocumentsByType(type);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/{name}/{type}")
    public ResponseEntity<Document> getDocumentByNameAndType(@PathVariable String name,
                                                             @PathVariable String type) {
        Optional<Document> optionalDocument = documentService.getDocumentByNameAndType(name, type);
        return optionalDocument.map(ResponseEntity::ok)
                               .orElse(ResponseEntity.notFound().build());
    }
}
