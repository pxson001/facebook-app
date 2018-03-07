package com.facebook.payments.paymentmethods.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PayPalBillingAgreementDeserializer.class)
@Immutable
/* compiled from: suggested_member_friend_sort_param */
public class PayPalBillingAgreement implements PaymentMethod {
    public static final Creator<PayPalBillingAgreement> CREATOR = new C02211();
    @PrivacySource
    @JsonProperty("email")
    private final String mEmailId;
    @JsonProperty("id")
    private final String mId;

    /* compiled from: suggested_member_friend_sort_param */
    final class C02211 implements Creator<PayPalBillingAgreement> {
        C02211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PayPalBillingAgreement(parcel);
        }

        public final Object[] newArray(int i) {
            return new PayPalBillingAgreement[i];
        }
    }

    public PayPalBillingAgreement() {
        this(null, null);
    }

    @VisibleForTesting
    public PayPalBillingAgreement(String str, String str2) {
        this.mId = str;
        this.mEmailId = str2;
    }

    public final String mo94a() {
        return this.mId;
    }

    public final PaymentMethodType mo95b() {
        return PaymentMethodType.PAYPAL_BILLING_AGREEMENT;
    }

    public static Drawable m2178a(Resources resources) {
        return resources.getDrawable(2130842972);
    }

    public final String m2181c() {
        return this.mEmailId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PayPalBillingAgreement payPalBillingAgreement = (PayPalBillingAgreement) obj;
        if (Objects.equal(this.mId, payPalBillingAgreement.mId) && Objects.equal(this.mEmailId, payPalBillingAgreement.mEmailId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mId, this.mEmailId});
    }

    public String toString() {
        return MoreObjects.toStringHelper(getClass()).add("id", mo94a()).add("email", m2181c()).toString();
    }

    public PayPalBillingAgreement(Parcel parcel) {
        this.mId = parcel.readString();
        this.mEmailId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mEmailId);
    }

    public int describeContents() {
        return 0;
    }
}
