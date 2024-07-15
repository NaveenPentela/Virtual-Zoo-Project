

/**
 * @author Naveen Pentela,
 * St id:- 2293004
 * FAN:-pent0020
 */
public class Monkey extends Animal{

    // creating monkey class using constructor with name and its species
    public Monkey(String name, String species) {
        super(name, species);
    }
    @Override
    public void giveFood() {
        // using boolean operator updating hunger
        if(hunger > 30)
            hunger -= 30;
        else
            hunger = 0;
        //updating thirst and boredom
        thirst += 10;
        boredom += 10;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5); // calculating total cost by giving food to monkey
    }

    @Override
    public void giveWater() {
        //updating hunger,thirst and boredom after giving water
        hunger += 10;

        if(thirst > 40)
            thirst -= 40;
        else
            thirst = 0;

        boredom += 10;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);// calculating total cost by giving water to monkey
    }

    @Override
    public void giveToy() {
        //updating hunger,thirst and boredom after giving toy
        hunger += 10;

        thirst += 10;

        if(boredom > 15)
            boredom -= 15;
        else
            boredom = 0;

        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);// calculating total cost by giving toy to monkey
    }
}
