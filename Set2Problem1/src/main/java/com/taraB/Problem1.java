/**
 * Our problem is set in the planet of Lengaburu…in the distant
 * distant galaxy of Tara B. Our protagonists are King Shan, the
 * emperor of Lengaburu, and the evil queen Al Falcone of
 * Falicornia
 * Lengaburu has been at peace with her neighbours for over 50
 * years but now…. planet Falicornia dares attack Lengaburu.
 * Write code to help King Shan identify the optimal force he
 * should deploy to defend Lengaburu
 * Problem 1: The two planets
 * If Falicornia attacks Lengaburu with 2 Horses, 2 Elephants, 2 Armoured Tanks and 2 Sling Guns, Lengaburu will
 * win the war if King Shan matches the attack with 1 Horse, 1 Elephant, 1 Armoured Tank and 1 Sling Gun.
 * But not so fast! Al Falcone will surely attack with a larger army. Your coding challenge is to identify what battalions,
 * and how many units of each battalion King Shan should deploy to match Al Falcone's attack.
 * Rules of war
 * Lengaburu’s army has 100 Horses, 50 Elephants, 10 Armoured Tanks and 5 Sling Guns
 * Rule #1. The Power Rule: Each Lengaburu army unit is 2X more powerful than their Falcornia counterpart. Example: 1
 * Lengaburu Horse can counter 2 Falicornia Horses, 1 Lengaburu Elephant can counter 2 Falicornia Elephants and so on.
 * Rule #2. The Like-to-Like Rule: Falicornia Horses battalion should be countered with Lengaburu horses battalion,
 * Elephants with elephants and so on. Except when the battalion is completely exhausted (see Rule #3).
 * Example: If Falicornia deploys 2 H, 4 E, 0 AT and 6 SG, Lengaburu should counter with 1 H, 2 E, 0 AT and 3 SG.
 * Rule #3. The Substitution Rule: When all units of a particular Lengaburu battalion is exhausted, an adjacent battalion can be used. 1
 * Elephant can replace 2 Horses (and 2 Horses can replace 1 Elephant), 1 Armoured Tank can replace 2 Elephants (and vice versa) and 1
 * Sling Gun can replace 2 Armoured Tanks (and vice versa). Note that only adjacent battalions can be used for substituting. Horses cannot
 * replace Sling Guns as they are not adjacent.
 * Example: If Falicornia deploys 204 H, 20 E, 0 AT and 0 SG, Lengaburu should counter with 100 H, 11 E (1 Elephant has substituted 2
 * Horses which got exhausted at 100)
 * Example: If Falicornia deploys 0 H, 0 E, 14 AT and 12 SG, Lengaburu should counter with 0 H, 0 E, 9 AT and 5 SG (2 AT has substituted
 * for 1 SG which got exhausted at 5)
 * Rule #4. The Substitution Choice Rule: When there are 2 possibilities of substitution, then always a lower ranked battalion should be
 * used (Horses is lower than Elephants, is lower than Armoured Tanks, is lower than Sling Guns)
 * Example: If Falicornia deploys 50 H, 104 E, 6 AT and 2 SG, Lengaburu should counter with 29 H, 50 E, 3 AT and 1 SG (4 Horses
 * substituted for 2 Elephants instead of the higher ranked Armoured Tanks)
 */
package com.taraB;

import java.util.Scanner;

/**
 * The Class Problem1.
 */
public class Problem1 {
	public static void main(String args[]) {
		Army lengaburu = null;
		Army falicornia = null;
		String result = null;
		try {
			System.out.print("Input: Falicornia attacks with ");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			String input[] = s.split(", ");
			scanner.close();
			if (input.length > 4) {
				System.out.println("Falicornia attacked with new Regiment. That is not allowed!!!");
			}
			falicornia = ArmyService.prepareFalicorniaArmy(input);
			if (falicornia.canAttack()) {
				lengaburu = ArmyService.prepareLengaburuArmy(falicornia);
				if (falicornia.isArmyWipedOut()) {
					result = "wins";
				} else {
					result = "loses";
				}
				System.out.println("Lengaburu deploys " + lengaburu.getHorses() + " H, " + lengaburu.getElephants()
						+ " E, " + lengaburu.getArmouredTanks() + " AT, " + lengaburu.getSlingGuns() + " SG and "
						+ result);
			} else {
				System.out.println("Falicornia cannot leave itself unprotected");
			}

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
