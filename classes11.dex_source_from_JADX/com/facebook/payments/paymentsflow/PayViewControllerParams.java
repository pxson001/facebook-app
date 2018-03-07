package com.facebook.payments.paymentsflow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.UniqueIdGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_add_tab_ */
public class PayViewControllerParams implements Parcelable {
    public static final Creator<PayViewControllerParams> CREATOR = new C06081();
    public final String f4364a;
    public final String f4365b;
    public final PaymentsFlowType f4366c;
    public final PaymentItemType f4367d;
    public final ImmutableList<NewPaymentOptionType> f4368e;
    public final long f4369f;

    /* compiled from: page_add_tab_ */
    final class C06081 implements Creator<PayViewControllerParams> {
        C06081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PayViewControllerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PayViewControllerParams[i];
        }
    }

    public PayViewControllerParams(PayViewControllerParamsBuilder payViewControllerParamsBuilder) {
        Preconditions.checkNotNull(payViewControllerParamsBuilder.f4370a);
        Preconditions.checkNotNull(payViewControllerParamsBuilder.f4371b);
        Preconditions.checkNotNull(payViewControllerParamsBuilder.f4372c);
        Preconditions.checkNotNull(payViewControllerParamsBuilder.f4373d);
        this.f4364a = payViewControllerParamsBuilder.f4370a;
        this.f4365b = payViewControllerParamsBuilder.f4371b;
        this.f4366c = payViewControllerParamsBuilder.f4372c;
        this.f4367d = payViewControllerParamsBuilder.f4373d;
        this.f4368e = (ImmutableList) MoreObjects.firstNonNull(payViewControllerParamsBuilder.f4374e, RegularImmutableList.a);
        this.f4369f = payViewControllerParamsBuilder.f4375f == 0 ? new UniqueIdGenerator().a() : payViewControllerParamsBuilder.f4375f;
    }

    public PayViewControllerParams(Parcel parcel) {
        this.f4364a = parcel.readString();
        this.f4365b = parcel.readString();
        this.f4366c = (PaymentsFlowType) ParcelUtil.c(parcel, PaymentsFlowType.class);
        this.f4367d = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f4368e = ImmutableList.copyOf(parcel.readArrayList(NewPaymentOptionType.class.getClassLoader()));
        this.f4369f = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4364a);
        parcel.writeString(this.f4365b);
        ParcelUtil.a(parcel, this.f4366c);
        ParcelUtil.a(parcel, this.f4367d);
        parcel.writeList(this.f4368e.asList());
        parcel.writeLong(this.f4369f);
    }
}
