package aiproject2;

public class PriorityList {

    state first;
    int size = 0;

    public void insert(state s) {
        size++;

        if (first == null) {
            first = s;
            return;
        }
        if (s.f() < first.f()) {
            state temp = s;
            temp.next = first;
       
            first = temp;
       
            return;
        }
        state current = first;
        while (current.next != null && current.next.f() < s.f()) {
            current = current.next;
        }
        state temp = s;
        temp.next = current.next;
      
        current.next = temp;


    }

    public state del() {
        size--;
        state temp = first;
        first = first.next;

        return temp;
    }

    public PriorityList(int m[][]) {
        first = new state(m);
        first.parent=null;
    }
}
