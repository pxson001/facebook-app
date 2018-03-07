package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: e46d5ebf4de085baeac729c891924317 */
public class DeltaPaymentMethodPrimary implements TBase, Serializable, Cloneable {
    public static boolean f15905a = true;
    private static final TStruct f15906b = new TStruct("DeltaPaymentMethodPrimary");
    private static final TField f15907c = new TField("paymentMethodId", (byte) 10, (short) 1);
    private static final TField f15908d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Long paymentMethodId;

    public DeltaPaymentMethodPrimary(Long l, Long l2) {
        this.paymentMethodId = l;
        this.irisSeqId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentMethodPrimary)) {
            return false;
        }
        DeltaPaymentMethodPrimary deltaPaymentMethodPrimary = (DeltaPaymentMethodPrimary) obj;
        boolean z = false;
        if (deltaPaymentMethodPrimary != null) {
            Object obj2;
            Object obj3 = this.paymentMethodId != null ? 1 : null;
            if (deltaPaymentMethodPrimary.paymentMethodId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.paymentMethodId.equals(deltaPaymentMethodPrimary.paymentMethodId))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentMethodPrimary.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentMethodPrimary.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16071a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.paymentMethodId == null || this.paymentMethodId == null)) {
            tProtocol.a(f15907c);
            tProtocol.a(this.paymentMethodId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15908d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16070a(1, f15905a);
    }

    public final String m16070a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentMethodPrimary");
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
