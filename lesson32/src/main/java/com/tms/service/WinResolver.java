package com.tms.service;

import com.tms.model.RideResult;
import com.tms.model.WinStat;

public interface WinResolver {
    WinStat resolveWinStat(RideResult rideResult, int pairNumber, int bet);
}
