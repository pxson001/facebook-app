package com.facebook.payments.checkout;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.checkout.model.CheckoutItemPrice;
import com.facebook.payments.checkout.recyclerview.TermsAndPoliciesParams;
import com.facebook.payments.decorator.PaymentsActivitySource;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.model.PaymentItemType;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: caspian */
public class CheckoutCommonParams implements CheckoutParams {
    public static final Creator<CheckoutCommonParams> CREATOR = new C21341();
    public final CheckoutStyle f18459a;
    public final PaymentItemType f18460b;
    @Nullable
    public final CheckoutItemPrice f18461c;
    public final PaymentsDecoratorParams f18462d;
    public final TermsAndPoliciesParams f18463e;

    /* compiled from: caspian */
    final class C21341 implements Creator<CheckoutCommonParams> {
        C21341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckoutCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckoutCommonParams[i];
        }
    }

    /* compiled from: caspian */
    public class Builder {
        public CheckoutStyle f18454a;
        public PaymentItemType f18455b;
        public CheckoutItemPrice f18456c;
        public PaymentsDecoratorParams f18457d;
        public TermsAndPoliciesParams f18458e;

        public final CheckoutCommonParams m18461f() {
            return new CheckoutCommonParams(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public CheckoutCommonParams(Builder builder) {
        TermsAndPoliciesParams termsAndPoliciesParams;
        this.f18459a = (CheckoutStyle) Preconditions.checkNotNull(builder.f18454a);
        this.f18460b = (PaymentItemType) Preconditions.checkNotNull(builder.f18455b);
        this.f18461c = builder.f18456c;
        this.f18462d = (PaymentsDecoratorParams) MoreObjects.firstNonNull(builder.f18457d, PaymentsDecoratorParams.b());
        Preconditions.checkArgument(this.f18462d.b == PaymentsActivitySource.CHECKOUT);
        if (builder.f18458e != null) {
            termsAndPoliciesParams = builder.f18458e;
        } else {
            termsAndPoliciesParams = TermsAndPoliciesParams.f18569a;
        }
        this.f18463e = termsAndPoliciesParams;
    }

    public CheckoutCommonParams(Parcel parcel) {
        this.f18459a = (CheckoutStyle) ParcelUtil.c(parcel, CheckoutStyle.class);
        this.f18460b = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f18461c = (CheckoutItemPrice) parcel.readParcelable(CheckoutItemPrice.class.getClassLoader());
        this.f18462d = (PaymentsDecoratorParams) parcel.readParcelable(PaymentsDecoratorParams.class.getClassLoader());
        this.f18463e = (TermsAndPoliciesParams) parcel.readParcelable(TermsAndPoliciesParams.class.getClassLoader());
    }

    public final CheckoutCommonParams mo627a() {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18459a);
        ParcelUtil.a(parcel, this.f18460b);
        parcel.writeParcelable(this.f18461c, i);
        parcel.writeParcelable(this.f18462d, i);
        parcel.writeParcelable(this.f18463e, i);
    }
}
