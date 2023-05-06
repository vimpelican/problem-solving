// https://stackoverflow.com/questions/33186650/input-string-and-int-in-the-same-line
import java.util.Scanner;
import java.util.ArrayList;

public class p10845 {
    public static void main(String[] args) {
        // 명령의 수 N (1 ≤ N ≤ 10,000)를 입력받는다
        Scanner sc = new Scanner(System.in);
        int numberOfCommands = sc.nextInt();
        // 엔터 키(\n)를 건너 뛴다
        sc.nextLine();

        // push 10과 같은 입력 String을 받는다
        String inputString;

        // inputString == inputCommand + inputNumber
        String[] inputCommand;
        int inputNumber;
        Queue myQueue = new Queue(numberOfCommands);

        for(int i = 0; i < numberOfCommands; i++) {
            // 매 루프마다 string을 입력받는다
            inputString = sc.nextLine();
            // inputString을 command와 숫자로 분류한다
            inputCommand = inputString.split("(?<=\\D)(?=\\d)");

            // push는 int 값을 같이 가지고, 나머지 명령어는 없다
            // int 값을 가지게 되면 길이가 2, 나머지는 길이가 1
            if(inputCommand.length == 2) {
                inputNumber = Integer.parseInt(inputCommand[1]);
                myQueue.push(inputNumber);
                continue;
            }
            // switch-case를 이용해 분기를 나눈다
            switch(inputCommand[0]) {
                case "pop":
                    myQueue.pop();
                    break;
                case "size":
                    myQueue.size();
                    break;
                case "empty":
                    myQueue.empty();
                    break;
                case "front":
                    myQueue.front();
                    break;
                case "back":
                    myQueue.back();
                    break;
            }
        }
        myQueue.printOutput();
    }
}

class Queue {
    private int[] elements;
    private int capacity;
    private int sizeOfQueue;
    private ArrayList<Integer> output = new ArrayList<Integer>();

    private int front, rear;

    public Queue(int i) {
        this.front = 0;
        this.rear = 0;
        this.capacity = i;
        elements = new int[this.capacity];
    }

    public void push(int value) {
        elements[rear] = value;
        rear++;
    }

    public void pop() {
        if(this.isEmpty())
            output.add(-1);
        else {
            output.add(elements[front]); 
            front++;
        }  
    }

    public void size() {
        this.sizeOfQueue = rear - front;
        output.add(sizeOfQueue);
    }

    public boolean isEmpty() {
        if(this.rear == this.front)
            return true;
        else
            return false;
    }

    public void empty() {
        if(this.isEmpty())
            output.add(1);
        else
            output.add(0);
    }

    public void front() {
        if(this.isEmpty())
            output.add(-1);
        else
            output.add(elements[this.front]);

    }

    public void back() {
        if(this.isEmpty())
            output.add(-1);
        else
            output.add(rear);
    }

    public void printOutput() {
        for(int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}
