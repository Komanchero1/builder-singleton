import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    //ссылка на единственный объект класса
    private static Logger logger;
    //переменная для нумерации логгера
    protected int num = 1;

    //приватный конструктор чтобы нельзя было изменить объект
    private Logger() {
    }


    //метод для формирования и форматирования строки логгера
    public void log(String msg) {
        //создаем объект  типа SimpleDateFormat  с заданным форматом даты и времени
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        //создаем строку с заданым форматом даты и времени
        String timestamp = sdf.format(new Date());
        //сформированное сообщение логера
        System.out.println("[" + timestamp + "  " + num + "]" + msg);
        //увеличиваем счетчик сообщения
        num++;
    }

    //метод для получения объекта
    public static Logger getInstance() {
        //если ссылка ссылается на пустой объект
        if (logger == null) {
            logger = new Logger();// то создаем объект
        }
        return logger;
    }
}
