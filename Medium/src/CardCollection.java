/*✅ Problem 2: Card Collection System (Medium Level)
Description:
Create a Java program that uses the Collection interface to collect and 
store cards. The program should assist users in:

Adding cards (Rank and Symbol)
Searching cards by symbol
Displaying all stored cards
Example Input:
Add Card
Search by Symbol
Display All Cards Enter your choice: 1 Enter Symbol (Hearts, Diamonds, etc.): 
Hearts Enter Rank (Ace, 2, King, etc.): Ace
Example Output:
Card added successfully! */

import java.util.ArrayList;
import java.util.Scanner;
public class CardCollection {
    public static void main(String[] args){
        ArrayList<Card> cards = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice: ");
            System.out.println("1. Add Card");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                addCard(cards, sc);
                break;
                case 2:
                searchCard(cards, sc);
                break;
                case 3:
                displayCards(cards);
                break;
                case 4:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
    public static void addCard(ArrayList<Card> cards, Scanner sc){
        System.out.println("Enter Symbol (Hearts, Diamonds, etc.): ");
        String symbol = sc.nextLine();
        System.out.println("Enter Rank (Ace, 2, King, etc.): ");
        String rank = sc.nextLine();
        Card card = new Card(symbol, rank);
        cards.add(card);
        System.out.println("Card added successfully!");
    }
    public static void searchCard(ArrayList<Card> cards, Scanner sc){
        System.out.println("Enter Symbol (Hearts, Diamonds, etc.): ");
        String symbol = sc.nextLine();
        for(Card card: cards){
            if(card.getSymbol().equals(symbol)){
                System.out.println("Card found!");
                System.out.println("Symbol: " + card.getSymbol());
                System.out.println("Rank: " + card.getRank());
                return;
            }
        }
        System.out.println("Card not found!");
    }
    public static void displayCards(ArrayList<Card> cards){
        for(Card card: cards){
            System.out.println("Symbol: " + card.getSymbol());
            System.out.println("Rank: " + card.getRank());
            System.out.println();
        }
    }
}
class Card{
    private String symbol;
    private String rank;
    public Card(String symbol, String rank){
        this.symbol = symbol;
        this.rank = rank;
    }
    public String getSymbol(){
        return this.symbol;
    }
    public String getRank(){
        return this.rank;
    }
}
