package com.facebook.messaging.payment.value.input.checkout;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.checkout.CheckoutCommonParams;
import com.facebook.payments.checkout.CheckoutParams;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: end_call_in_background */
public class MessengerCommerceCheckoutParams implements CheckoutParams {
    public static final Creator<MessengerCommerceCheckoutParams> CREATOR = new C18511();
    public final CheckoutCommonParams f15758a;
    public final String f15759b;

    /* compiled from: end_call_in_background */
    final class C18511 implements Creator<MessengerCommerceCheckoutParams> {
        C18511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerCommerceCheckoutParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerCommerceCheckoutParams[i];
        }
    }

    public MessengerCommerceCheckoutParams(MessengerCommerceCheckoutParamsBuilder messengerCommerceCheckoutParamsBuilder) {
        this.f15758a = (CheckoutCommonParams) Preconditions.checkNotNull(messengerCommerceCheckoutParamsBuilder.f15760a);
        this.f15759b = (String) Preconditions.checkNotNull(messengerCommerceCheckoutParamsBuilder.f15761b);
    }

    public MessengerCommerceCheckoutParams(Parcel parcel) {
        this.f15758a = (CheckoutCommonParams) parcel.readParcelable(CheckoutCommonParams.class.getClassLoader());
        this.f15759b = parcel.readString();
    }

    public final CheckoutCommonParams mo627a() {
        return this.f15758a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15758a, i);
        parcel.writeString(this.f15759b);
    }
}
