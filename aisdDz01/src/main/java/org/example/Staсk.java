package org.example;



public class Staсk<T> implements StaсkImpl<T> {
    class Node{
        T values;
        Node next;
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }
    private Node head;
    private int size;


    public Staсk(){
        this.head = new Node();
    }

    public Node findLast(){
        Node last = head;

        while (last.next != null){
            last = last.next;
        }
        return last;
    }

    @Override
    public void add(T x) {
        if (head == null) {
            head.values = x;
            return;
        }
        Node newLast = new Node();
        Node last = findLast();
        newLast.values = x;
        last.next = newLast;
        size++;
    }

    @Override
    public void add(T x, int i) throws IndexOutOfBoundsException {
        if(i > size() - 1 || i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;

        Node newN = new Node();
        int count = 1;
        while (count != i){
            current = current.next;
            ++count;
        }
        newN.values = x;
        newN.next = current.next;
        current.next = newN;
        size++;
    }




    public void remove()  {
        Node last = head;
        if (last.next == null){
            last = null;
            return;
        }
        while(last.next.next != null){
            last = last.next;
        }
        last.next = null;
        size--;
    }

    @Override
    public T get() {
        return findLast().values;
    }

    @Override
    public void clear() {
        head.next = null;
    }

    @Override
    public int size() {
        return size;
    }
    //по индексу
    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        if(i > size() - 1 || i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Node current = head.next;
        int count = 0;
        while (count != i - 1 & current.next != null){
            current = current.next;
            ++count;
        }
        return (T)(current.values);
    }



    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node last = head.next;
        if (last == null){
            return "";
        }
        while(last.next != null){
            stringBuilder.append(last.values).append(", ");
            last = last.next;
        }
        stringBuilder.append(last.values).append("");;
        return stringBuilder.toString();

    }





}
