import java.util.*;

/**
 * Клас, який відповідає за реалізацію
 * колекції, реалізуючи інтерфейс Set,
 * перевизначаючи його методи. Внутрішня
 * структура колекції - двозв'язний список
 *
 * @param <E> тип елементів, що зберігаються в цьому наборі
 */
public class CustomCoffeeSet<E> implements Set<E> {

    // Клас Node для двозв'язного списку.
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    // Порожній конструктор
    public CustomCoffeeSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Конструктор, в який передається один об'єкт
     *
     * @param element екземпляр класу Coffee
     */
    public CustomCoffeeSet(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, в який передається стандартна коллекція об'єктів
     *
     * @param collection коллекція екземплярів класу Coffee
     */
    public CustomCoffeeSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.data, element)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object element) {
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.data, element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Object[] result = a;
        for (Node<E> current = head; current != null; current = current.next) {
            result[index++] = current.data;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    public static void searchByQualityRange(CustomCoffeeSet<Coffee> coffeeSet, int minQuality, int maxQuality) {
        System.out.println("Кава з якістю в межах [" + minQuality + ", " + maxQuality + "]:");
        for (Coffee coffee : coffeeSet) {
            if (coffee.getQuality() >= minQuality && coffee.getQuality() <= maxQuality) {
                System.out.println(coffee);
            }
        }
    }

    public static void sortByPriceWeight(CustomCoffeeSet<Coffee> coffeeSet) {
        List<Coffee> coffeeList = new ArrayList<>();
        for (Coffee coffee : coffeeSet) {
            coffeeList.add(coffee);
        }
        coffeeList.sort(Comparator.comparingDouble(coffee -> coffee.getPricePerWeight()));

        System.out.println("\nКава, відсортована за співвідношенням ціни до ваги:");
        for (Coffee coffee : coffeeList) {
            System.out.println(coffee);
        }
    }
}