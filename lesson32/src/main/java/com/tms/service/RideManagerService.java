package com.tms.service;

import com.tms.model.Pair;

import java.util.List;
import java.util.Scanner;

public class RideManagerService {
    private Pair pair1;
    private Pair pair2;
    private Pair pair3;
    private RideService rideService;

    public RideManagerService(Pair pair1, Pair pair2, Pair pair3, RideService rideService) {
        this.pair1 = pair1;
        this.pair2 = pair2;
        this.pair3 = pair3;
        this.rideService = rideService;
    }

    public void bet() throws InterruptedException {
        System.out.println("Make a bet on pair from 1 to 3: ");
        Scanner scanner = new Scanner(System.in);
        int pairNumber = scanner.nextInt();
        if (pairNumber < 1 || pairNumber > 3) {
            throw new RuntimeException("Pair number must be between 1 to 3");
        }
        System.out.println("Pair number 1: " + pair1);
        System.out.println("Pair number 2: " + pair2);
        System.out.println("Pair number 3: " + pair3);
        List<Pair> pairs = List.of(pair1, pair2, pair3);
        Pair winner = rideService.ride(5, pairs);
        int winnerNumber = pairs.indexOf(winner) + 1;
        System.out.println("Winner pair number: " + winnerNumber);
        if (pairNumber == winnerNumber) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose:(");
        }
    }
}
