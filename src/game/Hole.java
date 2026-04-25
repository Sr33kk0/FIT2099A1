package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class Hole extends Ground
{
    private static final int SPAWN_INTERVAL = 20;
    private int turnCount = 0;
    private final Random random = new Random();
    private final AlarmStatus alarmStatus;

    public Hole(AlarmStatus alarmStatus) {
        super('o', "Hole");
        this.alarmStatus = alarmStatus;
    }

    @Override
    public void tick(Location location)
    {
        turnCount++;
        if (turnCount % SPAWN_INTERVAL == 0 && !location.containsAnActor())
        {
            Actor creature = random.nextBoolean() ? new Undead(alarmStatus) : new Slime();
            try
            {
                location.addActor(creature);
            } catch (Exception ignored){}
        }
    }
}