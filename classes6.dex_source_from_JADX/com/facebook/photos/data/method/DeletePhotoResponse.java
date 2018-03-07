package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: ignore_for_webhook */
public class DeletePhotoResponse implements Parcelable {
    public static final Creator<DeletePhotoResponse> CREATOR = new C08311();
    public final boolean f12916a;
    private boolean f12917b;

    /* compiled from: ignore_for_webhook */
    final class C08311 implements Creator<DeletePhotoResponse> {
        C08311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePhotoResponse(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePhotoResponse[i];
        }
    }

    public DeletePhotoResponse(boolean z) {
        this.f12916a = z;
        this.f12917b = false;
    }

    public DeletePhotoResponse(Parcel parcel) {
        this.f12916a = ParcelUtil.a(parcel);
        this.f12917b = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f12916a);
        ParcelUtil.a(parcel, this.f12917b);
    }
}
