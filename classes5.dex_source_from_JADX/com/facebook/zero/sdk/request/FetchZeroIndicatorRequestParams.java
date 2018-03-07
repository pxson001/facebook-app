package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.config.server.ACTION_SERVER_CONFIG_CHANGED */
public class FetchZeroIndicatorRequestParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroIndicatorRequestParams> CREATOR = new C05351();
    public final String f5894a;

    /* compiled from: com.facebook.config.server.ACTION_SERVER_CONFIG_CHANGED */
    final class C05351 implements Creator<FetchZeroIndicatorRequestParams> {
        C05351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroIndicatorRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroIndicatorRequestParams[i];
        }
    }

    public FetchZeroIndicatorRequestParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2) {
        super(carrierAndSimMccMnc, str);
        this.f5894a = str2;
    }

    public FetchZeroIndicatorRequestParams(Parcel parcel) {
        super(parcel);
        this.f5894a = parcel.readString();
    }

    public final String m10631a() {
        return "fetchZeroIndicatorParams";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5894a);
    }

    public String toString() {
        return Objects.toStringHelper(FetchZeroInterstitialContentParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("screenScale", this.f5894a).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroIndicatorRequestParams)) {
            return false;
        }
        FetchZeroIndicatorRequestParams fetchZeroIndicatorRequestParams = (FetchZeroIndicatorRequestParams) obj;
        if (Objects.equal(this.a, fetchZeroIndicatorRequestParams.a) && Objects.equal(this.b, fetchZeroIndicatorRequestParams.b) && Objects.equal(this.f5894a, fetchZeroIndicatorRequestParams.f5894a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f5894a});
    }

    public final String m10632b() {
        return this.f5894a;
    }
}
