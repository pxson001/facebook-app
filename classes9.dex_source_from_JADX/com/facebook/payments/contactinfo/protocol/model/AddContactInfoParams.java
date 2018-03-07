package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bottom_sheet_item_clicked */
public abstract class AddContactInfoParams implements Parcelable {
    public final boolean f18698a;

    /* compiled from: bottom_sheet_item_clicked */
    public abstract class Builder<BUILDER extends Builder> {
        public boolean f18697a;
    }

    protected AddContactInfoParams(Builder builder) {
        this.f18698a = builder.f18697a;
    }

    protected AddContactInfoParams(Parcel parcel) {
        this.f18698a = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18698a);
    }
}
