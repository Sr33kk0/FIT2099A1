package crew;

import actions.Action;
import actions.ActionCapable;
import items.*;
import java.util.List;

/**
 * Class which stores data of a CrewMember
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class CrewMember implements ActionCapable
{
    private Backpack backpack = new Backpack();
    private double energy = 30;
    private String name;

    /**
     * Default constructor which creates the object of the class CrewMember
     */
    public CrewMember()
    {
        setName("Unknown");
    }

    /**
     * Non-default constructor which creates the object of the class crews.CrewMember
     *
     * @param name  The name of the crews.CrewMember as a String
     */
    public CrewMember(String name)
    {
        setName(name);
    }

    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember    The crew member that can execute the action
     * @return              A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        return this.getBackpack().allowableActions(crewMember);
    }

    /**
     * Method to print out all the items in the CrewMember's backpack
     */
    public void checkAllItems()
    {
        System.out.println("Here are the items that " + getName() + " has in the backpack:");

        for (Item item:backpack.getStorage())
        {
            System.out.println(item.toString());
        }
    }

    /**
     * Method to decrease CrewMember's energy value
     *
     * @param energy    The CrewMember's energy value as a double
     */
    public void decreaseEnergyLevel(double energy)
    {
        this.energy = this.energy - energy;
    }

    /**
     * Getter method to get the CrewMember's energy value
     *
     * @return  The CrewMember's energy value as a double
     */
    public double getEnergy()
    {
        return this.energy;
    }

    /**
     * Getter method to get the CrewMember's Backpack
     *
     * @return  The CrewMember's Backpack as a Backpack object
     */
    public Backpack getBackpack()
    {
        return backpack;
    }

    /**
     * Getter method to get the CrewMember's name
     *
     * @return  The CrewMember's name as a String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method to check if CrewMember possess an item with a specific ability
     *
     * @param capability    The ability to be checked
     * @return              True if an item with the ability is found, false otherwise
     */
    public boolean hasCapability(Ability capability)
    {
        for (Item item : backpack.getAllItems())
        {
            if (item.hasCapability(capability))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to increase CrewMember's energy value
     *
     * @param energy    The CrewMember's energy value as a double
     */
    public void increaseEnergyLevel(double energy)
    {
        this.energy = this.energy + energy;
    }

    public boolean isConscious()
    {
        return this.energy > 0;
    }
    /**
     * Setter method to set the CrewMember's name
     *
     * @param name  The CrewMember's name as a String
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the CrewMember as a string
     */
    public String toString()
    {
        return getName() + " (Energy level: " + getEnergy() + ")";
    }

    /**
     * Method to remove an item from CrewMember's Backpack
     *
     * @param item  Item to be removed as a Item object
     */
    public void unpack(Item item)
    {
        this.backpack.remove(item);
    }
}
