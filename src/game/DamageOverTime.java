package game;

import edu.monash.fit2099.engine.GameEntity;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorStatistics;
import edu.monash.fit2099.engine.capabilities.Status;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.statistics.StatisticOperations;

public abstract class DamageOverTime implements Status
{
    private final int damage;
    private int turnsRemaining;

    public DamageOverTime(int damage, int turns)
    {
        this.damage = damage;
        this.turnsRemaining = turns;
    }

    public void tickStatus(GameEntity currEntity, Location location)
    {
        currEntity.modifyStatistic(ActorStatistics.HEALTH, StatisticOperations.DECREASE, damage);
        turnsRemaining--;
    }

    public boolean isStatusActive()
    {
        return turnsRemaining > 0;
    }
}
