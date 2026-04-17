package actions;

import crew.CrewMember;
import items.Item;
import simulation.Moon;

/**
 * Class which represents an action to pack an items.Item
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class PackAction extends Action
{
    private Item item;

    /**
     * Non-default constructor which creates the object of the class PackAction
     *
     * @param item  The item to be packed as an Item object
     */
    public PackAction(Item item)
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
        if(crewMember.getBackpack().add(this.item))
        {
            moon.getScatteredItems().remove(this.item);
            return crewMember + " packed " + this.item.getSimpleName() + " to the backpack";
        }
        return this.item.getSimpleName() + " can not be packed as it will exceed the backpack limit";
    }

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember    The CrewMember performing the action as a CrewMember object
     * @return              A menu description of the action as a String
     */
    public String menuDescription(CrewMember crewMember)
    {
        return crewMember + " will pack "  + this.item.getSimpleName() + " to the backpack";
    }
}
