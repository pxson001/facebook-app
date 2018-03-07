package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzbc;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.internal.zzcb;
import com.google.android.gms.wearable.internal.zzce;
import com.google.android.gms.wearable.internal.zzcg;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable {
    public static final DataApi f13157a = new zzx();
    public static final CapabilityApi f13158b = new zzj();
    public static final MessageApi f13159c = new zzbm();
    public static final NodeApi f13160d = new zzbo();
    public static final ChannelApi f13161e = new zzl();
    public static final LargeAssetApi f13162f = new zzbc();
    public static final zzc f13163g = new zzg();
    public static final zza f13164h = new zze();
    public static final zzf f13165i = new zzw();
    public static final zzj f13166j = new zzcb();
    public static final zzl f13167k = new zzcg();
    public static final zzc<zzce> f13168l = new zzc();
    public static final Api<WearableOptions> f13169m = new Api("Wearable.API", f13170n, f13168l);
    private static final zza<zzce, WearableOptions> f13170n = new C18281();

    final class C18281 extends zza<zzce, WearableOptions> {
        C18281() {
        }

        private static zzce m13290a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                Builder builder = new Builder();
                WearableOptions wearableOptions2 = new WearableOptions();
            }
            return new zzce(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    public final class WearableOptions implements Optional {

        public class Builder {
        }
    }

    private Wearable() {
    }
}
