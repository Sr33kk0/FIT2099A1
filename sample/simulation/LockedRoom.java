package simulation;

import actions.Action;
import actions.ActionCapable;
import actions.UnlockAction;
import crew.CrewMember;
import items.*;

import java.util.ArrayList;
import java.util.List;

public class LockedRoom implements ActionCapable, Unlockable
{
    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember The crew member that can execute the action
     * @return A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        List<Action> actions = new ArrayList<>();
        if (crewMember.hasCapability(Ability.UNLOCK))
        {
            actions.add(new UnlockAction(this));
        }
        return actions;
    }

    public String unlockedBy(CrewMember crewMember, Moon moon)
    {
        StringBuilder output = new StringBuilder("Unlocked a Mansion Room. Discovered 3 TreasureBoxes.");

        for (int i = 1; i <= 3; i++) {
            TreasureBox box = new TreasureBox("Mansion Room Box " + i, 2.0);
            box.addContent(new TortillaPack("Mansion Tortilla", 1.0));
            box.addContent(new NutCan("Mansion Nut", 0.5));

            if (crewMember.getBackpack().add(box))
            {
                output.append("\n").append(box.getSimpleName()).append(" packed to Backpack.");
            }
            else
            {
                moon.getScatteredItems().add(box);
                output.append("\n Backpack is Full - ").append(box.getSimpleName()).append(" dropped on Moon.");
            }
        }

        for (Item backpackItem : crewMember.getBackpack().getStorage())
        {
            if (backpackItem.hasCapability(Ability.UNLOCK))
            {
                backpackItem.removeCapability(Ability.UNLOCK);
                break;
            }
        }

        return output.toString();
    }
}
