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
public class ConsumeFlaskAction extends Action {

    private final Consumable consumable;

    /**
     * Constructor.
     *
     * @param consumable the consumable item to drink from
     */
    public ConsumeFlaskAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Delegates the consumption effect to the consumable item.
     *
     * @param actor the actor consuming the item
     * @param map   the map the actor is on
     * @return the description of the result
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.consumedBy(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks from Flask";
    }
}
