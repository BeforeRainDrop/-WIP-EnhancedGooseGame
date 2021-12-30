package cimillo.kata.goosegame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddPlayersScenarios {

	public static final int NUMBER_OF_PLAYERS = 3;

	public static final String PLAYER_1 = "Ground Control";
	public static final String PLAYER_2 = "Major Tom";
	public static final String PLAYER_3 = "David Bowie";
	public static final String CONTEXT_SEPARATOR = "********************************************";
	public static final String NEW_LINE_SEPARATOR = "\r\n";

	public static final String EXPECTED_RESULT = "\nPlayers: " + PLAYER_1 + ", " + PLAYER_2 + ", " + PLAYER_3;

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


	@Test
	void addDuplicatePlayers() {
		String players = PLAYER_1 + "\n" + PLAYER_2 + "\n" + PLAYER_2 + "\n" + PLAYER_3 + "\n";
		ByteArrayInputStream in = new ByteArrayInputStream(players.getBytes());
		try (Scanner gameInput = new Scanner(in)) {
			GooseGame game = new GooseGame(gameInput);
			game.addPlayers(NUMBER_OF_PLAYERS);
			String outputConsole = outputStreamCaptor
					.toString().replace(NEW_LINE_SEPARATOR + CONTEXT_SEPARATOR + NEW_LINE_SEPARATOR, "");
			Assert.assertEquals("\nPlayers: " + PLAYER_1 + ", " + PLAYER_2 + ", " + PLAYER_3,
					outputConsole.substring(outputConsole.lastIndexOf("\n")));
		}
	}

	@Test
	void addPlayers() {
		String players = PLAYER_1 + "\n" + PLAYER_2 + "\n" + PLAYER_3 + "\n";
		ByteArrayInputStream in = new ByteArrayInputStream(players.getBytes());
		try (Scanner gameInput = new Scanner(in)) {
			GooseGame game = new GooseGame(gameInput);
			game.addPlayers(NUMBER_OF_PLAYERS);
			String outputConsole = outputStreamCaptor
					.toString().replace(NEW_LINE_SEPARATOR + CONTEXT_SEPARATOR + NEW_LINE_SEPARATOR, "");
			Assert.assertEquals(EXPECTED_RESULT,
					outputConsole.substring(outputConsole.lastIndexOf("\n")));
		}
	}

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
}
