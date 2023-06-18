import java.util.Iterator;

public class dz_3 {

  public static void main(String[] args) {
    SingleLinkList<Teachers> TeachersList = new SingleLinkList<>();

    TeachersList.addToEnd(new Teachers(1, "Аленков Сергей Владимирович", "алгебра"));
    TeachersList.addToEnd(new Teachers(2, "Бугаев Александр Михайлович", "физика"));
    TeachersList.addToEnd(new Teachers(3, "Клиторович Анна Петровна", "химия"));
    TeachersList.addToEnd(new Teachers(4, "Иванова Инна Васильевна", "информатика"));
    TeachersList.addToEnd(new Teachers(5, "Левашева Татьяна Ивановна", "экономика"));

    for (Object Teachers : TeachersList) {
      System.out.println(Teachers);
    }
    TeachersList.reverse();

    System.out.println("-------------------------------------");

    for (Object Teachers : TeachersList) {
      System.out.println(Teachers);
    }
  }

  static class Teachers {

    int id;
    String name;
    String lesson
    ;

    public Teachers(int id, String name, String lesson
    ) {
      this.id = id;
      this.name = name;
      this.lesson
       = lesson
      ;
    }

    @Override
    public String toString() {
      return "Teachers{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", lesson='" + lesson
           + '\'' +
          '}';
    }
  }


  /**
   * Класс списка
   *
   * @param <T>
   */
  public static class SingleLinkList<T> implements Iterable {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator iterator() {
      return new Iterator<T>() {
        ListItem<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          T data = current.data;
          current = current.next;
          return data;
        }
      };
    }

    /**
     * Класс отдельного элемента
     *
     * @param <T>
     */
    private static class ListItem<T> {

      T data;
      ListItem<T> next;
    }

        public boolean isEmpty() {
      return head == null;
    }

        public void addToEnd(T item) {

    
      ListItem<T> newItem = new ListItem<>();
      newItem.data = item;

    
      if (isEmpty()) {
        head = newItem;
        tail = newItem;
      } else { 
        tail.next = newItem;
        tail = newItem;
      }
    }

    //метод разворота списка
    public void reverse() {
      if (!isEmpty() && head.next != null) {
        tail = head;
        ListItem<T> current = head.next;
        head.next = null;
        while (current != null) {
          ListItem<T> next = current.next;
          current.next = head;
          head = current;
          current = next;
        }
      }
    }
  }
}