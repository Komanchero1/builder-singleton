
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    //возраст будем хранить в виде объекта
    // это удобно когда возраст неизвестен
    private OptionalInt age;
    private String address;

    //конструктор с двумя параметрами
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        //присваиваем  переменной значение пустого объекта
        this.age = OptionalInt.empty();
        //инициализируем переменную если адрес известен
        this.address = "";
    }

    //конструктор с тремя параметрами
    public Person(String name, String surname, int age) throws IllegalAccessException {
        this.name = name;
        this.surname = surname;
        //проверяем возраст
        if (age >= 0) {
            //передаем значение переменной age  в объект OptionalInt
            this.age = OptionalInt.of(age);
        } else {
            //если меньше "0" выбрасывается исключение
            throw new IllegalAccessException("Не корректный возраст");
        }
        this.address = "";
    }

    //проверяем известен возраст или нет
    public boolean hasAge() {
        //возвращает если объект пустой false или наоборот true
        return age.isPresent();
    }

    //проверяем адрес возвращает true или false
    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    //устанавливаем адрес
    public void setAddress(String address) {
        this.address = address;
    }

    //увеличиваем возраст на 1
    public void happyBirthday() {
        //если возраст известен
        if (hasAge()) {
            //метод getAsInt вызывает значение из OptionalInt
            // затем увеличиваем его на единицу и возвращаем
            // измененное значение п OptionalInt
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    //переопределяем метод toString()
    @Override
    public String toString() {
        return " имя : " + name + "\n" +
                "фамилия : " + surname + "\n" +
                //если возраст известен, то возвращаем значение
                // из OptionalInt если нет "неизвестен"
                "возраст : " + (age.isPresent() ? age.getAsInt() : " неизвестен") + "\n" +
                //если адрес известен, то возвращаем значение address если нет "неизвестен"
                "адрес : " + (hasAddress() ? address : " неизвестен");
    }

    @Override
    //генерируем уникальный хеш код
    public int hashCode() {
        //так как у на 2 не изменяемых переменных используем их
        //применяем побитовый оператор сравниваем каждую пару битов
        // один бит хеш кода name и другой бит хеш кода surname по парно
        // если биты равны то возвращается '0' или наоборот '1'  в результате
        // по окончании сравнивания получаем уникальный хеш код объекта
        return name.hashCode() ^ surname.hashCode();
    }

    //метод для создания и настройки объекта PersonBuilder
    public PersonBuilder newChildBuilder() {
        //создаем новый объект
        return new PersonBuilder()
                //у которого будет имя
                .setName(name)
                //фамилия
                .setSurname(surname)
                //неизвестный возраст
                .setAge(0);
    }
}
