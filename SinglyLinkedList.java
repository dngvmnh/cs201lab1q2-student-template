public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk.getNext() != null) {
                sb.append(", ");
            }
            walk = walk.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public E removeLast(){
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        }
        Node<E> walk = head;
        while (walk.getNext() != tail) {
            walk = walk.getNext();
        }
        E answer = tail.getElement();
        walk.setNext(null);
        tail = walk;
        size--;
        return answer;
    }

    public void reverse(){       
        if (size <= 1) {
            return;
        }
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        tail = head;                 

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;                 
    }
}