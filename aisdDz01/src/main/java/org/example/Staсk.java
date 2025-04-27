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
    private int size = 0;


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
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
