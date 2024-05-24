public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    //заполняем поле age объекта PersonBuilder значением
    // которое принимает метод setAge
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    //тоже с полем address
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    //тоже с полем name
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    //тоже с полем surname
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    //метод создает экземпляр класса Person  на основе данных
    // установленных выше указанными методами
    public Person build() throws IllegalAccessException {
        //проверяем что имя и фамилия заданы
        if (name == null || surname == null) {
            //если нет выбрасываем исключение
            throw new IllegalStateException("Не корректное имя ,фамилия");
        }
        //проверяем что возраст не отрицательный
        if (age < 0) {
            //если да то выбрасываем исключение
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        //если возраст равен "0"
        if (age == 0) {
            //создаем экземпляр класса Person c двумя параметрами
            return new Person(name, surname);
        } else {
            //если больше нуля создаем экземпляр класса Person c использованием
            // конструктора с тремя параметрами
            return new Person(name, surname, age);
        }
    }

}
