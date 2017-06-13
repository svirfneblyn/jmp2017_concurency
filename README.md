# jmp2017_concurency
<p>1. Есть программа, каждый из методов a, b, c работают очень медленно.<br />
main() {
<br /> int a = a();<br /> int b = b();<br /> int c = c(a);<br /> int d = d(c + b);<br />
 System.out.format("a=%d b=%d c=%d d=%d\n", a, b, c, d);<br />}
 <br />Нужно распараллелить выполнение следующими способами:<br />
 - new thread, wait, notify<br />
 - new thread, Lock, Condition<br />
 - callable + future + ExecutorService (используйте cached и fixed thread pool, сделайте чтобы максимальное число потоков было только 2)<br />
 - CompletableFuture</p> <p>
 2. Создайте счётчик, запустите 2 треда, один из них инкрементирует, другой декрементирует<br />
 кажый тред в цикле делает свою операцию 1.000.000 раз и потом завершается<br />
 выведите значение счётчика в консоль после того как треды отработали (не всегда значение счётчика будет 0)<br />
 - пофиксите проблему с помощью AtomicInteger/AtomicLong и блока synchronized<br />
 - замерьте что быстрее</p> <p>
 3. Создайте HashMap ключ(Integer) значение (Integer). Один поток добавляет новые элементы в мапу, <br />
 другой пробегается по ключам и считает сумму values. Пусть треды поработают пока не упадут от ConcurrentModificationException<br />
- пофиксите проблему с помощью ConcurrentHashMap и Collections.synchronizedMap<br />
- замерьте что быстрее</p>