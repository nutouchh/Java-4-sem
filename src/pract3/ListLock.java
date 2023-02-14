package pract3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Использование Lock может понадобиться для более точечной блокировки.


public class ListLock<E> implements List<E> {

    private static final Lock lock = new ReentrantLock();

    private volatile List<E> list = new ArrayList<>();

    @Override
    public int size() {
        lock.lock();
        int size = list.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean isEmpty = list.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean cont = false;
        lock.lock();
        cont = list.contains(o);
        lock.unlock();
        return cont;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = null;
        lock.lock();
        iter = list.iterator();
        lock.unlock();
        return iter;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[]{};
        lock.lock();
        obj = list.toArray();
        lock.unlock();
        return obj;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] obj = new Object[]{};
        lock.lock();
        obj = list.toArray();
        lock.unlock();
        return (T[])obj;
    }

    @Override
    public boolean add(E e) {
        boolean add = false;
        lock.lock();
        add = list.add(e);
        lock.unlock();
        return add;
    }

    @Override
    public boolean remove(Object o) {
        boolean rem = false;
        lock.lock();
        rem = list.remove(o);
        lock.unlock();
        return rem;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean cont = false;
        lock.lock();
        cont = list.containsAll(c);
        lock.unlock();
        return cont;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean add = false;
        lock.lock();
        add = list.contains(c);
        lock.unlock();
        return add;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean add = false;
        lock.lock();
        add = list.addAll(index, c);
        lock.unlock();
        return add;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean rem = false;
        lock.lock();
        rem = list.contains(c);
        lock.unlock();
        return rem;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean ret = false;
        lock.lock();
        ret = list.retainAll(c);
        lock.unlock();
        return ret;
    }

    @Override
    public void clear() {
        lock.lock();
        list.clear();
        lock.unlock();
    }

    @Override
    public E get(int index) {
        E get = null;
        lock.lock();
        get = list.get(index);
        lock.unlock();
        return get;
    }

    @Override
    public E set(int index, E element) {
        E set = null;
        lock.lock();
        set = list.set(index, element);
        lock.unlock();
        return set;
    }

    @Override
    public void add(int index, E element) {
        lock.lock();
        list.add(index, element);
        lock.unlock();
    }

    @Override
    public E remove(int index) {
        E rem = null;
        lock.lock();
        rem = list.remove(index);
        lock.unlock();
        return rem;
    }

    @Override
    public int indexOf(Object o) {
        int ind = 0;
        lock.lock();
        ind = list.indexOf(o);
        lock.unlock();
        return ind;
    }

    @Override
    public int lastIndexOf(Object o) {
        int ind = 0;
        lock.lock();
        ind = list.lastIndexOf(o);
        lock.unlock();
        return ind;
    }

    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> iter = null;
        lock.lock();
        iter = list.listIterator();
        lock.unlock();
        return iter;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> iter = null;
        lock.lock();
        iter = list.listIterator(index);
        lock.unlock();
        return iter;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> l = null;
        lock.lock();
        l = list.subList(fromIndex, toIndex);
        lock.unlock();
        return l;
    }
}
