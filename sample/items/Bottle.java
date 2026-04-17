package items;

import actions.Action;
import actions.ConsumeAction;
import crew.CrewMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which stores the data of a bottle
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class Bottle extends Item implements Consumable
{
    private double capacity;
    private final double INCREASED_ENERGY_VALUE = 2;

    /**
     * Default constructor which creates the object of the class Bottle
     */
    public Bottle()
    {
        super("Unknown", 1);
        setCapacity(1);
    }

    /**
     * Non-default constructor which creates the object of the class Item
     *
     * @param brand     The bottle brand name as a string
     * @param weight    The bottle weight as a double
     * @param capacity  The bottle capacity as a double
     */
    public Bottle(String brand, double weight, double capacity)
    {
        super(brand, weight);
        setCapacity(capacity);
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
        if (capacity >= 0.15)
        {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    /**
     * Executes the consumption action for the bottle
     *
     * @param crewMember    The CrewMember drinking the bottle as a CrewMember object
     * @return              A descriptive string detailing the consumption of the bottle as a String
     */
    public String consumedBy(CrewMember crewMember)
    {
        setCapacity(this.capacity - 0.15);
        crewMember.increaseEnergyLevel(INCREASED_ENERGY_VALUE);
        return String.format("%s drink fresh water from %s",
                crewMember, this.toString());
    }

    /**
     * Getter method to get the bottle capacity
     *
     * @return  The bottle capacity as a double
     */
    public double getCapacity()
    {
        return capacity;
    }

    /**
     * Setter method to set the bottle capacity
     *
     * @param capacity The bottle capacity as a double
     */
    public void setCapacity(double capacity)
    {
        if(capacity < 0)
        {
            this.capacity = 0;
        }
        else
        {
            this.capacity = capacity;
        }
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the bottle as a string
     */
    public String toString()
    {
        return String.format("%s (%s) has weight of %.2f kg - to drink," +
                " with %.2f liter left", this.getClass().getSimpleName(), getBrand(),
                getWeight(), getCapacity());
    }
}
