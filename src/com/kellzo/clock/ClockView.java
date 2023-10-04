package com.kellzo.clock;

import com.kellzo.enums.STATE;
import java.util.Scanner;

public class ClockView extends Clock {

    public void clockView() {
        String in = "";
        Scanner input = new Scanner(System.in);

        while (!in.equals("q")) {
            System.out.println("-----------------------------");
            setState(STATE.Time);
            System.out.println("Status: " + getState());
            set();
            System.out.println("1. Change Time \n" +
                    "2. View Date \n" +
                    "q. Quit");
            System.out.println("-----------------------------");

            in = input.next();

            switch (in) {
                case "1":
                    if (getState() == STATE.Time) {
                        setState(STATE.ChangeTime);
                        System.out.println("Status: " + getState());
                        readyToSet();
                        System.out.println("1. Go to Display Time");
                        in = input.next();
                        if (in.equals("1")) {
                            setState(STATE.Time);
                        }
                    } else {
                        System.out.println("Please view the time first.");
                    }
                    break;
                case "2":
                    setState(STATE.Date);
                    while (true) {
                        System.out.println("-----------------------------");
                        System.out.println("Status: " + getState());
                        set();
                        System.out.println("1. Change Date \n" +
                                "2. View Time");
                        System.out.println("-----------------------------");
                        in = input.next();

                        if (in.equals("1")) {
                            if (getState() == STATE.Date) {
                                setState(STATE.ChangeDate);
                                System.out.println("Status: " + getState());
                                readyToSet();
                                System.out.println("1. Go to Display Date");
                                in = input.next();
                                if (in.equals("1")) {
                                    setState(STATE.Date);
                                }
                            } else {
                                System.out.println("Please view the date first.");
                            }
                        } else if (in.equals("2")) {
                            setState(STATE.Time);
                            break;
                        }
                    }
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        ClockView clockView = new ClockView();
        clockView.clockView();
    }
}
