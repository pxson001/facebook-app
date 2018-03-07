package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.Map;

/* compiled from: memory_cache_lru_size */
public class NetworkFetchProducer implements Producer<EncodedImage> {
    private final NativePooledByteBufferFactory f14451a;
    private final GenericByteArrayPool f14452b;
    public final BaseNetworkFetcher f14453c;

    public NetworkFetchProducer(NativePooledByteBufferFactory nativePooledByteBufferFactory, GenericByteArrayPool genericByteArrayPool, BaseNetworkFetcher baseNetworkFetcher) {
        this.f14451a = nativePooledByteBufferFactory;
        this.f14452b = genericByteArrayPool;
        this.f14453c = baseNetworkFetcher;
    }

    public final void mo2774a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.f14482c.mo2106a(producerContext.f14481b, "NetworkFetchProducer");
        final FetchState a = this.f14453c.mo2059a((BaseConsumer) consumer, (BaseProducerContext) producerContext);
        this.f14453c.mo2061a(a, new Object(this) {
            final /* synthetic */ NetworkFetchProducer f14717b;

            public final void m21135a(InputStream inputStream, int i) {
                NetworkFetchProducer.m20821a(this.f14717b, a, inputStream, i);
            }

            public final void m21136a(Throwable th) {
                NetworkFetchProducer networkFetchProducer = this.f14717b;
                FetchState fetchState = a;
                fetchState.m21132d().mo2108a(fetchState.m21131c(), "NetworkFetchProducer", th, null);
                fetchState.f14713a.m20907a(th);
            }

            public final void m21134a() {
                NetworkFetchProducer networkFetchProducer = this.f14717b;
                FetchState fetchState = a;
                fetchState.m21132d().mo2112b(fetchState.m21131c(), "NetworkFetchProducer", null);
                fetchState.f14713a.m20908b();
            }
        });
    }

    public static void m20821a(NetworkFetchProducer networkFetchProducer, FetchState fetchState, InputStream inputStream, int i) {
        PooledByteBufferOutputStream a;
        if (i > 0) {
            a = networkFetchProducer.f14451a.m15780a(i);
        } else {
            a = networkFetchProducer.f14451a.m15779a();
        }
        Object obj = (byte[]) networkFetchProducer.f14452b.mo2018a(16384);
        while (true) {
            try {
                int read = inputStream.read(obj);
                if (read < 0) {
                    break;
                } else if (read > 0) {
                    a.write(obj, 0, read);
                    networkFetchProducer.m20819a(a, fetchState);
                    fetchState.m21129a().m20905a(m20818a(a.mo2898b(), i));
                }
            } finally {
                networkFetchProducer.f14452b.mo2019a(obj);
                a.close();
            }
        }
        networkFetchProducer.f14453c.mo2060a(fetchState, a.mo2898b());
        networkFetchProducer.m20822b(a, fetchState);
    }

    private static float m20818a(int i, int i2) {
        return i2 > 0 ? ((float) i) / ((float) i2) : 1.0f - ((float) Math.exp(((double) (-i)) / 50000.0d));
    }

    private void m20819a(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        boolean a;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (fetchState.f14714b.f14480a.f12748e) {
            a = this.f14453c.mo2062a(fetchState);
        } else {
            a = false;
        }
        if (a && uptimeMillis - fetchState.f14715c >= 100) {
            fetchState.f14715c = uptimeMillis;
            fetchState.m21132d().mo2107a(fetchState.m21131c(), "NetworkFetchProducer", "intermediate_result");
            m20820a(pooledByteBufferOutputStream, false, fetchState.f14713a);
        }
    }

    private void m20822b(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map b;
        int b2 = pooledByteBufferOutputStream.mo2898b();
        if (fetchState.m21132d().mo2110a(fetchState.m21131c())) {
            b = this.f14453c.mo2063b(fetchState, b2);
        } else {
            b = null;
        }
        fetchState.m21132d().mo2109a(fetchState.m21131c(), "NetworkFetchProducer", b);
        m20820a(pooledByteBufferOutputStream, true, fetchState.f14713a);
    }

    private static void m20820a(PooledByteBufferOutputStream pooledByteBufferOutputStream, boolean z, Consumer<EncodedImage> consumer) {
        Throwable th;
        CloseableReference a = CloseableReference.m15675a(pooledByteBufferOutputStream.mo2897a());
        EncodedImage encodedImage;
        try {
            encodedImage = new EncodedImage(a);
            try {
                encodedImage.m15719i();
                consumer.m20910b(encodedImage, z);
                EncodedImage.m15704d(encodedImage);
                CloseableReference.m15681c(a);
            } catch (Throwable th2) {
                th = th2;
                EncodedImage.m15704d(encodedImage);
                CloseableReference.m15681c(a);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            encodedImage = null;
            EncodedImage.m15704d(encodedImage);
            CloseableReference.m15681c(a);
            throw th;
        }
    }
}
