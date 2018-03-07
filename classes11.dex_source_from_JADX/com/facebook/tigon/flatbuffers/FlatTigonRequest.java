package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.facebook.tigon.tigonapi.FlatBuffersHelpers;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_total_logging_writes */
public final class FlatTigonRequest extends Table {
    public static FlatTigonRequest m6139a(ByteBuffer byteBuffer, FlatTigonRequest flatTigonRequest) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        flatTigonRequest.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        flatTigonRequest.b = byteBuffer;
        return flatTigonRequest;
    }

    public final String m6165a() {
        int a = a(4);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }

    public final String m6166b() {
        int a = a(6);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }

    public final String m6170f(int i) {
        int a = a(8);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, e(a) + (i * 4)) : null;
    }

    public final int m6167c() {
        int a = a(8);
        return a != 0 ? d(a) : 0;
    }

    public final int m6168d() {
        int a = a(10);
        return a != 0 ? this.b.getShort(a + this.a) & 65535 : 0;
    }

    public final int m6169e() {
        int a = a(12);
        return a != 0 ? this.b.getShort(a + this.a) & 65535 : 0;
    }

    public final FlatFacebookLoggingRequestInfo m6157a(FlatFacebookLoggingRequestInfo flatFacebookLoggingRequestInfo) {
        int a = a(14);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatFacebookLoggingRequestInfo.a = a;
        flatFacebookLoggingRequestInfo.b = byteBuffer;
        return flatFacebookLoggingRequestInfo;
    }

    public final FlatTigonIdleTimeoutRequestInfo m6159a(FlatTigonIdleTimeoutRequestInfo flatTigonIdleTimeoutRequestInfo) {
        int a = a(16);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonIdleTimeoutRequestInfo.a = a;
        flatTigonIdleTimeoutRequestInfo.b = byteBuffer;
        return flatTigonIdleTimeoutRequestInfo;
    }

    public final FlatTigonDelayerRequestInfo m6158a(FlatTigonDelayerRequestInfo flatTigonDelayerRequestInfo) {
        int a = a(18);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonDelayerRequestInfo.a = a;
        flatTigonDelayerRequestInfo.b = byteBuffer;
        return flatTigonDelayerRequestInfo;
    }

    public final FlatTigonRequestTimeoutRequestInfo m6162a(FlatTigonRequestTimeoutRequestInfo flatTigonRequestTimeoutRequestInfo) {
        int a = a(20);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonRequestTimeoutRequestInfo.a = a;
        flatTigonRequestTimeoutRequestInfo.b = byteBuffer;
        return flatTigonRequestTimeoutRequestInfo;
    }

    public final FlatTigonRetrierRequestInfo m6163a(FlatTigonRetrierRequestInfo flatTigonRetrierRequestInfo) {
        int a = a(22);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonRetrierRequestInfo.a = a;
        flatTigonRetrierRequestInfo.b = byteBuffer;
        return flatTigonRetrierRequestInfo;
    }

    public final FlatTigonPriorityQueueRequestTypeInfo m6161a(FlatTigonPriorityQueueRequestTypeInfo flatTigonPriorityQueueRequestTypeInfo) {
        int a = a(24);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonPriorityQueueRequestTypeInfo.a = a;
        flatTigonPriorityQueueRequestTypeInfo.b = byteBuffer;
        return flatTigonPriorityQueueRequestTypeInfo;
    }

    public final FlatTigonSwitcherRequestInfo m6164a(FlatTigonSwitcherRequestInfo flatTigonSwitcherRequestInfo) {
        int a = a(28);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonSwitcherRequestInfo.a = a;
        flatTigonSwitcherRequestInfo.b = byteBuffer;
        return flatTigonSwitcherRequestInfo;
    }

    public final FlatTigonLigerRequestInfo m6160a(FlatTigonLigerRequestInfo flatTigonLigerRequestInfo) {
        int a = a(32);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonLigerRequestInfo.a = a;
        flatTigonLigerRequestInfo.b = byteBuffer;
        return flatTigonLigerRequestInfo;
    }

    public static int m6138a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        flatBufferBuilder.b(15);
        m6156q(flatBufferBuilder, i15);
        m6155p(flatBufferBuilder, i14);
        m6154o(flatBufferBuilder, i13);
        m6153n(flatBufferBuilder, i12);
        m6152m(flatBufferBuilder, i11);
        m6151l(flatBufferBuilder, i10);
        m6150k(flatBufferBuilder, i9);
        m6149j(flatBufferBuilder, i8);
        m6148i(flatBufferBuilder, i7);
        m6147h(flatBufferBuilder, i6);
        m6144e(flatBufferBuilder, i3);
        m6143d(flatBufferBuilder, i2);
        m6142c(flatBufferBuilder, i);
        m6146g(flatBufferBuilder, i5);
        m6145f(flatBufferBuilder, i4);
        return m6137a(flatBufferBuilder);
    }

    private static void m6142c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(0, i, 0);
    }

    private static void m6143d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(1, i, 0);
    }

    private static void m6144e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(2, i, 0);
    }

    public static void m6140a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.a(4, i, 4);
    }

    private static void m6145f(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.a(3, (short) (65535 & i), 0);
    }

    private static void m6146g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.a(4, (short) (65535 & i), 0);
    }

    private static void m6147h(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(5, i, 0);
    }

    private static void m6148i(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(6, i, 0);
    }

    private static void m6149j(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(7, i, 0);
    }

    private static void m6150k(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(8, i, 0);
    }

    private static void m6151l(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(9, i, 0);
    }

    private static void m6152m(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(10, i, 0);
    }

    private static void m6153n(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(11, i, 0);
    }

    private static void m6154o(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(12, i, 0);
    }

    private static void m6155p(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(13, i, 0);
    }

    private static void m6156q(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(14, i, 0);
    }

    private static int m6137a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.c();
    }

    public static void m6141b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.c(i);
    }
}
