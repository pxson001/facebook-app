package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_placeholder */
public class DeltaP2PPaymentMessage implements TBase, Serializable, Cloneable {
    public static boolean f2590a = true;
    private static final TStruct f2591b = new TStruct("DeltaP2PPaymentMessage");
    private static final TField f2592c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2593d = new TField("transferId", (byte) 10, (short) 2);
    private static final TField f2594e = new TField("messageType", (byte) 8, (short) 3);
    private static final TField f2595f = new TField("requestId", (byte) 10, (short) 4);
    public final MessageMetadata messageMetadata;
    public final Integer messageType;
    public final Long requestId;
    public final Long transferId;

    private DeltaP2PPaymentMessage(MessageMetadata messageMetadata, Long l, Integer num, Long l2) {
        this.messageMetadata = messageMetadata;
        this.transferId = l;
        this.messageType = num;
        this.requestId = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaP2PPaymentMessage)) {
            return false;
        }
        DeltaP2PPaymentMessage deltaP2PPaymentMessage = (DeltaP2PPaymentMessage) obj;
        boolean z = false;
        if (deltaP2PPaymentMessage != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaP2PPaymentMessage.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaP2PPaymentMessage.messageMetadata))) {
                if (this.transferId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaP2PPaymentMessage.transferId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.transferId.equals(deltaP2PPaymentMessage.transferId))) {
                    if (this.messageType != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaP2PPaymentMessage.messageType != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageType.equals(deltaP2PPaymentMessage.messageType))) {
                        if (this.requestId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaP2PPaymentMessage.requestId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requestId.equals(deltaP2PPaymentMessage.requestId))) {
                            z = true;
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

    public static DeltaP2PPaymentMessage m3758b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Integer num = null;
        Long l2 = null;
        MessageMetadata messageMetadata = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        messageMetadata = MessageMetadata.m3917b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaP2PPaymentMessage deltaP2PPaymentMessage = new DeltaP2PPaymentMessage(messageMetadata, l2, num, l);
            deltaP2PPaymentMessage.m3757a();
            return deltaP2PPaymentMessage;
        }
    }

    public final void m3760a(TProtocol tProtocol) {
        m3757a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2592c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.transferId == null || this.transferId == null)) {
            tProtocol.a(f2593d);
            tProtocol.a(this.transferId.longValue());
        }
        if (!(this.messageType == null || this.messageType == null)) {
            tProtocol.a(f2594e);
            tProtocol.a(this.messageType.intValue());
        }
        if (!(this.requestId == null || this.requestId == null)) {
            tProtocol.a(f2595f);
            tProtocol.a(this.requestId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3759a(1, f2590a);
    }

    public final String m3759a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaP2PPaymentMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("messageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.messageMetadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.messageMetadata, i + 1, z));
        }
        if (this.transferId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("transferId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.transferId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.transferId, i + 1, z));
            }
        }
        if (this.messageType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("messageType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageType == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) PaymentLogMessageType.f2791b.get(this.messageType);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.messageType);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.requestId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("requestId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.requestId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.requestId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3757a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.messageType != null && !PaymentLogMessageType.f2790a.contains(this.messageType)) {
            throw new TProtocolException("The field 'messageType' has been assigned the invalid value " + this.messageType);
        }
    }
}
