package test;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import problem.set.q.Problem2;

public class TestProblem2 {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	private String expectedOutput;
	@Before
	public void setUp() {
		System.setOut(new PrintStream(out));
		expectedOutput = "Who is the ruler of Southeros?\r\n" + 
				"Ouput: None\r\n" + 
				"Allies of Ruler?\r\n" + 
				"Ouput: None\r\n" + 
				"Enter the kingdoms competing to be the ruler:\r\n" + 
				"Input: " + 
				"Who is the ruler of Southeros?\r\n" + 
				"Ouput: None\r\n" + 
				"Allies of Ruler?\r\n" + 
				"Ouput: None\r\n";
	}
	
	@After
	public void resetStreams() {
		System.setOut(System.out);
	}
	
	/**
	 * Test: Success Case when the input are correct.
	 */
	@Test
	public void CorrectInput_Success() {
		systemInMock.provideLines("Land Air");
		String args[] = { "" };
		Problem2.main(args);
		Assert.assertTrue(out.toString().contains("Input: Results after round 1 ballot count"));
	}
	
	/**
	 * Test: Failure Case when input is empty.
	 */
	@Test
	public void EmptyInput_Failure() {
		systemInMock.provideLines("");
		String args[] = { "" };
		Problem2.main(args);
		Assert.assertEquals(expectedOutput,out.toString());
	}
	
	/**
	 * Test: Failure Case when Invalid Kingdoms are given as Input
	 */
	@Test 
	public void InvalidEmpire_Failure() {
		systemInMock.provideLines("Fiore");
		String args[] = { "" };
		Problem2.main(args);
		Assert.assertTrue(out.toString().contains("The Kingdom Fiore is not in Southeros"));
	}
}
