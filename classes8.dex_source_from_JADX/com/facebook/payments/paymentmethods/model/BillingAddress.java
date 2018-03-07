package com.facebook.payments.paymentmethods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.infer.annotation.PrivacySource;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: supportedMediaCommands */
public class BillingAddress implements Parcelable {
    public static final Creator<BillingAddress> CREATOR = new C02171();
    @PrivacySource
    public final String f1942a;
    @PrivacySource
    private final Country f1943b;

    /* compiled from: supportedMediaCommands */
    final class C02171 implements Creator<BillingAddress> {
        C02171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BillingAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new BillingAddress[i];
        }
    }

    public BillingAddress() {
        this.f1942a = null;
        this.f1943b = null;
    }

    public BillingAddress(String str, @Nullable Country country) {
        this.f1942a = str;
        this.f1943b = country;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BillingAddress billingAddress = (BillingAddress) obj;
        if (Objects.equal(this.f1942a, billingAddress.f1942a) && Objects.equal(this.f1943b, billingAddress.f1943b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1942a, this.f1943b});
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("zip", this.f1942a).add("country", this.f1943b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1942a);
        parcel.writeParcelable(this.f1943b, i);
    }

    public BillingAddress(Parcel parcel) {
        this.f1942a = parcel.readString();
        this.f1943b = (Country) parcel.readParcelable(Country.class.getClassLoader());
    }
}
