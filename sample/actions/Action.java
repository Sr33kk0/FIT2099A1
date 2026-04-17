package actions;

import crew.CrewMember;
import simulation.Moon;

/**
 * Abstract class which represent an actions.Action
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public abstract class Action
{
    /**
     * Method to execute the specific action
     *
     * @param crewMember    The crews.CrewMember performing the action as a crews.CrewMember object
     * @param moon          The moon environment as a simulation.Moon object
     * @return              The outcome of the action as a String
     */
    public abstract String execute(CrewMember crewMember, Moon moon);

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember    The crews.CrewMember performing the action as a crews.CrewMember object
     * @return              A menu description of the action as a String
     */
    public abstract String menuDescription(CrewMember crewMember);
}
