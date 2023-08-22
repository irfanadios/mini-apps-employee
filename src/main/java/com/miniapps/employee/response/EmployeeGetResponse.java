package com.miniapps.employee.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeGetResponse {
    private Long id;
    private String nik;
    private String name;
    private Integer age;
    private BigDecimal salary;
}
