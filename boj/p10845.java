// https://stackoverflow.com/questions/33186650/input-string-and-int-in-the-same-line
import java.util.Scanner;

public class p10845 {
    public static void main(String[] args) {
        // 명령의 수 N (1 ≤ N ≤ 10,000)를 입력받는다
        Scanner sc = new Scanner(System.in);
        long numberOfCommands = sc.nextInt();
        // 엔터 키(\n)를 건너 뛴다
        sc.nextLine();

        // push 10과 같은 입력 String을 받는다
        String inputString;

        // inputString == inputCommand + inputNumber
        String[] inputCommand;
        int inputNumber;
        Queue myQueue = new Queue();

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
                    System.out.println(myQueue.pop());
                    break;
                case "size":
                    System.out.println(myQueue.size());
                    break;
                case "empty":
                    System.out.println(myQueue.empty());
                    break;
                case "front":
                    System.out.println(myQueue.front());
                    break;
                case "back":
                    System.out.println(myQueue.back());
            }
        }
    }
}

class Queue {
    private int[] elements;
    private int capacity;
    private int sizeOfQueue;

    // queue의 처음과 마지막
    private int front, rear;

    public Queue() {
        this.front = 0;
        this.rear = 0;
        this.capacity = 10;
        elements = new int[capacity];
    }

    // 정수 X를 큐에 넣는 연산
    public void push(int value) {
        elements[rear] = value;
        rear++;
    }

    // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int pop() {
        if(this.empty() == 1)
            return -1;
        int temp = elements[front];        
        front++;
        return temp;
    }

    // 큐에 들어있는 정수의 개수를 출력
    public int size() {
        this.sizeOfQueue = rear - front;
        return this.sizeOfQueue;
    }

    // 큐가 비어있으면 1, 아니면 0을 출력
    public int empty() {
        if(this.rear == this.front)
            return 1;
        else
            return 0;
    }

    // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int front() {
        if(this.empty() == 1)
            return -1;
        else
            return elements[this.front];

    }

    // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int back() {
        if(this.empty() == 1)
            return -1;
        else
            return this.rear;
    }
}
