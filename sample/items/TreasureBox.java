package items;

import actions.Action;
import actions.UnlockAction;
import crew.CrewMember;
import simulation.Moon;

import java.util.ArrayList;
import java.util.List;

public class TreasureBox extends Item implements Unlockable
{
    private ArrayList<Item> contents = new ArrayList<Item>();

    public TreasureBox()
    {
        super("Treasure Box", 4);
    }

    public TreasureBox(String brand, double weight)
    {
        super(brand, weight);
    }

    public void addContent(Item item)
    {
        contents.add(item);
    }

    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember    The crew member that can execute the action
     * @return              A list of action that can be performed
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

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return The information of the items.Item as a string
     */
    public String toString() {
        return String.format("%s (%s) has weight of %.2f kg -" +
                        " requires a LockPick to open.", this.getClass().getSimpleName(),
                getBrand(), getWeight());
    }

    public String unlockedBy(CrewMember crewMember, Moon moon)
    {

        crewMember.getBackpack().remove(this);
        StringBuilder output = new StringBuilder("Unlocked " + this.getSimpleName() + ".");

        for (Item item : contents)
        {
            if (crewMember.getBackpack().add(item))
            {
                output.append("\n").append(item.getSimpleName()).append(" packed to Backpack.");
            }
            else
            {
                moon.getScatteredItems().add(item);
                output.append("\n Backpack is Full - ").append(item.getSimpleName()).append(" dropped on Moon.");
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
