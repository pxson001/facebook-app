package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: e0ddf3f0a1044ce0c439464843445a51 */
public class DeltaPaymentMethodUpdated implements TBase, Serializable, Cloneable {
    public static boolean f15913a = true;
    private static final TStruct f15914b = new TStruct("DeltaPaymentMethodUpdated");
    private static final TField f15915c = new TField("paymentMethodId", (byte) 10, (short) 1);
    private static final TField f15916d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Long paymentMethodId;

    public DeltaPaymentMethodUpdated(Long l, Long l2) {
        this.paymentMethodId = l;
        this.irisSeqId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentMethodUpdated)) {
            return false;
        }
        DeltaPaymentMethodUpdated deltaPaymentMethodUpdated = (DeltaPaymentMethodUpdated) obj;
        boolean z = false;
        if (deltaPaymentMethodUpdated != null) {
            Object obj2;
            Object obj3 = this.paymentMethodId != null ? 1 : null;
            if (deltaPaymentMethodUpdated.paymentMethodId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.paymentMethodId.equals(deltaPaymentMethodUpdated.paymentMethodId))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentMethodUpdated.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentMethodUpdated.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16075a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.paymentMethodId == null || this.paymentMethodId == null)) {
            tProtocol.a(f15915c);
            tProtocol.a(this.paymentMethodId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15916d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16074a(1, f15913a);
    }

    public final String m16074a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentMethodUpdated");
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
