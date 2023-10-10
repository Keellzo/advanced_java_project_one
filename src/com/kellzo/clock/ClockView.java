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

    // First menu that sets VIEW_TIME state and print the correct state and current time
    // and giving options to change time, print date, change date or quit
    private void displayMenu() {
        System.out.println("-----------------------------");
        setState(State.VIEW_TIME);
        System.out.println("State: " + getState());
        set();
        System.out.println("1. Change Time \n" +
                "2. View Date \n" +
                "3. Change date \n" +
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
            case "3":
                System.out.println("Wrong state, you need to go view date state");
                break;
            case "q":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid state. Try again");
        }
    }

    // Method for setting CHANGE_TIME state and then using readyToSet method for changing time.
    // Then going back to VIEW_TIME state
    private void handleTime() {
        if (getState() == State.VIEW_TIME) {
            setState(State.CHANGE_TIME);
            System.out.println("State: " + getState());
            readyToSet();
            setState(State.VIEW_TIME);
        } else {
            System.out.println("Invalid.");
        }
    }

    // Method for printing date, first setting state VIEW_DATE and then gives option
    // Change the date, change the time or view time
    // When changing date you go back to VIEW_DATE state
    private void handleDate() {
        setState(State.VIEW_DATE);
        while (!in.equals("q")) {
            System.out.println("-----------------------------");
            System.out.println("State: " + getState());
            set();
            System.out.println("1. Change Date \n" +
                    "2. View Time \n" +
                    "3. Change Time \n" +
                    "q. Quit");
            System.out.println("-----------------------------");
            in = scannerHelper.readString();

            if (in.equals("1")) {
                setState(State.CHANGE_DATE);
                System.out.println("State: " + getState());
                readyToSet();
                setState(State.VIEW_DATE);
            } else if (in.equals("2")) {
                setState(State.VIEW_TIME);
                break;
            } else if (in.equals("3")) {
                System.out.println("Wrong state, you need to go view time state");
            } else if (in.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}