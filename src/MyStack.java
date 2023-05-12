public class MyStack<T> {
    private int size;
    private Object[] array;
    private int top;

    public MyStack(int s) {
        size = s;
        array = new Object[size];
        top = -1;
    }

    public void push(T element) {
        int i = ++top;
        array[i] = element;
    }

    public T remove(int index) {
        if (array == null || index < 0 || index >= size) {
            return (T) array;
        }
        Object[] result = new Object[size - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, size - index -1);
        size--;
        array = result;
        return (T) array;
    }

    public void clear() {
        size = 0;
        array = null;
    }

    public int  size() {
        return size;
    }

    public T peek() {
        if (top == -1) {
            return null;
        } else {
            return (T) array[top];
        }
    }

    public T pop() {
        if (top == -1) {
            return null;
        } else {
            size--;
            return (T) array[top--];
        }
    }
    public void print() {
        for (Object elem : array) {
            System.out.print(elem + " ");
        }
    }
    
    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.print();
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack.size() = " + myStack.size());
        myStack.remove(3);
        myStack.print();
        myStack.clear();
        System.out.println("myStack.size() = " + myStack.size());
    }
}
