package com.facebook.payments.settings.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: location_ts */
public class PaymentSettingsPickerScreenData implements PickerScreenData {
    public static final Creator<PaymentSettingsPickerScreenData> CREATOR = new C12581();
    public final PaymentMethodsInfo f8440a;
    public final ImmutableList<MailingAddress> f8441b;
    public final PickerScreenParams f8442c;

    /* compiled from: location_ts */
    final class C12581 implements Creator<PaymentSettingsPickerScreenData> {
        C12581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentSettingsPickerScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentSettingsPickerScreenData[i];
        }
    }

    public PaymentSettingsPickerScreenData(PaymentSettingsPickerScreenDataBuilder paymentSettingsPickerScreenDataBuilder) {
        this.f8440a = paymentSettingsPickerScreenDataBuilder.f8443a;
        this.f8441b = (ImmutableList) Preconditions.checkNotNull(paymentSettingsPickerScreenDataBuilder.f8444b);
        this.f8442c = (PickerScreenParams) Preconditions.checkNotNull(paymentSettingsPickerScreenDataBuilder.f8445c);
    }

    public PaymentSettingsPickerScreenData(Parcel parcel) {
        this.f8440a = (PaymentMethodsInfo) parcel.readParcelable(PaymentMethodsInfo.class.getClassLoader());
        this.f8441b = ImmutableList.copyOf(parcel.readArrayList(MailingAddress.class.getClassLoader()));
        this.f8442c = (PickerScreenParams) parcel.readParcelable(PickerScreenParams.class.getClassLoader());
    }

    public final PickerScreenParams m8370a() {
        return this.f8442c;
    }

    @Nullable
    public final Intent m8371b() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8440a, i);
        parcel.writeList(this.f8441b);
        parcel.writeParcelable(this.f8442c, i);
    }
}
