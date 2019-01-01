package com.taraB.test;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.taraB.Problem1;

// TODO: Auto-generated Javadoc
/**
 * The Class TestProblem1. Here we have used the System.rules
 * (https://stefanbirkner.github.io/system-rules/) For using the scanner inputs.
 */
public class TestProblem1 {

	/** The out. */
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	/** The system in mock. */
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	/** The incorrect input new battalion. */
	private String expectedCorrectInputSuccess, expectedCorrectInputSuccessLose, incorrectInputNoSpace,
			incorrectInputMoreUnits, incorrectInputNewBattalion;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		expectedCorrectInputSuccess = "Input: Falicornia attacks with "
				+ "Lengaburu deploys 52 H, 50 E, 10 AT, 3 SG and wins\r\n";
		expectedCorrectInputSuccessLose = "Input: Falicornia attacks with "
				+ "Lengaburu deploys 100 H, 38 E, 10 AT, 5 SG and loses\r\n";
		incorrectInputNoSpace = "Input: Falicornia attacks with "
				+ "Input Format must be no of units then empty space followed by agreed symbol\r\n";
		incorrectInputMoreUnits = "Input: Falicornia attacks with " + "Falicornia cannot leave itself unprotected\r\n";
		incorrectInputNewBattalion = "Input: Falicornia attacks with "
				+ "Falicornia attacked with new Regiment. That is not allowed!!!\r\n"
				+ "Regiment A are forbidden in this War\r\n";
		System.setOut(new PrintStream(out));
	}

	/**
	 * Reset streams.
	 */
	@After
	public void resetStreams() {
		System.setOut(System.out);
	}

	/**
	 * Correct input success win.
	 */
	@Test
	public void Correct_Input_Success_Win() {
		systemInMock.provideLines("100 H, 101 E, 20 AT, 5 SG");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(expectedCorrectInputSuccess, actualOutput);
	}

	/**
	 * Correct input success lose.
	 */
	@Test
	public void Correct_Input_Success_Lose() {
		systemInMock.provideLines("250 H, 50 E, 20 AT, 15 SG");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(expectedCorrectInputSuccessLose, actualOutput);
	}

	/**
	 * In correct input failure no space.
	 */
	@Test
	public void InCorrect_Input_Failure_No_Space() {
		systemInMock.provideLines("250H, 50E, 20 AT, 15 SG");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(incorrectInputNoSpace, actualOutput);
	}

	/**
	 * In correct input failure more units.
	 */
	@Test
	public void InCorrect_Input_Failure_More_Units() {
		systemInMock.provideLines("400 H, 50 E, 20 AT, 15 SG");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(incorrectInputMoreUnits, actualOutput);
	}

	/**
	 * In correct input failure new battalion.
	 */
	@Test
	public void InCorrect_Input_Failure_New_Battalion() {
		systemInMock.provideLines("400 H, 50 E, 20 AT, 15 SG, 2 A");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(incorrectInputNewBattalion, actualOutput);
	}
}
