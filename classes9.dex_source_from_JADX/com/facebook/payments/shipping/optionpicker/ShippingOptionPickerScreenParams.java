package com.facebook.payments.shipping.optionpicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_import_deselect_all */
public class ShippingOptionPickerScreenParams implements PickerScreenParams {
    public static final Creator<ShippingOptionPickerScreenParams> CREATOR = new C22401();
    public final PickerScreenCommonParams f19027a;
    public final ImmutableList<ShippingOption> f19028b;
    @Nullable
    public final String f19029c;

    /* compiled from: backstage_import_deselect_all */
    final class C22401 implements Creator<ShippingOptionPickerScreenParams> {
        C22401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingOptionPickerScreenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingOptionPickerScreenParams[i];
        }
    }

    public static ShippingOptionPickerScreenParamsBuilder newBuilder() {
        return new ShippingOptionPickerScreenParamsBuilder();
    }

    public ShippingOptionPickerScreenParams(ShippingOptionPickerScreenParamsBuilder shippingOptionPickerScreenParamsBuilder) {
        this.f19027a = (PickerScreenCommonParams) Preconditions.checkNotNull(shippingOptionPickerScreenParamsBuilder.f19030a);
        if (shippingOptionPickerScreenParamsBuilder.f19031b == null || shippingOptionPickerScreenParamsBuilder.f19031b.isEmpty()) {
            throw new IllegalArgumentException("No Shipping option passed to show on picker screen");
        }
        this.f19028b = shippingOptionPickerScreenParamsBuilder.f19031b;
        this.f19029c = shippingOptionPickerScreenParamsBuilder.f19032c;
    }

    public ShippingOptionPickerScreenParams(Parcel parcel) {
        this.f19027a = (PickerScreenCommonParams) parcel.readParcelable(PickerScreenCommonParams.class.getClassLoader());
        this.f19028b = ImmutableList.copyOf(parcel.readArrayList(ShippingOption.class.getClassLoader()));
        this.f19029c = parcel.readString();
    }

    public final PickerScreenCommonParams mo743a() {
        return this.f19027a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f19027a, i);
        parcel.writeList(this.f19028b.asList());
        parcel.writeString(this.f19029c);
    }
}
