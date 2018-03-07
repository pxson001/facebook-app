package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_info_review_item_hide */
public class TimeSyncRequest implements TBase, Serializable, Cloneable {
    public static boolean f2985a = true;
    private static final TStruct f2986b = new TStruct("TimeSyncRequest");
    private static final TField f2987c = new TField("time", (byte) 10, (short) 1);
    public final Long time;

    public TimeSyncRequest(Long l) {
        this.time = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TimeSyncRequest)) {
            return false;
        }
        TimeSyncRequest timeSyncRequest = (TimeSyncRequest) obj;
        boolean z = false;
        if (timeSyncRequest != null) {
            Object obj2 = this.time != null ? 1 : null;
            Object obj3;
            if (timeSyncRequest.time != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.time.equals(timeSyncRequest.time))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m4011a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.time != null) {
            tProtocol.a(f2987c);
            tProtocol.a(this.time.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4010a(1, f2985a);
    }

    public final String m4010a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("TimeSyncRequest");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("time");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.time == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.time, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
