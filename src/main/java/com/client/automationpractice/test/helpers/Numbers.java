package com.client.automationpractice.test.helpers;

public enum Numbers {
    ZERO_SECOND(0),
    ONE_SECOND(1),
    TWO_SECOND(2),
    THREE_SECOND(3),
    FOUR_SECOND(4),
    FIVE_SECOND(5),
    SIX_SECOND(6),
    SEVEN_SECOND(7),
    EIGHT_SECOND(8),
    NINE_SECOND(9),
    TEN_SECOND(10),
    TWENTY_SECOND(20),
    TWENTYTHREE_SECOND(23),
    THIRTY_SECOND(30),
    THOUSAND_SECOND(1000);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
