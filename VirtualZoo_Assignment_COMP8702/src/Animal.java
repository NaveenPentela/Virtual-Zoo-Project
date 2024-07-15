
/**
 * @author Naveen Pentela,
 * St id:- 2293004
 * FAN:-pent0020
 */

public abstract class Animal{

    //we use "protected" access modifier below in-order to access them in this particular class
    protected String Animal_name; // specifies animal name
    protected String Animal_species; // specifies animal belong to what species
    protected int hunger = 50; // specifies the hunger level
    protected int thirst = 50; // specifies the thirst level
    protected int boredom = 50; // specifies the boredom level

    String End_Item_Type; // specifies the final item given to animal

    // we create constructors in order to initialize the objects with their names and species type
    public Animal(String name, String species) {
        this.Animal_name = name;
        this.Animal_species = species;
    }
    public String getLastItem() {
        return End_Item_Type;
    }// we use get() method to return end-item type

    public void setLastItem(String lastItem) {
        this.End_Item_Type = lastItem;
    }//using set method for end-item type

    public String getName() {
        return Animal_name;
    }//using get method for animal name
    public void setName(String name) {
        this.Animal_name = name;
    }//using set method for animal name
    public String getSpecies() {
        return Animal_species;
    }// same methods for species
    public void setSpecies(String species) {
        this.Animal_species = species;
    }
    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
    public int getBoredom() {
        return boredom;
    }
    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }
    // using boolean data type to print animal is dead/alive by either true or false
    public  boolean isDead(){
        if((boredom > 100) || (hunger > 100) || (thirst > 100))
            return true;
        else
            return false;
    }

    // for printing the animal object we use toString method
    public String toString()
    {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }
    public abstract void giveFood();// using abstract method in-order to give food to animal
    public abstract void giveWater();//same method applied here to give water
    public abstract void giveToy();// abstract method to give toy
}