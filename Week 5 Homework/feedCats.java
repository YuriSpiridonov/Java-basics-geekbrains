import java.util.concurrent.TimeUnit;

public class feedCats {

    public static void main(String[] args) throws InterruptedException {

        Cat[] Cats = new Cat[10];

        Cats[0] = new Cat("Bob", 10, true); // можно поставить фолс, но пока кот не поест будет тру,
        Cats[1] = new Cat("Mew", 5, true); // условие задачи выполняется, кот голоден при создании
        Cats[2] = new Cat("Marsel", 10, true);
        Cats[3] = new Cat("Grimson", 8, true);
        Cats[4] = new Cat("Musia", 12, true);
        Cats[5] = new Cat("Natasha", 4, true);
        Cats[6] = new Cat("Igor", 7, true);
        Cats[7] = new Cat("Tigra", 9, true);
        Cats[8] = new Cat("Pussycat", 15, true);
        Cats[9] = new Cat("Bo", 10, true); //90

        double foodInBowl = 33;
        Bowl newBowl = new Bowl(foodInBowl);

        System.out.println("In bowl " + newBowl.isBowlFull());

        for (int i =0; i < Cats.length; i++){
            if (newBowl.Size == 0 ){
                System.out.println("Bowl is empty!");
                TimeUnit.SECONDS.sleep(3);
                newBowl.fillBowl(foodInBowl);
                System.out.println("Bowl filled! In bowl "+ newBowl.Size);
            }
            else if (newBowl.Size < Cats[i].hunger){
                System.out.println("Not enough food for "+Cats[i].name);
                TimeUnit.SECONDS.sleep(3);
                newBowl.fillBowl(foodInBowl);
                System.out.println("Bowl filled! In bowl "+ newBowl.Size);
            }

            if (Cats[i].isHungry == true) {
                TimeUnit.SECONDS.sleep(1);
                //Bowl.Size = Bowl.Size - Cats[i].getHunger();
                newBowl.Size = newBowl.Size - Cats[i].getHunger();
                Cats[i].isHungry = false;
                System.out.println(Cats[i].name + " ate " + Cats[i].hunger);
                System.out.println("In bowl " + newBowl.Size);
            }
            else {
                System.out.println(Cats[i].name + " is not hungry!");
            }
        }
        for (int i = 0; i < Cats.length; i++){
            if (Cats[i].isHungry == false) {
                System.out.println(Cats[i].name + " is not hungry!");
            }
            else{
                System.out.println(Cats[i].name + " is hungry!");
            }
        }
    }
}
