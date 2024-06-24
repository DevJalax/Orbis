package com.scm.Supply.chain.apis.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.http.HttpHeaders;
import com.scm.Supply.chain.apis.Entity.Report;

@Service
public class PowerBIClient {
	
    private final String POWER_BI_API_URL = "https://api.powerbi.com/v1.0/myorg";
    private final String POWER_BI_APP_ID = "YOUR_POWER_BI_APP_ID";
    private final String POWER_BI_APP_SECRET = "YOUR_POWER_BI_APP_SECRET";

    private final RestTemplate restTemplate;

    public PowerBIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Report createReport(Report report) {
        HttpEntity<Report> requestEntity = new HttpEntity<>(report, getAuthorizationHeaders());
        ResponseEntity<Report> responseEntity = restTemplate.exchange(
                POWER_BI_API_URL + "/reports",
                HttpMethod.POST,
                requestEntity,
                Report.class
        );
        return responseEntity.getBody();
    }

    public Report updateReport(Report report) {
        HttpEntity<Report> requestEntity = new HttpEntity<>(report, getAuthorizationHeaders());
        ResponseEntity<Report> responseEntity = restTemplate.exchange(
                POWER_BI_API_URL + "/reports/" + report.getPowerBIReportId(),
                HttpMethod.PUT,
                requestEntity,
                Report.class
        );
        return responseEntity.getBody();
    }

    public void deleteReport(String reportId) {
        HttpEntity<?> requestEntity = new HttpEntity<>(getAuthorizationHeaders());
        restTemplate.exchange(
                POWER_BI_API_URL + "/reports/" + reportId,
                HttpMethod.DELETE,
                requestEntity,
                Void.class
        );
    }

    private HttpHeaders getAuthorizationHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(getAccessToken());
        return headers;
    }

    private String getAccessToken() {
        // Implement logic to obtain an access token using the Power BI app ID and secret
        // This could involve making a request to the Power BI OAuth endpoint
        // and exchanging the app ID and secret for an access token
        return "YOUR_ACCESS_TOKEN";
    }
}
