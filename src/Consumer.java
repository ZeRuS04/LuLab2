/**
 * Created by Admi on 28.05.2015.
 */
public class Consumer extends Thread {

    private TicketMachine _tm;
    private Window _win;
    private int _ticket;

    public Consumer( TicketMachine tm, Window win) {
        _tm = tm;
        _win = win;
    }

    @Override
    public void run() {
        _ticket = _tm.getTicket();          // Получить номерок
        System.out.print("New Consumer." + this.getName() + " Ticket:" + _ticket);
        System.out.println();

        while(_win.Display() != _ticket){   //Переодически посматриваем на дисплей, не появлися ли наш номер
            yield();
        }

        System.out.print("Consumer " + this.getName() + ". It's my Number!");
        System.out.println();
        _win.getService();          // Получить услугу
    }
}
