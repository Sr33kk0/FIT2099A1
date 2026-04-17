package actions;

import crew.CrewMember;
import simulation.Moon;
import items.Unlockable;

/**
 * Class which represents an action to consume an item
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class UnlockAction extends Action
{
    private Unlockable unlockable;

    /**
     * Non-default constructor which creates the object of the class ConsumeAction
     *
     * @param unlockable  The item to be consumed as a Unlockable object
     */
    public UnlockAction(Unlockable unlockable)
    {
        this.unlockable = unlockable;
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
        return unlockable.unlockedBy(crewMember, moon);
    }

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember    The CrewMember performing the action as a CrewMember object
     * @return              A menu description of the action as a String
     */
    public String menuDescription(CrewMember crewMember)
    {
        return crewMember + " will unlock " + unlockable.getClass().getSimpleName();
    }
}
