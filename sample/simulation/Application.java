package simulation;

/**
 * Main driver class for the simulation.Moon exploration simulation
 *
 * @author Ho Shou Yee
 * @version ver1.0.0
 */
public class Application
{
    public static void main(String[] args)
    {
        Moon moon = new Moon();
        while (moon.getCrewMember().isConscious())
        {
            moon.simulate();
        }
        System.out.println("\nGame over - " + moon.getCrewMember().getName() + " is unconscious");
    }
}