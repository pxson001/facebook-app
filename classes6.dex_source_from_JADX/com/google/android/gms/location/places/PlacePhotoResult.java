package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoResult> CREATOR = new zzi();
    public final int f6453a;
    public final BitmapTeleporter f6454b;
    private final Status f6455c;
    private final Bitmap f6456d;

    PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapTeleporter) {
        this.f6453a = i;
        this.f6455c = status;
        this.f6454b = bitmapTeleporter;
        if (this.f6454b != null) {
            this.f6456d = bitmapTeleporter.a();
        } else {
            this.f6456d = null;
        }
    }

    public final Status cp_() {
        return this.f6455c;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return zzw.a(this).a("status", this.f6455c).a("bitmap", this.f6456d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, cp_(), i, false);
        zzb.a(parcel, 1000, this.f6453a);
        zzb.a(parcel, 2, this.f6454b, i, false);
        zzb.c(parcel, a);
    }
}
