package com.facebook.messaging.media.upload.udp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: last_call_volume */
public class UDPServerConfig implements Parcelable {
    public static final Creator<UDPServerConfig> CREATOR = new C13521();
    public final String f12207a;
    public final String f12208b;
    public final String f12209c;
    public final int f12210d;

    /* compiled from: last_call_volume */
    final class C13521 implements Creator<UDPServerConfig> {
        C13521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UDPServerConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new UDPServerConfig[i];
        }
    }

    public UDPServerConfig(String str, String str2, String str3, int i) {
        this.f12207a = str;
        this.f12208b = str2;
        this.f12209c = str3;
        this.f12210d = i;
    }

    public static UDPServerConfig m12706a(JsonNode jsonNode) {
        return new UDPServerConfig(JSONUtil.b(jsonNode.b("turn_user_id")), JSONUtil.b(jsonNode.b("turn_password")), jsonNode.b("turn_server_ipv6") == null ? JSONUtil.b(jsonNode.b("turn_server_ipv4")) : JSONUtil.b(jsonNode.b("turn_server_ipv6")), JSONUtil.d(jsonNode.b("turn_server_port")));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12207a);
        parcel.writeString(this.f12208b);
        parcel.writeString(this.f12209c);
        parcel.writeInt(this.f12210d);
    }
}
