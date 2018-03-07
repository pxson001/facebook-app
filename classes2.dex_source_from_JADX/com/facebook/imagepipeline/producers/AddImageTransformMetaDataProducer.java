package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: members.count */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> f14466a;

    /* compiled from: members.count */
    class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        protected final void mo2788a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (encodedImage == null) {
                this.f14615a.m20910b(null, z);
                return;
            }
            if (!EncodedImage.m15703c(encodedImage)) {
                encodedImage.m15719i();
            }
            this.f14615a.m20910b(encodedImage, z);
        }

        public AddImageTransformMetaDataConsumer(Consumer<EncodedImage> consumer) {
            super(consumer);
        }
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.f14466a = producer;
    }

    public final void mo2774a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f14466a.mo2774a(new AddImageTransformMetaDataConsumer(consumer), producerContext);
    }
}
