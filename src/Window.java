import java.util.LinkedList;
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 * Created by Admi on 28.05.2015.
 */
public class Window {
    private Integer _numberOnDisplay = -1;
    private LinkedList<Integer> _numbers;
    public Window() {
        _numbers = new LinkedList<>();
    }
    public synchronized void getService(){                      // Получение услуги
        Random rand = new Random();

        try {
            sleep(50+rand.nextInt(500));
        }catch (InterruptedException e){
            return;
        }
        synchronized (_numberOnDisplay) {
            if (_numbers.isEmpty()) {                                  //Если есть еще люди в очереди вызовем
                _numberOnDisplay = -1;
            } else {
                System.out.print("Display:" + _numbers.getFirst());
                System.out.println();
                _numberOnDisplay = _numbers.poll();
            }
        }
    }
    public void addNewNumber(int num){                          // получение от билетной машины информации о еще одном посетителе
        synchronized (_numberOnDisplay) {
            if (_numberOnDisplay == -1) {
                System.out.print("Display:" + num);
                System.out.println();
                _numberOnDisplay = num;

            } else
                _numbers.add(num);
        }
    }

    public int Display(){
        return _numberOnDisplay;
    }
}
