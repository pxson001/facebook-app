package com.facebook.vault.momentsupsell.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_promo_status */
public class MomentsAppInfo implements Parcelable {
    public static final Creator<MomentsAppInfo> CREATOR = new C01711();
    public final boolean f1772a;
    public final boolean f1773b;
    public final MomentsAppInterstitialInfo f1774c;
    public final boolean f1775d;
    public final boolean f1776e;
    public final boolean f1777f;
    public final MomentsAppTabInfo f1778g;

    /* compiled from: thread_promo_status */
    final class C01711 implements Creator<MomentsAppInfo> {
        C01711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MomentsAppInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new MomentsAppInfo[i];
        }
    }

    /* compiled from: thread_promo_status */
    public class Builder {
        public boolean f1765a;
        public boolean f1766b;
        public MomentsAppInterstitialInfo f1767c;
        public boolean f1768d;
        public boolean f1769e;
        public boolean f1770f;
        public MomentsAppTabInfo f1771g;

        public final MomentsAppInfo m1903a() {
            return new MomentsAppInfo(this);
        }
    }

    public MomentsAppInfo(Builder builder) {
        this.f1772a = builder.f1765a;
        this.f1773b = builder.f1766b;
        this.f1774c = builder.f1767c;
        this.f1775d = builder.f1768d;
        this.f1776e = builder.f1769e;
        this.f1777f = builder.f1770f;
        this.f1778g = builder.f1771g;
    }

    public String toString() {
        return Objects.toStringHelper(MomentsAppInfo.class).add("hasInstalledMoments", this.f1772a).add("showInterstitial", this.f1773b).add("interstitialInfo", this.f1774c).add("showMomentsTab", this.f1775d).add("shouldRemoveTab", this.f1776e).add("viewerCanEnable", this.f1777f).add("tabInfo", this.f1778g).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MomentsAppInfo)) {
            return false;
        }
        MomentsAppInfo momentsAppInfo = (MomentsAppInfo) obj;
        if (this.f1772a == momentsAppInfo.f1772a && this.f1773b == momentsAppInfo.f1773b && Objects.equal(this.f1774c, momentsAppInfo.f1774c) && this.f1775d == momentsAppInfo.f1775d && this.f1776e == momentsAppInfo.f1776e && this.f1777f == momentsAppInfo.f1777f && Objects.equal(this.f1778g, momentsAppInfo.f1778g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f1772a), Boolean.valueOf(this.f1773b), this.f1774c, Boolean.valueOf(this.f1775d), Boolean.valueOf(this.f1776e), Boolean.valueOf(this.f1777f), this.f1778g});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f1772a ? 1 : 0);
        if (this.f1773b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f1774c, 0);
        if (this.f1775d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f1776e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f1777f) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeParcelable(this.f1778g, 0);
    }

    public MomentsAppInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f1772a = parcel.readInt() != 0;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1773b = z;
        this.f1774c = (MomentsAppInterstitialInfo) parcel.readParcelable(MomentsAppInterstitialInfo.class.getClassLoader());
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1775d = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f1776e = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f1777f = z2;
        this.f1778g = (MomentsAppTabInfo) parcel.readParcelable(MomentsAppTabInfo.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
