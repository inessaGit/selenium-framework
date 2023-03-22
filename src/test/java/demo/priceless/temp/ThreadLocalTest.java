package demo.priceless.temp;

import org.testng.annotations.Test;

/*
what is ThreadLocal? it enables you to create a generic/ThreadLocal type of object
which can only be read and written (via its get and set method) by the same thread,
so if two threads are trying to read and write a ThreadLocal object concurrently,
one thread would not see the modification of the ThreadLocal object done by the other thread,
thus, making the thread-local object thread-safe.
A typical thread-local object is made
private static
its class provides initialValue, get, set, and remove methods.
The following example shows how you can create a Generic type thread-local object
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> myThreadLocal;
    @Test
    public void test1(){
      myThreadLocal = new ThreadLocal<String>();
//set thread-local value
        myThreadLocal.set("Hello ThreadLocal");
        //get thread-local value
        String threadLocalValue = myThreadLocal.get();
//remove thread-local value for the current thread
        myThreadLocal.remove();
    }

}
