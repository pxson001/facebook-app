package com.google.android.gms.internal;

public abstract class zzte<M extends zzte<M>> extends zztk {
    public zztg f6973a = null;

    private M m13004e() {
        zzte com_google_android_gms_internal_zzte = (zzte) super.mo846b();
        if (this.f6973a != null) {
            com_google_android_gms_internal_zzte.f6973a = this.f6973a.m13024c();
        }
        return com_google_android_gms_internal_zzte;
    }

    protected int mo843a() {
        int i = 0;
        if (this.f6973a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f6973a.m13019a()) {
            i2 += this.f6973a.m13022b(i).m13026a();
            i++;
        }
        return i2;
    }

    public void mo845a(zztd com_google_android_gms_internal_zztd) {
        if (this.f6973a != null) {
            for (int i = 0; i < this.f6973a.m13019a(); i++) {
                this.f6973a.m13022b(i).m13027a(com_google_android_gms_internal_zztd);
            }
        }
    }

    protected final boolean m13007a(zztc com_google_android_gms_internal_zztc, int i) {
        int m = com_google_android_gms_internal_zztc.m12954m();
        if (!com_google_android_gms_internal_zztc.m12941b(i)) {
            return false;
        }
        byte[] bArr;
        int i2 = i >>> 3;
        int m2 = com_google_android_gms_internal_zztc.m12954m() - m;
        if (m2 == 0) {
            bArr = zztn.f6996h;
        } else {
            bArr = new byte[m2];
            System.arraycopy(com_google_android_gms_internal_zztc.f6962a, com_google_android_gms_internal_zztc.f6963b + m, bArr, 0, m2);
        }
        zztm com_google_android_gms_internal_zztm = new zztm(i, bArr);
        zzth com_google_android_gms_internal_zzth = null;
        if (this.f6973a == null) {
            this.f6973a = new zztg();
        } else {
            com_google_android_gms_internal_zzth = this.f6973a.m13020a(i2);
        }
        if (com_google_android_gms_internal_zzth == null) {
            com_google_android_gms_internal_zzth = new zzth();
            this.f6973a.m13021a(i2, com_google_android_gms_internal_zzth);
        }
        com_google_android_gms_internal_zzth.f6985c.add(com_google_android_gms_internal_zztm);
        return true;
    }

    public final /* synthetic */ zztk mo846b() {
        return m13004e();
    }

    public /* synthetic */ Object clone() {
        return m13004e();
    }
}
