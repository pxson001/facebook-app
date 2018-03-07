package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;

/* compiled from: best_post_reach */
final class Subscriptions$FutureSubscription implements Subscription {
    final Future<?> f7979a;

    public Subscriptions$FutureSubscription(Future<?> future) {
        this.f7979a = future;
    }

    public final void m14096b() {
        this.f7979a.cancel(true);
    }

    public final boolean m14097c() {
        return this.f7979a.isCancelled();
    }
}
