package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A small, stationary body of mysterious liquid on the ground.
 * In a standard video game, this would just be water. On a deprecated moon
 * in the Eclipse Nebula, it could be anything from spilled engine coolant to
 * highly corrosive alien saliva. Step in it at your own risk.
 */
public class Puddle extends Ground {
    public Puddle()
    {
        super('~', "Puddle");
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction)
    {
        ActionList actions = new ActionList();
        if (direction.equals(" "))
        {
            actions.add(new DrinkAction());
        }
        return actions;
    }
}
