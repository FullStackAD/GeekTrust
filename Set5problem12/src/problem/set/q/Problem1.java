/**
 * problem 1: A golden crown
 * There is no ruler in the universe of Southeros and pandemonium reigns. Shan, the gorilla king of the Space kingdom
 * wants to rule all Six Kingdoms in the universe of Southeros. He needs the support of 3 more kingdoms to be the ruler.
 * Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.
 * LAND emblem - Panda, WATER emblem - Octopus, ICE emblem - Mammoth, AIR emblem - Owl, FIRE emblem - Dragon.
 * Your coding challenge is to have King Shan send secret message to each kingdom and win them over.
 * Once he wins 3 more kingdoms, he is the ruler! The secret message needs to contain the letters of the animal in their
 * emblem. For example, secret message to the Land kingdom (emblem: Panda) needs to have the letter 'p','n','d' atleast
 * once and 'a' at-least twice. If he sends "a1d22n333a4444p" to the Land kingdom, he will win them over.
 */
package problem.set.q;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Class Problem1.
 */
public class Problem1 {

	/**
	 * We input messages sent by Shan. Then whether he has won Southeros is fetched
	 * as Output
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			Commons.initialMessage();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Input Messages to kingdoms from King Shan:");
			List<String> inputMessages = new ArrayList<String>();
			for (int i = 0; i < 5; i++) {
				System.out.print(Commons.INPUT);
				inputMessages.add(scanner.nextLine());
				System.out.println();
			}
			scanner.close();

			List<String> allies = getAllies(inputMessages);

			if (allies.size() >= 3) {
				System.out.println(Commons.RULEROFSOUTHEROS + "\r\n" + Commons.OUTPUT + Commons.SHAN + "\r\n"
						+ Commons.ALLIESOFRULERS + "\r\n" + Commons.OUTPUT
						+ Commons.getStringFromList(allies, Commons.COMMA));
			}
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			Commons.initialMessage();
		}
	}

	/**
	 * Gets the allies after decoding the message.
	 *
	 * @param messages the messages
	 * @return the allies
	 * @throws ServiceException
	 */
	private static List<String> getAllies(List<String> messages) throws ServiceException {
		List<String> allies = new ArrayList<>();
		for (String message : messages) {
			String kingdomName = getKingdomName(message);
			if (Commons.isAlliedKingdom(kingdomName, getMessage(message))) {
				allies.add(kingdomName);
			}
		}
		return allies;
	}

	/**
	 * Extracts the actual message from Message sent by Ruler.
	 *
	 * @param message the message
	 * @return the message
	 */
	private static String getMessage(String message) {
		return message.substring(message.indexOf(Commons.COMMA) + 1, message.length());
	}

	/**
	 * Extracts the Kingdom Name from Message sent by Ruler.
	 *
	 * @param message the message
	 * @return the kingdom name
	 * @throws ServiceException
	 */
	private static String getKingdomName(String message) throws ServiceException {
		if (message.equals(Commons.NOSPACE) || message.equals(Commons.SPACE) || !message.contains(Commons.SPACE)) {
			throw new ServiceException("Incorrect Input");
		}
		return message.substring(0, message.indexOf(Commons.COMMA));
	}
}
