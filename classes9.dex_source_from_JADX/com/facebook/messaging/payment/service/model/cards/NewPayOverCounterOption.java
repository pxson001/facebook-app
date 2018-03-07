package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetched_count */
public class NewPayOverCounterOption implements NewPaymentOption {
    public static final Creator<NewPayOverCounterOption> CREATOR = new C16761();
    private final String f14652a;

    /* compiled from: fetched_count */
    final class C16761 implements Creator<NewPayOverCounterOption> {
        C16761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewPayOverCounterOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewPayOverCounterOption[i];
        }
    }

    public NewPayOverCounterOption(@Nullable String str) {
        this.f14652a = str;
    }

    public NewPayOverCounterOption(Parcel parcel) {
        this.f14652a = parcel.readString();
    }

    public final NewPaymentOptionType m15165a() {
        return NewPaymentOptionType.NEW_PAY_OVER_COUNTER;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14652a);
    }
}
