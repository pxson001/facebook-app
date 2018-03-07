package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzsz extends zzte<zzsz> {
    public zza[] f13127c;

    public final class zza extends zzte<zza> {
        private static volatile zza[] f13124e;
        public String f13125c;
        public zza f13126d;

        public final class zza extends zzte<zza> {
            private static volatile zza[] f13121e;
            public int f13122c;
            public zza f13123d;

            public final class zza extends zzte<zza> {
                public byte[] f13107c;
                public String f13108d;
                public double f13109e;
                public float f13110f;
                public long f13111g;
                public int f13112h;
                public int f13113i;
                public boolean f13114j;
                public zza[] f13115k;
                public zza[] f13116l;
                public String[] f13117m;
                public long[] f13118n;
                public float[] f13119o;
                public long f13120p;

                public zza() {
                    this.f13107c = zztn.h;
                    this.f13108d = "";
                    this.f13109e = 0.0d;
                    this.f13110f = 0.0f;
                    this.f13111g = 0;
                    this.f13112h = 0;
                    this.f13113i = 0;
                    this.f13114j = false;
                    this.f13115k = zza.m13216e();
                    this.f13116l = zza.m13212e();
                    this.f13117m = zztn.f;
                    this.f13118n = zztn.b;
                    this.f13119o = zztn.c;
                    this.f13120p = 0;
                    this.a = null;
                    this.b = -1;
                }

                protected final int m13209a() {
                    int i;
                    int i2 = 0;
                    int a = super.a();
                    if (!Arrays.equals(this.f13107c, zztn.h)) {
                        a += zztd.b(1, this.f13107c);
                    }
                    if (!this.f13108d.equals("")) {
                        a += zztd.b(2, this.f13108d);
                    }
                    if (Double.doubleToLongBits(this.f13109e) != Double.doubleToLongBits(0.0d)) {
                        double d = this.f13109e;
                        a += zztd.h(3) + 8;
                    }
                    if (Float.floatToIntBits(this.f13110f) != Float.floatToIntBits(0.0f)) {
                        a += zztd.b(4, this.f13110f);
                    }
                    if (this.f13111g != 0) {
                        a += zztd.c(5, this.f13111g);
                    }
                    if (this.f13112h != 0) {
                        a += zztd.c(6, this.f13112h);
                    }
                    if (this.f13113i != 0) {
                        a += zztd.h(7) + zztd.c(zztd.j(this.f13113i));
                    }
                    if (this.f13114j) {
                        a += zztd.b(8, this.f13114j);
                    }
                    if (this.f13115k != null && this.f13115k.length > 0) {
                        i = a;
                        for (zztk com_google_android_gms_internal_zztk : this.f13115k) {
                            if (com_google_android_gms_internal_zztk != null) {
                                i += zztd.c(9, com_google_android_gms_internal_zztk);
                            }
                        }
                        a = i;
                    }
                    if (this.f13116l != null && this.f13116l.length > 0) {
                        i = a;
                        for (zztk com_google_android_gms_internal_zztk2 : this.f13116l) {
                            if (com_google_android_gms_internal_zztk2 != null) {
                                i += zztd.c(10, com_google_android_gms_internal_zztk2);
                            }
                        }
                        a = i;
                    }
                    if (this.f13117m != null && this.f13117m.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.f13117m) {
                            if (str != null) {
                                i4++;
                                i3 += zztd.a(str);
                            }
                        }
                        a = (a + i3) + (i4 * 1);
                    }
                    if (this.f13118n != null && this.f13118n.length > 0) {
                        i = 0;
                        while (i2 < this.f13118n.length) {
                            i += zztd.f(this.f13118n[i2]);
                            i2++;
                        }
                        a = (a + i) + (this.f13118n.length * 1);
                    }
                    if (this.f13120p != 0) {
                        a += zztd.c(13, this.f13120p);
                    }
                    return (this.f13119o == null || this.f13119o.length <= 0) ? a : (a + (this.f13119o.length * 4)) + (this.f13119o.length * 1);
                }

                public final zztk m13210a(zztc com_google_android_gms_internal_zztc) {
                    while (true) {
                        int a = com_google_android_gms_internal_zztc.a();
                        int b;
                        Object obj;
                        int c;
                        switch (a) {
                            case 0:
                                break;
                            case 10:
                                this.f13107c = com_google_android_gms_internal_zztc.h();
                                continue;
                            case 18:
                                this.f13108d = com_google_android_gms_internal_zztc.g();
                                continue;
                            case 25:
                                this.f13109e = com_google_android_gms_internal_zztc.b();
                                continue;
                            case 37:
                                this.f13110f = com_google_android_gms_internal_zztc.c();
                                continue;
                            case 40:
                                this.f13111g = com_google_android_gms_internal_zztc.d();
                                continue;
                            case 48:
                                this.f13112h = com_google_android_gms_internal_zztc.e();
                                continue;
                            case 56:
                                int k = com_google_android_gms_internal_zztc.k();
                                this.f13113i = (k >>> 1) ^ (-(k & 1));
                                continue;
                            case 64:
                                this.f13114j = com_google_android_gms_internal_zztc.f();
                                continue;
                            case 74:
                                b = zztn.b(com_google_android_gms_internal_zztc, 74);
                                a = this.f13115k == null ? 0 : this.f13115k.length;
                                obj = new zza[(b + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13115k, 0, obj, 0, a);
                                }
                                while (a < obj.length - 1) {
                                    obj[a] = new zza();
                                    com_google_android_gms_internal_zztc.a(obj[a]);
                                    com_google_android_gms_internal_zztc.a();
                                    a++;
                                }
                                obj[a] = new zza();
                                com_google_android_gms_internal_zztc.a(obj[a]);
                                this.f13115k = obj;
                                continue;
                            case 82:
                                b = zztn.b(com_google_android_gms_internal_zztc, 82);
                                a = this.f13116l == null ? 0 : this.f13116l.length;
                                obj = new zza[(b + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13116l, 0, obj, 0, a);
                                }
                                while (a < obj.length - 1) {
                                    obj[a] = new zza();
                                    com_google_android_gms_internal_zztc.a(obj[a]);
                                    com_google_android_gms_internal_zztc.a();
                                    a++;
                                }
                                obj[a] = new zza();
                                com_google_android_gms_internal_zztc.a(obj[a]);
                                this.f13116l = obj;
                                continue;
                            case 90:
                                b = zztn.b(com_google_android_gms_internal_zztc, 90);
                                a = this.f13117m == null ? 0 : this.f13117m.length;
                                obj = new String[(b + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13117m, 0, obj, 0, a);
                                }
                                while (a < obj.length - 1) {
                                    obj[a] = com_google_android_gms_internal_zztc.g();
                                    com_google_android_gms_internal_zztc.a();
                                    a++;
                                }
                                obj[a] = com_google_android_gms_internal_zztc.g();
                                this.f13117m = obj;
                                continue;
                            case 96:
                                b = zztn.b(com_google_android_gms_internal_zztc, 96);
                                a = this.f13118n == null ? 0 : this.f13118n.length;
                                obj = new long[(b + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13118n, 0, obj, 0, a);
                                }
                                while (a < obj.length - 1) {
                                    obj[a] = com_google_android_gms_internal_zztc.d();
                                    com_google_android_gms_internal_zztc.a();
                                    a++;
                                }
                                obj[a] = com_google_android_gms_internal_zztc.d();
                                this.f13118n = obj;
                                continue;
                            case 98:
                                c = com_google_android_gms_internal_zztc.c(com_google_android_gms_internal_zztc.k());
                                b = com_google_android_gms_internal_zztc.m();
                                a = 0;
                                while (com_google_android_gms_internal_zztc.l() > 0) {
                                    com_google_android_gms_internal_zztc.d();
                                    a++;
                                }
                                com_google_android_gms_internal_zztc.e(b);
                                b = this.f13118n == null ? 0 : this.f13118n.length;
                                Object obj2 = new long[(a + b)];
                                if (b != 0) {
                                    System.arraycopy(this.f13118n, 0, obj2, 0, b);
                                }
                                while (b < obj2.length) {
                                    obj2[b] = com_google_android_gms_internal_zztc.d();
                                    b++;
                                }
                                this.f13118n = obj2;
                                com_google_android_gms_internal_zztc.d(c);
                                continue;
                            case 104:
                                this.f13120p = com_google_android_gms_internal_zztc.d();
                                continue;
                            case 114:
                                a = com_google_android_gms_internal_zztc.k();
                                b = com_google_android_gms_internal_zztc.c(a);
                                c = a / 4;
                                a = this.f13119o == null ? 0 : this.f13119o.length;
                                Object obj3 = new float[(c + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13119o, 0, obj3, 0, a);
                                }
                                while (a < obj3.length) {
                                    obj3[a] = com_google_android_gms_internal_zztc.c();
                                    a++;
                                }
                                this.f13119o = obj3;
                                com_google_android_gms_internal_zztc.d(b);
                                continue;
                            case 117:
                                b = zztn.b(com_google_android_gms_internal_zztc, 117);
                                a = this.f13119o == null ? 0 : this.f13119o.length;
                                obj = new float[(b + a)];
                                if (a != 0) {
                                    System.arraycopy(this.f13119o, 0, obj, 0, a);
                                }
                                while (a < obj.length - 1) {
                                    obj[a] = com_google_android_gms_internal_zztc.c();
                                    com_google_android_gms_internal_zztc.a();
                                    a++;
                                }
                                obj[a] = com_google_android_gms_internal_zztc.c();
                                this.f13119o = obj;
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

                public final void m13211a(zztd com_google_android_gms_internal_zztd) {
                    int i = 0;
                    if (!Arrays.equals(this.f13107c, zztn.h)) {
                        com_google_android_gms_internal_zztd.a(1, this.f13107c);
                    }
                    if (!this.f13108d.equals("")) {
                        com_google_android_gms_internal_zztd.a(2, this.f13108d);
                    }
                    if (Double.doubleToLongBits(this.f13109e) != Double.doubleToLongBits(0.0d)) {
                        com_google_android_gms_internal_zztd.a(3, this.f13109e);
                    }
                    if (Float.floatToIntBits(this.f13110f) != Float.floatToIntBits(0.0f)) {
                        com_google_android_gms_internal_zztd.a(4, this.f13110f);
                    }
                    if (this.f13111g != 0) {
                        com_google_android_gms_internal_zztd.a(5, this.f13111g);
                    }
                    if (this.f13112h != 0) {
                        com_google_android_gms_internal_zztd.a(6, this.f13112h);
                    }
                    if (this.f13113i != 0) {
                        int i2 = this.f13113i;
                        com_google_android_gms_internal_zztd.e(7, 0);
                        com_google_android_gms_internal_zztd.b(zztd.j(i2));
                    }
                    if (this.f13114j) {
                        com_google_android_gms_internal_zztd.a(8, this.f13114j);
                    }
                    if (this.f13115k != null && this.f13115k.length > 0) {
                        for (zztk com_google_android_gms_internal_zztk : this.f13115k) {
                            if (com_google_android_gms_internal_zztk != null) {
                                com_google_android_gms_internal_zztd.a(9, com_google_android_gms_internal_zztk);
                            }
                        }
                    }
                    if (this.f13116l != null && this.f13116l.length > 0) {
                        for (zztk com_google_android_gms_internal_zztk2 : this.f13116l) {
                            if (com_google_android_gms_internal_zztk2 != null) {
                                com_google_android_gms_internal_zztd.a(10, com_google_android_gms_internal_zztk2);
                            }
                        }
                    }
                    if (this.f13117m != null && this.f13117m.length > 0) {
                        for (String str : this.f13117m) {
                            if (str != null) {
                                com_google_android_gms_internal_zztd.a(11, str);
                            }
                        }
                    }
                    if (this.f13118n != null && this.f13118n.length > 0) {
                        for (long a : this.f13118n) {
                            com_google_android_gms_internal_zztd.a(12, a);
                        }
                    }
                    if (this.f13120p != 0) {
                        com_google_android_gms_internal_zztd.a(13, this.f13120p);
                    }
                    if (this.f13119o != null && this.f13119o.length > 0) {
                        while (i < this.f13119o.length) {
                            com_google_android_gms_internal_zztd.a(14, this.f13119o[i]);
                            i++;
                        }
                    }
                    super.a(com_google_android_gms_internal_zztd);
                }

                public final boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof zza)) {
                        return false;
                    }
                    zza com_google_android_gms_internal_zzsz_zza_zza_zza = (zza) obj;
                    if (!Arrays.equals(this.f13107c, com_google_android_gms_internal_zzsz_zza_zza_zza.f13107c)) {
                        return false;
                    }
                    if (this.f13108d == null) {
                        if (com_google_android_gms_internal_zzsz_zza_zza_zza.f13108d != null) {
                            return false;
                        }
                    } else if (!this.f13108d.equals(com_google_android_gms_internal_zzsz_zza_zza_zza.f13108d)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.f13109e) != Double.doubleToLongBits(com_google_android_gms_internal_zzsz_zza_zza_zza.f13109e)) {
                        return false;
                    }
                    if (Float.floatToIntBits(this.f13110f) != Float.floatToIntBits(com_google_android_gms_internal_zzsz_zza_zza_zza.f13110f)) {
                        return false;
                    }
                    if (this.f13111g != com_google_android_gms_internal_zzsz_zza_zza_zza.f13111g) {
                        return false;
                    }
                    if (this.f13112h != com_google_android_gms_internal_zzsz_zza_zza_zza.f13112h) {
                        return false;
                    }
                    if (this.f13113i != com_google_android_gms_internal_zzsz_zza_zza_zza.f13113i) {
                        return false;
                    }
                    if (this.f13114j != com_google_android_gms_internal_zzsz_zza_zza_zza.f13114j) {
                        return false;
                    }
                    if (!zzti.a(this.f13115k, com_google_android_gms_internal_zzsz_zza_zza_zza.f13115k)) {
                        return false;
                    }
                    if (!zzti.a(this.f13116l, com_google_android_gms_internal_zzsz_zza_zza_zza.f13116l)) {
                        return false;
                    }
                    if (!zzti.a(this.f13117m, com_google_android_gms_internal_zzsz_zza_zza_zza.f13117m)) {
                        return false;
                    }
                    if (!zzti.a(this.f13118n, com_google_android_gms_internal_zzsz_zza_zza_zza.f13118n)) {
                        return false;
                    }
                    float[] fArr = this.f13119o;
                    float[] fArr2 = com_google_android_gms_internal_zzsz_zza_zza_zza.f13119o;
                    boolean equals = (fArr == null || fArr.length == 0) ? fArr2 == null || fArr2.length == 0 : Arrays.equals(fArr, fArr2);
                    return !equals ? false : this.f13120p != com_google_android_gms_internal_zzsz_zza_zza_zza.f13120p ? false : (this.a == null || this.a.b()) ? com_google_android_gms_internal_zzsz_zza_zza_zza.a == null || com_google_android_gms_internal_zzsz_zza_zza_zza.a.b() : this.a.equals(com_google_android_gms_internal_zzsz_zza_zza_zza.a);
                }

                public final int hashCode() {
                    int i = 0;
                    int hashCode = (this.f13108d == null ? 0 : this.f13108d.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f13107c)) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.f13109e);
                    hashCode = ((((((((((this.f13114j ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.f13110f)) * 31) + ((int) (this.f13111g ^ (this.f13111g >>> 32)))) * 31) + this.f13112h) * 31) + this.f13113i) * 31)) * 31) + zzti.a(this.f13115k)) * 31) + zzti.a(this.f13116l)) * 31) + zzti.a(this.f13117m)) * 31) + zzti.a(this.f13118n)) * 31;
                    float[] fArr = this.f13119o;
                    int hashCode2 = (fArr == null || fArr.length == 0) ? 0 : Arrays.hashCode(fArr);
                    hashCode = (((hashCode + hashCode2) * 31) + ((int) (this.f13120p ^ (this.f13120p >>> 32)))) * 31;
                    if (!(this.a == null || this.a.b())) {
                        i = this.a.hashCode();
                    }
                    return hashCode + i;
                }
            }

            public zza() {
                this.f13122c = 1;
                this.f13123d = null;
                this.a = null;
                this.b = -1;
            }

            public static zza[] m13212e() {
                if (f13121e == null) {
                    synchronized (zzti.a) {
                        if (f13121e == null) {
                            f13121e = new zza[0];
                        }
                    }
                }
                return f13121e;
            }

            protected final int m13213a() {
                int a = super.a() + zztd.c(1, this.f13122c);
                return this.f13123d != null ? a + zztd.c(2, this.f13123d) : a;
            }

            public final zztk m13214a(zztc com_google_android_gms_internal_zztc) {
                while (true) {
                    int a = com_google_android_gms_internal_zztc.a();
                    switch (a) {
                        case 0:
                            break;
                        case 8:
                            a = com_google_android_gms_internal_zztc.e();
                            switch (a) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.f13122c = a;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.f13123d == null) {
                                this.f13123d = new zza();
                            }
                            com_google_android_gms_internal_zztc.a(this.f13123d);
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

            public final void m13215a(zztd com_google_android_gms_internal_zztd) {
                com_google_android_gms_internal_zztd.a(1, this.f13122c);
                if (this.f13123d != null) {
                    com_google_android_gms_internal_zztd.a(2, this.f13123d);
                }
                super.a(com_google_android_gms_internal_zztd);
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzsz_zza_zza = (zza) obj;
                if (this.f13122c != com_google_android_gms_internal_zzsz_zza_zza.f13122c) {
                    return false;
                }
                if (this.f13123d == null) {
                    if (com_google_android_gms_internal_zzsz_zza_zza.f13123d != null) {
                        return false;
                    }
                } else if (!this.f13123d.equals(com_google_android_gms_internal_zzsz_zza_zza.f13123d)) {
                    return false;
                }
                return (this.a == null || this.a.b()) ? com_google_android_gms_internal_zzsz_zza_zza.a == null || com_google_android_gms_internal_zzsz_zza_zza.a.b() : this.a.equals(com_google_android_gms_internal_zzsz_zza_zza.a);
            }

            public final int hashCode() {
                int i = 0;
                int hashCode = ((this.f13123d == null ? 0 : this.f13123d.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f13122c) * 31)) * 31;
                if (!(this.a == null || this.a.b())) {
                    i = this.a.hashCode();
                }
                return hashCode + i;
            }
        }

        public zza() {
            this.f13125c = "";
            this.f13126d = null;
            this.a = null;
            this.b = -1;
        }

        public static zza[] m13216e() {
            if (f13124e == null) {
                synchronized (zzti.a) {
                    if (f13124e == null) {
                        f13124e = new zza[0];
                    }
                }
            }
            return f13124e;
        }

        protected final int m13217a() {
            int a = super.a() + zztd.b(1, this.f13125c);
            return this.f13126d != null ? a + zztd.c(2, this.f13126d) : a;
        }

        public final zztk m13218a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f13125c = com_google_android_gms_internal_zztc.g();
                        continue;
                    case 18:
                        if (this.f13126d == null) {
                            this.f13126d = new zza();
                        }
                        com_google_android_gms_internal_zztc.a(this.f13126d);
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

        public final void m13219a(zztd com_google_android_gms_internal_zztd) {
            com_google_android_gms_internal_zztd.a(1, this.f13125c);
            if (this.f13126d != null) {
                com_google_android_gms_internal_zztd.a(2, this.f13126d);
            }
            super.a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzsz_zza = (zza) obj;
            if (this.f13125c == null) {
                if (com_google_android_gms_internal_zzsz_zza.f13125c != null) {
                    return false;
                }
            } else if (!this.f13125c.equals(com_google_android_gms_internal_zzsz_zza.f13125c)) {
                return false;
            }
            if (this.f13126d == null) {
                if (com_google_android_gms_internal_zzsz_zza.f13126d != null) {
                    return false;
                }
            } else if (!this.f13126d.equals(com_google_android_gms_internal_zzsz_zza.f13126d)) {
                return false;
            }
            return (this.a == null || this.a.b()) ? com_google_android_gms_internal_zzsz_zza.a == null || com_google_android_gms_internal_zzsz_zza.a.b() : this.a.equals(com_google_android_gms_internal_zzsz_zza.a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f13126d == null ? 0 : this.f13126d.hashCode()) + (((this.f13125c == null ? 0 : this.f13125c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.a == null || this.a.b())) {
                i = this.a.hashCode();
            }
            return hashCode + i;
        }
    }

    public zzsz() {
        this.f13127c = zza.m13216e();
        this.a = null;
        this.b = -1;
    }

    public static zzsz m13220a(byte[] bArr) {
        return (zzsz) zztk.a(new zzsz(), bArr);
    }

    protected final int m13221a() {
        int a = super.a();
        if (this.f13127c != null && this.f13127c.length > 0) {
            for (zztk com_google_android_gms_internal_zztk : this.f13127c) {
                if (com_google_android_gms_internal_zztk != null) {
                    a += zztd.c(1, com_google_android_gms_internal_zztk);
                }
            }
        }
        return a;
    }

    public final zztk m13222a(zztc com_google_android_gms_internal_zztc) {
        while (true) {
            int a = com_google_android_gms_internal_zztc.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int b = zztn.b(com_google_android_gms_internal_zztc, 10);
                    a = this.f13127c == null ? 0 : this.f13127c.length;
                    Object obj = new zza[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f13127c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new zza();
                        com_google_android_gms_internal_zztc.a(obj[a]);
                        com_google_android_gms_internal_zztc.a();
                        a++;
                    }
                    obj[a] = new zza();
                    com_google_android_gms_internal_zztc.a(obj[a]);
                    this.f13127c = obj;
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

    public final void m13223a(zztd com_google_android_gms_internal_zztd) {
        if (this.f13127c != null && this.f13127c.length > 0) {
            for (zztk com_google_android_gms_internal_zztk : this.f13127c) {
                if (com_google_android_gms_internal_zztk != null) {
                    com_google_android_gms_internal_zztd.a(1, com_google_android_gms_internal_zztk);
                }
            }
        }
        super.a(com_google_android_gms_internal_zztd);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsz)) {
            return false;
        }
        zzsz com_google_android_gms_internal_zzsz = (zzsz) obj;
        return !zzti.a(this.f13127c, com_google_android_gms_internal_zzsz.f13127c) ? false : (this.a == null || this.a.b()) ? com_google_android_gms_internal_zzsz.a == null || com_google_android_gms_internal_zzsz.a.b() : this.a.equals(com_google_android_gms_internal_zzsz.a);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzti.a(this.f13127c)) * 31;
        int hashCode2 = (this.a == null || this.a.b()) ? 0 : this.a.hashCode();
        return hashCode2 + hashCode;
    }
}
