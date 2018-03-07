package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.zzy.zza;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzt {
    private static zzx f27a;
    private static volatile zzt f28b;
    public final Context f29c;
    public final zzc f30d = new zzc(this);
    private final zzr f31e;
    private final zzo f32f;
    public final zzs f33g;
    private final AppMeasurement f34h;
    private final zzae f35i;
    private final zzd f36j;
    private final zzp f37k;
    public final zznl f38l = zzno.m117c();
    public final zzz f39m;
    private final zzf f40n;
    private final zzy f41o;
    private final zzm f42p;
    private final zzq f43q;
    private final zzab f44r;
    private final boolean f45s;
    private Boolean f46t;
    private List<Long> f47u;
    public int f48v;
    public int f49w;

    class C00071 implements Runnable {
        final /* synthetic */ zzt f275a;

        C00071(zzt com_google_android_gms_measurement_internal_zzt) {
            this.f275a = com_google_android_gms_measurement_internal_zzt;
        }

        public void run() {
            this.f275a.m91c();
        }
    }

    zzt(zzx com_google_android_gms_measurement_internal_zzx) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzx);
        this.f29c = com_google_android_gms_measurement_internal_zzx.f50a;
        zzw com_google_android_gms_measurement_internal_zzr = new zzr(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f31e = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzo(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f32f = com_google_android_gms_measurement_internal_zzr;
        this.f35i = new zzae(this);
        com_google_android_gms_measurement_internal_zzr = new zzf(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f40n = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzm(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f42p = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzd(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f36j = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzp(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f37k = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzz(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f39m = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzy(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f41o = com_google_android_gms_measurement_internal_zzr;
        com_google_android_gms_measurement_internal_zzr = new zzab(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f44r = com_google_android_gms_measurement_internal_zzr;
        this.f43q = new zzq(this);
        this.f34h = new AppMeasurement(this);
        com_google_android_gms_measurement_internal_zzr = new zzs(this);
        com_google_android_gms_measurement_internal_zzr.m304y();
        this.f33g = com_google_android_gms_measurement_internal_zzr;
        if (this.f48v != this.f49w) {
            m93f().f203d.m357a("Not all components initialized", Integer.valueOf(this.f48v), Integer.valueOf(this.f49w));
        }
        this.f45s = true;
        if (!zzd.f66a && null == null) {
            if (!(this.f29c.getApplicationContext() instanceof Application)) {
                m93f().f206h.m355a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                zzv v = m78v();
                if (v.mo32i().getApplicationContext() instanceof Application) {
                    Application application = (Application) v.mo32i().getApplicationContext();
                    if (v.f252a == null) {
                        v.f252a = new zza(v);
                    }
                    application.unregisterActivityLifecycleCallbacks(v.f252a);
                    application.registerActivityLifecycleCallbacks(v.f252a);
                    v.mo35l().f211m.m355a("Registered activity lifecycle callback");
                }
            } else {
                m93f().f210l.m355a("Not tracking deep linking pre-ICS");
            }
        }
        this.f33g.m555a(new C00071(this));
    }

    private boolean m67A() {
        m100o();
        return this.f47u != null;
    }

    private boolean m68B() {
        return !TextUtils.isEmpty(m79w().m431q());
    }

    private void m69C() {
        m100o();
        m83a();
        if (m90b() && m68B()) {
            long D = m70D();
            if (D == 0) {
                m81y().m549b();
                m82z().m531b();
                return;
            } else if (m96j().m462b()) {
                long a = m92e().f153e.m326a();
                long max = Math.max(0, ((Long) zzk.f176i.m314a()).longValue());
                if (!m95i().m369a(a, max)) {
                    D = Math.max(D, a + max);
                }
                m81y().m549b();
                D -= this.f38l.mo11a();
                if (D <= 0) {
                    m82z().m530a(1);
                    return;
                }
                m93f().f211m.m356a("Upload scheduled in approximately ms", Long.valueOf(D));
                m82z().m530a(D);
                return;
            } else {
                m81y().m548a();
                m82z().m531b();
                return;
            }
        }
        m81y().m549b();
        m82z().m531b();
    }

    private long m70D() {
        long a = m98l().mo11a();
        long N = zzc.m129N();
        long L = zzc.m128L();
        long a2 = m92e().f151c.m326a();
        long a3 = m92e().f152d.m326a();
        long s = m79w().m433s();
        if (s == 0) {
            return 0;
        }
        a -= Math.abs(s - a);
        N += a;
        if (!m95i().m369a(a2, L)) {
            N = a2 + L;
        }
        if (a3 == 0 || a3 < a) {
            return N;
        }
        for (int i = 0; i < zzc.m131P(); i++) {
            N += ((long) (1 << i)) * zzc.m130O();
            if (N > a3) {
                return N;
            }
        }
        return 0;
    }

    private zzqq.zzd m71a(zzg[] com_google_android_gms_measurement_internal_zzgArr, AppMetadata appMetadata) {
        int i;
        zzx.m104a((Object) appMetadata);
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzgArr);
        m100o();
        zzqq.zzd com_google_android_gms_internal_zzqq_zzd = new zzqq.zzd();
        com_google_android_gms_internal_zzqq_zzd.a = Integer.valueOf(1);
        com_google_android_gms_internal_zzqq_zzd.j = "android";
        com_google_android_gms_internal_zzqq_zzd.p = appMetadata.b;
        com_google_android_gms_internal_zzqq_zzd.o = appMetadata.e;
        com_google_android_gms_internal_zzqq_zzd.q = appMetadata.d;
        com_google_android_gms_internal_zzqq_zzd.r = Long.valueOf(appMetadata.f);
        com_google_android_gms_internal_zzqq_zzd.z = appMetadata.c;
        com_google_android_gms_internal_zzqq_zzd.w = appMetadata.g == 0 ? null : Long.valueOf(appMetadata.g);
        Pair b = m92e().m297b();
        if (!(b == null || b.first == null || b.second == null)) {
            com_google_android_gms_internal_zzqq_zzd.t = (String) b.first;
            com_google_android_gms_internal_zzqq_zzd.u = (Boolean) b.second;
        }
        com_google_android_gms_internal_zzqq_zzd.l = m80x().m377b();
        com_google_android_gms_internal_zzqq_zzd.k = m80x().m390o();
        com_google_android_gms_internal_zzqq_zzd.n = Integer.valueOf((int) m80x().m391p());
        com_google_android_gms_internal_zzqq_zzd.m = m80x().m392q();
        com_google_android_gms_internal_zzqq_zzd.s = null;
        com_google_android_gms_internal_zzqq_zzd.e = null;
        com_google_android_gms_internal_zzqq_zzd.f = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[0].d);
        com_google_android_gms_internal_zzqq_zzd.g = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[0].d);
        for (int i2 = 1; i2 < com_google_android_gms_measurement_internal_zzgArr.length; i2++) {
            com_google_android_gms_internal_zzqq_zzd.f = Long.valueOf(Math.min(com_google_android_gms_internal_zzqq_zzd.f.longValue(), com_google_android_gms_measurement_internal_zzgArr[i2].d));
            com_google_android_gms_internal_zzqq_zzd.g = Long.valueOf(Math.max(com_google_android_gms_internal_zzqq_zzd.g.longValue(), com_google_android_gms_measurement_internal_zzgArr[i2].d));
        }
        zza b2 = m79w().m426b(appMetadata.b);
        if (b2 == null) {
            String str = appMetadata.b;
            m92e();
            b2 = new zza(str, zzr.m294p(), appMetadata.c, m92e().m298o(), 0, 0, appMetadata.d, appMetadata.e, appMetadata.f, appMetadata.g, appMetadata.i);
        }
        zza a = b2.a(m93f(), com_google_android_gms_internal_zzqq_zzd.g.longValue());
        m79w().m423a(a);
        com_google_android_gms_internal_zzqq_zzd.v = a.b;
        com_google_android_gms_internal_zzqq_zzd.x = Integer.valueOf((int) a.e);
        com_google_android_gms_internal_zzqq_zzd.i = b2.f == 0 ? null : Long.valueOf(b2.f);
        com_google_android_gms_internal_zzqq_zzd.h = com_google_android_gms_internal_zzqq_zzd.i;
        List a2 = m79w().m418a(appMetadata.b);
        com_google_android_gms_internal_zzqq_zzd.d = new zze[a2.size()];
        for (i = 0; i < a2.size(); i++) {
            zze com_google_android_gms_internal_zzqq_zze = new zze();
            com_google_android_gms_internal_zzqq_zzd.d[i] = com_google_android_gms_internal_zzqq_zze;
            com_google_android_gms_internal_zzqq_zze.c = ((zzac) a2.get(i)).b;
            com_google_android_gms_internal_zzqq_zze.a = Long.valueOf(((zzac) a2.get(i)).c);
            m95i().m367a(com_google_android_gms_internal_zzqq_zze, ((zzac) a2.get(i)).d);
        }
        com_google_android_gms_internal_zzqq_zzd.c = new zzqq.zza[com_google_android_gms_measurement_internal_zzgArr.length];
        for (i = 0; i < com_google_android_gms_measurement_internal_zzgArr.length; i++) {
            zzqq.zza com_google_android_gms_internal_zzqq_zza = new zzqq.zza();
            com_google_android_gms_internal_zzqq_zzd.c[i] = com_google_android_gms_internal_zzqq_zza;
            com_google_android_gms_internal_zzqq_zza.c = com_google_android_gms_measurement_internal_zzgArr[i].b;
            com_google_android_gms_internal_zzqq_zza.d = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[i].d);
            com_google_android_gms_internal_zzqq_zza.a = new zzb[com_google_android_gms_measurement_internal_zzgArr[i].f.a()];
            Iterator it = com_google_android_gms_measurement_internal_zzgArr[i].f.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                zzb com_google_android_gms_internal_zzqq_zzb = new zzb();
                int i4 = i3 + 1;
                com_google_android_gms_internal_zzqq_zza.a[i3] = com_google_android_gms_internal_zzqq_zzb;
                com_google_android_gms_internal_zzqq_zzb.a = str2;
                m95i().m366a(com_google_android_gms_internal_zzqq_zzb, com_google_android_gms_measurement_internal_zzgArr[i].f.a(str2));
                i3 = i4;
            }
        }
        com_google_android_gms_internal_zzqq_zzd.y = m93f().m351u();
        return com_google_android_gms_internal_zzqq_zzd;
    }

    public static zzt m72a(Context context) {
        zzx.m104a((Object) context);
        zzx.m104a(context.getApplicationContext());
        if (f28b == null) {
            synchronized (zzt.class) {
                if (f28b == null) {
                    f28b = (f27a != null ? f27a : new zzx(context)).m116a();
                }
            }
        }
        return f28b;
    }

    public static void m73a(zzt com_google_android_gms_measurement_internal_zzt, int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        com_google_android_gms_measurement_internal_zzt.m100o();
        com_google_android_gms_measurement_internal_zzt.m83a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = com_google_android_gms_measurement_internal_zzt.f47u;
        com_google_android_gms_measurement_internal_zzt.f47u = null;
        if ((i == 200 || i == 204) && th == null) {
            com_google_android_gms_measurement_internal_zzt.m92e().f151c.m327a(com_google_android_gms_measurement_internal_zzt.m98l().mo11a());
            com_google_android_gms_measurement_internal_zzt.m92e().f152d.m327a(0);
            com_google_android_gms_measurement_internal_zzt.m69C();
            com_google_android_gms_measurement_internal_zzt.m93f().m350t().m357a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            com_google_android_gms_measurement_internal_zzt.m79w().m427b();
            try {
                for (Long longValue : list) {
                    com_google_android_gms_measurement_internal_zzt.m79w().m421a(longValue.longValue());
                }
                com_google_android_gms_measurement_internal_zzt.m79w().m429o();
                if (com_google_android_gms_measurement_internal_zzt.m96j().m462b() && com_google_android_gms_measurement_internal_zzt.m68B()) {
                    com_google_android_gms_measurement_internal_zzt.m102r();
                } else {
                    com_google_android_gms_measurement_internal_zzt.m69C();
                }
            } finally {
                com_google_android_gms_measurement_internal_zzt.m79w().m430p();
            }
        } else {
            com_google_android_gms_measurement_internal_zzt.m93f().m350t().m357a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            com_google_android_gms_measurement_internal_zzt.m92e().f152d.m327a(com_google_android_gms_measurement_internal_zzt.m98l().mo11a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                com_google_android_gms_measurement_internal_zzt.m92e().f153e.m327a(com_google_android_gms_measurement_internal_zzt.m98l().mo11a());
            }
            com_google_android_gms_measurement_internal_zzt.m69C();
        }
    }

    private static void m74a(zzv com_google_android_gms_measurement_internal_zzv) {
        if (com_google_android_gms_measurement_internal_zzv == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void m75a(zzw com_google_android_gms_measurement_internal_zzw) {
        if (com_google_android_gms_measurement_internal_zzw == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_measurement_internal_zzw.m302v()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void m76a(List<Long> list) {
        zzx.m112b(!list.isEmpty());
        if (this.f47u != null) {
            m93f().f203d.m355a("Set uploading progress before finishing the previous upload");
        } else {
            this.f47u = new ArrayList(list);
        }
    }

    private void m77c(AppMetadata appMetadata) {
        m100o();
        m83a();
        zzx.m104a((Object) appMetadata);
        zzx.m106a(appMetadata.b);
        zza b = m79w().m426b(appMetadata.b);
        String o = m92e().m298o();
        Object obj = null;
        if (b == null) {
            String str = appMetadata.b;
            m92e();
            b = new zza(str, zzr.m294p(), appMetadata.c, o, 0, 0, appMetadata.d, appMetadata.e, appMetadata.f, appMetadata.g, appMetadata.i);
            obj = 1;
        } else if (!o.equals(b.d)) {
            m92e();
            b = b.a(zzr.m294p(), o);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.c) || (appMetadata.c.equals(b.c) && appMetadata.f == b.i))) {
            b = b.a(appMetadata.c, appMetadata.f);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.d) || (appMetadata.d.equals(b.g) && appMetadata.e.equals(b.h)))) {
            b = b.b(appMetadata.d, appMetadata.e);
            obj = 1;
        }
        if (appMetadata.g != b.j) {
            b = b.a(appMetadata.g);
            obj = 1;
        }
        if (appMetadata.i != b.k) {
            b = b.a(appMetadata.i);
            obj = 1;
        }
        if (obj != null) {
            m79w().m423a(b);
        }
    }

    private zzy m78v() {
        m75a(this.f41o);
        return this.f41o;
    }

    private zzd m79w() {
        m75a(this.f36j);
        return this.f36j;
    }

    private zzf m80x() {
        m75a(this.f40n);
        return this.f40n;
    }

    private zzq m81y() {
        if (this.f43q != null) {
            return this.f43q;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private zzab m82z() {
        m75a(this.f44r);
        return this.f44r;
    }

    final void m83a() {
        if (!this.f45s) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    final void m84a(AppMetadata appMetadata) {
        m100o();
        m83a();
        zzx.m106a(appMetadata.b);
        m77c(appMetadata);
    }

    final void m85a(EventParcel eventParcel, AppMetadata appMetadata) {
        m100o();
        m83a();
        zzx.m106a(appMetadata.b);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            m93f().m350t().m356a("Logging event", eventParcel);
            Object com_google_android_gms_measurement_internal_zzg = new zzg(this, eventParcel.d, appMetadata.b, eventParcel.b, eventParcel.e, 0, eventParcel.c.b());
            m79w().m427b();
            try {
                zzh com_google_android_gms_measurement_internal_zzh;
                m77c(appMetadata);
                zzh a = m79w().m417a(appMetadata.b, com_google_android_gms_measurement_internal_zzg.b);
                if (a == null) {
                    com_google_android_gms_measurement_internal_zzh = new zzh(appMetadata.b, com_google_android_gms_measurement_internal_zzg.b, 1, 1, com_google_android_gms_measurement_internal_zzg.d);
                } else {
                    com_google_android_gms_measurement_internal_zzg = com_google_android_gms_measurement_internal_zzg.a(this, a.e);
                    com_google_android_gms_measurement_internal_zzh = a.a(com_google_android_gms_measurement_internal_zzg.d);
                }
                m79w().m425a(com_google_android_gms_measurement_internal_zzh);
                m79w().m422a(m71a(new zzg[]{com_google_android_gms_measurement_internal_zzg}, appMetadata));
                m79w().m429o();
                m93f().m349s().m356a("Event logged", com_google_android_gms_measurement_internal_zzg);
                m69C();
            } finally {
                m79w().m430p();
            }
        }
    }

    final void m86a(EventParcel eventParcel, String str) {
        zza b = m79w().m426b(str);
        if (b == null || TextUtils.isEmpty(b.g)) {
            m93f().f210l.m356a("No app data available; dropping event", str);
            return;
        }
        m85a(eventParcel, new AppMetadata(str, b.c, b.g, b.h, b.i, b.j, null, b.k));
    }

    final void m87a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m100o();
        m83a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            m95i().m368a(userAttributeParcel.b);
            Object c = m95i().m375c(userAttributeParcel.b, userAttributeParcel.a());
            if (c != null) {
                zzac com_google_android_gms_measurement_internal_zzac = new zzac(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, c);
                m93f().m349s().m357a("Setting user attribute", com_google_android_gms_measurement_internal_zzac.b, c);
                m79w().m427b();
                try {
                    m77c(appMetadata);
                    m79w().m424a(com_google_android_gms_measurement_internal_zzac);
                    m79w().m429o();
                    m93f().m349s().m357a("User attribute set", com_google_android_gms_measurement_internal_zzac.b, com_google_android_gms_measurement_internal_zzac.d);
                } finally {
                    m79w().m430p();
                }
            }
        }
    }

    public final void m88b(AppMetadata appMetadata) {
        m100o();
        m83a();
        zzx.m104a((Object) appMetadata);
        zzx.m106a(appMetadata.b);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            m77c(appMetadata);
            if (m79w().m417a(appMetadata.b, "_f") == null) {
                long a = this.f38l.mo11a();
                m87a(new UserAttributeParcel("_fot", a, Long.valueOf(3600000 * ((a / 3600000) + 1)), "auto"), appMetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1);
                m85a(new EventParcel("_f", new EventParams(bundle), "auto", a), appMetadata);
            }
        }
    }

    final void m89b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m100o();
        m83a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            m93f().m349s().m356a("Removing user attribute", userAttributeParcel.b);
            m79w().m427b();
            try {
                m77c(appMetadata);
                m79w().m428b(appMetadata.b, userAttributeParcel.b);
                m79w().m429o();
                m93f().m349s().m356a("User attribute removed", userAttributeParcel.b);
            } finally {
                m79w().m430p();
            }
        }
    }

    public final boolean m90b() {
        boolean z = true;
        m83a();
        m100o();
        if (this.f46t == null) {
            boolean z2 = m95i().m373b("android.permission.INTERNET") && m95i().m373b("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.m544a(this.f29c) && AppMeasurementService.m637a(this.f29c);
            this.f46t = Boolean.valueOf(z2);
            if (this.f46t.booleanValue() && !zzd.f66a) {
                if (TextUtils.isEmpty(m99n().m397b())) {
                    z = false;
                }
                this.f46t = Boolean.valueOf(z);
            }
        }
        return this.f46t.booleanValue();
    }

    protected final void m91c() {
        m100o();
        m93f().f209k.m355a("App measurement is starting up");
        m93f().f210l.m355a("Debug logging enabled");
        if (null == null || (this.f33g.m302v() && !this.f33g.f162c)) {
            m79w().m432r();
            if (!m90b()) {
                if (!m95i().m373b("android.permission.INTERNET")) {
                    m93f().f203d.m355a("App is missing INTERNET permission");
                }
                if (!m95i().m373b("android.permission.ACCESS_NETWORK_STATE")) {
                    m93f().f203d.m355a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!AppMeasurementReceiver.m544a(this.f29c)) {
                    m93f().f203d.m355a("AppMeasurementReceiver not registered/enabled");
                }
                if (!AppMeasurementService.m637a(this.f29c)) {
                    m93f().f203d.m355a("AppMeasurementService not registered/enabled");
                }
                m93f().f203d.m355a("Uploading is not possible. App measurement disabled");
            } else if (!(zzd.f66a || null != null || TextUtils.isEmpty(m99n().m397b()))) {
                zzv v = m78v();
                v.mo28e();
                v.mo26c();
                v.m303x();
                if (v.f54g.m90b()) {
                    v.mo30g().m498o();
                }
            }
            m69C();
            return;
        }
        m93f().f203d.m355a("Scheduler shutting down before Scion.start() called");
    }

    public final zzr m92e() {
        m74a(this.f31e);
        return this.f31e;
    }

    public final zzo m93f() {
        m75a(this.f32f);
        return this.f32f;
    }

    public final zzs m94g() {
        m75a(this.f33g);
        return this.f33g;
    }

    public final zzae m95i() {
        m74a(this.f35i);
        return this.f35i;
    }

    public final zzp m96j() {
        m75a(this.f37k);
        return this.f37k;
    }

    public final Context m97k() {
        return this.f29c;
    }

    public final zznl m98l() {
        return this.f38l;
    }

    public final zzm m99n() {
        m75a(this.f42p);
        return this.f42p;
    }

    public final void m100o() {
        m94g().mo28e();
    }

    final void m101q() {
        if (zzd.f66a) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public final void m102r() {
        int i = 0;
        m100o();
        m83a();
        if (!zzc.m123B()) {
            Boolean q = m92e().m299q();
            if (q == null) {
                m93f().m348o().m355a("Upload data called on the client side before use of service was decided");
                return;
            } else if (q.booleanValue()) {
                m93f().m335b().m355a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m67A()) {
            m93f().m348o().m355a("Uploading requested multiple times");
        } else if (m96j().m462b()) {
            long a = m92e().f151c.m326a();
            if (a != 0) {
                m93f().m349s().m356a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(m98l().mo11a() - a)));
            }
            String q2 = m79w().m431q();
            if (!TextUtils.isEmpty(q2)) {
                List<Pair> a2 = m79w().m419a(q2, zzc.m125H(), zzc.m126I());
                if (!a2.isEmpty()) {
                    zzqq.zzd com_google_android_gms_internal_zzqq_zzd;
                    Object obj;
                    List subList;
                    for (Pair pair : a2) {
                        com_google_android_gms_internal_zzqq_zzd = (zzqq.zzd) pair.first;
                        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzqq_zzd.t)) {
                            obj = com_google_android_gms_internal_zzqq_zzd.t;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        for (int i2 = 0; i2 < a2.size(); i2++) {
                            com_google_android_gms_internal_zzqq_zzd = (zzqq.zzd) ((Pair) a2.get(i2)).first;
                            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzqq_zzd.t) && !com_google_android_gms_internal_zzqq_zzd.t.equals(obj)) {
                                subList = a2.subList(0, i2);
                                break;
                            }
                        }
                    }
                    subList = a2;
                    zzc com_google_android_gms_internal_zzqq_zzc = new zzc();
                    com_google_android_gms_internal_zzqq_zzc.a = new zzqq.zzd[subList.size()];
                    List arrayList = new ArrayList(subList.size());
                    long a3 = m98l().mo11a();
                    while (i < com_google_android_gms_internal_zzqq_zzc.a.length) {
                        com_google_android_gms_internal_zzqq_zzc.a[i] = (zzqq.zzd) ((Pair) subList.get(i)).first;
                        arrayList.add(((Pair) subList.get(i)).second);
                        com_google_android_gms_internal_zzqq_zzc.a[i].s = Long.valueOf(zzc.m122A());
                        com_google_android_gms_internal_zzqq_zzc.a[i].e = Long.valueOf(a3);
                        com_google_android_gms_internal_zzqq_zzc.a[i].A = Boolean.valueOf(zzc.m123B());
                        i++;
                    }
                    byte[] a4 = m95i().m370a(com_google_android_gms_internal_zzqq_zzc);
                    String J = zzc.m127J();
                    try {
                        URL url = new URL(J);
                        m76a(arrayList);
                        m92e().f152d.m327a(m98l().mo11a());
                        m96j().m461a(url, a4, new 2(this));
                    } catch (MalformedURLException e) {
                        m93f().m335b().m356a("Failed to parse upload URL. Not uploading", J);
                    }
                }
            }
        } else {
            m93f().m348o().m355a("Network not connected, ignoring upload request");
            m69C();
        }
    }

    public final void m103s() {
        m69C();
    }
}
