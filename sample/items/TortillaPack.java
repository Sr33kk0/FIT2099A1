package items;

import actions.Action;
import actions.ConsumeAction;
import crew.CrewMember;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which stores the data of a Nut Can
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class TortillaPack extends Item implements Consumable
{
    private final double INCREASED_ENERGY_VALUE = 4;

    /**
     * Default constructor which creates the object of the class TortillaPack
     */
    public TortillaPack()
    {
        super("TortillaPack", 1);
    }

    /**
     * Non-default constructor which creates the object of the class TortillaPack
     *
     * @param brand     The bottle brand name as a string
     * @param weight    The bottle weight as a double
     */
    public TortillaPack(String brand, double weight)
    {
        super(brand, weight);
    }

    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember    The crew member that can execute the action
     * @return              A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        List<Action> actions = new ArrayList<>();

        if (crewMember.hasCapability(Ability.STERILISE))
        {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    /**
     * Executes the consumption action for the TortillaPack
     *
     * @param crewMember    The CrewMember consuming the TortillaPack as a CrewMember object
     * @return              A descriptive string detailing the consumption of the TortillaPack as a String
     */
    public String consumedBy(CrewMember crewMember)
    {
        crewMember.increaseEnergyLevel(INCREASED_ENERGY_VALUE);
        crewMember.unpack(this);
        return this.getSimpleName() + " is consumed by " +
                crewMember + " and it increases the energy level by " +
                INCREASED_ENERGY_VALUE;
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the bottle as a string
     */
    public String toString()
    {
        return String.format("%s (%s) has weight of %.2f kg",
                this.getClass().getSimpleName(), getBrand(),
                getWeight());
    }
}
