package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.analytics.IAnalyticsService */
public final class ZeroOptinParams extends ZeroRequestBaseParams {
    public static final Creator<ZeroOptinParams> CREATOR = new C05431();
    public final String f5903a;

    /* compiled from: com.facebook.analytics.IAnalyticsService */
    final class C05431 implements Creator<ZeroOptinParams> {
        C05431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroOptinParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroOptinParams[i];
        }
    }

    public ZeroOptinParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2) {
        super(carrierAndSimMccMnc, str);
        this.f5903a = str2;
    }

    public ZeroOptinParams(Parcel parcel) {
        super(parcel);
        this.f5903a = parcel.readString();
    }

    public final String m10686a() {
        return "zeroOptinParams";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5903a);
    }

    public final String toString() {
        return Objects.toStringHelper(ZeroOptinParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("subnoBlob", this.f5903a).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ZeroOptinParams)) {
            return false;
        }
        ZeroOptinParams zeroOptinParams = (ZeroOptinParams) obj;
        if (Objects.equal(this.a, zeroOptinParams.a) && Objects.equal(this.b, zeroOptinParams.b) && Objects.equal(this.f5903a, zeroOptinParams.f5903a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f5903a});
    }
}
