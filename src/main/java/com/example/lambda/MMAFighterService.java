package com.example.lambda;

import java.util.List;

public class MMAFighterService {

    private List<MMAFighter> mmaFighters;

    public MMAFighterService(List<MMAFighter> mmaFighters) {
        this.mmaFighters = mmaFighters;
    }

    public MMAFighter getWinner() {
        return mmaFighters.stream()
                .reduce(this::fight)
                .orElse(null);
    }

    private MMAFighter fight(MMAFighter fighter1, MMAFighter fighter2) {
        MMAFighter mmaFighter = new MMAFighter();

        if (fighter1.getStamina() >= fighter2.getStamina()) {
            mmaFighter = fighter1;
        } else {
            if (fighter2.getStamina() > fighter1.getStamina()) {
                mmaFighter = fighter2;
            }
        }
        return mmaFighter;
    }
}