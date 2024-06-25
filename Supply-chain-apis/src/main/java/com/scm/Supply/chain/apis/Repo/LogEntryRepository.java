package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.LogEntry;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
	
    List<LogEntry> findByServiceNameAndSeverityOrderByTimestampDesc(String serviceName, String severity);
    
    List<LogEntry> findByLogTypeOrderByTimestampDesc(String logType);

}