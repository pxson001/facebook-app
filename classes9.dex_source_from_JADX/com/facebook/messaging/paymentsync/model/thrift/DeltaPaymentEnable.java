package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: ea5fa72ebabab9fcd4315fb60f24e42b */
public class DeltaPaymentEnable implements TBase, Serializable, Cloneable {
    public static boolean f15896a = true;
    private static final TStruct f15897b = new TStruct("DeltaPaymentEnable");
    private static final TField f15898c = new TField("enabled", (byte) 2, (short) 1);
    private static final TField f15899d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Boolean enabled;
    public final Long irisSeqId;

    public DeltaPaymentEnable(Boolean bool, Long l) {
        this.enabled = bool;
        this.irisSeqId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentEnable)) {
            return false;
        }
        DeltaPaymentEnable deltaPaymentEnable = (DeltaPaymentEnable) obj;
        boolean z = false;
        if (deltaPaymentEnable != null) {
            Object obj2;
            Object obj3 = this.enabled != null ? 1 : null;
            if (deltaPaymentEnable.enabled != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.enabled.equals(deltaPaymentEnable.enabled))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentEnable.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentEnable.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16066a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.enabled == null || this.enabled == null)) {
            tProtocol.a(f15898c);
            tProtocol.a(this.enabled.booleanValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15899d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16065a(1, f15896a);
    }

    public final String m16065a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentEnable");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.enabled != null) {
            stringBuilder.append(a);
            stringBuilder.append("enabled");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.enabled == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.enabled, i + 1, z));
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
