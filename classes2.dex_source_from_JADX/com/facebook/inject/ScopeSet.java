package com.facebook.inject;

import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: wifi_scan_operation_exception_type */
public class ScopeSet {
    private static final ThreadLocal<ScopeSet> f760b = new C00501();
    public byte f761a = (byte) 0;

    /* compiled from: wifi_scan_operation_exception_type */
    final class C00501 extends ThreadLocal<ScopeSet> {
        C00501() {
        }

        protected final Object initialValue() {
            return new ScopeSet();
        }
    }

    ScopeSet() {
    }

    public static ScopeSet m1499a() {
        return (ScopeSet) f760b.get();
    }

    @Deprecated
    public final byte m1503b() {
        return m1504b((byte) 1);
    }

    public final boolean m1502a(byte b) {
        return (this.f761a & b) != 0;
    }

    public final byte m1504b(byte b) {
        byte b2 = this.f761a;
        this.f761a = (byte) (this.f761a | b);
        return b2;
    }

    public final void m1505c(byte b) {
        this.f761a = b;
    }

    public final void m1501a(byte b, byte... bArr) {
        for (byte b2 : bArr) {
            if (m1502a(b2)) {
                throw new ProvisioningException("Scope violation. Should not call inject " + m1500d(b) + " into " + m1500d(b2));
            }
        }
    }

    private static String m1500d(byte b) {
        switch (b) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "SingletonScope";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "UserScope";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "ContextScope";
            default:
                throw new IllegalArgumentException(String.format("Invalid scope value %s", new Object[]{Integer.toBinaryString(b)}));
        }
    }
}
