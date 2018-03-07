package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

/* compiled from: branding_image */
public abstract class Scheduler {

    /* compiled from: branding_image */
    public abstract class Worker implements Subscription {
        public abstract Subscription mo1025a(Action0 action0);

        public abstract Subscription mo1026a(Action0 action0, long j, TimeUnit timeUnit);

        public final Subscription m13860a(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            final long toNanos = timeUnit.toNanos(j2);
            final long toNanos2 = TimeUnit.MILLISECONDS.toNanos(m13858a()) + timeUnit.toNanos(j);
            final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            final Action0 action02 = action0;
            multipleAssignmentSubscription.m14090a(mo1026a(new Action0(this) {
                long f7691a = 0;
                final /* synthetic */ Worker f7696f;

                public final void m13857a() {
                    if (!multipleAssignmentSubscription.m14092c()) {
                        action02.a();
                        long j = toNanos2;
                        long j2 = this.f7691a + 1;
                        this.f7691a = j2;
                        multipleAssignmentSubscription.m14090a(this.f7696f.mo1026a(this, (j + (j2 * toNanos)) - TimeUnit.MILLISECONDS.toNanos(Worker.m13858a()), TimeUnit.NANOSECONDS));
                    }
                }
            }, j, timeUnit));
            return multipleAssignmentSubscription;
        }

        public static long m13858a() {
            return System.currentTimeMillis();
        }
    }

    public abstract Worker mo1028a();
}
