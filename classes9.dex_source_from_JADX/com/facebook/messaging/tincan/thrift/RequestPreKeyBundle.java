package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: city_keys */
public class RequestPreKeyBundle implements TBase, Serializable, Cloneable {
    public static boolean f18195a = true;
    private static final TStruct f18196b = new TStruct("RequestPreKeyBundle");
    private static final TField f18197c = new TField("identity_key", (byte) 11, (short) 2);
    private static final TField f18198d = new TField("pre_key", (byte) 11, (short) 4);
    private static final TField f18199e = new TField("signed_pre_key", (byte) 11, (short) 6);
    private static final TField f18200f = new TField("signed_pre_key_signature", (byte) 11, (short) 7);
    public final byte[] identity_key;
    public final byte[] pre_key;
    public final byte[] signed_pre_key;
    public final byte[] signed_pre_key_signature;

    public RequestPreKeyBundle(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.identity_key = bArr;
        this.pre_key = bArr2;
        this.signed_pre_key = bArr3;
        this.signed_pre_key_signature = bArr4;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof RequestPreKeyBundle)) {
            return m18143a((RequestPreKeyBundle) obj);
        }
        return false;
    }

    public final boolean m18143a(RequestPreKeyBundle requestPreKeyBundle) {
        if (requestPreKeyBundle == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.identity_key != null;
        if (requestPreKeyBundle.identity_key != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.identity_key, requestPreKeyBundle.identity_key))) {
            return false;
        }
        if (this.pre_key != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (requestPreKeyBundle.pre_key != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.pre_key, requestPreKeyBundle.pre_key))) {
            return false;
        }
        if (this.signed_pre_key != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (requestPreKeyBundle.signed_pre_key != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.signed_pre_key, requestPreKeyBundle.signed_pre_key))) {
            return false;
        }
        if (this.signed_pre_key_signature != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (requestPreKeyBundle.signed_pre_key_signature != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.signed_pre_key_signature, requestPreKeyBundle.signed_pre_key_signature))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18142a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.identity_key != null) {
            tProtocol.a(f18197c);
            tProtocol.a(this.identity_key);
        }
        if (this.pre_key != null) {
            tProtocol.a(f18198d);
            tProtocol.a(this.pre_key);
        }
        if (this.signed_pre_key != null) {
            tProtocol.a(f18199e);
            tProtocol.a(this.signed_pre_key);
        }
        if (this.signed_pre_key_signature != null) {
            tProtocol.a(f18200f);
            tProtocol.a(this.signed_pre_key_signature);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18141a(1, f18195a);
    }

    public final String m18141a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("RequestPreKeyBundle");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("identity_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.identity_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.identity_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("pre_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.pre_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.pre_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("signed_pre_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.signed_pre_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.signed_pre_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("signed_pre_key_signature");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.signed_pre_key_signature == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.signed_pre_key_signature, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
