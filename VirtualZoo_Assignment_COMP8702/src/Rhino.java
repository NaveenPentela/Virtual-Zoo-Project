
/**
 * @author Naveen Pentela,
 * St id:- 2293004
 * FAN:-pent0020
 */
public class Rhino extends Animal{

    // creating Rhino class using constructor with name and its species
    public Rhino(String name, String species) {
        super(name, species);
    }

    @Override
    public void giveFood() {
        // using boolean method reducing hunger by 25 or else to 0 if the hunger is already low
        if(hunger > 25)
            hunger -= 25;
        else
            hunger = 0;

        thirst += 5;
        boredom += 25;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);//calculating total cost by addition giving food to Rhino
    }

    @Override
    public void giveWater() {
        hunger += 5;

        // using boolean method updating thirst
        if(thirst > 25)
            thirst -= 25;
        else
            thirst = 0;
        boredom += 25;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);//calculating total cost by addition giving water to Rhino
    }

    @Override
    public void giveToy() {
        // updating hunger and thirst
        hunger += 20;
        thirst += 20;

        // using boolean method updating boredom
        if(boredom > 50)
            boredom -= 50;
        else
            boredom = 0;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);//calculating total cost by addition giving toy to Rhino
    }
}
