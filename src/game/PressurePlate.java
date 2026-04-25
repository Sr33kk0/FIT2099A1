package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class PressurePlate extends Ground
{
    private final AlarmSystem alarmSystem;

    public PressurePlate(AlarmSystem alarmSystem)
    {
        super('✩', "Pressure Plate");
        this.alarmSystem = alarmSystem;
    }

    public void tick(Location location)
    {
        Actor actor = location.getActor();
        if (actor != null && actor.hasAbility(EntityType.WORKER) && !alarmSystem.isActive())
        {
            alarmSystem.trigger(this);
        }
        alarmSystem.tick(this);
    }
}
