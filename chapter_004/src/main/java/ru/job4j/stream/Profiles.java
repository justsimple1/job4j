package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream().map(x -> x.getAddress())
                .sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
        return addresses;
    }
}
