package com.kellzo.clock;

import com.kellzo.enums.State;
import com.kellzo.interfaces.Actions;
import com.kellzo.utils.ScannerHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock implements Actions {
    private LocalDate date;
    private LocalTime time;
    private State state;
    protected ScannerHelper scannerHelper = new ScannerHelper();


    // No args constructor initializes date and time fields with values
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /*
     ** Implemented methods from Interface below
     */


    // Method for displaying time or date depending on state condition
    @Override
    public void set() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (state == State.VIEW_TIME) {
            System.out.println("The clock is: " + getTime().format(timeFormatter));
        } else if (state == State.VIEW_DATE) {
            System.out.println("The date is: " + getDate().format(dateFormatter));
        }
    }


    // Method for changing time or date depending on state condition
    @Override
    public void readyToSet() {
        if (state == State.CHANGE_TIME) {
            System.out.println("Enter the new time in HH:MM:SS format:");
            LocalTime newTime = scannerHelper.readTime();
            if (newTime != null) {
                setTime(newTime);
            }
        } else if (state == State.CHANGE_DATE) {
            System.out.println("Enter the new date in YYYY-MM-DD format:");
            LocalDate newDate = scannerHelper.readDate();
            if (newDate != null) {
                setDate(newDate);
            }
        }
    }


}