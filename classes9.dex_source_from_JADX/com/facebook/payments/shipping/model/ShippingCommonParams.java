package com.facebook.payments.shipping.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.FormFieldProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_reactions_list_closed */
public class ShippingCommonParams implements ShippingParams {
    public static final Creator<ShippingCommonParams> CREATOR = new C22361();
    public final ShippingStyle f18987a;
    @Nullable
    public final Country f18988b;
    public final FormFieldProperty f18989c;
    @Nullable
    public final MailingAddress f18990d;
    public final ShippingSource f18991e;
    public final PaymentsDecoratorParams f18992f;
    public final int f18993g;

    /* compiled from: backstage_reactions_list_closed */
    final class C22361 implements Creator<ShippingCommonParams> {
        C22361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShippingCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShippingCommonParams[i];
        }
    }

    public static ShippingCommonParamsBuilder newBuilder() {
        return new ShippingCommonParamsBuilder();
    }

    public ShippingCommonParams(ShippingCommonParamsBuilder shippingCommonParamsBuilder) {
        FormFieldProperty formFieldProperty;
        this.f18987a = (ShippingStyle) Preconditions.checkNotNull(shippingCommonParamsBuilder.f18994a);
        this.f18988b = shippingCommonParamsBuilder.f18995b;
        if (shippingCommonParamsBuilder.f18996c != null) {
            formFieldProperty = shippingCommonParamsBuilder.f18996c;
        } else {
            formFieldProperty = FormFieldProperty.REQUIRED;
        }
        this.f18989c = formFieldProperty;
        this.f18990d = shippingCommonParamsBuilder.f18997d;
        this.f18991e = (ShippingSource) Preconditions.checkNotNull(shippingCommonParamsBuilder.f18998e);
        this.f18992f = (PaymentsDecoratorParams) MoreObjects.firstNonNull(shippingCommonParamsBuilder.f18999f, PaymentsDecoratorParams.a());
        this.f18993g = shippingCommonParamsBuilder.f19000g;
    }

    public ShippingCommonParams(Parcel parcel) {
        this.f18987a = (ShippingStyle) ParcelUtil.c(parcel, ShippingStyle.class);
        this.f18988b = (Country) parcel.readParcelable(Country.class.getClassLoader());
        this.f18989c = (FormFieldProperty) ParcelUtil.c(parcel, FormFieldProperty.class);
        this.f18990d = (MailingAddress) parcel.readParcelable(MailingAddress.class.getClassLoader());
        this.f18991e = (ShippingSource) ParcelUtil.c(parcel, ShippingSource.class);
        this.f18992f = (PaymentsDecoratorParams) parcel.readParcelable(PaymentsDecoratorParams.class.getClassLoader());
        this.f18993g = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18987a);
        parcel.writeParcelable(this.f18988b, i);
        ParcelUtil.a(parcel, this.f18989c);
        parcel.writeParcelable(this.f18990d, i);
        ParcelUtil.a(parcel, this.f18991e);
        parcel.writeParcelable(this.f18992f, i);
        parcel.writeInt(this.f18993g);
    }

    public final ShippingCommonParams mo759a() {
        return this;
    }
}
