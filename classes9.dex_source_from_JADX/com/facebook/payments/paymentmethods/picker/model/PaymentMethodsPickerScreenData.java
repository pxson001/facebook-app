package com.facebook.payments.paymentmethods.picker.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bluetooth_end */
public class PaymentMethodsPickerScreenData implements PickerScreenData {
    public static final Creator<PaymentMethodsPickerScreenData> CREATOR = new C22081();
    public final PaymentMethodsInfo f18844a;
    public final PickerScreenParams f18845b;
    @Nullable
    public final String f18846c;

    /* compiled from: bluetooth_end */
    final class C22081 implements Creator<PaymentMethodsPickerScreenData> {
        C22081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentMethodsPickerScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentMethodsPickerScreenData[i];
        }
    }

    public PaymentMethodsPickerScreenData(PaymentMethodsInfo paymentMethodsInfo, PickerScreenParams pickerScreenParams, @Nullable String str) {
        this.f18844a = paymentMethodsInfo;
        this.f18845b = pickerScreenParams;
        this.f18846c = str;
    }

    protected PaymentMethodsPickerScreenData(Parcel parcel) {
        this.f18844a = (PaymentMethodsInfo) parcel.readParcelable(PaymentMethodsInfo.class.getClassLoader());
        this.f18845b = (PickerScreenParams) parcel.readParcelable(PickerScreenParams.class.getClassLoader());
        this.f18846c = parcel.readString();
    }

    public final PickerScreenParams mo752a() {
        return this.f18845b;
    }

    public final Intent mo753b() {
        if (this.f18846c == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("selected_payment_method", this.f18844a.a(this.f18846c));
        return intent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18844a, i);
        parcel.writeParcelable(this.f18845b, i);
        parcel.writeString(this.f18846c);
    }
}
