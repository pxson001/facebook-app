package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: cl */
public class RegisterResponsePayload implements TBase, Serializable, Cloneable {
    public static boolean f18188a = true;
    private static final TStruct f18189b = new TStruct("RegisterResponsePayload");
    private static final TField f18190c = new TField("nonce", (byte) 11, (short) 2);
    public final byte[] nonce;

    public RegisterResponsePayload(byte[] bArr) {
        this.nonce = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegisterResponsePayload)) {
            return false;
        }
        RegisterResponsePayload registerResponsePayload = (RegisterResponsePayload) obj;
        boolean z = false;
        if (registerResponsePayload != null) {
            Object obj2 = this.nonce != null ? 1 : null;
            Object obj3;
            if (registerResponsePayload.nonce != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !Arrays.equals(this.nonce, registerResponsePayload.nonce))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18137a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.nonce != null) {
            tProtocol.a(f18190c);
            tProtocol.a(this.nonce);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18136a(1, f18188a);
    }

    public final String m18136a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("RegisterResponsePayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("nonce");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.nonce == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.nonce, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
