package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class CircleResult {
    private int circle;
    private List<PairResult> pairResults;
}
