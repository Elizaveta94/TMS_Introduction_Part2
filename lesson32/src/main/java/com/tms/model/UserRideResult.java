package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRideResult {
    private RideResult rideResult;
    private WinStat winStat;
}
