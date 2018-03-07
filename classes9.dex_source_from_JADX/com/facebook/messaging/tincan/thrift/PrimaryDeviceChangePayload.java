package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: clearPrimaryCardIdStatus */
public class PrimaryDeviceChangePayload implements TBase, Serializable, Cloneable {
    public static boolean f18169a = true;
    private static final TStruct f18170b = new TStruct("PrimaryDeviceChangePayload");
    private static final TField f18171c = new TField("msg_to", (byte) 12, (short) 2);
    private static final TField f18172d = new TField("suggested_codename", (byte) 11, (short) 3);
    public final MessagingCollectionAddress msg_to;
    public final String suggested_codename;

    public PrimaryDeviceChangePayload(MessagingCollectionAddress messagingCollectionAddress, String str) {
        this.msg_to = messagingCollectionAddress;
        this.suggested_codename = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PrimaryDeviceChangePayload)) {
            return false;
        }
        PrimaryDeviceChangePayload primaryDeviceChangePayload = (PrimaryDeviceChangePayload) obj;
        boolean z = false;
        if (primaryDeviceChangePayload != null) {
            Object obj2;
            Object obj3 = this.msg_to != null ? 1 : null;
            if (primaryDeviceChangePayload.msg_to != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.msg_to.m18090a(primaryDeviceChangePayload.msg_to))) {
                if (this.suggested_codename != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (primaryDeviceChangePayload.suggested_codename != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_codename.equals(primaryDeviceChangePayload.suggested_codename))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18126a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.msg_to != null) {
            tProtocol.a(f18171c);
            this.msg_to.m18089a(tProtocol);
        }
        if (this.suggested_codename != null) {
            tProtocol.a(f18172d);
            tProtocol.a(this.suggested_codename);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18125a(1, f18169a);
    }

    public final String m18125a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PrimaryDeviceChangePayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("msg_to");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.msg_to == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.msg_to, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("suggested_codename");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.suggested_codename == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.suggested_codename, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
