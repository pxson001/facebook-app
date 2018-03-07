package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

/* compiled from: medium_power_scan_interval_ms */
public class ThreadHandoffProducer<T> implements Producer<T> {
    public final Producer<T> f14478a;
    public final ThreadHandoffProducerQueue f14479b;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.f14478a = (Producer) Preconditions.a(producer);
        this.f14479b = threadHandoffProducerQueue;
    }

    public final void mo2774a(Consumer<T> consumer, ProducerContext producerContext) {
        ProducerListener producerListener = producerContext.f14482c;
        String str = producerContext.f14481b;
        final ProducerListener producerListener2 = producerListener;
        final String str2 = str;
        final BaseConsumer baseConsumer = consumer;
        final BaseProducerContext baseProducerContext = producerContext;
        final Runnable c06051 = new StatefulProducerRunnable<T>(this, consumer, producerListener, "BackgroundThreadHandoffProducer", str) {
            final /* synthetic */ ThreadHandoffProducer f14521f;

            protected final void mo2796a(T t) {
                producerListener2.mo2109a(str2, "BackgroundThreadHandoffProducer", null);
                this.f14521f.f14478a.mo2774a(baseConsumer, baseProducerContext);
            }

            protected final void mo2797b(T t) {
            }

            protected final T mo2798c() {
                return null;
            }
        };
        producerContext.m20856a(new BaseProducerContextCallbacks(this) {
            final /* synthetic */ ThreadHandoffProducer f14528b;

            public final void mo2801a() {
                c06051.m20939a();
                this.f14528b.f14479b.m16060b(c06051);
            }
        });
        this.f14479b.m16059a(c06051);
    }
}
