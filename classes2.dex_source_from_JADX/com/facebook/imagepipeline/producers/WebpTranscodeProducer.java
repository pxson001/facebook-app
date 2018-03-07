package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: instant_shopping_catalog */
public class WebpTranscodeProducer implements Producer<EncodedImage> {
    private final Executor f19772a;
    public final NativePooledByteBufferFactory f19773b;
    private final Producer<EncodedImage> f19774c;

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.f19772a = (Executor) Preconditions.a(executor);
        this.f19773b = (NativePooledByteBufferFactory) Preconditions.a(pooledByteBufferFactory);
        this.f19774c = (Producer) Preconditions.a(producer);
    }

    public final void mo2774a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f19774c.mo2774a(new WebpTranscodeConsumer(this, consumer, producerContext), producerContext);
    }

    public static void m27448a(WebpTranscodeProducer webpTranscodeProducer, EncodedImage encodedImage, BaseConsumer baseConsumer, BaseProducerContext baseProducerContext) {
        Preconditions.a(encodedImage);
        WebpTranscodeProducer webpTranscodeProducer2 = webpTranscodeProducer;
        BaseConsumer baseConsumer2 = baseConsumer;
        ExecutorDetour.a(webpTranscodeProducer.f19772a, new 1(webpTranscodeProducer2, baseConsumer2, baseProducerContext.f14482c, "WebpTranscodeProducer", baseProducerContext.f14481b, EncodedImage.m15702a(encodedImage)), -1752170623);
    }

    public static void m27449b(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) {
        InputStream b = encodedImage.m15711b();
        switch (2.a[ImageFormatChecker.m24998b(b).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
                WebpTranscoderFactory.b.m25064a(b, pooledByteBufferOutputStream, 80);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                WebpTranscoderFactory.b.m25063a(b, pooledByteBufferOutputStream);
                return;
            default:
                throw new IllegalArgumentException("Wrong image format");
        }
    }
}
