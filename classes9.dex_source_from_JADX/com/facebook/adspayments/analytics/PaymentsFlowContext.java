package com.facebook.adspayments.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: sender_packet_id */
public class PaymentsFlowContext implements Parcelable {
    public static final Creator<PaymentsFlowContext> CREATOR = new C03581();
    public final String f3966a;
    public final PaymentItemType f3967b;
    public final long f3968c;
    public String f3969d;
    public final PaymentsFlowType f3970e;
    public final String f3971f;

    /* compiled from: sender_packet_id */
    final class C03581 implements Creator<PaymentsFlowContext> {
        C03581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentsFlowContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentsFlowContext[i];
        }
    }

    protected PaymentsFlowContext(String str, String str2, PaymentsFlowType paymentsFlowType) {
        this(str, str2, PaymentItemType.INVOICE, paymentsFlowType, new UniqueIdGenerator().a(), null);
    }

    public PaymentsFlowContext(String str, String str2, PaymentItemType paymentItemType, PaymentsFlowType paymentsFlowType, long j, @Nullable String str3) {
        this.f3966a = (String) Preconditions.checkNotNull(str);
        this.f3969d = str2;
        this.f3967b = (PaymentItemType) Preconditions.checkNotNull(paymentItemType);
        this.f3970e = (PaymentsFlowType) Preconditions.checkNotNull(paymentsFlowType);
        Preconditions.checkArgument(j != 0, "Flow context id should be passed.");
        this.f3968c = j;
        if (str3 == null) {
            str3 = String.valueOf(this.f3968c);
        }
        this.f3971f = str3;
        if (this.f3967b != PaymentItemType.INVOICE) {
            return;
        }
        if (this.f3969d == null || this.f3969d.equals("0")) {
            throw new IllegalArgumentException("Invoice payment (Ads) only works with valid account id");
        }
    }

    public PaymentsFlowContext(Parcel parcel) {
        this.f3966a = parcel.readString();
        this.f3969d = parcel.readString();
        this.f3967b = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f3968c = parcel.readLong();
        this.f3971f = parcel.readString();
        this.f3970e = (PaymentsFlowType) ParcelUtil.c(parcel, PaymentsFlowType.class);
    }

    public final String m3863e() {
        return this.f3969d;
    }

    public String toString() {
        return m3864j().toString();
    }

    protected final ToStringHelper m3864j() {
        return MoreObjects.toStringHelper(this).add("flowName", this.f3966a).add("accountId", this.f3969d).add("paymentItemType", this.f3967b).add("flowContextId", this.f3968c).add("externalReferenceId", this.f3971f).add("paymentsFlowType", this.f3970e);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3966a);
        parcel.writeString(this.f3969d);
        ParcelUtil.a(parcel, this.f3967b);
        parcel.writeLong(this.f3968c);
        parcel.writeString(this.f3971f);
        ParcelUtil.a(parcel, this.f3970e);
    }
}
