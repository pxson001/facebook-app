package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: megaphoneandroidlayouts */
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    private final GenericByteArrayPool f14467a;
    public final Executor f14468b;
    public final ImageDecoder f14469c;
    private final SimpleProgressiveJpegConfig f14470d;
    private final Producer<EncodedImage> f14471e;
    public final boolean f14472f;
    public final boolean f14473g;

    /* compiled from: megaphoneandroidlayouts */
    class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        final /* synthetic */ DecodeProducer f14623a;
        private final ProgressiveJpegParser f14624c;
        private final SimpleProgressiveJpegConfig f14625d;
        private int f14626e = 0;

        public NetworkImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig) {
            this.f14623a = decodeProducer;
            super(decodeProducer, consumer, producerContext);
            this.f14624c = (ProgressiveJpegParser) Preconditions.a(progressiveJpegParser);
            this.f14625d = (SimpleProgressiveJpegConfig) Preconditions.a(progressiveJpegConfig);
        }

        protected final synchronized boolean mo2821a(EncodedImage encodedImage, boolean z) {
            boolean z2 = false;
            synchronized (this) {
                boolean a = super.mo2821a(encodedImage, z);
                if (!z && EncodedImage.m15705e(encodedImage)) {
                    if (this.f14624c.m21037a(encodedImage)) {
                        int b = this.f14624c.m21038b();
                        if (b > this.f14626e && b >= this.f14625d.m16016a(this.f14626e)) {
                            this.f14626e = b;
                        }
                    }
                }
                z2 = a;
            }
            return z2;
        }

        protected final int mo2819a(EncodedImage encodedImage) {
            return this.f14624c.f14621f;
        }

        protected final ImmutableQualityInfo mo2820a() {
            SimpleProgressiveJpegConfig simpleProgressiveJpegConfig = this.f14625d;
            int i = this.f14624c.f14620e;
            return ImmutableQualityInfo.m25101a(i, i >= simpleProgressiveJpegConfig.f10771a.mo2066b(), false);
        }
    }

    /* compiled from: megaphoneandroidlayouts */
    abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public final BaseProducerContext f14627a;
        final /* synthetic */ DecodeProducer f14628b;
        private final ProducerListener f14629c;
        private final ImageDecodeOptions f14630d;
        @GuardedBy("this")
        private boolean f14631e = false;
        public final JobScheduler f14632f;

        protected abstract int mo2819a(EncodedImage encodedImage);

        protected abstract ImmutableQualityInfo mo2820a();

        public final void mo2788a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (z && !EncodedImage.m15705e(encodedImage)) {
                m21046c(new NullPointerException("Encoded image is not valid."));
            } else if (!mo2821a(encodedImage, z)) {
            } else {
                if (z || this.f14627a.m20864h()) {
                    this.f14632f.m21063b();
                }
            }
        }

        public ProgressiveDecoder(final DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext) {
            this.f14628b = decodeProducer;
            super(consumer);
            this.f14627a = producerContext;
            this.f14629c = producerContext.f14482c;
            this.f14630d = producerContext.f14480a.f12750g;
            this.f14632f = new JobScheduler(decodeProducer.f14468b, new JobRunnable(this) {
                final /* synthetic */ ProgressiveDecoder f14635c;

                public final void mo2822a(EncodedImage encodedImage, boolean z) {
                    if (encodedImage != null) {
                        if (this.f14635c.f14628b.f14472f) {
                            ImageRequest imageRequest = producerContext.f14480a;
                            if (this.f14635c.f14628b.f14473g || !UriUtil.m18788a(imageRequest.f12746c)) {
                                int b;
                                if (EncodedImage.m15703c(encodedImage)) {
                                    float b2 = DownsampleUtil.b(imageRequest, encodedImage);
                                    if (encodedImage.f10563c == ImageFormat.JPEG) {
                                        b = DownsampleUtil.b(b2);
                                    } else {
                                        b = DownsampleUtil.a(b2);
                                    }
                                    int max = Math.max(encodedImage.f10566f, encodedImage.f10565e);
                                    while (((float) (max / b)) > 2048.0f) {
                                        if (encodedImage.f10563c == ImageFormat.JPEG) {
                                            b *= 2;
                                        } else {
                                            b++;
                                        }
                                    }
                                } else {
                                    b = 1;
                                }
                                encodedImage.f10567g = b;
                            }
                        }
                        ProgressiveDecoder.m21045c(this.f14635c, encodedImage, z);
                    }
                }
            }, this.f14630d.f12729a);
            this.f14627a.m20856a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ ProgressiveDecoder f14649b;

                public final void mo2817c() {
                    if (this.f14649b.f14627a.m20864h()) {
                        this.f14649b.f14632f.m21063b();
                    }
                }
            });
        }

        public final void mo2790b(Throwable th) {
            m21046c(th);
        }

        public final void mo2791c() {
            m21048f();
        }

        protected boolean mo2821a(EncodedImage encodedImage, boolean z) {
            return this.f14632f.m21062a(encodedImage, z);
        }

        public static void m21045c(ProgressiveDecoder progressiveDecoder, EncodedImage encodedImage, boolean z) {
            if (!progressiveDecoder.m21047e() && EncodedImage.m15705e(encodedImage)) {
                try {
                    long c = progressiveDecoder.f14632f.m21064c();
                    int h = z ? encodedImage.m15718h() : progressiveDecoder.mo2819a(encodedImage);
                    ImmutableQualityInfo a = z ? ImmutableQualityInfo.f17879a : progressiveDecoder.mo2820a();
                    progressiveDecoder.f14629c.mo2106a(progressiveDecoder.f14627a.m20857b(), "DecodeProducer");
                    try {
                        CloseableImage a2 = progressiveDecoder.f14628b.f14469c.m15921a(encodedImage, h, a, progressiveDecoder.f14630d);
                        progressiveDecoder.f14629c.mo2109a(progressiveDecoder.f14627a.m20857b(), "DecodeProducer", progressiveDecoder.m21042a(a2, c, a, z));
                        progressiveDecoder.m21043a(a2, z);
                    } catch (Throwable e) {
                        Throwable th = e;
                        progressiveDecoder.f14629c.mo2108a(progressiveDecoder.f14627a.m20857b(), "DecodeProducer", th, progressiveDecoder.m21042a(null, c, a, z));
                        progressiveDecoder.m21046c(th);
                        EncodedImage.m15704d(encodedImage);
                    }
                } finally {
                    EncodedImage.m15704d(encodedImage);
                }
            }
        }

        private Map<String, String> m21042a(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z) {
            if (!this.f14629c.mo2110a(this.f14627a.m20857b())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.m25103b());
            String valueOf3 = String.valueOf(z);
            String valueOf4 = String.valueOf(this.f14627a.m20853a().m18797a());
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                return ImmutableMap.m3307a("queueTime", valueOf, "hasGoodQuality", valueOf2, "isFinal", valueOf3, "imageType", valueOf4);
            }
            Bitmap a = ((CloseableStaticBitmap) closeableImage).mo2979a();
            return ImmutableMap.m3308a("bitmapSize", a.getWidth() + "x" + a.getHeight(), "queueTime", valueOf, "hasGoodQuality", valueOf2, "isFinal", valueOf3, "imageType", valueOf4);
        }

        private synchronized boolean m21047e() {
            return this.f14631e;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m21044a(boolean r2) {
            /*
            r1 = this;
            monitor-enter(r1);
            if (r2 == 0) goto L_0x0007;
        L_0x0003:
            r0 = r1.f14631e;	 Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0009;
        L_0x0007:
            monitor-exit(r1);	 Catch:{ all -> 0x0013 }
        L_0x0008:
            return;
        L_0x0009:
            r0 = 1;
            r1.f14631e = r0;	 Catch:{ all -> 0x0013 }
            monitor-exit(r1);	 Catch:{ all -> 0x0013 }
            r0 = r1.f14632f;
            r0.m21061a();
            goto L_0x0008;
        L_0x0013:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{  }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.a(boolean):void");
        }

        private void m21043a(CloseableImage closeableImage, boolean z) {
            CloseableReference a = CloseableReference.m15675a((Closeable) closeableImage);
            try {
                m21044a(z);
                m21033d().m20910b(a, z);
            } finally {
                CloseableReference.m15681c(a);
            }
        }

        private void m21046c(Throwable th) {
            m21044a(true);
            this.f14615a.m20907a(th);
        }

        private void m21048f() {
            m21044a(true);
            this.f14615a.m20908b();
        }
    }

    public final void mo2774a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        BaseConsumer networkImagesProgressiveDecoder;
        if (UriUtil.m18788a(producerContext.f14480a.f12746c)) {
            networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(this, consumer, producerContext, new ProgressiveJpegParser(this.f14467a), this.f14470d);
        } else {
            networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(this, consumer, producerContext);
        }
        this.f14471e.mo2774a(networkImagesProgressiveDecoder, producerContext);
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, Producer<EncodedImage> producer) {
        this.f14467a = (GenericByteArrayPool) Preconditions.a(byteArrayPool);
        this.f14468b = (Executor) Preconditions.a(executor);
        this.f14469c = (ImageDecoder) Preconditions.a(imageDecoder);
        this.f14470d = (SimpleProgressiveJpegConfig) Preconditions.a(progressiveJpegConfig);
        this.f14472f = z;
        this.f14473g = z2;
        this.f14471e = (Producer) Preconditions.a(producer);
    }
}
