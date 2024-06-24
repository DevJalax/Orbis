package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Attendance;
import com.scm.Supply.chain.apis.Entity.Employee;
import com.scm.Supply.chain.apis.Entity.Payroll;
import com.scm.Supply.chain.apis.Entity.PerformanceReview;
import com.scm.Supply.chain.apis.Entity.Training;
import com.scm.Supply.chain.apis.Service.HRManagementService;

@RestController
@RequestMapping("/api/hr")
public class HRManagementController {
	
    private final HRManagementService hrManagementService;

    @Autowired
    public HRManagementController(HRManagementService hrManagementService) {
        this.hrManagementService = hrManagementService;
    }

    // Employee Management
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return hrManagementService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = hrManagementService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = hrManagementService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = hrManagementService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        hrManagementService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Payroll Management
    @GetMapping("/payroll")
    public List<Payroll> getAllPayroll() {
        return hrManagementService.getAllPayroll();
    }

    @GetMapping("/payroll/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        Payroll payroll = hrManagementService.getPayrollById(id);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/payroll")
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll createdPayroll = hrManagementService.createPayroll(payroll);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
    }

    // Attendance Management
    @GetMapping("/attendance")
    public List<Attendance> getAllAttendance() {
        return hrManagementService.getAllAttendance();
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = hrManagementService.getAttendanceById(id);
        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/attendance")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = hrManagementService.createAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendance);
    }

    // Performance Management
    @GetMapping("/performance-reviews")
    public List<PerformanceReview> getAllPerformanceReviews() {
        return hrManagementService.getAllPerformanceReviews();
    }

    @GetMapping("/performance-reviews/{id}")
    public ResponseEntity<PerformanceReview> getPerformanceReviewById(@PathVariable Long id) {
        PerformanceReview review = hrManagementService.getPerformanceReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/performance-reviews")
    public ResponseEntity<PerformanceReview> createPerformanceReview(@RequestBody PerformanceReview review) {
        PerformanceReview createdReview = hrManagementService.createPerformanceReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    // Training Management
    @GetMapping("/trainings")
    public List<Training> getAllTrainings() {
        return hrManagementService.getAllTrainings();
    }

    @GetMapping("/trainings/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
        Training training = hrManagementService.getTrainingById(id);
        if (training != null) {
            return ResponseEntity.ok(training);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/trainings")
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
        Training createdTraining = hrManagementService.createTraining(training);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTraining);
    }
}
