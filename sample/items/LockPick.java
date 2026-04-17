package items;

/**
 * Class which stores the data of lock pick
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class LockPick extends Item
{
    /**
     * Default constructor which creates the object of the class LockPick
     */
    public LockPick()
    {
        super("Unknown", 0.1);
        this.addCapability(Ability.UNLOCK);
    }

    /**
     * Non-default constructor which creates the object of the class LockPick
     *
     * @param brand     The bottle brand name as a string
     * @param weight    The bottle weight as a double
     */
    public LockPick(String brand, double weight)
    {
        super(brand, weight);
        this.addCapability(Ability.UNLOCK);

    }

    /**
     * Method to return the all the information, formatted appropriately
     *
     * @return  The information of the lock pick as a string
     */
    public String toString()
    {
        String output;

        if (this.hasCapability(Ability.UNLOCK))
        {
            output = String.format("%s (%s) has weight of %.2f kg - to unlock door/treasure box.",
                    this.getClass().getSimpleName(), getBrand(), getWeight());
        }
        else
        {
            output = String.format("Broken %s (%s) has weight of %.2f kg - scrap metal.",
                    this.getClass().getSimpleName(), getBrand(), getWeight());
        }

        return output;
    }
}
