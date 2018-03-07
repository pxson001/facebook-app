package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;

/* compiled from: com.facebook.build_time */
public class FetchZeroInterstitialEligibilityParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroInterstitialEligibilityParams> CREATOR = new C05381();

    /* compiled from: com.facebook.build_time */
    final class C05381 implements Creator<FetchZeroInterstitialEligibilityParams> {
        C05381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroInterstitialEligibilityParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroInterstitialEligibilityParams[i];
        }
    }

    public FetchZeroInterstitialEligibilityParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str) {
        super(carrierAndSimMccMnc, str);
    }

    public FetchZeroInterstitialEligibilityParams(Parcel parcel) {
        super(parcel);
    }

    public final String m10656a() {
        return "fetchZeroInterstitialEligibilityParams";
    }

    public String toString() {
        return Objects.toStringHelper(FetchZeroInterstitialEligibilityParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroInterstitialEligibilityParams)) {
            return false;
        }
        FetchZeroInterstitialEligibilityParams fetchZeroInterstitialEligibilityParams = (FetchZeroInterstitialEligibilityParams) obj;
        if (Objects.equal(this.a, fetchZeroInterstitialEligibilityParams.a) && Objects.equal(this.b, fetchZeroInterstitialEligibilityParams.b)) {
            return true;
        }
        return false;
    }
}
