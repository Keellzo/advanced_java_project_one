package com.kellzo.clock;

import com.kellzo.enums.STATE;
import com.kellzo.interfaces.Actions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Clock implements Actions {
    private LocalDate date;
    private LocalTime time;
    protected STATE state;

    public Clock() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }

    @Override
    public void changeMode() {

    }

    @Override
    public void set() {
        if (state == STATE.Time) {
            System.out.println("The clock is: " + getTime().getHour() + ":" + String.format("%02d", getTime().getMinute()));
        } else if (state == STATE.Date) {
            System.out.println("The date is: " + getDate().getDayOfMonth() + "th " + getDate().getMonth() + " - " + getDate().getDayOfWeek());
        }
    }

    @Override
    public void readyToSet() {
        Scanner scanner = new Scanner(System.in);
        if (state == STATE.ChangeTime) {
            System.out.println("Enter the new time in HH:MM format:");
            String newTime = scanner.nextLine();
            // Parse and set the new time (you'll need to implement the parsing)
            setTime(LocalTime.parse(newTime));
        } else if (state == STATE.ChangeDate) {
            System.out.println("Enter the new date in YYYY-MM-DD format:");
            String newDate = scanner.nextLine();
            // Parse and set the new date (you'll need to implement the parsing)
            setDate(LocalDate.parse(newDate));
        }
    }
}
