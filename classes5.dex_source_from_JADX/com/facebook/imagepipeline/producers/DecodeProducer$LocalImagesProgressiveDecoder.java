package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder;

/* compiled from: TOPIC_REAL_ESTATE */
class DecodeProducer$LocalImagesProgressiveDecoder extends ProgressiveDecoder {
    final /* synthetic */ DecodeProducer f13755a;

    public DecodeProducer$LocalImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        this.f13755a = decodeProducer;
        super(decodeProducer, consumer, producerContext);
    }

    protected final synchronized boolean m23111a(EncodedImage encodedImage, boolean z) {
        boolean a;
        if (z) {
            a = super.a(encodedImage, z);
        } else {
            a = false;
        }
        return a;
    }

    protected final int m23109a(EncodedImage encodedImage) {
        return encodedImage.h();
    }

    protected final ImmutableQualityInfo m23110a() {
        return ImmutableQualityInfo.a(0, false, false);
    }
}
