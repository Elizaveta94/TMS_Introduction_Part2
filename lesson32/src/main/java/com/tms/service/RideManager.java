package com.tms.service;

import com.tms.model.UserRideResult;

public interface RideManager {
    UserRideResult bet(int pairNumber, int bet);
    void setPair(int riderNumber, int horseNumber);
}
