package com.tms.service;

import com.tms.model.Pair;
import com.tms.model.RideResult;

import java.util.List;

public interface RideSimulator {
    RideResult ride(int circleCount, int circleDistance, List<Pair> pairs);
}
