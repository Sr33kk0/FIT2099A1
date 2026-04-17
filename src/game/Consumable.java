package game;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for items that can be consumed by an actor.
 * Implementors define the effect of consumption and when they are available to be consumed.
 */
public interface Consumable {

    /**
     * Applies this item's consumption effect to the given actor.
     *
     * @param actor the actor consuming this item
     * @return a string describing the outcome
     */
    String consumedBy(Actor actor);
}
