package com.facebook.adspayments.analytics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.model.PaymentsFlowType;

/* compiled from: sender_short_name */
public class AdsPaymentsFlowContext extends PaymentsFlowContext {
    public static final Creator<AdsPaymentsFlowContext> CREATOR = new C03571();
    public final CurrencyAmount f3972a;
    public final boolean f3973b;
    public final StoredBalanceStatus f3974c;

    /* compiled from: sender_short_name */
    final class C03571 implements Creator<AdsPaymentsFlowContext> {
        C03571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdsPaymentsFlowContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdsPaymentsFlowContext[i];
        }
    }

    public AdsPaymentsFlowContext(String str, String str2, PaymentsFlowType paymentsFlowType, CurrencyAmount currencyAmount, boolean z, StoredBalanceStatus storedBalanceStatus) {
        super(str, str2, paymentsFlowType);
        this.f3972a = currencyAmount;
        this.f3973b = z;
        this.f3974c = storedBalanceStatus;
    }

    public AdsPaymentsFlowContext(Parcel parcel) {
        super(parcel);
        this.f3972a = (CurrencyAmount) ParcelUtil.b(parcel, CurrencyAmount.class);
        this.f3973b = ParcelUtil.a(parcel);
        this.f3974c = (StoredBalanceStatus) ParcelUtil.c(parcel, StoredBalanceStatus.class);
    }

    public String toString() {
        return m3864j().add("selectedBudget", this.f3972a).add("dailyBudget", this.f3973b).add("storedBalanceStatus", this.f3974c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f3972a, i);
        ParcelUtil.a(parcel, this.f3973b);
        ParcelUtil.a(parcel, this.f3974c);
    }
}
