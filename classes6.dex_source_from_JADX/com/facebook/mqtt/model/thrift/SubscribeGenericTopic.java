package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_photo_widget */
public class SubscribeGenericTopic implements TBase, Serializable, Cloneable {
    public static boolean f2976a = true;
    private static final TStruct f2977b = new TStruct("SubscribeGenericTopic");
    private static final TField f2978c = new TField("topicName", (byte) 11, (short) 1);
    private static final TField f2979d = new TField("qualityOfService", (byte) 8, (short) 2);
    public final Integer qualityOfService;
    public final String topicName;

    public SubscribeGenericTopic(String str, Integer num) {
        this.topicName = str;
        this.qualityOfService = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SubscribeGenericTopic)) {
            return false;
        }
        SubscribeGenericTopic subscribeGenericTopic = (SubscribeGenericTopic) obj;
        boolean z = false;
        if (subscribeGenericTopic != null) {
            Object obj2;
            Object obj3 = this.topicName != null ? 1 : null;
            if (subscribeGenericTopic.topicName != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.topicName.equals(subscribeGenericTopic.topicName))) {
                if (this.qualityOfService != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (subscribeGenericTopic.qualityOfService != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.qualityOfService.equals(subscribeGenericTopic.qualityOfService))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m4007a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.topicName != null) {
            tProtocol.a(f2978c);
            tProtocol.a(this.topicName);
        }
        if (this.qualityOfService != null) {
            tProtocol.a(f2979d);
            tProtocol.a(this.qualityOfService.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4006a(1, f2976a);
    }

    public final String m4006a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SubscribeGenericTopic");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("topicName");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.topicName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.topicName, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("qualityOfService");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.qualityOfService == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.qualityOfService, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
