package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

public enum Occupation {
    ASTRONAUT("astronaut"),
    POLITICIAN("politician"),
    SCIENCE_FICTION_AUTHOR("scifiauthor");

    private String value;

    private Occupation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
