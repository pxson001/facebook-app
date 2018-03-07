package rx.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.internal.util.RxThreadFactory;

/* compiled from: birthday_stories */
final class GenericScheduledExecutorService {
    private static final RxThreadFactory f7937a = new RxThreadFactory("RxScheduledExecutorPool-");
    private static final GenericScheduledExecutorService f7938b = new GenericScheduledExecutorService();
    private final ScheduledExecutorService f7939c;

    private GenericScheduledExecutorService() {
        int i = 8;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors <= 8) {
            i = availableProcessors;
        }
        this.f7939c = Executors.newScheduledThreadPool(i, f7937a);
    }

    public static ScheduledExecutorService m14066a() {
        return f7938b.f7939c;
    }
}
