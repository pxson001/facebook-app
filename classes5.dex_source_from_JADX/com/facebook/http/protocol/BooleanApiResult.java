package com.facebook.http.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;

/* compiled from: dialtone_wifi_interstitial_upgrade_button_click */
public class BooleanApiResult implements Parcelable {
    public static final Creator<BooleanApiResult> CREATOR = new C04821();
    public final boolean f5062a;

    /* compiled from: dialtone_wifi_interstitial_upgrade_button_click */
    final class C04821 implements Creator<BooleanApiResult> {
        C04821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BooleanApiResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new BooleanApiResult[i];
        }
    }

    public BooleanApiResult(boolean z) {
        this.f5062a = z;
    }

    public BooleanApiResult(Parcel parcel) {
        this.f5062a = ParcelUtil.m3827a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.m3826a(parcel, this.f5062a);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("value", this.f5062a).toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof BooleanApiResult) && this.f5062a == ((BooleanApiResult) obj).f5062a;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f5062a)});
    }
}
