public class Unit {
    String name;
    String surname;
    String position;
    String email;
    long phone;
    int salary;
    int age;

    public Unit(String _name, String _surname, String _position, String _email, long _phone, int _salary, int _age){
        name = _name;
        surname = _surname;
        position = _position;
        email = _email;
        phone = _phone;
        salary = _salary;
        age = _age;
    }
    public String getFullInfo(){
        String fullInfo = "Unit " + this.surname + this.name + " position " + this.position + " email " + this.email + " phone " + this.phone + " salary " + this.salary + " age " + this.age + ".";
        return fullInfo;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getPosition(){
        return this.position;
    }
    public String getEmail(){
        return this.email;
    }
    public long getPhone(){
        return this.phone;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getAge(){
        return this.age;
    }


}
