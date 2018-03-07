package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.internal.zzi.zza.zza;

public class zzb extends zzj<zzi> {
    protected final zzp<zzi> f18778d = new C07511(this);
    private final String f18779e;

    class C07511 implements zzp<zzi> {
        final /* synthetic */ zzb f18924a;

        C07511(zzb com_google_android_gms_location_internal_zzb) {
            this.f18924a = com_google_android_gms_location_internal_zzb;
        }

        public final void mo3043a() {
            this.f18924a.m26416o();
        }

        public final IInterface mo3044b() {
            return (zzi) this.f18924a.m26418q();
        }
    }

    public zzb(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 23, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.f18779e = str;
    }

    protected final IInterface mo3024a(IBinder iBinder) {
        zzi com_google_android_gms_location_internal_zzi;
        if (iBinder == null) {
            com_google_android_gms_location_internal_zzi = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            com_google_android_gms_location_internal_zzi = (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zza(iBinder) : (zzi) queryLocalInterface;
        }
        return com_google_android_gms_location_internal_zzi;
    }

    protected final String mo3025g() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String mo3026h() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected final Bundle mo3027n() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f18779e);
        return bundle;
    }
}
