package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: bluetooth.on */
public final class UnsafeAccess {
    public static final Unsafe f7894a;

    private UnsafeAccess() {
        throw new IllegalStateException("No instances!");
    }

    static {
        Unsafe unsafe;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Exception e) {
            unsafe = null;
        }
        f7894a = unsafe;
    }

    public static final boolean m14041a() {
        return f7894a != null;
    }
}
