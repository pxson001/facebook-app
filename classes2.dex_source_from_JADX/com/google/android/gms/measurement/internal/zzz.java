package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.List;

public class zzz extends zzw {
    public final zza f234a;
    public zzl f235b;
    private Boolean f236c;
    private final zze f237d;
    private final zzaa f238e;
    public final List<Runnable> f239f = new ArrayList();
    public final zze f240h;

    public class zza implements ServiceConnection, ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzz f241a;
        private volatile boolean f242b;
        private volatile zzn f243c;

        protected zza(zzz com_google_android_gms_measurement_internal_zzz) {
            this.f241a = com_google_android_gms_measurement_internal_zzz;
        }

        public final void m499a() {
            this.f241a.mo28e();
            Context i = this.f241a.mo32i();
            synchronized (this) {
                if (this.f242b) {
                    this.f241a.mo35l().m350t().m355a("Connection attempt already in progress");
                } else if (this.f243c != null) {
                    this.f241a.mo35l().m350t().m355a("Already awaiting connection attempt");
                } else {
                    this.f243c = new zzn(i, Looper.getMainLooper(), zzf.m25412a(i), this, this);
                    this.f241a.mo35l().m350t().m355a("Connecting to remote service");
                    this.f242b = true;
                    this.f243c.p_();
                }
            }
        }

        public final void mo38a(int i) {
            zzx.m111b("MeasurementServiceConnection.onConnectionSuspended");
            this.f241a.mo35l().f210l.m355a("Service connection suspended");
            this.f241a.mo34k().m555a(new 4(this));
        }

        public final void m501a(Intent intent) {
            this.f241a.mo28e();
            Context i = this.f241a.mo32i();
            zzb a = zzb.m26500a();
            synchronized (this) {
                if (this.f242b) {
                    this.f241a.mo35l().m350t().m355a("Connection attempt already in progress");
                    return;
                }
                this.f242b = true;
                a.m26509a(i, intent, this.f241a.f234a, 129);
            }
        }

        public final void mo39a(Bundle bundle) {
            zzx.m111b("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                this.f242b = false;
                try {
                    zzl com_google_android_gms_measurement_internal_zzl = (zzl) this.f243c.m26418q();
                    this.f243c = null;
                    this.f241a.mo34k().m555a(new 3(this, com_google_android_gms_measurement_internal_zzl));
                } catch (DeadObjectException e) {
                    this.f243c = null;
                } catch (IllegalStateException e2) {
                    this.f243c = null;
                }
            }
        }

        public final void mo40a(ConnectionResult connectionResult) {
            zzx.m111b("MeasurementServiceConnection.onConnectionFailed");
            this.f241a.mo35l().m348o().m356a("Service connection failed", connectionResult);
            synchronized (this) {
                this.f242b = false;
                this.f243c = null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzx.m111b("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                this.f242b = false;
                if (iBinder == null) {
                    this.f241a.mo35l().m335b().m355a("Service connected with null binder");
                    return;
                }
                zzl com_google_android_gms_measurement_internal_zzl = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        com_google_android_gms_measurement_internal_zzl = com.google.android.gms.measurement.internal.zzl.zza.a(iBinder);
                        this.f241a.mo35l().m350t().m355a("Bound to IMeasurementService interface");
                    } else {
                        this.f241a.mo35l().m335b().m356a("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.f241a.mo35l().m335b().m355a("Service connect failed to get IMeasurementService");
                }
                if (com_google_android_gms_measurement_internal_zzl == null) {
                    try {
                        zzb.m26500a().m26507a(this.f241a.mo32i(), this.f241a.f234a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.f241a.mo34k().m555a(new 1(this, com_google_android_gms_measurement_internal_zzl));
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            zzx.m111b("MeasurementServiceConnection.onServiceDisconnected");
            this.f241a.mo35l().f210l.m355a("Service disconnected");
            this.f241a.mo34k().m555a(new 2(this, componentName));
        }
    }

    public zzz(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
        this.f238e = new zzaa(com_google_android_gms_measurement_internal_zzt.f38l);
        this.f234a = new zza(this);
        this.f237d = new zze(this, com_google_android_gms_measurement_internal_zzt) {
            final /* synthetic */ zzz f244a;

            public final void mo41a() {
                zzz.m481u(this.f244a);
            }
        };
        this.f240h = new zze(this, com_google_android_gms_measurement_internal_zzt) {
            final /* synthetic */ zzz f251a;

            public final void mo41a() {
                this.f251a.mo35l().f206h.m355a("Tasks have been queued for a long time");
            }
        };
    }

    public static void m475a(zzz com_google_android_gms_measurement_internal_zzz, ComponentName componentName) {
        com_google_android_gms_measurement_internal_zzz.mo28e();
        if (com_google_android_gms_measurement_internal_zzz.f235b != null) {
            com_google_android_gms_measurement_internal_zzz.f235b = null;
            com_google_android_gms_measurement_internal_zzz.mo35l().f211m.m356a("Disconnected from device MeasurementService", componentName);
            com_google_android_gms_measurement_internal_zzz.m482z();
        }
    }

    public static void m476a(zzz com_google_android_gms_measurement_internal_zzz, zzl com_google_android_gms_measurement_internal_zzl) {
        com_google_android_gms_measurement_internal_zzz.mo28e();
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzl);
        com_google_android_gms_measurement_internal_zzz.f235b = com_google_android_gms_measurement_internal_zzl;
        m478p(com_google_android_gms_measurement_internal_zzz);
        com_google_android_gms_measurement_internal_zzz.mo28e();
        com_google_android_gms_measurement_internal_zzz.mo35l().f211m.m356a("Processing queued up service tasks", Integer.valueOf(com_google_android_gms_measurement_internal_zzz.f239f.size()));
        for (Runnable a : com_google_android_gms_measurement_internal_zzz.f239f) {
            com_google_android_gms_measurement_internal_zzz.mo34k().m555a(a);
        }
        com_google_android_gms_measurement_internal_zzz.f239f.clear();
        com_google_android_gms_measurement_internal_zzz.f240h.m511c();
    }

    private void m477a(Runnable runnable) {
        mo28e();
        if (m485b()) {
            runnable.run();
        } else if (((long) this.f239f.size()) >= 20) {
            mo35l().f203d.m355a("Discarding data. Max runnable queue size reached");
        } else {
            this.f239f.add(runnable);
            if (null == null) {
                this.f240h.m510a(60000);
            }
            m479q();
        }
    }

    public static void m478p(zzz com_google_android_gms_measurement_internal_zzz) {
        com_google_android_gms_measurement_internal_zzz.mo28e();
        com_google_android_gms_measurement_internal_zzz.f238e.m450a();
        if (null == null) {
            com_google_android_gms_measurement_internal_zzz.f237d.m510a(((Long) zzk.f184q.m314a()).longValue());
        }
    }

    private void m479q() {
        mo28e();
        m303x();
        if (!m485b()) {
            if (this.f236c == null) {
                this.f236c = mo36m().m299q();
                if (this.f236c == null) {
                    mo35l().f211m.m355a("State of service unknown");
                    boolean z = true;
                    mo28e();
                    m303x();
                    if (!zzd.f66a) {
                        Intent intent = new Intent("com.google.android.gms.measurement.START");
                        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
                        zzb a = zzb.m26500a();
                        mo35l().f211m.m355a("Checking service availability");
                        if (a.m26509a(mo32i(), intent, new 7(this), 0)) {
                            mo35l().f211m.m355a("Service available");
                        } else {
                            z = false;
                        }
                    }
                    this.f236c = Boolean.valueOf(z);
                    zzv m = mo36m();
                    boolean booleanValue = this.f236c.booleanValue();
                    m.mo28e();
                    m.mo35l().f211m.m356a("Setting useService", Boolean.valueOf(booleanValue));
                    Editor edit = zzr.m295s(m).edit();
                    edit.putBoolean("use_service", booleanValue);
                    edit.apply();
                }
            }
            if (this.f236c.booleanValue()) {
                mo35l().f211m.m355a("Using measurement service");
                this.f234a.m499a();
                return;
            }
            List queryIntentServices = mo32i().getPackageManager().queryIntentServices(new Intent(mo32i(), AppMeasurementService.class), 65536);
            Object obj = (queryIntentServices == null || queryIntentServices.size() <= 0) ? null : 1;
            if (obj != null && null == null) {
                mo35l().f211m.m355a("Using local app measurement service");
                Intent intent2 = new Intent("com.google.android.gms.measurement.START");
                intent2.setComponent(new ComponentName(mo32i(), AppMeasurementService.class));
                this.f234a.m501a(intent2);
            } else if (mo37n().m135C()) {
                mo35l().f211m.m355a("Using direct local measurement implementation");
                m476a(this, new zzu(this.f54g, true));
            } else {
                mo35l().f203d.m355a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    private void m480t() {
        mo28e();
        m303x();
        try {
            zzb.m26500a().m26507a(mo32i(), this.f234a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f235b = null;
    }

    public static void m481u(zzz com_google_android_gms_measurement_internal_zzz) {
        com_google_android_gms_measurement_internal_zzz.mo28e();
        if (com_google_android_gms_measurement_internal_zzz.m485b()) {
            com_google_android_gms_measurement_internal_zzz.mo35l().f211m.m355a("Inactivity, disconnecting from AppMeasurementService");
            com_google_android_gms_measurement_internal_zzz.m480t();
        }
    }

    private void m482z() {
        mo28e();
        m479q();
    }

    protected final void mo24a() {
    }

    protected final void m484a(UserAttributeParcel userAttributeParcel) {
        mo28e();
        m303x();
        m477a(new 5(this, userAttributeParcel));
    }

    public final boolean m485b() {
        mo28e();
        m303x();
        return this.f235b != null;
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

    public final void m498o() {
        mo28e();
        m303x();
        m477a(new 6(this));
    }
}
