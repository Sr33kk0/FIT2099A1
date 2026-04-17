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
public class Flask extends Item implements Consumable {

    private int totalUsable = 5;

    public Flask() {
        super("Flask", 'u');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(3));
    }

    /**
     * Decrements the flask's remaining uses and heals the actor by 1 point.
     *
     * @param actor the actor drinking from the flask
     * @return a string describing the outcome
     */
    @Override
    public String consumedBy(Actor actor) {
        totalUsable--;
        actor.heal(1);
        return actor + " drinks from the Flask, restoring 1 point of health.";
    }

    /**
     * Returns a ConsumeFlaskAction when the flask still has uses remaining.
     * Once depleted, no action is offered and the flask silently remains in inventory.
     */
    @Override
    public ActionList allowableActions(Actor owner, GameMap map) {
        ActionList actions = new ActionList();
        if (totalUsable > 0) {
            actions.add(new ConsumeFlaskAction(this));
        }
        return actions;
    }
}
