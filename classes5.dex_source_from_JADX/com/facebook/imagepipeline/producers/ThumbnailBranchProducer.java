package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: TOPIC_LAKE */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    private final ThumbnailProducer<EncodedImage>[] f13849a;

    /* compiled from: TOPIC_LAKE */
    class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        final /* synthetic */ ThumbnailBranchProducer f13845a;
        private final BaseProducerContext f13846b;
        private final int f13847c;
        private final ResizeOptions f13848d = this.f13846b.a.a;

        protected final void m23214a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (encodedImage != null && (!z || ThumbnailSizeChecker.m23221a(encodedImage, this.f13848d))) {
                this.a.b(encodedImage, z);
            } else if (z) {
                EncodedImage.d(encodedImage);
                if (!ThumbnailBranchProducer.m23217a(this.f13845a, this.f13847c + 1, this.a, this.f13846b)) {
                    this.a.b(null, true);
                }
            }
        }

        public ThumbnailConsumer(ThumbnailBranchProducer thumbnailBranchProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext, int i) {
            this.f13845a = thumbnailBranchProducer;
            super(consumer);
            this.f13846b = producerContext;
            this.f13847c = i;
        }

        protected final void m23215b(Throwable th) {
            if (!ThumbnailBranchProducer.m23217a(this.f13845a, this.f13847c + 1, this.a, this.f13846b)) {
                this.a.a(th);
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... thumbnailProducerArr) {
        this.f13849a = (ThumbnailProducer[]) Preconditions.a(thumbnailProducerArr);
        Preconditions.a(0, this.f13849a.length);
    }

    public final void m23218a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.a.a == null) {
            consumer.b(null, true);
        } else if (!m23217a(this, 0, consumer, producerContext)) {
            consumer.b(null, true);
        }
    }

    public static boolean m23217a(ThumbnailBranchProducer thumbnailBranchProducer, int i, BaseConsumer baseConsumer, BaseProducerContext baseProducerContext) {
        int a = thumbnailBranchProducer.m23216a(i, baseProducerContext.a.a);
        if (a == -1) {
            return false;
        }
        thumbnailBranchProducer.f13849a[a].a(new ThumbnailConsumer(thumbnailBranchProducer, baseConsumer, baseProducerContext, a), baseProducerContext);
        return true;
    }

    private int m23216a(int i, ResizeOptions resizeOptions) {
        while (i < this.f13849a.length) {
            if (this.f13849a[i].mo1277a(resizeOptions)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
