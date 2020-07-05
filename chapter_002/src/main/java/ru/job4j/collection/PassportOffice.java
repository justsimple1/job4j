package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (citizens.containsKey(citizen) == false) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }
    public Citizen get(String passport) {
        Citizen citizen = null;
        for (String key : citizens.keySet()) {
            if(citizens.get(key).getPassport().equals(passport)) {
                citizen = citizens.get(key);
            }
        }
        return citizen;
    }
}