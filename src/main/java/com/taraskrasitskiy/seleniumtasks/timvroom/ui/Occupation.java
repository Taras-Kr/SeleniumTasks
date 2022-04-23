package com.taraskrasitskiy.seleniumtasks.timvroom.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Occupation {
    ASTRONAUT("astronaut", "Astronaut"),
    POLITICIAN("politician", "Politician"),
    SCIENCE_FICTION_AUTHOR("scifiauthor", "Science Fiction Author");

    @Getter
    private String value;
    @Getter
    private String text;
}
