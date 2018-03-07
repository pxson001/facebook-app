package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fonts/HelveticaNeue-Light.ttf */
public class FetchZeroTokenRequestParams extends ZeroRequestBaseParams {
    public static final Creator<FetchZeroTokenRequestParams> CREATOR = new C09631();
    public ZeroTokenType f23530a;
    public boolean f23531b;
    public String f23532c;
    public TokenRequestReason f23533d;

    /* compiled from: fonts/HelveticaNeue-Light.ttf */
    final class C09631 implements Creator<FetchZeroTokenRequestParams> {
        C09631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroTokenRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroTokenRequestParams[i];
        }
    }

    public FetchZeroTokenRequestParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str, ZeroTokenType zeroTokenType, boolean z, String str2, TokenRequestReason tokenRequestReason) {
        super(carrierAndSimMccMnc, str);
        this.f23530a = zeroTokenType;
        this.f23531b = z;
        this.f23532c = str2;
        this.f23533d = tokenRequestReason;
    }

    public FetchZeroTokenRequestParams(Parcel parcel) {
        boolean z = false;
        super(parcel);
        byte readByte = parcel.readByte();
        for (ZeroTokenType zeroTokenType : ZeroTokenType.values()) {
            if (zeroTokenType.getModeNumber() == readByte) {
                this.f23530a = zeroTokenType;
                break;
            }
        }
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.f23531b = z;
        this.f23532c = parcel.readString();
        this.f23533d = TokenRequestReason.fromString(parcel.readString());
        if (this.f23530a == null) {
            throw new IllegalArgumentException("Parcel mode did not match any known token type");
        }
    }

    public final String mo3447a() {
        return "fetchZeroTokenRequestParams";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f23530a.getModeNumber());
        parcel.writeByte((byte) (this.f23531b ? 1 : 0));
        parcel.writeString(this.f23532c);
        parcel.writeString(this.f23533d.toString());
    }

    public String toString() {
        return Objects.toStringHelper(FetchZeroTokenRequestParams.class).add("carrierAndSimMccMnc", (Object) this.f23534a).add("networkType", (Object) this.f23535b).add("tokenType", String.valueOf(this.f23530a)).add("fetchBackupRewriteRules", String.valueOf(this.f23531b)).add("tokenRequestReason", this.f23533d.toString()).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroTokenRequestParams)) {
            return false;
        }
        FetchZeroTokenRequestParams fetchZeroTokenRequestParams = (FetchZeroTokenRequestParams) obj;
        if (Objects.equal(this.f23534a, fetchZeroTokenRequestParams.f23534a) && Objects.equal(this.f23535b, fetchZeroTokenRequestParams.f23535b) && this.f23530a == fetchZeroTokenRequestParams.f23530a && this.f23531b == fetchZeroTokenRequestParams.f23531b && Objects.equal(this.f23532c, fetchZeroTokenRequestParams.f23532c) && Objects.equal(this.f23533d, fetchZeroTokenRequestParams.f23533d)) {
            return true;
        }
        return false;
    }
}
