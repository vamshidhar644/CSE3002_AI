package Lab2;
import java.util.*;

public class MinMax {
	
	static String[] GB;
	static String Tn;
	
	static void printBoard()	{
		System.out.println("|===|===|===|");
		System.out.println("| " + GB[0] + " | "	+ GB[1] + " | " + GB[2]	+ " |");
		System.out.println("|===|===|===|");
		System.out.println("| " + GB[3] + " | "	+ GB[4] + " | " + GB[5]	+ " |");
		System.out.println("|===|===|===|");
		System.out.println("| " + GB[6] + " | "	+ GB[7] + " | " + GB[8]	+ " |");
		System.out.println("|===|===|===|");
	}
	
	static String Winner()	{
		for (int a = 0; a < 8; a++)		{
			String line = null;

			switch (a) {
			case 0:
				line = GB[0] + GB[1] + GB[2];
				break;
			case 1:
				line = GB[3] + GB[4] + GB[5];
				break;
			case 2:
				line = GB[6] + GB[7] + GB[8];
				break;
			case 3:
				line = GB[0] + GB[3] + GB[6];
				break;
			case 4:
				line = GB[1] + GB[4] + GB[7];
				break;
			case 5:
				line = GB[2] + GB[5] + GB[8];
				break;
			case 6:
				line = GB[0] + GB[4] + GB[8];
				break;
			case 7:
				line = GB[2] + GB[4] + GB[6];
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return "X";
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(GB).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}
		System.out.println(Tn + "'s turn; enter a slot number to place "	+ Tn + " in:");
		return null;
	}

	public static void main(String[] args)	{
		Scanner in = new Scanner(System.in);
		GB = new String[9];
		Tn = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) 		{
			GB[a] = String.valueOf(a + 1);
		}

		System.out.println("Tic Tac Toe.");
		printBoard();

		System.out.println("X's Turn");

		while (winner == null) {
			int numInput;
			
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"Invalid ; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid ; re-enter slot number:");
				continue;
			}
			if (GB[numInput - 1].equals(String.valueOf(numInput))) 
			{
				GB[numInput - 1] = Tn;

				if (Tn.equals("X")) {
					Tn = "O";
				}
				else {
					Tn = "X";
				}

				printBoard();
				winner = Winner();
			}
			else {
				System.out.println("Slot already taken; re-enter slot number:");
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("Draw! Play Again");
		}
		else {
			System.out.println("Congratulations! " + winner	+ "'s have won! Thanks for playing.");
		}
		
		in.close();
	}
}