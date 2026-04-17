package simulation;

import actions.*;
import crew.CrewMember;
import items.FlashLight;
import items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents the simulation.Moon environment
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class Moon implements ActionCapable
{
    private final ArrayList<Item> scatteredItems = new ArrayList<>();
    private CrewMember crewMember = new CrewMember("Misty");
    private ArrayList<Explorable> locations = new ArrayList<>();
    private LockedRoom lockedRoom = new LockedRoom();

    /**
     * Default constructor which creates the object of the class simulation.Moon
     */
    public Moon()
    {
        scatteredItems.add(new FlashLight("Emisar D3AA", 2));
        locations.add(new Factory());
        locations.add(new Mansion());
        locations.add(new MineShaft());
    }

    /**
     * Method to generate a list of actions that can be performed on the simulation.Moon
     *
     * @return A list of action that can be done
     */
    public List<Action> allowableActions(CrewMember crewMember)
    {
        List<Action> actions = new ArrayList<>();

        for (Item item : scatteredItems)
        {
            actions.add(item.getPackAction());
        }

        for (Explorable location : locations)
        {
            actions.addAll(location.allowableActions(crewMember));
        }

        actions.addAll(lockedRoom.allowableActions(crewMember));

        return actions;
    }

    public CrewMember getCrewMember()
    {
        return this.crewMember;
    }

    /**
     * Getter method to get the scattered items on the simulation.Moon
     *
     * @return  The items scattered across the moon as an array list of items
     */
    public ArrayList<Item> getScatteredItems()
    {
        return scatteredItems;
    }

    /**
     * Method to print every item scattered on the simulation.Moon
     */
    public void listOutItems()
    {
        System.out.println("\nHere are the items that we have on the moon:");
        for (Item item : scatteredItems)
        {
            System.out.println(item.toString());
        }
    }

    /**
     * Method to simulate the simulation.Moon exploration
     */
    public void simulate()
    {
        List<Action> actions = new ArrayList<>();
        actions.addAll(this.allowableActions(crewMember));
        actions.addAll(crewMember.allowableActions(crewMember));

        System.out.println("###################################################");

        crewMember.checkAllItems();
        this.listOutItems();

        System.out.println("###################################################");

        Action action = Menu.showMenu(actions, crewMember);
        System.out.println(action.execute(crewMember, this));
    }
}
