
/*
 * Author: Naveen Pentela <pent0020@flinders.edu.au>
 * College of Science and Engineering, Flinders University
 * Copyright (C) 2023, All Rights Reserved
 */

public class Elephant extends Animal{

    // creating elephant class using constructor with name and its species
    public Elephant(String name, String species) {
        super(name, species);
    }

    @Override
    public void giveFood() {
        // using boolean operator updating hunger,thirst and boredom with conditions
        if(hunger > 50)
            hunger -= 50;
        else
            hunger = 0;

        thirst += 30;
        boredom += 20;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100);// calculating total cost by addition of food to elephant
    }
    @Override
    public void giveWater() {
        //updating hunger,thirst and boredom after giving water
        hunger += 20;
        if(thirst > 50)
            thirst -= 50;
        else
            thirst = 0;
        boredom += 30;

        // calculating total cost by giving water to elephant
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }

    @Override
    public void giveToy() {
        //updating hunger,thirst and boredom after giving toy
        hunger += 30;
        thirst += 10;
        if(boredom > 40)
            boredom -= 40;
        else
            boredom = 0;

        // add whole cost of after giving toy to elephant
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 75);
    }
}
