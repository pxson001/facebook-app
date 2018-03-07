package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: droid_inspector_enabled */
public class DeltaPinCode implements TBase, Serializable, Cloneable {
    public static boolean f15942a = true;
    private static final TStruct f15943b = new TStruct("DeltaPinCode");
    private static final TField f15944c = new TField("pinFbId", (byte) 10, (short) 1);
    private static final TField f15945d = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Long pinFbId;

    public DeltaPinCode(Long l, Long l2) {
        this.pinFbId = l;
        this.irisSeqId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPinCode)) {
            return false;
        }
        DeltaPinCode deltaPinCode = (DeltaPinCode) obj;
        boolean z = false;
        if (deltaPinCode != null) {
            Object obj2;
            Object obj3 = this.pinFbId != null ? 1 : null;
            if (deltaPinCode.pinFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.pinFbId.equals(deltaPinCode.pinFbId))) {
                if (this.irisSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPinCode.irisSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPinCode.irisSeqId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m16100a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.pinFbId == null || this.pinFbId == null)) {
            tProtocol.a(f15944c);
            tProtocol.a(this.pinFbId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15945d);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16099a(1, f15942a);
    }

    public final String m16099a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPinCode");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.pinFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("pinFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.pinFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.pinFbId, i + 1, z));
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
