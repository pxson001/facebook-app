package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: turn_on_joinable_by_user */
public class DeltaRTCEventLog implements TBase, Serializable, Cloneable {
    public static boolean f2616a = true;
    private static final TStruct f2617b = new TStruct("DeltaRTCEventLog");
    private static final TField f2618c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2619d = new TField("answered", (byte) 2, (short) 2);
    private static final TField f2620e = new TField("startTime", (byte) 10, (short) 3);
    private static final TField f2621f = new TField("duration", (byte) 10, (short) 4);
    private static final TField f2622g = new TField("eventType", (byte) 8, (short) 5);
    private static final TField f2623h = new TField("acknowledged", (byte) 2, (short) 6);
    public final Boolean acknowledged;
    public final Boolean answered;
    public final Long duration;
    public final Integer eventType;
    public final MessageMetadata messageMetadata;
    public final Long startTime;

    private DeltaRTCEventLog(MessageMetadata messageMetadata, Boolean bool, Long l, Long l2, Integer num, Boolean bool2) {
        this.messageMetadata = messageMetadata;
        this.answered = bool;
        this.startTime = l;
        this.duration = l2;
        this.eventType = num;
        this.acknowledged = bool2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaRTCEventLog)) {
            return false;
        }
        DeltaRTCEventLog deltaRTCEventLog = (DeltaRTCEventLog) obj;
        boolean z = false;
        if (deltaRTCEventLog != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaRTCEventLog.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaRTCEventLog.messageMetadata))) {
                if (this.answered != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaRTCEventLog.answered != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.answered.equals(deltaRTCEventLog.answered))) {
                    if (this.startTime != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaRTCEventLog.startTime != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.startTime.equals(deltaRTCEventLog.startTime))) {
                        if (this.duration != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaRTCEventLog.duration != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.duration.equals(deltaRTCEventLog.duration))) {
                            if (this.eventType != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deltaRTCEventLog.eventType != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.eventType.equals(deltaRTCEventLog.eventType))) {
                                if (this.acknowledged != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deltaRTCEventLog.acknowledged != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.acknowledged.equals(deltaRTCEventLog.acknowledged))) {
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

    public static DeltaRTCEventLog m3781b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        Integer num = null;
        Long l = null;
        Long l2 = null;
        Boolean bool2 = null;
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
                        bool2 = Boolean.valueOf(tProtocol.j());
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
                    case (short) 5:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaRTCEventLog deltaRTCEventLog = new DeltaRTCEventLog(messageMetadata, bool2, l2, l, num, bool);
            deltaRTCEventLog.m3780a();
            return deltaRTCEventLog;
        }
    }

    public final void m3783a(TProtocol tProtocol) {
        m3780a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2618c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.answered == null || this.answered == null)) {
            tProtocol.a(f2619d);
            tProtocol.a(this.answered.booleanValue());
        }
        if (!(this.startTime == null || this.startTime == null)) {
            tProtocol.a(f2620e);
            tProtocol.a(this.startTime.longValue());
        }
        if (!(this.duration == null || this.duration == null)) {
            tProtocol.a(f2621f);
            tProtocol.a(this.duration.longValue());
        }
        if (!(this.eventType == null || this.eventType == null)) {
            tProtocol.a(f2622g);
            tProtocol.a(this.eventType.intValue());
        }
        if (!(this.acknowledged == null || this.acknowledged == null)) {
            tProtocol.a(f2623h);
            tProtocol.a(this.acknowledged.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3782a(1, f2616a);
    }

    public final String m3782a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaRTCEventLog");
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
        if (this.eventType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("eventType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.eventType == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) RTCEventType.f2793b.get(this.eventType);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.eventType);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.acknowledged != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("acknowledged");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.acknowledged == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.acknowledged, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3780a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.eventType != null && !RTCEventType.f2792a.contains(this.eventType)) {
            throw new TProtocolException("The field 'eventType' has been assigned the invalid value " + this.eventType);
        }
    }
}
