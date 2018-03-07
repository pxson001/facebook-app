package com.facebook.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: gk */
public class MqttThriftHeader implements TBase, Serializable, Cloneable {
    public static boolean f11716a = true;
    private static final TStruct f11717b = new TStruct("MqttThriftHeader");
    private static final TField f11718c = new TField("traceInfo", (byte) 11, (short) 1);
    public final String traceInfo;

    public MqttThriftHeader(String str) {
        this.traceInfo = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MqttThriftHeader)) {
            return false;
        }
        MqttThriftHeader mqttThriftHeader = (MqttThriftHeader) obj;
        boolean z = false;
        if (mqttThriftHeader != null) {
            Object obj2 = this.traceInfo != null ? 1 : null;
            Object obj3;
            if (mqttThriftHeader.traceInfo != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.traceInfo.equals(mqttThriftHeader.traceInfo))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static MqttThriftHeader m12262b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new MqttThriftHeader(str);
        }
    }

    public final void m12264a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.traceInfo == null || this.traceInfo == null)) {
            tProtocol.a(f11718c);
            tProtocol.a(this.traceInfo);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m12263a(1, f11716a);
    }

    public final String m12263a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("MqttThriftHeader");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.traceInfo != null) {
            stringBuilder.append(a);
            stringBuilder.append("traceInfo");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.traceInfo == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.traceInfo, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
