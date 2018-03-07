package com.facebook.messaging.payment.service.model.shipping;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchTransactionPaymentCardParams */
public class AddShippingAddressParams implements Parcelable {
    public static final Creator<AddShippingAddressParams> CREATOR = new C16961();
    public final ShippingAddressFormInput f14721a;
    public final String f14722b;

    /* compiled from: fetchTransactionPaymentCardParams */
    final class C16961 implements Creator<AddShippingAddressParams> {
        C16961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddShippingAddressParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddShippingAddressParams[i];
        }
    }

    public AddShippingAddressParams(ShippingAddressFormInput shippingAddressFormInput, String str) {
        this.f14721a = shippingAddressFormInput;
        this.f14722b = str;
    }

    public AddShippingAddressParams(Parcel parcel) {
        this.f14721a = (ShippingAddressFormInput) parcel.readParcelable(ShippingAddressFormInput.class.getClassLoader());
        this.f14722b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14721a, i);
        parcel.writeString(this.f14722b);
    }
}
