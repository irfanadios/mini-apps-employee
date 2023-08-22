package com.miniapps.employee.service.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miniapps.employee.model.Employee;
import com.miniapps.employee.repository.EmployeeRepository;
import com.miniapps.employee.request.EmployeeGetByNameRequest;
import com.miniapps.employee.response.EmployeeGetResponse;
import com.miniapps.employee.service.EmployeeService;
import com.miniapps.employee.util.builder.ListResponseBuilder;

@ExtendWith(MockitoExtension.class)
class TestGetAllEmployees {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private static Employee employee1;

    private static Employee employee2;

    @BeforeAll
    static void beforeAll() {
        employee1 = Employee.builder()
            .id(1L)
            .nik("3201291999190001")
            .name("Muhammad Irfan Adi Prayoga")
            .age(24)
            .salary(new BigDecimal(10_000_000L))
        .build();
        employee2 = Employee.builder()
            .id(2L)
            .nik("3201291999190002")
            .name("Muhammad Alejandro Putra")
            .age(22)
            .salary(new BigDecimal(10_000_000L))
        .build();
    }

    @Test
    void testGetAllEmployeeDataSize2() {
        List<Employee> employees = List.of(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employees);

        ListResponseBuilder<EmployeeGetResponse> response = employeeService.getAllEmployeeData(null);

        assertEquals(2, response.getData().size());
    }
    
    @Test
    void testGetAllEmployeeByName() {
        EmployeeGetByNameRequest request = EmployeeGetByNameRequest.builder()
            .name("Irfan")
        .build();
        List<Employee> employees = List.of(employee1);

        when(employeeRepository.findByNameContaining(anyString())).thenReturn(employees);

        ListResponseBuilder<EmployeeGetResponse> response = employeeService.getAllEmployeeData(request);

        assertEquals(1, response.getData().size());
    }
}
