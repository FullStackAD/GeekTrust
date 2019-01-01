package com.taraB;
/**
 * The Class Army.
 */
public abstract class Army {
	
	/** The horses. */
	Integer horses;
	
	/** The elephants. */
	Integer elephants;
	
	/** The armoured tanks. */
	Integer armouredTanks;
	
	/** The sling guns. */
	Integer slingGuns;
	
	/** The available horses. */
	Integer availableHorses;
	
	/** The available elephants. */
	Integer availableElephants;
	
	/** The available armoured tanks. */
	Integer availableArmouredTanks;
	
	/** The available sling guns. */
	Integer availableSlingGuns;

	/**
	 * Gets the horses.
	 *
	 * @return the horses
	 */
	public Integer getHorses() {
		return horses;
	}

	/**
	 * Sets the horses.
	 *
	 * @param horses the new horses
	 */
	public void setHorses(Integer horses) {
		this.horses = horses;
	}

	/**
	 * Gets the elephants.
	 *
	 * @return the elephants
	 */
	public Integer getElephants() {
		return elephants;
	}

	/**
	 * Sets the elephants.
	 *
	 * @param elephants the new elephants
	 */
	public void setElephants(Integer elephants) {
		this.elephants = elephants;
	}

	/**
	 * Gets the armoured tanks.
	 *
	 * @return the armoured tanks
	 */
	public Integer getArmouredTanks() {
		return armouredTanks;
	}

	/**
	 * Sets the armoured tanks.
	 *
	 * @param armouredTanks the new armoured tanks
	 */
	public void setArmouredTanks(Integer armouredTanks) {
		this.armouredTanks = armouredTanks;
	}

	/**
	 * Gets the sling guns.
	 *
	 * @return the sling guns
	 */
	public Integer getSlingGuns() {
		return slingGuns;
	}

	/**
	 * Sets the sling guns.
	 *
	 * @param slingGuns the new sling guns
	 */
	public void setSlingGuns(Integer slingGuns) {
		this.slingGuns = slingGuns;
	}
	
	/**
	 * Checks if the Army can attack.
	 *
	 * @return the boolean
	 */
	public Boolean canAttack() {
		if (this.horses >= this.availableHorses || this.elephants >= this.availableElephants
				|| this.armouredTanks >= this.availableArmouredTanks || this.slingGuns >= this.availableSlingGuns) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if is army wiped out.
	 * Returns true only if entire army regiments are wiped out by the enemy.
	 *
	 * @return the boolean
	 */
	public Boolean isArmyWipedOut() {
		if (this.horses > 0 || this.elephants > 0 || this.armouredTanks > 0 || this.slingGuns > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Army [horses=" + horses + ", elephants=" + elephants + ", armouredTanks=" + armouredTanks
				+ ", slingGuns=" + slingGuns + "]";
	}
}
