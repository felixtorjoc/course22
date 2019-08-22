package com.example.lambda;

import java.util.ArrayList;
import java.util.List;

public class MMAFighterMain {
    public static void main(String[] args) {

        List<MMAFighter> mmaFighters = new ArrayList<>();
        mmaFighters.add(new MMAFighter("bibi", 10, 5));
        mmaFighters.add(new MMAFighter("titi", 11, 6));
        mmaFighters.add(new MMAFighter("cici", 8, 4));
        mmaFighters.add(new MMAFighter("riri tepes", 12, 5));

    MMAFighterService mmaFighterService = new MMAFighterService(mmaFighters);

        System.out.println(mmaFighterService.getWinner());

    }

}
