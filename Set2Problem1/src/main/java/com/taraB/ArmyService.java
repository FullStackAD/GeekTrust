package com.taraB;

/**
 * The Class ArmyService.
 */
public class ArmyService {

	/**
	 * Prepare falicornia army.
	 *
	 * @param input the input
	 * @return the army
	 * @throws ServiceException the service exception
	 */
	public static Army prepareFalicorniaArmy(String input[]) throws ServiceException {
		Army falicornia = new Falicornia();
		String initialOfRegiment;
		String detailOfRegiment[];
		for (int i = 0; i < input.length; i++) {
			detailOfRegiment = input[i].split(" ");
			if (detailOfRegiment.length != 2) {
				throw new ServiceException("Input Format must be no of units then empty space followed by agreed symbol");
			}
			initialOfRegiment = detailOfRegiment[1].toUpperCase();
			switch (initialOfRegiment) {
			case "H":
				falicornia.setHorses(Integer.parseInt(detailOfRegiment[0]));
				break;
			case "E":
				falicornia.setElephants(Integer.parseInt(detailOfRegiment[0]));
				break;
			case "AT":
				falicornia.setArmouredTanks(Integer.parseInt(detailOfRegiment[0]));
				break;
			case "SG":
				falicornia.setSlingGuns(Integer.parseInt(detailOfRegiment[0]));
				break;
			default:
				throw new ServiceException("Regiment " + initialOfRegiment + " are forbidden in this War");
			}
		}
		return falicornia;
	}

	/**
	 * Prepare lengaburu army.
	 *
	 * @param falicornia the falicornia
	 * @return the army
	 */
	public static Army prepareLengaburuArmy(Army falicornia) {
		Lengaburu lengaburu = new Lengaburu();
		lengaburu.calculateHorses(falicornia);
		lengaburu.calculateElephants(falicornia);
		lengaburu.calculateArmouredTanks(falicornia);
		lengaburu.calculateSlingGuns(falicornia);
		lengaburu.substituteHorses(falicornia);
		lengaburu.substituteElephants(falicornia);
		lengaburu.substituteArmouredTanks(falicornia);
		lengaburu.substituteSlingGuns(falicornia);
		return lengaburu;
	}
}
