package com.taraB.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.taraB.Army;
import com.taraB.ArmyService;
import com.taraB.Falicornia;
import com.taraB.Lengaburu;
import com.taraB.ServiceException;

/**
 * The Class TestArmyService.
 */
public class TestArmyService {
	
	/** The input. */
	private String input[];
	
	/** The expected. */
	private Army expected;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

	}

	/**
	 * Test prepare falicornia army success.
	 *
	 * @throws ServiceException the service exception
	 */
	@Test
	public void Test_PrepareFalicorniaArmy_Success() throws ServiceException {
		input = new String[] { "100 H", "101 E", "20 AT", "5 SG" };
		expected = new Falicornia();
		expected.setArmouredTanks(20);
		expected.setElephants(101);
		expected.setHorses(100);
		expected.setSlingGuns(5);
		Assert.assertEquals(expected.getArmouredTanks(), ArmyService.prepareFalicorniaArmy(input).getArmouredTanks());
	}

	/**
	 * Test prepare falicornia army failure.
	 *
	 * @throws ServiceException the service exception
	 */
	@Test(expected = ServiceException.class)
	public void Test_PrepareFalicorniaArmy_Failure() throws ServiceException {
		input = new String[] { "1000 H G", "101 E", "20 AT", "5 SG" };
		ArmyService.prepareFalicorniaArmy(input).getArmouredTanks();
	}

	/**
	 * Test prepare falicornia army extra battalion failure.
	 *
	 * @throws ServiceException the service exception
	 */
	@Test(expected = ServiceException.class)
	public void Test_PrepareFalicorniaArmy_ExtraBattalion_Failure() throws ServiceException {
		input = new String[] { "100 H", "101 E", "20 AT", "5 SG", "2 A" };
		ArmyService.prepareFalicorniaArmy(input).getArmouredTanks();
	}

	/**
	 * Test prepare lengaburu army success.
	 */
	@Test
	public void Test_PrepareLengaburuArmy_Success() {
		Army falicornia = new Falicornia();
		Army lengaburu = new Lengaburu();
		falicornia.setHorses(100);
		falicornia.setElephants(101);
		falicornia.setArmouredTanks(20);
		falicornia.setSlingGuns(5);
		lengaburu.setHorses(52);
		lengaburu.setElephants(50);
		lengaburu.setArmouredTanks(10);
		lengaburu.setSlingGuns(3);
		Assert.assertEquals(lengaburu.getSlingGuns(), ArmyService.prepareLengaburuArmy(falicornia).getSlingGuns());
	}
}
