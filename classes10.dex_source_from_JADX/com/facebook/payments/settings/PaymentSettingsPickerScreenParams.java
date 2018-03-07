package com.facebook.payments.settings;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: logged_in_user */
public class PaymentSettingsPickerScreenParams implements PickerScreenParams {
    public static final Creator<PaymentSettingsPickerScreenParams> CREATOR = new C12541();
    public final PickerScreenCommonParams f8430a;

    /* compiled from: logged_in_user */
    final class C12541 implements Creator<PaymentSettingsPickerScreenParams> {
        C12541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentSettingsPickerScreenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentSettingsPickerScreenParams[i];
        }
    }

    public PaymentSettingsPickerScreenParams(PaymentSettingsPickerScreenParamsBuilder paymentSettingsPickerScreenParamsBuilder) {
        this.f8430a = (PickerScreenCommonParams) Preconditions.checkNotNull(paymentSettingsPickerScreenParamsBuilder.f8431a);
    }

    public PaymentSettingsPickerScreenParams(Parcel parcel) {
        this.f8430a = (PickerScreenCommonParams) parcel.readParcelable(PickerScreenCommonParams.class.getClassLoader());
    }

    public final PickerScreenCommonParams m8357a() {
        return this.f8430a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8430a, i);
    }
}
