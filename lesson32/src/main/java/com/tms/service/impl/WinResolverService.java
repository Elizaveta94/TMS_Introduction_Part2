package com.tms.service.impl;

import com.tms.model.*;
import com.tms.service.WinResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WinResolverService implements WinResolver {
    private List<Pair> pair;

    @Override
    public WinStat resolveWinStat(RideResult rideResult, int pairNumber, int bet) {
        WinStat winStat = new WinStat();
        winStat.setWinner(getWinner(rideResult.getCircleResults()));
        winStat.setWinBalance(calculateWinBalance(rideResult.getCircleResults(), pairNumber, bet));
        winStat.setYouWin(isWin(rideResult.getCircleResults(), pairNumber));
        return winStat;
    }

    private Pair getWinner(List<CircleResult> circleResult) {
        CircleResult lastCircle = circleResult.get(circleResult.size() - 1);
        List<PairResult> pairResults = lastCircle.getPairResults();
        return pairResults.get(0).getPair();
    }

    private int calculateWinBalance(List<CircleResult> circleResult, int pairNumber, int bet) {
        if (isWin(circleResult, pairNumber)) {
            return pair.size() * bet;
        } else {
            return 0;
        }
    }

    private boolean isWin(List<CircleResult> circleResult, int pairNumber) {
        CircleResult lastCircle = circleResult.get(circleResult.size() - 1);
        return lastCircle.getPairResults().get(0).getPair().getNumber() == pairNumber;
    }

}
