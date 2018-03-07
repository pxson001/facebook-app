package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: boosted_website_promotions */
public abstract class EditContactInfoParams implements Parcelable {
    public final String f18707a;
    public final boolean f18708b;
    public final boolean f18709c;

    /* compiled from: boosted_website_promotions */
    public abstract class Builder<BUILDER extends Builder> {
        public String f18704a;
        public boolean f18705b;
        public boolean f18706c;
    }

    protected EditContactInfoParams(Builder builder) {
        boolean z;
        if (builder.f18705b && builder.f18706c) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f18707a = (String) Preconditions.checkNotNull(builder.f18704a);
        this.f18708b = builder.f18705b;
        this.f18709c = builder.f18706c;
    }

    protected EditContactInfoParams(Parcel parcel) {
        this.f18707a = parcel.readString();
        this.f18708b = ParcelUtil.a(parcel);
        this.f18709c = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18707a);
        ParcelUtil.a(parcel, this.f18708b);
        ParcelUtil.a(parcel, this.f18709c);
    }
}
