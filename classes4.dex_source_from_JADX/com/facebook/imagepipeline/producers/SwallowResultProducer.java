package com.facebook.imagepipeline.producers;

/* compiled from: mqtt_notifications_fetch_counts */
public class SwallowResultProducer<T> implements Producer<Void> {
    private final Producer<T> f7484a;

    public SwallowResultProducer(Producer<T> producer) {
        this.f7484a = producer;
    }

    public final void m7799a(Consumer<Void> consumer, ProducerContext producerContext) {
        this.f7484a.a(new DelegatingConsumer<T, Void>(this, consumer) {
            final /* synthetic */ SwallowResultProducer f7500a;

            protected final void m7802a(T t, boolean z) {
                if (z) {
                    this.a.b(null, z);
                }
            }
        }, producerContext);
    }
}
