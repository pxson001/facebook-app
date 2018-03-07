package com.facebook.payments.paymentmethods.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: suggested_pages */
public class NewPayPalOption implements NewPaymentOption {
    public static final Creator<NewPayPalOption> CREATOR = new C02201();

    /* compiled from: suggested_pages */
    final class C02201 implements Creator<NewPayPalOption> {
        C02201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewPayPalOption();
        }

        public final Object[] newArray(int i) {
            return new NewPayPalOption[i];
        }
    }

    private NewPayPalOption(byte b) {
    }

    public final NewPaymentOptionType mo102a() {
        return NewPaymentOptionType.NEW_PAYPAL;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
