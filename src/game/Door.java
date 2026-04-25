package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Its primary purpose in the universe is to halt the progress of underpaid
 * {@code ContractedWorker}s until they can produce the correct rectangular
 * piece of plastic.
 */
public class Door extends Ground implements AlarmAffected{
    boolean isUnlocked = false;
    boolean alarmLocked = false;

    public Door(AlarmSystem alarmSystem)
    {
        super('=', "Door");
        alarmSystem.register(this);
    }

    /**
     * if the door is unlocked, any actor can step into the door
     * @param actor the Actor to check
     * @return true if the door is unlocked, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return isUnlocked && !alarmLocked;
    }

    public void onAlarmStart()
    {
        this.alarmLocked = true;
    }
    public void onAlarmEnd()
    {
        this.alarmLocked = false;
    }
}
