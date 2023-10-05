package com.kellzo.clock;

import com.kellzo.enums.STATE;
import com.kellzo.utils.ScannerHelper;


public class ClockView extends Clock {
    private final ScannerHelper scannerHelper = new ScannerHelper();

    private String in = "";

    public void clockView() {
        while (!in.equals("q")) {
            displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("-----------------------------");
        setState(STATE.Time);
        System.out.println("Status: " + getState());
        set();
        System.out.println("1. Change Time \n" +
                "2. View Date \n" +
                "q. Quit");
        System.out.println("-----------------------------");

        in = scannerHelper.readString();

        switch (in) {
            case "1":
                handleTime();
                break;
            case "2":
                handleDate();
                break;
            case "q":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private void handleTime() {
        if (getState() == STATE.Time) {
            setState(STATE.ChangeTime);
            System.out.println("Status: " + getState());
            readyToSet();
            System.out.println("1. Go to Display Time \n" +
                    "q. Quit");
            in = scannerHelper.readString();
            if (in.equals("1")) {
                setState(STATE.Time);
            } else if (in.equals("q")) {
                System.out.println("Goodbye!");
            }
        } else {
            System.out.println("Please view the time first.");
        }
    }


    private void handleDate() {
        setState(STATE.Date);
        while (!in.equals("q")) {
            System.out.println("-----------------------------");
            System.out.println("Status: " + getState());
            set();
            System.out.println("1. Change Date \n" +
                    "2. View Time \n" +
                    "q. Quit");
            System.out.println("-----------------------------");
            in = scannerHelper.readString();

            if (in.equals("1")) {
                setState(STATE.ChangeDate);
                System.out.println("Status: " + getState());
                readyToSet();
                System.out.println("1. Go to Display Date \n" +
                        "q. Quit");
                in = scannerHelper.readString();
                if (in.equals("1")) {
                    setState(STATE.Date);
                }
            } else if (in.equals("2")) {
                setState(STATE.Time);
                break;
            } else if (in.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
