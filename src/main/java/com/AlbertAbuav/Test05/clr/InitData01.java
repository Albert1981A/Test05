package com.AlbertAbuav.Test05.clr;

import com.AlbertAbuav.Test05.beans.Employee;
import com.AlbertAbuav.Test05.beans.Job;
import com.AlbertAbuav.Test05.exception.CompanyCustomException;
import com.AlbertAbuav.Test05.services.CompanyService;
import com.AlbertAbuav.Test05.utils.ArtUtils;
import com.AlbertAbuav.Test05.utils.FactoryUtils;
import com.AlbertAbuav.Test05.utils.TestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Order(1)
public class InitData01 implements CommandLineRunner {

    private final CompanyService companyService;

    @Override
    public void run(String... args) {

        System.out.println(ArtUtils.INIT_DATA_1);

        TestUtils.testInfo("Add Employee");

        Job b1 = FactoryUtils.createJob();
        Job b2 = FactoryUtils.createJob();
        Job b3 = FactoryUtils.createJob();
        Job b4 = FactoryUtils.createJob();
        Job b5 = FactoryUtils.createJob();
        Job b6 = FactoryUtils.createJob();
        Job b7 = FactoryUtils.createJob();
        Job b8 = FactoryUtils.createJob();

        Employee e1 = Employee.builder()
                .name("Avi1")
                .salary(3000.5)
                .jobs(Arrays.asList(b1,b2))
                .build();

        Employee e2 = Employee.builder()
                .name("Ron2")
                .salary(4000.5)
                .jobs(Arrays.asList(b3,b4))
                .build();

        Employee e3 = Employee.builder()
                .name("Gideon3")
                .salary(5000.5)
                .jobs(Arrays.asList(b5,b6))
                .build();

        Employee e4 = Employee.builder()
                .name("Yossi4")
                .salary(6000.5)
                .jobs(Arrays.asList(b7,b8))
                .build();

        companyService.addEmployee(e1);
        companyService.addEmployee(e2);
        companyService.addEmployee(e3);
        companyService.addEmployee(e4);

        companyService.getAllEmployees().forEach(System.out::println);
        companyService.getAllJobs().forEach(System.out::println);

        TestUtils.testInfo("Get Employee By Id");

        System.out.println(companyService.getEmployeeById(1));

        TestUtils.testInfo("Get Employees By Name");

        System.out.println(companyService.getEmployeesByName("Ron2"));

        TestUtils.testInfo("Get All Employees");

        companyService.getAllEmployees().forEach(System.out::println);

        TestUtils.testInfo("Get All Jobs");

        companyService.getAllJobs().forEach(System.out::println);

        TestUtils.testInfo("Get Job By End Date");

        System.out.println(companyService.getJobByEndDate(Date.valueOf(LocalDate.now().plusDays(2))));

        TestUtils.testInfo("Get Jobs Between Dates");
        System.out.println("Invalid Operation:");
        System.out.println("------------------");
        try {
            companyService.getJobsBetweenDates(Date.valueOf(LocalDate.now().plusDays(4)), Date.valueOf(LocalDate.now().plusDays(2))).forEach(System.out::println);
        } catch (CompanyCustomException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Good Operation:");
        System.out.println("------------------");
        try {
            companyService.getJobsBetweenDates(Date.valueOf(LocalDate.now().plusDays(2)), Date.valueOf(LocalDate.now().plusDays(4))).forEach(System.out::println);
        } catch (CompanyCustomException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();


    }
}
