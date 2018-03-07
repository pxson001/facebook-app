package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.schedulers.Schedulers;

/* compiled from: booleanResult */
public abstract class ObjectPool<T> {
    public Queue<T> f7831a;
    public final int f7832b;
    private Worker f7833c;

    public abstract T mo1027a();

    public ObjectPool() {
        this(0, 0, 67);
    }

    private ObjectPool(final int i, final int i2, long j) {
        this.f7832b = i2;
        if (UnsafeAccess.m14041a()) {
            this.f7831a = new MpmcArrayQueue(Math.max(this.f7832b, 1024));
        } else {
            this.f7831a = new ConcurrentLinkedQueue();
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f7831a.add(mo1027a());
        }
        this.f7833c = Schedulers.m14073a().mo1028a();
        this.f7833c.m13860a(new Action0(this) {
            final /* synthetic */ ObjectPool f7847c;

            public final void m13999a() {
                int i = 0;
                int size = this.f7847c.f7831a.size();
                if (size < i) {
                    size = i2 - size;
                    while (i < size) {
                        this.f7847c.f7831a.add(this.f7847c.mo1027a());
                        i++;
                    }
                } else if (size > i2) {
                    size -= i2;
                    while (i < size) {
                        this.f7847c.f7831a.poll();
                        i++;
                    }
                }
            }
        }, j, j, TimeUnit.SECONDS);
    }

    public final T m13984b() {
        T poll = this.f7831a.poll();
        if (poll == null) {
            return mo1027a();
        }
        return poll;
    }

    public final void m13983a(T t) {
        if (t != null) {
            this.f7831a.offer(t);
        }
    }
}
