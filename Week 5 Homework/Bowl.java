public class Bowl {
    static double foodInBowl;// = 35;
    public static double Size = foodInBowl;

    public Bowl(double foodInBowl) {
        this.Size = foodInBowl;
    }

    public static double fillBowl(double foodInBowl) {
        //Size = Size + foodInBowl; //если хотим к остаткам добавить весь объем миски
        Size = foodInBowl;
        return Size;
    }

    public static double isBowlFull() {
        return Size;
    }
}
