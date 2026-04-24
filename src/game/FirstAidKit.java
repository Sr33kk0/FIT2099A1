package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorStatistics;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.statistics.BaseStatistic;
import edu.monash.fit2099.engine.statistics.StatisticOperations;

public class FirstAidKit extends Item implements Consumable
{
    private int cooldownTurns = 0;
    private static final int COOLDOWN = 20;
    public FirstAidKit()
    {
        super("FirstAidKit", '+');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(25));
    }

    public ActionList allowableActions(Actor actor, GameMap map)
    {
        ActionList actions = new ActionList();
        if (cooldownTurns == 0)
        {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    public String consumedBy(Actor actor)
    {
        actor.modifyStatisticMaximum(ActorStatistics.HEALTH, StatisticOperations.INCREASE,1);
        cooldownTurns = COOLDOWN;
        return actor + " uses the First Aid Kit. Max HP is increased by 1 and health fully restored.";
    }

    public String menuDescription(Actor actor)
    {
        return actor + " uses the First Aid Kit";
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    public void tick(Location currentLocation, Actor actor)
    {
        if (cooldownTurns > 0)
        {
            cooldownTurns--;
        }
    }

    public boolean isFullyConsumed()
    {
        return false;
    }
}
