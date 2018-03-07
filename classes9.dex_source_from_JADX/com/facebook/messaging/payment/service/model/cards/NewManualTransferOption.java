package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fig_adoption_enabled */
public class NewManualTransferOption implements NewPaymentOption {
    public static final Creator<NewManualTransferOption> CREATOR = new C16741();
    public final String f14646a;
    @Nullable
    public final String f14647b;
    @Nullable
    public final String f14648c;
    @Nullable
    public final String f14649d;

    /* compiled from: fig_adoption_enabled */
    final class C16741 implements Creator<NewManualTransferOption> {
        C16741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewManualTransferOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewManualTransferOption[i];
        }
    }

    public NewManualTransferOption(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.f14646a = str;
        this.f14647b = str2;
        this.f14648c = str3;
        this.f14649d = str4;
    }

    public NewManualTransferOption(Parcel parcel) {
        this.f14646a = parcel.readString();
        this.f14647b = parcel.readString();
        this.f14648c = parcel.readString();
        this.f14649d = parcel.readString();
    }

    public final NewPaymentOptionType m15163a() {
        return NewPaymentOptionType.NEW_MANUAL_TRANSFER;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14646a);
        parcel.writeString(this.f14647b);
        parcel.writeString(this.f14648c);
        parcel.writeString(this.f14649d);
    }
}
