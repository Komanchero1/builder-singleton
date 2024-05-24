import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            //создаем объект класса PersonBuilder
            Person mom = new PersonBuilder()
                    .setName("Анна") //задаем необходимые данные для полей
                    .setSurname("Вольф")//то же . . .
                    .setAge(31)//то же . . .
                    .setAddress("Сидней")//то же . . .
                    .build();//метод для создания объекта персон с присвоенными данными
            //создаем объект класса персон который является дочерним объектом  объекта mom
            //  вызов метода newChildBuilder возвращает новый экземпляр PersonBuilder
            //  который наследует данные родительского объекта
            Person son = mom.newChildBuilder()
                    .setName("Антошка")//задаем необходимые данные для полей
                    //создается новый объект  son класса Person  с наследованной фамилией
                    .build();
            //выводим в консоль созданные объекты
            System.out.println("У " + mom + " \nесть сын, \n" + son);

            // Проверка на отсутствие обязательных полей
            try {
                new PersonBuilder().build();
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            // Проверка на некорректный возраст
            try {
                new PersonBuilder().setAge(-100).build();
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}