package pract4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {

    private ExecutorService exServ;


//  Конструктор, принимающий только количество потоков
    public MyExecutorService(int numOfThreads) {
        this.exServ = Executors.newFixedThreadPool(numOfThreads);
    }

//  Упорядоченное завершение работы, при котором ранее отправленные задачи выполняются, а новые задачи не принимаются
    @Override
    public void shutdown() {
        exServ.shutdown();
    }

//  Остановка всех активно выполняемых задач, остановка обработки ожидающих задач,
//  возвращение списка задач, ожидающих выполнения
    @Override
    public List<Runnable> shutdownNow() {
        return exServ.shutdownNow();
    }

//  Возвращает true, если исполнитель сервиса остановлен (shutdown)
    @Override
    public boolean isShutdown() {
        return exServ.isShutdown();
    }

//  Возвращает true, если все задачи исполнителя сервиса завершены по команде остановки (shutdown)
    @Override
    public boolean isTerminated() {
        return exServ.isTerminated();
    }

//  Блокировка до тех пор, пока все задачи не завершат выполнение после запроса на завершение работы
//  или пока не наступит тайм-аут или не будет прерван текущий поток
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return exServ.awaitTermination(timeout, unit);
    }


//  метод submit(), который ставит задачу в очередь на выполнение.
//  В качестве входного параметра данный метод принимает объект типа Callable или Runnable,
//  а возвращает параметризованный объект типа Future,
//  который можно использовать для доступа к результату выполнения задачи.


//  Завершение выполнения задачи, возвращающей результат в виде объекта Future
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return exServ.submit(task);
    }

//  Завершение выполнения задачи, возвращающей объект Future, представляющий данную задачу
    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return exServ.submit(task, result);
    }

//  Завершение выполнения задачи, возвращающей объект Future, представляющий данную задачу
    @Override
    public Future<?> submit(Runnable task) {
        return exServ.submit(task);
    }

//  Выполнение задач с возвращением списка задач с их статусом и результатами завершения
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return exServ.invokeAll(tasks);
    }

//  Выполнение задач с возвращением списка задач с их статусом и результатами завершения в течение заданного времени
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return exServ.invokeAll(tasks, timeout, unit);
    }

//  Выполнение задач с возвращением результата успешно выполненной задачи
//  (т. е. без создания исключения), если таковые имеются
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return exServ.invokeAny(tasks);
    }

//  Выполнение задач в течение заданного времени с возвращением результата успешно выполненной задачи
//  (т. е. без создания исключения), если таковые имеются
    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return exServ.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        exServ.execute(command);
    }
}
