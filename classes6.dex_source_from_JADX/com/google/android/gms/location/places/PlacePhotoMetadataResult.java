package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
    public final int f6449a;
    public final DataHolder f6450b;
    private final Status f6451c;
    private final PlacePhotoMetadataBuffer f6452d;

    PlacePhotoMetadataResult(int i, Status status, DataHolder dataHolder) {
        this.f6449a = i;
        this.f6451c = status;
        this.f6450b = dataHolder;
        if (dataHolder == null) {
            this.f6452d = null;
        } else {
            this.f6452d = new PlacePhotoMetadataBuffer(this.f6450b);
        }
    }

    public final Status cp_() {
        return this.f6451c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, cp_(), i, false);
        zzb.a(parcel, 1000, this.f6449a);
        zzb.a(parcel, 2, this.f6450b, i, false);
        zzb.c(parcel, a);
    }
}
