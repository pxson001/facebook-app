package rx;

import rx.internal.util.SubscriptionList;

/* compiled from: rtc_enable_frame_enhancement */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private final SubscriptionList f6464a;
    private final Subscriber<?> f6465b;
    private Producer f6466c;
    private long f6467d;

    protected Subscriber() {
        this.f6467d = Long.MIN_VALUE;
        this.f6465b = null;
        this.f6464a = new SubscriptionList();
    }

    protected Subscriber(Subscriber<?> subscriber) {
        this.f6467d = Long.MIN_VALUE;
        this.f6465b = subscriber;
        this.f6464a = subscriber.f6464a;
    }

    public final void m11202a(Subscription subscription) {
        this.f6464a.m11211a(subscription);
    }

    public final void mo1600b() {
        this.f6464a.mo1600b();
    }

    public final boolean mo1601c() {
        return this.f6464a.mo1601c();
    }

    public void m11205d() {
    }

    public final void m11200a(long j) {
        Producer producer = null;
        synchronized (this) {
            if (this.f6466c != null) {
                producer = this.f6466c;
            } else {
                this.f6467d = j;
            }
        }
        if (producer != null) {
            producer.a(j);
        }
    }

    public void m11201a(Producer producer) {
        Object obj = null;
        synchronized (this) {
            long j = this.f6467d;
            this.f6466c = producer;
            if (this.f6465b != null && j == Long.MIN_VALUE) {
                obj = 1;
            }
        }
        if (obj != null) {
            this.f6465b.m11201a(this.f6466c);
        } else if (j == Long.MIN_VALUE) {
            this.f6466c.a(Long.MAX_VALUE);
        } else {
            this.f6466c.a(j);
        }
    }
}
