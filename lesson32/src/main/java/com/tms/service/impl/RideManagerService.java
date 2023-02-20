package com.tms.service.impl;

import com.tms.exception.InvalidBet;
import com.tms.exception.InvalidPairBet;
import com.tms.exception.ResourceNotFound;
import com.tms.model.*;
import com.tms.service.RideManager;
import com.tms.service.RideSimulator;
import com.tms.service.WinResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RideManagerService implements RideManager {
    private static final int CIRCLE_COUNT = 5;
    private static final int CIRCLE_DISTANCE = 1000;
    private User user;
    private List<Rider> riders;
    private List<Horse> horses;
    private List<Pair> pairs;
    private RideSimulator rideSimulator;
    private WinResolver winResolver;

    @Override
    public UserRideResult bet(int pairNumber, int bet) {
        validateBet(bet);
        validatePair(pairNumber);
        RideResult rideResult = rideSimulator.ride(CIRCLE_COUNT, CIRCLE_DISTANCE, pairs);
        WinStat winStat = winResolver.resolveWinStat(rideResult, pairNumber, bet);
        user.setBalance(user.getBalance() - bet + winStat.getWinBalance());
        clearPairs();
        return new UserRideResult(rideResult, winStat);
    }

    @Override
    public void setPair(int riderNumber, int horseNumber) {
        Rider rider = riders.stream().filter(r -> r.getNumber() == riderNumber).findFirst().orElseThrow(() -> new ResourceNotFound("Rider with number %d not found".formatted(riderNumber)));
        Horse horse = horses.stream().filter(h -> h.getNumber() == horseNumber).findFirst().orElseThrow(() -> new ResourceNotFound("Horse with number %d not found".formatted(horseNumber)));
        riders.remove(rider);
        horses.remove(horse);
        pairs.add(new Pair(horse, rider, pairs.size() + 1));
    }

    private void validateBet(int bet) {
        if (user.getBalance() < bet) {
            throw new InvalidBet("Insufficient balance, balance: %d , bet: %d.".formatted(user.getBalance(), bet));
        }
    }

    private void validatePair(int pairNumber) {
        if (pairs.size() < 2) {
            throw new InvalidPairBet("At least 2 pairs should be created.");
        } else if (pairs.stream().noneMatch(p -> p.getNumber() == pairNumber)) {
            throw new ResourceNotFound("Pair with number %d not found.".formatted(pairNumber));
        }
    }

    private void clearPairs() {
        riders.addAll(pairs.stream().map(Pair::getRider).toList());
        horses.addAll(pairs.stream().map(Pair::getHorse).toList());
        pairs.clear();
    }
}
