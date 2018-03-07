package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurement;

public class zzo extends zzw {
    public final String f200a = ((String) zzk.f170c.m314a());
    private final char f201b;
    private final long f202c = zzc.m122A();
    public final zza f203d;
    private final zza f204e;
    private final zza f205f;
    public final zza f206h;
    public final zza f207i;
    public final zza f208j;
    public final zza f209k;
    public final zza f210l;
    public final zza f211m;

    public class zza {
        final /* synthetic */ zzo f212a;
        private final int f213b;
        private final boolean f214c;
        private final boolean f215d;

        zza(zzo com_google_android_gms_measurement_internal_zzo, int i, boolean z, boolean z2) {
            this.f212a = com_google_android_gms_measurement_internal_zzo;
            this.f213b = i;
            this.f214c = z;
            this.f215d = z2;
        }

        public final void m355a(String str) {
            this.f212a.m334a(this.f213b, this.f214c, this.f215d, str, null, null, null);
        }

        public final void m356a(String str, Object obj) {
            this.f212a.m334a(this.f213b, this.f214c, this.f215d, str, obj, null, null);
        }

        public final void m357a(String str, Object obj, Object obj2) {
            this.f212a.m334a(this.f213b, this.f214c, this.f215d, str, obj, obj2, null);
        }

        public final void m358a(String str, Object obj, Object obj2, Object obj3) {
            this.f212a.m334a(this.f213b, this.f214c, this.f215d, str, obj, obj2, obj3);
        }
    }

    public zzo(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
        if (mo37n().m135C()) {
            this.f201b = zzd.f66a ? 'P' : 'C';
        } else {
            this.f201b = zzd.f66a ? 'p' : 'c';
        }
        this.f203d = new zza(this, 6, false, false);
        this.f204e = new zza(this, 6, true, false);
        this.f205f = new zza(this, 6, false, true);
        this.f206h = new zza(this, 5, false, false);
        this.f207i = new zza(this, 5, true, false);
        this.f208j = new zza(this, 5, false, true);
        this.f209k = new zza(this, 4, false, false);
        this.f210l = new zza(this, 3, false, false);
        this.f211m = new zza(this, 2, false, false);
    }

    private static String m328a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    private static String m329a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d);
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(th.toString());
                String a = m328a(AppMeasurement.class.getCanonicalName());
                String a2 = m328a(zzt.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m328a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    private static String m330a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m329a(z, obj);
        Object a2 = m329a(z, obj2);
        Object a3 = m329a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    private void m331a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzx.m104a((Object) str);
        zzw com_google_android_gms_measurement_internal_zzw = this.f54g.f33g;
        if (com_google_android_gms_measurement_internal_zzw == null || !com_google_android_gms_measurement_internal_zzw.m302v() || com_google_android_gms_measurement_internal_zzw.f162c) {
            m333a(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
            return;
        }
        int i2 = i < 0 ? 0 : i;
        if (i2 >= 9) {
            i2 = 8;
        }
        String str2 = "1" + "01VDIWEA?".charAt(i2) + this.f201b + this.f202c + ":" + m330a(true, str, obj, obj2, obj3);
        if (str2.length() > 1024) {
            str2 = str.substring(0, 1024);
        }
        com_google_android_gms_measurement_internal_zzw.m555a(new Runnable(this) {
            final /* synthetic */ zzo f379b;

            public void run() {
                zzw e = this.f379b.f54g.m92e();
                if (!e.m302v() || e.f162c) {
                    this.f379b.m333a(6, "Persisted config not initialized . Not logging error/warn.");
                } else {
                    e.f150b.m309a(str2, 1);
                }
            }
        });
    }

    protected final void mo24a() {
    }

    protected final void m333a(int i, String str) {
        Log.println(i, this.f200a, str);
    }

    protected final void m334a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(this.f200a, i)) {
            m333a(i, m330a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m331a(i, str, obj, obj2, obj3);
        }
    }

    public final zza m335b() {
        return this.f203d;
    }

    public final /* bridge */ /* synthetic */ void mo26c() {
        super.mo26c();
    }

    public final /* bridge */ /* synthetic */ void mo27d() {
        super.mo27d();
    }

    public final /* bridge */ /* synthetic */ void mo28e() {
        super.mo28e();
    }

    public final /* bridge */ /* synthetic */ zzm mo29f() {
        return super.mo29f();
    }

    public final /* bridge */ /* synthetic */ zzz mo30g() {
        return super.mo30g();
    }

    public final /* bridge */ /* synthetic */ zznl mo31h() {
        return super.mo31h();
    }

    public final /* bridge */ /* synthetic */ Context mo32i() {
        return super.mo32i();
    }

    public final /* bridge */ /* synthetic */ zzae mo33j() {
        return super.mo33j();
    }

    public final /* bridge */ /* synthetic */ zzs mo34k() {
        return super.mo34k();
    }

    public final /* bridge */ /* synthetic */ zzo mo35l() {
        return super.mo35l();
    }

    public final /* bridge */ /* synthetic */ zzr mo36m() {
        return super.mo36m();
    }

    public final /* bridge */ /* synthetic */ zzc mo37n() {
        return super.mo37n();
    }

    public final zza m348o() {
        return this.f206h;
    }

    public final zza m349s() {
        return this.f210l;
    }

    public final zza m350t() {
        return this.f211m;
    }

    public final String m351u() {
        Pair a = mo36m().f150b.m308a();
        return a == null ? null : String.valueOf(a.second) + ":" + ((String) a.first);
    }
}
