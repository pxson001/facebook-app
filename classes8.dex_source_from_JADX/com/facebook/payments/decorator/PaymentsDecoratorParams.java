package com.facebook.payments.decorator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_privacy_picker_privacy_search */
public class PaymentsDecoratorParams implements Parcelable {
    public static final Creator<PaymentsDecoratorParams> CREATOR = new C01821();
    public final PaymentsDecoratorAnimation f1758a;
    public final PaymentsActivitySource f1759b;

    /* compiled from: target_privacy_picker_privacy_search */
    final class C01821 implements Creator<PaymentsDecoratorParams> {
        C01821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentsDecoratorParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentsDecoratorParams[i];
        }
    }

    /* compiled from: target_privacy_picker_privacy_search */
    public class Builder {
        public PaymentsDecoratorAnimation f1756a;
        public PaymentsActivitySource f1757b;

        public final Builder m1942a(PaymentsDecoratorParams paymentsDecoratorParams) {
            this.f1756a = paymentsDecoratorParams.f1758a;
            this.f1757b = paymentsDecoratorParams.f1759b;
            return this;
        }

        public final PaymentsDecoratorParams m1943c() {
            return new PaymentsDecoratorParams(this);
        }
    }

    public static PaymentsDecoratorParams m1944a() {
        Builder newBuilder = newBuilder();
        newBuilder.f1756a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
        return newBuilder.m1943c();
    }

    public static PaymentsDecoratorParams m1945b() {
        Builder newBuilder = newBuilder();
        newBuilder.f1756a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
        newBuilder = newBuilder;
        newBuilder.f1757b = PaymentsActivitySource.CHECKOUT;
        return newBuilder.m1943c();
    }

    public static PaymentsDecoratorParams m1946c() {
        Builder newBuilder = newBuilder();
        newBuilder.f1756a = PaymentsDecoratorAnimation.SLIDE_RIGHT;
        return newBuilder.m1943c();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public PaymentsDecoratorParams(Builder builder) {
        this.f1758a = (PaymentsDecoratorAnimation) Preconditions.checkNotNull(builder.f1756a);
        this.f1759b = (PaymentsActivitySource) MoreObjects.firstNonNull(builder.f1757b, PaymentsActivitySource.OTHER);
    }

    public PaymentsDecoratorParams(Parcel parcel) {
        this.f1758a = (PaymentsDecoratorAnimation) ParcelUtil.c(parcel, PaymentsDecoratorAnimation.class);
        this.f1759b = (PaymentsActivitySource) ParcelUtil.c(parcel, PaymentsActivitySource.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f1758a);
        ParcelUtil.a(parcel, this.f1759b);
    }
}
