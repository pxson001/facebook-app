package com.facebook.zero.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.request.ZeroRequestBaseParams;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: sms_integration/ */
public final class FetchZeroHeaderRequestParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroHeaderRequestParams> CREATOR = new C01081();
    public final String f2106a;
    public final boolean f2107b;

    /* compiled from: sms_integration/ */
    final class C01081 implements Creator<FetchZeroHeaderRequestParams> {
        C01081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroHeaderRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroHeaderRequestParams[i];
        }
    }

    public FetchZeroHeaderRequestParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, String str2, boolean z) {
        super(carrierAndSimMccMnc, str);
        this.f2106a = str2;
        this.f2107b = z;
    }

    public FetchZeroHeaderRequestParams(Parcel parcel) {
        super(parcel);
        this.f2106a = parcel.readString();
        this.f2107b = parcel.readByte() != (byte) 0;
    }

    public final String m2203a() {
        return "fetchZeroHeaderRequestParams";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2106a);
        parcel.writeByte((byte) (this.f2107b ? 1 : 0));
    }

    public final String toString() {
        return Objects.toStringHelper(FetchZeroHeaderRequestParams.class).add("carrierAndSimMccMnc", this.a).add("networkType", this.b).add("machineId", this.f2106a).add("forceRefresh", String.valueOf(this.f2107b)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroHeaderRequestParams)) {
            return false;
        }
        FetchZeroHeaderRequestParams fetchZeroHeaderRequestParams = (FetchZeroHeaderRequestParams) obj;
        if (Objects.equal(this.a, fetchZeroHeaderRequestParams.a) && Objects.equal(this.b, fetchZeroHeaderRequestParams.b) && Objects.equal(this.f2106a, fetchZeroHeaderRequestParams.f2106a) && this.f2107b == fetchZeroHeaderRequestParams.f2107b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.a, this.b, this.f2106a, Boolean.valueOf(this.f2107b)});
    }
}
