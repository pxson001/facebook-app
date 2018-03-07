package com.facebook.vault.momentsupsell.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_msg_ids */
public class MomentsAppTabInfo implements Parcelable {
    public static final Creator<MomentsAppTabInfo> CREATOR = new C01731();
    private final int f1803a;
    public final ImmutableList<String> f1804b;
    private final String f1805c;
    private final String f1806d;

    /* compiled from: thread_msg_ids */
    final class C01731 implements Creator<MomentsAppTabInfo> {
        C01731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MomentsAppTabInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new MomentsAppTabInfo[i];
        }
    }

    /* compiled from: thread_msg_ids */
    public class Builder {
        public int f1799a;
        public List<String> f1800b;
        public String f1801c;
        public String f1802d;
    }

    public MomentsAppTabInfo(Builder builder) {
        this.f1803a = builder.f1799a;
        this.f1804b = builder.f1800b == null ? null : ImmutableList.copyOf(builder.f1800b);
        this.f1805c = builder.f1801c;
        this.f1806d = builder.f1802d;
    }

    public String toString() {
        return Objects.toStringHelper(MomentsAppTabInfo.class).add("badgeCount", this.f1803a).add("photoMemImages", this.f1804b).add("actionText", this.f1805c).add("actionUrl", this.f1806d).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MomentsAppTabInfo)) {
            return false;
        }
        MomentsAppTabInfo momentsAppTabInfo = (MomentsAppTabInfo) obj;
        if (this.f1803a == momentsAppTabInfo.f1803a && Objects.equal(this.f1804b, momentsAppTabInfo.f1804b) && Objects.equal(this.f1805c, momentsAppTabInfo.f1805c) && Objects.equal(this.f1806d, momentsAppTabInfo.f1806d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f1803a), this.f1804b, this.f1805c, this.f1806d});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1803a);
        parcel.writeStringList(this.f1804b);
        parcel.writeString(this.f1805c);
        parcel.writeString(this.f1806d);
    }

    public MomentsAppTabInfo(Parcel parcel) {
        this.f1803a = parcel.readInt();
        this.f1804b = ParcelableHelper.m1904a(parcel);
        this.f1805c = parcel.readString();
        this.f1806d = parcel.readString();
    }
}
