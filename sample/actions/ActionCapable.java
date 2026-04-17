package actions;

import crew.CrewMember;

import java.util.List;

/**
 * Interface to generate a list of user interactions
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public interface ActionCapable
{
    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember    The crew member that can execute the action
     * @return              A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember);
}
