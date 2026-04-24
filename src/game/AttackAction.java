package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Class representing an action to attack Note that the attacker must have a
 * weapon, e.g., an intrinsic weapon or a weapon item. Otherwise, the execute
 * method will throw an error.
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Ho Shou Yee
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private final Actor target;

    /**
     * The direction of incoming attack.
     */
    private final String direction;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only
     * used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor.getIntrinsicWeapon().attack(actor, target, map);
        if (!target.isConscious())
        {
            result += "\n" + target.unconscious(actor, map);
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + actor.getIntrinsicWeapon();
    }
}
