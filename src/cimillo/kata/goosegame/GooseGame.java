package cimillo.kata.goosegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Giovanna
 *
 *         Main class for the "Goose Game"
 */
public class GooseGame {
	
	/**
	 * Board on which the game takes place
	 */
	private final Board board = new Board(this);

	private final List<Player> playersList = new ArrayList<>();

	private boolean thereIsAWinner = false;

	/**
	 * @param participantsName TODO @return true if the player name is unique in the
	 *                         current state of the game
	 */
	public static List<String> checkParticipants(List<String> participatsList, String participantsName) {
		boolean existPlayer = participatsList.stream().anyMatch(p -> p.equalsIgnoreCase(participantsName));
		if (!existPlayer) {
			participatsList.add(participantsName);
		}
		return participatsList;
	}

	/**
	 * Access point to start a game
	 *
	 * @param playersNumber
	 * @throws InterruptedException
	 *
	 */
	public static GooseGame letsPlay(List<String> playersNames) throws InterruptedException {
		GooseGame game = new GooseGame();
		playersNames.forEach(p -> game.playersList.add(new Player(p)));

		game.makesMoves(game.playersList.size());
		return game;
	}

	public List<Player> getPlayersList() {
		return playersList;
	}

	public boolean isThereAWinner() {
		return thereIsAWinner;
	}

	private void makesMoves(int playersNumber) throws InterruptedException {
		int i = 0;

		while (!thereIsAWinner && i <= playersNumber) {
			Player currentPlayer = playersList.get(i);
			System.out.println("\n********************************************");
			System.out.println("\t" + currentPlayer.getName() + " thows dice...");

//			Player throws dice
			int[] score = throwDice();
			System.out.println(
					"* " + currentPlayer.getName() + " * gets " + score[0] + ", " + score[1] + " at the dice!");

//			Move player on the board
			String msgFromBoard = board.movePlayer(currentPlayer, score[0] + score[1]);
			System.out.println(msgFromBoard);

			System.out.println("********************************************\n");
			i = i == playersNumber - 1 ? 0 : i + 1;
		}
	}

	public void setThereIsAWinner(Boolean thereIsAWinner) {
		this.thereIsAWinner = thereIsAWinner;
	}

	private int[] throwDice() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		int dice[] = new int[2];
		int minScore = 1;
		int maxScore = 6;
		dice[0] = new Random().nextInt(maxScore - minScore) + minScore;
		dice[1] = new Random().nextInt(maxScore - minScore) + minScore;
		return dice;
	}

}
