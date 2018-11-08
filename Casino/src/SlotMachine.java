/*
 * To change this li    cense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ricjo
 */
public class SlotMachine {

    private int tokenCredit;
    private Random generator;
    private static int houseCredit = 0;

    public SlotMachine() {
        this.generator = new Random();
        this.tokenCredit = 0;
    }

    //method 1
    public void topupTokens(int tokens) {
        this.tokenCredit = tokens;
    }

    //method 2 will return token credit.
    public int cashoutTokens() {
        return this.tokenCredit = 0;
    }

    //method 3 will be the default pullLever method
    public void pullLever() {
        pullLever(1);
    }

    //method 4 will be the pullLever method that takes in a variable.
    public void pullLever(int tokenInput) {
        generator = new Random();
        int num1, num2, num3;

        num1 = generator.nextInt(10);
        num2 = generator.nextInt(10);
        num3 = generator.nextInt(10);

        if (this.tokenCredit < tokenInput) {
            System.out.println("You do not have enough tokens. Please top-up.");
        } else {

            // Subtracting token input from token credits
            this.tokenCredit = this.tokenCredit - tokenInput;
            System.out.println("Rolled: " + num1 + " - " + num2 + " - " + num3);

            // Case 1
            if ((num1 == 0) && (num2 == 0) && (num3 == 0)) {
                this.tokenCredit = tokenInput * 500;
                System.out.println("Super Jackpot! Amount won: " + this.tokenCredit);
                System.out.println("Your current balance is: " + getTokenBalance());

            }

            // Case 2
            if ((num1 > 0) && (num2 > 0) && (num3 > 0)) {
                if ((num1 == num2) && (num1 == num3)) {
                    this.tokenCredit = tokenInput * 50;
                    System.out.println("Jackpot! Amount won: " + this.tokenCredit);
                    System.out.println("Your current balance is: " + getTokenBalance());

                }
            }

            // Case 3
            if (((num1 == num2) && (num3 != num2) && (num3 != num1))
                    || ((num1 == num3) && (num2 != num1) && (num2 != num3))
                    || ((num2 == num3) && (num1 != num2) && (num1 != num3))) {
                this.tokenCredit = this.tokenCredit + tokenInput;
                System.out.println("Free spin! Your bet has been refunded." + "\n" + "Your current balance is: " + this.tokenCredit);
            }

            // Case 4
            if ((num1 != num2) && (num2 != num3) && (num3 != num1)) {
                System.out.println("Bad luck, try again!");
                System.out.println("Your current balance is: " + getTokenBalance());

            }
        }
    }

    //method 5 will return token balance.
    public int getTokenBalance() {
        return this.tokenCredit;
    }

    //method 6 will return house credit.
    public static int getHouseCredit() {
        return houseCredit;
    }

    // main method will ask user to input how much tokens to gamble
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tokensToGamble;
        int currentSlotMachine = 0;
        int smNum = 1;
        int number;
        char answer;
        boolean isPlaying = true;
        SlotMachine[] sm = new SlotMachine[3];

        for (int i = 0; i < 3; i++) {
            sm[i] = new SlotMachine();
        }

        while (isPlaying) {
            System.out.println("\n Welcome to AUT casino!\n You are currently in slot machine " + smNum + " What would you like "
                    + "to do? \n\n 1 - Pull lever"
                    + " \n 2 - Top-up credit \n 3 - Check credit balance \n 4 - "
                    + "Cash out \n 5 - Switch slot machines \n 6 - Check house credit");
            answer = input.next().charAt(0);

            // case 1 - Pull lever
            if ((answer == '1') && (sm[currentSlotMachine].getTokenBalance() != 0)) {
                System.out.println("How much would you like to gamble?");
                tokensToGamble = input.nextInt();
                sm[currentSlotMachine].pullLever(tokensToGamble);
            } else if ((answer == '1') && (sm[currentSlotMachine].getTokenBalance() == 0)) {
                System.out.println("Not enough tokens. Please top-up.");
            }

            // case 2 - Top up machine
            if ((answer == '2')) {
                System.out.println("How much would you like to top-up?");
                tokensToGamble = input.nextInt();
                if (tokensToGamble < 0) {
                    System.out.println("Invalid amount");
                } else {
                    sm[currentSlotMachine].topupTokens(tokensToGamble);
                    System.out.println("Your current balance is: " + sm[currentSlotMachine].getTokenBalance());

                    int totalHouseCredit = 0;
                    for (int i = 0; i < 3; i++) {
                        totalHouseCredit = totalHouseCredit + sm[i].getTokenBalance();
                    }
                    houseCredit = totalHouseCredit;
                }
            }

            // case 3 - Check balance of current slot machine
            if ((answer == '3')) {
                System.out.println("Your current balance is: " + sm[currentSlotMachine].getTokenBalance());
            }

            // case 4 - Cash out
            if ((answer == '4')) {
                System.out.println(sm[currentSlotMachine].getTokenBalance() + " token(s) have been "
                        + "cashed out \nYour current balance is: " + sm[currentSlotMachine].cashoutTokens()
                        + "\nThank you for playing!");
                break;
            }

            // case 5 - Swap slot machines
            if ((answer == '5')) {
                System.out.println("You are currently in slot machine " + smNum + "\nEnter: \n1 - slot machine 1 \n2 - slot machine 2 \n3 - slot machine 3");
                number = input.nextInt();

                if (number == smNum) {
                    System.out.println("You are currently in that slot machine,"
                            + " please choose a different one.");
                } else if (number > 3) {
                    System.out.println("Please choose between range 1 and 3.");
                } else {
                    if (number == 1) {
                        currentSlotMachine = 0;
                        smNum = 1;
                    } else if (number == 2) {
                        currentSlotMachine = 1;
                        smNum = 2;
                    } else if (number == 3) {
                        currentSlotMachine = 2;
                        smNum = 3;
                    }
                }
            }

            // case 6 - Show house credit
            if ((answer == '6')) {
                System.out.println("Your house credit balance is: " + getHouseCredit());
            }

            // Update house credit after each condition. Mainly for when jackpots has been won.
            int totalHouseCredit = 0;
            for (int i = 0; i < 3; i++) {
                totalHouseCredit = totalHouseCredit + sm[i].getTokenBalance();
            }
            houseCredit = totalHouseCredit;
        }
    }
}
