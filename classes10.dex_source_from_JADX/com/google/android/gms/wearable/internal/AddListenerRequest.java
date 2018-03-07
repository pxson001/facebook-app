package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.zzba.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new zzc();
    public final int f13196a;
    public final zzba f13197b;
    public final IntentFilter[] f13198c;
    public final String f13199d;
    public final String f13200e;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.f13196a = i;
        if (iBinder != null) {
            this.f13197b = zza.m13304a(iBinder);
        } else {
            this.f13197b = null;
        }
        this.f13198c = intentFilterArr;
        this.f13199d = str;
        this.f13200e = str2;
    }

    public AddListenerRequest(zzcf com_google_android_gms_wearable_internal_zzcf) {
        this.f13196a = 1;
        this.f13197b = com_google_android_gms_wearable_internal_zzcf;
        this.f13198c = com_google_android_gms_wearable_internal_zzcf.f13425j;
        this.f13199d = com_google_android_gms_wearable_internal_zzcf.f13426k;
        this.f13200e = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13196a);
        zzb.a(parcel, 2, this.f13197b == null ? null : this.f13197b.asBinder(), false);
        zzb.a(parcel, 3, this.f13198c, i, false);
        zzb.a(parcel, 4, this.f13199d, false);
        zzb.a(parcel, 5, this.f13200e, false);
        zzb.c(parcel, a);
    }
}
