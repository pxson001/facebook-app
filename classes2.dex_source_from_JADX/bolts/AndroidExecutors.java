package bolts;

import android.os.Handler;
import android.os.Looper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.Executor;

/* compiled from: measurement.upload.stale_data_deletion_interval */
public final class AndroidExecutors {
    public static final int f14668a;
    public static final int f14669b = ((f14671e * 2) + 1);
    public static final AndroidExecutors f14670c = new AndroidExecutors();
    private static final int f14671e;
    public final Executor f14672d = new UIThreadExecutor();

    /* compiled from: measurement.upload.stale_data_deletion_interval */
    class UIThreadExecutor implements Executor {
        public void execute(Runnable runnable) {
            HandlerDetour.a(new Handler(Looper.getMainLooper()), runnable, -663043565);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f14671e = availableProcessors;
        f14668a = availableProcessors + 1;
    }

    private AndroidExecutors() {
    }
}
