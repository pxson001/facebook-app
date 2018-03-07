package com.facebook.presence;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: image_format */
public class PresenceItem implements Parcelable {
    public static final Creator<PresenceItem> CREATOR = new C09891();
    public final UserKey f11173a;
    public final boolean f11174b;
    public final long f11175c;
    public final int f11176d;
    public final Long f11177e;

    /* compiled from: image_format */
    final class C09891 implements Creator<PresenceItem> {
        C09891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PresenceItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new PresenceItem[i];
        }
    }

    public PresenceItem(UserKey userKey, boolean z, long j, int i, @Nullable Long l) {
        this.f11173a = userKey;
        this.f11174b = z;
        this.f11175c = j;
        this.f11176d = i;
        this.f11177e = l;
    }

    public PresenceItem(Parcel parcel) {
        this.f11173a = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f11174b = ParcelUtil.a(parcel);
        this.f11175c = parcel.readLong();
        this.f11176d = parcel.readInt();
        this.f11177e = (Long) parcel.readValue(Long.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11173a, i);
        ParcelUtil.a(parcel, this.f11174b);
        parcel.writeLong(this.f11175c);
        parcel.writeInt(this.f11176d);
        parcel.writeValue(this.f11177e);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("user", this.f11173a).add("active", this.f11174b).add("last active", this.f11175c).add("active client bits", this.f11176d).add("voip capability bits", this.f11177e).toString();
    }
}
