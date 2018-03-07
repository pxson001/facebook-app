package com.facebook.messaging.payment.service.model.shipping;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchTransactionPaymentCard */
public class EditShippingAddressParams implements Parcelable {
    public static final Creator<EditShippingAddressParams> CREATOR = new C16971();
    public final ShippingAddressFormInput f14723a;
    public final String f14724b;
    public final boolean f14725c;
    public final boolean f14726d;

    /* compiled from: fetchTransactionPaymentCard */
    final class C16971 implements Creator<EditShippingAddressParams> {
        C16971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditShippingAddressParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditShippingAddressParams[i];
        }
    }

    public EditShippingAddressParams(EditShippingAddressParamsBuilder editShippingAddressParamsBuilder) {
        boolean z;
        if (editShippingAddressParamsBuilder.f14729c && editShippingAddressParamsBuilder.f14730d) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f14723a = editShippingAddressParamsBuilder.f14727a;
        this.f14724b = editShippingAddressParamsBuilder.f14728b;
        this.f14725c = editShippingAddressParamsBuilder.f14729c;
        this.f14726d = editShippingAddressParamsBuilder.f14730d;
    }

    public EditShippingAddressParams(Parcel parcel) {
        this.f14723a = (ShippingAddressFormInput) parcel.readParcelable(ShippingAddressFormInput.class.getClassLoader());
        this.f14724b = parcel.readString();
        this.f14725c = ParcelUtil.a(parcel);
        this.f14726d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14723a, i);
        parcel.writeString(this.f14724b);
        ParcelUtil.a(parcel, this.f14725c);
        ParcelUtil.a(parcel, this.f14726d);
    }
}
