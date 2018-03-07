package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmg.zzd;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzlx$zza<R extends Result, A extends zzb> extends zzly<R> implements zzlx$zzb<R>, zzmg$zze<A> {
    private final zzc<A> f6842b;
    private AtomicReference<zzd> f6843c = new AtomicReference();

    protected zzlx$zza(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
        super(((GoogleApiClient) zzx.a(googleApiClient, "GoogleApiClient must not be null")).b());
        this.f6842b = (zzc) zzx.a(com_google_android_gms_common_api_Api_zzc_A);
    }

    private void m12771a(RemoteException remoteException) {
        mo829a(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public final void mo828a(A a) {
        try {
            m12776b(a);
        } catch (RemoteException e) {
            m12771a(e);
            throw e;
        } catch (RemoteException e2) {
            m12771a(e2);
        }
    }

    public final void mo829a(Status status) {
        zzx.b(!status.e(), "Failed result must not be success");
        m12752a(m12756c(status));
    }

    public final void mo830a(zzd com_google_android_gms_internal_zzmg_zzd) {
        this.f6843c.set(com_google_android_gms_internal_zzmg_zzd);
    }

    public final /* synthetic */ void mo831a(Object obj) {
        super.m12752a((Result) obj);
    }

    protected abstract void m12776b(A a);

    public final zzc<A> mo832c() {
        return this.f6842b;
    }

    public final void mo833d() {
        mo826a(null);
    }

    public final int mo834e() {
        return 0;
    }

    protected final void mo835f() {
        zzd com_google_android_gms_internal_zzmg_zzd = (zzd) this.f6843c.getAndSet(null);
        if (com_google_android_gms_internal_zzmg_zzd != null) {
            com_google_android_gms_internal_zzmg_zzd.a(this);
        }
    }
}
