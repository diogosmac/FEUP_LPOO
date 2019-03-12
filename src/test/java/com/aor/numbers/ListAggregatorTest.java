package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    public List<Integer> helper() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        return list;
    }

    @Test
    public void sum() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void maxAlt() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    class StubListDistinct implements IListDeduplicator {
        @Override
        public List<Integer> deduplicate(IListSorter listSorter) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(4);
            list.add(5);
            return list;
        }
    }

    @Test
    public void distinct() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubListDistinct());

        assertEquals(4, distinct);
    }

    class StubListDistinctAlt implements IListDeduplicator {
        @Override
        public List<Integer> deduplicate(IListSorter listSorter) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(4);
            return list;
        }
    }

    @Test
    public void distinctAlt() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubListDistinctAlt());

        assertEquals(3, distinct);
    }

}
