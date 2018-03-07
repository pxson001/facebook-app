package com.facebook.ipc.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: THIRD_PARTY_APP_VIA_INTENT */
public class MediaIdKey implements Parcelable {
    public static final Creator<MediaIdKey> CREATOR = new C13491();
    private final String f14079a;
    public final long f14080b;

    /* compiled from: THIRD_PARTY_APP_VIA_INTENT */
    final class C13491 implements Creator<MediaIdKey> {
        C13491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaIdKey(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaIdKey[i];
        }
    }

    public MediaIdKey(@Nullable String str, long j) {
        if (str == null) {
            str = "";
        }
        this.f14079a = str;
        if (j <= 0) {
            j = 0;
        }
        this.f14080b = j;
    }

    public String toString() {
        return String.format(Locale.US, "%d%c%s", new Object[]{Long.valueOf(this.f14080b), Character.valueOf('|'), this.f14079a});
    }

    public static MediaIdKey m23449a(String str) {
        int indexOf = ((String) Preconditions.checkNotNull(str)).indexOf(124);
        if (indexOf >= 0) {
            return new MediaIdKey(str.substring(indexOf + 1), Long.parseLong(str.substring(0, indexOf)));
        }
        throw new IllegalArgumentException("MediaIdKey.valueOf: " + str);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f14080b), this.f14079a});
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaIdKey mediaIdKey = (MediaIdKey) obj;
        if (this.f14080b == 0 || this.f14080b != mediaIdKey.f14080b) {
            return this.f14079a.equals(mediaIdKey.f14079a);
        }
        return true;
    }

    public MediaIdKey(Parcel parcel) {
        this.f14079a = parcel.readString();
        this.f14080b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14079a);
        parcel.writeLong(this.f14080b);
    }
}
