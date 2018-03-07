package com.google.android.gms.internal;

import android.support.v7.widget.LinearLayoutCompat;

public final class zztc {
    public final byte[] f6962a;
    public int f6963b;
    public int f6964c;
    private int f6965d;
    public int f6966e;
    private int f6967f;
    private int f6968g = Integer.MAX_VALUE;
    private int f6969h;
    private int f6970i = 64;
    private int f6971j = 67108864;

    private zztc(byte[] bArr, int i, int i2) {
        this.f6962a = bArr;
        this.f6963b = i;
        this.f6964c = i + i2;
        this.f6966e = i;
    }

    public static zztc m12928a(byte[] bArr) {
        return m12929a(bArr, 0, bArr.length);
    }

    public static zztc m12929a(byte[] bArr, int i, int i2) {
        return new zztc(bArr, i, i2);
    }

    private byte[] m12930g(int i) {
        if (i < 0) {
            throw zztj.m13038b();
        } else if (this.f6966e + i > this.f6968g) {
            m12931h(this.f6968g - this.f6966e);
            throw zztj.m13037a();
        } else if (i <= this.f6964c - this.f6966e) {
            Object obj = new byte[i];
            System.arraycopy(this.f6962a, this.f6966e, obj, 0, i);
            this.f6966e += i;
            return obj;
        } else {
            throw zztj.m13037a();
        }
    }

    private void m12931h(int i) {
        if (i < 0) {
            throw zztj.m13038b();
        } else if (this.f6966e + i > this.f6968g) {
            m12931h(this.f6968g - this.f6966e);
            throw zztj.m13037a();
        } else if (i <= this.f6964c - this.f6966e) {
            this.f6966e += i;
        } else {
            throw zztj.m13037a();
        }
    }

    private long m12932o() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte t = m12936t();
            j |= ((long) (t & 127)) << i;
            if ((t & 128) == 0) {
                return j;
            }
        }
        throw zztj.m13039c();
    }

    private int m12933p() {
        return (((m12936t() & 255) | ((m12936t() & 255) << 8)) | ((m12936t() & 255) << 16)) | ((m12936t() & 255) << 24);
    }

    private long m12934q() {
        byte t = m12936t();
        byte t2 = m12936t();
        return ((((((((((long) t2) & 255) << 8) | (((long) t) & 255)) | ((((long) m12936t()) & 255) << 16)) | ((((long) m12936t()) & 255) << 24)) | ((((long) m12936t()) & 255) << 32)) | ((((long) m12936t()) & 255) << 40)) | ((((long) m12936t()) & 255) << 48)) | ((((long) m12936t()) & 255) << 56);
    }

    private void m12935r() {
        this.f6964c += this.f6965d;
        int i = this.f6964c;
        if (i > this.f6968g) {
            this.f6965d = i - this.f6968g;
            this.f6964c -= this.f6965d;
            return;
        }
        this.f6965d = 0;
    }

    private byte m12936t() {
        if (this.f6966e == this.f6964c) {
            throw zztj.m13037a();
        }
        byte[] bArr = this.f6962a;
        int i = this.f6966e;
        this.f6966e = i + 1;
        return bArr[i];
    }

    public final int m12937a() {
        if ((this.f6966e == this.f6964c ? 1 : null) != null) {
            this.f6967f = 0;
            return 0;
        }
        this.f6967f = m12952k();
        if (this.f6967f != 0) {
            return this.f6967f;
        }
        throw new zztj("Protocol message contained an invalid tag (zero).");
    }

    public final void m12938a(int i) {
        if (this.f6967f != i) {
            throw new zztj("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void m12939a(zztk com_google_android_gms_internal_zztk) {
        int k = m12952k();
        if (this.f6969h >= this.f6970i) {
            throw new zztj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        k = m12943c(k);
        this.f6969h++;
        com_google_android_gms_internal_zztk.mo844a(this);
        m12938a(0);
        this.f6969h--;
        m12945d(k);
    }

    public final double m12940b() {
        return Double.longBitsToDouble(m12934q());
    }

    public final boolean m12941b(int i) {
        switch (i & 7) {
            case 0:
                m12946e();
                return true;
            case 1:
                m12934q();
                return true;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                m12931h(m12952k());
                return true;
            case 3:
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return false;
            case 5:
                m12933p();
                return true;
            default:
                throw new zztj("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = m12937a();
            if (a != 0) {
            }
            m12938a(zztn.m13045a(i >>> 3, 4));
            return true;
        } while (m12941b(a));
        m12938a(zztn.m13045a(i >>> 3, 4));
        return true;
    }

    public final float m12942c() {
        return Float.intBitsToFloat(m12933p());
    }

    public final int m12943c(int i) {
        if (i < 0) {
            throw zztj.m13038b();
        }
        int i2 = this.f6966e + i;
        int i3 = this.f6968g;
        if (i2 > i3) {
            throw zztj.m13037a();
        }
        this.f6968g = i2;
        m12935r();
        return i3;
    }

    public final long m12944d() {
        return m12932o();
    }

    public final void m12945d(int i) {
        this.f6968g = i;
        m12935r();
    }

    public final int m12946e() {
        return m12952k();
    }

    public final void m12947e(int i) {
        if (i > this.f6966e - this.f6963b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f6966e - this.f6963b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f6966e = this.f6963b + i;
        }
    }

    public final boolean m12948f() {
        return m12952k() != 0;
    }

    public final String m12949g() {
        int k = m12952k();
        if (k > this.f6964c - this.f6966e || k <= 0) {
            return new String(m12930g(k), "UTF-8");
        }
        String str = new String(this.f6962a, this.f6966e, k, "UTF-8");
        this.f6966e = k + this.f6966e;
        return str;
    }

    public final byte[] m12950h() {
        int k = m12952k();
        if (k > this.f6964c - this.f6966e || k <= 0) {
            return k == 0 ? zztn.f6996h : m12930g(k);
        } else {
            Object obj = new byte[k];
            System.arraycopy(this.f6962a, this.f6966e, obj, 0, k);
            this.f6966e = k + this.f6966e;
            return obj;
        }
    }

    public final long m12951j() {
        long o = m12932o();
        return (o >>> 1) ^ (-(1 & o));
    }

    public final int m12952k() {
        byte t = m12936t();
        if (t >= (byte) 0) {
            return t;
        }
        int i = t & 127;
        byte t2 = m12936t();
        if (t2 >= (byte) 0) {
            return i | (t2 << 7);
        }
        i |= (t2 & 127) << 7;
        t2 = m12936t();
        if (t2 >= (byte) 0) {
            return i | (t2 << 14);
        }
        i |= (t2 & 127) << 14;
        t2 = m12936t();
        if (t2 >= (byte) 0) {
            return i | (t2 << 21);
        }
        i |= (t2 & 127) << 21;
        t2 = m12936t();
        i |= t2 << 28;
        if (t2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m12936t() >= (byte) 0) {
                return i;
            }
        }
        throw zztj.m13039c();
    }

    public final int m12953l() {
        if (this.f6968g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f6968g - this.f6966e;
    }

    public final int m12954m() {
        return this.f6966e - this.f6963b;
    }
}
