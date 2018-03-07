package com.facebook.payments.contactinfo.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: browser_prefetch_load_url_cache_hit */
public class PhoneNumberContactInfoFormInput implements ContactInfoFormInput {
    public static final Creator<PhoneNumberContactInfoFormInput> CREATOR = new C21771();
    public final String f18690a;
    public final boolean f18691b;

    /* compiled from: browser_prefetch_load_url_cache_hit */
    final class C21771 implements Creator<PhoneNumberContactInfoFormInput> {
        C21771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhoneNumberContactInfoFormInput(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhoneNumberContactInfoFormInput[i];
        }
    }

    public static PhoneNumberContactInfoFormInputBuilder newBuilder() {
        return new PhoneNumberContactInfoFormInputBuilder();
    }

    public PhoneNumberContactInfoFormInput(Parcel parcel) {
        this.f18690a = parcel.readString();
        this.f18691b = ParcelUtil.a(parcel);
    }

    public final boolean mo738a() {
        return this.f18691b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18690a);
        ParcelUtil.a(parcel, this.f18691b);
    }
}
