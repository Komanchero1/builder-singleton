import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;// переменная для хранения порога для фильтрации списка

    //конструктор
    public Filter(int treshold) {
        this.treshold = treshold;
    }

    //метод для отфильтровывания списка по заданному порогу
    public List<Integer> filterOut(List<Integer> sourse) {
        //// создаем объект logger через вызов метода getInstance
        Logger logger = Logger.getInstance();
        //пустой список для хранения отфильтрованных данных
        List<Integer> result = new ArrayList<>();
        for (Integer num : sourse) { //перебираем список с ранндомными числами
            if (num >= treshold) { //проверяем по условию подходит или нет
                result.add(num); //добавляем в список
                //логгируем добавление элемента
                logger.log("Элемент  " + num + " проходит");
            } else {
                //логируем что элемент не проходит
                logger.log("Элемент  " + num + " не  проходит");
            }
        }
        //логгируем результат сколько элементов прошло сколько не прошло
        logger.log("Прошло фильтр  " + result.size() + " элемента из  " +
                sourse.size());
        return result;
    }
}
