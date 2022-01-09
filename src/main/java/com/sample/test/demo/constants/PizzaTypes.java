package com.sample.test.demo.constants;


import java.math.BigDecimal;

public enum PizzaTypes {

    SMALL_NOTOPPINGS("Small 6 Slices - no toppings", new BigDecimal("6.75")),
    SMALL_ONETOPPINGS("Small 6 Slices - 1 topping", new BigDecimal("7.50")),
    MEDIUM_TWOTOPPINGS("Medium 8 Slices - 2 toppings", new BigDecimal("9.75")),
    LARGE_NOTOPPINGS("Large 10 Slices - no toppings", new BigDecimal("11.75")),
    LARGE_THREETOPPINGS("Large 10 Slices - 2 toppings", new BigDecimal("13.50"));

    private String displayName;
    private BigDecimal cost;

    private PizzaTypes(String displayName, BigDecimal cost) {
        this.displayName = displayName;
        this.cost = cost;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
