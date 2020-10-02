public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String address;

    public PersonBuilder () {
        age = -1;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build(){
        if (name == null) {
            throw new IllegalStateException("Не указано имя");
        } else if (surname == null) {
            throw new IllegalStateException("Не указана фамилия");
        }
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}
