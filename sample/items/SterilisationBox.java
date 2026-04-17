package items;

/**
 * Class which stores the data of a sterilisation box
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class SterilisationBox extends Item
{
    /**
     * Default constructor which creates the object of the class SterilisationBox
     */
    public SterilisationBox()
    {
        super("Unknown", 5);
        this.addCapability(Ability.STERILISE);
    }

    /**
     * Non-default constructor which creates the object of the class SterilisationBox
     *
     * @param brand     The bottle brand name as a string
     * @param weight    The bottle weight as a double
     */
    public SterilisationBox(String brand, double weight)
    {
        super(brand, weight);
        this.addCapability(Ability.STERILISE);
    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the sterilisation box as a string
     */
    public String toString()
    {
        return String.format("%s (%s) has weight of %.2f kg -" +
                " to sterilise food.", this.getClass().getSimpleName(),
                getBrand(), getWeight());
    }
}
