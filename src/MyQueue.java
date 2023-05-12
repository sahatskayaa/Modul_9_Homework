public class MyQueue<E> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public E peek() {
        if (first == null) {
            return null;
        }
        E element = first.element;
        return element;
    }

    public E poll() {
        if (first == null) {
            return null;
        }
        E element = first.element;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return element;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.print();
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
        myQueue.clear();
        System.out.println("myQueue.size() = " + myQueue.size());

    }
}
