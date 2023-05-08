import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

// 제출 시 Main으로 이름 변경
public class p10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.

        // 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
        // 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfCommands = Integer.parseInt(br.readLine());

        Deque myDeque = new Deque();

        for(int i = 0; i < numberOfCommands; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inputString = st.nextToken();

            switch(inputString) {
                case "push_front" :
                    myDeque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    myDeque.push_back((Integer.parseInt(st.nextToken())));
                    break;
                case "pop_front" :
                    sb.append(myDeque.pop_front()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(myDeque.pop_back()).append("\n");
                    break;
                case "size" :
                    sb.append(myDeque.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(myDeque.empty()).append("\n");
                    break;
                case "front" :
                    sb.append(myDeque.front()).append("\n");
                    break;
                case "back" :
                    sb.append(myDeque.back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

}

class Deque {
    private static LinkedList<Integer> elements;
    //private int sizeOfElements;
    private static int temp;

    Deque() {
        //this.sizeOfElements = 10001;
        elements = new LinkedList<Integer>();
    }

    public void push_front(int input) {
        // push_front X: 정수 X를 덱의 앞에 넣는다.
        elements.addFirst(input);
    }

    public void push_back(int input) {
        // push_back X: 정수 X를 덱의 뒤에 넣는다.
        elements.addLast(input);
    }

    public int pop_front() {
        // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(elements.isEmpty())
            return -1;
        else {
            temp = elements.getFirst();
            elements.removeFirst();
            return temp;
        }
    }

    public int pop_back() {
        // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(elements.isEmpty())
            return -1;
        else {
            temp = elements.getLast();
            elements.removeLast();
            return temp;
        }
    }

    public int size() {
        // size: 덱에 들어있는 정수의 개수를 출력한다.
        return elements.size();
    }

    public int empty() {
        // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
        if(elements.isEmpty())
            return 1;
        return 0;
    }

    public int front() {
        // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(elements.isEmpty())
            return -1;
        return elements.getFirst();
    }

    public int back() {
        // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(elements.isEmpty())
            return -1;
        return elements.getLast();
    }
}