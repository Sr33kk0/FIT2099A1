package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action representing the desperate, mid-combat decision to chug whatever
 * liquid is sloshing around inside a flask.
 * Because nothing cures catastrophic injuries quite like aggressive hydration.
 *
 * @see Action
 */
public class ConsumeAction extends Action
{
    private final Consumable consumable;

    public ConsumeAction(Consumable consumable)
    {
        this.consumable = consumable;
    }

    /**
     * When executed, it will check for the actor's inventory whether they are carrying the flask.
     * If so, it will decrease the flask content and heal the actor.
     *
     * @param actor The actor consuming the flask.
     * @param map The map the actor is on.
     * @return the description of the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map)
    {
        return consumable.consumedBy(actor);
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return consumable.menuDescription(actor);
    }
}
