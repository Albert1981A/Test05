package com.AlbertAbuav.Test05.clr;

import com.AlbertAbuav.Test05.beans.Employee;
import com.AlbertAbuav.Test05.beans.Job;
import com.AlbertAbuav.Test05.services.CompanyService;
import com.AlbertAbuav.Test05.utils.ArtUtils;
import com.AlbertAbuav.Test05.utils.FactoryUtils;
import com.AlbertAbuav.Test05.utils.TestUtils;
import com.AlbertAbuav.Test05.wrappers.EmployeeList;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Order(2)
public class ControllerTesting implements CommandLineRunner {

    private final static String BASE_URL = "http://localhost:8080/Company";

    private final RestTemplate restTemplate;
    private final CompanyService companyService;

    @Override
    public void run(String... args) {

        System.out.println(ArtUtils.CONTROLLER_TESTING);

        Job b1 = FactoryUtils.createJob();
        Job b2 = FactoryUtils.createJob();

        Employee e1 = Employee.builder()
                .name("New-Employee")
                .salary(3020.5)
                .jobs(Arrays.asList(b1,b2))
                .build();

        System.out.println("New employee to add:");
        System.out.println(e1);
        System.out.println();

        TestUtils.testInfo("Add a Employee");

        ResponseEntity<String> res1 = restTemplate.postForEntity(BASE_URL + "/employees", e1, String.class);
        System.out.println(res1);
        System.out.println(res1.getStatusCodeValue());
        System.out.println(res1.getStatusCodeValue() == 201);
        System.out.println(res1.getStatusCodeValue() == HttpStatus.CREATED.value());

        TestUtils.testInfo("Get employee by id (Employee id 3)");

        Employee employeeToGet = restTemplate.getForObject(BASE_URL + "/employees/3", Employee.class);
        System.out.println("Employee id-3:");
        System.out.println(employeeToGet);

        TestUtils.testInfo("Get all employees");
        EmployeeList res2 = restTemplate.getForObject(BASE_URL + "/employees", EmployeeList.class);
        res2.getEmployees().forEach(System.out::println);

        TestUtils.testInfo("Get employees by name");
        System.out.println("Employee named: \"Avi1\"");
        EmployeeList res3 = restTemplate.getForObject(BASE_URL + "/employees/by_name?name=Avi1", EmployeeList.class);
        res3.getEmployees().forEach(System.out::println);

    }
}
