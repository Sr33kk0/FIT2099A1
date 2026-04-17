package actions;

import crew.CrewMember;
import simulation.Explorable;
import simulation.Moon;

public class ExploreAction extends Action
{
    private Explorable explorable;

    public ExploreAction(Explorable explorable)
    {
        this.explorable = explorable;
    }

    /**
     * Method to execute the specific action
     *
     * @param crewMember The crews.CrewMember performing the action as a crews.CrewMember object
     * @param moon       The moon environment as a simulation.Moon object
     * @return The outcome of the action as a String
     */
    public String execute(CrewMember crewMember, Moon moon)
    {
        return explorable.exploredBy(crewMember);
    }

    /**
     * Method that returns a general description of the action
     *
     * @param crewMember The crews.CrewMember performing the action as a crews.CrewMember object
     * @return A menu description of the action as a String
     */
    public String menuDescription(CrewMember crewMember)
    {
        return crewMember + " will explore " + explorable.getClass().getSimpleName();
    }
}
