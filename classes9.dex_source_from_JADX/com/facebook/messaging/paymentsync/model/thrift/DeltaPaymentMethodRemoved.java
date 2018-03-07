package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: e372f8803435d8f82035c8bd1f10a982 */
public class DeltaPaymentMethodRemoved implements TBase, Serializable, Cloneable {
    public static boolean f15909a = true;
    private static final TStruct f15910b = new TStruct("DeltaPaymentMethodRemoved");
    private static final TField f15911c = new TField("paymentMethodId", (byte) 10, (short) 1);
    private static final TField f15912d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Long paymentMethodId;

    public DeltaPaymentMethodRemoved(Long l, Long l2) {
        this.paymentMethodId = l;
        this.irisSeqId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentMethodRemoved)) {
            return false;
        }
        DeltaPaymentMethodRemoved deltaPaymentMethodRemoved = (DeltaPaymentMethodRemoved) obj;
        boolean z = false;
        if (deltaPaymentMethodRemoved != null) {
            Object obj2;
            Object obj3 = this.paymentMethodId != null ? 1 : null;
            if (deltaPaymentMethodRemoved.paymentMethodId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.paymentMethodId.equals(deltaPaymentMethodRemoved.paymentMethodId))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentMethodRemoved.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentMethodRemoved.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16073a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.paymentMethodId == null || this.paymentMethodId == null)) {
            tProtocol.a(f15911c);
            tProtocol.a(this.paymentMethodId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15912d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16072a(1, f15909a);
    }

    public final String m16072a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentMethodRemoved");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.paymentMethodId != null) {
            stringBuilder.append(a);
            stringBuilder.append("paymentMethodId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.paymentMethodId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.paymentMethodId, i + 1, z));
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
