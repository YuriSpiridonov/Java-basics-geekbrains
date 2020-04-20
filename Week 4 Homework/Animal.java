public abstract class Animal {
    protected String name;
    protected double jump;
    protected int run;
    protected int swim;

    public abstract boolean canRun(int run);
    public abstract boolean canJump(double jump);
    public abstract boolean canSwim(int swim);

    public Animal(){ //konstructor
    }
    public Animal(String name) {
        this.name = name;
    }
    public void animalInfo() {
        System.out.println("Animal: "+name);
    }
}
