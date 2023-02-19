package com.tms.controller;

import com.tms.model.*;
import com.tms.service.RideManager;
import com.tms.service.impl.RideManagerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
public class RideController {

    private User user;
    private List<Rider> riders;
    private List<Horse> horses;
    private List<Pair> pairs;
    private RideManager rideManagerService;

    @GetMapping(path = "/ride")
    public String rideHome(Model model) {
        fillHomeModel(model);
        return "ride";
    }

    @PostMapping(path = "/bet")
    public String makeBet(@RequestParam("pair") int pairNumber, @RequestParam("bet") int bet, Model model) {
        UserRideResult userRideResult = rideManagerService.bet(pairNumber, bet);
        model.addAttribute("userRideResult",userRideResult);
        return "rideResult";
    }

    @PostMapping(path = "/pair")
    public String setPair(@RequestParam("rider") int riderNumber, @RequestParam("horse") int horseNumber, Model model) {
        rideManagerService.setPair(riderNumber, horseNumber);
        fillHomeModel(model);
        return "ride";
    }

    private void fillHomeModel(Model model) {
        model.addAttribute("balance", user.getBalance());
        model.addAttribute("riders", riders);
        model.addAttribute("horses", horses);
        model.addAttribute("pairs", pairs);
    }
}
