
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author: Naveen Pentela <pent0020@flinders.edu.au>
 * College of Science and Engineering, Flinders University
 * Copyright (C) 2023, All Rights Reserved
 */

public class VirtualZoo {

    private final Scanner scan;
    private static ArrayList<String> usedNames = new ArrayList<>();// animals names are stored in this array list
    private static int Total_Cost;// this variable is for total cost of the zoo

    public VirtualZoo() {
        scan = new Scanner(System.in);
    }

    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    //pre-existed welcome message to display

    private void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|   Use this application to simulate running a zoo with many animals   |");
        System.out.println("|           This program is intended for zoo employees only            |");
        System.out.println("+----------------------------------------------------------------------+");
    }

    private int Num_of_Animals() {

        int num_Animals; //this func prompts number of animals in the zoo using while loop

        while (true) {
            System.out.println("How many animals are at your zoo?");
            String input = scan.nextLine();

            try {

                num_Animals = Integer.parseInt(input);//string value converted to int
            } catch (NumberFormatException e) { // prompts user to enter valid number if integer is invalid
                System.out.println("Please enter a valid number of animals");
                continue;
            }


            if (num_Animals <= 0) {
                System.out.println("Please enter a positive number of animals");//prompts user to enter positive number if he enter a negetive int
                continue;
            }
            System.out.println();
            break;// breaks the loop here
        }

        return num_Animals;
    }


    private String Animal_Name(int id) {
        String animal_Name; // stores the animal name using while loop

        while (true) {
            System.out.println("What is the name of animal #" + id + "?");
            animal_Name = scan.nextLine();

            // compares with the list if the name already exists if it does then it give below output
            if (usedNames.contains(animal_Name)) {
                System.out.println("That name is already taken");
                continue;
            }

            usedNames.add(animal_Name);//adds if the name is different from the list
            break;
        }


        return animal_Name;
    }

    private Animal askAnimalSpecies(String name) {

        String species; // stores the list of species

        while (true) {
            System.out.println("What is the species of " + name + "?");// prompts the user to enter a species from pre-existed list
            species = scan.nextLine();

            // compare with the list of species if it matches then it stores with the matched species name
            switch (species.toLowerCase()) {
                case "tiger":
                    return new Tiger(name, "Tiger");
                case "elephant":
                    return new Elephant(name, "Elephant");
                case "rhino":
                    return new Rhino(name, "Rhino");
                case "panda":
                    return new Panda(name, "Panda");
                case "monkey":
                    return new Monkey(name, "Monkey");
                default: //if either of those above names does not match with input then it display not valid msg
                    System.out.println("That is not a valid species");
            }
        }
    }

    public ArrayList<Animal> animalSelection() {


        int numAnimals = Num_of_Animals();//function to prompt user to enter num of animals in zoo


        ArrayList<Animal> animals = new ArrayList<>();//collects and stores animal list
        for (int i = 1; i <= numAnimals; i++) {
            String name = Animal_Name(i);//func to prompt animal name
            Animal animal = askAnimalSpecies(name);// func to prompt user to specify animal species
            animals.add(animal);//adds the return name to the list
        }

        return animals;
    }

    public static int getTotalCost() {
        return Total_Cost;
    }

    public static void setTotalCost(int totalCost) {
        VirtualZoo.Total_Cost = totalCost;
    }

    private boolean isValidItem(String item){
        boolean valid = false;
        String[] items = {"Food", "Water", "Toy"};//list of valid items that can be taken to give to animals

        for (String validItem : items) {
            if (item.equalsIgnoreCase(validItem))// checks whether the input is from the list above
                valid = true;
        }
        return valid;
    }

    public void askItem(Animal animal) {
        String name = animal.getName();
        while (true) {
            System.out.println("What item would you like to give to " + name + "?");
            String item = scan.nextLine().trim().toLowerCase();

            boolean isLastItem = item.equalsIgnoreCase(animal.getLastItem());//compares whether the current item is same as last given item

            if (!isValidItem(item))
                System.out.println("That is not a valid item");//displays to user invalid msg if the user provides different item from list
            else if (isLastItem)
                System.out.println("You cannot give the same item as yesterday");//displays msg if the item is same as last item
            else {
                animal.setLastItem(item);
                if (item.equals("food")) {
                    animal.giveFood();
                } else if (item.equals("water")) {
                    animal.giveWater();
                } else if (item.equals("toy")) {
                    animal.giveToy();
                }
                break;
            }
        }
        if (animal.isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.printf("%s has died%n", name);//prints has died msg along with animal name
        }
    }

        public void weekCycle(ArrayList<Animal> zooAnimals) {

            String[] items = {"Food", "Water", "Toy"};
            String[] recentItems = new String[zooAnimals.size()];
            int currentDay = 1;

            while (currentDay <= 7) {
                System.out.println("\nThe current day is " + Day_Name(currentDay) + "\n");

                for (Animal animal : zooAnimals)
                    System.out.println(animal.toString());

                for (Animal animal : zooAnimals) {
                    if (!animal.isDead()) {
                        askItem(animal);
                    }
                }
                currentDay++;
            }

            System.out.println("");
            System.out.println("Total week cost = $" + getTotalCost());
        }

        public static String Day_Name(int day) {
            switch (day) {
                case 1:
                    return "Monday";
                case 2:
                    return "Tuesday";
                case 3:
                    return "Wednesday";
                case 4:
                    return "Thursday";
                case 5:
                    return "Friday";
                case 6:
                    return "Saturday";
                case 7:
                    return "Sunday";
                default:
                    return "";
            }
        }

}
