import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Admi on 28.05.2015.
 */
public class Programm {

    public static void main(String[] args) {
        Window win = new Window();
        TicketMachine tm = new TicketMachine(31, win);
        for (int i = 0; i < 50; i++){
            Consumer cons = new Consumer(tm, win);
            Random rand = new Random();
            cons.start();
            try {
                sleep(50 + rand.nextInt(100));
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
