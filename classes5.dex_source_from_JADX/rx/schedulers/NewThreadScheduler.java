package rx.schedulers;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;

/* compiled from: birthdayFriends */
public final class NewThreadScheduler extends Scheduler {
    private static final RxThreadFactory f7943a = new RxThreadFactory("RxNewThreadScheduler-");
    public static final NewThreadScheduler f7944b = new NewThreadScheduler();

    private NewThreadScheduler() {
    }

    public final Worker mo1028a() {
        return new NewThreadWorker(f7943a);
    }
}
