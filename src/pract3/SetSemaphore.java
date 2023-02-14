package pract3;

import java.util.*;
import java.util.concurrent.Semaphore;


// Семафор — это средство для синхронизации доступа к какому-то ресурсу.
// Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.
// Счетчик указывает нам, сколько потоков одновременно могут получать доступ к общему ресурсу.


public class SetSemaphore<E> implements Set<E> {

    private static final Semaphore semaphore = new Semaphore(1);

    private volatile Set<E> set = new HashSet<>(); // volatile: значение переменной может неожиданно изменяться

    @Override
    public int size() {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[]{};
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            objects = set.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] objects = new Object[]{};
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            objects = set.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return  (T[]) objects;
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.add(e);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.remove(o);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.containsAll(c);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.addAll(c);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.retainAll(c);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            return set.removeAll(c);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire(); //Запрашиваем у семафора разрешение на выполнение
            set.clear();
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
        finally {
            semaphore.release(); // освобождение места в семафоре
        }
    }
}
