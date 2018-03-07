package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

/* compiled from: fromInterface */
public class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {
    private final LongArray f11653a = LongArray.m13594a(20);
    private final LongArray f11654b = LongArray.m13594a(20);
    private final LongArray f11655c = LongArray.m13594a(20);
    private final LongArray f11656d = LongArray.m13594a(20);
    private volatile boolean f11657e = true;

    public final synchronized void mo727a() {
        this.f11653a.m13598a(System.nanoTime());
    }

    public final synchronized void mo728b() {
        this.f11654b.m13598a(System.nanoTime());
    }

    public final synchronized void mo729c() {
        this.f11655c.m13598a(System.nanoTime());
    }

    public final synchronized void mo730d() {
        this.f11656d.m13598a(System.nanoTime());
    }

    public final synchronized boolean m13730a(long j, long j2) {
        boolean z = true;
        synchronized (this) {
            boolean a = m13726a(this.f11656d, j, j2);
            boolean b = m13728b(j, j2);
            if (!a && (!b || m13726a(this.f11655c, j, j2))) {
                z = false;
            }
            m13725a(this.f11653a, j2);
            m13725a(this.f11654b, j2);
            m13725a(this.f11655c, j2);
            m13725a(this.f11656d, j2);
            this.f11657e = b;
        }
        return z;
    }

    private static boolean m13726a(LongArray longArray, long j, long j2) {
        for (int i = 0; i < longArray.f11580b; i++) {
            long b = longArray.m13599b(i);
            if (b >= j && b < j2) {
                return true;
            }
        }
        return false;
    }

    private static long m13727b(LongArray longArray, long j, long j2) {
        long j3 = -1;
        for (int i = 0; i < longArray.f11580b; i++) {
            long b = longArray.m13599b(i);
            if (b >= j && b < j2) {
                j3 = b;
            } else if (b >= j2) {
                break;
            }
        }
        return j3;
    }

    private boolean m13728b(long j, long j2) {
        long b = m13727b(this.f11653a, j, j2);
        long b2 = m13727b(this.f11654b, j, j2);
        if (b == -1 && b2 == -1) {
            return this.f11657e;
        }
        return b > b2;
    }

    private static void m13725a(LongArray longArray, long j) {
        int i = 0;
        int i2 = longArray.f11580b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (longArray.m13599b(i4) < j) {
                i3++;
            }
        }
        if (i3 > 0) {
            while (i < i2 - i3) {
                longArray.m13597a(i, longArray.m13599b(i + i3));
                i++;
            }
            longArray.m13600c(i3);
        }
    }
}
