package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.zzba.zza;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new zzbv();
    public final int f13355a;
    public final zzba f13356b;

    RemoveListenerRequest(int i, IBinder iBinder) {
        this.f13355a = i;
        if (iBinder != null) {
            this.f13356b = zza.m13304a(iBinder);
        } else {
            this.f13356b = null;
        }
    }

    public RemoveListenerRequest(zzba com_google_android_gms_wearable_internal_zzba) {
        this.f13355a = 1;
        this.f13356b = com_google_android_gms_wearable_internal_zzba;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13355a);
        zzb.a(parcel, 2, this.f13356b == null ? null : this.f13356b.asBinder(), false);
        zzb.c(parcel, a);
    }
}
