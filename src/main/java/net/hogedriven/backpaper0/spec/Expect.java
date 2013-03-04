package net.hogedriven.backpaper0.spec;

import java.util.concurrent.Callable;
import org.junit.Assert;

public class Expect<T> {

    private final Callable<T> c;

    public Expect(Callable<T> c) {
        this.c = c;
    }

    public void toEqual(T value) throws Exception {
        Assert.assertEquals(value, c.call());
    }

    public void toThrow(Class<? extends Exception> exceptionClass) throws Exception {
        try {
            c.call();
            Assert.fail();
        } catch (Exception e) {
            if (e.getClass().isAssignableFrom(exceptionClass) == false) {
                Assert.fail();
            }
        }
    }

    public static <T> Expect<T> expect(Callable<T> c) {
        return new Expect<>(c);
    }
}
