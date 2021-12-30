package cimillo.kata.goosegame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Main {

	static List<String> addPlayers(Scanner gameInput, int playersNumber) {
		List<String> playerList = new ArrayList<>();
		int addedPlayers = 0;
		for (int i = 1; i < playersNumber + 1; i++) {
			boolean validPartecipant = false;
			while (!validPartecipant) {
				System.out.println("\nPlayer " + i + " enter your name:");
				String playerName = gameInput.nextLine();
				if (playerName.trim().isEmpty()) {
					System.out.println("Player " + i + " please enter a not empty name.");
				} else {
					GooseGame.checkParticipants(playerList, playerName);
					validPartecipant = addedPlayers == playerList.size() - 1 || validPartecipant;
					if (validPartecipant) {
						addedPlayers++;
						String currentPlayers = playerList.stream().collect(Collectors.joining(", "));
						System.out.println("\nPlayers: " + currentPlayers);
					} else {
						System.out.println(playerName + ": player already present\n");
					}
				}
			}
		}
		System.out.println("********************************************");
		return playerList;
	}

	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("\tWelcome to Goose Game!");
		System.out.println("****************************************");
		System.out.println("The game begins...\n");
		System.out.println("Press Enter to continue ");
		try (Scanner gameInput = new Scanner(System.in)) {
			gameInput.nextLine();
			// Read number of players
			int playersNumber = 0;
			while (playersNumber == 0) {
				System.out.println("How many players? ");
				try {
					playersNumber = gameInput.nextInt();
				} catch (InputMismatchException e) {
					gameInput.nextLine();
					System.out.println("Insert a valid number");
				}
			}
			gameInput.nextLine();
			List<String> playersNames = addPlayers(gameInput, playersNumber);
			GooseGame.letsPlay(playersNames);

		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.exit(0);

	}

}
