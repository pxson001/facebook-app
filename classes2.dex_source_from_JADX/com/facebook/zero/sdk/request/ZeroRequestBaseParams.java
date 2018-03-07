package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fonts/HelveticaNeue-Bold.ttf */
public abstract class ZeroRequestBaseParams implements Parcelable {
    public final CarrierAndSimMccMnc f23534a;
    public final String f23535b;

    public abstract String mo3447a();

    protected ZeroRequestBaseParams(CarrierAndSimMccMnc carrierAndSimMccMnc, String str) {
        this.f23534a = carrierAndSimMccMnc;
        this.f23535b = str;
    }

    protected ZeroRequestBaseParams(Parcel parcel) {
        this.f23534a = (CarrierAndSimMccMnc) parcel.readParcelable(CarrierAndSimMccMnc.class.getClassLoader());
        this.f23535b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f23534a, i);
        parcel.writeString(this.f23535b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f23534a, this.f23535b);
    }
}
