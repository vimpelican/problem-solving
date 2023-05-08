// https://stackoverflow.com/questions/33186650/input-string-and-int-in-the-same-line
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10845 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 명령의 수 N (1 ≤ N ≤ 10,000)를 입력받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCommands = Integer.parseInt(br.readLine());

        // push 10과 같은 입력 String을 받는다
        String inputString;

        // inputString == inputCommand + inputNumber
        String[] inputCommand;
        int inputNumber;
        Queue myQueue = new Queue(numberOfCommands);

        for(int i = 0; i < numberOfCommands; i++) {
            // 매 루프마다 string을 입력받는다
            inputString = br.readLine();
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
                    myQueue.printSize();
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
    }
}

class Queue {
    private int[] elements;
    private int capacity;
    private int sizeOfQueue;

    private int front, rear;
    private BufferedWriter bw;

    public Queue(int i) {
        this.front = 0;
        this.rear = 0;
        this.capacity = i;
        this.sizeOfQueue = 0;
        elements = new int[this.capacity];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void push(int value) {
        elements[rear] = value;
        rear++;
    }

    public void pop() throws IOException {
        if(this.isEmpty()) {
            bw.write(Integer.toString(-1));
            bw.newLine();
            bw.flush();
        }
        else {
            bw.write(Integer.toString(elements[front]));
            bw.newLine();
            bw.flush();
            front++;
        }  
    }

    public int checkSize() {
        this.sizeOfQueue = rear - front;
        return sizeOfQueue;
    }

    public void printSize() throws IOException {
        bw.write(Integer.toString(checkSize()));
        bw.newLine();
        bw.flush();
    }

    public boolean isEmpty() {
        if(this.rear == this.front)
            return true;
        else
            return false;
    }

    public void empty() throws IOException {
        if(this.isEmpty()) {
            bw.write(Integer.toString(1));
            bw.newLine();
            bw.flush();
        }
        else {
            bw.write(Integer.toString(0));
            bw.newLine();
            bw.flush();
        }
    }

    public void front() throws IOException {
        if(this.isEmpty()) {
            bw.write(Integer.toString(-1));
            bw.newLine();
            bw.flush();
        }
        else {
            bw.write(Integer.toString(elements[this.front]));
            bw.newLine();
            bw.flush();
        }

    }

    public void back() throws IOException {
        if(this.isEmpty()) {
            bw.write(Integer.toString(-1));
            bw.newLine();
            bw.flush();
        }
        else {
            bw.write(Integer.toString(elements[this.rear - 1]));
            bw.newLine();
            bw.flush();
        }
    }
}
