package com.AlbertAbuav.Test05.services;

import com.AlbertAbuav.Test05.beans.Employee;
import com.AlbertAbuav.Test05.beans.Job;
import com.AlbertAbuav.Test05.exception.CompanyCustomException;

import java.util.List;

public interface CompanyService {

    void addEmployee(Employee employee);
    Employee getEmployeeById(long id);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getAllEmployees();
    List<Job> getAllJobs();
    Job getJobByEndDate(java.sql.Date endDate);
    List<Job> getJobsBetweenDates(java.sql.Date startDate, java.sql.Date endDate) throws CompanyCustomException;

}
