package com.facebook.messaging.payment.service.model.cards;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: filter_to_groups */
public class ManualTransferMethod implements PaymentMethod {
    public static final Creator<ManualTransferMethod> CREATOR = new C16721();
    private final String f14637a;
    public final String f14638b;
    public final Uri f14639c;
    public final String f14640d;
    public final String f14641e;

    /* compiled from: filter_to_groups */
    final class C16721 implements Creator<ManualTransferMethod> {
        C16721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ManualTransferMethod(parcel);
        }

        public final Object[] newArray(int i) {
            return new ManualTransferMethod[i];
        }
    }

    public ManualTransferMethod(String str, String str2, Uri uri, String str3, String str4) {
        this.f14637a = str;
        this.f14638b = str2;
        this.f14639c = uri;
        this.f14640d = str3;
        this.f14641e = str4;
    }

    public final String m15159a() {
        return this.f14637a;
    }

    public final PaymentMethodType m15160b() {
        return PaymentMethodType.MANUAL_TRANSFER;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14637a);
        parcel.writeString(this.f14638b);
        parcel.writeString(this.f14639c != null ? this.f14639c.toString() : null);
        parcel.writeString(this.f14640d);
        parcel.writeString(this.f14641e);
    }

    public int describeContents() {
        return 0;
    }

    ManualTransferMethod(Parcel parcel) {
        this.f14637a = parcel.readString();
        this.f14638b = parcel.readString();
        String readString = parcel.readString();
        this.f14639c = readString != null ? Uri.parse(readString) : null;
        this.f14640d = parcel.readString();
        this.f14641e = parcel.readString();
    }
}
