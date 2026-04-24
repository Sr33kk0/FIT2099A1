package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.statistics.BaseStatistic;

public class Apple extends Item implements Consumable
{
    public Apple()
    {
        super("Apple", 'ó');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(1));
    }

    public String consumedBy(Actor actor)
    {
        String result;
        if (actor.hasAbility(WorkerAbility.STERILISE))
        {
            actor.heal(3);
            result = actor + " consumed Apple. 3 HP Restored.";
        }
        else
        {
            actor.addStatus(new PoisonStatus(1, 5));
            result = actor + " consumed Apple (Rotten) and is poisoned for 5 turns.";
        }
        actor.getInventory().remove(this);
        return result;
    }

    public ActionList allowableActions(Actor actor, GameMap map)
    {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    public String menuDescription(Actor actor)
    {
        return actor + " consumes Apple";
    }

    public boolean isFullyConsumed()
    {
        return true;
    }
}
