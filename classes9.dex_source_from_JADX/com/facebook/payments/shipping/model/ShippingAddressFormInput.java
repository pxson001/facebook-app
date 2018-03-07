package com.facebook.payments.shipping.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_save_shot */
public class ShippingAddressFormInput implements Parcelable {
    public static final Creator<ShippingAddressFormInput> CREATOR = new C22351();
    public final String f18963a;
    public final String f18964b;
    public final String f18965c;
    @Nullable
    public final String f18966d;
    public final String f18967e;
    public final String f18968f;
    public final String f18969g;
    public final Country f18970h;
    public final boolean f18971i;

    /* compiled from: backstage_save_shot */
    final class C22351 implements Creator<ShippingAddressFormInput> {
        C22351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingAddressFormInput(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingAddressFormInput[i];
        }
    }

    public ShippingAddressFormInput(ShippingAddressFormInputBuilder shippingAddressFormInputBuilder) {
        this.f18963a = shippingAddressFormInputBuilder.f18972a;
        this.f18964b = shippingAddressFormInputBuilder.f18973b;
        this.f18965c = shippingAddressFormInputBuilder.f18974c;
        this.f18966d = shippingAddressFormInputBuilder.f18975d;
        this.f18967e = shippingAddressFormInputBuilder.f18976e;
        this.f18968f = shippingAddressFormInputBuilder.f18977f;
        this.f18969g = shippingAddressFormInputBuilder.f18978g;
        this.f18970h = shippingAddressFormInputBuilder.f18979h;
        this.f18971i = shippingAddressFormInputBuilder.f18980i;
    }

    public ShippingAddressFormInput(Parcel parcel) {
        this.f18963a = parcel.readString();
        this.f18964b = parcel.readString();
        this.f18965c = parcel.readString();
        this.f18966d = parcel.readString();
        this.f18967e = parcel.readString();
        this.f18968f = parcel.readString();
        this.f18969g = parcel.readString();
        this.f18970h = (Country) parcel.readParcelable(Country.class.getClassLoader());
        this.f18971i = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18963a);
        parcel.writeString(this.f18964b);
        parcel.writeString(this.f18965c);
        parcel.writeString(this.f18966d);
        parcel.writeString(this.f18967e);
        parcel.writeString(this.f18968f);
        parcel.writeString(this.f18969g);
        parcel.writeParcelable(this.f18970h, i);
        ParcelUtil.a(parcel, this.f18971i);
    }
}
