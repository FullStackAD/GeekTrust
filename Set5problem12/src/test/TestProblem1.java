package test;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import problem.set.q.Commons;
import problem.set.q.Problem1;

/**
 * The Class TestProblem1. Here we have used the System.rules
 * (https://stefanbirkner.github.io/system-rules/) For using the scanner inputs.
 */
public class TestProblem1 {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	private String expectedOutputSuccess;
	private String expectedOutputEmptyInput;
	private String expectedOutputIncorrectKingdom;

	@Before
	public void setUp() {
		expectedOutputSuccess = Commons.EXPECTED_OUTPUT_SUCCESS;

		expectedOutputEmptyInput = Commons.EXPECTED_OUTPUT_EMPTY_INPUT;

		expectedOutputIncorrectKingdom = Commons.EXPECTED_OUTPUT_INCORRECT_KINGDOM;
		System.setOut(new PrintStream(out));

	}

	@After
	public void resetStreams() {
		// System.setIn(System.in);
		System.setOut(System.out);
	}

	/**
	 * Test: Success scenario when all the input are correctly provided.
	 * 
	 */
	@Test
	public void allFiveInput_Success() {
		systemInMock.provideLines("Air, /“Let’s swing the sword together/”",
				"Land, /“Die or play the tame of thrones/”", "Ice, /“Ahoy! Fight for me with men and money/”",
				"Water, /“Summer is coming/”", "Fire, /“Drag on Martin!/”");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(expectedOutputSuccess, actualOutput);
	}

	/**
	 * Test: Failure case when empty or input without expected format is provided.
	 */
	@Test
	public void EmptyInput_Failure() {
		systemInMock.provideLines("", "", "Ice, /“Ahoy! Fight for me with men and money/”",
				"Water, /“Summer is coming/”", "Fire, /“Drag on Martin!/”");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(expectedOutputEmptyInput, actualOutput);
	}

	@Test
	public void IncorrectKingdomInput_Failure() {
		String incorrectKingdom = "Fiore";
		systemInMock.provideLines("Air, /“Let’s swing the sword together/”",
				"Land, /“Die or play the tame of thrones/”", "Ice, /“Ahoy! Fight for me with men and money/”",
				"Water, /“Summer is coming/”", incorrectKingdom + ", /“Drag on Martin!/”");
		String args[] = { "" };
		Problem1.main(args);
		String actualOutput = out.toString();
		assertEquals(expectedOutputIncorrectKingdom, actualOutput);
	}
}
