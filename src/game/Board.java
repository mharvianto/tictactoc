package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
	public static final char SPACE = ' ';
	public static final char PLAYERS[] = new char[] { 'X', 'O' };

	private int turnCount = 0;
	private char board[][] = null;

	public Board() {
		init();
		loop();
	}

	private void loop() {
		Scanner sc = new Scanner(System.in);
		do {
			printBoard();
			int x, y;
			do {
				System.out.println("Player " + PLAYERS[getTurn()] + " turn");
				try{
					System.out.print("X position: ");
					x = sc.nextInt();
				}catch(InputMismatchException ex){
					x = -1;
				}
				sc.nextLine();
				System.out.print("Y position: ");
				y = sc.nextInt();
			} while (board[y - 1][x - 1] != SPACE);
			board[y - 1][x - 1] = PLAYERS[getTurn()];
			
			if (Checker.check(board, PLAYERS[getTurn()])) {
				System.out.println("Player " + PLAYERS[getTurn()] + " win!!");
				break;
			} else {
				turnCount++;
			}
		} while (turnCount < 9);
		sc.close();
	}
	
	private int getTurn(){
		return turnCount % 2;
	}

	private void init() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = SPACE;
			}
		}
	}

	private void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println("+-+-+-+");
			for (int j = 0; j < 3; j++) {
				System.out.print("|" + board[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("+-+-+-+");
	}
}
