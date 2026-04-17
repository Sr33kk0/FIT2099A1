package simulation;

import actions.Action;
import actions.ExploreAction;
import crew.CrewMember;
import items.*;

import java.util.ArrayList;
import java.util.List;

public class MineShaft implements Explorable
{
    public String exploredBy(CrewMember crewMember)
    {
        boolean foundSomething = false;
        crewMember.decreaseEnergyLevel(5);
        String result = crewMember.getName() + " explores the Mansion. Energy decreased by 5. ";

        if (crewMember.hasCapability(Ability.STERILISE))
        {
            if (crewMember.getBackpack().add(new NutCan()))
            {
                result += "\nFound a NutCan and added it to the backpack!";
            }
            else
            {
                result += "\nFound a NutCan, but the backpack is too heavy to carry it.";
            }

            foundSomething = true;
        }

        if (Math.random() <= 0.30)
        {
            TreasureBox box = new TreasureBox();
            box.addContent(new TortillaPack());
            box.addContent(new LockPick());

            if (crewMember.getBackpack().add(box))
            {
                result += "\nFound a TreasureBox and added it to the backpack!";
            }
            else
            {
                result += "\nFound a TreasureBox, but the backpack is too heavy to carry it.";
            }

            foundSomething = true;
        }

        if (!foundSomething)
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
