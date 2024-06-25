package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Document;
import com.scm.Supply.chain.apis.Repo.DocumentRepository;

@Service
public class DocumentService {
	
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document createDocument(String name, String type, String contentType, byte[] content) {
        Document document = new Document();
        document.setName(name);
        document.setType(type);
        document.setContentType(contentType);
        document.setContent(content);
        document.setCreatedAt(LocalDateTime.now());
        document.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }

    public Document updateDocument(Long id, String name, String type, String contentType, byte[] content) throws Exception {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();
            document.setName(name);
            document.setType(type);
            document.setContentType(contentType);
            document.setContent(content);
            document.setUpdatedAt(LocalDateTime.now());
            return documentRepository.save(document);
        } else {
            throw new Exception("Document not found with id: " + id);
        }
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> getDocumentsByType(String type) {
        return documentRepository.findByType(type);
    }

    public Optional<Document> getDocumentByNameAndType(String name, String type) {
        return documentRepository.findByNameAndType(name, type);
    }
}
