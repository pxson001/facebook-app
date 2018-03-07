package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: TOPIC_SHOPPING_RETAIL */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> f13750a;
    public final Producer<EncodedImage> f13751b;

    /* compiled from: TOPIC_SHOPPING_RETAIL */
    class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        final /* synthetic */ BranchOnSeparateImagesProducer f13748a;
        private BaseProducerContext f13749b;

        protected final void m23099a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            ImageRequest imageRequest = this.f13749b.a;
            boolean a = ThumbnailSizeChecker.m23221a(encodedImage, imageRequest.a);
            if (encodedImage != null && (a || imageRequest.f)) {
                boolean z2;
                BaseConsumer baseConsumer = this.a;
                if (z && a) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                baseConsumer.b(encodedImage, z2);
            }
            if (z && !a) {
                EncodedImage.d(encodedImage);
                this.f13748a.f13751b.a(this.a, this.f13749b);
            }
        }

        public OnFirstImageConsumer(BranchOnSeparateImagesProducer branchOnSeparateImagesProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            this.f13748a = branchOnSeparateImagesProducer;
            super(consumer);
            this.f13749b = producerContext;
        }

        protected final void m23100b(Throwable th) {
            this.f13748a.f13751b.a(this.a, this.f13749b);
        }
    }

    public BranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        this.f13750a = producer;
        this.f13751b = producer2;
    }

    public final void m23101a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f13750a.a(new OnFirstImageConsumer(this, consumer, producerContext), producerContext);
    }
}
