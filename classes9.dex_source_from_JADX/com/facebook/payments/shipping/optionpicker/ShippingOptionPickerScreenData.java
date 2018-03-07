package com.facebook.payments.shipping.optionpicker;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_main_list_query */
public class ShippingOptionPickerScreenData implements PickerScreenData {
    public static final Creator<ShippingOptionPickerScreenData> CREATOR = new C22391();
    public final ShippingOptionPickerScreenParams f19025a;
    @Nullable
    public final String f19026b;

    /* compiled from: backstage_main_list_query */
    final class C22391 implements Creator<ShippingOptionPickerScreenData> {
        C22391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingOptionPickerScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingOptionPickerScreenData[i];
        }
    }

    public ShippingOptionPickerScreenData(ShippingOptionPickerScreenParams shippingOptionPickerScreenParams, @Nullable String str) {
        this.f19025a = shippingOptionPickerScreenParams;
        this.f19026b = str;
    }

    public ShippingOptionPickerScreenData(Parcel parcel) {
        this.f19025a = (ShippingOptionPickerScreenParams) parcel.readParcelable(ShippingOptionPickerScreenParams.class.getClassLoader());
        this.f19026b = parcel.readString();
    }

    public final PickerScreenParams mo752a() {
        return this.f19025a;
    }

    @Nullable
    public final Intent mo753b() {
        if (this.f19026b == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_shipping_option_id", this.f19026b);
        return intent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f19025a, i);
        parcel.writeString(this.f19026b);
    }
}
