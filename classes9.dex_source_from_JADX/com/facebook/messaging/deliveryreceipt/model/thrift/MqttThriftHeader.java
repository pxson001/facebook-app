package com.facebook.messaging.deliveryreceipt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: map_address */
public class MqttThriftHeader implements TBase, Serializable, Cloneable {
    public static boolean f10888a = true;
    private static final TStruct f10889b = new TStruct("MqttThriftHeader");
    private static final TField f10890c = new TField("traceInfo", (byte) 11, (short) 1);
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

    public final void m11307a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.traceInfo == null || this.traceInfo == null)) {
            tProtocol.a(f10890c);
            tProtocol.a(this.traceInfo);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m11306a(1, f10888a);
    }

    public final String m11306a(int i, boolean z) {
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
