package com.facebook.messaging.media.upload.udp;

import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.Allocator;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import java.util.Arrays;

/* compiled from: last_notification_update_time */
public class UDPByteBufferBuilder {
    private static final ObjectPool<byte[]> f12149a;

    /* compiled from: last_notification_update_time */
    final class C13461 implements Allocator<byte[]> {
        C13461() {
        }

        public final /* bridge */ /* synthetic */ void m12659a(Object obj) {
        }

        public final Object m12658a() {
            return new byte[2000];
        }
    }

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(byte[].class, AwakeTimeSinceBootClock.INSTANCE);
        objectPoolBuilder.f = new C13461();
        objectPoolBuilder = objectPoolBuilder;
        objectPoolBuilder.c = 100;
        f12149a = objectPoolBuilder.a();
    }

    public static byte[] m12661a() {
        byte[] bArr = (byte[]) f12149a.a();
        Arrays.fill(bArr, (byte) 0);
        return bArr;
    }

    public static void m12660a(byte[] bArr) {
        f12149a.a(bArr);
    }
}
