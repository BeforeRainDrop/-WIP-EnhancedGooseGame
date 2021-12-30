package cimillo.kata.goosegame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddPlayersScenarios {

	public static final int NUMBER_OF_PLAYERS = 3;

	public static final String PLAYER_1 = "Ground Control";
	public static final String PLAYER_2 = "Major Tom";
	public static final String PLAYER_3 = "David Bowie";
	public static final String CONTEXT_SEPARATOR = "********************************************";
	public static final String NEW_LINE_SEPARATOR = "\r\n";

	public static final List<String> EXPECTED_RESULT = Collections
			.unmodifiableList(Arrays.asList(PLAYER_1, PLAYER_2, PLAYER_3));

	@Test
	void addDuplicatePlayers() {
		String players = PLAYER_1 + "\n" + PLAYER_2 + "\n" + PLAYER_2 + "\n" + PLAYER_3 + "\n";
		ByteArrayInputStream in = new ByteArrayInputStream(players.getBytes());
		try (Scanner gameInput = new Scanner(in)) {
			List<String> playersName = Main.addPlayers(gameInput, NUMBER_OF_PLAYERS);
			Assert.assertEquals(EXPECTED_RESULT, playersName);
		}
	}

	@Test
	void addPlayers() {
		String players = PLAYER_1 + "\n" + PLAYER_2 + "\n" + PLAYER_3 + "\n";
		ByteArrayInputStream in = new ByteArrayInputStream(players.getBytes());
		try (Scanner gameInput = new Scanner(in)) {
			List<String> playersName = Main.addPlayers(gameInput, NUMBER_OF_PLAYERS);
			Assert.assertEquals(EXPECTED_RESULT, playersName);
		}
	}
}
