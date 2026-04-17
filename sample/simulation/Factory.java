package simulation;

import actions.Action;
import actions.ExploreAction;
import crew.CrewMember;
import items.*;

import java.util.ArrayList;
import java.util.List;

public class Factory implements Explorable
{
    public String exploredBy(CrewMember crewMember) {
        crewMember.decreaseEnergyLevel(4);
        String result = crewMember.getName() + " explores the Factory. Energy decreased by 4. ";

        double probability = crewMember.hasCapability(Ability.ILLUMINATOR) ? 0.40 : 0.10;

        if (Math.random() <= probability)
        {
            TreasureBox box = new TreasureBox();
            box.addContent(new NutCan());
            box.addContent(new LockPick());

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
