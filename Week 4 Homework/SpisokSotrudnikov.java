public class SpisokSotrudnikov {
    public static void main(String args[]){
        /*
        Unit Unit1 = new Unit();
        Unit1.name = "Bob";
        Unit1.surname = "Bobbers";
        Unit1.position = "Uborschik";
        Unit1.email = "uborschik_bob@companyname.com";
        Unit1.phone = 2133434559;
        Unit1.salary = 0;
        Unit1.age = 40;
        */

        Unit Unit2 = new Unit("Bo", "Macduglas", "Pomoschnik uborschika", "bo@sdfsdf.com", 666, -1, 12);
        Unit Unit3 = new Unit("Yo", "One", "Rukoboditel uborschika", "Yo@google.com", 666-2312-123-2, 300, 30);
        Unit Unit4 = new Unit("Ho", "Two", "Nastavnik uborschika", "ho@yahoo.com", 2342000030L, 12, 22);
        Unit Unit5 = new Unit("Vo", "D.", "Cadovod", "vo@kukareku.com", 213-23-5-3422, 25, 56);
        Unit Unit6 = new Unit("Mo", "Ron", "Toje ne poslednii chelovek", "Mo@site.com", 888_5454_45453L, 1000, 44);
/*
        System.out.println(Unit2.getFullInfo());
        System.out.println(Unit6.getFullInfo());
        System.out.println(Unit5.getName());
        System.out.println(Unit5.getAge());
*/
        Unit[] unitArray = new Unit[5];
        unitArray[0] = Unit2;
        unitArray[1] = Unit6;
        unitArray[2] = Unit5;
        unitArray[3] = new Unit("Duglas", "Bublas","Spyder-monkey", "spyder_monkey@positions.com", 89534324, 320, 70);
        unitArray[4] = new Unit("Goliy", "Mujik","Prodavec", "goliymujic@mail.ru", 567676567, 500, 30);

        //System.out.println(unitArray[0].getAge());
        //System.out.println(unitArray[4].getFullInfo());

        for (int i = 0; i < unitArray.length; i++){
            if (unitArray[i].getAge() > 40){
                System.out.println(unitArray[i].getFullInfo());
            }
        }
    }
}
