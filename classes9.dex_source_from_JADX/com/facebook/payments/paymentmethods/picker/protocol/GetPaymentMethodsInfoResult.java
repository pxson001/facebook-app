package com.facebook.payments.paymentmethods.picker.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: birthdate */
public class GetPaymentMethodsInfoResult implements Parcelable {
    public static final Creator<GetPaymentMethodsInfoResult> CREATOR = new C22111();
    public final PaymentMethodsInfo f18864a;

    /* compiled from: birthdate */
    final class C22111 implements Creator<GetPaymentMethodsInfoResult> {
        C22111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetPaymentMethodsInfoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetPaymentMethodsInfoResult[i];
        }
    }

    public GetPaymentMethodsInfoResult(PaymentMethodsInfo paymentMethodsInfo) {
        this.f18864a = paymentMethodsInfo;
    }

    public GetPaymentMethodsInfoResult(Parcel parcel) {
        this.f18864a = (PaymentMethodsInfo) parcel.readValue(PaymentMethodsInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f18864a);
    }
}
