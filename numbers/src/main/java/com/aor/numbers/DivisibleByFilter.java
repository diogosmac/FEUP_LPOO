package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private Integer divisor;

    public DivisibleByFilter(Integer number) {
        this.divisor = number;
    }

    @Override
    public boolean accept(Integer number) {
        if (number == 0 || this.divisor == 0) return false;
        else return (number % divisor == 0);
    }
}
