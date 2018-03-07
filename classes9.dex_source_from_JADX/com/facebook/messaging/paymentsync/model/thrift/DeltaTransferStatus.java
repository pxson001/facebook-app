package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: dragged_chat_head */
public class DeltaTransferStatus implements TBase, Serializable, Cloneable {
    public static boolean f15964a = true;
    private static final TStruct f15965b = new TStruct("DeltaTransferStatus");
    private static final TField f15966c = new TField("transferFbId", (byte) 10, (short) 1);
    private static final TField f15967d = new TField("timestampMs", (byte) 10, (short) 2);
    private static final TField f15968e = new TField("newStatus", (byte) 8, (short) 3);
    private static final TField f15969f = new TField("newSenderStatus", (byte) 8, (short) 4);
    private static final TField f15970g = new TField("newReceiverStatus", (byte) 8, (short) 5);
    private static final TField f15971h = new TField("irisSeqId", (byte) 10, (short) 1000);
    public final Long irisSeqId;
    public final Integer newReceiverStatus;
    public final Integer newSenderStatus;
    public final Integer newStatus;
    public final Long timestampMs;
    public final Long transferFbId;

    private DeltaTransferStatus(Long l, Long l2, Integer num, Integer num2, Integer num3, Long l3) {
        this.transferFbId = l;
        this.timestampMs = l2;
        this.newStatus = num;
        this.newSenderStatus = num2;
        this.newReceiverStatus = num3;
        this.irisSeqId = l3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaTransferStatus)) {
            return false;
        }
        DeltaTransferStatus deltaTransferStatus = (DeltaTransferStatus) obj;
        boolean z = false;
        if (deltaTransferStatus != null) {
            Object obj2;
            Object obj3 = this.transferFbId != null ? 1 : null;
            if (deltaTransferStatus.transferFbId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.transferFbId.equals(deltaTransferStatus.transferFbId))) {
                if (this.timestampMs != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaTransferStatus.timestampMs != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestampMs.equals(deltaTransferStatus.timestampMs))) {
                    if (this.newStatus != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaTransferStatus.newStatus != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.newStatus.equals(deltaTransferStatus.newStatus))) {
                        if (this.newSenderStatus != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaTransferStatus.newSenderStatus != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.newSenderStatus.equals(deltaTransferStatus.newSenderStatus))) {
                            if (this.newReceiverStatus != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaTransferStatus.newReceiverStatus != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.newReceiverStatus.equals(deltaTransferStatus.newReceiverStatus))) {
                                if (this.irisSeqId != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaTransferStatus.irisSeqId != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.irisSeqId.equals(deltaTransferStatus.irisSeqId))) {
                                    z = true;
                                }
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

    public static DeltaTransferStatus m16106b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Integer num = null;
        Integer num2 = null;
        Integer num3 = null;
        Long l2 = null;
        Long l3 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
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
            DeltaTransferStatus deltaTransferStatus = new DeltaTransferStatus(l3, l2, num3, num2, num, l);
            deltaTransferStatus.m16105a();
            return deltaTransferStatus;
        }
    }

    public final void m16108a(TProtocol tProtocol) {
        m16105a();
        tProtocol.a();
        if (!(this.transferFbId == null || this.transferFbId == null)) {
            tProtocol.a(f15966c);
            tProtocol.a(this.transferFbId.longValue());
        }
        if (!(this.timestampMs == null || this.timestampMs == null)) {
            tProtocol.a(f15967d);
            tProtocol.a(this.timestampMs.longValue());
        }
        if (!(this.newStatus == null || this.newStatus == null)) {
            tProtocol.a(f15968e);
            tProtocol.a(this.newStatus.intValue());
        }
        if (!(this.newSenderStatus == null || this.newSenderStatus == null)) {
            tProtocol.a(f15969f);
            tProtocol.a(this.newSenderStatus.intValue());
        }
        if (!(this.newReceiverStatus == null || this.newReceiverStatus == null)) {
            tProtocol.a(f15970g);
            tProtocol.a(this.newReceiverStatus.intValue());
        }
        if (!(this.irisSeqId == null || this.irisSeqId == null)) {
            tProtocol.a(f15971h);
            tProtocol.a(this.irisSeqId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m16107a(1, f15964a);
    }

    public final String m16107a(int i, boolean z) {
        String str;
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str2 = z ? "\n" : "";
        String str3 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaTransferStatus");
        stringBuilder.append(str3);
        stringBuilder.append("(");
        stringBuilder.append(str2);
        Object obj2 = 1;
        if (this.transferFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("transferFbId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.transferFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.transferFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.timestampMs != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("timestampMs");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.timestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.timestampMs, i + 1, z));
            }
            obj2 = null;
        }
        if (this.newStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("newStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.newStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) PaymentStatus.f15975b.get(this.newStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.newStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.newSenderStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("newSenderStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.newSenderStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) SenderStatus.f15989b.get(this.newSenderStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.newSenderStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.newReceiverStatus != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("newReceiverStatus");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.newReceiverStatus == null) {
                stringBuilder.append("null");
            } else {
                str = (String) ReceiverStatus.f15987b.get(this.newReceiverStatus);
                if (str != null) {
                    stringBuilder.append(str);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.newReceiverStatus);
                if (str != null) {
                    stringBuilder.append(")");
                }
            }
        } else {
            obj = obj2;
        }
        if (this.irisSeqId != null) {
            if (obj == null) {
                stringBuilder.append("," + str2);
            }
            stringBuilder.append(a);
            stringBuilder.append("irisSeqId");
            stringBuilder.append(str3);
            stringBuilder.append(":").append(str3);
            if (this.irisSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.irisSeqId, i + 1, z));
            }
        }
        stringBuilder.append(str2 + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m16105a() {
        if (this.newStatus != null && !PaymentStatus.f15974a.contains(this.newStatus)) {
            throw new TProtocolException("The field 'newStatus' has been assigned the invalid value " + this.newStatus);
        } else if (this.newSenderStatus != null && !SenderStatus.f15988a.contains(this.newSenderStatus)) {
            throw new TProtocolException("The field 'newSenderStatus' has been assigned the invalid value " + this.newSenderStatus);
        } else if (this.newReceiverStatus != null && !ReceiverStatus.f15986a.contains(this.newReceiverStatus)) {
            throw new TProtocolException("The field 'newReceiverStatus' has been assigned the invalid value " + this.newReceiverStatus);
        }
    }
}
