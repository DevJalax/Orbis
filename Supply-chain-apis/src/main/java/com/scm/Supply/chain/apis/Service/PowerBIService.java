package com.scm.Supply.chain.apis.Service;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Report;

@Service
public class PowerBIService {
	
    private final PowerBIClient powerBIClient;

    public PowerBIService(PowerBIClient powerBIClient) {
        this.powerBIClient = powerBIClient;
    }

    public String createPowerBIReport(Report report) {
        // Create a new Power BI report using the report data
        Report powerBIReport = powerBIClient.createReport(report);
        
        return powerBIReport.getPowerBIReportId();
    }

    public String updatePowerBIReport(Report report) {
        // Update the existing Power BI report with the new report data
        Report updatedPowerBIReport = powerBIClient.updateReport(report);
        
        return updatedPowerBIReport.getPowerBIReportId();
    }

    public void deletePowerBIReport(String reportId) {
        // Delete the Power BI report with the given ID
        powerBIClient.deleteReport(reportId);
    }
}
