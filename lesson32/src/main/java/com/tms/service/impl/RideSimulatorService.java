package com.tms.service.impl;

import com.tms.model.CircleResult;
import com.tms.model.Pair;
import com.tms.model.PairResult;
import com.tms.model.RideResult;
import com.tms.service.RideSimulator;
import com.tms.service.SpeedSimulator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RideSimulatorService implements RideSimulator {
    private SpeedSimulator speedSimulator;

    public RideResult ride(int circleCount, int circleDistance, List<Pair> pairs) {
        RideResult rideResult = new RideResult(new ArrayList<>());
        Map<Pair, Integer> pairResultMap = pairs.stream().collect(Collectors.toMap(p -> p, p -> 0));
        for (int i = 1; i <= circleCount; i++) {
            for (Map.Entry<Pair, Integer> entry : pairResultMap.entrySet()) {
                entry.setValue(entry.getValue() + (circleDistance / speedSimulator.simulate(i, entry.getKey())));
            }
            rideResult.getCircleResults().add(calculateCircleResult(pairResultMap, i));
        }
        return rideResult;
    }

    private CircleResult calculateCircleResult(Map<Pair, Integer> pairResultMap, int circle) {
        CircleResult circleResult = new CircleResult();
        circleResult.setCircle(circle);
        List<Pair> pairs = pairResultMap.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
        List<PairResult> pairResults = new ArrayList<>();
        for (int i = 1; i <= pairs.size(); i++) {
            pairResults.add(new PairResult(pairs.get(i - 1), i));
        }
        circleResult.setPairResults(pairResults);
        return circleResult;
    }
}

