package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.statistics.BaseStatistic;

public class FloppyDisk extends Item
{
    public FloppyDisk()
    {
        super("FloppyDisk", '⊟');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(1));
    }
}
