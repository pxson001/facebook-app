package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: e023c4a4979deb01f12bdcb276ffd1bd */
public class DeltaPaymentNoOp implements TBase, Serializable, Cloneable {
    public static boolean f15917a = true;
    private static final TStruct f15918b = new TStruct("DeltaPaymentNoOp");
    private static final TField f15919c = new TField("numNoOps", (byte) 8, (short) 1);
    private static final TField f15920d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Integer numNoOps;

    public DeltaPaymentNoOp(Integer num, Long l) {
        this.numNoOps = num;
        this.irisSeqId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentNoOp)) {
            return false;
        }
        DeltaPaymentNoOp deltaPaymentNoOp = (DeltaPaymentNoOp) obj;
        boolean z = false;
        if (deltaPaymentNoOp != null) {
            Object obj2;
            Object obj3 = this.numNoOps != null ? 1 : null;
            if (deltaPaymentNoOp.numNoOps != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.numNoOps.equals(deltaPaymentNoOp.numNoOps))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentNoOp.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentNoOp.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16077a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.numNoOps == null || this.numNoOps == null)) {
            tProtocol.a(f15919c);
            tProtocol.a(this.numNoOps.intValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15920d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16076a(1, f15917a);
    }

    public final String m16076a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentNoOp");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.numNoOps != null) {
            stringBuilder.append(a);
            stringBuilder.append("numNoOps");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.numNoOps == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.numNoOps, i + 1, z));
            }
            obj = null;
        }
        if (this.irisSeqId != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("irisSeqId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.irisSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.irisSeqId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
