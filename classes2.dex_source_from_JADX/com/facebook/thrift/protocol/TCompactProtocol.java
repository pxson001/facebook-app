package com.facebook.thrift.protocol;

import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.thrift.ShortStack;
import com.facebook.thrift.TException;
import com.facebook.thrift.transport.TTransport;
import java.io.UnsupportedEncodingException;

/* compiled from: flyoutLauncherStoryIndex */
public final class TCompactProtocol extends TProtocol {
    private static final TStruct f23585d = new TStruct("");
    private static final TField f23586f = new TField("", (byte) 0, (short) 0);
    private static final byte[] f23587g;
    byte[] f23588a = new byte[5];
    byte[] f23589b = new byte[10];
    byte[] f23590c = new byte[1];
    private ShortStack f23591h = new ShortStack(15);
    private short f23592i = (short) 0;
    private byte f23593j = (byte) 2;
    private TField f23594k = null;
    private Boolean f23595l = null;
    private byte[] f23596m = new byte[1];

    /* compiled from: flyoutLauncherStoryIndex */
    public class Factory implements TProtocolFactory {
        public final TProtocol mo3465a(TTransport tTransport) {
            return new TCompactProtocol(tTransport);
        }
    }

    static {
        byte[] bArr = new byte[16];
        f23587g = bArr;
        bArr[0] = (byte) 0;
        f23587g[2] = (byte) 1;
        f23587g[3] = (byte) 3;
        f23587g[6] = (byte) 4;
        f23587g[8] = (byte) 5;
        f23587g[10] = (byte) 6;
        f23587g[4] = (byte) 7;
        f23587g[11] = (byte) 8;
        f23587g[15] = (byte) 9;
        f23587g[14] = (byte) 10;
        f23587g[13] = (byte) 11;
        f23587g[12] = (byte) 12;
    }

    public TCompactProtocol(TTransport tTransport) {
        super(tTransport);
    }

    public final void mo3468a() {
        this.f23591h.m32000a(this.f23592i);
        this.f23592i = (short) 0;
    }

    public final void mo3479b() {
        this.f23592i = this.f23591h.m31999a();
    }

    public final void mo3472a(TField tField) {
        if (tField.f23578b == (byte) 2) {
            this.f23594k = tField;
        } else {
            m31927a(tField, (byte) -1);
        }
    }

    private void m31927a(TField tField, byte b) {
        if (b == (byte) -1) {
            b = m31937e(tField.f23578b);
        }
        if (tField.f23579c <= this.f23592i || tField.f23579c - this.f23592i > 15) {
            m31929b(b);
            mo3476a(tField.f23579c);
        } else {
            m31936d(((tField.f23579c - this.f23592i) << 4) | b);
        }
        this.f23592i = tField.f23579c;
    }

    public final void mo3480c() {
        m31929b((byte) 0);
    }

    public final void mo3474a(TMap tMap) {
        if (tMap.c == 0) {
            m31936d(0);
            return;
        }
        m31930b(tMap.c);
        m31936d((m31937e(tMap.a) << 4) | m31937e(tMap.b));
    }

    public final void mo3473a(TList tList) {
        m31926a(tList.f23600a, tList.f23601b);
    }

    public final void mo3477a(boolean z) {
        byte b = (byte) 1;
        if (this.f23594k != null) {
            TField tField = this.f23594k;
            if (!z) {
                b = (byte) 2;
            }
            m31927a(tField, b);
            this.f23594k = null;
            return;
        }
        if (!z) {
            b = (byte) 2;
        }
        m31929b(b);
    }

    public final void mo3469a(byte b) {
        m31929b(b);
    }

    public final void mo3476a(short s) {
        m31930b(m31932c((int) s));
    }

    public final void mo3470a(int i) {
        m31930b(m31932c(i));
    }

    public final void mo3475a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m31928a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new TException("UTF-8 not supported!");
        }
    }

    public final void mo3478a(byte[] bArr) {
        m31928a(bArr, 0, bArr.length);
    }

    private void m31928a(byte[] bArr, int i, int i2) {
        m31930b(i2);
        this.f23597e.mo3467b(bArr, i, i2);
    }

    private void m31926a(byte b, int i) {
        if (i <= 14) {
            m31936d((i << 4) | m31937e(b));
            return;
        }
        m31936d(m31937e(b) | 240);
        m31930b(i);
    }

    private void m31930b(int i) {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.f23588a[i2] = (byte) ((i & 127) | HTTPTransportCallback.BODY_BYTES_RECEIVED);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.f23588a[i2] = (byte) i;
        this.f23597e.mo3467b(this.f23588a, 0, i4);
    }

    private void m31931b(long j) {
        int i = 0;
        while ((-128 & j) != 0) {
            int i2 = i + 1;
            this.f23589b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.f23589b[i] = (byte) ((int) j);
        this.f23597e.mo3467b(this.f23589b, 0, i3);
    }

    public final void mo3471a(long j) {
        m31931b((j << 1) ^ (j >> 63));
    }

    private static int m31932c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private void m31929b(byte b) {
        this.f23596m[0] = b;
        TTransport tTransport = this.f23597e;
        byte[] bArr = this.f23596m;
        tTransport.mo3467b(bArr, 0, bArr.length);
    }

    private void m31936d(int i) {
        m31929b((byte) i);
    }

    public final TStruct mo3481d() {
        this.f23591h.m32000a(this.f23592i);
        this.f23592i = (short) 0;
        return f23585d;
    }

    public final void mo3482e() {
        this.f23592i = this.f23591h.m31999a();
    }

    public final TField mo3483f() {
        byte k = mo3488k();
        if (k == (byte) 0) {
            return f23586f;
        }
        short s = (short) ((k & 240) >> 4);
        if (s == (short) 0) {
            s = mo3489l();
        } else {
            s = (short) (s + this.f23592i);
        }
        TField tField = new TField("", m31934d((byte) (k & 15)), s);
        Object obj = 1;
        int i = k & 15;
        if (!(i == 1 || i == 2)) {
            obj = null;
        }
        if (obj != null) {
            this.f23595l = ((byte) (k & 15)) == (byte) 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f23592i = tField.f23579c;
        return tField;
    }

    public final TMap mo3484g() {
        int v = m31940v();
        int k = v == 0 ? 0 : mo3488k();
        return new TMap(m31934d((byte) (k >> 4)), m31934d((byte) (k & 15)), v);
    }

    public final TList mo3485h() {
        byte k = mo3488k();
        int i = (k >> 4) & 15;
        if (i == 15) {
            i = m31940v();
        }
        return new TList(m31934d(k), i);
    }

    public final TSet mo3486i() {
        return new TSet(mo3485h());
    }

    public final boolean mo3487j() {
        if (this.f23595l != null) {
            boolean booleanValue = this.f23595l.booleanValue();
            this.f23595l = null;
            return booleanValue;
        } else if (mo3488k() != (byte) 1) {
            return false;
        } else {
            return true;
        }
    }

    public final byte mo3488k() {
        if (-1 > 0) {
            return null[0];
        }
        this.f23597e.m31925c(this.f23590c, 0, 1);
        return this.f23590c[0];
    }

    public final short mo3489l() {
        return (short) m31939f(m31940v());
    }

    public final int mo3490m() {
        return m31939f(m31940v());
    }

    public final long mo3491n() {
        long j = null;
        long j2 = 0;
        if (-1 < 10) {
            while (true) {
                byte k = mo3488k();
                j2 |= ((long) (k & 127)) << j;
                if ((k & HTTPTransportCallback.BODY_BYTES_RECEIVED) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    break;
                }
                j += 7;
            }
        } else {
            byte[] bArr = null;
            int i = 0;
            long j3 = 0;
            while (true) {
                int i2;
                byte b = bArr[i + i2];
                j2 |= ((long) (b & 127)) << j3;
                if ((b & HTTPTransportCallback.BODY_BYTES_RECEIVED) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    break;
                }
                j3 += 7;
                i2++;
            }
        }
        return m31935d(j2);
    }

    public final double mo3492o() {
        long j;
        byte[] bArr = new byte[8];
        this.f23597e.m31925c(bArr, 0, 8);
        if (this.f23593j >= (byte) 2) {
            j = ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
        } else {
            j = m31933c(bArr);
        }
        return Double.longBitsToDouble(j);
    }

    public final String mo3493p() {
        int v = m31940v();
        if (v == 0) {
            return "";
        }
        try {
            if (TTransport.m31922d() >= v) {
                return new String(TTransport.m31920b(), TTransport.m31921c(), v, "UTF-8");
            }
            return new String(m31938e(v), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TException("UTF-8 not supported!");
        }
    }

    public final byte[] mo3494q() {
        return m31938e(m31940v());
    }

    private byte[] m31938e(int i) {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f23597e.m31925c(bArr, 0, i);
        return bArr;
    }

    private int m31940v() {
        int i = 0;
        int i2;
        if (-1 >= 5) {
            byte[] bArr = null;
            int i3 = 0;
            i2 = 0;
            int i4 = 0;
            while (true) {
                byte b = bArr[i3 + i];
                i4 |= (b & 127) << i2;
                if ((b & HTTPTransportCallback.BODY_BYTES_RECEIVED) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    return i4;
                }
                i2 += 7;
                i++;
            }
        } else {
            i2 = 0;
            while (true) {
                byte k = mo3488k();
                i2 |= (k & 127) << i;
                if ((k & HTTPTransportCallback.BODY_BYTES_RECEIVED) != HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    return i2;
                }
                i += 7;
            }
        }
    }

    private static int m31939f(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private static long m31935d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private static long m31933c(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    private static byte m31934d(byte b) {
        switch ((byte) (b & 15)) {
            case (byte) 0:
                return (byte) 0;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (byte) 6;
            case (byte) 5:
                return (byte) 8;
            case (byte) 6:
                return (byte) 10;
            case (byte) 7:
                return (byte) 4;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return (byte) 11;
            case (byte) 9:
                return (byte) 15;
            case (byte) 10:
                return (byte) 14;
            case (byte) 11:
                return (byte) 13;
            case (byte) 12:
                return (byte) 12;
            default:
                throw new TProtocolException("don't know what type: " + ((byte) (b & 15)));
        }
    }

    private static byte m31937e(byte b) {
        return f23587g[b];
    }
}
