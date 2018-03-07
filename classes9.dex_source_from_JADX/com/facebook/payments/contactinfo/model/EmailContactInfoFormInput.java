package com.facebook.payments.contactinfo.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bssids */
public class EmailContactInfoFormInput implements ContactInfoFormInput {
    public static final Creator<EmailContactInfoFormInput> CREATOR = new C21751();
    public final String f18683a;
    public final boolean f18684b;

    /* compiled from: bssids */
    final class C21751 implements Creator<EmailContactInfoFormInput> {
        C21751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EmailContactInfoFormInput(parcel);
        }

        public final Object[] newArray(int i) {
            return new EmailContactInfoFormInput[i];
        }
    }

    public EmailContactInfoFormInput(EmailContactInfoFormInputBuilder emailContactInfoFormInputBuilder) {
        this.f18683a = emailContactInfoFormInputBuilder.f18685a;
        this.f18684b = emailContactInfoFormInputBuilder.f18686b;
    }

    public EmailContactInfoFormInput(Parcel parcel) {
        this.f18683a = parcel.readString();
        this.f18684b = ParcelUtil.a(parcel);
    }

    public final boolean mo738a() {
        return this.f18684b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18683a);
        ParcelUtil.a(parcel, this.f18684b);
    }
}
