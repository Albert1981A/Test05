package com.AlbertAbuav.Test05.wrappers;

import com.AlbertAbuav.Test05.beans.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeList {
    List<Employee> employees = new ArrayList<>();
}
