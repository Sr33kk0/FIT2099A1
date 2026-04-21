package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.statistics.BaseStatistic;

public class Lantern extends Item
{
    private int fuelRemaining = 10;
    public Lantern()
    {
        super("Lantern", '&');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(7));
    }

    public void tick(Location currentLocation, Actor actor)
    {
        if (fuelRemaining > 0 && Math.random() < 0.05)
        {
            fuelRemaining--;
            currentLocation.setGround(new Fire());
        }
    }
}
