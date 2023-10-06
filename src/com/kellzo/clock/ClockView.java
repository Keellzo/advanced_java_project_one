package com.kellzo.clock;

import com.kellzo.enums.State;


public class ClockView extends Clock {
    private String in = "";

    // Initialize clockView for main method
    public void clockView() {
        while (!in.equals("q")) {
            displayMenu();
        }
    }

    // First menu that sets and print TIME state and the time right now with set method
    // and giving options to change time, print date right now or quit
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

    // Method for changing time,setting CHANGE_TIME state and then using readyToSet method for changing time.
    // Then giving two options to either display the time or quit the program
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


    // Method for handling date, setting DATE state, prints the state, prints the date and then gives option
    // Change the date or view time
    // When changing date you have two options, either view date or end the program
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