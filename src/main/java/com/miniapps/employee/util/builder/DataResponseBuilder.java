package com.miniapps.employee.util.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponseBuilder<T> {
    private String status;
    private Integer code;
    private String message;
    private T data;
}
