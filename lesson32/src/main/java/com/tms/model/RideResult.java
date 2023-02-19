package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class RideResult {
    private List<CircleResult> circleResults;
}
