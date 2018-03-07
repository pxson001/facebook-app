package com.facebook.rtc.models.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: application/vnd.wap.loc+xml */
public class PhoneAppPayload implements TBase, Serializable, Cloneable {
    public static boolean f19842a = true;
    private static final TStruct f19843b = new TStruct("PhoneAppPayload");
    private static final TField f19844c = new TField("phoneNumbers", (byte) 15, (short) 1);
    public final List<String> phoneNumbers;

    public PhoneAppPayload(List<String> list) {
        this.phoneNumbers = list;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PhoneAppPayload)) {
            return m19569a((PhoneAppPayload) obj);
        }
        return false;
    }

    public final boolean m19569a(PhoneAppPayload phoneAppPayload) {
        if (phoneAppPayload == null) {
            return false;
        }
        boolean z = this.phoneNumbers != null;
        boolean z2;
        if (phoneAppPayload.phoneNumbers != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z || r3) && (!z || !r3 || !this.phoneNumbers.equals(phoneAppPayload.phoneNumbers))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final void m19568a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.phoneNumbers == null || this.phoneNumbers == null)) {
            tProtocol.a(f19844c);
            tProtocol.a(new TList((byte) 11, this.phoneNumbers.size()));
            for (String a : this.phoneNumbers) {
                tProtocol.a(a);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m19567a(1, f19842a);
    }

    public final String m19567a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PhoneAppPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.phoneNumbers != null) {
            stringBuilder.append(a);
            stringBuilder.append("phoneNumbers");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.phoneNumbers == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.phoneNumbers, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
