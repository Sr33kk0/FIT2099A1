package simulation;

import actions.Action;
import crew.CrewMember;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class responsible for handling user interaction displaying a menu
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class Menu
{
    /**
     * Displays a menu of actions available to the user
     *
     * @param actions       The actions that can be done by the crew member as a list of Actions
     * @param crewMember    The crew member performing an action as crews.CrewMember object
     * @return              The action selected by the user as an actions.Action object
     */
    public static Action showMenu(List<Action> actions, CrewMember crewMember)
    {
        Scanner scanner = new Scanner(System.in);
        Character startChar = 'a';

        Map<Character, Action> keyToActionMap = new HashMap<>();

        for (Action action : actions)
        {
            keyToActionMap.put(startChar, action);
            System.out.println(startChar + ": " + action.menuDescription(crewMember));
            startChar++;
        }

        char key;
        do
        {
            key = scanner.next().charAt(0);
        }while (!keyToActionMap.containsKey(key));

        return keyToActionMap.get(key);
    }
}
