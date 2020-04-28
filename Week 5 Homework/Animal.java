public abstract class Animal {
    protected String name;
    protected double hunger;
    protected boolean isHungry = true;

    public abstract boolean isCatHungry(double hunger);

    public Animal(String name, double hunger, boolean isHungry) {
        this.name = name;
        this.hunger = hunger;
        this.isHungry = isHungry;
    }

    public void animalInfo() {
        System.out.println("Animal: "+name+" hunger "+hunger);
    }
    public String getName(){
        return this.name;
    }
    public double getHunger(){
        return this.hunger;
    }
}
