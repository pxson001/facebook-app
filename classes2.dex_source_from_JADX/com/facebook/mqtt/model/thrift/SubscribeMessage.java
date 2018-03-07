package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: fo_FO */
public class SubscribeMessage implements TBase, Serializable, Cloneable {
    public static boolean f23572a = true;
    private static final TStruct f23573b = new TStruct("SubscribeMessage");
    private static final TField f23574c = new TField("subscribeTopics", (byte) 15, (short) 1);
    private static final TField f23575d = new TField("subscribeGenericTopics", (byte) 15, (short) 2);
    public final List<SubscribeGenericTopic> subscribeGenericTopics;
    public final List<Integer> subscribeTopics;

    public SubscribeMessage(List<Integer> list, List<SubscribeGenericTopic> list2) {
        this.subscribeTopics = list;
        this.subscribeGenericTopics = list2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SubscribeMessage)) {
            return false;
        }
        SubscribeMessage subscribeMessage = (SubscribeMessage) obj;
        boolean z = false;
        if (subscribeMessage != null) {
            Object obj2;
            Object obj3 = this.subscribeTopics != null ? 1 : null;
            if (subscribeMessage.subscribeTopics != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.subscribeTopics.equals(subscribeMessage.subscribeTopics))) {
                if (this.subscribeGenericTopics != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (subscribeMessage.subscribeGenericTopics != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.subscribeGenericTopics.equals(subscribeMessage.subscribeGenericTopics))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void mo3464a(TProtocol tProtocol) {
        tProtocol.mo3468a();
        if (!(this.subscribeTopics == null || this.subscribeTopics == null)) {
            tProtocol.mo3472a(f23574c);
            tProtocol.mo3473a(new TList((byte) 8, this.subscribeTopics.size()));
            for (Integer intValue : this.subscribeTopics) {
                tProtocol.mo3470a(intValue.intValue());
            }
        }
        if (!(this.subscribeGenericTopics == null || this.subscribeGenericTopics == null)) {
            tProtocol.mo3472a(f23575d);
            tProtocol.mo3473a(new TList((byte) 12, this.subscribeGenericTopics.size()));
            for (SubscribeGenericTopic a : this.subscribeGenericTopics) {
                a.a(tProtocol);
            }
        }
        tProtocol.mo3480c();
        tProtocol.mo3479b();
    }

    public String toString() {
        return mo3463a(1, f23572a);
    }

    public final String mo3463a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SubscribeMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.subscribeTopics != null) {
            stringBuilder.append(a);
            stringBuilder.append("subscribeTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.subscribeTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.subscribeTopics, i + 1, z));
            }
            obj = null;
        }
        if (this.subscribeGenericTopics != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("subscribeGenericTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.subscribeGenericTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.subscribeGenericTopics, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
