package rx.internal.util;

import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* compiled from: bookmarks */
public class RxRingBuffer implements Subscription {
    static int f7849b;
    public static final int f7850c = f7849b;
    private static final NotificationLite<Object> f7851d = NotificationLite.a();
    private static ObjectPool<Queue<Object>> f7852h = new C08941();
    public static ObjectPool<Queue<Object>> f7853i = new C08952();
    public volatile Object f7854a;
    public Queue<Object> f7855e;
    public final int f7856f;
    public final ObjectPool<Queue<Object>> f7857g;

    /* compiled from: bookmarks */
    final class C08941 extends ObjectPool<Queue<Object>> {
        C08941() {
        }

        protected final Object mo1027a() {
            return new SpscArrayQueue(RxRingBuffer.f7850c);
        }
    }

    /* compiled from: bookmarks */
    final class C08952 extends ObjectPool<Queue<Object>> {
        C08952() {
        }

        protected final Object mo1027a() {
            return new SpmcArrayQueue(RxRingBuffer.f7850c);
        }
    }

    public static RxRingBuffer m14006d() {
        if (UnsafeAccess.m14041a()) {
            return new RxRingBuffer(f7853i, f7850c);
        }
        return new RxRingBuffer();
    }

    static {
        f7849b = 128;
        if (PlatformDependent.m14000a()) {
            f7849b = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f7849b = Integer.parseInt(property);
            } catch (Exception e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
    }

    private RxRingBuffer(Queue<Object> queue, int i) {
        this.f7855e = queue;
        this.f7857g = null;
        this.f7856f = i;
    }

    public RxRingBuffer(ObjectPool<Queue<Object>> objectPool, int i) {
        this.f7857g = objectPool;
        this.f7855e = (Queue) objectPool.m13984b();
        this.f7856f = i;
    }

    public final void m14008b() {
        if (this.f7857g != null) {
            Queue queue = this.f7855e;
            queue.clear();
            this.f7855e = null;
            this.f7857g.m13983a(queue);
        }
    }

    public RxRingBuffer() {
        this(new SynchronizedQueue(f7850c), f7850c);
    }

    public final void m14007a(Object obj) {
        if (this.f7855e == null) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (!this.f7855e.offer(NotificationLite.a(obj))) {
            throw new MissingBackpressureException();
        }
    }

    public final void m14010e() {
        if (this.f7854a == null) {
            this.f7854a = NotificationLite.b;
        }
    }

    public final int m14011g() {
        if (this.f7855e == null) {
            return 0;
        }
        return this.f7855e.size();
    }

    public final boolean m14012h() {
        if (this.f7855e == null) {
            return true;
        }
        return this.f7855e.isEmpty();
    }

    public final Object m14013i() {
        if (this.f7855e == null) {
            return null;
        }
        Object poll = this.f7855e.poll();
        if (poll != null || this.f7854a == null || !this.f7855e.isEmpty()) {
            return poll;
        }
        poll = this.f7854a;
        this.f7854a = null;
        return poll;
    }

    public final Object m14014j() {
        if (this.f7855e == null) {
            return null;
        }
        Object peek = this.f7855e.peek();
        if (peek == null && this.f7854a != null && this.f7855e.isEmpty()) {
            return this.f7854a;
        }
        return peek;
    }

    public static boolean m14005a(Object obj, Observer observer) {
        return NotificationLite.a(observer, obj);
    }

    public final boolean m14009c() {
        return this.f7855e == null;
    }
}
