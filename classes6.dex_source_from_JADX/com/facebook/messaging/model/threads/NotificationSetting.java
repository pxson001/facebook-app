package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateTimelineAppCollection */
public class NotificationSetting implements Parcelable {
    public static final Creator<NotificationSetting> CREATOR = new C01171();
    public static final NotificationSetting f2238a = new NotificationSetting(true, 0, false);
    public static final NotificationSetting f2239b = new NotificationSetting(false, 0, false);
    public final boolean f2240c;
    public final long f2241d;
    public final boolean f2242e;

    /* compiled from: updateTimelineAppCollection */
    final class C01171 implements Creator<NotificationSetting> {
        C01171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationSetting(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationSetting[i];
        }
    }

    public static NotificationSetting m3520a(long j) {
        return new NotificationSetting(true, j, false);
    }

    public static NotificationSetting m3521b(long j) {
        if (j == -1) {
            return f2239b;
        }
        if (j == 0) {
            return f2238a;
        }
        if (j < 0) {
            return new NotificationSetting(true, -j, true);
        }
        return new NotificationSetting(true, j, false);
    }

    private NotificationSetting(boolean z, long j, boolean z2) {
        this.f2240c = z;
        this.f2241d = j;
        this.f2242e = z2;
    }

    public NotificationSetting(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2240c = z;
        this.f2241d = parcel.readLong();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f2242e = z2;
    }

    public final long m3522a() {
        if (this.f2240c) {
            return this.f2241d;
        }
        return -1;
    }

    public final boolean m3523b() {
        return m3524c() == NotificationState.Enabled;
    }

    public final NotificationState m3524c() {
        if (this.f2240c) {
            return this.f2241d > System.currentTimeMillis() / 1000 ? NotificationState.TemporarilyMuted : NotificationState.Enabled;
        } else {
            return NotificationState.PermanentlyDisabled;
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("enabled", this.f2240c).add("mutedUntilSeconds", this.f2241d).add("automaticallyMuted", this.f2242e).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotificationSetting notificationSetting = (NotificationSetting) obj;
        if (this.f2242e != notificationSetting.f2242e) {
            return false;
        }
        if (this.f2240c != notificationSetting.f2240c) {
            return false;
        }
        if (this.f2241d != notificationSetting.f2241d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        if (this.f2240c) {
            i = 1;
        } else {
            i = 0;
        }
        i = ((i * 31) + ((int) (this.f2241d ^ (this.f2241d >>> 32)))) * 31;
        if (!this.f2242e) {
            i2 = 0;
        }
        return i + i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        if (this.f2240c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.f2241d);
        if (!this.f2242e) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public final ObjectNode m3525d() {
        return new ObjectNode(JsonNodeFactory.a).a("enabled", this.f2240c).a("mutedUntilSeconds", this.f2241d).a("automaticallyMuted", this.f2242e);
    }
}
