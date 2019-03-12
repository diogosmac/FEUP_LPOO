package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    public List<Integer> listHelper() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        return list;
    }

    public List<Integer> expectedHelper() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        return list;
    }

    class StubListDeduplicate implements IListSorter {
        @Override
        public List<Integer> sort() {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(2);
            list.add(4);
            list.add(5);
            return list;
        }
    }

    @Test
    public void deduplicate() {
        List<Integer> list = listHelper();

        List<Integer> expected = expectedHelper();

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubListDeduplicate());

        assertEquals(expected, distinct);

        // -----------------------------------------------------------------

        List<Integer> sorted = new ArrayList<>();
        Collections.addAll(sorted, 1, 2, 2, 4, 5);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        List<Integer> distinctMockito = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinctMockito);
    }

    class StubListDeduplicateAlt implements IListSorter {
        @Override
        public List<Integer> sort() {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(2);
            list.add(4);
            return list;
        }
    }

    @Test
    public void deduplicateAlt() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubListDeduplicateAlt());

        assertEquals(expected, distinct);

        // -----------------------------------------------------------------

        List<Integer> sorted = new ArrayList<>();
        Collections.addAll(sorted, 1, 2, 4);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        List<Integer> distinctMockito = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinctMockito);

    }
}