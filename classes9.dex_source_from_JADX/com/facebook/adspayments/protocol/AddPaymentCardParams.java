package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: first_devices */
public class AddPaymentCardParams extends PaymentCardParams {
    public static final Creator<AddPaymentCardParams> CREATOR = new C28591();
    public final String f23691a;
    public final String f23692b;
    public final String f23693c;
    public final boolean f23694d;

    /* compiled from: first_devices */
    final class C28591 implements Creator<AddPaymentCardParams> {
        C28591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPaymentCardParams[i];
        }
    }

    public AddPaymentCardParams(String str, int i, int i2, String str2, String str3, Country country, String str4, String str5, PaymentItemType paymentItemType, boolean z) {
        super(paymentItemType, str2, i, i2, str3, country);
        this.f23691a = str;
        this.f23692b = str4;
        this.f23693c = str5;
        this.f23694d = z;
    }

    public AddPaymentCardParams(Parcel parcel) {
        super(parcel);
        this.f23691a = parcel.readString();
        this.f23692b = parcel.readString();
        this.f23693c = parcel.readString();
        this.f23694d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f23691a);
        parcel.writeString(this.f23692b);
        parcel.writeString(this.f23693c);
        ParcelUtil.a(parcel, this.f23694d);
    }
}
