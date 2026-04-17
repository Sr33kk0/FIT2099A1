package items;

/**
 * Class which stores the data of a flashlight
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class FlashLight extends Item
{
    /**
     * Default constructor which creates the object of the class FlashLight
     */
    public FlashLight()
    {
        super("Unknown", 2);
        this.addCapability(Ability.ILLUMINATOR);
    }

    /**
     * Non-default constructor which creates the object of the class FlashLight
     *
     * @param brand     The bottle brand name as a string
     * @param weight    The bottle weight as a double
     */
    public FlashLight(String brand, double weight)
    {
        super(brand, weight);
        this.addCapability(Ability.ILLUMINATOR);
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the flashlight as a string
     */
    public String toString()
    {
        return String.format("%s (%s) has weight of %.2f kg -" +
                " to emit light.", this.getClass().getSimpleName(), getBrand(),
                getWeight());
    }
}
