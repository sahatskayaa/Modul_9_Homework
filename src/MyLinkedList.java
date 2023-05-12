import java.util.Objects;

public class MyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        static class Node<T> {
                T element;
                Node<T> next;

                public Node(T element) {
                        this.element = element;
                }
        }

        public void add(T element) {
                Node<T> newNode = new Node<>(element);
                if (head == null) {
                        head = tail = newNode;
                } else {
                        tail.next = newNode;
                        tail = newNode;
                }
                size++;
        }

        private Node<T> getNodeByIndex(int index) {
                Node<T> current = head;
                for (int i = 0; i < index; i++) {
                        current = current.next;
                }
                return current;
        }

        public T get(int index) {
                Objects.checkIndex(index, size);
                return getNodeByIndex(index).element;
        }
        public T remove(int index) {
                Objects.checkIndex(index, size);
                T deletedElem;

                if (index == 0) {
                        deletedElem = head.element;
                        head = head.next;
                        if (head == null) {
                                tail = null;
                        }
                } else {
                        Node<T> prev = getNodeByIndex(index - 1);
                        deletedElem = prev.next.element;
                        prev.next = prev.next.next;
                        if (index == size - 1) {
                                tail = prev;
                        }
                }
                size--;
                return deletedElem;
        }

        public int size() {
                return size;
        }

        public void clear() {
                head = tail = null;
                size = 0;
        }
        public void print() {
                Node temp = head;
                while (temp != null) {
                        System.out.println(temp.element);
                        temp = temp.next;
                }
        }

        public static void main(String[] args) {
                MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
                myLinkedList.add(1);
                myLinkedList.add(2);
                myLinkedList.add(3);
                myLinkedList.remove(2);
                myLinkedList.print();
                System.out.println("myLinkedList.size() = " + myLinkedList.size());
                System.out.println("myLinkedList.get(2) = " + myLinkedList.get(1));
                myLinkedList.clear();
                System.out.println("myLinkedList.size() = " + myLinkedList.size());
        }
}