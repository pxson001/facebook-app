package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: tmp */
public class ConnPublishMessage implements TBase, Serializable, Cloneable {
    public static boolean f2878a = true;
    private static final TStruct f2879b = new TStruct("ConnPublishMessage");
    private static final TField f2880c = new TField("topic", (byte) 11, (short) 1);
    private static final TField f2881d = new TField("messageId", (byte) 8, (short) 2);
    private static final TField f2882e = new TField("payload", (byte) 11, (short) 3);
    public final Integer messageId;
    public final byte[] payload;
    public final String topic;

    public ConnPublishMessage(String str, Integer num, byte[] bArr) {
        this.topic = str;
        this.messageId = num;
        this.payload = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ConnPublishMessage)) {
            return false;
        }
        ConnPublishMessage connPublishMessage = (ConnPublishMessage) obj;
        boolean z = false;
        if (connPublishMessage != null) {
            Object obj2;
            Object obj3 = this.topic != null ? 1 : null;
            if (connPublishMessage.topic != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.topic.equals(connPublishMessage.topic))) {
                if (this.messageId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (connPublishMessage.messageId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageId.equals(connPublishMessage.messageId))) {
                    if (this.payload != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (connPublishMessage.payload != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.payload, connPublishMessage.payload))) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3972a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.topic != null) {
            tProtocol.a(f2880c);
            tProtocol.a(this.topic);
        }
        if (this.messageId != null) {
            tProtocol.a(f2881d);
            tProtocol.a(this.messageId.intValue());
        }
        if (this.payload != null) {
            tProtocol.a(f2882e);
            tProtocol.a(this.payload);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3971a(1, f2878a);
    }

    public final String m3971a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ConnPublishMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("topic");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.topic == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.topic, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("messageId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.messageId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.messageId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("payload");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.payload == null) {
            stringBuilder.append("null");
        } else {
            int min = Math.min(this.payload.length, 128);
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(Integer.toHexString(this.payload[i2]).length() > 1 ? Integer.toHexString(this.payload[i2]).substring(Integer.toHexString(this.payload[i2]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.payload[i2]).toUpperCase());
            }
            if (this.payload.length > 128) {
                stringBuilder.append(" ...");
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
