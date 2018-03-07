package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: chunked_session_id */
public class SignedPublicKeyWithID implements TBase, Serializable, Cloneable {
    public static boolean f18219a = true;
    private static final TStruct f18220b = new TStruct("SignedPublicKeyWithID");
    private static final TField f18221c = new TField("public_key_with_id", (byte) 12, (short) 2);
    private static final TField f18222d = new TField("signature", (byte) 11, (short) 3);
    public final PublicKeyWithID public_key_with_id;
    public final byte[] signature;

    private SignedPublicKeyWithID(PublicKeyWithID publicKeyWithID, byte[] bArr) {
        this.public_key_with_id = publicKeyWithID;
        this.signature = bArr;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof SignedPublicKeyWithID)) {
            return m18173a((SignedPublicKeyWithID) obj);
        }
        return false;
    }

    public final boolean m18173a(SignedPublicKeyWithID signedPublicKeyWithID) {
        if (signedPublicKeyWithID == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.public_key_with_id != null;
        if (signedPublicKeyWithID.public_key_with_id != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.public_key_with_id.m18130a(signedPublicKeyWithID.public_key_with_id))) {
            return false;
        }
        if (this.signature != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (signedPublicKeyWithID.signature != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.signature, signedPublicKeyWithID.signature))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static SignedPublicKeyWithID m18170b(TProtocol tProtocol) {
        byte[] bArr = null;
        tProtocol.r();
        PublicKeyWithID publicKeyWithID = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        publicKeyWithID = PublicKeyWithID.m18127b(tProtocol);
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new SignedPublicKeyWithID(publicKeyWithID, bArr);
        }
    }

    public final void m18172a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.public_key_with_id != null) {
            tProtocol.a(f18221c);
            this.public_key_with_id.m18129a(tProtocol);
        }
        if (this.signature != null) {
            tProtocol.a(f18222d);
            tProtocol.a(this.signature);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18171a(1, f18219a);
    }

    public final String m18171a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SignedPublicKeyWithID");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("public_key_with_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.public_key_with_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.public_key_with_id, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("signature");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.signature == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.signature, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
