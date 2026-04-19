package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.statistics.BaseStatistic;

/**
 * Due to severe budget cuts, the flask is only permitted to hold five (5)
 * mouthfuls of liquid per deployment. Employees are reminded not to consume
 * all five charges in a panic during a single encounter.
 */
public class Flask extends Item implements Consumable
{
    int totalUsable = 5;
    public Flask()
    {
        super("Flask", 'u');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(3));
    }

    public String consumedBy(Actor actor)
    {
        totalUsable--;
        actor.heal(1);
        return actor + " drinks from the Flask. 1hp Restored.";
    }

    public ActionList allowableActions(Actor actor, GameMap map)
    {
        ActionList actions = new ActionList();
        if (totalUsable > 0)
        {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }
}
