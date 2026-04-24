package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.behaviours.Behaviour;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

public class ConsumeBehaviour implements Behaviour<Actor, Action>
{
    @Override
    public Action operate(Actor actor, Location location) {
        List<Consumable> consumables = location.getItemsAs(Consumable.class);
        if (consumables.isEmpty())
        {
            return null;
        }
        return new ConsumeFromGroundAction(consumables.getFirst(), location);
    }
}