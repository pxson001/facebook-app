package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

public class zzy extends zzw {
    public zza f252a;

    public class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzy f274a;

        public zza(zzy com_google_android_gms_measurement_internal_zzy) {
            this.f274a = com_google_android_gms_measurement_internal_zzy;
        }

        private boolean m569a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzv com_google_android_gms_measurement_internal_zzv = this.f274a;
            String str2 = "auto";
            String str3 = "_ldl";
            zzx.m106a(str2);
            long a = com_google_android_gms_measurement_internal_zzv.mo31h().mo11a();
            com_google_android_gms_measurement_internal_zzv.mo33j().m368a(str3);
            if (str != null) {
                com_google_android_gms_measurement_internal_zzv.mo33j().m372b(str3, str);
                Object c = com_google_android_gms_measurement_internal_zzv.mo33j().m375c(str3, str);
                if (c != null) {
                    com_google_android_gms_measurement_internal_zzv.mo34k().m555a(new 3(com_google_android_gms_measurement_internal_zzv, str2, str3, c, a));
                }
            } else {
                com_google_android_gms_measurement_internal_zzv.mo34k().m555a(new 4(com_google_android_gms_measurement_internal_zzv, str2, str3, a));
            }
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.f274a.mo35l().m350t().m355a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.f274a.mo35l().m349s().m356a("Activity created with referrer", queryParameter);
                                m569a(queryParameter);
                                return;
                            }
                            this.f274a.mo35l().m349s().m355a("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.f274a.mo35l().m335b().m356a("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public zzy(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private void m514a(String str, String str2, Object obj, long j) {
        zzx.m106a(str);
        zzx.m106a(str2);
        mo28e();
        mo26c();
        m303x();
        if (!mo36m().m300r()) {
            mo35l().f209k.m355a("User attribute not set since app measurement is disabled");
        } else if (this.f54g.m90b()) {
            mo35l().f210l.m357a("Setting user attribute (FE)", str2, obj);
            mo30g().m484a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    protected final void mo24a() {
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
