package rx.schedulers;

import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.plugins.RxJavaPlugins;

/* compiled from: bio_text */
public final class Schedulers {
    private static final Schedulers f7945d = new Schedulers();
    private final Scheduler f7946a;
    private final Scheduler f7947b;
    private final Scheduler f7948c;

    private Schedulers() {
        RxJavaPlugins.b.d();
        Scheduler scheduler = null;
        if (scheduler != null) {
            this.f7946a = scheduler;
        } else {
            this.f7946a = new EventLoopsScheduler();
        }
        RxJavaPlugins.b.d();
        scheduler = null;
        if (scheduler != null) {
            this.f7947b = scheduler;
        } else {
            this.f7947b = new CachedThreadScheduler();
        }
        RxJavaPlugins.b.d();
        scheduler = null;
        if (scheduler != null) {
            this.f7948c = scheduler;
        } else {
            this.f7948c = NewThreadScheduler.f7944b;
        }
    }

    public static Scheduler m14073a() {
        return f7945d.f7946a;
    }

    public static Scheduler m14074a(Executor executor) {
        return new ExecutorScheduler(executor);
    }
}
