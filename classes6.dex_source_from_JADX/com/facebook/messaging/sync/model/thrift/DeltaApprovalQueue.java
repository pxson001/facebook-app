package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: ui_counters/ */
public class DeltaApprovalQueue implements TBase, Serializable, Cloneable {
    public static boolean f2506a = true;
    private static final TStruct f2507b = new TStruct("DeltaApprovalQueue");
    private static final TField f2508c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2509d = new TField("action", (byte) 8, (short) 2);
    private static final TField f2510e = new TField("recipientFbId", (byte) 10, (short) 3);
    public final Integer action;
    public final MessageMetadata messageMetadata;
    public final Long recipientFbId;

    private DeltaApprovalQueue(MessageMetadata messageMetadata, Integer num, Long l) {
        this.messageMetadata = messageMetadata;
        this.action = num;
        this.recipientFbId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaApprovalQueue)) {
            return false;
        }
        DeltaApprovalQueue deltaApprovalQueue = (DeltaApprovalQueue) obj;
        boolean z = false;
        if (deltaApprovalQueue != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaApprovalQueue.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaApprovalQueue.messageMetadata))) {
                if (this.action != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaApprovalQueue.action != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.action.equals(deltaApprovalQueue.action))) {
                    if (this.recipientFbId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaApprovalQueue.recipientFbId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.recipientFbId.equals(deltaApprovalQueue.recipientFbId))) {
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

    public static DeltaApprovalQueue m3701b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Integer num = null;
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
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
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
            DeltaApprovalQueue deltaApprovalQueue = new DeltaApprovalQueue(messageMetadata, num, l);
            deltaApprovalQueue.m3700a();
            return deltaApprovalQueue;
        }
    }

    public final void m3703a(TProtocol tProtocol) {
        m3700a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2508c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.action != null) {
            tProtocol.a(f2509d);
            tProtocol.a(this.action.intValue());
        }
        if (this.recipientFbId != null) {
            tProtocol.a(f2510e);
            tProtocol.a(this.recipientFbId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3702a(1, f2506a);
    }

    public final String m3702a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaApprovalQueue");
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
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("action");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.action == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) ApprovalQueueAction.f2457b.get(this.action);
            if (str3 != null) {
                stringBuilder.append(str3);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.action);
            if (str3 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("recipientFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.recipientFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.recipientFbId, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3700a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.action == null) {
            throw new TProtocolException(6, "Required field 'action' was not present! Struct: " + toString());
        } else if (this.recipientFbId == null) {
            throw new TProtocolException(6, "Required field 'recipientFbId' was not present! Struct: " + toString());
        } else if (this.action != null && !ApprovalQueueAction.f2456a.contains(this.action)) {
            throw new TProtocolException("The field 'action' has been assigned the invalid value " + this.action);
        }
    }
}
