package com.facebook.payments.paymentmethods.picker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.google.common.collect.ImmutableList;

/* compiled from: boosted_component_delete */
public class PaymentMethodsPickerScreenCommonParams implements PickerScreenParams {
    public static final Creator<PaymentMethodsPickerScreenCommonParams> CREATOR = new C21881();
    public final PickerScreenStyleParams f18741a;
    public final PaymentItemType f18742b;
    public final ImmutableList<NewPaymentOptionType> f18743c;
    public final String f18744d;
    public final PickerScreenCommonParams f18745e;

    /* compiled from: boosted_component_delete */
    final class C21881 implements Creator<PaymentMethodsPickerScreenCommonParams> {
        C21881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentMethodsPickerScreenCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentMethodsPickerScreenCommonParams[i];
        }
    }

    public static PaymentMethodsPickerScreenCommonParamsBuilder newBuilder() {
        return new PaymentMethodsPickerScreenCommonParamsBuilder();
    }

    public PaymentMethodsPickerScreenCommonParams(Parcel parcel) {
        this.f18741a = (PickerScreenStyleParams) parcel.readParcelable(PickerScreenStyleParams.class.getClassLoader());
        this.f18742b = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f18743c = ImmutableList.copyOf(parcel.readArrayList(NewPaymentOptionType.class.getClassLoader()));
        this.f18744d = parcel.readString();
        this.f18745e = (PickerScreenCommonParams) parcel.readParcelable(PickerScreenCommonParams.class.getClassLoader());
    }

    public final PickerScreenCommonParams mo743a() {
        return this.f18745e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18741a, i);
        ParcelUtil.a(parcel, this.f18742b);
        parcel.writeList(this.f18743c.asList());
        parcel.writeString(this.f18744d);
        parcel.writeParcelable(this.f18745e, i);
    }
}
