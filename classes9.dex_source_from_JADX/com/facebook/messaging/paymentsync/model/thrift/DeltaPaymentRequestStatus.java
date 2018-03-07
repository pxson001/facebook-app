package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: due_time */
public class DeltaPaymentRequestStatus implements TBase, Serializable, Cloneable {
    public static boolean f15921a = true;
    private static final TStruct f15922b = new TStruct("DeltaPaymentRequestStatus");
    private static final TField f15923c = new TField("requestFbId", (byte) 10, (short) 1);
    private static final TField f15924d = new TField("timestampMs", (byte) 10, (short) 2);
    private static final TField f15925e = new TField("newStatus", (byte) 8, (short) 3);
    private static final TField f15926f = new TField("transferFbId", (byte) 10, (short) 4);
    private static final TField f15927g = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Integer newStatus;
    public final Long requestFbId;
    public final Long timestampMs;
    public final Long transferFbId;

    private DeltaPaymentRequestStatus(Long l, Long l2, Integer num, Long l3, Long l4) {
        this.requestFbId = l;
        this.timestampMs = l2;
        this.newStatus = num;
        this.transferFbId = l3;
        this.irisSeqId = l4;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPaymentRequestStatus)) {
            return false;
        }
        DeltaPaymentRequestStatus deltaPaymentRequestStatus = (DeltaPaymentRequestStatus) obj;
        boolean z = false;
        if (deltaPaymentRequestStatus != null) {
            Object obj2;
            Object obj3 = this.requestFbId != null ? 1 : null;
            if (deltaPaymentRequestStatus.requestFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requestFbId.equals(deltaPaymentRequestStatus.requestFbId))) {
                if (this.timestampMs != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPaymentRequestStatus.timestampMs != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaPaymentRequestStatus.timestampMs))) {
                    if (this.newStatus != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaPaymentRequestStatus.newStatus != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.newStatus.equals(deltaPaymentRequestStatus.newStatus))) {
                        if (this.transferFbId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaPaymentRequestStatus.transferFbId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.transferFbId.equals(deltaPaymentRequestStatus.transferFbId))) {
                            if (this.irisSeqId != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaPaymentRequestStatus.irisSeqId != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaPaymentRequestStatus.irisSeqId))) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPaymentRequestStatus m16079b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Long l2 = null;
        Integer num = null;
        Long l3 = null;
        Long l4 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l4 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
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
            DeltaPaymentRequestStatus deltaPaymentRequestStatus = new DeltaPaymentRequestStatus(l4, l3, num, l2, l);
            deltaPaymentRequestStatus.m16078a();
            return deltaPaymentRequestStatus;
        }
    }

    public final void m16081a(TProtocol tProtocol) {
        m16078a();
        tProtocol.a();
        if (this.requestFbId != null) {
            tProtocol.a(f15923c);
            tProtocol.a(this.requestFbId.longValue());
        }
        if (this.timestampMs != null) {
            tProtocol.a(f15924d);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (this.newStatus != null) {
            tProtocol.a(f15925e);
            tProtocol.a(this.newStatus.intValue());
        }
        if (!(this.transferFbId == null || this.transferFbId == null)) {
            tProtocol.a(f15926f);
            tProtocol.a(this.transferFbId.longValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15927g);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16080a(1, f15921a);
    }

    public final String m16080a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPaymentRequestStatus");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("requestFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.requestFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.requestFbId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("timestampMs");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.timestampMs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.timestampMs, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("newStatus");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.newStatus == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) PaymentRequestStatus.f15973b.get(this.newStatus);
            if (str3 != null) {
                stringBuilder.append(str3);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.newStatus);
            if (str3 != null) {
                stringBuilder.append(")");
            }
        }
        if (this.transferFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("transferFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.transferFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.transferFbId, i + 1, z));
            }
        }
        if (this.irisSeqId != null) {
            stringBuilder.append("," + str);
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

    private void m16078a() {
        if (this.requestFbId == null) {
            throw new TProtocolException(6, "Required field 'requestFbId' was not present! Struct: " + toString());
        } else if (this.timestampMs == null) {
            throw new TProtocolException(6, "Required field 'timestampMs' was not present! Struct: " + toString());
        } else if (this.newStatus == null) {
            throw new TProtocolException(6, "Required field 'newStatus' was not present! Struct: " + toString());
        } else if (this.newStatus != null && !PaymentRequestStatus.f15972a.contains(this.newStatus)) {
            throw new TProtocolException("The field 'newStatus' has been assigned the invalid value " + this.newStatus);
        }
    }
}
