package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: TOPIC_LANDMARK */
public class ThrottlingProducer<T> implements Producer<T> {
    private final Producer<T> f13840a;
    private final int f13841b;
    @GuardedBy("this")
    private int f13842c = 0;
    @GuardedBy("this")
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> f13843d = new ConcurrentLinkedQueue();
    public final Executor f13844e;

    /* compiled from: TOPIC_LANDMARK */
    class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        final /* synthetic */ ThrottlingProducer f13839a;

        protected final void m23208a(T t, boolean z) {
            this.a.b(t, z);
            if (z) {
                m23207a();
            }
        }

        protected final void m23209b(Throwable th) {
            this.a.a(th);
            m23207a();
        }

        protected final void m23210c() {
            this.a.b();
            m23207a();
        }

        public ThrottlerConsumer(ThrottlingProducer throttlingProducer, Consumer<T> consumer) {
            this.f13839a = throttlingProducer;
            super(consumer);
        }

        private void m23207a() {
            synchronized (this.f13839a) {
                final Pair pair = (Pair) this.f13839a.f13843d.poll();
                if (pair == null) {
                    this.f13839a.f13842c = this.f13839a.f13842c - 1;
                }
            }
            if (pair != null) {
                ExecutorDetour.a(this.f13839a.f13844e, new Runnable(this) {
                    final /* synthetic */ ThrottlerConsumer f13838b;

                    public void run() {
                        this.f13838b.f13839a.m23213b((BaseConsumer) pair.first, (BaseProducerContext) pair.second);
                    }
                }, -1860297354);
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.f13841b = i;
        this.f13844e = (Executor) Preconditions.a(executor);
        this.f13840a = (Producer) Preconditions.a(producer);
    }

    public final void m23212a(Consumer<T> consumer, ProducerContext producerContext) {
        Object obj;
        producerContext.c().a(producerContext.b(), "ThrottlingProducer");
        synchronized (this) {
            if (this.f13842c >= this.f13841b) {
                this.f13843d.add(Pair.create(consumer, producerContext));
                obj = 1;
            } else {
                this.f13842c++;
                obj = null;
            }
        }
        if (obj == null) {
            m23213b(consumer, producerContext);
        }
    }

    final void m23213b(Consumer<T> consumer, ProducerContext producerContext) {
        producerContext.c.a(producerContext.b, "ThrottlingProducer", null);
        this.f13840a.a(new ThrottlerConsumer(this, consumer), producerContext);
    }
}
