package com.facebook.tigon.tigonapi;

import com.facebook.tigon.flatbuffers.FlatAndroidRetryRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonError;
import com.facebook.tigon.flatbuffers.FlatTigonRequest;
import com.facebook.tigon.iface.AndroidRetryRequestInfo;
import com.facebook.tigon.iface.FacebookLoggingRequestInfo;
import com.facebook.tigon.iface.TigonDelayerRequestInfoImpl;
import com.facebook.tigon.iface.TigonIdleTimeoutRequestInfoImpl;
import com.facebook.tigon.iface.TigonLigerRequestInfoImpl;
import com.facebook.tigon.iface.TigonPriorityQueueRequestTypeInfoImpl;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonRequestLayers;
import com.facebook.tigon.iface.TigonRequestTimeoutRequestInfoImpl;
import com.facebook.tigon.iface.TigonRetrierRequestInfo;
import com.facebook.tigon.iface.TigonSamplingConfigInfoImpl;
import com.facebook.tigon.iface.TigonSwitcherRequestInfoImpl;
import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: northBound */
public class FlatBufferSerializer {
    private static int f5025a = 64;
    private static final FlatBufferBuilder f5026b = new FlatBufferBuilder();
    private static int[] f5027c = new int[32];

    private static int m6322a(int i, int i2) {
        if (i >= f5027c.length) {
            Object obj = f5027c;
            f5027c = new int[(obj.length * 2)];
            System.arraycopy(obj, 0, f5027c, 0, obj.length);
        }
        f5027c[i] = i2;
        return i + 1;
    }

    private static int m6324a(@Nullable FacebookLoggingRequestInfo facebookLoggingRequestInfo) {
        if (facebookLoggingRequestInfo == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        int a = f5026b.a(facebookLoggingRequestInfo.logName());
        int a2 = f5026b.a(facebookLoggingRequestInfo.logNamespace());
        flatBufferBuilder.b(2);
        flatBufferBuilder.c(1, a2, 0);
        flatBufferBuilder.c(0, a, 0);
        return flatBufferBuilder.c();
    }

    private static int m6330a(@Nullable TigonRetrierRequestInfo tigonRetrierRequestInfo) {
        if (tigonRetrierRequestInfo == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        boolean a = tigonRetrierRequestInfo.a();
        flatBufferBuilder.b(1);
        flatBufferBuilder.a(0, a, false);
        return flatBufferBuilder.c();
    }

    private static int m6328a(@Nullable TigonPriorityQueueRequestTypeInfoImpl tigonPriorityQueueRequestTypeInfoImpl) {
        if (tigonPriorityQueueRequestTypeInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        int i = tigonPriorityQueueRequestTypeInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.b(0, i, 0);
        return flatBufferBuilder.c();
    }

    private static int m6332a(@Nullable TigonSwitcherRequestInfoImpl tigonSwitcherRequestInfoImpl) {
        if (tigonSwitcherRequestInfoImpl == null) {
            return 0;
        }
        int i;
        int i2 = 0;
        for (String a : tigonSwitcherRequestInfoImpl.a) {
            i2 = m6322a(i2, f5026b.a(a));
        }
        f5026b.a(4, i2, 4);
        for (i = i2 - 1; i >= 0; i--) {
            f5026b.a(f5027c[i]);
        }
        i = f5026b.b();
        FlatBufferBuilder flatBufferBuilder = f5026b;
        flatBufferBuilder.b(1);
        flatBufferBuilder.c(0, i, 0);
        return flatBufferBuilder.c();
    }

    private static int m6325a(@Nullable TigonDelayerRequestInfoImpl tigonDelayerRequestInfoImpl) {
        if (tigonDelayerRequestInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        long j = tigonDelayerRequestInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.a(0, j, 0);
        return flatBufferBuilder.c();
    }

    private static int m6326a(@Nullable TigonIdleTimeoutRequestInfoImpl tigonIdleTimeoutRequestInfoImpl) {
        if (tigonIdleTimeoutRequestInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        long j = tigonIdleTimeoutRequestInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.a(0, j, 0);
        return flatBufferBuilder.c();
    }

    private static int m6329a(@Nullable TigonRequestTimeoutRequestInfoImpl tigonRequestTimeoutRequestInfoImpl) {
        if (tigonRequestTimeoutRequestInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        long j = tigonRequestTimeoutRequestInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.a(0, j, 0);
        return flatBufferBuilder.c();
    }

    private static int m6331a(@Nullable TigonSamplingConfigInfoImpl tigonSamplingConfigInfoImpl) {
        if (tigonSamplingConfigInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        int i = tigonSamplingConfigInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.b(0, i, 0);
        return flatBufferBuilder.c();
    }

    private static int m6323a(@Nullable AndroidRetryRequestInfo androidRetryRequestInfo) {
        if (androidRetryRequestInfo == null) {
            return 0;
        }
        return FlatAndroidRetryRequestInfo.m6117a(f5026b, androidRetryRequestInfo.a(), androidRetryRequestInfo.b(), androidRetryRequestInfo.c(), androidRetryRequestInfo.d());
    }

    private static int m6327a(@Nullable TigonLigerRequestInfoImpl tigonLigerRequestInfoImpl) {
        if (tigonLigerRequestInfoImpl == null) {
            return 0;
        }
        FlatBufferBuilder flatBufferBuilder = f5026b;
        boolean z = tigonLigerRequestInfoImpl.a;
        flatBufferBuilder.b(1);
        flatBufferBuilder.a(0, z, false);
        return flatBufferBuilder.c();
    }

    private static ByteBuffer m6333a() {
        ByteBuffer byteBuffer = f5026b.a;
        f5025a = Math.max(f5025a, byteBuffer.limit());
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.limit() - byteBuffer.position());
        allocateDirect.put(byteBuffer);
        allocateDirect.position(0);
        return allocateDirect;
    }

    public static synchronized ByteBuffer m6334a(TigonRequest tigonRequest) {
        ByteBuffer a;
        synchronized (FlatBufferSerializer.class) {
            f5026b.a(ByteBuffer.allocateDirect(f5025a));
            int i = 0;
            for (Entry entry : tigonRequest.c().entrySet()) {
                i = m6322a(m6322a(i, f5026b.a((String) entry.getKey())), f5026b.a((String) entry.getValue()));
            }
            FlatTigonRequest.m6140a(f5026b, i);
            for (int i2 = i - 1; i2 >= 0; i2--) {
                f5026b.a(f5027c[i2]);
            }
            FlatTigonRequest.m6141b(f5026b, FlatTigonRequest.m6138a(f5026b, f5026b.a(tigonRequest.a()), f5026b.a(tigonRequest.b()), f5026b.b(), tigonRequest.d().a, tigonRequest.d().b, m6324a((FacebookLoggingRequestInfo) tigonRequest.a(TigonRequestLayers.c)), m6326a((TigonIdleTimeoutRequestInfoImpl) tigonRequest.a(TigonRequestLayers.d)), m6325a((TigonDelayerRequestInfoImpl) tigonRequest.a(TigonRequestLayers.b)), m6329a((TigonRequestTimeoutRequestInfoImpl) tigonRequest.a(TigonRequestLayers.g)), m6330a((TigonRetrierRequestInfo) tigonRequest.a(TigonRequestLayers.h)), m6328a((TigonPriorityQueueRequestTypeInfoImpl) tigonRequest.a(TigonRequestLayers.f)), m6331a((TigonSamplingConfigInfoImpl) tigonRequest.a(TigonRequestLayers.i)), m6332a((TigonSwitcherRequestInfoImpl) tigonRequest.a(TigonRequestLayers.j)), m6323a((AndroidRetryRequestInfo) tigonRequest.a(TigonRequestLayers.a)), m6327a((TigonLigerRequestInfoImpl) tigonRequest.a(TigonRequestLayers.e))));
            a = m6333a();
        }
        return a;
    }

    public static synchronized ByteBuffer m6335a(TigonError tigonError) {
        ByteBuffer a;
        synchronized (FlatBufferSerializer.class) {
            f5026b.a(ByteBuffer.allocateDirect(f5025a));
            f5026b.c(FlatTigonError.m6124a(f5026b, tigonError.f5030a, f5026b.a(tigonError.f5031b), tigonError.f5032c, f5026b.a(tigonError.f5033d)));
            a = m6333a();
        }
        return a;
    }
}
