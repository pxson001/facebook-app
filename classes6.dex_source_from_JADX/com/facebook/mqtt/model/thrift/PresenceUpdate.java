package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timestampMs */
public class PresenceUpdate implements TBase, Serializable, Cloneable {
    public static boolean f2931a = true;
    private static final TStruct f2932b = new TStruct("PresenceUpdate");
    private static final TField f2933c = new TField("uid", (byte) 10, (short) 1);
    private static final TField f2934d = new TField("state", (byte) 8, (short) 2);
    private static final TField f2935e = new TField("lastActiveTimeSec", (byte) 10, (short) 3);
    private static final TField f2936f = new TField("detailedClientPresence", (byte) 6, (short) 4);
    private static final TField f2937g = new TField("voipCapabilities", (byte) 10, (short) 5);
    public final Short detailedClientPresence;
    public final Long lastActiveTimeSec;
    public final Integer state;
    public final Long uid;
    public final Long voipCapabilities;

    private PresenceUpdate(Long l, Integer num, Long l2, Short sh, Long l3) {
        this.uid = l;
        this.state = num;
        this.lastActiveTimeSec = l2;
        this.detailedClientPresence = sh;
        this.voipCapabilities = l3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PresenceUpdate)) {
            return false;
        }
        PresenceUpdate presenceUpdate = (PresenceUpdate) obj;
        boolean z = false;
        if (presenceUpdate != null) {
            Object obj2;
            Object obj3 = this.uid != null ? 1 : null;
            if (presenceUpdate.uid != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.uid.equals(presenceUpdate.uid))) {
                if (this.state != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (presenceUpdate.state != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.state.equals(presenceUpdate.state))) {
                    if (this.lastActiveTimeSec != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (presenceUpdate.lastActiveTimeSec != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.lastActiveTimeSec.equals(presenceUpdate.lastActiveTimeSec))) {
                        if (this.detailedClientPresence != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (presenceUpdate.detailedClientPresence != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.detailedClientPresence.equals(presenceUpdate.detailedClientPresence))) {
                            if (this.voipCapabilities != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (presenceUpdate.voipCapabilities != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.voipCapabilities.equals(presenceUpdate.voipCapabilities))) {
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

    public static PresenceUpdate m3992b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Short sh = null;
        Long l2 = null;
        Integer num = null;
        Long l3 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
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
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 6) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        sh = Short.valueOf(tProtocol.l());
                        break;
                    case (short) 5:
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
            PresenceUpdate presenceUpdate = new PresenceUpdate(l3, num, l2, sh, l);
            presenceUpdate.m3991a();
            return presenceUpdate;
        }
    }

    public final void m3994a(TProtocol tProtocol) {
        m3991a();
        tProtocol.a();
        if (!(this.uid == null || this.uid == null)) {
            tProtocol.a(f2933c);
            tProtocol.a(this.uid.longValue());
        }
        if (!(this.state == null || this.state == null)) {
            tProtocol.a(f2934d);
            tProtocol.a(this.state.intValue());
        }
        if (!(this.lastActiveTimeSec == null || this.lastActiveTimeSec == null)) {
            tProtocol.a(f2935e);
            tProtocol.a(this.lastActiveTimeSec.longValue());
        }
        if (!(this.detailedClientPresence == null || this.detailedClientPresence == null)) {
            tProtocol.a(f2936f);
            tProtocol.a(this.detailedClientPresence.shortValue());
        }
        if (!(this.voipCapabilities == null || this.voipCapabilities == null)) {
            tProtocol.a(f2937g);
            tProtocol.a(this.voipCapabilities.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3993a(1, f2931a);
    }

    public final String m3993a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PresenceUpdate");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.uid != null) {
            stringBuilder.append(a);
            stringBuilder.append("uid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.uid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.uid, i + 1, z));
            }
            obj2 = null;
        }
        if (this.state != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("state");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.state == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) PresenceState.f2930b.get(this.state);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.state);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.lastActiveTimeSec != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("lastActiveTimeSec");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.lastActiveTimeSec == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.lastActiveTimeSec, i + 1, z));
            }
            obj2 = null;
        }
        if (this.detailedClientPresence != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("detailedClientPresence");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.detailedClientPresence == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.detailedClientPresence, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.voipCapabilities != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("voipCapabilities");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.voipCapabilities == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.voipCapabilities, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3991a() {
        if (this.state != null && !PresenceState.f2929a.contains(this.state)) {
            throw new TProtocolException("The field 'state' has been assigned the invalid value " + this.state);
        }
    }
}
