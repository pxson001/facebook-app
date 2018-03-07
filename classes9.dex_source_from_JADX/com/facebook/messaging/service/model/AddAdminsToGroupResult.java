package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: create_thread_waiting_for_media_uploads */
public class AddAdminsToGroupResult implements Parcelable {
    private final boolean f17008a;

    public AddAdminsToGroupResult(boolean z) {
        this.f17008a = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f17008a);
    }
}
