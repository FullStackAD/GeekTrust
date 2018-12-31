package problem.set.q;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class Commons.
 */
public class Commons {
	public static String INPUT = "Input: ";
	public static String RULEROFSOUTHEROS = "Who is the ruler of Southeros?";
	public static String OUTPUT = "Ouput: ";
	public static String SHAN = "Shan";
	public static String ALLIESOFRULERS = "Allies of Ruler?";
	public static String COMMA = ",";
	public static String NONE = "None";
	public static String LAND = "Land";
	public static String LAND_EMBLEM = "PANDA";
	public static String WATER = "Water";
	public static String WATER_EMBLEM = "Octopus";
	public static String ICE = "Ice";
	public static String ICE_EMBLEM = "Mammoth";
	public static String AIR = "Air";
	public static String AIR_EMBLEM = "Owl";
	public static String FIRE = "Fire";
	public static String FIRE_EMBLEM = "Dragon";
	public static String SPACE = " ";
	public static String MESSAGES_FILE_NAME = "boc-messages.txt";
	public static String NOSPACE = "";
	public static String EXPECTED_OUTPUT_SUCCESS = "Who is the ruler of Southeros?\r\n" + "Ouput: None\r\n"
			+ "Allies of Ruler?\r\n" + "Ouput: None\r\n" + "Input Messages to kingdoms from King Shan:\r\n"
			+ "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n"
			+ "Who is the ruler of Southeros?\r\n" + "Ouput: Shan\r\n" + "Allies of Ruler?\r\n"
			+ "Ouput: Air,Land,Ice,Fire\r\n";
	public static String EXPECTED_OUTPUT_EMPTY_INPUT = "Who is the ruler of Southeros?\r\n" + "Ouput: None\r\n"
			+ "Allies of Ruler?\r\n" + "Ouput: None\r\n" + "Input Messages to kingdoms from King Shan:\r\n"
			+ "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Incorrect Input\r\n"
			+ "Who is the ruler of Southeros?\r\n" + "Ouput: None\r\n" + "Allies of Ruler?\r\n" + "Ouput: None\r\n";

	public static String EXPECTED_OUTPUT_INCORRECT_KINGDOM = "Who is the ruler of Southeros?\r\n" + "Ouput: None\r\n"
			+ "Allies of Ruler?\r\n" + "Ouput: None\r\n" + "Input Messages to kingdoms from King Shan:\r\n"
			+ "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "Input: \r\n" + "The Kingdom Fiore is not in Southeros\r\n"
			+ "Who is the ruler of Southeros?\r\n" + "Ouput: None\r\n" + "Allies of Ruler?\r\n" + "Ouput: None\r\n";


	/**
	 * Gets the kingdom code. Mapping of Kingdom Name and Emblem
	 *
	 * @return the kingdom code
	 */
	public static Map<String, String> getKingdomCode() {
		return new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(LAND, LAND_EMBLEM);
				put(WATER, WATER_EMBLEM);
				put(ICE, ICE_EMBLEM);
				put(AIR, AIR_EMBLEM);
				put(FIRE, FIRE_EMBLEM);
			}
		};
	}


	/**
	 * Checks if given kingom is allied based on message sent by ruler. We get the
	 * kingdom emblem based on the name and then check if all characters are present
	 * or not in the message.
	 *
	 * @param kingdomName the kingdom name
	 * @param messageSentByRuler the message sent by ruler
	 * @return the boolean
	 * @throws ServiceException the service exception
	 */
	public static Boolean isAlliedKingdom(String kingdomName, String messageSentByRuler) throws ServiceException {
		int index = 0;
		messageSentByRuler = messageSentByRuler.toLowerCase();
		String emblem = getEmblem(kingdomName);
		for (char c : emblem.toCharArray()) {
			index = messageSentByRuler.indexOf(c);
			if (index < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the emblem. If not then throws service exception
	 *
	 * @param kingdomName the kingdom name
	 * @return the emblem
	 * @throws ServiceException the service exception
	 */
	public static String getEmblem(String kingdomName) throws ServiceException {
		try {
			return Commons.getKingdomCode().get(kingdomName).toLowerCase();
		} catch (java.lang.NullPointerException e) {
			throw new ServiceException("The Kingdom " + kingdomName + " is not in Southeros");
		}
	}

	/**
	 * Initial message. This prints the initial message before the Ruler sends the
	 * messages.
	 */
	public static void initialMessage() {
		System.out
				.println(RULEROFSOUTHEROS + "\r\n" + OUTPUT + NONE + "\r\n" + ALLIESOFRULERS + "\r\n" + OUTPUT + NONE);
	}

	/**
	 * Split string to list of string for a given pattern.
	 *
	 * @param input the input
	 * @param pattern the pattern
	 * @return the list
	 */
	public static List<String> splitStringToList(String input, String pattern) {
		return new ArrayList<>(Arrays.asList(input.split(pattern)));
	}


	/**
	 * Read messages from TXT File. If file path is empty then absolute location of
	 * file is used to load the file.
	 *
	 * @param fileName the file name
	 * @param filePath the file path
	 * @return the list
	 */
	public static List<String> readMessagesFromTxt(String fileName, String filePath) {
		try {
			if (filePath == null) {
				return Files
						.readAllLines(Paths.get(Paths.get("").toAbsolutePath().toString() + File.separator + fileName));
			} else {
				return Files.readAllLines(Paths.get(Paths.get(filePath) + File.separator + fileName));
			}
		} catch (IOException e) {
			System.out.println("Error Sorry Unable to Read file");
			return null;
		}
	}


	/**
	 * Convert List of String to String separated by given pattern.
	 *
	 * @param allies the allies
	 * @param pattern the pattern
	 * @return the string from list
	 */
	public static String getStringFromList(List<String> allies, String pattern) {
		return String.join(pattern, allies);
	}
}
