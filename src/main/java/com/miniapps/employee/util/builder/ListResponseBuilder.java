package com.miniapps.employee.util.builder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListResponseBuilder<T> {
    private String status;
    private Integer code;
    private String message;
    private List<T> data;
}
