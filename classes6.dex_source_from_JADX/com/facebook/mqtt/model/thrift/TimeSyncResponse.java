package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_featured_content */
public class TimeSyncResponse implements TBase, Serializable, Cloneable {
    public static boolean f2988a = true;
    private static final TStruct f2989b = new TStruct("TimeSyncResponse");
    private static final TField f2990c = new TField("time", (byte) 10, (short) 1);
    public final Long time;

    private TimeSyncResponse(Long l) {
        this.time = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TimeSyncResponse)) {
            return false;
        }
        TimeSyncResponse timeSyncResponse = (TimeSyncResponse) obj;
        boolean z = false;
        if (timeSyncResponse != null) {
            Object obj2 = this.time != null ? 1 : null;
            Object obj3;
            if (timeSyncResponse.time != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.time.equals(timeSyncResponse.time))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static TimeSyncResponse m4012b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new TimeSyncResponse(l);
        }
    }

    public final void m4014a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.time != null) {
            tProtocol.a(f2990c);
            tProtocol.a(this.time.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4013a(1, f2988a);
    }

    public final String m4013a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("TimeSyncResponse");
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
