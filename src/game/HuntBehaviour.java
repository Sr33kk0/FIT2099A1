package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.behaviours.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

/**
 * While the facility alarm is active, moves the actor one step along the BFS
 * shortest path toward the nearest reachable worker. Returns {@code null} when
 * the alarm is inactive or no worker is reachable, allowing a lower-priority
 * {@link WanderBehaviour} to take over.
 *
 * <p>Priority-wise this sits between {@code AttackBehaviour} (1) and
 * {@code WanderBehaviour} (3): if the hostile is already adjacent to a worker,
 * the attack still wins.</p>
 */
public class HuntBehaviour implements Behaviour<Actor, Action>
{
    private final AlarmStatus alarmStatus;

    public HuntBehaviour(AlarmStatus alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }

    @Override
    public Action operate(Actor actor, Location here)
    {
        if (!alarmStatus.alarmActive())
        {
            return null;
        }

        GameMap map = here.map();
        List<Location> bestPath = null;

        for (int x : map.getXRange())
        {
            for (int y : map.getYRange())
            {
                Location loc = map.at(x, y);
                Actor other = map.getActorAt(loc);
                if (other == null || !other.hasAbility(EntityType.WORKER))
                {
                    continue;
                }
                List<Location> path = BFSPathfinder.findPath(map, actor, here, loc);
                if (path.size() < 2)
                {
                    continue;
                }
                if (bestPath == null || path.size() < bestPath.size())
                {
                    bestPath = path;
                }
            }
        }

        if (bestPath == null)
        {
            return null;
        }

        Location next = bestPath.get(1);
        for (Exit exit : here.getExits())
        {
            if (exit.getDestination() == next)
            {
                return next.getMoveAction(actor, "toward worker", exit.getHotKey());
            }
        }
        return null;
    }
}