package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.internal.zzx.zza;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzcd$zzq extends zzcd$zzb<DataItemResult> {
    private final List<FutureTask<Boolean>> f13392a;

    zzcd$zzq(zzb<DataItemResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
        super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        this.f13392a = list;
    }

    public final void mo608a(PutDataResponse putDataResponse) {
        m13578a(new zza(zzbz.m13577a(putDataResponse.f13350b), putDataResponse.f13351c));
        if (putDataResponse.f13350b != 0) {
            for (FutureTask cancel : this.f13392a) {
                cancel.cancel(true);
            }
        }
    }
}
