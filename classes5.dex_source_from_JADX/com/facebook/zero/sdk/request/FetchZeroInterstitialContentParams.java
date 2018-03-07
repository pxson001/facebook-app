package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.common.jobscheduler.compat.jobIds */
public class FetchZeroInterstitialContentParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroInterstitialContentParams> CREATOR = new C05361();
    public final String f5895a;
    public final String f5896b;
    public final String f5897c;

    /* compiled from: com.facebook.common.jobscheduler.compat.jobIds */
    final class C05361 implements Creator<FetchZeroInterstitialContentParams> {
        C05361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroInterstitialContentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroInterstitialContentParams[i];
        }
    }

    public FetchZeroInterstitialContentParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2, String str3, String str4) {
        super(carrierAndSimMccMnc, str);
        this.f5895a = str2;
        this.f5896b = str3;
        this.f5897c = str4;
    }

    public FetchZeroInterstitialContentParams(Parcel parcel) {
        super(parcel);
        this.f5895a = parcel.readString();
        this.f5896b = parcel.readString();
        this.f5897c = parcel.readString();
    }

    public final String m10633a() {
        return "fetchZeroInterstitialContentParams";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5895a);
        parcel.writeString(this.f5896b);
        parcel.writeString(this.f5897c);
    }

    public String toString() {
        return Objects.toStringHelper(FetchZeroInterstitialContentParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("screenScale", this.f5895a).add("step", this.f5896b).add("action", this.f5897c).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroInterstitialContentParams)) {
            return false;
        }
        FetchZeroInterstitialContentParams fetchZeroInterstitialContentParams = (FetchZeroInterstitialContentParams) obj;
        if (Objects.equal(this.a, fetchZeroInterstitialContentParams.a) && Objects.equal(this.b, fetchZeroInterstitialContentParams.b) && Objects.equal(this.f5895a, fetchZeroInterstitialContentParams.f5895a) && Objects.equal(this.f5896b, fetchZeroInterstitialContentParams.f5895a) && Objects.equal(this.f5897c, fetchZeroInterstitialContentParams.f5895a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f5895a, this.f5896b, this.f5897c});
    }
}
