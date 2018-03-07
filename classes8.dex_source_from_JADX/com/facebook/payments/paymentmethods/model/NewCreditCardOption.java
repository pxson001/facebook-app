package com.facebook.payments.paymentmethods.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.FormFieldProperty;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: suggestifier_footer_question */
public class NewCreditCardOption implements NewPaymentOption {
    public static final Creator<NewCreditCardOption> CREATOR = new C02191();
    private final String f1945a;
    public final FormFieldProperty f1946b;
    public final ImmutableSet<FbPaymentCardType> f1947c;

    /* compiled from: suggestifier_footer_question */
    final class C02191 implements Creator<NewCreditCardOption> {
        C02191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewCreditCardOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewCreditCardOption[i];
        }
    }

    public NewCreditCardOption(@Nullable String str, FormFieldProperty formFieldProperty, ImmutableSet<FbPaymentCardType> immutableSet) {
        this.f1945a = str;
        this.f1946b = formFieldProperty;
        this.f1947c = immutableSet;
    }

    public NewCreditCardOption(Parcel parcel) {
        this.f1945a = parcel.readString();
        this.f1946b = (FormFieldProperty) ParcelUtil.c(parcel, FormFieldProperty.class);
        this.f1947c = Sets.a(parcel.readArrayList(FbPaymentCardType.class.getClassLoader()));
    }

    public final NewPaymentOptionType mo102a() {
        return NewPaymentOptionType.NEW_CREDIT_CARD;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1945a);
        ParcelUtil.a(parcel, this.f1946b);
        parcel.writeList(this.f1947c.asList());
    }
}
