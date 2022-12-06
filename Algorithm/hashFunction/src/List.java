class Link {
    private int iData;
    public Link next;

    public Link(int it)                 // Конструктор
    {
        iData = it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink()           // Вывод содержимого элемента
    {
        System.out.print(iData + " ");
    }
}

class SortedList {
    private Link first;               // Ссылка на первый элемент списка

    public void SortedList()          // Конструктор
    {
        first = null;
    }

    public void insert(Link theLink)  // Вставка в порядке сортировки
    {
        int key = theLink.getKey();
        Link previous = null;          // Начиная с первого элемента
        Link current = first;
        // До конца списка
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = theLink;
        else
            previous.next = theLink;
        theLink.next = current;
// Или пока current <= key
// Переход к следующему элементу
// В начале списка
// first --> новый элемент
// Не в начале
// prev --> новый элемент
// новый элемент --> current
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;
// Удаление элемента
// (предполагается, что список не пуст)
// Начиная с первого элемента
        // До конца списка
        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            first = first.next;
// или пока key != current
// Переход к следующему элементу
        else
            if (current.next != null && previous.next != null)
            System.out.println("\tcurrent.previous friend : " + previous.getKey() + " \tcurrent.next friend : " + current.next.getKey());
            else System.out.println("\tIt has not current.next");

        previous.next = current.next; // удалить текущий элемент
    }

    public Link find(int key) {
// Поиск элемента с заданным ключом
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                if (current.next != null) {
                    System.out.println("it's friend to right side [current.next]: " + current.next.getKey());
                } else System.out.println("It's last element in List");
                return current;
            }
            current = current.next;
        }
        return null;
// или пока ключ не превысит current,
        // Искомый элемент?
// Совпадение обнаружено
// Переход к следующему элементу
// Элемент не найден
    }

    public void displayList() {
        System.out.print("List (first -> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;  // Переход к следующему элементу
        }
        System.out.println("");
    }
}