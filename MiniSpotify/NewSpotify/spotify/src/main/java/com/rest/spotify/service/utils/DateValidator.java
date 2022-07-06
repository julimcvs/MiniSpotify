package com.rest.spotify.service.utils;

import java.time.LocalDate;

public interface DateValidator {
    static Boolean isValidDate(LocalDate date) {
        return (date.getYear() > 1903) && date.isBefore(LocalDate.now());
    }
}
