package com.facebook.messaging.payment.value.input.checkout;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParams;
import com.facebook.payments.checkout.CheckoutCommonParams;
import com.facebook.payments.checkout.CheckoutParams;
import com.google.common.base.Preconditions;

/* compiled from: error_create_account */
public class MCheckoutParams implements CheckoutParams {
    public static final Creator<MCheckoutParams> CREATOR = new C18431();
    public final CheckoutCommonParams f15701a;
    public final MoneyPennyItemParams f15702b;

    /* compiled from: error_create_account */
    final class C18431 implements Creator<MCheckoutParams> {
        C18431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MCheckoutParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MCheckoutParams[i];
        }
    }

    public MCheckoutParams(MCheckoutParamsBuilder mCheckoutParamsBuilder) {
        this.f15701a = (CheckoutCommonParams) Preconditions.checkNotNull(mCheckoutParamsBuilder.f15703a);
        this.f15702b = (MoneyPennyItemParams) Preconditions.checkNotNull(mCheckoutParamsBuilder.f15704b);
    }

    public MCheckoutParams(Parcel parcel) {
        this.f15701a = (CheckoutCommonParams) parcel.readParcelable(CheckoutCommonParams.class.getClassLoader());
        this.f15702b = (MoneyPennyItemParams) parcel.readParcelable(MoneyPennyItemParams.class.getClassLoader());
    }

    public final CheckoutCommonParams mo627a() {
        return this.f15701a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15701a, i);
        parcel.writeParcelable(this.f15702b, i);
    }
}
