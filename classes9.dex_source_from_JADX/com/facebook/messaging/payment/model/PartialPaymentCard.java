package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: identity_key */
public class PartialPaymentCard extends PaymentCard {
    public static final Creator<PartialPaymentCard> CREATOR = new C14831();

    /* compiled from: identity_key */
    final class C14831 implements Creator<PartialPaymentCard> {
        C14831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PartialPaymentCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new PartialPaymentCard[i];
        }
    }

    public PartialPaymentCard(long j, String str, int i, int i2, Address address, String str2, boolean z, boolean z2) {
        PaymentCardBuilder newBuilder = PaymentCard.newBuilder();
        newBuilder.f13215a = j;
        newBuilder = newBuilder;
        newBuilder.f13216b = str;
        newBuilder = newBuilder;
        newBuilder.f13217c = i;
        newBuilder = newBuilder;
        newBuilder.f13218d = i2;
        newBuilder = newBuilder;
        newBuilder.f13219e = address;
        newBuilder = newBuilder;
        newBuilder.f13220f = str2;
        newBuilder = newBuilder;
        newBuilder.f13221g = z;
        newBuilder = newBuilder;
        newBuilder.f13223i = z2;
        super(newBuilder);
    }

    public PartialPaymentCard(Parcel parcel) {
        super(parcel);
    }

    public final PaymentCardCategory mo522g() {
        throw new IllegalAccessError("Cannot access category for locally constructed PaymentCard");
    }

    public final boolean mo523h() {
        throw new IllegalAccessError("Cannot access CommercePaymentEligible for locally constructed PaymentCard");
    }

    public final boolean mo524k() {
        throw new IllegalAccessError("Cannot access PersonaTransferEligible for locally constructed PaymentCard");
    }

    public final boolean mo525l() {
        throw new IllegalAccessError("Cannot access IsDefaultReceiving for locally constructed PaymentCard");
    }
}
