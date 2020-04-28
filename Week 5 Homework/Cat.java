public class Cat extends Animal{
    protected boolean isHungry = true;
    public Cat (String name, int hunger, boolean isHungry){
        super(name, hunger, isHungry);
    }

    public boolean isCatHungry(double hunger){
        return hunger == 0 ? true : false;
    }
}
