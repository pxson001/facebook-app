package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzab();
    public final int f13239a;
    private final String f13240b;
    private final String f13241c;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.f13239a = i;
        this.f13240b = str;
        this.f13241c = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.f13239a = 1;
        this.f13240b = (String) zzx.a(dataItemAsset.mo576b());
        this.f13241c = (String) zzx.a(dataItemAsset.mo577c());
    }

    public final Object m13323a() {
        return this;
    }

    public final String mo576b() {
        return this.f13240b;
    }

    public final String mo577c() {
        return this.f13241c;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.f13240b == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.f13240b);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.f13241c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13239a);
        zzb.a(parcel, 2, mo576b(), false);
        zzb.a(parcel, 3, mo577c(), false);
        zzb.c(parcel, a);
    }
}
