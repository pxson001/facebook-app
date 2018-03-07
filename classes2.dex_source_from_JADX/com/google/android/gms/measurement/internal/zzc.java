package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzny;

public class zzc extends zzv {
    static final String f52a = String.valueOf(GoogleApiAvailability.f55a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean f53b;

    public zzc(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    public static long m122A() {
        return (long) (GoogleApiAvailability.f55a / 1000);
    }

    public static boolean m123B() {
        return zzd.f66a;
    }

    public static long m124D() {
        return ((Long) zzk.f183p.m314a()).longValue();
    }

    public static int m125H() {
        return ((Integer) zzk.f173f.m314a()).intValue();
    }

    public static int m126I() {
        return Math.max(0, ((Integer) zzk.f174g.m314a()).intValue());
    }

    public static String m127J() {
        return (String) zzk.f175h.m314a();
    }

    public static long m128L() {
        return Math.max(0, ((Long) zzk.f178k.m314a()).longValue());
    }

    public static long m129N() {
        return Math.max(0, ((Long) zzk.f180m.m314a()).longValue());
    }

    public static long m130O() {
        return Math.max(0, ((Long) zzk.f181n.m314a()).longValue());
    }

    public static int m131P() {
        return Math.min(20, Math.max(0, ((Integer) zzk.f182o.m314a()).intValue()));
    }

    static int m132s() {
        return 20;
    }

    static long m133t() {
        return 3600000;
    }

    static long m134w() {
        return ((Long) zzk.f171d.m314a()).longValue();
    }

    public final boolean m135C() {
        if (this.f53b == null) {
            synchronized (this) {
                if (this.f53b == null) {
                    ApplicationInfo applicationInfo = mo32i().getApplicationInfo();
                    String a = zzny.m354a(mo32i(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f53b = Boolean.valueOf(z);
                    }
                    if (this.f53b == null) {
                        this.f53b = Boolean.TRUE;
                        mo35l().m335b().m355a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f53b.booleanValue();
    }
}
