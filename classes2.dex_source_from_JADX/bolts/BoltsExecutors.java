package bolts;

import android.os.Build.VERSION;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: measurement.upload.url */
public final class BoltsExecutors {
    public static final BoltsExecutors f14665a = new BoltsExecutors();
    private final ExecutorService f14666b;
    public final Executor f14667c;

    /* compiled from: measurement.upload.url */
    class ImmediateExecutor implements Executor {
        private ThreadLocal<Integer> f14673a = new ThreadLocal();

        private int m21090a() {
            Integer num = (Integer) this.f14673a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.f14673a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int m21091b() {
            Integer num = (Integer) this.f14673a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f14673a.remove();
            } else {
                this.f14673a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (m21090a() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m21091b();
                }
            } else {
                ExecutorDetour.a(BoltsExecutors.m21089a(), runnable, 1274109319);
            }
            m21091b();
        }
    }

    private BoltsExecutors() {
        boolean z;
        ExecutorService newCachedThreadPool;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            z = false;
        } else {
            z = property.toLowerCase(Locale.US).contains("android");
        }
        if (z) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.f14668a, AndroidExecutors.f14669b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
            if (VERSION.SDK_INT >= 9) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            Object obj = threadPoolExecutor;
        } else {
            newCachedThreadPool = Executors.newCachedThreadPool();
        }
        this.f14666b = newCachedThreadPool;
        this.f14667c = new ImmediateExecutor();
    }

    public static ExecutorService m21089a() {
        return f14665a.f14666b;
    }
}
