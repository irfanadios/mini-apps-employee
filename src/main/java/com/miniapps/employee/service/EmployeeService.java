package com.miniapps.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miniapps.employee.model.Employee;
import com.miniapps.employee.repository.EmployeeRepository;
import com.miniapps.employee.request.EmployeeGetByNameRequest;
import com.miniapps.employee.request.EmployeeInsertRequest;
import com.miniapps.employee.request.EmployeeUpdateRequest;
import com.miniapps.employee.response.EmployeeGetResponse;
import com.miniapps.employee.util.builder.DataResponseBuilder;
import com.miniapps.employee.util.builder.ListResponseBuilder;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final String SUCCESS = "Success";

    public ListResponseBuilder<EmployeeGetResponse> getAllEmployeeData(EmployeeGetByNameRequest request) {
        List<Employee> listEmployee = request == null ? employeeRepository.findAll() : employeeRepository.findByNameContaining(request.getName());

        List<EmployeeGetResponse> employeeResponse = listEmployee.stream().map(this::buildGetEmployeeResponse).toList();

        return ListResponseBuilder.<EmployeeGetResponse>builder()
            .code(HttpStatus.OK.value())
            .status(SUCCESS)
            .message("Get All Employe "+(request == null ? "Data" : "By Name")+" Success!")
            .data(employeeResponse)
        .build();
    }

    public DataResponseBuilder<EmployeeGetResponse> getByNik(String nik) {
        Optional<Employee> optEmployee = employeeRepository.findByNik(nik);

        if (optEmployee.isEmpty()) {
            return DataResponseBuilder.<EmployeeGetResponse>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status("Fail")
                .message("Get Employee By NIK Fail. NIK Not Found.")
            .build();
        }

        Employee employee = optEmployee.get();

        EmployeeGetResponse response = buildGetEmployeeResponse(employee);

        return DataResponseBuilder.<EmployeeGetResponse>builder()
            .code(HttpStatus.OK.value())
            .status(SUCCESS)
            .message("Get Employee by NIK Success.")
            .data(response)
        .build();
    }

    public DataResponseBuilder<EmployeeGetResponse> insertNewEmployee(EmployeeInsertRequest request) {
        if (employeeRepository.existsByNik(request.getNik()).booleanValue()) {
            return DataResponseBuilder.<EmployeeGetResponse>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status("Fail")
                .message("Insert New Employee Fail. NIK is Not Unique.")
            .build();
        }
        
        Employee newEmployee = Employee.builder()
            .nik(request.getNik())
            .name(request.getName())
            .age(request.getAge())
            .salary(request.getSalary())
        .build();

        Employee savedEmployee = employeeRepository.save(newEmployee);

        EmployeeGetResponse response = buildGetEmployeeResponse(savedEmployee);

        return DataResponseBuilder.<EmployeeGetResponse>builder()
            .code(HttpStatus.OK.value())
            .status(SUCCESS)
            .message("Insert New Employee Success.")
            .data(response)
        .build();
    }

    public DataResponseBuilder<EmployeeGetResponse> updateEmployee(Long id, @Valid EmployeeUpdateRequest request) {
        if (!employeeRepository.existsById(id)) {
            return DataResponseBuilder.<EmployeeGetResponse>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status("Fail")
                .message("Update Employee By Id Fail. Id Not Found.")
            .build();
        }

        Employee employee = employeeRepository.getReferenceById(id);

        if (employeeRepository.existsByNik(request.getNik()).booleanValue() && !request.getNik().equalsIgnoreCase(employee.getNik())) {
            return DataResponseBuilder.<EmployeeGetResponse>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status("Fail")
                .message("Update Employee By Id Fail. NIK is Not Unique.")
            .build();
        }

        employee.setNik(request.getNik());
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setSalary(request.getSalary());

        EmployeeGetResponse response = buildGetEmployeeResponse(employee);

        return DataResponseBuilder.<EmployeeGetResponse>builder()
            .code(HttpStatus.OK.value())
            .status(SUCCESS)
            .message("Update Employee Success.")
            .data(response)
        .build();
    }

    public DataResponseBuilder<Object> deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            return DataResponseBuilder.<Object>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status("Fail")
                .message("Delete Employee By Id Fail. Id Not Found.")
            .build();
        }

        employeeRepository.deleteById(id);

        return DataResponseBuilder.builder()
            .code(HttpStatus.OK.value())
            .status(SUCCESS)
            .message("Delete Employee Success.")
        .build();
    }

    private EmployeeGetResponse buildGetEmployeeResponse(Employee employee) {
        return EmployeeGetResponse.builder()
            .id(employee.getId())
            .nik(employee.getNik())
            .name(employee.getName())
            .age(employee.getAge())
            .salary(employee.getSalary())
        .build();
    }

}
