package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: click_confirm_in_surge_dialog */
public class LookupPayload implements TBase, Serializable, Cloneable {
    public static boolean f18122a = true;
    private static final TStruct f18123b = new TStruct("LookupPayload");
    private static final TField f18124c = new TField("nonce", (byte) 11, (short) 2);
    private static final TField f18125d = new TField("user_id", (byte) 10, (short) 3);
    public final byte[] nonce;
    public final Long user_id;

    public LookupPayload(byte[] bArr, Long l) {
        this.nonce = bArr;
        this.user_id = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LookupPayload)) {
            return false;
        }
        LookupPayload lookupPayload = (LookupPayload) obj;
        boolean z = false;
        if (lookupPayload != null) {
            Object obj2;
            Object obj3 = this.nonce != null ? 1 : null;
            if (lookupPayload.nonce != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.nonce, lookupPayload.nonce))) {
                if (this.user_id != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (lookupPayload.user_id != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.user_id.equals(lookupPayload.user_id))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18083a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.nonce != null) {
            tProtocol.a(f18124c);
            tProtocol.a(this.nonce);
        }
        if (this.user_id != null) {
            tProtocol.a(f18125d);
            tProtocol.a(this.user_id.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18082a(1, f18122a);
    }

    public final String m18082a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("LookupPayload");
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
        stringBuilder.append("," + str);
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
