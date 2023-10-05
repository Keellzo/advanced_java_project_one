package com.kellzo.clock;

import com.kellzo.enums.STATE;
import com.kellzo.interfaces.Actions;
import com.kellzo.utils.ScannerHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock implements Actions {
    private LocalDate date;
    private LocalTime time;
    protected STATE state;
    private final ScannerHelper scannerHelper = new ScannerHelper();


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
    public void set() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (state == STATE.Time) {
            System.out.println("The clock is: " + getTime().format(timeFormatter));
        } else if (state == STATE.Date) {
            System.out.println("The date is: " + getDate().format(dateFormatter));
        }
    }


    @Override
    public void readyToSet() {
        if (state == STATE.ChangeTime) {
            System.out.println("Enter the new time in HH:MM:SS format:");
            LocalTime newTime = scannerHelper.readTime();
            if (newTime != null) {
                setTime(newTime);
            }
        } else if (state == STATE.ChangeDate) {
            System.out.println("Enter the new date in YYYY-MM-DD format:");
            LocalDate newDate = scannerHelper.readDate();
            if (newDate != null) {
                setDate(newDate);
            }
        }
    }

}
