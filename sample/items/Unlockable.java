package items;

import crew.CrewMember;
import simulation.Moon;

public interface Unlockable
{
    public String unlockedBy(CrewMember crewMember, Moon moon);
}
