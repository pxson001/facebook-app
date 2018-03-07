package com.facebook.payments.paymentmethods.cardform;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.FormFieldProperty;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: tap_change_cta_button */
public class CardFormStyleParams implements Parcelable {
    public static final Creator<CardFormStyleParams> CREATOR = new C02051();
    @Nullable
    public final String f1853a;
    @Nullable
    public final String f1854b;
    public final PaymentsDecoratorParams f1855c;
    public final FormFieldProperty f1856d;

    /* compiled from: tap_change_cta_button */
    final class C02051 implements Creator<CardFormStyleParams> {
        C02051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CardFormStyleParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CardFormStyleParams[i];
        }
    }

    /* compiled from: tap_change_cta_button */
    public class Builder {
        public String f1849a;
        public String f1850b;
        public PaymentsDecoratorParams f1851c;
        public FormFieldProperty f1852d;

        public final CardFormStyleParams m2033e() {
            return new CardFormStyleParams(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public CardFormStyleParams(Builder builder) {
        FormFieldProperty formFieldProperty;
        this.f1853a = builder.f1849a;
        this.f1854b = builder.f1850b;
        this.f1855c = (PaymentsDecoratorParams) MoreObjects.firstNonNull(builder.f1851c, PaymentsDecoratorParams.m1944a());
        if (builder.f1852d != null) {
            formFieldProperty = builder.f1852d;
        } else {
            formFieldProperty = FormFieldProperty.REQUIRED;
        }
        this.f1856d = formFieldProperty;
    }

    public CardFormStyleParams(Parcel parcel) {
        this.f1853a = parcel.readString();
        this.f1854b = parcel.readString();
        this.f1855c = (PaymentsDecoratorParams) parcel.readParcelable(PaymentsDecoratorParams.class.getClassLoader());
        this.f1856d = (FormFieldProperty) ParcelUtil.c(parcel, FormFieldProperty.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1853a);
        parcel.writeString(this.f1854b);
        parcel.writeParcelable(this.f1855c, i);
        ParcelUtil.a(parcel, this.f1856d);
    }
}
