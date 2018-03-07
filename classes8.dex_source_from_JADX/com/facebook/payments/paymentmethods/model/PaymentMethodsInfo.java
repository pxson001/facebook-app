package com.facebook.payments.paymentmethods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.infer.annotation.PrivacySource;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: subtitles */
public class PaymentMethodsInfo implements Parcelable {
    public static final Creator<PaymentMethodsInfo> CREATOR = new C02221();
    @PrivacySource
    public final Country f1949a;
    @PrivacySource
    private final String f1950b;
    @PrivacySource
    public final String f1951c;
    public final ImmutableList<PaymentMethod> f1952d;
    public final ImmutableList<NewPaymentOption> f1953e;

    /* compiled from: subtitles */
    final class C02221 implements Creator<PaymentMethodsInfo> {
        C02221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentMethodsInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentMethodsInfo[i];
        }
    }

    public PaymentMethodsInfo(Country country, String str, String str2, ImmutableList<PaymentMethod> immutableList, ImmutableList<NewPaymentOption> immutableList2) {
        this.f1949a = country;
        this.f1950b = str;
        this.f1951c = str2;
        this.f1952d = immutableList;
        this.f1953e = immutableList2;
    }

    public PaymentMethodsInfo(Parcel parcel) {
        this.f1949a = (Country) parcel.readParcelable(Country.class.getClassLoader());
        this.f1950b = parcel.readString();
        this.f1951c = parcel.readString();
        this.f1952d = ImmutableList.copyOf(parcel.readArrayList(PaymentMethod.class.getClassLoader()));
        this.f1953e = ImmutableList.copyOf(parcel.readArrayList(NewPaymentOption.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1949a, i);
        parcel.writeString(this.f1950b);
        parcel.writeString(this.f1951c);
        parcel.writeList(this.f1952d);
        parcel.writeList(this.f1953e);
    }

    @Nullable
    public final PaymentMethod m2184a(String str) {
        int size = this.f1952d.size();
        for (int i = 0; i < size; i++) {
            PaymentMethod paymentMethod = (PaymentMethod) this.f1952d.get(i);
            if (paymentMethod.mo94a().equals(str)) {
                return paymentMethod;
            }
        }
        return null;
    }
}
