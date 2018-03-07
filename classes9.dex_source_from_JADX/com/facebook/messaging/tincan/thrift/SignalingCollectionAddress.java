package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: ci_how_found */
public class SignalingCollectionAddress implements TBase, Serializable, Cloneable {
    public static boolean f18216a = true;
    private static final TStruct f18217b = new TStruct("SignalingCollectionAddress");
    private static final TField f18218c = new TField("user_id", (byte) 10, (short) 2);
    public final Long user_id;

    public SignalingCollectionAddress(Long l) {
        this.user_id = l;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof SignalingCollectionAddress)) {
            return m18169a((SignalingCollectionAddress) obj);
        }
        return false;
    }

    public final boolean m18169a(SignalingCollectionAddress signalingCollectionAddress) {
        if (signalingCollectionAddress == null) {
            return false;
        }
        boolean z = this.user_id != null;
        boolean z2;
        if (signalingCollectionAddress.user_id != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z || r3) && (!z || !r3 || !this.user_id.equals(signalingCollectionAddress.user_id))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static SignalingCollectionAddress m18166b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
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
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new SignalingCollectionAddress(l);
        }
    }

    public final void m18168a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.user_id != null) {
            tProtocol.a(f18218c);
            tProtocol.a(this.user_id.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18167a(1, f18216a);
    }

    public final String m18167a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SignalingCollectionAddress");
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
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
