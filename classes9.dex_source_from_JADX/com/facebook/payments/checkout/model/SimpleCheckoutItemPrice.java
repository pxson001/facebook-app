package com.facebook.payments.checkout.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.model.CurrencyAmount;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: canonical_thread_id */
public class SimpleCheckoutItemPrice implements CheckoutItemPrice {
    public static final Creator<SimpleCheckoutItemPrice> CREATOR = new C21461();
    private final CurrencyAmount f18516a;

    /* compiled from: canonical_thread_id */
    final class C21461 implements Creator<SimpleCheckoutItemPrice> {
        C21461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleCheckoutItemPrice(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleCheckoutItemPrice[i];
        }
    }

    public SimpleCheckoutItemPrice(CurrencyAmount currencyAmount) {
        this.f18516a = currencyAmount;
    }

    public SimpleCheckoutItemPrice(Parcel parcel) {
        this.f18516a = (CurrencyAmount) parcel.readParcelable(CurrencyAmount.class.getClassLoader());
    }

    public final CurrencyAmount mo730a() {
        return this.f18516a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18516a, i);
    }
}
