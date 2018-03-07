package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.base.activity.ReactFragmentActivity */
public class FetchZeroOptinContentRequestParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroOptinContentRequestParams> CREATOR = new C05401();
    public final String f5900a;

    /* compiled from: com.facebook.base.activity.ReactFragmentActivity */
    final class C05401 implements Creator<FetchZeroOptinContentRequestParams> {
        C05401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroOptinContentRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroOptinContentRequestParams[i];
        }
    }

    public FetchZeroOptinContentRequestParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2) {
        super(carrierAndSimMccMnc, str);
        this.f5900a = str2;
    }

    public FetchZeroOptinContentRequestParams(Parcel parcel) {
        super(parcel);
        this.f5900a = parcel.readString();
    }

    public final String m10663a() {
        return "fetchZeroOptinContentRequestParams";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5900a);
    }

    public String toString() {
        return Objects.toStringHelper(FetchZeroOptinContentRequestParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("screenScale", this.f5900a).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroOptinContentRequestParams)) {
            return false;
        }
        FetchZeroOptinContentRequestParams fetchZeroOptinContentRequestParams = (FetchZeroOptinContentRequestParams) obj;
        if (Objects.equal(this.a, fetchZeroOptinContentRequestParams.a) && Objects.equal(this.b, fetchZeroOptinContentRequestParams.b) && Objects.equal(this.f5900a, fetchZeroOptinContentRequestParams.f5900a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f5900a});
    }
}
