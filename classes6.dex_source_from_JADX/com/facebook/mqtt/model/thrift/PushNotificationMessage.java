package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_review_item_type */
public class PushNotificationMessage implements TBase, Serializable, Cloneable {
    public static boolean f2943a = true;
    private static final TStruct f2944b = new TStruct("PushNotificationMessage");
    private static final TField f2945c = new TField("fbpushdata", (byte) 12, (short) 1);
    public final AndroidNotificationPayload fbpushdata;

    private PushNotificationMessage(AndroidNotificationPayload androidNotificationPayload) {
        this.fbpushdata = androidNotificationPayload;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PushNotificationMessage)) {
            return false;
        }
        PushNotificationMessage pushNotificationMessage = (PushNotificationMessage) obj;
        boolean z = false;
        if (pushNotificationMessage != null) {
            Object obj2 = this.fbpushdata != null ? 1 : null;
            Object obj3;
            if (pushNotificationMessage.fbpushdata != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.fbpushdata.m3963a(pushNotificationMessage.fbpushdata))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static PushNotificationMessage m3997b(TProtocol tProtocol) {
        AndroidNotificationPayload androidNotificationPayload = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        androidNotificationPayload = AndroidNotificationPayload.m3960b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new PushNotificationMessage(androidNotificationPayload);
        }
    }

    public final void m3999a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.fbpushdata != null) {
            tProtocol.a(f2945c);
            this.fbpushdata.m3962a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3998a(1, f2943a);
    }

    public final String m3998a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PushNotificationMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("fbpushdata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.fbpushdata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.fbpushdata, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
