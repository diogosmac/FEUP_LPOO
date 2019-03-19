package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ListFiltererTest {
    private List<Integer> list;

    @Before
    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(-3);
        list.add(12);
        list.add(-8);
        list.add(16);
        list.add(24);
    }

    @Test
    public void anyFilter() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(12);
        expected.add(16);
        expected.add(24);

        ListFilterer filterer = new ListFilterer(list);

        PositiveFilter posFilt = Mockito.mock(PositiveFilter.class);
        Mockito.when(posFilt.accept(1)).thenReturn(true);
        Mockito.when(posFilt.accept(-3)).thenReturn(false);
        Mockito.when(posFilt.accept(12)).thenReturn(true);
        Mockito.when(posFilt.accept(-8)).thenReturn(false);
        Mockito.when(posFilt.accept(16)).thenReturn(true);
        Mockito.when(posFilt.accept(24)).thenReturn(true);

        List<Integer> result = filterer.filter(posFilt);

        assertEquals(expected, result);
    }

    @Test
    public void filterPositive() {
        PositiveFilter posFilt = new PositiveFilter();

        assertEquals(true, posFilt.accept(2));
        assertEquals(false, posFilt.accept(-4));
        assertEquals(false, posFilt.accept(0));
    }

    @Test
    public void filterDivisible() {
        DivisibleByFilter divFilt = new DivisibleByFilter(4);

        assertEquals(true, divFilt.accept(12));
        assertEquals(false, divFilt.accept(0));
        assertEquals(true, divFilt.accept(4));
        assertEquals(true, divFilt.accept(-16));

        DivisibleByFilter divByZeroFilt = new DivisibleByFilter(0);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer rand = random.nextInt();
            assertEquals(false, divByZeroFilt.accept(rand));
        }
    }
}
