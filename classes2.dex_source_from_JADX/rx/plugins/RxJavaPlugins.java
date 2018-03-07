package rx.plugins;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: rtc_call_everyone_people_tab */
public class RxJavaPlugins {
    static final RxJavaErrorHandler f6486a = new C02901();
    public static final RxJavaPlugins f6487b = new RxJavaPlugins();
    private final AtomicReference<RxJavaErrorHandler> f6488c = new AtomicReference();
    public final AtomicReference<RxJavaObservableExecutionHook> f6489d = new AtomicReference();
    private final AtomicReference<RxJavaSchedulersHook> f6490e = new AtomicReference();

    /* compiled from: rtc_call_everyone_people_tab */
    final class C02901 extends RxJavaErrorHandler {
        C02901() {
        }
    }

    public static RxJavaPlugins m11258a() {
        return f6487b;
    }

    RxJavaPlugins() {
    }

    public final RxJavaErrorHandler m11259b() {
        if (this.f6488c.get() == null) {
            Object a = m11257a(RxJavaErrorHandler.class);
            if (a == null) {
                this.f6488c.compareAndSet(null, f6486a);
            } else {
                this.f6488c.compareAndSet(null, (RxJavaErrorHandler) a);
            }
        }
        return (RxJavaErrorHandler) this.f6488c.get();
    }

    public static Object m11257a(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e) {
            throw new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
        } catch (Throwable e2) {
            throw new RuntimeException(simpleName + " implementation class not found: " + property, e2);
        } catch (Throwable e22) {
            throw new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e22);
        } catch (Throwable e222) {
            throw new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e222);
        }
    }

    public final RxJavaSchedulersHook m11260d() {
        if (this.f6490e.get() == null) {
            Object a = m11257a(RxJavaSchedulersHook.class);
            if (a == null) {
                this.f6490e.compareAndSet(null, RxJavaSchedulersHook.a);
            } else {
                this.f6490e.compareAndSet(null, (RxJavaSchedulersHook) a);
            }
        }
        return (RxJavaSchedulersHook) this.f6490e.get();
    }
}
