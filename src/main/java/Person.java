public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age != -1;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        return personBuilder.setSurname(surname).setAddress(address);
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public void happyBirthday() {
        age++;
    }

    public boolean setAge(int age) {
        if (this.hasAge()) {
            return false;
        } else if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else {
            this.age = age;
            return true;
        }
    }

    @Override
    public String toString() {
        return name + ' ' + surname;
    }
}
