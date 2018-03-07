package com.google.android.gms.internal;

public interface zzqq {

    public final class zza extends zztk {
        private static volatile zza[] f6916g;
        public zzb[] f6917a = zzb.m12908e();
        public String f6918c = null;
        public Long f6919d = null;
        public Long f6920e = null;
        public Integer f6921f = null;

        public static zza[] m12904e() {
            if (f6916g == null) {
                synchronized (zzti.f6986a) {
                    if (f6916g == null) {
                        f6916g = new zza[0];
                    }
                }
            }
            return f6916g;
        }

        protected final int mo843a() {
            int a = super.mo843a();
            if (this.f6917a != null && this.f6917a.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f6917a) {
                    if (com_google_android_gms_internal_zztk != null) {
                        a += zztd.m12978c(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.f6918c != null) {
                a += zztd.m12968b(2, this.f6918c);
            }
            if (this.f6919d != null) {
                a += zztd.m12977c(3, this.f6919d.longValue());
            }
            if (this.f6920e != null) {
                a += zztd.m12977c(4, this.f6920e.longValue());
            }
            return this.f6921f != null ? a + zztd.m12976c(5, this.f6921f.intValue()) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = zztn.m13048b(com_google_android_gms_internal_zztc, 10);
                        a = this.f6917a == null ? 0 : this.f6917a.length;
                        Object obj = new zzb[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6917a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new zzb();
                            com_google_android_gms_internal_zztc.m12939a(obj[a]);
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = new zzb();
                        com_google_android_gms_internal_zztc.m12939a(obj[a]);
                        this.f6917a = obj;
                        continue;
                    case 18:
                        this.f6918c = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 24:
                        this.f6919d = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 32:
                        this.f6920e = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 40:
                        this.f6921f = Integer.valueOf(com_google_android_gms_internal_zztc.m12946e());
                        continue;
                    default:
                        if (!zztn.m13046a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (this.f6917a != null && this.f6917a.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f6917a) {
                    if (com_google_android_gms_internal_zztk != null) {
                        com_google_android_gms_internal_zztd.m12994a(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.f6918c != null) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f6918c);
            }
            if (this.f6919d != null) {
                com_google_android_gms_internal_zztd.m12993a(3, this.f6919d.longValue());
            }
            if (this.f6920e != null) {
                com_google_android_gms_internal_zztd.m12993a(4, this.f6920e.longValue());
            }
            if (this.f6921f != null) {
                com_google_android_gms_internal_zztd.m12992a(5, this.f6921f.intValue());
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
            zza com_google_android_gms_internal_zzqq_zza = (zza) obj;
            if (!zzti.m13035a(this.f6917a, com_google_android_gms_internal_zzqq_zza.f6917a)) {
                return false;
            }
            if (this.f6918c == null) {
                if (com_google_android_gms_internal_zzqq_zza.f6918c != null) {
                    return false;
                }
            } else if (!this.f6918c.equals(com_google_android_gms_internal_zzqq_zza.f6918c)) {
                return false;
            }
            if (this.f6919d == null) {
                if (com_google_android_gms_internal_zzqq_zza.f6919d != null) {
                    return false;
                }
            } else if (!this.f6919d.equals(com_google_android_gms_internal_zzqq_zza.f6919d)) {
                return false;
            }
            if (this.f6920e == null) {
                if (com_google_android_gms_internal_zzqq_zza.f6920e != null) {
                    return false;
                }
            } else if (!this.f6920e.equals(com_google_android_gms_internal_zzqq_zza.f6920e)) {
                return false;
            }
            return this.f6921f == null ? com_google_android_gms_internal_zzqq_zza.f6921f == null : this.f6921f.equals(com_google_android_gms_internal_zzqq_zza.f6921f);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f6920e == null ? 0 : this.f6920e.hashCode()) + (((this.f6919d == null ? 0 : this.f6919d.hashCode()) + (((this.f6918c == null ? 0 : this.f6918c.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzti.m13031a(this.f6917a)) * 31)) * 31)) * 31)) * 31;
            if (this.f6921f != null) {
                i = this.f6921f.hashCode();
            }
            return hashCode + i;
        }
    }

    public final class zzb extends zztk {
        private static volatile zzb[] f6922f;
        public String f6923a = null;
        public String f6924c = null;
        public Long f6925d = null;
        public Float f6926e = null;

        public static zzb[] m12908e() {
            if (f6922f == null) {
                synchronized (zzti.f6986a) {
                    if (f6922f == null) {
                        f6922f = new zzb[0];
                    }
                }
            }
            return f6922f;
        }

        protected final int mo843a() {
            int a = super.mo843a();
            if (this.f6923a != null) {
                a += zztd.m12968b(1, this.f6923a);
            }
            if (this.f6924c != null) {
                a += zztd.m12968b(2, this.f6924c);
            }
            if (this.f6925d != null) {
                a += zztd.m12977c(3, this.f6925d.longValue());
            }
            return this.f6926e != null ? a + zztd.m12967b(4, this.f6926e.floatValue()) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f6923a = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 18:
                        this.f6924c = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 24:
                        this.f6925d = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 37:
                        this.f6926e = Float.valueOf(com_google_android_gms_internal_zztc.m12942c());
                        continue;
                    default:
                        if (!zztn.m13046a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (this.f6923a != null) {
                com_google_android_gms_internal_zztd.m12995a(1, this.f6923a);
            }
            if (this.f6924c != null) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f6924c);
            }
            if (this.f6925d != null) {
                com_google_android_gms_internal_zztd.m12993a(3, this.f6925d.longValue());
            }
            if (this.f6926e != null) {
                com_google_android_gms_internal_zztd.m12991a(4, this.f6926e.floatValue());
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
            zzb com_google_android_gms_internal_zzqq_zzb = (zzb) obj;
            if (this.f6923a == null) {
                if (com_google_android_gms_internal_zzqq_zzb.f6923a != null) {
                    return false;
                }
            } else if (!this.f6923a.equals(com_google_android_gms_internal_zzqq_zzb.f6923a)) {
                return false;
            }
            if (this.f6924c == null) {
                if (com_google_android_gms_internal_zzqq_zzb.f6924c != null) {
                    return false;
                }
            } else if (!this.f6924c.equals(com_google_android_gms_internal_zzqq_zzb.f6924c)) {
                return false;
            }
            if (this.f6925d == null) {
                if (com_google_android_gms_internal_zzqq_zzb.f6925d != null) {
                    return false;
                }
            } else if (!this.f6925d.equals(com_google_android_gms_internal_zzqq_zzb.f6925d)) {
                return false;
            }
            return this.f6926e == null ? com_google_android_gms_internal_zzqq_zzb.f6926e == null : this.f6926e.equals(com_google_android_gms_internal_zzqq_zzb.f6926e);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f6925d == null ? 0 : this.f6925d.hashCode()) + (((this.f6924c == null ? 0 : this.f6924c.hashCode()) + (((this.f6923a == null ? 0 : this.f6923a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.f6926e != null) {
                i = this.f6926e.hashCode();
            }
            return hashCode + i;
        }
    }

    public final class zzc extends zztk {
        public zzd[] f6927a = zzd.m12915e();

        protected final int mo843a() {
            int a = super.mo843a();
            if (this.f6927a != null && this.f6927a.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f6927a) {
                    if (com_google_android_gms_internal_zztk != null) {
                        a += zztd.m12978c(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            return a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = zztn.m13048b(com_google_android_gms_internal_zztc, 10);
                        a = this.f6927a == null ? 0 : this.f6927a.length;
                        Object obj = new zzd[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6927a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new zzd();
                            com_google_android_gms_internal_zztc.m12939a(obj[a]);
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = new zzd();
                        com_google_android_gms_internal_zztc.m12939a(obj[a]);
                        this.f6927a = obj;
                        continue;
                    default:
                        if (!zztn.m13046a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (this.f6927a != null && this.f6927a.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f6927a) {
                    if (com_google_android_gms_internal_zztk != null) {
                        com_google_android_gms_internal_zztd.m12994a(1, com_google_android_gms_internal_zztk);
                    }
                }
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
            return zzti.m13035a(this.f6927a, ((zzc) obj).f6927a);
        }

        public final int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzti.m13031a(this.f6927a);
        }
    }

    public final class zzd extends zztk {
        private static volatile zzd[] f6928B;
        public Boolean f6929A = null;
        public Integer f6930a = null;
        public zza[] f6931c = zza.m12904e();
        public zze[] f6932d = zze.m12920e();
        public Long f6933e = null;
        public Long f6934f = null;
        public Long f6935g = null;
        public Long f6936h = null;
        public Long f6937i = null;
        public String f6938j = null;
        public String f6939k = null;
        public String f6940l = null;
        public String f6941m = null;
        public Integer f6942n = null;
        public String f6943o = null;
        public String f6944p = null;
        public String f6945q = null;
        public Long f6946r = null;
        public Long f6947s = null;
        public String f6948t = null;
        public Boolean f6949u = null;
        public String f6950v = null;
        public Long f6951w = null;
        public Integer f6952x = null;
        public String f6953y = null;
        public String f6954z = null;

        public static zzd[] m12915e() {
            if (f6928B == null) {
                synchronized (zzti.f6986a) {
                    if (f6928B == null) {
                        f6928B = new zzd[0];
                    }
                }
            }
            return f6928B;
        }

        protected final int mo843a() {
            int i = 0;
            int a = super.mo843a();
            if (this.f6930a != null) {
                a += zztd.m12976c(1, this.f6930a.intValue());
            }
            if (this.f6931c != null && this.f6931c.length > 0) {
                int i2 = a;
                for (zztk com_google_android_gms_internal_zztk : this.f6931c) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i2 += zztd.m12978c(2, com_google_android_gms_internal_zztk);
                    }
                }
                a = i2;
            }
            if (this.f6932d != null && this.f6932d.length > 0) {
                while (i < this.f6932d.length) {
                    zztk com_google_android_gms_internal_zztk2 = this.f6932d[i];
                    if (com_google_android_gms_internal_zztk2 != null) {
                        a += zztd.m12978c(3, com_google_android_gms_internal_zztk2);
                    }
                    i++;
                }
            }
            if (this.f6933e != null) {
                a += zztd.m12977c(4, this.f6933e.longValue());
            }
            if (this.f6934f != null) {
                a += zztd.m12977c(5, this.f6934f.longValue());
            }
            if (this.f6935g != null) {
                a += zztd.m12977c(6, this.f6935g.longValue());
            }
            if (this.f6937i != null) {
                a += zztd.m12977c(7, this.f6937i.longValue());
            }
            if (this.f6938j != null) {
                a += zztd.m12968b(8, this.f6938j);
            }
            if (this.f6939k != null) {
                a += zztd.m12968b(9, this.f6939k);
            }
            if (this.f6940l != null) {
                a += zztd.m12968b(10, this.f6940l);
            }
            if (this.f6941m != null) {
                a += zztd.m12968b(11, this.f6941m);
            }
            if (this.f6942n != null) {
                a += zztd.m12976c(12, this.f6942n.intValue());
            }
            if (this.f6943o != null) {
                a += zztd.m12968b(13, this.f6943o);
            }
            if (this.f6944p != null) {
                a += zztd.m12968b(14, this.f6944p);
            }
            if (this.f6945q != null) {
                a += zztd.m12968b(16, this.f6945q);
            }
            if (this.f6946r != null) {
                a += zztd.m12977c(17, this.f6946r.longValue());
            }
            if (this.f6947s != null) {
                a += zztd.m12977c(18, this.f6947s.longValue());
            }
            if (this.f6948t != null) {
                a += zztd.m12968b(19, this.f6948t);
            }
            if (this.f6949u != null) {
                a += zztd.m12969b(20, this.f6949u.booleanValue());
            }
            if (this.f6950v != null) {
                a += zztd.m12968b(21, this.f6950v);
            }
            if (this.f6951w != null) {
                a += zztd.m12977c(22, this.f6951w.longValue());
            }
            if (this.f6952x != null) {
                a += zztd.m12976c(23, this.f6952x.intValue());
            }
            if (this.f6953y != null) {
                a += zztd.m12968b(24, this.f6953y);
            }
            if (this.f6954z != null) {
                a += zztd.m12968b(25, this.f6954z);
            }
            if (this.f6936h != null) {
                a += zztd.m12977c(26, this.f6936h.longValue());
            }
            return this.f6929A != null ? a + zztd.m12969b(28, this.f6929A.booleanValue()) : a;
        }

        public final /* synthetic */ zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            return m12919b(com_google_android_gms_internal_zztc);
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            int i = 0;
            if (this.f6930a != null) {
                com_google_android_gms_internal_zztd.m12992a(1, this.f6930a.intValue());
            }
            if (this.f6931c != null && this.f6931c.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.f6931c) {
                    if (com_google_android_gms_internal_zztk != null) {
                        com_google_android_gms_internal_zztd.m12994a(2, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.f6932d != null && this.f6932d.length > 0) {
                while (i < this.f6932d.length) {
                    zztk com_google_android_gms_internal_zztk2 = this.f6932d[i];
                    if (com_google_android_gms_internal_zztk2 != null) {
                        com_google_android_gms_internal_zztd.m12994a(3, com_google_android_gms_internal_zztk2);
                    }
                    i++;
                }
            }
            if (this.f6933e != null) {
                com_google_android_gms_internal_zztd.m12993a(4, this.f6933e.longValue());
            }
            if (this.f6934f != null) {
                com_google_android_gms_internal_zztd.m12993a(5, this.f6934f.longValue());
            }
            if (this.f6935g != null) {
                com_google_android_gms_internal_zztd.m12993a(6, this.f6935g.longValue());
            }
            if (this.f6937i != null) {
                com_google_android_gms_internal_zztd.m12993a(7, this.f6937i.longValue());
            }
            if (this.f6938j != null) {
                com_google_android_gms_internal_zztd.m12995a(8, this.f6938j);
            }
            if (this.f6939k != null) {
                com_google_android_gms_internal_zztd.m12995a(9, this.f6939k);
            }
            if (this.f6940l != null) {
                com_google_android_gms_internal_zztd.m12995a(10, this.f6940l);
            }
            if (this.f6941m != null) {
                com_google_android_gms_internal_zztd.m12995a(11, this.f6941m);
            }
            if (this.f6942n != null) {
                com_google_android_gms_internal_zztd.m12992a(12, this.f6942n.intValue());
            }
            if (this.f6943o != null) {
                com_google_android_gms_internal_zztd.m12995a(13, this.f6943o);
            }
            if (this.f6944p != null) {
                com_google_android_gms_internal_zztd.m12995a(14, this.f6944p);
            }
            if (this.f6945q != null) {
                com_google_android_gms_internal_zztd.m12995a(16, this.f6945q);
            }
            if (this.f6946r != null) {
                com_google_android_gms_internal_zztd.m12993a(17, this.f6946r.longValue());
            }
            if (this.f6947s != null) {
                com_google_android_gms_internal_zztd.m12993a(18, this.f6947s.longValue());
            }
            if (this.f6948t != null) {
                com_google_android_gms_internal_zztd.m12995a(19, this.f6948t);
            }
            if (this.f6949u != null) {
                com_google_android_gms_internal_zztd.m12996a(20, this.f6949u.booleanValue());
            }
            if (this.f6950v != null) {
                com_google_android_gms_internal_zztd.m12995a(21, this.f6950v);
            }
            if (this.f6951w != null) {
                com_google_android_gms_internal_zztd.m12993a(22, this.f6951w.longValue());
            }
            if (this.f6952x != null) {
                com_google_android_gms_internal_zztd.m12992a(23, this.f6952x.intValue());
            }
            if (this.f6953y != null) {
                com_google_android_gms_internal_zztd.m12995a(24, this.f6953y);
            }
            if (this.f6954z != null) {
                com_google_android_gms_internal_zztd.m12995a(25, this.f6954z);
            }
            if (this.f6936h != null) {
                com_google_android_gms_internal_zztd.m12993a(26, this.f6936h.longValue());
            }
            if (this.f6929A != null) {
                com_google_android_gms_internal_zztd.m12996a(28, this.f6929A.booleanValue());
            }
            super.mo845a(com_google_android_gms_internal_zztd);
        }

        public final zzd m12919b(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6930a = Integer.valueOf(com_google_android_gms_internal_zztc.m12946e());
                        continue;
                    case 18:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 18);
                        a = this.f6931c == null ? 0 : this.f6931c.length;
                        obj = new zza[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6931c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new zza();
                            com_google_android_gms_internal_zztc.m12939a(obj[a]);
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = new zza();
                        com_google_android_gms_internal_zztc.m12939a(obj[a]);
                        this.f6931c = obj;
                        continue;
                    case 26:
                        b = zztn.m13048b(com_google_android_gms_internal_zztc, 26);
                        a = this.f6932d == null ? 0 : this.f6932d.length;
                        obj = new zze[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6932d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new zze();
                            com_google_android_gms_internal_zztc.m12939a(obj[a]);
                            com_google_android_gms_internal_zztc.m12937a();
                            a++;
                        }
                        obj[a] = new zze();
                        com_google_android_gms_internal_zztc.m12939a(obj[a]);
                        this.f6932d = obj;
                        continue;
                    case 32:
                        this.f6933e = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 40:
                        this.f6934f = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 48:
                        this.f6935g = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 56:
                        this.f6937i = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 66:
                        this.f6938j = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 74:
                        this.f6939k = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 82:
                        this.f6940l = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 90:
                        this.f6941m = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 96:
                        this.f6942n = Integer.valueOf(com_google_android_gms_internal_zztc.m12946e());
                        continue;
                    case 106:
                        this.f6943o = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 114:
                        this.f6944p = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 130:
                        this.f6945q = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 136:
                        this.f6946r = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 144:
                        this.f6947s = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 154:
                        this.f6948t = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 160:
                        this.f6949u = Boolean.valueOf(com_google_android_gms_internal_zztc.m12948f());
                        continue;
                    case 170:
                        this.f6950v = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 176:
                        this.f6951w = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 184:
                        this.f6952x = Integer.valueOf(com_google_android_gms_internal_zztc.m12946e());
                        continue;
                    case 194:
                        this.f6953y = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 202:
                        this.f6954z = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 208:
                        this.f6936h = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 224:
                        this.f6929A = Boolean.valueOf(com_google_android_gms_internal_zztc.m12948f());
                        continue;
                    default:
                        if (!zztn.m13046a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzqq_zzd = (zzd) obj;
            if (this.f6930a == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6930a != null) {
                    return false;
                }
            } else if (!this.f6930a.equals(com_google_android_gms_internal_zzqq_zzd.f6930a)) {
                return false;
            }
            if (!zzti.m13035a(this.f6931c, com_google_android_gms_internal_zzqq_zzd.f6931c)) {
                return false;
            }
            if (!zzti.m13035a(this.f6932d, com_google_android_gms_internal_zzqq_zzd.f6932d)) {
                return false;
            }
            if (this.f6933e == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6933e != null) {
                    return false;
                }
            } else if (!this.f6933e.equals(com_google_android_gms_internal_zzqq_zzd.f6933e)) {
                return false;
            }
            if (this.f6934f == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6934f != null) {
                    return false;
                }
            } else if (!this.f6934f.equals(com_google_android_gms_internal_zzqq_zzd.f6934f)) {
                return false;
            }
            if (this.f6935g == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6935g != null) {
                    return false;
                }
            } else if (!this.f6935g.equals(com_google_android_gms_internal_zzqq_zzd.f6935g)) {
                return false;
            }
            if (this.f6936h == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6936h != null) {
                    return false;
                }
            } else if (!this.f6936h.equals(com_google_android_gms_internal_zzqq_zzd.f6936h)) {
                return false;
            }
            if (this.f6937i == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6937i != null) {
                    return false;
                }
            } else if (!this.f6937i.equals(com_google_android_gms_internal_zzqq_zzd.f6937i)) {
                return false;
            }
            if (this.f6938j == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6938j != null) {
                    return false;
                }
            } else if (!this.f6938j.equals(com_google_android_gms_internal_zzqq_zzd.f6938j)) {
                return false;
            }
            if (this.f6939k == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6939k != null) {
                    return false;
                }
            } else if (!this.f6939k.equals(com_google_android_gms_internal_zzqq_zzd.f6939k)) {
                return false;
            }
            if (this.f6940l == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6940l != null) {
                    return false;
                }
            } else if (!this.f6940l.equals(com_google_android_gms_internal_zzqq_zzd.f6940l)) {
                return false;
            }
            if (this.f6941m == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6941m != null) {
                    return false;
                }
            } else if (!this.f6941m.equals(com_google_android_gms_internal_zzqq_zzd.f6941m)) {
                return false;
            }
            if (this.f6942n == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6942n != null) {
                    return false;
                }
            } else if (!this.f6942n.equals(com_google_android_gms_internal_zzqq_zzd.f6942n)) {
                return false;
            }
            if (this.f6943o == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6943o != null) {
                    return false;
                }
            } else if (!this.f6943o.equals(com_google_android_gms_internal_zzqq_zzd.f6943o)) {
                return false;
            }
            if (this.f6944p == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6944p != null) {
                    return false;
                }
            } else if (!this.f6944p.equals(com_google_android_gms_internal_zzqq_zzd.f6944p)) {
                return false;
            }
            if (this.f6945q == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6945q != null) {
                    return false;
                }
            } else if (!this.f6945q.equals(com_google_android_gms_internal_zzqq_zzd.f6945q)) {
                return false;
            }
            if (this.f6946r == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6946r != null) {
                    return false;
                }
            } else if (!this.f6946r.equals(com_google_android_gms_internal_zzqq_zzd.f6946r)) {
                return false;
            }
            if (this.f6947s == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6947s != null) {
                    return false;
                }
            } else if (!this.f6947s.equals(com_google_android_gms_internal_zzqq_zzd.f6947s)) {
                return false;
            }
            if (this.f6948t == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6948t != null) {
                    return false;
                }
            } else if (!this.f6948t.equals(com_google_android_gms_internal_zzqq_zzd.f6948t)) {
                return false;
            }
            if (this.f6949u == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6949u != null) {
                    return false;
                }
            } else if (!this.f6949u.equals(com_google_android_gms_internal_zzqq_zzd.f6949u)) {
                return false;
            }
            if (this.f6950v == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6950v != null) {
                    return false;
                }
            } else if (!this.f6950v.equals(com_google_android_gms_internal_zzqq_zzd.f6950v)) {
                return false;
            }
            if (this.f6951w == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6951w != null) {
                    return false;
                }
            } else if (!this.f6951w.equals(com_google_android_gms_internal_zzqq_zzd.f6951w)) {
                return false;
            }
            if (this.f6952x == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6952x != null) {
                    return false;
                }
            } else if (!this.f6952x.equals(com_google_android_gms_internal_zzqq_zzd.f6952x)) {
                return false;
            }
            if (this.f6953y == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6953y != null) {
                    return false;
                }
            } else if (!this.f6953y.equals(com_google_android_gms_internal_zzqq_zzd.f6953y)) {
                return false;
            }
            if (this.f6954z == null) {
                if (com_google_android_gms_internal_zzqq_zzd.f6954z != null) {
                    return false;
                }
            } else if (!this.f6954z.equals(com_google_android_gms_internal_zzqq_zzd.f6954z)) {
                return false;
            }
            return this.f6929A == null ? com_google_android_gms_internal_zzqq_zzd.f6929A == null : this.f6929A.equals(com_google_android_gms_internal_zzqq_zzd.f6929A);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f6954z == null ? 0 : this.f6954z.hashCode()) + (((this.f6953y == null ? 0 : this.f6953y.hashCode()) + (((this.f6952x == null ? 0 : this.f6952x.hashCode()) + (((this.f6951w == null ? 0 : this.f6951w.hashCode()) + (((this.f6950v == null ? 0 : this.f6950v.hashCode()) + (((this.f6949u == null ? 0 : this.f6949u.hashCode()) + (((this.f6948t == null ? 0 : this.f6948t.hashCode()) + (((this.f6947s == null ? 0 : this.f6947s.hashCode()) + (((this.f6946r == null ? 0 : this.f6946r.hashCode()) + (((this.f6945q == null ? 0 : this.f6945q.hashCode()) + (((this.f6944p == null ? 0 : this.f6944p.hashCode()) + (((this.f6943o == null ? 0 : this.f6943o.hashCode()) + (((this.f6942n == null ? 0 : this.f6942n.hashCode()) + (((this.f6941m == null ? 0 : this.f6941m.hashCode()) + (((this.f6940l == null ? 0 : this.f6940l.hashCode()) + (((this.f6939k == null ? 0 : this.f6939k.hashCode()) + (((this.f6938j == null ? 0 : this.f6938j.hashCode()) + (((this.f6937i == null ? 0 : this.f6937i.hashCode()) + (((this.f6936h == null ? 0 : this.f6936h.hashCode()) + (((this.f6935g == null ? 0 : this.f6935g.hashCode()) + (((this.f6934f == null ? 0 : this.f6934f.hashCode()) + (((this.f6933e == null ? 0 : this.f6933e.hashCode()) + (((((((this.f6930a == null ? 0 : this.f6930a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzti.m13031a(this.f6931c)) * 31) + zzti.m13031a(this.f6932d)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6929A != null) {
                i = this.f6929A.hashCode();
            }
            return hashCode + i;
        }
    }

    public final class zze extends zztk {
        private static volatile zze[] f6955g;
        public Long f6956a = null;
        public String f6957c = null;
        public String f6958d = null;
        public Long f6959e = null;
        public Float f6960f = null;

        public static zze[] m12920e() {
            if (f6955g == null) {
                synchronized (zzti.f6986a) {
                    if (f6955g == null) {
                        f6955g = new zze[0];
                    }
                }
            }
            return f6955g;
        }

        protected final int mo843a() {
            int a = super.mo843a();
            if (this.f6956a != null) {
                a += zztd.m12977c(1, this.f6956a.longValue());
            }
            if (this.f6957c != null) {
                a += zztd.m12968b(2, this.f6957c);
            }
            if (this.f6958d != null) {
                a += zztd.m12968b(3, this.f6958d);
            }
            if (this.f6959e != null) {
                a += zztd.m12977c(4, this.f6959e.longValue());
            }
            return this.f6960f != null ? a + zztd.m12967b(5, this.f6960f.floatValue()) : a;
        }

        public final zztk mo844a(zztc com_google_android_gms_internal_zztc) {
            while (true) {
                int a = com_google_android_gms_internal_zztc.m12937a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6956a = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 18:
                        this.f6957c = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 26:
                        this.f6958d = com_google_android_gms_internal_zztc.m12949g();
                        continue;
                    case 32:
                        this.f6959e = Long.valueOf(com_google_android_gms_internal_zztc.m12944d());
                        continue;
                    case 45:
                        this.f6960f = Float.valueOf(com_google_android_gms_internal_zztc.m12942c());
                        continue;
                    default:
                        if (!zztn.m13046a(com_google_android_gms_internal_zztc, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void mo845a(zztd com_google_android_gms_internal_zztd) {
            if (this.f6956a != null) {
                com_google_android_gms_internal_zztd.m12993a(1, this.f6956a.longValue());
            }
            if (this.f6957c != null) {
                com_google_android_gms_internal_zztd.m12995a(2, this.f6957c);
            }
            if (this.f6958d != null) {
                com_google_android_gms_internal_zztd.m12995a(3, this.f6958d);
            }
            if (this.f6959e != null) {
                com_google_android_gms_internal_zztd.m12993a(4, this.f6959e.longValue());
            }
            if (this.f6960f != null) {
                com_google_android_gms_internal_zztd.m12991a(5, this.f6960f.floatValue());
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
            zze com_google_android_gms_internal_zzqq_zze = (zze) obj;
            if (this.f6956a == null) {
                if (com_google_android_gms_internal_zzqq_zze.f6956a != null) {
                    return false;
                }
            } else if (!this.f6956a.equals(com_google_android_gms_internal_zzqq_zze.f6956a)) {
                return false;
            }
            if (this.f6957c == null) {
                if (com_google_android_gms_internal_zzqq_zze.f6957c != null) {
                    return false;
                }
            } else if (!this.f6957c.equals(com_google_android_gms_internal_zzqq_zze.f6957c)) {
                return false;
            }
            if (this.f6958d == null) {
                if (com_google_android_gms_internal_zzqq_zze.f6958d != null) {
                    return false;
                }
            } else if (!this.f6958d.equals(com_google_android_gms_internal_zzqq_zze.f6958d)) {
                return false;
            }
            if (this.f6959e == null) {
                if (com_google_android_gms_internal_zzqq_zze.f6959e != null) {
                    return false;
                }
            } else if (!this.f6959e.equals(com_google_android_gms_internal_zzqq_zze.f6959e)) {
                return false;
            }
            return this.f6960f == null ? com_google_android_gms_internal_zzqq_zze.f6960f == null : this.f6960f.equals(com_google_android_gms_internal_zzqq_zze.f6960f);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.f6959e == null ? 0 : this.f6959e.hashCode()) + (((this.f6958d == null ? 0 : this.f6958d.hashCode()) + (((this.f6957c == null ? 0 : this.f6957c.hashCode()) + (((this.f6956a == null ? 0 : this.f6956a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6960f != null) {
                i = this.f6960f.hashCode();
            }
            return hashCode + i;
        }
    }
}
