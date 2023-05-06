// https://stackoverflow.com/questions/33186650/input-string-and-int-in-the-same-line
import java.util.Scanner;

public class p10845 {
    public static void main(String[] args) {
        // 명령의 수 N (1 ≤ N ≤ 10,000)를 입력받는다
        Scanner sc = new Scanner(System.in);
        long numberOfCommands = sc.nextInt();
        // 엔터 키(\n)를 건너 뛴다
        sc.nextLine();

        String[] command;
        int inputNumber;
        Queue queue = new Queue();

        // push 10과 같은 입력 String을 받는다
        String inputString;
        // 엔터 키(\n)를 건너 뛴다
        inputString = sc.nextLine();

        // inputString을 command와 숫자로 분류한다
        command = inputString.split("(?<=\\D)(?=\\d)");
        System.out.println(command[0]);

        if(inputString.length() == 1)
            System.out.println("Null!");

    }
}

class Queue {
    private int[] elements;
    private int size;

    // queue의 처음과 마지막
    private int front, rear;

    public Queue() {
        front = -1;
        rear = -1;
    }

    // 정수 X를 큐에 넣는 연산
    public void push(int value) {
        elements[++rear] = value;
    }

    // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int pop() {
        return elements[++front];
    }

    // 큐에 들어있는 정수의 개수를 출력
    public int size() {
        this.size = front - rear;
        return this.size;
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
        if(this.empty() == 1) {
            return -1;
        }
        else
            return this.front;

    }

    // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
    public int back() {
        if(this.empty() == 1) {
            return -1;
        }
        else
            return this.rear;
    }



}
