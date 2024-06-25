package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.LogEntry;
import com.scm.Supply.chain.apis.Repo.LogEntryRepository;

@Service
public class LogEntryService {
	
    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogEntryService(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    public LogEntry createLogEntry(LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    public List<LogEntry> getLogEntriesByServiceAndSeverity(String serviceName, String severity) {
        return logEntryRepository.findByServiceNameAndSeverityOrderByTimestampDesc(serviceName, severity);
    }

    public List<LogEntry> getLogEntriesByLogType(String logType) {
        return logEntryRepository.findByLogTypeOrderByTimestampDesc(logType);
    }
}
