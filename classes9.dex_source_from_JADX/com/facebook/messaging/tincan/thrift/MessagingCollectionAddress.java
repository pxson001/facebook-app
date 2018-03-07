package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: click_cancel_in_surge_dialog */
public class MessagingCollectionAddress implements TBase, Serializable, Cloneable {
    public static boolean f18134a = true;
    private static final TStruct f18135b = new TStruct("MessagingCollectionAddress");
    private static final TField f18136c = new TField("user_id", (byte) 10, (short) 2);
    private static final TField f18137d = new TField("instance_id", (byte) 11, (short) 3);
    public final String instance_id;
    public final Long user_id;

    public MessagingCollectionAddress(Long l, String str) {
        this.user_id = l;
        this.instance_id = str;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof MessagingCollectionAddress)) {
            return m18090a((MessagingCollectionAddress) obj);
        }
        return false;
    }

    public final boolean m18090a(MessagingCollectionAddress messagingCollectionAddress) {
        if (messagingCollectionAddress == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.user_id != null;
        if (messagingCollectionAddress.user_id != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.user_id.equals(messagingCollectionAddress.user_id))) {
            return false;
        }
        if (this.instance_id != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messagingCollectionAddress.instance_id != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.instance_id.equals(messagingCollectionAddress.instance_id))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static MessagingCollectionAddress m18087b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        Long l = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
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
            return new MessagingCollectionAddress(l, str);
        }
    }

    public final void m18089a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.user_id != null) {
            tProtocol.a(f18136c);
            tProtocol.a(this.user_id.longValue());
        }
        if (this.instance_id != null) {
            tProtocol.a(f18137d);
            tProtocol.a(this.instance_id);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18088a(1, f18134a);
    }

    public final String m18088a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("MessagingCollectionAddress");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("user_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.user_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.user_id, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("instance_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.instance_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.instance_id, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
