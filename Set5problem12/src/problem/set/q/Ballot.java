package problem.set.q;

/**
 * The Class Ballot. The format asked in Problem2
 */
public class Ballot {

	/** The from kingdom. */
	private String fromKingdom;
	
	/** The to kingdom. */
	private String toKingdom;
	
	/** The message. */
	private String message;

	/**
	 * Gets the from kingdom.
	 *
	 * @return the from kingdom
	 */
	public String getFromKingdom() {
		return fromKingdom;
	}

	/**
	 * Sets the from kingdom.
	 *
	 * @param fromKingdom the new from kingdom
	 */
	public void setFromKingdom(String fromKingdom) {
		this.fromKingdom = fromKingdom;
	}

	/**
	 * Gets the to kingdom.
	 *
	 * @return the to kingdom
	 */
	public String getToKingdom() {
		return toKingdom;
	}

	/**
	 * Sets the to kingdom.
	 *
	 * @param toKingdom the new to kingdom
	 */
	public void setToKingdom(String toKingdom) {
		this.toKingdom = toKingdom;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Ballot [fromKingdom=" + fromKingdom + ", toKingdom=" + toKingdom + ", message=" + message + "]";
	}

}
