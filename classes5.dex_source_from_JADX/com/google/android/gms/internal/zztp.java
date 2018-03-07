package com.google.android.gms.internal;

import android.support.v7.widget.LinearLayoutCompat;
import java.util.Arrays;

public interface zztp {

    public final class zza extends zzte<zza> {
        public String[] f6997c = zztn.f6994f;
        public String[] f6998d = zztn.f6994f;
        public int[] f6999e = zztn.f6989a;
        public long[] f7000f = zztn.f6990b;

        protected final int mo843a() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int a = super.mo843a();
            if (this.f6997c == null || this.f6997c.length <= 0) {
                i = a;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.f6997c) {
                    if (str != null) {
                        i3++;
                        i2 += zztd.m12959a(str);
                    }
                }
                i = (a + i2) + (i3 * 1);
            }
            if (this.f6998d != null && this.f6998d.length > 0) {
                i3 = 0;
                a = 0;
                for (String str2 : this.f6998d) {
                    if (str2 != null) {
                        a++;
                        i3 += zztd.m12959a(str2);
                    }
                }
                i = (i + i3) + (a * 1);
            }
            if (this.f6999e != null && this.f6999e.length > 0) {
                i3 = 0;
                for (int a2 : this.f6999e) {
                    i3 += zztd.m12955a(a2);
                }
                i = (i + i3) + (this.f6999e.length * 1);
            }
            if (this.f7000f == null || this.f7000f.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.f7000f.length) {
                i2 += zztd.m12982f(this.f7000f[i4]);
                i4++;
            }
            return (i + i2) + (this.f7000f.length * 1);
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                int b;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 10);
                        a = this.f6997c == null ? 0 : this.f6997c.length;
                        obj = new String[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6997c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12949g();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12949g();
                        this.f6997c = obj;
                        continue;
                    case 18:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 18);
                        a = this.f6998d == null ? 0 : this.f6998d.length;
                        obj = new String[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6998d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12949g();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12949g();
                        this.f6998d = obj;
                        continue;
                    case 24:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 24);
                        a = this.f6999e == null ? 0 : this.f6999e.length;
                        obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6999e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12946e();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12946e();
                        this.f6999e = obj;
                        continue;
                    case 26:
                        c = com_google_android_gms_internal_zztc.m12943c(com_google_android_gms_internal_zztc.m12952k());
                        b = com_google_android_gms_internal_zztc.m12954m();
                        a = 0;
                        while (com_google_android_gms_internal_zztc.m12953l() > 0) {
                            com_google_android_gms_internal_zztc.m12946e();
                            a++;
                        }
                        com_google_android_gms_internal_zztc.m12947e(b);
                        b = this.f6999e == null ? 0 : this.f6999e.length;
                        obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f6999e, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = com_google_android_gms_internal_zztc.m12946e();
                            b++;
                        }
                        this.f6999e = obj2;
                        com_google_android_gms_internal_zztc.m12945d(c);
                        continue;
                    case 32:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 32);
                        a = this.f7000f == null ? 0 : this.f7000f.length;
                        obj = new long[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f7000f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12944d();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12944d();
                        this.f7000f = obj;
                        continue;
                    case 34:
                        c = com_google_android_gms_internal_zztc.m12943c(com_google_android_gms_internal_zztc.m12952k());
                        b = com_google_android_gms_internal_zztc.m12954m();
                        a = 0;
                        while (com_google_android_gms_internal_zztc.m12953l() > 0) {
                            com_google_android_gms_internal_zztc.m12944d();
                            a++;
                        }
                        com_google_android_gms_internal_zztc.m12947e(b);
                        b = this.f7000f == null ? 0 : this.f7000f.length;
                        obj2 = new long[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f7000f, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = com_google_android_gms_internal_zztc.m12944d();
                            b++;
                        }
                        this.f7000f = obj2;
                        com_google_android_gms_internal_zztc.m12945d(c);
                        continue;
                    default:
                        if (!m13007a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            int i = 0;
            if (this.f6997c != null && this.f6997c.length > 0) {
                for (String str : this.f6997c) {
                    if (str != null) {
                        com_google_android_gms_internal_zztd.m12995a(1, str);
                    }
                }
            }
            if (this.f6998d != null && this.f6998d.length > 0) {
                for (String str2 : this.f6998d) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zztd.m12995a(2, str2);
                    }
                }
            }
            if (this.f6999e != null && this.f6999e.length > 0) {
                for (int a : this.f6999e) {
                    com_google_android_gms_internal_zztd.m12992a(3, a);
                }
            }
            if (this.f7000f != null && this.f7000f.length > 0) {
                while (i < this.f7000f.length) {
                    com_google_android_gms_internal_zztd.m12993a(4, this.f7000f[i]);
                    i++;
                }
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zztp_zza = (zza) obj;
            return !zzti.m13035a(this.f6997c, com_google_android_gms_internal_zztp_zza.f6997c) ? false : !zzti.m13035a(this.f6998d, com_google_android_gms_internal_zztp_zza.f6998d) ? false : !zzti.m13033a(this.f6999e, com_google_android_gms_internal_zztp_zza.f6999e) ? false : !zzti.m13034a(this.f7000f, com_google_android_gms_internal_zztp_zza.f7000f) ? false : (this.f6973a == null || this.f6973a.m13023b()) ? com_google_android_gms_internal_zztp_zza.f6973a == null || com_google_android_gms_internal_zztp_zza.f6973a.m13023b() : this.f6973a.equals(com_google_android_gms_internal_zztp_zza.f6973a);
        }

        public final int hashCode() {
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzti.m13031a(this.f6997c)) * 31) + zzti.m13031a(this.f6998d)) * 31) + zzti.m13029a(this.f6999e)) * 31) + zzti.m13030a(this.f7000f)) * 31;
            int hashCode2 = (this.f6973a == null || this.f6973a.m13023b()) ? 0 : this.f6973a.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public final class zzb extends zzte<zzb> {
        public int f7001c = 0;
        public String f7002d = "";
        public String f7003e = "";

        protected final int mo843a() {
            int a = super.mo843a();
            if (this.f7001c != 0) {
                a += zztd.m12976c(1, this.f7001c);
            }
            if (!this.f7002d.equals("")) {
                a += zztd.m12968b(2, this.f7002d);
            }
            return !this.f7003e.equals("") ? a + zztd.m12968b(3, this.f7003e) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = com_google_android_gms_internal_zztc.m12946e();
                        switch (a) {
                            case 0:
                            case 1:
                            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                            case 3:
                            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
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
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.f7001c = a;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f7002d = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 26:
                        this.f7003e = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    default:
                        if (!m13007a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (this.f7001c != 0) {
                com_google_android_gms_internal_zztd.m12992a(1, this.f7001c);
            }
            if (!this.f7002d.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f7002d);
            }
            if (!this.f7003e.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(3, this.f7003e);
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zztp_zzb = (zzb) obj;
            if (this.f7001c != com_google_android_gms_internal_zztp_zzb.f7001c) {
                return false;
            }
            if (this.f7002d == null) {
                if (com_google_android_gms_internal_zztp_zzb.f7002d != null) {
                    return false;
                }
            } else if (!this.f7002d.equals(com_google_android_gms_internal_zztp_zzb.f7002d)) {
                return false;
            }
            if (this.f7003e == null) {
                if (com_google_android_gms_internal_zztp_zzb.f7003e != null) {
                    return false;
                }
            } else if (!this.f7003e.equals(com_google_android_gms_internal_zztp_zzb.f7003e)) {
                return false;
            }
            return (this.f6973a == null || this.f6973a.m13023b()) ? com_google_android_gms_internal_zztp_zzb.f6973a == null || com_google_android_gms_internal_zztp_zzb.f6973a.m13023b() : this.f6973a.equals(com_google_android_gms_internal_zztp_zzb.f6973a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f7003e == null ? 0 : this.f7003e.hashCode()) + (((this.f7002d == null ? 0 : this.f7002d.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f7001c) * 31)) * 31)) * 31;
            if (!(this.f6973a == null || this.f6973a.m13023b())) {
                i = this.f6973a.hashCode();
            }
            return hashCode + i;
        }
    }

    public final class zzc extends zzte<zzc> {
        public byte[] f7004c = zztn.f6996h;
        public byte[][] f7005d = zztn.f6995g;
        public boolean f7006e = false;

        protected final int mo843a() {
            int i = 0;
            int a = super.mo843a();
            if (!Arrays.equals(this.f7004c, zztn.f6996h)) {
                a += zztd.m12970b(1, this.f7004c);
            }
            if (this.f7005d != null && this.f7005d.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f7005d.length) {
                    byte[] bArr = this.f7005d[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zztd.m12971b(bArr);
                    }
                    i++;
                }
                a = (a + i2) + (i3 * 1);
            }
            return this.f7006e ? a + zztd.m12969b(3, this.f7006e) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f7004c = com_google_android_gms_internal_zztc.m12950h();
                        continue;
                    case 18:
                        int b = zztn.m13048b(com_google_android_gms_internal_zztc, 18);
                        a = this.f7005d == null ? 0 : this.f7005d.length;
                        Object obj = new byte[(b + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f7005d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12950h();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12950h();
                        this.f7005d = obj;
                        continue;
                    case 24:
                        this.f7006e = com_google_android_gms_internal_zztc.m12948f();
                        continue;
                    default:
                        if (!m13007a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (!Arrays.equals(this.f7004c, zztn.f6996h)) {
                com_google_android_gms_internal_zztd.m12997a(1, this.f7004c);
            }
            if (this.f7005d != null && this.f7005d.length > 0) {
                for (byte[] bArr : this.f7005d) {
                    if (bArr != null) {
                        com_google_android_gms_internal_zztd.m12997a(2, bArr);
                    }
                }
            }
            if (this.f7006e) {
                com_google_android_gms_internal_zztd.m12996a(3, this.f7006e);
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zztp_zzc = (zzc) obj;
            return !Arrays.equals(this.f7004c, com_google_android_gms_internal_zztp_zzc.f7004c) ? false : !zzti.m13036a(this.f7005d, com_google_android_gms_internal_zztp_zzc.f7005d) ? false : this.f7006e != com_google_android_gms_internal_zztp_zzc.f7006e ? false : (this.f6973a == null || this.f6973a.m13023b()) ? com_google_android_gms_internal_zztp_zzc.f6973a == null || com_google_android_gms_internal_zztp_zzc.f6973a.m13023b() : this.f6973a.equals(com_google_android_gms_internal_zztp_zzc.f6973a);
        }

        public final int hashCode() {
            int hashCode = ((this.f7006e ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f7004c)) * 31) + zzti.m13032a(this.f7005d)) * 31)) * 31;
            int hashCode2 = (this.f6973a == null || this.f6973a.m13023b()) ? 0 : this.f6973a.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public final class zzd extends zzte<zzd> {
        public long f7007c = 0;
        public long f7008d = 0;
        public long f7009e = 0;
        public String f7010f = "";
        public int f7011g = 0;
        public int f7012h = 0;
        public boolean f7013i = false;
        public zze[] f7014j = zze.m13061e();
        public zzb f7015k = null;
        public byte[] f7016l = zztn.f6996h;
        public byte[] f7017m = zztn.f6996h;
        public byte[] f7018n = zztn.f6996h;
        public zza f7019o = null;
        public String f7020p = "";
        public long f7021q = 180000;
        public zzc f7022r = null;
        public byte[] f7023s = zztn.f6996h;
        public int f7024t = 0;
        public int[] f7025u = zztn.f6989a;

        protected final int mo843a() {
            int i;
            int i2 = 0;
            int a = super.mo843a();
            if (this.f7007c != 0) {
                a += zztd.m12977c(1, this.f7007c);
            }
            if (!this.f7010f.equals("")) {
                a += zztd.m12968b(2, this.f7010f);
            }
            if (this.f7014j != null && this.f7014j.length > 0) {
                i = a;
                for (zztk com_google_android_gms_internal_zztk : this.f7014j) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i += zztd.m12978c(3, com_google_android_gms_internal_zztk);
                    }
                }
                a = i;
            }
            if (!Arrays.equals(this.f7016l, zztn.f6996h)) {
                a += zztd.m12970b(6, this.f7016l);
            }
            if (this.f7019o != null) {
                a += zztd.m12978c(7, this.f7019o);
            }
            if (!Arrays.equals(this.f7017m, zztn.f6996h)) {
                a += zztd.m12970b(8, this.f7017m);
            }
            if (this.f7015k != null) {
                a += zztd.m12978c(9, this.f7015k);
            }
            if (this.f7013i) {
                a += zztd.m12969b(10, this.f7013i);
            }
            if (this.f7011g != 0) {
                a += zztd.m12976c(11, this.f7011g);
            }
            if (this.f7012h != 0) {
                a += zztd.m12976c(12, this.f7012h);
            }
            if (!Arrays.equals(this.f7018n, zztn.f6996h)) {
                a += zztd.m12970b(13, this.f7018n);
            }
            if (!this.f7020p.equals("")) {
                a += zztd.m12968b(14, this.f7020p);
            }
            if (this.f7021q != 180000) {
                a += zztd.m12985h(15) + zztd.m12982f(zztd.m12986h(this.f7021q));
            }
            if (this.f7022r != null) {
                a += zztd.m12978c(16, this.f7022r);
            }
            if (this.f7008d != 0) {
                a += zztd.m12977c(17, this.f7008d);
            }
            if (!Arrays.equals(this.f7023s, zztn.f6996h)) {
                a += zztd.m12970b(18, this.f7023s);
            }
            if (this.f7024t != 0) {
                a += zztd.m12976c(19, this.f7024t);
            }
            if (this.f7025u != null && this.f7025u.length > 0) {
                i = 0;
                while (i2 < this.f7025u.length) {
                    i += zztd.m12955a(this.f7025u[i2]);
                    i2++;
                }
                a = (a + i) + (this.f7025u.length * 2);
            }
            return this.f7009e != 0 ? a + zztd.m12977c(21, this.f7009e) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f7007c = com_google_android_gms_internal_zztc.m12944d();
                        continue;
                    case 18:
                        this.f7010f = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 26:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 26);
                        a = this.f7014j == null ? 0 : this.f7014j.length;
                        obj = new zze[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f7014j, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new zze();
                            com_google_android_gms_internal_zztc.m12939a(obj[a]);
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = new zze();
                        com_google_android_gms_internal_zztc.m12939a(obj[a]);
                        this.f7014j = obj;
                        continue;
                    case 50:
                        this.f7016l = com_google_android_gms_internal_zztc.m12950h();
                        continue;
                    case 58:
                        if (this.f7019o == null) {
                            this.f7019o = new zza();
                        }
                        com_google_android_gms_internal_zztc.m12939a(this.f7019o);
                        continue;
                    case 66:
                        this.f7017m = com_google_android_gms_internal_zztc.m12950h();
                        continue;
                    case 74:
                        if (this.f7015k == null) {
                            this.f7015k = new zzb();
                        }
                        com_google_android_gms_internal_zztc.m12939a(this.f7015k);
                        continue;
                    case 80:
                        this.f7013i = com_google_android_gms_internal_zztc.m12948f();
                        continue;
                    case 88:
                        this.f7011g = com_google_android_gms_internal_zztc.m12946e();
                        continue;
                    case 96:
                        this.f7012h = com_google_android_gms_internal_zztc.m12946e();
                        continue;
                    case 106:
                        this.f7018n = com_google_android_gms_internal_zztc.m12950h();
                        continue;
                    case 114:
                        this.f7020p = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 120:
                        this.f7021q = com_google_android_gms_internal_zztc.m12951j();
                        continue;
                    case 130:
                        if (this.f7022r == null) {
                            this.f7022r = new zzc();
                        }
                        com_google_android_gms_internal_zztc.m12939a(this.f7022r);
                        continue;
                    case 136:
                        this.f7008d = com_google_android_gms_internal_zztc.m12944d();
                        continue;
                    case 146:
                        this.f7023s = com_google_android_gms_internal_zztc.m12950h();
                        continue;
                    case 152:
                        a = com_google_android_gms_internal_zztc.m12946e();
                        switch (a) {
                            case 0:
                            case 1:
                            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                                this.f7024t = a;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 160);
                        a = this.f7025u == null ? 0 : this.f7025u.length;
                        obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f7025u, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = com_google_android_gms_internal_zztc.m12946e();
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = com_google_android_gms_internal_zztc.m12946e();
                        this.f7025u = obj;
                        continue;
                    case 162:
                        int c = com_google_android_gms_internal_zztc.m12943c(com_google_android_gms_internal_zztc.m12952k());
                        b = com_google_android_gms_internal_zztc.m12954m();
                        a = 0;
                        while (com_google_android_gms_internal_zztc.m12953l() > 0) {
                            com_google_android_gms_internal_zztc.m12946e();
                            a++;
                        }
                        com_google_android_gms_internal_zztc.m12947e(b);
                        b = this.f7025u == null ? 0 : this.f7025u.length;
                        Object obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f7025u, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = com_google_android_gms_internal_zztc.m12946e();
                            b++;
                        }
                        this.f7025u = obj2;
                        com_google_android_gms_internal_zztc.m12945d(c);
                        continue;
                    case 168:
                        this.f7009e = com_google_android_gms_internal_zztc.m12944d();
                        continue;
                    default:
                        if (!m13007a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            int i = 0;
            if (this.f7007c != 0) {
                com_google_android_gms_internal_zztd.m12993a(1, this.f7007c);
            }
            if (!this.f7010f.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f7010f);
            }
            if (this.f7014j != null && this.f7014j.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f7014j) {
                    if (com_google_android_gms_internal_zztk != null) {
                        com_google_android_gms_internal_zztd.m12994a(3, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (!Arrays.equals(this.f7016l, zztn.f6996h)) {
                com_google_android_gms_internal_zztd.m12997a(6, this.f7016l);
            }
            if (this.f7019o != null) {
                com_google_android_gms_internal_zztd.m12994a(7, this.f7019o);
            }
            if (!Arrays.equals(this.f7017m, zztn.f6996h)) {
                com_google_android_gms_internal_zztd.m12997a(8, this.f7017m);
            }
            if (this.f7015k != null) {
                com_google_android_gms_internal_zztd.m12994a(9, this.f7015k);
            }
            if (this.f7013i) {
                com_google_android_gms_internal_zztd.m12996a(10, this.f7013i);
            }
            if (this.f7011g != 0) {
                com_google_android_gms_internal_zztd.m12992a(11, this.f7011g);
            }
            if (this.f7012h != 0) {
                com_google_android_gms_internal_zztd.m12992a(12, this.f7012h);
            }
            if (!Arrays.equals(this.f7018n, zztn.f6996h)) {
                com_google_android_gms_internal_zztd.m12997a(13, this.f7018n);
            }
            if (!this.f7020p.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(14, this.f7020p);
            }
            if (this.f7021q != 180000) {
                com_google_android_gms_internal_zztd.m13000b(15, this.f7021q);
            }
            if (this.f7022r != null) {
                com_google_android_gms_internal_zztd.m12994a(16, this.f7022r);
            }
            if (this.f7008d != 0) {
                com_google_android_gms_internal_zztd.m12993a(17, this.f7008d);
            }
            if (!Arrays.equals(this.f7023s, zztn.f6996h)) {
                com_google_android_gms_internal_zztd.m12997a(18, this.f7023s);
            }
            if (this.f7024t != 0) {
                com_google_android_gms_internal_zztd.m12992a(19, this.f7024t);
            }
            if (this.f7025u != null && this.f7025u.length > 0) {
                while (i < this.f7025u.length) {
                    com_google_android_gms_internal_zztd.m12992a(20, this.f7025u[i]);
                    i++;
                }
            }
            if (this.f7009e != 0) {
                com_google_android_gms_internal_zztd.m12993a(21, this.f7009e);
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zztp_zzd = (zzd) obj;
            if (this.f7007c != com_google_android_gms_internal_zztp_zzd.f7007c) {
                return false;
            }
            if (this.f7008d != com_google_android_gms_internal_zztp_zzd.f7008d) {
                return false;
            }
            if (this.f7009e != com_google_android_gms_internal_zztp_zzd.f7009e) {
                return false;
            }
            if (this.f7010f == null) {
                if (com_google_android_gms_internal_zztp_zzd.f7010f != null) {
                    return false;
                }
            } else if (!this.f7010f.equals(com_google_android_gms_internal_zztp_zzd.f7010f)) {
                return false;
            }
            if (this.f7011g != com_google_android_gms_internal_zztp_zzd.f7011g) {
                return false;
            }
            if (this.f7012h != com_google_android_gms_internal_zztp_zzd.f7012h) {
                return false;
            }
            if (this.f7013i != com_google_android_gms_internal_zztp_zzd.f7013i) {
                return false;
            }
            if (!zzti.m13035a(this.f7014j, com_google_android_gms_internal_zztp_zzd.f7014j)) {
                return false;
            }
            if (this.f7015k == null) {
                if (com_google_android_gms_internal_zztp_zzd.f7015k != null) {
                    return false;
                }
            } else if (!this.f7015k.equals(com_google_android_gms_internal_zztp_zzd.f7015k)) {
                return false;
            }
            if (!Arrays.equals(this.f7016l, com_google_android_gms_internal_zztp_zzd.f7016l)) {
                return false;
            }
            if (!Arrays.equals(this.f7017m, com_google_android_gms_internal_zztp_zzd.f7017m)) {
                return false;
            }
            if (!Arrays.equals(this.f7018n, com_google_android_gms_internal_zztp_zzd.f7018n)) {
                return false;
            }
            if (this.f7019o == null) {
                if (com_google_android_gms_internal_zztp_zzd.f7019o != null) {
                    return false;
                }
            } else if (!this.f7019o.equals(com_google_android_gms_internal_zztp_zzd.f7019o)) {
                return false;
            }
            if (this.f7020p == null) {
                if (com_google_android_gms_internal_zztp_zzd.f7020p != null) {
                    return false;
                }
            } else if (!this.f7020p.equals(com_google_android_gms_internal_zztp_zzd.f7020p)) {
                return false;
            }
            if (this.f7021q != com_google_android_gms_internal_zztp_zzd.f7021q) {
                return false;
            }
            if (this.f7022r == null) {
                if (com_google_android_gms_internal_zztp_zzd.f7022r != null) {
                    return false;
                }
            } else if (!this.f7022r.equals(com_google_android_gms_internal_zztp_zzd.f7022r)) {
                return false;
            }
            return !Arrays.equals(this.f7023s, com_google_android_gms_internal_zztp_zzd.f7023s) ? false : this.f7024t != com_google_android_gms_internal_zztp_zzd.f7024t ? false : !zzti.m13033a(this.f7025u, com_google_android_gms_internal_zztp_zzd.f7025u) ? false : (this.f6973a == null || this.f6973a.m13023b()) ? com_google_android_gms_internal_zztp_zzd.f6973a == null || com_google_android_gms_internal_zztp_zzd.f6973a.m13023b() : this.f6973a.equals(com_google_android_gms_internal_zztp_zzd.f6973a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((((((((this.f7022r == null ? 0 : this.f7022r.hashCode()) + (((((this.f7020p == null ? 0 : this.f7020p.hashCode()) + (((this.f7019o == null ? 0 : this.f7019o.hashCode()) + (((((((((this.f7015k == null ? 0 : this.f7015k.hashCode()) + (((((this.f7013i ? 1231 : 1237) + (((((((this.f7010f == null ? 0 : this.f7010f.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f7007c ^ (this.f7007c >>> 32)))) * 31) + ((int) (this.f7008d ^ (this.f7008d >>> 32)))) * 31) + ((int) (this.f7009e ^ (this.f7009e >>> 32)))) * 31)) * 31) + this.f7011g) * 31) + this.f7012h) * 31)) * 31) + zzti.m13031a(this.f7014j)) * 31)) * 31) + Arrays.hashCode(this.f7016l)) * 31) + Arrays.hashCode(this.f7017m)) * 31) + Arrays.hashCode(this.f7018n)) * 31)) * 31)) * 31) + ((int) (this.f7021q ^ (this.f7021q >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.f7023s)) * 31) + this.f7024t) * 31) + zzti.m13029a(this.f7025u)) * 31;
            if (!(this.f6973a == null || this.f6973a.m13023b())) {
                i = this.f6973a.hashCode();
            }
            return hashCode + i;
        }
    }

    public final class zze extends zzte<zze> {
        private static volatile zze[] f7026e;
        public String f7027c = "";
        public String f7028d = "";

        public static zze[] m13061e() {
            if (f7026e == null) {
                synchronized (zzti.f6986a) {
                    if (f7026e == null) {
                        f7026e = new zze[0];
                    }
                }
            }
            return f7026e;
        }

        protected final int mo843a() {
            int a = super.mo843a();
            if (!this.f7027c.equals("")) {
                a += zztd.m12968b(1, this.f7027c);
            }
            return !this.f7028d.equals("") ? a + zztd.m12968b(2, this.f7028d) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f7027c = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 18:
                        this.f7028d = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    default:
                        if (!m13007a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (!this.f7027c.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(1, this.f7027c);
            }
            if (!this.f7028d.equals("")) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f7028d);
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zztp_zze = (zze) obj;
            if (this.f7027c == null) {
                if (com_google_android_gms_internal_zztp_zze.f7027c != null) {
                    return false;
                }
            } else if (!this.f7027c.equals(com_google_android_gms_internal_zztp_zze.f7027c)) {
                return false;
            }
            if (this.f7028d == null) {
                if (com_google_android_gms_internal_zztp_zze.f7028d != null) {
                    return false;
                }
            } else if (!this.f7028d.equals(com_google_android_gms_internal_zztp_zze.f7028d)) {
                return false;
            }
            return (this.f6973a == null || this.f6973a.m13023b()) ? com_google_android_gms_internal_zztp_zze.f6973a == null || com_google_android_gms_internal_zztp_zze.f6973a.m13023b() : this.f6973a.equals(com_google_android_gms_internal_zztp_zze.f6973a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f7028d == null ? 0 : this.f7028d.hashCode()) + (((this.f7027c == null ? 0 : this.f7027c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.f6973a == null || this.f6973a.m13023b())) {
                i = this.f6973a.hashCode();
            }
            return hashCode + i;
        }
    }
}
