package com.facebook.payments.settings.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;

/* compiled from: location_signal_package_db */
public class PaymentSettingsPickerScreenFetcherParams implements PickerScreenFetcherParams {
    public static final Creator<PaymentSettingsPickerScreenFetcherParams> CREATOR = new C12591();
    public final boolean f8446a;

    /* compiled from: location_signal_package_db */
    final class C12591 implements Creator<PaymentSettingsPickerScreenFetcherParams> {
        C12591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentSettingsPickerScreenFetcherParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentSettingsPickerScreenFetcherParams[i];
        }
    }

    public static PaymentSettingsPickerScreenFetcherParamsBuilder newBuilder() {
        return new PaymentSettingsPickerScreenFetcherParamsBuilder();
    }

    public PaymentSettingsPickerScreenFetcherParams(PaymentSettingsPickerScreenFetcherParamsBuilder paymentSettingsPickerScreenFetcherParamsBuilder) {
        this.f8446a = paymentSettingsPickerScreenFetcherParamsBuilder.f8447a;
    }

    public PaymentSettingsPickerScreenFetcherParams(Parcel parcel) {
        this.f8446a = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f8446a);
    }

    public int describeContents() {
        return 0;
    }
}
