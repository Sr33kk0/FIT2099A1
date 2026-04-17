package actions;

import crew.CrewMember;
import simulation.Moon;
import items.Consumable;

/**
 * Class which represents an action to consume an item
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class ConsumeAction extends Action
{
    private Consumable consumable;

    /**
     * Non-default constructor which creates the object of the class ConsumeAction
     *
     * @param consumable  The item to be consumed as a Consumable object
     */
    public ConsumeAction(Consumable consumable)
    {
        this.consumable = consumable;
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
        return consumable.consumedBy(crewMember);
    }

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember    The CrewMember performing the action as a CrewMember object
     * @return              A menu description of the action as a String
     */
    public String menuDescription(CrewMember crewMember)
    {
        return crewMember + " will consume " + consumable.getClass().getSimpleName();
    }
}
