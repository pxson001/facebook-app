package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.TriState;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: handleFetchThreadList canServeFromCache= */
public class SetPaymentPinParams implements Parcelable {
    public static final Creator<SetPaymentPinParams> CREATOR = new C15451();
    public static String f13713a = "setPaymentPinParams";
    public final String f13714b;
    public final long f13715c;
    private final TriState f13716d;
    private final Map<Long, Boolean> f13717e;

    /* compiled from: handleFetchThreadList canServeFromCache= */
    final class C15451 implements Creator<SetPaymentPinParams> {
        C15451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetPaymentPinParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetPaymentPinParams[i];
        }
    }

    public SetPaymentPinParams(SetPaymentPinParamsBuilder setPaymentPinParamsBuilder) {
        boolean z;
        ImmutableMap immutableMap;
        if (Strings.isNullOrEmpty(setPaymentPinParamsBuilder.f13718a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f13714b = setPaymentPinParamsBuilder.f13718a;
        this.f13715c = setPaymentPinParamsBuilder.f13719b;
        this.f13716d = setPaymentPinParamsBuilder.f13720c;
        if (setPaymentPinParamsBuilder.f13721d == null) {
            immutableMap = null;
        } else {
            immutableMap = ImmutableMap.copyOf(setPaymentPinParamsBuilder.f13721d);
        }
        this.f13717e = immutableMap;
    }

    public SetPaymentPinParams(Parcel parcel) {
        this.f13714b = parcel.readString();
        this.f13715c = parcel.readLong();
        this.f13716d = ParcelUtil.g(parcel);
        this.f13717e = parcel.readHashMap(null);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("pin", this.f13714b).add("senderId", this.f13715c).add("paymentProtected", this.f13716d).add("threadProfileProtected", this.f13717e).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13714b);
        parcel.writeLong(this.f13715c);
        ParcelUtil.a(parcel, this.f13716d);
        parcel.writeMap(this.f13717e);
    }
}
