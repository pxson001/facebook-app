package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: measurement.upload.backoff_period */
public class FetchState {
    public final Consumer<EncodedImage> f14713a;
    public final BaseProducerContext f14714b;
    public long f14715c = 0;

    public FetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f14713a = consumer;
        this.f14714b = producerContext;
    }

    public final Consumer<EncodedImage> m21129a() {
        return this.f14713a;
    }

    public final BaseProducerContext m21130b() {
        return this.f14714b;
    }

    public final String m21131c() {
        return this.f14714b.f14481b;
    }

    public final ProducerListener m21132d() {
        return this.f14714b.f14482c;
    }

    public final Uri m21133e() {
        return this.f14714b.f14480a.f12746c;
    }
}
