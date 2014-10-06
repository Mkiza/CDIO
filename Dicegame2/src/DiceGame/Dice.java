package DiceGame;
import java.util.Random;

public class Dice {

	int dice1, dice2;

	// roll the dice
	public void rollDice() {
		Random r = new Random();
		dice1 = r.nextInt(6) + 1;
		dice2 = r.nextInt(6) + 1;

		
	}
}
