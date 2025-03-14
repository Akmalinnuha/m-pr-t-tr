import java.util.*;

class Node {
    public Node(char data) {
        this.data = data;
    }

    char data;
    Node next;
}

class Stack {
    Node bottom;
    Node top;
    int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public int length() {
        return size;
    }

    public void push(char inp) {
        Node newNode = new Node(inp);
        if(isEmpty()){
            bottom=top=newNode;
        }else{
            top.next = newNode;
            top = newNode;
        }
        size++;
    }

    public Character pop() {
        if (isEmpty()) {
            return null;
        }

        Character poppedData = top.data;

        if (bottom == top) {
            bottom = top = null;
        } else {
            Node p = bottom;
            while (p.next != top) {
                p = p.next;
            }
            top = p;
            top.next = null;
        }

        size--;
        return poppedData;
    }

    public Character peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }
}

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        Stack parenthesses = new Stack();
        
        for (char c : command.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                parenthesses.push(c);
            } else {
                if (parenthesses.isEmpty() || 
                   (c == ')' && parenthesses.peek() != '(') || 
                   (c == '}' && parenthesses.peek() != '{') || 
                   (c == ']' && parenthesses.peek() != '[')) {
                    break;
                } else parenthesses.pop();
            }
        }
        System.out.println(parenthesses.isEmpty());
        sc.close();
    }
}
