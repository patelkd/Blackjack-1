import java.util.Scanner;

public class Blackjack {

        private int player;
        private int dealer;
        private int drawn = deck[rand];

                
    public scorePlayer() {
        for (int i=0; i<52; i++) {
            
            if (value[i] < 21) {
                player.hit();
                newValue + value[i] = value[i];
            }
            else if (value[i]==21) {
                System.out.println("You win!");
            }

            else if (value[i] > 21) {
                break;
            }

        }
    }

    public void hit() {
        int newValue = 0;
        deck[rand] = newValue;
    }
}

}



