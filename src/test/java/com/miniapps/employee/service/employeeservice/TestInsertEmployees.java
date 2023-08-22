package com.miniapps.employee.service.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miniapps.employee.model.Employee;
import com.miniapps.employee.repository.EmployeeRepository;
import com.miniapps.employee.request.EmployeeInsertRequest;
import com.miniapps.employee.response.EmployeeGetResponse;
import com.miniapps.employee.service.EmployeeService;
import com.miniapps.employee.util.builder.DataResponseBuilder;

@ExtendWith(MockitoExtension.class)
class TestInsertEmployees {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private static Employee employee1;

    @BeforeAll
    static void beforeAll() {
        employee1 = Employee.builder()
            .id(1L)
            .nik("3201291999190001")
            .name("Muhammad Irfan Adi Prayoga")
            .age(24)
            .salary(new BigDecimal(10_000_000L))
        .build();
    }

    @Test
    void testInsertNewEmployeeReturnsSuccess() {
        EmployeeInsertRequest request = EmployeeInsertRequest.builder()
            .nik("3201291999190001")
            .name("Muhammad Irfan Adi Prayoga")
            .age(24)
            .salary(new BigDecimal(10_000_000L))
        .build();

        when(employeeRepository.existsByNik(anyString())).thenReturn(false);
        when(employeeRepository.save(any())).thenReturn(employee1);

        DataResponseBuilder<EmployeeGetResponse> response = employeeService.insertNewEmployee(request);

        assertEquals(200, response.getCode());
    }

    @Test
    void testInsertNewEmployeeReturnsFailExistNIK() {
        EmployeeInsertRequest request = EmployeeInsertRequest.builder()
            .nik("3201291999190001")
            .name("Muhammad Irfan Adi Prayoga")
            .age(24)
            .salary(new BigDecimal(10_000_000L))
        .build();

        when(employeeRepository.existsByNik(anyString())).thenReturn(true);

        DataResponseBuilder<EmployeeGetResponse> response = employeeService.insertNewEmployee(request);

        assertEquals(400, response.getCode());
    }
}
