package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                if (!Character.isUpperCase(str.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>();
            for (int num : list) {
                if (num % 2 == 0) {
                    evenValues.add(num);
                }
            }
            list.addAll(evenValues);
        };
        }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> filteredValues = new ArrayList<>();
        for (String s : values) {
            if (s.matches("^[A-Z][\\w\\s]*\\.$") && s.split("\\s+").length > 3) {
                filteredValues.add(s);
            }
        }
        return () -> filteredValues;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

            return list -> {
                Map<String, Integer> map = new HashMap<>();
                for (String s : list) {
                    map.put(s, s.length());
                }
                return map;
            };
        }


    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1.size() + list2.size());
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
