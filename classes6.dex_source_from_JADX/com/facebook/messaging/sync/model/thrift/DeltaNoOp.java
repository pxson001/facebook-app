package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_selected_page_id */
public class DeltaNoOp implements TBase, Serializable, Cloneable {
    public static boolean f2583a = true;
    private static final TStruct f2584b = new TStruct("DeltaNoOp");
    private static final TField f2585c = new TField("numNoOps", (byte) 8, (short) 1);
    public final Integer numNoOps;

    public DeltaNoOp(Integer num) {
        this.numNoOps = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaNoOp)) {
            return false;
        }
        DeltaNoOp deltaNoOp = (DeltaNoOp) obj;
        boolean z = false;
        if (deltaNoOp != null) {
            Object obj2 = this.numNoOps != null ? 1 : null;
            Object obj3;
            if (deltaNoOp.numNoOps != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.numNoOps.equals(deltaNoOp.numNoOps))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3753a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.numNoOps == null || this.numNoOps == null)) {
            tProtocol.a(f2585c);
            tProtocol.a(this.numNoOps.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3752a(1, f2583a);
    }

    public final String m3752a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNoOp");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.numNoOps != null) {
            stringBuilder.append(a);
            stringBuilder.append("numNoOps");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.numNoOps == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.numNoOps, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
