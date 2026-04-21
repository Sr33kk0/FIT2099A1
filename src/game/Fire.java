package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Fire extends Ground
{
    private int turnsRemaining = 5;

    public Fire ()
    {
        super('^', "Fire");
    }

    public void tick(Location location)
    {
        Actor actor = location.getActor();
        if (actor != null && !actor.hasStatus(OnFireStatus.class))
        {
            actor.addStatus(new OnFireStatus(1, 5));
        }
        turnsRemaining--;
        if (turnsRemaining == 0)
        {
            location.setGround(new Dirt());
        }
    }
}
