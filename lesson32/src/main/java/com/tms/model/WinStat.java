package com.tms.model;

import lombok.Data;

@Data
public class WinStat {
    private Pair winner;
    private int winBalance;
    private boolean isYouWin;
}
