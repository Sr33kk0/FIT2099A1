package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.behaviours.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;
import java.util.TreeMap;

public class Slime extends Actor {
    private final Map<Integer, Behaviour<Actor, Action>> behaviours = new TreeMap<>();

    public Slime()
    {
        super("Slime", '⍾', 25, new BasicInventory());
        behaviours.put(1, new ConsumeBehaviour());
        behaviours.put(2, new WanderBehaviour());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display)
    {
        for (Behaviour<Actor, Action> behaviour : behaviours.values())
        {
            Action action = behaviour.operate(this, map.locationOf(this));
            if (action != null)
            {
                return action;
            }
        }
        return new DoNothingAction();
    }
}