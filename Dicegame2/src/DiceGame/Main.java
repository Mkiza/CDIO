package DiceGame;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
//***********************************************************************************************************************************
//- Har �ndret noget af teksten, bl.a. "enter" til "ENTER", og andre sm�ting.
//- Har ogs� �ndret nogle varibel navne for at v�re konsekvent, eksempelvis fra "totalscore" til "totalScore" i Player.java.
//- Har �ndret s� Hvis man f�r 2 ens og med det nye score kommer op p� 40, s� vinder man ikke, men at f�rst turen efter man er
//oppe p� 40 kan man vinde ved at sl� 2 ens.
//- Har �ndret at hvis man f�r 2 6'ere 2 gange i tr�k vinder man, i stedet for at hvis man f�r 2 vilk�rlige ens 2 gange i tr�k,
//s� vinder man. Grundet det er d�t et af kravene er. Som er lavet med en prevScore integer, for at holde �je med den forrige score.
//- Alt i alt ser det skide godt ud! MVH. Christoffer :)
//***********************************************************************************************************************************
		
		// Opretter to objekter af klassen Player
		Player player1 = new Player();
		Player player2 = new Player();

		// Variabel til at tjekke om player 1 har spillet
		boolean p1hasp = false;

		System.out.println("Tryk ENTER for at starte");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();

		while (keyboard != null && !player1.gameWon()) {

			System.out.println();
			System.out.println("Spiller 1 Kaster. Tryk ENTER for at kaste");
			keyboard.nextLine();

			if (!p1hasp) {
				System.out.println("Spiller 1 Tur");
				player1.startGame();
				if (player1.gameWon())
					break;
				else
					System.out.println();
				System.out.println("Spiller 2 Kaster. Tryk ENTER for at kaste");

				keyboard.nextLine();

				p1hasp = true;
			}
			if (p1hasp && !player1.gameWon()) {
				System.out.println("Spiller 2 Tur");
				player2.startGame();
				p1hasp = false;
				if (player2.gameWon())
					break;
			}

		}
		keyboard.close();
		System.out.println("Du har vundet!");

	}
}
