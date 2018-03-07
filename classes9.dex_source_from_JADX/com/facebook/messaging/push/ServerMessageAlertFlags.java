package com.facebook.messaging.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: dest_coordinates */
public class ServerMessageAlertFlags implements Parcelable {
    public static final Creator<ServerMessageAlertFlags> CREATOR = new C19321();
    public final boolean f16398a;
    public final boolean f16399b;
    public final boolean f16400c;
    public final boolean f16401d;

    /* compiled from: dest_coordinates */
    final class C19321 implements Creator<ServerMessageAlertFlags> {
        C19321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ServerMessageAlertFlags(parcel);
        }

        public final Object[] newArray(int i) {
            return new ServerMessageAlertFlags[i];
        }
    }

    /* compiled from: dest_coordinates */
    public class Builder {
        public boolean f16394a;
        public boolean f16395b;
        public boolean f16396c;
        public boolean f16397d;

        public final ServerMessageAlertFlags m16462a() {
            return new ServerMessageAlertFlags(this.f16394a, this.f16395b, this.f16396c, this.f16397d);
        }
    }

    public ServerMessageAlertFlags(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f16398a = z;
        this.f16399b = z2;
        this.f16400c = z3;
        this.f16401d = z4;
    }

    public ServerMessageAlertFlags(Parcel parcel) {
        this.f16398a = ParcelUtil.a(parcel);
        this.f16399b = ParcelUtil.a(parcel);
        this.f16400c = ParcelUtil.a(parcel);
        this.f16401d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f16398a);
        ParcelUtil.a(parcel, this.f16399b);
        ParcelUtil.a(parcel, this.f16400c);
        ParcelUtil.a(parcel, this.f16401d);
    }

    public String toString() {
        return Objects.toStringHelper(ServerMessageAlertFlags.class).add("isDisableSound", this.f16398a).add("isDisableVibrate", this.f16399b).add("isDisableLightScreen", this.f16400c).add("isNotifyAggressively", this.f16401d).toString();
    }
}
