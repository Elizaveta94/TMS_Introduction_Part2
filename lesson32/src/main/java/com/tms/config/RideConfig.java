package com.tms.config;

import com.tms.model.Horse;
import com.tms.model.Pair;
import com.tms.model.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RideConfig {
    private static final int PAIR_COUNT = 10;

    @Bean
    public List<Rider> riders() {
        ArrayList<Rider> riders = new ArrayList<>(PAIR_COUNT);
        for (int i = 1; i <= PAIR_COUNT; i++) {
            riders.add(new Rider(i));
        }
        return riders;
    }

    @Bean
    public List<Horse> horses() {
        ArrayList<Horse> horses = new ArrayList<>(PAIR_COUNT);
        for (int i = 1; i <= PAIR_COUNT; i++) {
            horses.add(new Horse(i));
        }
        return horses;
    }

    @Bean
    public List<Pair> pairs() {
        ArrayList<Pair> pairs = new ArrayList<>(PAIR_COUNT);
        return pairs;
    }
}
