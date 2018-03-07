package com.facebook.payments.shipping.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_onboarding_complete */
public class SimpleShippingOption implements ShippingOption {
    public static final Creator<SimpleShippingOption> CREATOR = new C22381();
    private final String f19023a;
    private final String f19024b;

    /* compiled from: backstage_onboarding_complete */
    final class C22381 implements Creator<SimpleShippingOption> {
        C22381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleShippingOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleShippingOption[i];
        }
    }

    public static SimpleShippingOptionBuilder newBuilder() {
        return new SimpleShippingOptionBuilder();
    }

    public SimpleShippingOption(Parcel parcel) {
        this.f19023a = parcel.readString();
        this.f19024b = parcel.readString();
    }

    public final String mo646a() {
        return this.f19023a;
    }

    public final String mo647b() {
        return this.f19024b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19023a);
        parcel.writeString(this.f19024b);
    }
}
