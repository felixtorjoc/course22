package com.example.lambda;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class VacationMain {
    public static void main(String[] args) {

        List<Vacation> vacations = new ArrayList<>();

        vacations.add(new Vacation("arieseni",1000, 6));
        vacations.add(new Vacation("stana",1400, 7));
        vacations.add(new Vacation("busteni",1000, 8));
        vacations.add(new Vacation("sinaia",1500, 7));
        vacations.add(new Vacation("astileu",1000, 5));
        vacations.add(new Vacation("arieseni",1000, 7));
        vacations.add(new Vacation("arieseni",1300, 7));

        VacationService vacationService = new VacationService(vacations);


        out.println(vacationService.countAllVacations());
        out.println(vacationService.countAllVacationForLocation("arieseni"));
        out.println("Vacations per location: ");
        out.println(vacationService.getVacationsPerLocation("arieseni"));
        out.println("Cheapest vacation: ");
        out.println(vacationService.getCheapestVacation());
        out.println("Cheapest vacation per location: ");
        out.println(vacationService.getCheapestVacationPerLocation("arieseni"));
        out.println("Second cheapest vacation: ");
        out.println(vacationService.getSecondCheapestVacation());
        out.println("Cheapest vacation(s): ");
        out.println(vacationService.getCheapestVacations());
        out.println("Cheapest Vacation(s) Per Location: ");
        out.println(vacationService.getCheapestVacationsPerLocation("arieseni"));


    }
}
