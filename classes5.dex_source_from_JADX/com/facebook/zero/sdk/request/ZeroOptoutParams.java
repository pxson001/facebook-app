package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.abtest.action.CLEAR_CACHE */
public class ZeroOptoutParams extends ZeroRequestBaseParams {
    public static final Creator<ZeroOptoutParams> CREATOR = new C05451();

    /* compiled from: com.facebook.abtest.action.CLEAR_CACHE */
    final class C05451 implements Creator<ZeroOptoutParams> {
        C05451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroOptoutParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroOptoutParams[i];
        }
    }

    public ZeroOptoutParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str) {
        super(carrierAndSimMccMnc, str);
    }

    public ZeroOptoutParams(Parcel parcel) {
        super(parcel);
    }

    public final String m10690a() {
        return "zeroOptoutParams";
    }

    public String toString() {
        return Objects.toStringHelper(ZeroOptoutParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZeroOptoutParams)) {
            return false;
        }
        ZeroOptoutParams zeroOptoutParams = (ZeroOptoutParams) obj;
        if (Objects.equal(this.a, zeroOptoutParams.a) && Objects.equal(this.b, zeroOptoutParams.b)) {
            return true;
        }
        return false;
    }
}
