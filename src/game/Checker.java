package game;

public class Checker {
	private static final int position[][] = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 }, { 0, 2 }, { 1, 2 }, { 2, 2 } };

	private static final int checkWin[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
			{ 2, 4, 6 } };
	
	private Checker() { }
	
	public static boolean check(char board[][], char player){
		for (int[] check : checkWin) {
			int count = 0;
			for (int i : check) {
				if (board[position[i][1]][position[i][0]] == player) {
					count++;
				}
			}
			if (count == 3) {
				return true;
			}
		}
		return false;
	}
}
