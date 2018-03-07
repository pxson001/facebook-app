package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

/* compiled from: TOPIC_LIST */
public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
    private final Producer<EncodedImage> f13824a;

    /* compiled from: TOPIC_LIST */
    class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        final /* synthetic */ RemoveImageTransformMetaDataProducer f13823a;

        protected final void m23196a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            CloseableReference closeableReference = null;
            try {
                if (EncodedImage.e(encodedImage)) {
                    closeableReference = encodedImage.a();
                }
                d().b(closeableReference, z);
            } finally {
                CloseableReference.c(closeableReference);
            }
        }

        public RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer removeImageTransformMetaDataProducer, Consumer<CloseableReference<PooledByteBuffer>> consumer) {
            this.f13823a = removeImageTransformMetaDataProducer;
            super(consumer);
        }
    }

    public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.f13824a = producer;
    }

    public final void m23197a(Consumer<CloseableReference<PooledByteBuffer>> consumer, ProducerContext producerContext) {
        this.f13824a.a(new RemoveImageTransformMetaDataConsumer(this, consumer), producerContext);
    }
}
