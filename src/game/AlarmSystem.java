package game;

import java.util.ArrayList;
import java.util.List;

public class AlarmSystem implements AlarmStatus
{
    private static final int ALARM_DURATION_TURNS = 40;

    private boolean active = false;
    private int turnsRemaining = 0;
    private PressurePlate triggerPlate;
    private final List<AlarmAffected> affected = new ArrayList<>();

    public void register(AlarmAffected object)
    {
        affected.add(object);
    }

    public boolean isActive()
    {
        return active;
    }

    public void trigger(PressurePlate plate)
    {
        if (active)
        {
            return;
        }
        active = true;
        turnsRemaining = ALARM_DURATION_TURNS;
        triggerPlate = plate;
        for (AlarmAffected object : affected)
        {
            object.onAlarmStart();
        }
    }

    public void tick(PressurePlate plate)
    {
        if (!active || plate != triggerPlate)
        {
            return;
        }
        turnsRemaining--;
        if (turnsRemaining <= 0)
        {
            active = false;
            triggerPlate = null;
            for (AlarmAffected object : affected)
            {
                object.onAlarmEnd();
            }
        }
    }

    @Override
    public boolean alarmActive()
    {
        return active;
    }
}
