import java.util.StringJoiner;
    public class MyHashMap<T, V> {

        private static class Node<K, E> {
            K key;
            E value;
            Node<K, E> next;

            public Node( K key, E value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node<T, V>[] table;
        private static final int DEFAULT_CAPACITY = 10;
        private int size;

        public MyHashMap(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException();
            }
            table = new Node[capacity];
        }

        public MyHashMap() {
            this(DEFAULT_CAPACITY);
        }

        private int hash(T key) {
            return hashCode() % table.length;
        }

        public void put(T key, V value) {
            int element = hash(key);
            Node<T, V> node = table[element];
            Node<T, V> newNode = new Node<>(key, value);

            if (node == null) {
                table[element] = newNode;
            } else {
                Node<T, V> prev = node;
                while (node != null) {
                    if (key == null || node.key.equals(key)) {
                        node.value = value;
                    }
                    prev = node;
                    node = node.next;
                }
                prev.next = newNode;
            }
            size++;
        }

        public V remove(T key) {
            int element = hash(key);
            Node<T, V> node = table[element];

            if (node != null) {
                if (key == null || node.key.equals(key)) {
                    table[element] = node.next;
                    size--;
                    return node.value;
                }
                while (node.next != null) {
                    if (node.next.key.equals(key)) {
                        node.next = node.next.next;
                        size--;
                        return node.value;
                    }
                    node = node.next;
                }
            }
            return null;
        }

        public void clear() {
            size = 0;
            table = new Node[DEFAULT_CAPACITY];
        }

        public int size() {
            return size;
        }

        public V get(T key) {
            int element = hash(key);
            Node<T, V> node = table[element];

            while (node != null) {
                if (key == null || node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        @Override
        public String toString() {
            StringJoiner builder = new StringJoiner(" ");
            for (Node node : table) {
                Node n = node;
                while (n != null) {
                    builder.add("{key:" + n.key + ",value:" + n.value + "}");
                    n = n.next;
                }
            }
            return builder.toString();
        }

        public static void main(String[] args) {
            MyHashMap<String, String> countries = new MyHashMap<> () ;
            countries.put ("Kyiv", "Ukraine");
            countries.put ("Berlin", "Germany");
            countries.put ("Paris", "France" );
            countries.put ("Warsaw", "Poland");
            System.out.println("countries = " + countries);
            System.out.println(countries.get("Praga"));
            System.out.println (countries.size());
            countries.remove ("Paris");
            System.out.println("countries = " + countries);
            System.out.println("countries.size() = " + countries.size());
            countries.clear();
        }
}
