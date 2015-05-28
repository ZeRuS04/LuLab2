import java.util.Random;
import static java.lang.Thread.sleep;

/**
 * Created by Admi on 28.05.2015.
 */
public class TicketMachine {
    private int _MT;
    public int _currentTicket = 0;
    private Window _win;

    public TicketMachine(int MT, Window win) {
        _MT = MT;
        _win = win;
    }

    public synchronized int getTicket(){        //Получение номерка
        if(_currentTicket > _MT)                // Проверяем не кончилась ли бумага
            _currentTicket = 0;                     //Если кончилась, устанавливаем новый рулон

        _win.addNewNumber(++_currentTicket);        //Сообщаем дисплею над окном, о том что появился новый номерок
        Random rand = new Random();
        try {
            sleep(150);
        }catch (InterruptedException e){
            return _currentTicket;
        }
        return _currentTicket;                      // печатаем номерок
    }

}
