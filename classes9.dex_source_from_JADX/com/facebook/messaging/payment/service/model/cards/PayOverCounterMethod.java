package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchedSavedAudienceAccount */
public class PayOverCounterMethod implements PaymentMethod {
    public static final Creator<PayOverCounterMethod> CREATOR = new C16771();

    /* compiled from: fetchedSavedAudienceAccount */
    final class C16771 implements Creator<PayOverCounterMethod> {
        C16771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PayOverCounterMethod((byte) 0);
        }

        public final Object[] newArray(int i) {
            return new PayOverCounterMethod[i];
        }
    }

    @Nullable
    public final String m15166a() {
        return "0";
    }

    public final PaymentMethodType m15167b() {
        return PaymentMethodType.PAY_OVER_COUNTER;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    PayOverCounterMethod(byte b) {
    }
}
