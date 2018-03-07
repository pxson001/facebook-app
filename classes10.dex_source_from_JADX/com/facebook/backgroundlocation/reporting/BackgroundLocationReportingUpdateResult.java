package com.facebook.backgroundlocation.reporting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: dirty */
public class BackgroundLocationReportingUpdateResult implements Parcelable {
    public static final Creator<BackgroundLocationReportingUpdateResult> CREATOR = new C20801();
    public final boolean f14902a;
    public final boolean f14903b;
    public final boolean f14904c;

    /* compiled from: dirty */
    final class C20801 implements Creator<BackgroundLocationReportingUpdateResult> {
        C20801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BackgroundLocationReportingUpdateResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackgroundLocationReportingUpdateResult[i];
        }
    }

    public BackgroundLocationReportingUpdateResult(boolean z, boolean z2, boolean z3) {
        this.f14902a = z;
        this.f14903b = z2;
        this.f14904c = z3;
    }

    public BackgroundLocationReportingUpdateResult(Parcel parcel) {
        this.f14902a = ParcelUtil.a(parcel);
        this.f14903b = ParcelUtil.a(parcel);
        this.f14904c = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f14902a);
        ParcelUtil.a(parcel, this.f14903b);
        ParcelUtil.a(parcel, this.f14904c);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("didUpdateSucceed", this.f14902a).add("isLocationHistoryEnabled", this.f14903b).add("isBestDevice", this.f14904c).toString();
    }
}
