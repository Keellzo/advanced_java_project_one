package com.kellzo.clock;

import com.kellzo.enums.State;


public class ClockView extends Clock {
    private String in = "";

    public void clockView() {
        while (!in.equals("q")) {
            displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("-----------------------------");
        setState(State.TIME);
        System.out.println("State: " + getState());
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
        if (getState() == State.TIME) {
            setState(State.CHANGE_TIME);
            System.out.println("State: " + getState());
            readyToSet();
            System.out.println("1. Go to Display Time \n" +
                    "q. Quit");
            in = scannerHelper.readString();
            if (in.equals("1")) {
                setState(State.TIME);
            } else if (in.equals("q")) {
                System.out.println("Goodbye!");
            }
        } else {
            System.out.println("Please view the time first.");
        }
    }


    private void handleDate() {
        setState(State.DATE);
        while (!in.equals("q")) {
            System.out.println("-----------------------------");
            System.out.println("State: " + getState());
            set();
            System.out.println("1. Change Date \n" +
                    "2. View Time \n" +
                    "q. Quit");
            System.out.println("-----------------------------");
            in = scannerHelper.readString();

            if (in.equals("1")) {
                setState(State.CHANGE_DATE);
                System.out.println("State: " + getState());
                readyToSet();
                System.out.println("1. Go to Display Date \n" +
                        "q. Quit");
                in = scannerHelper.readString();
                if (in.equals("1")) {
                    setState(State.DATE);
                }
            } else if (in.equals("2")) {
                setState(State.TIME);
                break;
            } else if (in.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
