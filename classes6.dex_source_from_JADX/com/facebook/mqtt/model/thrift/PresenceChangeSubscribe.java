package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: timing_ */
public class PresenceChangeSubscribe implements TBase, Serializable, Cloneable {
    public static boolean f2926a = true;
    private static final TStruct f2927b = new TStruct("PresenceChangeSubscribe");
    private static final TField f2928c = new TField("ids", (byte) 15, (short) 1);
    public final List<Long> ids;

    public PresenceChangeSubscribe(List<Long> list) {
        this.ids = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PresenceChangeSubscribe)) {
            return false;
        }
        PresenceChangeSubscribe presenceChangeSubscribe = (PresenceChangeSubscribe) obj;
        boolean z = false;
        if (presenceChangeSubscribe != null) {
            Object obj2 = this.ids != null ? 1 : null;
            Object obj3;
            if (presenceChangeSubscribe.ids != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.ids.equals(presenceChangeSubscribe.ids))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3990a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.ids != null) {
            tProtocol.a(f2928c);
            tProtocol.a(new TList((byte) 10, this.ids.size()));
            for (Long longValue : this.ids) {
                tProtocol.a(longValue.longValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3989a(1, f2926a);
    }

    public final String m3989a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PresenceChangeSubscribe");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("ids");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.ids == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.ids, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
