package com.miniapps.employee.request;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInsertRequest {
    @NotBlank(message = "NIK must not be empty.")
    @Length(max = 16, min = 16, message = "NIK must contains 16 digits")
    private String nik;
    @NotBlank
    @Length(max = 50, message = "Name can not be more than 50 letters")
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private BigDecimal salary;
}
