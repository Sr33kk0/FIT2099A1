package actions;

import crew.CrewMember;
import items.Item;
import simulation.Moon;

/**
 * Class which represents an action to unpack an Item
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class UnpackAction extends Action
{
    private Item item;

    /**
     * Non-default constructor which creates the object of the UnpackAction
     *
     * @param item  The item to be packed as an Item object
     */
    public UnpackAction(Item item)
    {
        this.item = item;
    }

    /**
     * Method to execute the specific action
     *
     * @param crewMember    The CrewMember performing the action as a CrewMember object
     * @param moon          The moon environment as a Moon object
     * @return              The outcome of the action as a String
     */
    public String execute(CrewMember crewMember, Moon moon)
    {
        if(crewMember.getBackpack().remove(this.item))
        {
            moon.getScatteredItems().add(this.item);
            return crewMember + " removed " + this.item.getSimpleName() + " from the backpack";
        }
        return this.item.getSimpleName() + " is not in the backpack";
    }

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember    The CrewMember performing the action as a CrewMember object
     * @return              A menu description of the action as a String
     */
    public String menuDescription(CrewMember crewMember)
    {
        return crewMember + " will unpack "  + this.item.getSimpleName() + " from the backpack";
    }
}
