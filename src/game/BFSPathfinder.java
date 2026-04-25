package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public final class BFSPathfinder {
    private BFSPathfinder() {}

    /**
     * @param map Map the actors are in.
     * @param actor the moving actor.
     * @param start the actor's current location.
     * @param goal  the target location.
     * @return a list of shortest path to target or an empty list if no path exists.
     *
     * Based On:
     * <a href="https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/">...</a>, 24/4/2026
     * <a href="https://www.baeldung.com/java-breadth-first-search">...</a>, 24/4/2026
     *
     */
    public static List<Location> findPath(GameMap map, Actor actor, Location start, Location goal) {
        if (start == goal) {
            return Collections.singletonList(start);
        }

        Map<Location, Location> parent = new HashMap<>();
        Set<Location> visited = new HashSet<>();
        Deque<Location> queue = new ArrayDeque<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty())
        {
            Location current = queue.poll();

            for (Exit exit : current.getExits())
            {
                Location next = exit.getDestination();
                if (visited.contains(next))
                {
                    continue;
                }
                boolean passable = (next == goal) || next.canActorEnter(actor);
                if (!passable)
                {
                    continue;
                }
                visited.add(next);
                parent.put(next, current);
                if (next == goal)
                {
                    return reconstruct(parent, start, goal);
                }
                queue.add(next);
            }
        }
        return Collections.emptyList();
    }

    private static List<Location> reconstruct(Map<Location, Location> parent, Location start, Location goal)
    {
        List<Location> path = new ArrayList<>();
        Location cursor = goal;
        while (cursor != null)
        {
            path.add(cursor);
            if (cursor == start)
            {
                break;
            }
            cursor = parent.get(cursor);
        }
        Collections.reverse(path);
        return path;
    }
}