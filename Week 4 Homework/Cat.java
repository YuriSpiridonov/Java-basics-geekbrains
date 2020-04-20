public class Cat extends Animal {
    protected int runDistance = 200;
    protected double jumpHeight = 2.0;
    protected int SwimDistance = -1;

    public Cat (String _name, int _run, double _jump, int _swim){
        this.name = "untitled";
        this.run = _run;
        this.jump = _jump;
        this.swim = _swim;

    }
    public Cat (int run, double jump) {
    }
    public boolean canRun(int run){
        return run <= runDistance ? true : false;
    }
    public boolean canJump(double jump){
        return jump <= jumpHeight ? true : false;
    }
    public boolean canSwim(int swim){
        return swim <= SwimDistance ? true : false;
    }

}
