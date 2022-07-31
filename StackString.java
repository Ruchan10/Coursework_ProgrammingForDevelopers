package CourseWork;

public class StackString {
    String stack0[];
    int top = -1;
    int size;

    StackString(int size) {
        this.size = size;
        stack0 = new String[size];
    }

    public boolean push(String data) {
        if (top == size - 1) {
            System.out.println("StackOverFlow");
            return false;
        }
        stack0[++top] = data;
        return true;
    }

    public String pop() {
        if (top == -1) {
            System.out.println("StackEmpty");
            return "false";
        }
        return stack0[top--];
    }

    public static void main(String[] args) {
        StackString ss = new StackString(5);
        ss.push("Ruchan");
        ss.push("kayastha");
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }
}
