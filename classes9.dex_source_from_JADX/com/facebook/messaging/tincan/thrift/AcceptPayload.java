package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: click_phone_row */
public class AcceptPayload implements TBase, Serializable, Cloneable {
    public static boolean f18091a = true;
    private static final TStruct f18092b = new TStruct("AcceptPayload");
    private static final TField f18093c = new TField("link_accepted_salamander_payload", (byte) 11, (short) 2);
    private static final TField f18094d = new TField("suggested_codename", (byte) 11, (short) 3);
    public final byte[] link_accepted_salamander_payload;
    public final String suggested_codename;

    public AcceptPayload(byte[] bArr, String str) {
        this.link_accepted_salamander_payload = bArr;
        this.suggested_codename = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AcceptPayload)) {
            return false;
        }
        AcceptPayload acceptPayload = (AcceptPayload) obj;
        boolean z = false;
        if (acceptPayload != null) {
            Object obj2;
            Object obj3 = this.link_accepted_salamander_payload != null ? 1 : null;
            if (acceptPayload.link_accepted_salamander_payload != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.link_accepted_salamander_payload, acceptPayload.link_accepted_salamander_payload))) {
                if (this.suggested_codename != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (acceptPayload.suggested_codename != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_codename.equals(acceptPayload.suggested_codename))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18067a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.link_accepted_salamander_payload != null) {
            tProtocol.a(f18093c);
            tProtocol.a(this.link_accepted_salamander_payload);
        }
        if (this.suggested_codename != null) {
            tProtocol.a(f18094d);
            tProtocol.a(this.suggested_codename);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18066a(1, f18091a);
    }

    public final String m18066a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AcceptPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("link_accepted_salamander_payload");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.link_accepted_salamander_payload == null) {
            stringBuilder.append("null");
        } else {
            int min = Math.min(this.link_accepted_salamander_payload.length, 128);
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(Integer.toHexString(this.link_accepted_salamander_payload[i2]).length() > 1 ? Integer.toHexString(this.link_accepted_salamander_payload[i2]).substring(Integer.toHexString(this.link_accepted_salamander_payload[i2]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.link_accepted_salamander_payload[i2]).toUpperCase());
            }
            if (this.link_accepted_salamander_payload.length > 128) {
                stringBuilder.append(" ...");
            }
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
