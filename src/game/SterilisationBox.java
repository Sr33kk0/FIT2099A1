package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.statistics.BaseStatistic;

public class SterilisationBox extends Item
{
    public SterilisationBox()
    {
        super("Sterilisation Box", '▣');
        this.addNewStatistic(ItemStatistics.WEIGHT, new BaseStatistic(7));
        this.enableAbility(WorkerAbility.STERILISE);
    }
}
