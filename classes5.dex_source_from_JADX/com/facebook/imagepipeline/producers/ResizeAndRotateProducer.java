package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: TOPIC_LIBRARY */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public final Executor f13834a;
    public final NativePooledByteBufferFactory f13835b;
    private final Producer<EncodedImage> f13836c;

    /* compiled from: TOPIC_LIBRARY */
    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        final /* synthetic */ ResizeAndRotateProducer f13830a;
        public final BaseProducerContext f13831b;
        public boolean f13832c = false;
        public final JobScheduler f13833d;

        public static void m23202b(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer r8, com.facebook.imagepipeline.image.EncodedImage r9, boolean r10) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:18:0x0075 in {15, 17, 20, 21, 25, 27, 28, 29, 32} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = 0;
            r0 = r8.f13831b;
            r0 = r0.c();
            r2 = r8.f13831b;
            r2 = r2.b();
            r3 = "ResizeAndRotateProducer";
            r0.a(r2, r3);
            r0 = r8.f13831b;
            r0 = r0.a();
            r2 = r8.f13830a;
            r2 = r2.f13835b;
            r3 = r2.a();
            r4 = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.m23204e(r0, r9);	 Catch:{ Exception -> 0x00a1 }
            r2 = r8.m23201a(r9, r0, r4);	 Catch:{ Exception -> 0x00a1 }
            r1 = r9.b();	 Catch:{ Exception -> 0x0079 }
            r0 = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.m23205f(r0, r9);	 Catch:{ Exception -> 0x0079 }
            r5 = 85;	 Catch:{ Exception -> 0x0079 }
            com.facebook.imagepipeline.nativecode.JpegTranscoder.a(r1, r3, r0, r4, r5);	 Catch:{ Exception -> 0x0079 }
            r0 = r3.a();	 Catch:{ Exception -> 0x0079 }
            r4 = com.facebook.common.references.CloseableReference.a(r0);	 Catch:{ Exception -> 0x0079 }
            r5 = new com.facebook.imagepipeline.image.EncodedImage;	 Catch:{ all -> 0x0074 }
            r5.<init>(r4);	 Catch:{ all -> 0x0074 }
            r0 = com.facebook.imageformat.ImageFormat.JPEG;	 Catch:{ all -> 0x0074 }
            r5.a(r0);	 Catch:{ all -> 0x0074 }
            r5.i();	 Catch:{ all -> 0x006f }
            r0 = r8.f13831b;	 Catch:{ all -> 0x006f }
            r0 = r0.c();	 Catch:{ all -> 0x006f }
            r6 = r8.f13831b;	 Catch:{ all -> 0x006f }
            r6 = r6.b();	 Catch:{ all -> 0x006f }
            r7 = "ResizeAndRotateProducer";	 Catch:{ all -> 0x006f }
            r0.a(r6, r7, r2);	 Catch:{ all -> 0x006f }
            r0 = r8.d();	 Catch:{ all -> 0x006f }
            r0.b(r5, r10);	 Catch:{ all -> 0x006f }
            com.facebook.imagepipeline.image.EncodedImage.d(r5);
            com.facebook.common.references.CloseableReference.c(r4);
            com.facebook.common.internal.Closeables.a(r1);
            r3.close();
        L_0x006e:
            return;
        L_0x006f:
            r0 = move-exception;
            com.facebook.imagepipeline.image.EncodedImage.d(r5);	 Catch:{ all -> 0x006f }
            throw r0;	 Catch:{ all -> 0x006f }
        L_0x0074:
            r0 = move-exception;
            com.facebook.common.references.CloseableReference.c(r4);	 Catch:{ all -> 0x0074 }
            throw r0;	 Catch:{ all -> 0x0074 }
        L_0x0079:
            r0 = move-exception;
        L_0x007a:
            r4 = r8.f13831b;	 Catch:{ all -> 0x0099 }
            r4 = r4.c();	 Catch:{ all -> 0x0099 }
            r5 = r8.f13831b;	 Catch:{ all -> 0x0099 }
            r5 = r5.b();	 Catch:{ all -> 0x0099 }
            r6 = "ResizeAndRotateProducer";	 Catch:{ all -> 0x0099 }
            r4.a(r5, r6, r0, r2);	 Catch:{ all -> 0x0099 }
            r2 = r8.d();	 Catch:{ all -> 0x0099 }
            r2.a(r0);	 Catch:{ all -> 0x0099 }
            com.facebook.common.internal.Closeables.a(r1);
            r3.close();
            goto L_0x006e;
        L_0x0099:
            r0 = move-exception;
            com.facebook.common.internal.Closeables.a(r1);
            r3.close();
            throw r0;
        L_0x00a1:
            r0 = move-exception;
            r2 = r1;
            goto L_0x007a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.b(com.facebook.imagepipeline.producers.ResizeAndRotateProducer$TransformingConsumer, com.facebook.imagepipeline.image.EncodedImage, boolean):void");
        }

        protected final void m23203a(@Nullable Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (!this.f13832c) {
                if (encodedImage != null) {
                    TriState triState;
                    ImageRequest imageRequest = this.f13831b.a;
                    if (encodedImage == null || encodedImage.c == ImageFormat.UNKNOWN) {
                        triState = TriState.UNSET;
                    } else if (encodedImage.c != ImageFormat.JPEG) {
                        triState = TriState.NO;
                    } else {
                        boolean z2;
                        if (ResizeAndRotateProducer.m23205f(imageRequest, encodedImage) == 0) {
                            if ((ResizeAndRotateProducer.m23204e(imageRequest, encodedImage) < 8 ? 1 : null) == null) {
                                z2 = false;
                                triState = TriState.valueOf(z2);
                            }
                        }
                        z2 = true;
                        triState = TriState.valueOf(z2);
                    }
                    TriState triState2 = triState;
                    if (!z && triState2 == TriState.UNSET) {
                        return;
                    }
                    if (triState2 != TriState.YES) {
                        this.a.b(encodedImage, z);
                    } else if (!this.f13833d.a(encodedImage, z)) {
                    } else {
                        if (z || this.f13831b.h()) {
                            this.f13833d.b();
                        }
                    }
                } else if (z) {
                    this.a.b(null, true);
                }
            }
        }

        public TransformingConsumer(final ResizeAndRotateProducer resizeAndRotateProducer, final Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            this.f13830a = resizeAndRotateProducer;
            super(consumer);
            this.f13831b = producerContext;
            this.f13833d = new JobScheduler(resizeAndRotateProducer.f13834a, new JobRunnable(this) {
                final /* synthetic */ TransformingConsumer f13826b;

                public final void m23198a(EncodedImage encodedImage, boolean z) {
                    TransformingConsumer.m23202b(this.f13826b, encodedImage, z);
                }
            }, 100);
            this.f13831b.a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ TransformingConsumer f13829c;

                public final void m23200c() {
                    if (this.f13829c.f13831b.h()) {
                        this.f13829c.f13833d.b();
                    }
                }

                public final void m23199a() {
                    this.f13829c.f13833d.a();
                    this.f13829c.f13832c = true;
                    consumer.b();
                }
            });
        }

        private Map<String, String> m23201a(EncodedImage encodedImage, ImageRequest imageRequest, int i) {
            if (!this.f13831b.c.a(this.f13831b.b)) {
                return null;
            }
            Object obj;
            String str = encodedImage.e + "x" + encodedImage.f;
            if (imageRequest.a != null) {
                obj = imageRequest.a.a + "x" + imageRequest.a.b;
            } else {
                obj = "Unspecified";
            }
            return ImmutableMap.a("Original size", str, "Requested size", obj, "Fraction", i > 0 ? i + "/8" : "", "queueTime", String.valueOf(this.f13833d.c()));
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.f13834a = (Executor) Preconditions.a(executor);
        this.f13835b = (NativePooledByteBufferFactory) Preconditions.a(pooledByteBufferFactory);
        this.f13836c = (Producer) Preconditions.a(producer);
    }

    public final void m23206a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.f13836c.a(new TransformingConsumer(this, consumer, producerContext), producerContext);
    }

    public static int m23204e(ImageRequest imageRequest, EncodedImage encodedImage) {
        ResizeOptions resizeOptions = imageRequest.a;
        if (resizeOptions == null) {
            return 8;
        }
        int i;
        float f;
        int f2 = m23205f(imageRequest, encodedImage);
        Object obj = (f2 == 90 || f2 == 270) ? 1 : null;
        if (obj != null) {
            i = encodedImage.f;
        } else {
            i = encodedImage.e;
        }
        if (obj != null) {
            f2 = encodedImage.e;
        } else {
            f2 = encodedImage.f;
        }
        if (resizeOptions == null) {
            f = 1.0f;
        } else {
            f = Math.max(((float) resizeOptions.a) / ((float) i), ((float) resizeOptions.b) / ((float) f2));
            if (((float) i) * f > 2048.0f) {
                f = 2048.0f / ((float) i);
            }
            if (((float) f2) * f > 2048.0f) {
                f = 2048.0f / ((float) f2);
            }
        }
        f2 = (int) (0.6666667f + (8.0f * f));
        if (f2 > 8) {
            return 8;
        }
        if (f2 <= 0) {
            return 1;
        }
        return f2;
    }

    public static int m23205f(ImageRequest imageRequest, EncodedImage encodedImage) {
        boolean z = false;
        if (!imageRequest.h) {
            return 0;
        }
        int i = encodedImage.d;
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            z = true;
        }
        Preconditions.a(z);
        return i;
    }
}
