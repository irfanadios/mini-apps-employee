package com.miniapps.employee.request;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {
    @Length(max = 16, min = 16, message = "NIK must contains 16 digits")
    private String nik;
    @Length(max = 50, message = "Name can not be more than 50 letters")
    private String name;
    private Integer age;
    private BigDecimal salary;
}
