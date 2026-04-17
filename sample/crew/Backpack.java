package crew;

import actions.*;
import items.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which stores the inventory data of a backpack
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class Backpack implements ActionCapable
{
    private final ArrayList<Item> storage = new ArrayList<>();
    private double limit = 100;

    /**
     * Default constructor which creates the object of the class Backpack
     */
    public Backpack()
    {
        Bottle bottle = new Bottle("Target", 1, 1);
        FlashLight flashLight = new FlashLight("Imalent MS32", 2);
        LockPick lockPick = new LockPick("Sparrows", 0.1);
        SterilisationBox sterilisationBox = new SterilisationBox("SURTEX", 5);
        NutCan nutCan = new NutCan();
        TortillaPack tortillaPack = new TortillaPack();
        add(bottle);
        add(flashLight);
        add(lockPick);
        add(sterilisationBox);
        add(nutCan);
        add(tortillaPack);
    }

    /**
     * Method to add an item into the backpack
     *
     * @param item  Item to be added into the backpack as an item
     * @return      True if item was successfully added, false if exceeds weight limit
     */
    public boolean add(Item item)
    {
        double estimatedWeight = this.totalWeight() + item.getWeight();
        if (estimatedWeight > limit)
        {
            return false;
        }
        this.storage.add(item);
        return true;
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

        for (Item item : storage)
        {
            actions.add(item.getUnpackAction());
            actions.addAll(item.allowableActions(crewMember));
        }
        return actions;
    }

    /**
     * Method to retrieve a defensive copy of the items stored in the backpack
     *
     * @return  A new list of items stored in the backpack as a list of Items
     */
    public List<Item> getAllItems()
    {
        return new ArrayList<>(this.storage);
    }

    /**
     * Getter method to get the contents of the backpack
     *
     * @return  The items contained in the backpack as an array list of items
     */
    public ArrayList<Item> getStorage()
    {
        return storage;
    }

    /**
     * Method to remove an item from the backpack
     *
     * @param item  Item to be removed from the backpack as an item
     * @return  True if item was successfully removed, false if item does not exist in backpack
     */
    public boolean remove(Item item)
    {
        return this.storage.remove(item);
    }

    /**
     * Method to return the total weight of the items inside the backpack
     *
     * @return  The total weight of all items as a double
     */
    public double totalWeight()
    {
        double totalWeight = 0;
        for (Item item : storage)
        {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
