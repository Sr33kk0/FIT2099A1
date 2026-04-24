package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class ConsumeFromGroundAction extends Action {
    private final Consumable consumable;
    private final Location itemLocation;

    public ConsumeFromGroundAction(Consumable consumable, Location itemLocation)
    {
        this.consumable = consumable;
        this.itemLocation = itemLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map)
    {
        String result = consumable.consumedBy(actor);
        if (consumable.isFullyConsumed())
        {
            itemLocation.removeItem((Item) consumable);
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor)
    {
        return actor + " consumes " + consumable + " from the ground";
    }
}