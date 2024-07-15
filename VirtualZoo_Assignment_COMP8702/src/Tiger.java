
/**
 * @author Naveen Pentela,
 * St id:- 2293004
 * FAN:-pent0020
 */
public class Tiger extends Animal {

    // creating Tiger class using constructor with name and its species
    public Tiger(String name, String species) {
        super(name, species);
    }

    @Override
    public void giveFood() {
        // using boolean method reducing hunger by 30 or else to 0 if the hunger is already low
        if(hunger > 30)
            hunger -= 30;
        else
            hunger = 0;

        // updating thirst and boredom
        thirst += 15;
        boredom += 15;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);//calculating total cost by addition giving food to Tiger
    }

    @Override
    public void giveWater() {
        hunger += 15;

        // updating thirst by reducing 30 or else to 0 if it is less than 30
        if(thirst > 30)
            thirst -= 30;
        else
            thirst = 0;

        boredom += 15;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);//calculating total cost by addition giving water to Tiger
    }

    @Override
    public void giveToy() {
        // updating hunger and thirst
        hunger += 15;
        thirst += 15;

        // updating boredom using boolean method
        if(boredom > 30)
            boredom -= 30;
        else
            boredom = 0;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);//calculating total cost by addition giving toy to Tiger
    }
}
