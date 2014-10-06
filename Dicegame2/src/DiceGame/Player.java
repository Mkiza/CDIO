package DiceGame;
import java.util.Scanner;

public class Player extends Dice {

	int lose = 0;
	int go = 0;
	int score = 0;
	int totalScore, prevScore;
	int firstDice1, firstDice2, lastDice1, lastDice2;
	boolean won;

	public void startGame() {

		if (!won) {
			getPrevScore();
			// Store gamle kast
			storeData2();
			
			// Lav et nyt kast
			rollDice();
			
			// set Score til at vær sum af de to nye
			storeData1();

			// Score bliver opdateret med de nye kast.
			setScore();

			// printer alle data ud
			print();

			// checker terningerne mht. reglerne
			checkThrow();

		}
	}

	public void print() {

		System.out.println("Terning 1: " + dice1);
		System.out.println("Terning 2: " + dice2);

		// print af totalScore
		System.out.println("Score " + setTotalScore());

		// Check til om den gemmer gamle kast

		System.out.println("Dette kast: " + firstDice1 + " " + firstDice2);
		System.out.println("Sidste kast: " + lastDice1 + " " + lastDice2);
	}

	public void checkThrow() {
	// Ændret af Christoffer / slet evt.
	//	if (firstDice1 == firstDice2 && lastDice1 > 0 && lastDice1 == lastDice2
	//			&& lastDice2 > 0 && lastDice1 == lastDice2) {
	//		go = 1;
	//		gameWon();
	//	}

		if ( firstDice1 == 6 && firstDice2 == 6 && lastDice1 == 6 && lastDice2 == 6) {
			go = 1;
			gameWon();
		}
		if (prevScore >= 40){
			
			if (firstDice1 == firstDice2){
				go = 1;
				gameWon();
			}
		}

// Ændret af Christoffer / slet evt.		
//		if (firstDice1 > 1 && firstDice1 == firstDice2 && firstDice2 > 1
//				&& firstDice2 == firstDice1 && totalScore >= 40) {
//			go = 1;
//			gameWon();
//		}

		if (firstDice1 == firstDice2 && !won) {

			if (firstDice1 == 1 && firstDice2 == 1) {

				losePoint();
				setTotalScore();
				System.out.println("Øv du mister alle dine point og din score er nu nulstillet");
				System.out.println("Score: " + setTotalScore());

			}

			System.out.println("Du slog to ens! Tryk ENTER for at slå igen!");

			Scanner keyboard = new Scanner(System.in);
			keyboard.nextLine();

			startGame();
		}
		
	}
	
	// Funktion til at de første kast gemmes
	public void storeData1() {

		firstDice1 = dice1;
		firstDice2 = dice2;

	}

	// Funktion til at gemme værdierne fra sidste kast
	public void storeData2() {

		lastDice1 = firstDice1;
		lastDice2 = firstDice2;

	}

	// Set score til at være summen af terningernes øjne + tjekker om du har
	public void setScore() {
		score += dice1 + dice2;

	}

	
	public int setTotalScore() {

		if (lose == 0)
			totalScore = score;

		if (totalScore >= 40 && lose == 0)
			totalScore = 40;

		if (lose == 1) {
			score = 0;
			totalScore = 0;
			lose = 0;
		}

		return totalScore;
	}

	public int getPrevScore() {
		prevScore = score;
		return prevScore;
	}
	
	public void losePoint() {

		lose = 1;

	}

	public boolean gameWon() {

		if (go == 1)
			won = true;

		return won;
	}
}
