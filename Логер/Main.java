import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // создаем объект через вызов метода getInstance
        Logger logger = Logger.getInstance();
        //создаем сканер
        Scanner scanner = new Scanner(System.in);
        //логгируем запуск программы
        logger.log("Запускаем программу");
        //логгируем общение с пользователем
        logger.log("Просим пользователя ввести входные данные для создания списка");
        System.out.println("Введите размер списка: ");
        //считываем данные с консоли и заносим в переменную
        int listSize = scanner.nextInt();
        System.out.println("Введите верхнюю границу значений:  ");
        //считываем данные с консоли и заносим в переменную
        int limit = scanner.nextInt();
        //создаем пустой список
        List<Integer> list = new ArrayList<>();
        //генератор случайных чисел для заполнения списка list
        Random random = new Random();

        //заполняем список случайными числами
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(limit + 1));
        }
        //логгируем создание и наполнение списка
        logger.log("Создаем и наполняем список");
        //логгируем готовый список
        logger.log("Вот случайный список:  " + list.toString());
        //логгируем общение с пользователем
        logger.log("Просим пользователя ввести данные для фильтрации");
        System.out.println("Введите порог для фильтра:  ");
        //считываем данные с консоли и заносим в переменную
        int bound = scanner.nextInt();
        //создаем объект класса Filter
        Filter filter = new Filter(bound);
        //создаем список для хранения отфильтрованных данных из списка list
        List<Integer> filteredList = filter.filterOut(list);
        //логгируем вывод на экран отфильтрованного списка
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список:  " + filteredList.toString());
        //логгируем завершение программы
        logger.log("Завершаем программу");
    }
}
