package com.facebook.payments.paymentmethods.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: bookmark_fbid */
public class PickerScreenStyleParams implements Parcelable {
    public static final Creator<PickerScreenStyleParams> CREATOR = new C22051();
    public final PaymentsDecoratorParams f18812a;
    @Nullable
    public final PaymentMethod f18813b;

    /* compiled from: bookmark_fbid */
    final class C22051 implements Creator<PickerScreenStyleParams> {
        C22051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PickerScreenStyleParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PickerScreenStyleParams[i];
        }
    }

    public static PickerScreenStyleParamsBuilder newBuilder() {
        return new PickerScreenStyleParamsBuilder();
    }

    public PickerScreenStyleParams(PickerScreenStyleParamsBuilder pickerScreenStyleParamsBuilder) {
        this.f18812a = (PaymentsDecoratorParams) MoreObjects.firstNonNull(pickerScreenStyleParamsBuilder.f18814a, PaymentsDecoratorParams.c());
        this.f18813b = pickerScreenStyleParamsBuilder.f18815b;
    }

    public PickerScreenStyleParams(Parcel parcel) {
        this.f18812a = (PaymentsDecoratorParams) parcel.readParcelable(PaymentsDecoratorParams.class.getClassLoader());
        this.f18813b = (PaymentMethod) parcel.readParcelable(PaymentMethod.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18812a, i);
        parcel.writeParcelable(this.f18813b, i);
    }
}
