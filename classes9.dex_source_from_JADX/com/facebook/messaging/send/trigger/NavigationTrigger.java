package com.facebook.messaging.send.trigger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: defaultFundingAmount */
public class NavigationTrigger implements Parcelable {
    public static final Creator<NavigationTrigger> CREATOR = new C19861();
    private final boolean f16853a;
    private final String f16854b;
    @Nullable
    private final String f16855c;
    @Nullable
    private final String f16856d;

    /* compiled from: defaultFundingAmount */
    final class C19861 implements Creator<NavigationTrigger> {
        C19861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NavigationTrigger(parcel);
        }

        public final Object[] newArray(int i) {
            return new NavigationTrigger[i];
        }
    }

    @Nullable
    public static NavigationTrigger m16839a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return new NavigationTrigger(str, null, null, true);
    }

    public static NavigationTrigger m16841b(String str) {
        return new NavigationTrigger(str, null, null, false);
    }

    public static NavigationTrigger m16840a(String str, String str2) {
        return new NavigationTrigger(str, str2, null, false);
    }

    public NavigationTrigger(String str, @Nullable String str2, @Nullable String str3, boolean z) {
        Preconditions.checkNotNull(str);
        this.f16854b = str;
        this.f16855c = str2;
        this.f16856d = str3;
        this.f16853a = z;
    }

    public NavigationTrigger(Parcel parcel) {
        this.f16853a = parcel.readInt() == 0;
        this.f16854b = parcel.readString();
        this.f16855c = parcel.readString();
        this.f16856d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16853a ? 1 : 0);
        parcel.writeString(this.f16854b);
        parcel.writeString(this.f16855c);
        parcel.writeString(this.f16856d);
    }

    public String toString() {
        if (this.f16853a) {
            return this.f16854b;
        }
        StringBuilder append = new StringBuilder("2").append(":").append(this.f16854b);
        if (this.f16855c != null) {
            append.append(":").append(this.f16855c);
            if (this.f16856d != null) {
                append.append(":").append(this.f16856d);
            }
        }
        return append.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigationTrigger)) {
            return false;
        }
        NavigationTrigger navigationTrigger = (NavigationTrigger) obj;
        if (this.f16853a == navigationTrigger.f16853a && Objects.equal(this.f16854b, navigationTrigger.f16854b) && Objects.equal(this.f16855c, navigationTrigger.f16855c) && Objects.equal(this.f16856d, navigationTrigger.f16856d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (Boolean.valueOf(this.f16853a).hashCode() * 31) + this.f16854b.hashCode();
        if (this.f16855c != null) {
            hashCode = (hashCode * 31) + this.f16855c.hashCode();
        }
        if (this.f16856d != null) {
            return (hashCode * 31) + this.f16856d.hashCode();
        }
        return hashCode;
    }

    public int describeContents() {
        return 0;
    }
}
