package com.facebook.messaging.payment.pin.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.TriState;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: gysc_tab */
public class PaymentPinProtectionsParams implements Parcelable {
    public static final Creator<PaymentPinProtectionsParams> CREATOR = new C15471();
    public static String f13728a = "paymentPinProtectionsParams";
    public final TriState f13729b;
    private final Map<Long, Boolean> f13730c;

    /* compiled from: gysc_tab */
    final class C15471 implements Creator<PaymentPinProtectionsParams> {
        C15471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentPinProtectionsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentPinProtectionsParams[i];
        }
    }

    public PaymentPinProtectionsParams(PaymentPinProtectionsParamsBuilder paymentPinProtectionsParamsBuilder) {
        this.f13729b = paymentPinProtectionsParamsBuilder.f13731a;
        this.f13730c = paymentPinProtectionsParamsBuilder.f13732b;
    }

    public final ImmutableMap<Long, Boolean> m14266b() {
        return ImmutableMap.copyOf(this.f13730c);
    }

    public PaymentPinProtectionsParams(Parcel parcel) {
        this.f13729b = ParcelUtil.g(parcel);
        this.f13730c = parcel.readHashMap(null);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("paymentProtected", this.f13729b).add("threadProfileProtected", this.f13730c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f13729b);
        parcel.writeMap(this.f13730c);
    }
}
