import java.util.LinkedList;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Admi on 28.05.2015.
 */
public class Window {
    private int _numberOnDisplay = -1;
    private LinkedList<Integer> _numbers;

    public Window() {
        _numbers = new LinkedList<>();

    }
    public synchronized void getService(){                      // ��������� ������
        Random rand = new Random();

        try {
            sleep(50+rand.nextInt(500));
        }catch (InterruptedException e){
            return;
        }

        if(_numbers.isEmpty())                                  //���� ���� ��� ���� � ������� �������
            _numberOnDisplay = -1;
        else{
            System.out.print("Display:" + _numbers.getFirst());
            System.out.println();
            _numberOnDisplay = _numbers.poll();
        }
    }
    public void addNewNumber(int num){                          // ��������� �� �������� ������ ���������� � ��� ����� ����������
        if(_numberOnDisplay == -1) {
            System.out.print("Display:" + num);
            System.out.println();
            _numberOnDisplay = num;

        }
        else
            _numbers.add(num);
    }

    public int Display(){
        return _numberOnDisplay;
    }
}
