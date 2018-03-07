package com.facebook.adspayments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import javax.annotation.Nullable;

/* compiled from: Unable to update socket destination address */
public class AdsPaymentsPickerScreenData extends PaymentMethodsPickerScreenData {
    public static final Creator<AdsPaymentsPickerScreenData> CREATOR = new C28101();
    public final boolean f23519d;

    /* compiled from: Unable to update socket destination address */
    final class C28101 implements Creator<AdsPaymentsPickerScreenData> {
        C28101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdsPaymentsPickerScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdsPaymentsPickerScreenData[i];
        }
    }

    public AdsPaymentsPickerScreenData(PaymentMethodsInfo paymentMethodsInfo, PickerScreenParams pickerScreenParams, @Nullable String str, boolean z) {
        super(paymentMethodsInfo, pickerScreenParams, str);
        this.f23519d = z;
    }

    public AdsPaymentsPickerScreenData(Parcel parcel) {
        super(parcel);
        this.f23519d = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        ParcelUtil.a(parcel, this.f23519d);
    }
}
