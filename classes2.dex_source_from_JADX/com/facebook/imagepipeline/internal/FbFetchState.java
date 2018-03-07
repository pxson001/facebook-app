package com.facebook.imagepipeline.internal;

import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.ProducerContext;

/* compiled from: measurement.upload.initial_upload_delay_time */
public class FbFetchState extends FetchState {
    public CdnHeaderResponse f14707a;
    private final long f14708b;
    public long f14709c;
    public long f14710d;
    public long f14711e = -1;
    private int f14712f;

    public FbFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext, long j) {
        super(consumer, producerContext);
        this.f14708b = j;
    }

    final long m21125h() {
        return (long) this.f14712f;
    }

    final long m21126j() {
        return this.f14708b;
    }

    final long m21127k() {
        return this.f14711e;
    }

    public final boolean m21128l() {
        return this.f14711e != -1;
    }
}
