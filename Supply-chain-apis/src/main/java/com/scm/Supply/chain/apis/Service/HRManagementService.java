package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Attendance;
import com.scm.Supply.chain.apis.Entity.Employee;
import com.scm.Supply.chain.apis.Entity.Payroll;
import com.scm.Supply.chain.apis.Entity.PerformanceReview;
import com.scm.Supply.chain.apis.Entity.Training;
import com.scm.Supply.chain.apis.Repo.AttendanceRepository;
import com.scm.Supply.chain.apis.Repo.EmployeeRepository;
import com.scm.Supply.chain.apis.Repo.PayrollRepository;
import com.scm.Supply.chain.apis.Repo.PerformanceReviewRepository;
import com.scm.Supply.chain.apis.Repo.TrainingRepository;

@Service
public class HRManagementService {
	
    private final EmployeeRepository employeeRepository;
    
    private final PayrollRepository payrollRepository;
    
    private final AttendanceRepository attendanceRepository;
    
    private final PerformanceReviewRepository performanceReviewRepository;
    
    private final TrainingRepository trainingRepository;

    @Autowired
    public HRManagementService(EmployeeRepository employeeRepository, PayrollRepository payrollRepository,
                               AttendanceRepository attendanceRepository, PerformanceReviewRepository performanceReviewRepository,
                               TrainingRepository trainingRepository) {
        this.employeeRepository = employeeRepository;
        this.payrollRepository = payrollRepository;
        this.attendanceRepository = attendanceRepository;
        this.performanceReviewRepository = performanceReviewRepository;
        this.trainingRepository = trainingRepository;
    }

    // Employee Management
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setHireDate(updatedEmployee.getHireDate());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Payroll Management
    public List<Payroll> getAllPayroll() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public Payroll createPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    // Attendance Management
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Performance Management
    public List<PerformanceReview> getAllPerformanceReviews() {
        return performanceReviewRepository.findAll();
    }

    public PerformanceReview getPerformanceReviewById(Long id) {
        return performanceReviewRepository.findById(id).orElse(null);
    }

    public PerformanceReview createPerformanceReview(PerformanceReview review) {
        return performanceReviewRepository.save(review);
    }

    // Training Management
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }
}
