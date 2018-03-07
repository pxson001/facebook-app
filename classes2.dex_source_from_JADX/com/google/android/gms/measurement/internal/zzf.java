package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zznl;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzf extends zzw {
    private long f216a;
    private String f217b;

    public zzf(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    protected final void mo24a() {
        Calendar instance = Calendar.getInstance();
        this.f216a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.f217b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public final String m377b() {
        m303x();
        return Build.MODEL;
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

    public final String m390o() {
        m303x();
        return VERSION.RELEASE;
    }

    public final long m391p() {
        m303x();
        return this.f216a;
    }

    public final String m392q() {
        m303x();
        return this.f217b;
    }
}
