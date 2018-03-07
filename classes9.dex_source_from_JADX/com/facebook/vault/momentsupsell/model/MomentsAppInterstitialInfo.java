package com.facebook.vault.momentsupsell.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_profiles_protected */
public class MomentsAppInterstitialInfo implements Parcelable {
    public static final Creator<MomentsAppInterstitialInfo> CREATOR = new C01721();
    public final String f1789a;
    public final String f1790b;
    public final String f1791c;
    public final String f1792d;
    public final ImmutableList<String> f1793e;
    public final String f1794f;
    public final String f1795g;
    public final String f1796h;
    public final String f1797i;
    public final boolean f1798j;

    /* compiled from: thread_profiles_protected */
    final class C01721 implements Creator<MomentsAppInterstitialInfo> {
        C01721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MomentsAppInterstitialInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new MomentsAppInterstitialInfo[i];
        }
    }

    /* compiled from: thread_profiles_protected */
    public class Builder {
        public String f1779a;
        public String f1780b;
        public String f1781c;
        public String f1782d;
        public List<String> f1783e;
        public String f1784f;
        public String f1785g;
        public String f1786h;
        public String f1787i;
        public boolean f1788j;
    }

    public MomentsAppInterstitialInfo(Builder builder) {
        this.f1789a = builder.f1779a;
        this.f1790b = builder.f1780b;
        this.f1791c = builder.f1781c;
        this.f1792d = builder.f1782d;
        this.f1793e = builder.f1783e == null ? null : ImmutableList.copyOf(builder.f1783e);
        this.f1794f = builder.f1784f;
        this.f1795g = builder.f1785g;
        this.f1796h = builder.f1786h;
        this.f1797i = builder.f1787i;
        this.f1798j = builder.f1788j;
    }

    public String toString() {
        return Objects.toStringHelper(MomentsAppInterstitialInfo.class).add("title", this.f1789a).add("description", this.f1790b).add("imageUrl", this.f1791c).add("socialContext", this.f1792d).add("facepileImageUrls", this.f1793e).add("actionText", this.f1794f).add("actionUrl", this.f1795g).add("helpText", this.f1796h).add("helpUrl", this.f1797i).add("xoutBlocksTab", this.f1798j).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MomentsAppInterstitialInfo)) {
            return false;
        }
        MomentsAppInterstitialInfo momentsAppInterstitialInfo = (MomentsAppInterstitialInfo) obj;
        if (Objects.equal(this.f1789a, momentsAppInterstitialInfo.f1789a) && Objects.equal(this.f1790b, momentsAppInterstitialInfo.f1790b) && Objects.equal(this.f1791c, momentsAppInterstitialInfo.f1791c) && Objects.equal(this.f1792d, momentsAppInterstitialInfo.f1792d) && Objects.equal(this.f1793e, momentsAppInterstitialInfo.f1793e) && Objects.equal(this.f1794f, momentsAppInterstitialInfo.f1794f) && Objects.equal(this.f1795g, momentsAppInterstitialInfo.f1795g) && Objects.equal(this.f1796h, momentsAppInterstitialInfo.f1796h) && Objects.equal(this.f1797i, momentsAppInterstitialInfo.f1797i) && this.f1798j == momentsAppInterstitialInfo.f1798j) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1789a, this.f1790b, this.f1791c, this.f1792d, this.f1793e, this.f1794f, this.f1795g, this.f1796h, this.f1797i, Boolean.valueOf(this.f1798j)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1789a);
        parcel.writeString(this.f1790b);
        parcel.writeString(this.f1791c);
        parcel.writeString(this.f1792d);
        parcel.writeStringList(this.f1793e);
        parcel.writeString(this.f1794f);
        parcel.writeString(this.f1795g);
        parcel.writeString(this.f1796h);
        parcel.writeString(this.f1797i);
        parcel.writeInt(this.f1798j ? 1 : 0);
    }

    public MomentsAppInterstitialInfo(Parcel parcel) {
        this.f1789a = parcel.readString();
        this.f1790b = parcel.readString();
        this.f1791c = parcel.readString();
        this.f1792d = parcel.readString();
        this.f1793e = ParcelableHelper.m1904a(parcel);
        this.f1794f = parcel.readString();
        this.f1795g = parcel.readString();
        this.f1796h = parcel.readString();
        this.f1797i = parcel.readString();
        this.f1798j = parcel.readInt() != 0;
    }
}
