package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import javax.swing.*;

public class DrinkAction extends Action
{
    public DrinkAction()
    {

    }

    public String execute(Actor actor, GameMap map)
    {
        String result;
        if (actor.hasAbility(WorkerAbility.STERILISE))
        {
            actor.heal(1);
            result = actor + " drinks purified puddle water and heals 1 HP.";
        }
        else
        {
            actor.addStatus(new PoisonStatus(1, 3));
            result = actor + " drinks toxic puddle water and is poisoned for 3 turns.";
        }
        return result;
    }

    public String menuDescription(Actor actor) {
        return actor + " drinks from the puddle.";
    }
}
