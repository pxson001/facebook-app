package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: timeline_context_items */
public class UnsubscribeMessage implements TBase, Serializable, Cloneable {
    public static boolean f2998a = true;
    private static final TStruct f2999b = new TStruct("UnsubscribeMessage");
    private static final TField f3000c = new TField("unsubscribeTopics", (byte) 15, (short) 1);
    private static final TField f3001d = new TField("unsubscribeGenericTopics", (byte) 15, (short) 2);
    public final List<String> unsubscribeGenericTopics;
    public final List<Integer> unsubscribeTopics;

    public UnsubscribeMessage(List<Integer> list, List<String> list2) {
        this.unsubscribeTopics = list;
        this.unsubscribeGenericTopics = list2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UnsubscribeMessage)) {
            return false;
        }
        UnsubscribeMessage unsubscribeMessage = (UnsubscribeMessage) obj;
        boolean z = false;
        if (unsubscribeMessage != null) {
            Object obj2;
            Object obj3 = this.unsubscribeTopics != null ? 1 : null;
            if (unsubscribeMessage.unsubscribeTopics != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unsubscribeTopics.equals(unsubscribeMessage.unsubscribeTopics))) {
                if (this.unsubscribeGenericTopics != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (unsubscribeMessage.unsubscribeGenericTopics != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unsubscribeGenericTopics.equals(unsubscribeMessage.unsubscribeGenericTopics))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m4019a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.unsubscribeTopics == null || this.unsubscribeTopics == null)) {
            tProtocol.a(f3000c);
            tProtocol.a(new TList((byte) 8, this.unsubscribeTopics.size()));
            for (Integer intValue : this.unsubscribeTopics) {
                tProtocol.a(intValue.intValue());
            }
        }
        if (!(this.unsubscribeGenericTopics == null || this.unsubscribeGenericTopics == null)) {
            tProtocol.a(f3001d);
            tProtocol.a(new TList((byte) 11, this.unsubscribeGenericTopics.size()));
            for (String a : this.unsubscribeGenericTopics) {
                tProtocol.a(a);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4018a(1, f2998a);
    }

    public final String m4018a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("UnsubscribeMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.unsubscribeTopics != null) {
            stringBuilder.append(a);
            stringBuilder.append("unsubscribeTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unsubscribeTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.unsubscribeTopics, i + 1, z));
            }
            obj = null;
        }
        if (this.unsubscribeGenericTopics != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("unsubscribeGenericTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unsubscribeGenericTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.unsubscribeGenericTopics, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
