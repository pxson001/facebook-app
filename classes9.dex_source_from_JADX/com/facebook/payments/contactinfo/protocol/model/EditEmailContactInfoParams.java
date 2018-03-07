package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: boosted_website_mobile */
public class EditEmailContactInfoParams extends EditContactInfoParams {
    public static final Creator<EditEmailContactInfoParams> CREATOR = new C21811();
    public static final String f18711d = EditEmailContactInfoParams.class.getSimpleName();
    public final String f18712e;

    /* compiled from: boosted_website_mobile */
    final class C21811 implements Creator<EditEmailContactInfoParams> {
        C21811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditEmailContactInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditEmailContactInfoParams[i];
        }
    }

    /* compiled from: boosted_website_mobile */
    public class Builder extends com.facebook.payments.contactinfo.protocol.model.EditContactInfoParams.Builder<Builder> {
        public String f18710a;
    }

    public EditEmailContactInfoParams(Builder builder) {
        super((com.facebook.payments.contactinfo.protocol.model.EditContactInfoParams.Builder) builder);
        this.f18712e = builder.f18710a;
    }

    public EditEmailContactInfoParams(Parcel parcel) {
        super(parcel);
        this.f18712e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f18712e);
    }
}
