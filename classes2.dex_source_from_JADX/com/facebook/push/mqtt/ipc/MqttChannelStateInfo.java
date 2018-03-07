package com.facebook.push.mqtt.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: first_body_byte_flushed */
public class MqttChannelStateInfo implements Parcelable {
    public static final Creator<MqttChannelStateInfo> CREATOR = new C09681();
    public final ConnectionState f23628a;
    private final long f23629b;
    public final long f23630c;
    public final long f23631d;
    public final boolean f23632e;

    /* compiled from: first_body_byte_flushed */
    public enum ConnectionState {
        CONNECTING,
        CONNECTED,
        DISCONNECTED;

        public static ConnectionState fromOrdinal(int i) {
            return values()[i];
        }
    }

    /* compiled from: first_body_byte_flushed */
    final class C09681 implements Creator<MqttChannelStateInfo> {
        C09681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            ConnectionState fromOrdinal = ConnectionState.fromOrdinal(parcel.readInt());
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            return new MqttChannelStateInfo(fromOrdinal, readLong, readLong2, readLong3, zArr[0]);
        }

        public final Object[] newArray(int i) {
            return new MqttChannelStateInfo[i];
        }
    }

    public MqttChannelStateInfo(ConnectionState connectionState, long j, long j2, long j3, boolean z) {
        this.f23628a = connectionState;
        this.f23629b = j;
        this.f23630c = j2;
        this.f23631d = j3;
        this.f23632e = z;
    }

    public final ConnectionState m32032a() {
        return this.f23628a;
    }

    public final long m32033b() {
        return this.f23629b;
    }

    public final long m32034c() {
        return this.f23630c;
    }

    public final long m32035d() {
        return this.f23631d;
    }

    public final boolean m32036e() {
        return this.f23632e;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("mConnectionState", this.f23628a).add("mServiceGeneratedMs", this.f23629b).add("mLastConnectionMs", this.f23630c).add("mLastDisconnectMs", this.f23631d).add("mClockSkewDetected", this.f23632e).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MqttChannelStateInfo mqttChannelStateInfo = (MqttChannelStateInfo) obj;
        if (this.f23628a == mqttChannelStateInfo.f23628a && this.f23630c == mqttChannelStateInfo.f23630c && this.f23631d == mqttChannelStateInfo.f23631d && this.f23632e == mqttChannelStateInfo.f23632e) {
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f23628a.ordinal());
        parcel.writeLong(this.f23629b);
        parcel.writeLong(this.f23630c);
        parcel.writeLong(this.f23631d);
        parcel.writeBooleanArray(new boolean[]{this.f23632e});
    }
}
