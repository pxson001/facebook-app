package com.facebook.thrift.protocol;

import com.facebook.thrift.TException;
import com.facebook.thrift.transport.TTransport;
import java.io.UnsupportedEncodingException;

/* compiled from: selected_result_type */
public class TBinaryProtocol extends TProtocol {
    private static final TStruct f5037f = new TStruct();
    protected boolean f5038a = false;
    protected boolean f5039b = true;
    public int f5040c;
    public boolean f5041d = false;
    private byte[] f5042g = new byte[1];
    private byte[] f5043h = new byte[2];
    private byte[] f5044i = new byte[4];
    private byte[] f5045j = new byte[8];
    private byte[] f5046k = new byte[1];
    private byte[] f5047l = new byte[2];
    private byte[] f5048m = new byte[4];
    private byte[] f5049n = new byte[8];

    /* compiled from: selected_result_type */
    public class Factory implements TProtocolFactory {
        protected int readLength_;
        protected boolean strictRead_;
        protected boolean strictWrite_;

        public Factory() {
            this(false, true);
        }

        private Factory(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        private Factory(boolean z, boolean z2, int i) {
            this.strictRead_ = false;
            this.strictWrite_ = true;
            this.strictRead_ = z;
            this.strictWrite_ = z2;
            this.readLength_ = i;
        }

        public final TProtocol m7785a(TTransport tTransport) {
            TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(tTransport, this.strictRead_, this.strictWrite_);
            if (this.readLength_ != 0) {
                tBinaryProtocol.f5040c = this.readLength_;
                tBinaryProtocol.f5041d = true;
            }
            return tBinaryProtocol;
        }
    }

    public TBinaryProtocol(TTransport tTransport, boolean z, boolean z2) {
        super(tTransport);
        this.f5038a = z;
        this.f5039b = z2;
    }

    public final void m7789a() {
    }

    public final void m7800b() {
    }

    public final void m7793a(TField tField) {
        a(tField.b);
        a(tField.c);
    }

    public final void m7801c() {
        a((byte) 0);
    }

    public final void m7795a(TMap tMap) {
        a(tMap.f5050a);
        a(tMap.f5051b);
        a(tMap.f5052c);
    }

    public final void m7794a(TList tList) {
        a(tList.a);
        a(tList.b);
    }

    public final void m7798a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public final void m7790a(byte b) {
        this.f5042g[0] = b;
        this.e.b(this.f5042g, 0, 1);
    }

    public final void m7797a(short s) {
        this.f5043h[0] = (byte) ((s >> 8) & 255);
        this.f5043h[1] = (byte) (s & 255);
        this.e.b(this.f5043h, 0, 2);
    }

    public final void m7791a(int i) {
        this.f5044i[0] = (byte) ((i >> 24) & 255);
        this.f5044i[1] = (byte) ((i >> 16) & 255);
        this.f5044i[2] = (byte) ((i >> 8) & 255);
        this.f5044i[3] = (byte) (i & 255);
        this.e.b(this.f5044i, 0, 4);
    }

    public final void m7792a(long j) {
        this.f5045j[0] = (byte) ((int) ((j >> 56) & 255));
        this.f5045j[1] = (byte) ((int) ((j >> 48) & 255));
        this.f5045j[2] = (byte) ((int) ((j >> 40) & 255));
        this.f5045j[3] = (byte) ((int) ((j >> 32) & 255));
        this.f5045j[4] = (byte) ((int) ((j >> 24) & 255));
        this.f5045j[5] = (byte) ((int) ((j >> 16) & 255));
        this.f5045j[6] = (byte) ((int) ((j >> 8) & 255));
        this.f5045j[7] = (byte) ((int) (255 & j));
        this.e.b(this.f5045j, 0, 8);
    }

    public final void m7796a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.e.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public final void m7799a(byte[] bArr) {
        a(bArr.length);
        this.e.b(bArr, 0, bArr.length);
    }

    public final TStruct m7802d() {
        return f5037f;
    }

    public final void m7803e() {
    }

    public final TField m7804f() {
        byte k = k();
        return new TField("", k, k == (byte) 0 ? (short) 0 : l());
    }

    public final TMap m7805g() {
        return new TMap(k(), k(), m());
    }

    public final TList m7806h() {
        return new TList(k(), m());
    }

    public final TSet m7807i() {
        return new TSet(k(), m());
    }

    public final boolean m7808j() {
        return k() == (byte) 1;
    }

    public final byte m7809k() {
        if (-1 > 0) {
            return null[0];
        }
        m7786a(this.f5046k, 0, 1);
        return this.f5046k[0];
    }

    public final short m7810l() {
        int i = 0;
        byte[] bArr = this.f5047l;
        if (-1 >= 2) {
            bArr = null;
            i = 0;
        } else {
            m7786a(this.f5047l, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public final int m7811m() {
        int i = 0;
        byte[] bArr = this.f5048m;
        if (-1 >= 4) {
            bArr = null;
            i = 0;
        } else {
            m7786a(this.f5048m, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public final long m7812n() {
        int i = 0;
        byte[] bArr = this.f5049n;
        if (-1 >= 8) {
            bArr = null;
            i = 0;
        } else {
            m7786a(this.f5049n, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8));
    }

    public final double m7813o() {
        return Double.longBitsToDouble(n());
    }

    public final String m7814p() {
        int m = m();
        if (TTransport.d() < m) {
            return m7787c(m);
        }
        try {
            return new String(TTransport.b(), TTransport.c(), m, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    private String m7787c(int i) {
        try {
            m7788d(i);
            byte[] bArr = new byte[i];
            this.e.c(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public final byte[] m7815q() {
        int m = m();
        m7788d(m);
        byte[] bArr = new byte[m];
        this.e.c(bArr, 0, m);
        return bArr;
    }

    private int m7786a(byte[] bArr, int i, int i2) {
        m7788d(i2);
        return this.e.c(bArr, i, i2);
    }

    private void m7788d(int i) {
        if (i < 0) {
            throw new TException("Negative length: " + i);
        } else if (this.f5041d) {
            this.f5040c -= i;
            if (this.f5040c < 0) {
                throw new TException("Message length exceeded: " + i);
            }
        }
    }
}
