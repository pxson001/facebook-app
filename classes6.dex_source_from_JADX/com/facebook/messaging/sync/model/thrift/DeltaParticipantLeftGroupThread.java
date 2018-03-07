package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_existing_fields */
public class DeltaParticipantLeftGroupThread implements TBase, Serializable, Cloneable {
    public static boolean f2605a = true;
    private static final TStruct f2606b = new TStruct("DeltaParticipantLeftGroupThread");
    private static final TField f2607c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2608d = new TField("leftParticipantFbId", (byte) 10, (short) 2);
    public final Long leftParticipantFbId;
    public final MessageMetadata messageMetadata;

    private DeltaParticipantLeftGroupThread(MessageMetadata messageMetadata, Long l) {
        this.messageMetadata = messageMetadata;
        this.leftParticipantFbId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaParticipantLeftGroupThread)) {
            return false;
        }
        DeltaParticipantLeftGroupThread deltaParticipantLeftGroupThread = (DeltaParticipantLeftGroupThread) obj;
        boolean z = false;
        if (deltaParticipantLeftGroupThread != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaParticipantLeftGroupThread.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaParticipantLeftGroupThread.messageMetadata))) {
                if (this.leftParticipantFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaParticipantLeftGroupThread.leftParticipantFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.leftParticipantFbId.equals(deltaParticipantLeftGroupThread.leftParticipantFbId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaParticipantLeftGroupThread m3770b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
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
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaParticipantLeftGroupThread deltaParticipantLeftGroupThread = new DeltaParticipantLeftGroupThread(messageMetadata, l);
            deltaParticipantLeftGroupThread.m3769a();
            return deltaParticipantLeftGroupThread;
        }
    }

    public final void m3772a(TProtocol tProtocol) {
        m3769a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2607c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.leftParticipantFbId != null) {
            tProtocol.a(f2608d);
            tProtocol.a(this.leftParticipantFbId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3771a(1, f2605a);
    }

    public final String m3771a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaParticipantLeftGroupThread");
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
        stringBuilder.append("leftParticipantFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.leftParticipantFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.leftParticipantFbId, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3769a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.leftParticipantFbId == null) {
            throw new TProtocolException(6, "Required field 'leftParticipantFbId' was not present! Struct: " + toString());
        }
    }
}
