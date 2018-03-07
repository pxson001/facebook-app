package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable$Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* compiled from: boosting_status */
public final class OperatorDebounceWithTime<T> implements Observable$Operator<T, T> {
    final long f7735a;
    final TimeUnit f7736b;
    final Scheduler f7737c;

    /* compiled from: boosting_status */
    final class DebounceState<T> {
        int f7730a;
        T f7731b;
        boolean f7732c;
        boolean f7733d;
        boolean f7734e;

        DebounceState() {
        }

        public final synchronized int m13898a(T t) {
            int i;
            this.f7731b = t;
            this.f7732c = true;
            i = this.f7730a + 1;
            this.f7730a = i;
            return i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m13900a(int r4, rx.Subscriber<T> r5, rx.Subscriber<?> r6) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f7734e;	 Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x000d;
        L_0x0005:
            r0 = r3.f7732c;	 Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x000d;
        L_0x0009:
            r0 = r3.f7730a;	 Catch:{ all -> 0x002f }
            if (r4 == r0) goto L_0x000f;
        L_0x000d:
            monitor-exit(r3);	 Catch:{ all -> 0x002f }
        L_0x000e:
            return;
        L_0x000f:
            r0 = r3.f7731b;	 Catch:{ all -> 0x002f }
            r1 = r3.f7732c;	 Catch:{ all -> 0x002f }
            r2 = 0;
            r3.f7731b = r2;	 Catch:{ all -> 0x002f }
            r2 = 0;
            r3.f7732c = r2;	 Catch:{ all -> 0x002f }
            r2 = 1;
            r3.f7734e = r2;	 Catch:{ all -> 0x002f }
            monitor-exit(r3);	 Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0022;
        L_0x001f:
            r5.a(r0);	 Catch:{ Throwable -> 0x0032 }
        L_0x0022:
            monitor-enter(r3);
            r0 = r3.f7733d;	 Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0037;
        L_0x0027:
            r0 = 0;
            r3.f7734e = r0;	 Catch:{ all -> 0x002c }
            monitor-exit(r3);	 Catch:{ all -> 0x002c }
            goto L_0x000e;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x002c }
            throw r0;
        L_0x002f:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
        L_0x0032:
            r0 = move-exception;
            r6.a(r0);
            goto L_0x000e;
        L_0x0037:
            monitor-exit(r3);	 Catch:{  }
            r5.N_();
            goto L_0x000e;
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.a(int, rx.Subscriber, rx.Subscriber):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m13901a(rx.Subscriber<T> r4, rx.Subscriber<?> r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.f7734e;	 Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000a;
        L_0x0005:
            r0 = 1;
            r3.f7733d = r0;	 Catch:{ all -> 0x0021 }
            monitor-exit(r3);	 Catch:{ all -> 0x0021 }
        L_0x0009:
            return;
        L_0x000a:
            r0 = r3.f7731b;	 Catch:{ all -> 0x0021 }
            r1 = r3.f7732c;	 Catch:{ all -> 0x0021 }
            r2 = 0;
            r3.f7731b = r2;	 Catch:{ all -> 0x0021 }
            r2 = 0;
            r3.f7732c = r2;	 Catch:{ all -> 0x0021 }
            r2 = 1;
            r3.f7734e = r2;	 Catch:{ all -> 0x0021 }
            monitor-exit(r3);	 Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001d;
        L_0x001a:
            r4.a(r0);	 Catch:{ Throwable -> 0x0024 }
        L_0x001d:
            r4.N_();
            goto L_0x0009;
        L_0x0021:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{  }
            throw r0;
        L_0x0024:
            r0 = move-exception;
            r5.a(r0);
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.DebounceState.a(rx.Subscriber, rx.Subscriber):void");
        }

        public final synchronized void m13899a() {
            this.f7730a++;
            this.f7731b = null;
            this.f7732c = false;
        }
    }

    public final Object mo611a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        final Worker a = this.f7737c.mo1028a();
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.a(a);
        serializedSubscriber.a(serialSubscription);
        return new Subscriber<T>(this, subscriber) {
            final DebounceState<T> f7724a = new DebounceState();
            final Subscriber<?> f7725b = this;
            final /* synthetic */ OperatorDebounceWithTime f7729f;

            public final void m13896a(T t) {
                final int a = this.f7724a.m13898a(t);
                serialSubscription.m14093a(a.mo1026a(new Action0(this) {
                    final /* synthetic */ C08771 f7723b;

                    public final void m13895a() {
                        this.f7723b.f7724a.m13900a(a, serializedSubscriber, this.f7723b.f7725b);
                    }
                }, this.f7729f.f7735a, this.f7729f.f7736b));
            }

            public final void m13897a(Throwable th) {
                serializedSubscriber.m14047a(th);
                b();
                this.f7724a.m13899a();
            }

            public final void N_() {
                this.f7724a.m13901a(serializedSubscriber, this);
            }
        };
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7735a = j;
        this.f7736b = timeUnit;
        this.f7737c = scheduler;
    }
}
