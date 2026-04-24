package game;

import edu.monash.fit2099.engine.actors.Actor;

public interface Consumable
{
    String consumedBy(Actor actor);
    String menuDescription(Actor actor);
    boolean isFullyConsumed();
}
