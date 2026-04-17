package items;

import actions.*;
import crew.CrewMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class which stores the data of an item
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public abstract class Item implements ActionCapable
{
    private String brand;
    private double weight;
    private final ArrayList<Ability> statuses = new ArrayList<>();

    /**
     * Default constructor which creates the object of the class items.Item
     */
    public Item()
    {
        setBrand("None");
        setWeight(0);
    }

    /**
     * Non-default constructor which creates the object of the class items.Item
     *
     * @param brand     The item brand name as a string
     * @param weight    The item weight as a double
     */
    public Item(String brand, double weight)
    {
        setBrand(brand);
        setWeight(weight);
    }

    /**
     * Method that adds a specific capability to the item
     *
     * @param capability    Ability to be added to the item as an Ability enum
     */
    public void addCapability(Ability capability)
    {
        this.statuses.add(capability);
    }

    /**
     * Method to generate a list of allowable actions that can be performed by a crew member
     *
     * @param crewMember    The crew member that can execute the action
     * @return              A list of action that can be performed
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        return new ArrayList<>();
    }

    /**
     * Getter method to get the item brand name
     *
     * @return  The item brand name as a string
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Instantiate an action to pack this Item instance
     *
     * @return  The actions.PackAction bound to this Item instance
     */
    public Action getPackAction()
    {
        return new PackAction(this);
    }

    /**
     * Getter method to get the simple name of the class
     *
     * @return  The class simple name as a String
     */
    public String getSimpleName()
    {
        return this.getClass().getSimpleName();
    }

    /**
     * Instantiate an action to unpack this Item instance
     *
     * @return  The actions.UnpackAction bound to this Item instance
     */
    public Action getUnpackAction()
    {
        return new UnpackAction(this);
    }

    /**
     * Getter method to get the item weight
     * @return  The item weight as a double
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Method to check if the item has a specific ability
     *
     * @param capability    The ability to check for as an Ability enum
     * @return              True if found, false otherwise
     */
    public boolean hasCapability(Ability capability)
    {
        return this.statuses.contains(capability);
    }

    /**
     * Method to remove a specific capability from the item
     *
     * @param capability    The ability to be removed from the item as an Ability enum
     */
    public void removeCapability(Ability capability)
    {
        this.statuses.remove(capability);
    }

    /**
     * Setter method to set the item brand name
     *
     * @param brand The item brand name as a String
     */
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    /**
     * Setter method to set the item weight
     *
     * @param weight    The item weight as a double
     */
    public void setWeight(double weight)
    {
        if(weight < 0)
        {
            this.weight = 0;
        }
        else
        {
            this.weight = weight;
        }
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the items.Item as a string
     */
    public abstract String toString();
}
