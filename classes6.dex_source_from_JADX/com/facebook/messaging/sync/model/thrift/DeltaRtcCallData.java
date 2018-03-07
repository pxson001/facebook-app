package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: turn_off_on_last_owner_removed */
public class DeltaRtcCallData implements TBase, Serializable, Cloneable {
    public static boolean f2634a = true;
    private static final TStruct f2635b = new TStruct("DeltaRtcCallData");
    private static final TField f2636c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2637d = new TField("callState", (byte) 11, (short) 2);
    private static final TField f2638e = new TField("serverInfoData", (byte) 11, (short) 3);
    private static final TField f2639f = new TField("initiator", (byte) 12, (short) 4);
    public final String callState;
    public final ParticipantInfo initiator;
    public final MessageMetadata messageMetadata;
    public final String serverInfoData;

    private DeltaRtcCallData(MessageMetadata messageMetadata, String str, String str2, ParticipantInfo participantInfo) {
        this.messageMetadata = messageMetadata;
        this.callState = str;
        this.serverInfoData = str2;
        this.initiator = participantInfo;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaRtcCallData)) {
            return false;
        }
        DeltaRtcCallData deltaRtcCallData = (DeltaRtcCallData) obj;
        boolean z = false;
        if (deltaRtcCallData != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaRtcCallData.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaRtcCallData.messageMetadata))) {
                if (this.callState != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaRtcCallData.callState != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.callState.equals(deltaRtcCallData.callState))) {
                    if (this.serverInfoData != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaRtcCallData.serverInfoData != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.serverInfoData.equals(deltaRtcCallData.serverInfoData))) {
                        if (this.initiator != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaRtcCallData.initiator != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.initiator.m3928a(deltaRtcCallData.initiator))) {
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

    public static DeltaRtcCallData m3792b(TProtocol tProtocol) {
        ParticipantInfo participantInfo = null;
        tProtocol.r();
        String str = null;
        String str2 = null;
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
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        participantInfo = ParticipantInfo.m3925b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaRtcCallData deltaRtcCallData = new DeltaRtcCallData(messageMetadata, str2, str, participantInfo);
            deltaRtcCallData.m3791a();
            return deltaRtcCallData;
        }
    }

    public final void m3794a(TProtocol tProtocol) {
        m3791a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2636c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.callState == null || this.callState == null)) {
            tProtocol.a(f2637d);
            tProtocol.a(this.callState);
        }
        if (!(this.serverInfoData == null || this.serverInfoData == null)) {
            tProtocol.a(f2638e);
            tProtocol.a(this.serverInfoData);
        }
        if (!(this.initiator == null || this.initiator == null)) {
            tProtocol.a(f2639f);
            this.initiator.m3927a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3793a(1, f2634a);
    }

    public final String m3793a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaRtcCallData");
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
        if (this.callState != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("callState");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.callState == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.callState, i + 1, z));
            }
        }
        if (this.serverInfoData != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("serverInfoData");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.serverInfoData == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.serverInfoData, i + 1, z));
            }
        }
        if (this.initiator != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("initiator");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.initiator == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.initiator, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3791a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        }
    }
}
