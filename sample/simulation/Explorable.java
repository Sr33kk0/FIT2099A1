package simulation;

import actions.ActionCapable;
import crew.CrewMember;

public interface Explorable extends ActionCapable
{
    String exploredBy(CrewMember crewMember);
}
