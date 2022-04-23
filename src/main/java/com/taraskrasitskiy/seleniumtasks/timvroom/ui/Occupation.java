package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

public enum Occupation {
    ASTRONAUT("astronaut", "Astronaut"),
    POLITICIAN("politician", "Politician"),
    SCIENCE_FICTION_AUTHOR("scifiauthor", "Science Fiction Author");

    private String value;
    private String text;

    private Occupation(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
