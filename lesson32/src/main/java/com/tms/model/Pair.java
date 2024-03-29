package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pair {
    private Horse horse;
    private Rider rider;
    private int number;
}
