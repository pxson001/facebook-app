package com.facebook.payments.contactinfo.protocol.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bot_participants */
public class AddPhoneNumberContactInfoParams extends AddContactInfoParams {
    public static final Creator<AddPhoneNumberContactInfoParams> CREATOR = new C21791();
    public final String f18702b;

    /* compiled from: bot_participants */
    final class C21791 implements Creator<AddPhoneNumberContactInfoParams> {
        C21791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPhoneNumberContactInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPhoneNumberContactInfoParams[i];
        }
    }

    /* compiled from: bot_participants */
    public class Builder extends com.facebook.payments.contactinfo.protocol.model.AddContactInfoParams.Builder<Builder> {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public AddPhoneNumberContactInfoParams(Parcel parcel) {
        super(parcel);
        this.f18702b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f18702b);
    }
}
