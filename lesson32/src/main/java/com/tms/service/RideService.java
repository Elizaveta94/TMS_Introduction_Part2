package com.tms.service;

import com.tms.model.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {
    public int sumSpeed(Pair pair) {
        return pair.getHorse().getSpeed() + pair.getRider().getLevel();
    }

    public Pair ride(int circle, List<Pair> pairs) throws InterruptedException {
        List<Pair> sortedPairs = pairs.stream().sorted((pair1, pair2) -> sumSpeed(pair2) - sumSpeed(pair1)).toList();
        for (int i = 1; i <= circle; i++) {
            Thread.sleep(2000);
            System.out.println("Circle: " + i);
            for (int j = 1; j <= sortedPairs.size(); j++) {
                System.out.println(j + ". " + sortedPairs.get(j - 1));
            }
        }

        return sortedPairs.get(0);
    }
}

