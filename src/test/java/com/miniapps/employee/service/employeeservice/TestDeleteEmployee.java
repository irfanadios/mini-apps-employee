package com.miniapps.employee.service.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miniapps.employee.repository.EmployeeRepository;
import com.miniapps.employee.service.EmployeeService;
import com.miniapps.employee.util.builder.DataResponseBuilder;

@ExtendWith(MockitoExtension.class)
class TestDeleteEmployee {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void deleteEmployeeReturnsSuccess() {
        when(employeeRepository.existsById(anyLong())).thenReturn(true);

        DataResponseBuilder<Object> response = employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).deleteById(anyLong());

        assertEquals(200, response.getCode());
        assertEquals("Delete Employee Success.", response.getMessage());
    }

    @Test
    void deleteEmployeeReturnsNotFound() {
        when(employeeRepository.existsById(anyLong())).thenReturn(false);

        DataResponseBuilder<Object> response = employeeService.deleteEmployee(1L);

        assertEquals(404, response.getCode());
        assertEquals("Delete Employee By Id Fail. Id Not Found.", response.getMessage());
    }
}
