package com.facebook.payments.shipping.addresspicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.facebook.payments.shipping.model.ShippingParams;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: badge_count_package_name */
public class ShippingPickerScreenParams implements PickerScreenParams {
    public static final Creator<ShippingPickerScreenParams> CREATOR = new C22161();
    public final PickerScreenCommonParams f18898a;
    public final ShippingParams f18899b;
    public final ImmutableList<MailingAddress> f18900c;
    @Nullable
    public final String f18901d;

    /* compiled from: badge_count_package_name */
    final class C22161 implements Creator<ShippingPickerScreenParams> {
        C22161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingPickerScreenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingPickerScreenParams[i];
        }
    }

    public static ShippingPickerScreenParamsBuilder newBuilder() {
        return new ShippingPickerScreenParamsBuilder();
    }

    public ShippingPickerScreenParams(ShippingPickerScreenParamsBuilder shippingPickerScreenParamsBuilder) {
        ShippingParams h;
        this.f18898a = (PickerScreenCommonParams) Preconditions.checkNotNull(shippingPickerScreenParamsBuilder.f18902a);
        if (shippingPickerScreenParamsBuilder.f18903b == null) {
            ShippingCommonParamsBuilder newBuilder = ShippingCommonParams.newBuilder();
            newBuilder.f18994a = ShippingStyle.SIMPLE;
            newBuilder = newBuilder;
            newBuilder.f18998e = ShippingSource.CHECKOUT;
            h = newBuilder.m18972h();
        } else {
            h = shippingPickerScreenParamsBuilder.f18903b;
        }
        this.f18899b = h;
        if (shippingPickerScreenParamsBuilder.f18904c == null || shippingPickerScreenParamsBuilder.f18904c.isEmpty()) {
            throw new IllegalArgumentException("Shipping picker screen started on empty or null list");
        }
        this.f18900c = shippingPickerScreenParamsBuilder.f18904c;
        this.f18901d = shippingPickerScreenParamsBuilder.f18905d;
    }

    public ShippingPickerScreenParams(Parcel parcel) {
        this.f18898a = (PickerScreenCommonParams) parcel.readParcelable(PickerScreenCommonParams.class.getClassLoader());
        this.f18899b = (ShippingParams) parcel.readParcelable(ShippingParams.class.getClassLoader());
        this.f18900c = ImmutableList.copyOf(parcel.readArrayList(MailingAddress.class.getClassLoader()));
        this.f18901d = parcel.readString();
    }

    public final PickerScreenCommonParams mo743a() {
        return this.f18898a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18898a, i);
        parcel.writeParcelable(this.f18899b, i);
        parcel.writeList(this.f18900c.asList());
        parcel.writeString(this.f18901d);
    }
}
