package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorStatistics;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.statistics.BaseStatistic;
import edu.monash.fit2099.engine.statistics.StatisticOperations;

public class Cookies extends Item implements Consumable
{
    private int totalUsable = 5;
    public Cookies()
    {
        super("Cookies", '◍');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(2));
    }

    public String consumedBy(Actor actor)
    {
        String result;
        if (actor.hasAbility(WorkerAbility.STERILISE))
        {
            actor.heal(1);
            result = actor + " consumed Cookies. 1 HP Restored.";
        }
        else
        {
            actor.modifyStatisticMaximum(ActorStatistics.HEALTH, StatisticOperations.DECREASE,1);
            result = actor + " consumed Cookies (Rotten). Max HP is decreased by 1";
        }
        this.totalUsable--;
        if (this.totalUsable == 0)
        {
            actor.getInventory().remove(this);
        }
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
        return actor + " consumes Cookies (" +this.totalUsable + " uses left)";
    }
}
