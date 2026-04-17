package items;

import crew.CrewMember;

/**
 * Interface for an item to be consumed by a crew member
 *
 * @author Ho Shou Yee
 * @version v1.0.0
 */
public interface Consumable
{
    /**
     * Method for an item to be consumed by a crew member
     *
     * @param crewMember    The crew member consuming the item as a CrewMember object
     * @return              A string describing the outcome of the consumption as a String
     */
    public String consumedBy(CrewMember crewMember);
}
