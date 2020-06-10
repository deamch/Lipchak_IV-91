package lab7;

import lab6.Stones;

import java.util.*;

public class MyList<Stones> implements List<Stones>{
    private int size = 0;
    private Node<Stones> first;
    private Node<Stones> last;
    public MyList(){

    }
    public MyList(Stones stones){
        add(stones);
    }
    public MyList(Collection<? extends Stones> c){
        addAll(c);
    }
    @Override //+
    public int size() {
        return this.size;
    }

    @Override //+
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override //+
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override //+
    public Iterator<Stones> iterator() {
        return new MyIterator();
    }

    @Override //+
    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        if (!this.isEmpty()) {
            Node<Stones> current = first;
            result[0] = current.item;
            for (int i = 1; i < this.size(); i++) {
                current = current.next;
                result[i] = current.item;
            }
        }
        return result;
    }

    @Override //+
    public <T> T[] toArray(T[] a) {
        if (a.length<size()) {
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size());
        }
        for(int i=0; i<a.length;i++){
            a[i]=(T)get(i);
        }
        if (size()<a.length){
            a[size()]=null;
        }
        return a;
    }

    @Override //+
    public boolean add(Stones e) {
        if(isEmpty()){
            first = new Node<Stones>(null, e, null);
            last = first;
        } else {
            last.next = new Node<Stones>(last, e, null);
            last = last.next;
        }
        this.size++;
        return true;
    }

    @Override //+
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index==-1){
            return false;
        }
        remove(index);
        return true;
    }

    @Override //+
    public boolean containsAll(Collection<?> c) {
        for(Object o: c) {
            if(indexOf(o)==-1){
                return false;
            }
        }
        return true;
    }

    @Override //+
    public boolean addAll(Collection<? extends Stones> c) {
        return addAll(size(), c);
    }

    @Override //+
    public boolean addAll(int index, Collection<? extends Stones> c) {
        boolean changed = false;
        if (index>=0 && index<=size()) {
            ListIterator<Stones> itr = listIterator(index);
            for(Object o: c) {
                itr.add((Stones)o);
                changed = true;
            }
            return changed;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override //+
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for(Object o: c) {
            while(indexOf(o)!=-1){
                remove(o);
                changed = true;
            }
        }
        return changed;
    }

    @Override //+
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        ListIterator<Stones> itr = listIterator();
        while(itr.hasNext()){
            if(!c.contains(itr.next())){
                itr.remove();
                changed = true;
            }
        }
        return changed;
    }

    @Override //+
    public void clear() {
        for (Node<Stones> n = first; n != null; ) {
            Node<Stones> next = n.next;
            n.item = null;
            n.next = null;
            n.prev = null;
            n = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override //+
    public Stones get(int index) {
        if (0 <= index && index < size()){
            Node<Stones> current = first;
            for (int i=0; i < index; i++){
                current = current.next;
            }
            return current.item;
        }
        throw new NoSuchElementException();
    }

    @Override //+
    public Stones set(int index, Stones element) {
        if (index>=0 && index<size()) {
            Node<Stones> n = first;
            for(int i=0; i<index; i++) {
                n = n.next;
            }
            Stones e = n.item;
            n.item = element;
            return e;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override //+
    public void add(int index, Stones element) {
        if (index>=0 && index<=size()) {
            ListIterator<Stones> itr = listIterator(index);
            itr.add(element);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override //+
    public Stones remove(int index) {
        if (index<size() && index>=0){
            Node<Stones> current = first;
            for(int i=0; i<index;i++){
                current = current.next;
            }
            Node<Stones> n = current;
            if(current.next!=null){
                current.next.prev = current.prev;
            } else {
                last = current.prev;
            }
            if(current.prev!=null){
                current.prev.next = current.next;
            } else {
                first = current.next;
            }
            size--;
            n.prev = null;
            n.item = null;
            n.next = null;
            return current.item;
        }
        throw new NoSuchElementException();
    }

    @Override //+
    public int indexOf(Object o) {
        int index = -1;
        for (Stones e: this) {
            index++;
            if(e.equals(o)){
                return index;
            }
        }
        return -1;
    }

    @Override //+
    public int lastIndexOf(Object o) {
        ListIterator<Stones> itr = listIterator(size());
        for (int index = size()-1; index>=0; index--) {
            if (itr.previous().equals(o)){
                return index;
            }
        }
        return -1;
    }

    @Override //+
    public ListIterator<Stones> listIterator() {
        return new MyListIterator();
    }

    @Override //+
    public ListIterator<Stones> listIterator(int index) {
        ListIterator<Stones> itr = new MyListIterator();
        for (int i=0; i<index; i++){
            itr.next();
        }
        return itr;
    }

    @Override
    public List<Stones> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override //+
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        String s = "[";
        for (Stones e: this){
            s = s + e.toString() + ", ";
        }
        s = s.substring(0,s.length()-2) + "]";
        return s;
    }

    private class Node<Stones> {
        Stones item;
        Node<Stones> next;
        Node<Stones> prev;

        Node(Node<Stones> prev, Stones element, Node<Stones> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class MyIterator implements Iterator<Stones>{
        private int index = -1;
        private Node<Stones> current;

        @Override
        public boolean hasNext() {
            return index+1<size();
        }

        @Override
        public Stones next() {
            if (index==-1){
                current = first;
            } else {
                current = current.next;
            }
            index++;
            return current.item;
        }
    }

    private class MyListIterator implements ListIterator<Stones> {
        private int position = -1;
        private Node<Stones> prevNode;
        private int lastCalled = 0; // 1 - called next(); -1 - called previous()

        @Override //+
        public boolean hasNext() {
            return position+1 < size();
        }

        @Override //+
        public Stones next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            if (position == -1){
                prevNode = first;
            } else {
                prevNode = prevNode.next;
            }
            position++;
            lastCalled = 1;
            return prevNode.item;
        }

        @Override //+
        public boolean hasPrevious() {
            return position !=-1;
        }

        @Override //+
        public Stones previous() {
            if (!hasPrevious()){
                throw new NoSuchElementException();
            }
            Stones e = prevNode.item;
            prevNode = prevNode.prev;
            position--;
            lastCalled = -1;
            return e;
        }

        @Override //+
        public int nextIndex() {
            return position + 1;
        }

        @Override //+
        public int previousIndex() {
            return position;
        }

        @Override //+
        public void remove() {
            if (lastCalled == -1) {
                next();
            }
            if (lastCalled == 1) {
                Node<Stones> n = prevNode;
                if (prevNode.next != null) {
                    prevNode.next.prev = prevNode.prev;
                } else {
                    last = prevNode.prev;
                }
                if (prevNode.prev != null) {
                    prevNode.prev.next = prevNode.next;
                } else {
                    first = prevNode.next;
                }
                size--;
                position--;
                prevNode = prevNode.prev;
                lastCalled = 0;
                n.prev = null;
                n.item = null;
                n.next = null;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override //+
        public void set(Stones e) {
            if (lastCalled == 1) {
                prevNode.item = e;
            } else if (lastCalled == -1) {
                next();
                prevNode.item = e;
                previous();
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override //+
        public void add(Stones e) {
            if (position==-1){
                first = new Node<Stones>(null, e, first);
                if (!isEmpty()){
                    first.next.prev = first;
                }
                prevNode = first;
            } else {
                prevNode = new Node<Stones>(prevNode, e, prevNode.next);
                prevNode.prev.next = prevNode;
                if (position == size()-1){
                    last = prevNode;
                } else {
                    prevNode.next.prev = prevNode;
                }
            }
            position++;
            size++;
            lastCalled = 0;
        }
    }
}
