package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.behaviours.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
public class AttackBehaviour implements Behaviour<Actor, Action>
{
    /**
     * Returns an AttackAction to attack to a worker, if possible.
     * If no attack is possible, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param location the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action operate(Actor actor, Location location)
    {
        for (Exit exit : location.getExits())
        {
            Actor target = exit.getDestination().getActor();
            if (target != null && target.hasAbility(EntityType.WORKER))
            {
                return new AttackAction(target, exit.getName());
            }
        }
        return null;
    }
}

