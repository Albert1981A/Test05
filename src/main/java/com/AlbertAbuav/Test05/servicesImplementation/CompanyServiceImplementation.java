package com.AlbertAbuav.Test05.servicesImplementation;

import com.AlbertAbuav.Test05.beans.Employee;
import com.AlbertAbuav.Test05.beans.Job;
import com.AlbertAbuav.Test05.exception.CompanyCustomException;
import com.AlbertAbuav.Test05.repositories.EmployeeRepository;
import com.AlbertAbuav.Test05.repositories.JobRepository;
import com.AlbertAbuav.Test05.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImplementation implements CompanyService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobByEndDate(Date endDate) {
        return jobRepository.findByEndDate(endDate);
    }

    @Override
    public List<Job> getJobsBetweenDates(Date startDate, Date endDate) throws CompanyCustomException {
        if (endDate.before(startDate)) {
            throw new CompanyCustomException("The end date can't be before the start date");
        }
        return jobRepository.findByEndDateBetween(startDate, endDate);
    }
}
