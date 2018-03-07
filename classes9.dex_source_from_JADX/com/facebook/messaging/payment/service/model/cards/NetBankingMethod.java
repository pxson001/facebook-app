package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: file_mime_type */
public class NetBankingMethod implements PaymentMethod {
    public static final Creator<NetBankingMethod> CREATOR = new C16731();
    public final String f14642a;
    private final String f14643b;
    private final String f14644c;
    public final String f14645d;

    /* compiled from: file_mime_type */
    final class C16731 implements Creator<NetBankingMethod> {
        C16731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NetBankingMethod(parcel);
        }

        public final Object[] newArray(int i) {
            return new NetBankingMethod[i];
        }
    }

    public NetBankingMethod(String str, String str2, String str3, String str4) {
        this.f14642a = str;
        this.f14643b = str2;
        this.f14644c = str3;
        this.f14645d = str4;
    }

    public NetBankingMethod(Parcel parcel) {
        this.f14642a = parcel.readString();
        this.f14643b = parcel.readString();
        this.f14644c = parcel.readString();
        this.f14645d = parcel.readString();
    }

    @Nullable
    public final String m15161a() {
        return "0";
    }

    public final PaymentMethodType m15162b() {
        return PaymentMethodType.NET_BANKING;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14642a);
        parcel.writeString(this.f14643b);
        parcel.writeString(this.f14644c);
        parcel.writeString(this.f14645d);
    }
}
