package com.taraB;

/**
 * The Class Lengaburu.
 */
public class Lengaburu extends Army {

	/**
	 * Instantiates a new lengaburu.
	 * We set the available units of each Battalion.
	 */
	public Lengaburu() {
		this.availableHorses = 100;
		this.availableElephants = 50;
		this.availableArmouredTanks = 10;
		this.availableSlingGuns = 5;
	}

	/**
	 * Calculate horses.
	 *
	 * @param falicornia the falicornia
	 */
	public void calculateHorses(Army falicornia) {
		if (falicornia.getHorses() / 2.0 < availableHorses) {
			this.horses = (int) Math.ceil(falicornia.getHorses() / 2.0);
			falicornia.setHorses(falicornia.getHorses() - this.horses * 2);
			availableHorses -= this.horses;
		} else {
			this.horses = availableHorses;
			availableHorses = 0;
			falicornia.setHorses(falicornia.getHorses() - this.horses * 2);
		}
	}

	/**
	 * Calculate elephants.
	 *
	 * @param falicornia the falicornia
	 */
	public void calculateElephants(Army falicornia) {
		if (falicornia.getElephants() / 2.0 < availableElephants) {
			this.elephants = (int) Math.ceil(falicornia.getElephants() / 2.0);
			availableElephants -= (int) Math.ceil(falicornia.getElephants() / 2.0);
			falicornia.setElephants(0);
		} else {
			this.elephants = availableElephants;
			availableElephants = 0;
			falicornia.setElephants(falicornia.getElephants() - this.elephants * 2);
		}
	}

	/**
	 * Calculate armoured tanks.
	 *
	 * @param falicornia the falicornia
	 */
	public void calculateArmouredTanks(Army falicornia) {
		if (falicornia.getArmouredTanks() / 2.0 < availableArmouredTanks) {
			this.armouredTanks = (int) Math.ceil(falicornia.getArmouredTanks() / 2.0);
		} else {
			this.armouredTanks = availableArmouredTanks;
			availableArmouredTanks = 0;
			falicornia.setArmouredTanks(falicornia.getArmouredTanks() - this.armouredTanks * 2);
		}
	}

	/**
	 * Calculate sling guns.
	 *
	 * @param falicornia the falicornia
	 */
	public void calculateSlingGuns(Army falicornia) {
		if (falicornia.getSlingGuns() / 2.0 < availableSlingGuns) {
			this.slingGuns = (int) Math.ceil(falicornia.getSlingGuns() / 2.0);
			falicornia.setSlingGuns(0);
		} else {
			this.slingGuns = availableSlingGuns;
			availableSlingGuns = 0;
			falicornia.setSlingGuns(falicornia.getSlingGuns() - this.slingGuns * 2);
		}
	}

	/**
	 * Calculate Substitute horses if required.
	 *
	 * @param falicornia the falicornia
	 */
	public void substituteHorses(Army falicornia) {
		if (falicornia.getHorses() > 0) {
			if (falicornia.getHorses() / 4.0 < availableElephants) {
				this.elephants += (int) Math.ceil(falicornia.getHorses() / 4.0);
				availableElephants -= (int) Math.ceil(falicornia.getHorses() / 4.0);
				falicornia.setHorses(0);
			} else {
				this.elephants += availableElephants;
				falicornia.setHorses(falicornia.getHorses() - availableElephants * 4);
				availableElephants = 0;
			}
		}
	}

	/**
	 * Calculate Substitute elephants if required.
	 *
	 * @param falicornia the falicornia
	 */
	public void substituteElephants(Army falicornia) {
		if (falicornia.getElephants() > 0) {
			if (falicornia.getElephants() * 2 < availableHorses) {
				availableHorses -= falicornia.getElephants() * 2;
				this.horses += falicornia.getElephants() * 2;
				falicornia.setElephants(0);
			} else {
				falicornia.setElephants(falicornia.getElephants() - availableHorses);
				this.horses += availableHorses;
				availableHorses = 0;
				if (falicornia.getElephants() > 0) {
					if (falicornia.getElephants() / 4.0 < availableArmouredTanks) {
						this.armouredTanks += (int) Math.ceil(falicornia.getElephants() / 4.0);
						availableArmouredTanks -= (int) Math.ceil(falicornia.getElephants() / 4.0);
						falicornia.setElephants(0);
					} else {
						this.armouredTanks += availableArmouredTanks;
						falicornia.setElephants(falicornia.getElephants() - availableArmouredTanks);
						availableArmouredTanks = 0;
					}
				}
			}
		}
	}
	
	/**
	 * Substitute armoured tanks.
	 *
	 * @param falicornia the falicornia
	 */
	public void substituteArmouredTanks(Army falicornia) {
		if (falicornia.getArmouredTanks() > 0) {
			if (falicornia.getArmouredTanks() < availableElephants) {
				availableElephants -= falicornia.getArmouredTanks() * 2;
				this.elephants += falicornia.getArmouredTanks() * 2;
				falicornia.setArmouredTanks(0);
			} else {
				falicornia.setArmouredTanks(falicornia.getArmouredTanks() - availableElephants);
				this.elephants += availableElephants;
				availableElephants = 0;
				if (falicornia.getArmouredTanks() > 0) {
					if (falicornia.getArmouredTanks() / 4.0 < availableSlingGuns) {
						this.slingGuns += (int) Math.ceil(falicornia.getArmouredTanks() / 4.0);
						availableSlingGuns -= (int) Math.ceil(falicornia.getArmouredTanks() / 4.0);
						falicornia.setArmouredTanks(0);
					} else {
						this.slingGuns += availableSlingGuns;
						falicornia.setArmouredTanks(falicornia.getArmouredTanks() - availableSlingGuns);
						availableSlingGuns = 0;
					}
				}
			}
		}
	}

	/**
	 * Substitute sling guns.
	 *
	 * @param falicornia the falicornia
	 */
	public void substituteSlingGuns(Army falicornia) {
		if (falicornia.getSlingGuns() > 0) {
			if (falicornia.getSlingGuns() < availableArmouredTanks) {
				this.armouredTanks += falicornia.getSlingGuns();
				availableArmouredTanks -= falicornia.getSlingGuns();
				falicornia.setSlingGuns(0);
			} else {
				this.armouredTanks += availableArmouredTanks;
				falicornia.setSlingGuns(falicornia.getSlingGuns() - availableArmouredTanks);
				availableArmouredTanks = 0;
			}
		}
	}

}
