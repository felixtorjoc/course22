package com.example.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VacationService {

    private List<Vacation> vacations;

    public VacationService(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public long countAllVacations() {
        return vacations.stream()
                .count();
    }

    public long countAllVacationForLocation(String location) {
        return vacations.stream()
                .filter(vacation -> location.equals(vacation.getLocation()))
                .count();
    }

    public List<Vacation> getVacationsPerLocation(String location) {
        return vacations.stream()
                .filter(vacation -> location.equals(vacation.getLocation()))
                .collect(Collectors.toList());
    }

    public Vacation getCheapestVacation() {
        return vacations.stream()
                .min(Comparator.comparing(vacation -> vacation.getPrice()))
                .orElse(null);
    }

    public Vacation getSecondCheapestVacation() {
        return vacations.stream()
                .sorted(this::sortVacations)
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    public Map<Integer, List<Vacation>> getCheapestVacations() {
        int minPrice = vacations.stream()
                .mapToInt(Vacation::getPrice)
                .min()
                .orElse(0);

        return vacations.stream()
                .filter(vacation -> vacation.getPrice() == minPrice)
                .collect(Collectors.toMap(vacation -> vacation.getPrice(), vacation -> buildList(vacation), (l1, l2) -> mergeLists(l1, l2)));
    }

    public Vacation getCheapestVacationPerLocation(String location) {
        return vacations.stream()
                .filter(vacation -> location.equals(vacation.getLocation()))
                .min(Comparator.comparing(Vacation::getPrice))
                .orElse(null);
    }

    public Map<Integer, List<Vacation>> getCheapestVacationsPerLocation(String location) {
        int minPriceVacationsPerLocation = vacations.stream()
                .filter(vacation -> location.equals(vacation.getLocation()))
                .mapToInt(vacation -> vacation.getPrice())
                .min()
                .orElse(0);

        return vacations.stream()
                .filter(vacation -> location.equals(vacation.getLocation()) && vacation.getPrice() == minPriceVacationsPerLocation)
                .collect(Collectors.toMap(Vacation::getPrice,this::buildList, this::mergeLists));
    }

    private int sortVacations(Vacation v1, Vacation v2) {
        int control = 2;
        if (v1.getPrice() < v2.getPrice()) {
            control = -1;
        } else if (v1.getPrice() == v2.getPrice()) {
            control = 0;
        } else if (v1.getPrice() > v2.getPrice()) {
            control = 1;
        }
        return control;
    }

    private List<Vacation> buildList(Vacation vacation) {
        List<Vacation> list = new ArrayList<>();
        list.add(vacation);
        return list;
    }

    private List<Vacation> mergeLists(List<Vacation> l1, List<Vacation> l2) {
        List<Vacation> result = new ArrayList<>();
        result.addAll(l1);
        result.addAll(l2);
        return result;
    }
}
