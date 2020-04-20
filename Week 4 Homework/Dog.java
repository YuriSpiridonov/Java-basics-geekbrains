public class Dog extends Animal {
    protected int runDistance = 500;
    protected double jumpHeight = 0.5;
    protected int SwimDistance = 10;

    public Dog(String _name, int _run, double _jump, int _swim) {
        this.name = "untitled";
        this.run = _run;
        this.jump = _jump;
        this.swim = _swim;
        //Animal catRun = new this.canRun();

    }

    public Dog(int _run, double _jump) {
    }

    public boolean canRun(int run) {
        return run < runDistance ? true : false;
    }

    public boolean canJump(double jump) {
        return jump < jumpHeight ? true : false;
    }

    public boolean canSwim(int swim) {
        return swim < SwimDistance ? true : false;
    }
}
