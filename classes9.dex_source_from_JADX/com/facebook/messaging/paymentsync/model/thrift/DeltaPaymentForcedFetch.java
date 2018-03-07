package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: e8fb3868ed98621bb7fd0c8673024326 */
public class DeltaPaymentForcedFetch implements TBase, Serializable, Cloneable {
    public static boolean f15900a = true;
    private static final TStruct f15901b = new TStruct("DeltaPaymentForcedFetch");
    private static final TField f15902c = new TField("fetchTransferFbId", (byte) 10, (short) 1);
    private static final TField f15903d = new TField("fetchPaymentMethods", (byte) 2, (short) 2);
    private static final TField f15904e = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Boolean fetchPaymentMethods;
    public final Long fetchTransferFbId;
    public final Long irisSeqId;

    private DeltaPaymentForcedFetch(Long l, Boolean bool, Long l2) {
        this.fetchTransferFbId = l;
        this.fetchPaymentMethods = bool;
        this.irisSeqId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentForcedFetch)) {
            return false;
        }
        DeltaPaymentForcedFetch deltaPaymentForcedFetch = (DeltaPaymentForcedFetch) obj;
        boolean z = false;
        if (deltaPaymentForcedFetch != null) {
            Object obj2;
            Object obj3 = this.fetchTransferFbId != null ? 1 : null;
            if (deltaPaymentForcedFetch.fetchTransferFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.fetchTransferFbId.equals(deltaPaymentForcedFetch.fetchTransferFbId))) {
                if (this.fetchPaymentMethods != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentForcedFetch.fetchPaymentMethods != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.fetchPaymentMethods.equals(deltaPaymentForcedFetch.fetchPaymentMethods))) {
                    if (this.irisSeqId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaPaymentForcedFetch.irisSeqId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentForcedFetch.irisSeqId))) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPaymentForcedFetch m16067b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Boolean bool = null;
        Long l2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 1000:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaPaymentForcedFetch(l2, bool, l);
        }
    }

    public final void m16069a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.fetchTransferFbId == null || this.fetchTransferFbId == null)) {
            tProtocol.a(f15902c);
            tProtocol.a(this.fetchTransferFbId.longValue());
        }
        if (!(this.fetchPaymentMethods == null || this.fetchPaymentMethods == null)) {
            tProtocol.a(f15903d);
            tProtocol.a(this.fetchPaymentMethods.booleanValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15904e);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16068a(1, f15900a);
    }

    public final String m16068a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentForcedFetch");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.fetchTransferFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("fetchTransferFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fetchTransferFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fetchTransferFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fetchPaymentMethods != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fetchPaymentMethods");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fetchPaymentMethods == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fetchPaymentMethods, i + 1, z));
            }
        } else {
            obj = obj2;
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
