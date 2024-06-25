package com.scm.Supply.chain.apis.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
    List<Document> findByType(String type);
    
    Optional<Document> findByNameAndType(String name, String type);

}
