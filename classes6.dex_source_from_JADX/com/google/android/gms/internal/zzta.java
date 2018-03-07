package com.google.android.gms.internal;

public final class zzta extends zzte<zzta> {
    public String[] f6282c;
    public int[] f6283d;
    public byte[][] f6284e;

    public zzta() {
        this.f6282c = zztn.f;
        this.f6283d = zztn.a;
        this.f6284e = zztn.g;
        this.a = null;
        this.b = -1;
    }

    public static zzta m8828a(byte[] bArr) {
        return (zzta) zztk.a(new zzta(), bArr);
    }

    protected final int m8829a() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int a = super.a();
        if (this.f6282c == null || this.f6282c.length <= 0) {
            i = a;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.f6282c) {
                if (str != null) {
                    i3++;
                    i2 += zztd.a(str);
                }
            }
            i = (a + i2) + (i3 * 1);
        }
        if (this.f6283d != null && this.f6283d.length > 0) {
            i3 = 0;
            for (int a2 : this.f6283d) {
                i3 += zztd.a(a2);
            }
            i = (i + i3) + (this.f6283d.length * 1);
        }
        if (this.f6284e == null || this.f6284e.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.f6284e.length) {
            byte[] bArr = this.f6284e[i4];
            if (bArr != null) {
                i3++;
                i2 += zztd.b(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }

    public final zztk m8830a(zztc com_google_android_gms_internal_zztc) {
        while (true) {
            int a = com_google_android_gms_internal_zztc.a();
            int b;
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 10:
                    b = zztn.b(com_google_android_gms_internal_zztc, 10);
                    a = this.f6282c == null ? 0 : this.f6282c.length;
                    obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f6282c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_google_android_gms_internal_zztc.g();
                        com_google_android_gms_internal_zztc.a();
                        a++;
                    }
                    obj[a] = com_google_android_gms_internal_zztc.g();
                    this.f6282c = obj;
                    continue;
                case 16:
                    b = zztn.b(com_google_android_gms_internal_zztc, 16);
                    a = this.f6283d == null ? 0 : this.f6283d.length;
                    obj = new int[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f6283d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_google_android_gms_internal_zztc.e();
                        com_google_android_gms_internal_zztc.a();
                        a++;
                    }
                    obj[a] = com_google_android_gms_internal_zztc.e();
                    this.f6283d = obj;
                    continue;
                case 18:
                    int c = com_google_android_gms_internal_zztc.c(com_google_android_gms_internal_zztc.k());
                    b = com_google_android_gms_internal_zztc.m();
                    a = 0;
                    while (com_google_android_gms_internal_zztc.l() > 0) {
                        com_google_android_gms_internal_zztc.e();
                        a++;
                    }
                    com_google_android_gms_internal_zztc.e(b);
                    b = this.f6283d == null ? 0 : this.f6283d.length;
                    Object obj2 = new int[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.f6283d, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = com_google_android_gms_internal_zztc.e();
                        b++;
                    }
                    this.f6283d = obj2;
                    com_google_android_gms_internal_zztc.d(c);
                    continue;
                case 26:
                    b = zztn.b(com_google_android_gms_internal_zztc, 26);
                    a = this.f6284e == null ? 0 : this.f6284e.length;
                    obj = new byte[(b + a)][];
                    if (a != 0) {
                        System.arraycopy(this.f6284e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = com_google_android_gms_internal_zztc.h();
                        com_google_android_gms_internal_zztc.a();
                        a++;
                    }
                    obj[a] = com_google_android_gms_internal_zztc.h();
                    this.f6284e = obj;
                    continue;
                default:
                    if (!a(com_google_android_gms_internal_zztc, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void m8831a(zztd com_google_android_gms_internal_zztd) {
        int i = 0;
        if (this.f6282c != null && this.f6282c.length > 0) {
            for (String str : this.f6282c) {
                if (str != null) {
                    com_google_android_gms_internal_zztd.a(1, str);
                }
            }
        }
        if (this.f6283d != null && this.f6283d.length > 0) {
            for (int a : this.f6283d) {
                com_google_android_gms_internal_zztd.a(2, a);
            }
        }
        if (this.f6284e != null && this.f6284e.length > 0) {
            while (i < this.f6284e.length) {
                byte[] bArr = this.f6284e[i];
                if (bArr != null) {
                    com_google_android_gms_internal_zztd.a(3, bArr);
                }
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zztd);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzta)) {
            return false;
        }
        zzta com_google_android_gms_internal_zzta = (zzta) obj;
        return !zzti.a(this.f6282c, com_google_android_gms_internal_zzta.f6282c) ? false : !zzti.a(this.f6283d, com_google_android_gms_internal_zzta.f6283d) ? false : !zzti.a(this.f6284e, com_google_android_gms_internal_zzta.f6284e) ? false : (this.a == null || this.a.b()) ? com_google_android_gms_internal_zzta.a == null || com_google_android_gms_internal_zzta.a.b() : this.a.equals(com_google_android_gms_internal_zzta.a);
    }

    public final int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzti.a(this.f6282c)) * 31) + zzti.a(this.f6283d)) * 31) + zzti.a(this.f6284e)) * 31;
        int hashCode2 = (this.a == null || this.a.b()) ? 0 : this.a.hashCode();
        return hashCode2 + hashCode;
    }
}
