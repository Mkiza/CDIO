package DiceGame;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
//***********************************************************************************************************************************
//- Har ændret noget af teksten, bl.a. "enter" til "ENTER", og andre småting.
//- Har også ændret nogle varibel navne for at være konsekvent, eksempelvis fra "totalscore" til "totalScore" i Player.java.
//- Har ændret så Hvis man får 2 ens og med det nye score kommer op på 40, så vinder man ikke, men at først turen efter man er
//oppe på 40 kan man vinde ved at slå 2 ens.
//- Har ændret at hvis man får 2 6'ere 2 gange i træk vinder man, i stedet for at hvis man får 2 vilkårlige ens 2 gange i træk,
//så vinder man. Grundet det er dét et af kravene er. Som er lavet med en prevScore integer, for at holde øje med den forrige score.
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
