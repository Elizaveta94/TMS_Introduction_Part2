package com.tms.service.impl;

import com.tms.model.Horse;
import com.tms.model.Pair;
import com.tms.model.Rider;
import com.tms.service.SpeedSimulator;
import org.springframework.stereotype.Service;

@Service
public class SpeedSimulatorService implements SpeedSimulator {
    @Override
    public int simulate(int circle, Pair pair) {
        Rider rider = pair.getRider();
        Horse horse = pair.getHorse();
        return ((horse.getSpeed() * ((horse.getStamina() - circle) * rider.getLevel())) / 100) + 1;
    }
}
