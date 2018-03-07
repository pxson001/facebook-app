package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: topPercentage */
public class AdditionalContacts implements TBase, Serializable, Cloneable {
    public static boolean f2852a = true;
    private static final TStruct f2853b = new TStruct("AdditionalContacts");
    private static final TField f2854c = new TField("additional_contacts", (byte) 15, (short) 1);
    public final List<Long> additional_contacts;

    public AdditionalContacts(List<Long> list) {
        this.additional_contacts = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AdditionalContacts)) {
            return false;
        }
        AdditionalContacts additionalContacts = (AdditionalContacts) obj;
        boolean z = false;
        if (additionalContacts != null) {
            Object obj2 = this.additional_contacts != null ? 1 : null;
            Object obj3;
            if (additionalContacts.additional_contacts != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.additional_contacts.equals(additionalContacts.additional_contacts))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3959a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.additional_contacts != null) {
            tProtocol.a(f2854c);
            tProtocol.a(new TList((byte) 10, this.additional_contacts.size()));
            for (Long longValue : this.additional_contacts) {
                tProtocol.a(longValue.longValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3958a(1, f2852a);
    }

    public final String m3958a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AdditionalContacts");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("additional_contacts");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.additional_contacts == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.additional_contacts, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
