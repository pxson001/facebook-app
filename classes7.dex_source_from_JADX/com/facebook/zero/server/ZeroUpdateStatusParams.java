package com.facebook.zero.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.request.ZeroRequestBaseParams;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: wvtt */
public final class ZeroUpdateStatusParams extends ZeroRequestBaseParams {
    public static final Creator<ZeroUpdateStatusParams> CREATOR = new C00321();
    public final String f221a;

    /* compiled from: wvtt */
    final class C00321 implements Creator<ZeroUpdateStatusParams> {
        C00321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroUpdateStatusParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroUpdateStatusParams[i];
        }
    }

    public ZeroUpdateStatusParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2) {
        super(carrierAndSimMccMnc, str);
        this.f221a = str2;
    }

    public ZeroUpdateStatusParams(Parcel parcel) {
        super(parcel);
        this.f221a = parcel.readString();
    }

    public final String m228a() {
        return "zeroUpdateStatusParams";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f221a);
    }

    public final String toString() {
        return Objects.toStringHelper(ZeroUpdateStatusParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("statusToUpdate", this.f221a).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ZeroUpdateStatusParams)) {
            return false;
        }
        ZeroUpdateStatusParams zeroUpdateStatusParams = (ZeroUpdateStatusParams) obj;
        if (Objects.equal(this.a, zeroUpdateStatusParams.a) && Objects.equal(this.b, zeroUpdateStatusParams.b) && Objects.equal(this.f221a, zeroUpdateStatusParams.f221a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f221a});
    }
}
