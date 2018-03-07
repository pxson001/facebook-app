package com.facebook.adspayments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;

/* compiled from: Unable to retrieve thread owner. */
public class AdsPaymentsPickerScreenParams implements PickerScreenParams {
    public static final Creator<AdsPaymentsPickerScreenParams> CREATOR = new C28111();
    private final PickerScreenCommonParams f23521a;
    public final boolean f23522b;

    /* compiled from: Unable to retrieve thread owner. */
    final class C28111 implements Creator<AdsPaymentsPickerScreenParams> {
        C28111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdsPaymentsPickerScreenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdsPaymentsPickerScreenParams[i];
        }
    }

    public AdsPaymentsPickerScreenParams(PickerScreenCommonParams pickerScreenCommonParams, boolean z) {
        this.f23521a = pickerScreenCommonParams;
        this.f23522b = z;
    }

    public AdsPaymentsPickerScreenParams(Parcel parcel) {
        this.f23521a = (PickerScreenCommonParams) parcel.readParcelable(PickerScreenCommonParams.class.getClassLoader());
        this.f23522b = ParcelUtil.a(parcel);
    }

    public final PickerScreenCommonParams mo743a() {
        return this.f23521a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f23521a, i);
        ParcelUtil.a(parcel, this.f23522b);
    }
}
