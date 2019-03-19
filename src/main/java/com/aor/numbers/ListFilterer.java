package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;


public class ListFilterer {
    private final List<Integer> list;

    public ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter) {

        List<Integer> filtered = new ArrayList<>();

        for (Integer num : this.list) {
            if (filter.accept(num))
                filtered.add(num);
        }

        return filtered;
    }

}
