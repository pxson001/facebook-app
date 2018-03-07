package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: clearPinTable */
public class PublicKeyWithID implements TBase, Serializable, Cloneable {
    public static boolean f18173a = true;
    private static final TStruct f18174b = new TStruct("PublicKeyWithID");
    private static final TField f18175c = new TField("public_key", (byte) 11, (short) 2);
    private static final TField f18176d = new TField("id", (byte) 8, (short) 3);
    public final Integer id;
    public final byte[] public_key;

    private PublicKeyWithID(byte[] bArr, Integer num) {
        this.public_key = bArr;
        this.id = num;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PublicKeyWithID)) {
            return m18130a((PublicKeyWithID) obj);
        }
        return false;
    }

    public final boolean m18130a(PublicKeyWithID publicKeyWithID) {
        if (publicKeyWithID == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.public_key != null;
        if (publicKeyWithID.public_key != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.public_key, publicKeyWithID.public_key))) {
            return false;
        }
        if (this.id != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (publicKeyWithID.id != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.id.equals(publicKeyWithID.id))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static PublicKeyWithID m18127b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        byte[] bArr = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new PublicKeyWithID(bArr, num);
        }
    }

    public final void m18129a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.public_key != null) {
            tProtocol.a(f18175c);
            tProtocol.a(this.public_key);
        }
        if (this.id != null) {
            tProtocol.a(f18176d);
            tProtocol.a(this.id.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18128a(1, f18173a);
    }

    public final String m18128a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PublicKeyWithID");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("public_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.public_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.public_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.id, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
