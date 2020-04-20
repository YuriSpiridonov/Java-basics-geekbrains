public class playWithAnimal {
    public static void main(String[] args){
        Cat cat = new Cat ("Barsik", 201, 5, 500); //задаем имя кота и нормативы к выполнению
        Dog dog = new Dog ( "Sharick", 505, 12,9); //задаем имя сабаки и нормативы к выполнению

        // если хотим проверить созданного кота с желаемыми характеристикми
        System.out.println("swim: " + cat.canRun(cat.run));
        System.out.println("swim: " + cat.canJump(cat.jump));
        System.out.println("swim: " + cat.canSwim(cat.swim)); // не успел разобраться с тем чтобы было сообщение "Извините, не умею плавать", а не просто фолс.
        // если хотим проверить случайную характеристику абстрактного кота
        System.out.println("run: " + cat.canRun(201));
        System.out.println("jump: " + cat.canJump(1));
        System.out.println("swim: " + cat.canSwim(1));
        // если хотим проверить созданной собаки с желаемыми характеристикми
        System.out.println("run: " + dog.canRun(dog.run));
        // если хотим проверить случайную характеристику абстрактного пса
        System.out.println("jump: " + dog.canJump(0.3));
        System.out.println("swim: " + dog.canSwim(1));
    }

}
