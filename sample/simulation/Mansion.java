package simulation;

import actions.Action;
import actions.ExploreAction;
import crew.CrewMember;
import items.*;

import java.util.ArrayList;
import java.util.List;

public class Mansion implements Explorable
{
    public String exploredBy(CrewMember crewMember) {
        crewMember.decreaseEnergyLevel(6);
        String result = crewMember.getName() + " explores the Mansion. Energy decreased by 6. ";

        if (crewMember.hasCapability(Ability.UNLOCK))
        {
            TreasureBox box = new TreasureBox();
            box.addContent(new TortillaPack());
            box.addContent(new NutCan());

            if (crewMember.getBackpack().add(box))
            {
                result += "\nFound a TreasureBox and added it to the backpack!";
            }
            else
            {
                result += "\nFound a TreasureBox, but the backpack is too heavy to carry it.";
            }
        }
        else
        {
            result += "\nFound nothing of interest.";
        }
        return result;
    }

    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember The crew member that can execute the action
     * @return A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        List<Action> actions = new ArrayList<>();
        actions.add(new ExploreAction(this));
        return actions;
    }
}
