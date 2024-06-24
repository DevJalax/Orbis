package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Report;
import com.scm.Supply.chain.apis.Repo.ReportRepository;

@Service
public class ReportService {
	
    private final ReportRepository reportRepository;
    
    private final PowerBIService powerBIService;

    @Autowired
    public ReportService(ReportRepository reportRepository, PowerBIService powerBIService) {
        this.reportRepository = reportRepository;
        this.powerBIService = powerBIService;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new Exception("Report not found with id: " + id));
    }

    public Report createReport(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        report.setPowerBIReportId(powerBIService.createPowerBIReport(report));
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report reportDetails) {
        Report report = getReportById(id);
        report.setName(reportDetails.getName());
        report.setDescription(reportDetails.getDescription());
        report.setData(reportDetails.getData());
        report.setPowerBIReportId(powerBIService.updatePowerBIReport(report));
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        Report report = getReportById(id);
        powerBIService.deletePowerBIReport(report.getPowerBIReportId());
        reportRepository.delete(report);
    }

    public List<Report> getReportsCreatedSinceTimestamp(LocalDateTime timestamp) {
        return reportRepository.findByCreatedAtAfter(timestamp);
    }
}
