package com.miniapps.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniapps.employee.request.EmployeeGetByNameRequest;
import com.miniapps.employee.request.EmployeeInsertRequest;
import com.miniapps.employee.request.EmployeeUpdateRequest;
import com.miniapps.employee.response.EmployeeGetResponse;
import com.miniapps.employee.service.EmployeeService;
import com.miniapps.employee.util.builder.DataResponseBuilder;
import com.miniapps.employee.util.builder.ListResponseBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<ListResponseBuilder<EmployeeGetResponse>> getAllEmployeeData(@RequestBody(required = false) EmployeeGetByNameRequest request) {
        ListResponseBuilder<EmployeeGetResponse> response = employeeService.getAllEmployeeData(request);

        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/employee/{nik}")
    public ResponseEntity<DataResponseBuilder<EmployeeGetResponse>> getByNik(@PathVariable(name = "nik") String nik) {
        DataResponseBuilder<EmployeeGetResponse> response = employeeService.getByNik(nik);

        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping("/employee")
    public ResponseEntity<DataResponseBuilder<EmployeeGetResponse>> insertNewEmployee(@Valid @RequestBody(required = true) EmployeeInsertRequest request) {
        DataResponseBuilder<EmployeeGetResponse> response = employeeService.insertNewEmployee(request);

        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<DataResponseBuilder<EmployeeGetResponse>> updateEmployee(@Valid @RequestBody(required = true) EmployeeUpdateRequest request, @PathVariable(name = "id") Long id) {
        DataResponseBuilder<EmployeeGetResponse> response = employeeService.updateEmployee(id, request);

        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<DataResponseBuilder<Object>> deleteEmployee(@PathVariable(name = "id") Long id) {
        DataResponseBuilder<Object> response = employeeService.deleteEmployee(id);

        return ResponseEntity.status(response.getCode()).body(response);
    }
}
