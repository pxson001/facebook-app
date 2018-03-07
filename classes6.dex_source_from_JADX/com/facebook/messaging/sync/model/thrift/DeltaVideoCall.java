package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transfer_status */
public class DeltaVideoCall implements TBase, Serializable, Cloneable {
    public static boolean f2669a = true;
    private static final TStruct f2670b = new TStruct("DeltaVideoCall");
    private static final TField f2671c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2672d = new TField("answered", (byte) 2, (short) 2);
    private static final TField f2673e = new TField("startTime", (byte) 10, (short) 3);
    private static final TField f2674f = new TField("duration", (byte) 10, (short) 4);
    public final Boolean answered;
    public final Long duration;
    public final MessageMetadata messageMetadata;
    public final Long startTime;

    private DeltaVideoCall(MessageMetadata messageMetadata, Boolean bool, Long l, Long l2) {
        this.messageMetadata = messageMetadata;
        this.answered = bool;
        this.startTime = l;
        this.duration = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaVideoCall)) {
            return false;
        }
        DeltaVideoCall deltaVideoCall = (DeltaVideoCall) obj;
        boolean z = false;
        if (deltaVideoCall != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaVideoCall.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaVideoCall.messageMetadata))) {
                if (this.answered != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaVideoCall.answered != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.answered.equals(deltaVideoCall.answered))) {
                    if (this.startTime != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaVideoCall.startTime != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.startTime.equals(deltaVideoCall.startTime))) {
                        if (this.duration != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaVideoCall.duration != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.duration.equals(deltaVideoCall.duration))) {
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

    public static DeltaVideoCall m3822b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Long l2 = null;
        Boolean bool = null;
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
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
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
            DeltaVideoCall deltaVideoCall = new DeltaVideoCall(messageMetadata, bool, l2, l);
            deltaVideoCall.m3821a();
            return deltaVideoCall;
        }
    }

    public final void m3824a(TProtocol tProtocol) {
        m3821a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2671c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.answered == null || this.answered == null)) {
            tProtocol.a(f2672d);
            tProtocol.a(this.answered.booleanValue());
        }
        if (!(this.startTime == null || this.startTime == null)) {
            tProtocol.a(f2673e);
            tProtocol.a(this.startTime.longValue());
        }
        if (!(this.duration == null || this.duration == null)) {
            tProtocol.a(f2674f);
            tProtocol.a(this.duration.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3823a(1, f2669a);
    }

    public final String m3823a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaVideoCall");
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
        if (this.answered != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("answered");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.answered == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.answered, i + 1, z));
            }
        }
        if (this.startTime != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("startTime");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.startTime == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.startTime, i + 1, z));
            }
        }
        if (this.duration != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("duration");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.duration == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.duration, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3821a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        }
    }
}
