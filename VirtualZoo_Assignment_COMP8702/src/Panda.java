

/**
 * @author Naveen Pentela,
 * St id:- 2293004
 * FAN:-pent0020
 */
public class Panda extends Animal{

    // creating panda class using constructor with name and its species
    public Panda(String name, String species) {
        super(name, species);
    }

    @Override
    public void giveFood() {
        // using boolean method reducing hunger by 25 or else to 0 if the hunger is already low
        if(hunger > 25)
            hunger -= 25;
        else
            hunger = 0;

        // updating thirst and boredom by increasing 15
        thirst += 15;
        boredom += 15;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 60);//calculating total cost by addition giving food to panda
    }

    @Override
    public void giveWater() {
        // updating hunger by adding 40points
        hunger += 40;
        // using boolean method updating thirst and boredom
        if(thirst > 80)
            thirst -= 80;
        else
            thirst = 0;

        boredom += 10;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);//calculating total cost by addition giving water to panda
    }

    @Override
    public void giveToy() {
        //updating hunger thirst and boredom after giving toy
        hunger += 40;
        thirst += 15;
        if(boredom > 40)
            boredom -= 40;
        else
            boredom = 0;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 10);//calculating total cost by addition giving toy to panda
    }
}
