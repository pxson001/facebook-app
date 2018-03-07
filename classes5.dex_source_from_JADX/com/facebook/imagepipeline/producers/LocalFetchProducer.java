package com.facebook.imagepipeline.producers;

import android.os.Build.VERSION;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_SCHOOL */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    private final Executor f13752a;
    private final NativePooledByteBufferFactory f13753b;
    private final boolean f13754c;

    protected abstract EncodedImage mo1275a(ImageRequest imageRequest);

    protected abstract String mo1276a();

    protected LocalFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, boolean z) {
        this.f13752a = executor;
        this.f13753b = nativePooledByteBufferFactory;
        boolean z2 = z && VERSION.SDK_INT == 19;
        this.f13754c = z2;
    }

    public final void m23105a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener producerListener = producerContext.c;
        String str = producerContext.b;
        final ImageRequest imageRequest = producerContext.a;
        final C13081 c13081 = new StatefulProducerRunnable<EncodedImage>(this, consumer, producerListener, mo1276a(), str) {
            final /* synthetic */ LocalFetchProducer f13785c;

            protected final void m23150b(Object obj) {
                EncodedImage.d((EncodedImage) obj);
            }

            protected final Object m23151c() {
                Object a = this.f13785c.mo1275a(imageRequest);
                if (a == null) {
                    return null;
                }
                a.i();
                return a;
            }
        };
        producerContext.a(new BaseProducerContextCallbacks(this) {
            final /* synthetic */ LocalFetchProducer f13787b;

            public final void m23152a() {
                c13081.a();
            }
        });
        ExecutorDetour.a(this.f13752a, c13081, 2092063591);
    }

    protected final EncodedImage m23103a(InputStream inputStream, int i) {
        CloseableReference a;
        if (i < 0) {
            try {
                a = CloseableReference.a(this.f13753b.a(inputStream));
            } catch (Throwable th) {
                Closeables.a(inputStream);
                CloseableReference.c(null);
            }
        } else {
            a = CloseableReference.a(this.f13753b.a(inputStream, i));
        }
        EncodedImage encodedImage = new EncodedImage(a);
        Closeables.a(inputStream);
        CloseableReference.c(a);
        return encodedImage;
    }

    protected final EncodedImage m23106b(InputStream inputStream, int i) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long min = Math.min(maxMemory - (runtime.totalMemory() - runtime.freeMemory()), 8388608);
        if (!this.f13754c || !(inputStream instanceof FileInputStream) || maxMemory < min * 64) {
            return m23103a(inputStream, i);
        }
        final File file = new File(inputStream.toString());
        return new EncodedImage(new Supplier<FileInputStream>(this) {
            final /* synthetic */ LocalFetchProducer f13789b;

            public final Object m23153a() {
                try {
                    return new FileInputStream(file);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }, i);
    }
}
