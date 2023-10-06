package com.kellzo.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerHelper {
    private final Scanner scanner;
    public ScannerHelper() {
        this.scanner = new Scanner(System.in);
    }


    // Method for reading Strings, mostly for the switch cases in this case
    public String readString() {
        return scanner.next();
    }

    // Method for reading the time, parsing the input with a try/catch
    public LocalTime readTime() {
        String input = scanner.next();
        try {
            return LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please use HH:MM:SS.");
            return null;
        }
    }

    // Method for reading the time, parsing the input with a try/catch
    public LocalDate readDate() {
        String input = scanner.next();
        try {
            return LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }
}

