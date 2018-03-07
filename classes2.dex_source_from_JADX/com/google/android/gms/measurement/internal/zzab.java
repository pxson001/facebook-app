package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public class zzab extends zzw {
    private boolean f253a;
    private final AlarmManager f254b = ((AlarmManager) mo32i().getSystemService("alarm"));

    public zzab(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private PendingIntent m528o() {
        Intent intent = new Intent(mo32i(), AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo32i(), 0, intent, 0);
    }

    protected final void mo24a() {
        this.f254b.cancel(m528o());
    }

    public final void m530a(long j) {
        m303x();
        zzx.m112b(j > 0);
        zzx.m109a(AppMeasurementReceiver.m544a(mo32i()), (Object) "Receiver not registered/enabled");
        zzx.m109a(AppMeasurementService.m637a(mo32i()), (Object) "Service not registered/enabled");
        m531b();
        long b = mo31h().mo12b() + j;
        this.f253a = true;
        this.f254b.setInexactRepeating(2, b, Math.max(((Long) zzk.f177j.m314a()).longValue(), j), m528o());
    }

    public final void m531b() {
        m303x();
        this.f253a = false;
        this.f254b.cancel(m528o());
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
}
