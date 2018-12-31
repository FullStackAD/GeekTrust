/**
 * problem 2: Breaker of Chains
 * The other kingdoms in the Universe also yearn to be the ruler of Southeros and war is imminent! The High Priest of Southeros
 * intervenes and is trying hard to avoid a war and he suggests a ballot system to decide the ruler.
 * Your coding challenge is to help the High Priest choose the ruler of Southeros through the ballot system.
 * Rules of the Ballot system
 * 1. Any kingdom can compete to be the ruler.
 * 2. They should send a message to all other kingdoms asking for allegiance.
 * 3. This message will be put in a ballot from which the High Priest will pick 6 random messages.
 * 4. The High Priest then hands over the 6 messages to the respective receiving kingdoms.
 * 5. The kingdom that receives the highest number of allegiance is the ruler.
 * 
 * Rules to decide allegiance by a kingdom
 * 1. The receiving kingdom has to give allegiance to the sending kingdom if the message contains the letters of the animal in their
 * emblem (same as problem 1).
 * 2. If the receiving kingdom is competing to be the ruler, they will not give their allegiance even if the message they received is correct.
 * 3. A kingdom cannot give their allegiance twice. If they have given their allegiance once, they will not give their allegiance again even
 * if they get a second message and the message is correct.
 * In case there is a tie
 * 1. If there is a tie, the whole ballot process is repeated but only with the tied kingdoms till there is a winner.
 * Sending messages
 * The format of the message dropped in the ballot should contain :
 * • The Sender kingdom
 * • The Receiver kingdom
 * • The Message (should be selected randomly from the messages provided in the table below)
 */
package problem.set.q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * The Class Problem2.
 */
public class Problem2 {
	public static void main(String[] args) {
		try {
			Commons.initialMessage();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the kingdoms competing to be the ruler:");
			System.out.print(Commons.INPUT);
			String input = scanner.nextLine();
			scanner.close();
			List<String> competingKingdoms = Commons.splitStringToList(input, Commons.SPACE);
			Integer n = 1;

			while (n > 0) {
				List<String> messages = Commons.readMessagesFromTxt(Commons.MESSAGES_FILE_NAME, null);
				Collections.shuffle(messages);
				if (competingKingdoms.size() == 0) {
					Commons.initialMessage();
					return;
				} else if (competingKingdoms.size() == 1) {
					if (competingKingdoms.get(0).trim().equals(Commons.NOSPACE)
							|| competingKingdoms.get(0).trim().equals(Commons.SPACE)) {
						Commons.initialMessage();
						return;
					}
					Commons.getEmblem(competingKingdoms.get(0));
					System.out.println(Commons.RULEROFSOUTHEROS + "\r\n" + Commons.OUTPUT + competingKingdoms.get(0)
							+ "\r\n" + Commons.ALLIESOFRULERS + "\r\n" + Commons.OUTPUT + Commons.NONE);
					return;
				}

				List<Ballot> ballot = getBallot(competingKingdoms, messages);
				List<Ballot> highPriestSelection = getMessagesSelectedByHighPriest(ballot);
				Map<String, List<String>> resultAfterBallet = getResultAfterBallotCount(competingKingdoms,
						highPriestSelection);

				System.out.println("Results after round " + n + " ballot count");
				for (String competingKingdom : competingKingdoms) {
					if (resultAfterBallet.containsKey(competingKingdom)) {
						System.out.println("Output: Allies for " + competingKingdom + " : "
								+ resultAfterBallet.get(competingKingdom).size());
					} else {
						System.out.println("Output: Allies for " + competingKingdom + " : " + 0);
					}
				}

				List<String> ruler = getRuler(resultAfterBallet);
				if (ruler.size() == 1) {
					System.out.println(Commons.RULEROFSOUTHEROS + "\r\n" + Commons.OUTPUT + ruler.get(0) + "\r\n"
							+ Commons.ALLIESOFRULERS + "\r\n" + Commons.OUTPUT
							+ String.join(Commons.COMMA, resultAfterBallet.get(ruler.get(0))));
					n = 0;
				} else if (ruler.size() > 1) {
					competingKingdoms.clear();
					competingKingdoms = ruler;
					n++;
				}
			}
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			Commons.initialMessage();
		}
	}

	/**
	 * Determines the ruler after ballot count.
	 *
	 * @param resultAfterBallet the result after ballet
	 * @return the ruler
	 */
	private static List<String> getRuler(Map<String, List<String>> resultAfterBallet) {
		List<String> ruler = new ArrayList<>();
		Integer noOfAllies = 0;
		for (Map.Entry<String, List<String>> result : resultAfterBallet.entrySet()) {
			if (result.getValue().size() > noOfAllies) {
				noOfAllies = result.getValue().size();
				ruler.clear();
				ruler.add(result.getKey());
			} else if (result.getValue().size() == noOfAllies) {
				ruler.add(result.getKey());
			}
		}
		if (noOfAllies == 0) {
			for (Map.Entry<String, List<String>> result : resultAfterBallet.entrySet()) {
				ruler.add(result.getKey());
			}
		}
		return ruler;
	}

	/**
	 * Gets the result after ballot count.
	 *
	 * @param competitingKingdoms the competiting kingdoms
	 * @param messages            the messages
	 * @return the result after ballot count
	 * @throws ServiceException
	 */
	private static Map<String, List<String>> getResultAfterBallotCount(List<String> competitingKingdoms,
			List<Ballot> messages) throws ServiceException {
		List<String> alreadyAlly = new ArrayList<>();
		HashMap<String, List<String>> result = new HashMap<>();
		for (Ballot message : messages) {
			if (alreadyAlly.indexOf(message.getToKingdom()) < 0
					&& competitingKingdoms.indexOf(message.getToKingdom()) < 0) {
				if (Commons.isAlliedKingdom(message.getToKingdom(), message.getMessage())) {
					alreadyAlly.add(message.getToKingdom());
					if (result.containsKey(message.getFromKingdom()) || null != result.get(message.getFromKingdom())) {
						result.get(message.getFromKingdom()).add(message.getToKingdom());
					} else {
						result.put(message.getFromKingdom(),
								new ArrayList<String>(Arrays.asList(message.getToKingdom())));
					}
				}
			}
		}
		return result;
	}

	/**
	 * Gets the messages selected by high priest. The high priest selects any 6
	 * messages at random. Here we shuffle the ballot and then randomly choose any 6
	 * messages
	 *
	 * @param ballot the ballot
	 * @return the messages selected by high priest
	 */
	private static List<Ballot> getMessagesSelectedByHighPriest(List<Ballot> ballot) {
		Collections.shuffle(ballot);
		List<Ballot> highPriestSelection = new ArrayList<>();
		int random = new Random().nextInt((ballot.size() - 6) + 1);
		for (int i = random; i < ballot.size(); i++) {
			highPriestSelection.add(ballot.get(i));
		}
		return highPriestSelection;
	}

	/**
	 * Prepare The Ballot. Here we take the messages read from text file as input
	 * and list of competing kingdoms. We then prepare the ballot with condition The
	 * competing kingdom must send the message to other kingdom not to itlself
	 *
	 * @param competingKingdoms the competing kingdoms
	 * @param messages          the messages
	 * @return the ballot
	 * @throws ServiceException
	 */
	private static List<Ballot> getBallot(List<String> competingKingdoms, List<String> messages)
			throws ServiceException {
		Integer index = 0;
		List<Ballot> ballots = new ArrayList<>();
		for (String competingKingdom : competingKingdoms) {
			for (Map.Entry<String, String> toKingdoms : Commons.getKingdomCode().entrySet()) {
				if (competingKingdom.equalsIgnoreCase(toKingdoms.getKey())) {

				} else {
					Commons.getEmblem(competingKingdom);
					Ballot ballot = new Ballot();
					ballot.setFromKingdom(competingKingdom);
					ballot.setToKingdom(toKingdoms.getKey());
					ballot.setMessage(messages.get(index).replaceAll(Commons.COMMA, Commons.SPACE));
					ballots.add(ballot);
					index++;
				}
			}
		}
		return ballots;
	}
}
