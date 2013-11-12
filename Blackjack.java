import java.util.Scanner;

public class Blackjack {

        private int player;
        private int dealer;
        private int counter = 0;
        private Card drawn = deck[counter];


                
    public static void main(String[] args) {

        System.out.println("You got a " + drawn.name);
        player = drawn.value; 

        counter++;
        drawn = deck[counter];

        player = drawn.value + player;
        System.out.println("You got a " + drawn.name);
        System.out.println("Your score is " + player);

        System.out.println("Do you want to hit or stay?");
        Scanner reader = new Scanner (System.in);

        String yourChoice = reader.next();

        if (yourChoice.equals("hit")) {
            
            
        }

    }

    public void hit() {
        counter++;
        drawn = deck[counter];

        player = drawn.value + player;
    }
}

}






