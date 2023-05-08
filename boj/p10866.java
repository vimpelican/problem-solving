import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

// 제출 시 Main으로 이름 변경
public class p10866 {
    public static void main(String[] args) {
        // 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.

        // 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
        // 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

    }

}

class Deque {
    private LinkedList<Integer> elements;
    private int sizeOfElements;

    Deque() {
        this.sizeOfElements = 10001;
        elements = new LinkedList<Integer>();
    }

    public static void push_front() {
        // push_front X: 정수 X를 덱의 앞에 넣는다.
    }

    public static void push_back() {
        // push_back X: 정수 X를 덱의 뒤에 넣는다.
    }

    public static int pop_front() {
        // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    }

    public static int pop_back() {
        // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    }

    public static int size() {
        // size: 덱에 들어있는 정수의 개수를 출력한다.
    }

    public static int empty() {
        // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    }

    public static int front() {
        // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    }

    public static int back() {
        // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    }
}