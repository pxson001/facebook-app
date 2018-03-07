package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: contacts_ccu_upload/ */
public class RemoveAdminsFromGroupResult implements Parcelable {
    private final boolean f17275a;

    public RemoveAdminsFromGroupResult(boolean z) {
        this.f17275a = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f17275a);
    }
}
