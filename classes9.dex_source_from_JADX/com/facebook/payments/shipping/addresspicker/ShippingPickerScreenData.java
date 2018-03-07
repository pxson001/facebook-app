package com.facebook.payments.shipping.addresspicker;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: barcode_value */
public class ShippingPickerScreenData implements PickerScreenData {
    public static final Creator<ShippingPickerScreenData> CREATOR = new C22151();
    public final ImmutableList<MailingAddress> f18893a;
    @Nullable
    public final String f18894b;
    public final ShippingPickerScreenParams f18895c;

    /* compiled from: barcode_value */
    final class C22151 implements Creator<ShippingPickerScreenData> {
        C22151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingPickerScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingPickerScreenData[i];
        }
    }

    public ShippingPickerScreenData(ShippingPickerScreenParams shippingPickerScreenParams, ImmutableList<MailingAddress> immutableList, String str) {
        this.f18895c = shippingPickerScreenParams;
        this.f18893a = immutableList;
        this.f18894b = str;
    }

    public ShippingPickerScreenData(Parcel parcel) {
        this.f18893a = ImmutableList.copyOf(parcel.readArrayList(MailingAddress.class.getClassLoader()));
        this.f18894b = parcel.readString();
        this.f18895c = (ShippingPickerScreenParams) parcel.readParcelable(ShippingPickerScreenParams.class.getClassLoader());
    }

    public final PickerScreenParams mo752a() {
        return this.f18895c;
    }

    @Nullable
    public final Intent mo753b() {
        int size = this.f18893a.size();
        for (int i = 0; i < size; i++) {
            MailingAddress mailingAddress = (MailingAddress) this.f18893a.get(i);
            if (mailingAddress.mo760a().equals(this.f18894b)) {
                Intent intent = new Intent();
                intent.putExtra("shipping_address", mailingAddress);
                return intent;
            }
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f18893a.asList());
        parcel.writeString(this.f18894b);
        parcel.writeParcelable(this.f18895c, i);
    }
}
