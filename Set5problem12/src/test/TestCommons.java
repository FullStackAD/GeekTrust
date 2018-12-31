package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import problem.set.q.Commons;
import problem.set.q.ServiceException;

public class TestCommons {
	private Map<String, String> kingdomCode;
	private List<String> expectedOutput;

	@Before
	public void setUp() {
		kingdomCode = new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(Commons.LAND, Commons.LAND_EMBLEM);
				put(Commons.WATER, Commons.WATER_EMBLEM);
				put(Commons.ICE, Commons.ICE_EMBLEM);
				put(Commons.AIR, Commons.AIR_EMBLEM);
				put(Commons.FIRE, Commons.FIRE_EMBLEM);
			}
		};
		expectedOutput = new ArrayList<>();
		expectedOutput.add("A");
		expectedOutput.add("B");
		expectedOutput.add("C D");
	}

	/**
	 * Test: Check the Kingdom Name and Emblem Mapping is correct
	 */
	@Test
	public void getKingdomCodeCheck() {
		Assert.assertEquals(kingdomCode, Commons.getKingdomCode());
	}

	/**
	 * Test: Checks the functionality of getting True or False for given Kingdom and
	 * Message This scenario is a success case hence expected output is true
	 * 
	 * @throws ServiceException the service exception
	 */
	@Test
	public void isAlliedKingdom_Success() throws ServiceException {
		Assert.assertTrue(Commons.isAlliedKingdom(Commons.AIR, "Let’s swing the sword together"));
	}

	/**
	 * Test: Checks the functionality of getting True or False for given Kingdom and
	 * Message This scenario is a failure case hence expected output is false
	 * 
	 * @throws ServiceException the service exception
	 */
	@Test
	public void isAlliedKingdom_Failure() throws ServiceException {
		Assert.assertFalse(Commons.isAlliedKingdom(Commons.AIR, "Die or play the tame of thrones”"));
	}

	/**
	 * Test: Checks the functionality of getting True or False for given Kingdom and
	 * Message This scenario is a failure case since input Kingdom is not in
	 * Southeros Here we expect an ServiceException
	 * 
	 * @throws ServiceException the service exception
	 */
	@Test(expected = ServiceException.class)
	public void isAlliedKingdom_IncorrectKingdom_Failure() throws ServiceException {
		Commons.isAlliedKingdom("Fiore", "Die or play the tame of thrones”");
	}

	/**
	 * Test: Scenario when the Kingdom is present and has its emblem mapped
	 * @throws ServiceException the service exception
	 */
	@Test
	public void getEmblem_Success() throws ServiceException {
		Assert.assertEquals(Commons.AIR_EMBLEM, Commons.getEmblem(Commons.AIR));
	}

	/**
	 * Test: Scenario when the Kingdom is not present We get back a Service
	 * Exception
	 * @throws ServiceException the service exception
	 */
	@Test(expected = ServiceException.class)
	public void getEmblem_Failure() throws ServiceException {
		Commons.getEmblem("Fiore");
	}

	/**
	 * Test: Success for String to List conversion.
	 */
	@Test
	public void splitStringToList_Success() {
		Assert.assertEquals(expectedOutput, Commons.splitStringToList("A,B,C D", Commons.COMMA));

	}
	
	/**
	 * Test: Succes for List to String conversion.
	 */
	@Test
	public void getStringFromList_Success() {
		Assert.assertEquals("A,B,C D", Commons.getStringFromList(expectedOutput,Commons.COMMA));

	}
	
	/**
	 * Test: Read from a text file success.
	 */
	@Test
	public void readMessagesFromTxt_Success() {
		Assert.assertEquals(expectedOutput, Commons.readMessagesFromTxt("test.txt", null));
	}
	
	/**
	 * Test: Read from a text file failure.
	 */
	@Test
	public void readMessagesFromTxt_Failure() {
		Assert.assertNull(Commons.readMessagesFromTxt("doesNotExist.txt", null));
	}
}
