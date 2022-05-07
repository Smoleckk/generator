package com.example.generator.generator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private long id;
    private String salary;
    private String amount;
    private String price;
    private String sum;
}
