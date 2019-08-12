package main;

import java.util.Scanner;
/*
Card game developed by Hirak as assigned by Target.
 */
public class CardGameMenu {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TARGET CARD GAME ");
        System.out.println("***** Please choose from the options below ****** ");
        System.out.println("1. Start Game ");
        System.out.println("2. Shuffle cards ");
        System.out.println("3. Distribute cards ");
        System.out.println("4. Exit ");

        int value ;
        // switch case for the game menu
        while(true) {
            value= sc.nextInt();
            switch (value) {
                case 1:
                    System.out.println("Initialising cards.......");
                    CardGameEngine.initialiseCards();
                    CardGameEngine.showCards();
                    break;
                case 2:
                    if(CardGameEngine.cards!=null) {
                        System.out.println("Shuffling cards..........");
                        CardGameEngine.shuffleCards();
                        CardGameEngine.showCards();
                    }else
                        System.out.println("Deck is empty. Please initialise the cards.");
                    break;
                case 3:
                    if(CardGameEngine.cards!=null) {
                        System.out.println("Distributing cards..........");
                        CardGameEngine.play();
                    }else
                        System.out.println("Deck is empty. Please initialise the cards.");
                    break;
                case 4:
                    System.out.println("Thank you for playing TARGET CARD GAME. \nWe hope you liked the game !!! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option from the Menu");
            }
        }
    }
}
