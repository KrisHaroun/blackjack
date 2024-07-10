import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int cardNumber1 = drawRandomCard();
        int cardNumber2 = drawRandomCard();
        String cardString1 = cardString(cardNumber1);
        String cardString2 = cardString(cardNumber2);

        System.out.println("\n You get a \n" + cardString1 + "\n and a \n" + cardString2);

        int total = 0;
        if (cardNumber1 > 10) {
            cardNumber1 = 10;
        }
        if (cardNumber2 > 10) {
            cardNumber2 = 10;
        }
        total = cardNumber1 + cardNumber2;
        System.out.println("Your total is: " + total);

        cardNumber1 = drawRandomCard();
        cardNumber2 = drawRandomCard();
        cardString1 = cardString(cardNumber1);
        cardString2 = cardString(cardNumber2);

        System.out.println("The dealer shows \n" + cardString1 + "\nand has a card facing down \n");
        System.out.println("\nThe dealer's total is hidden");

        int dealerTotal = 0;
        if (cardNumber1 > 10) {
            cardNumber1 = 10;
        }
        if (cardNumber2 > 10) {
            cardNumber2 = 10;
        }
        dealerTotal = cardNumber1 + cardNumber2;

        String hitOrStay = hitOrStay();

        while (hitOrStay.equals("hit")) {
            int nextCard = drawRandomCard();
            String nextCardString = cardString(nextCard);
            if (nextCard > 10) {
                nextCard = 10;
            }
            total += nextCard;
            System.out.println("\n You get a \n" + nextCardString);
            System.out.println("Your new total is " + total);
            if (total > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
            hitOrStay = hitOrStay();
        }

        while (hitOrStay.equals("stay")) {
            System.out.println("Dealer's turn");
            System.out.println("The dealer's cards are: \n" + cardString1 + "and a\n" + cardString2);

            while(dealerTotal <= 17) {
                int nextCard = drawRandomCard();
                String nextCardString = cardString(nextCard);
                if (nextCard > 10) {
                    nextCard = 10;
                }
                dealerTotal += nextCard;
                System.out.println("The dealer got a\n" + nextCardString);
                System.out.println("Their new total is " + dealerTotal);
                if (dealerTotal > 21) {
                    System.out.println("Bust! Dealer loses");
                    System.exit(0);
                }
            }
            System.out.println("Dealer's turn has ended");
            break;
        }

        if (total > dealerTotal) {
            System.out.println("Player wins!");
        }  else if (dealerTotal > total) {
            System.out.println("Dealer wins!");
        }
    
         scan.close();

    }

    /**
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */

     public static int drawRandomCard() {
        double randomDouble = Math.random() * 13;
        randomDouble++;
        int randomInt = (int)randomDouble;
        return randomInt;
     }

    /**
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

     public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";
            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";
            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";
            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";
            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";
            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";
            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";
            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";
            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";
            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";
            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";
            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";

            default: return "This should not be needed.";
        }
     }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /**
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */

     public static String hitOrStay() {
        System.out.println("hit or stay?");
        String answer = scan.nextLine();
        while (!answer.equals("stay") && !answer.equals("hit")) {
            System.out.println("Please write 'hit' or 'stay'");
            answer = scan.nextLine();
        }
        return answer;
     }
    }

