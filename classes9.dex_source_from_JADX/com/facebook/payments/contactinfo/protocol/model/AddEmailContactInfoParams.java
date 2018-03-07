package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bot_subscriptions */
public class AddEmailContactInfoParams extends AddContactInfoParams {
    public static final Creator<AddEmailContactInfoParams> CREATOR = new C21781();
    public static final String f18700b = AddEmailContactInfoParams.class.getSimpleName();
    public final String f18701c;

    /* compiled from: bot_subscriptions */
    final class C21781 implements Creator<AddEmailContactInfoParams> {
        C21781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddEmailContactInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddEmailContactInfoParams[i];
        }
    }

    /* compiled from: bot_subscriptions */
    public class Builder extends com.facebook.payments.contactinfo.protocol.model.AddContactInfoParams.Builder<Builder> {
        public String f18699a;
    }

    public AddEmailContactInfoParams(Builder builder) {
        super((com.facebook.payments.contactinfo.protocol.model.AddContactInfoParams.Builder) builder);
        this.f18701c = builder.f18699a;
    }

    public AddEmailContactInfoParams(Parcel parcel) {
        super(parcel);
        this.f18701c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f18701c);
    }
}
