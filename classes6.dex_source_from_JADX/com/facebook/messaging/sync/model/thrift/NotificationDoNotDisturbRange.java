package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: tracking_data_key */
public class NotificationDoNotDisturbRange implements TBase, Serializable, Cloneable {
    public static boolean f2776a = true;
    private static final TStruct f2777b = new TStruct("NotificationDoNotDisturbRange");
    private static final TField f2778c = new TField("days", (byte) 3, (short) 1);
    private static final TField f2779d = new TField("startMinutes", (byte) 6, (short) 2);
    private static final TField f2780e = new TField("durationMinutes", (byte) 6, (short) 3);
    public final Byte days;
    public final Short durationMinutes;
    public final Short startMinutes;

    private NotificationDoNotDisturbRange(Byte b, Short sh, Short sh2) {
        this.days = b;
        this.startMinutes = sh;
        this.durationMinutes = sh2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NotificationDoNotDisturbRange)) {
            return false;
        }
        NotificationDoNotDisturbRange notificationDoNotDisturbRange = (NotificationDoNotDisturbRange) obj;
        boolean z = false;
        if (notificationDoNotDisturbRange != null) {
            Object obj2;
            Object obj3 = this.days != null ? 1 : null;
            if (notificationDoNotDisturbRange.days != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.days.equals(notificationDoNotDisturbRange.days))) {
                if (this.startMinutes != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (notificationDoNotDisturbRange.startMinutes != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.startMinutes.equals(notificationDoNotDisturbRange.startMinutes))) {
                    if (this.durationMinutes != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (notificationDoNotDisturbRange.durationMinutes != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.durationMinutes.equals(notificationDoNotDisturbRange.durationMinutes))) {
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

    public static NotificationDoNotDisturbRange m3922b(TProtocol tProtocol) {
        Short sh = null;
        tProtocol.r();
        Short sh2 = null;
        Byte b = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 3) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        b = Byte.valueOf(tProtocol.k());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 6) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        sh2 = Short.valueOf(tProtocol.l());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 6) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        sh = Short.valueOf(tProtocol.l());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            NotificationDoNotDisturbRange notificationDoNotDisturbRange = new NotificationDoNotDisturbRange(b, sh2, sh);
            notificationDoNotDisturbRange.m3921a();
            return notificationDoNotDisturbRange;
        }
    }

    public final void m3924a(TProtocol tProtocol) {
        m3921a();
        tProtocol.a();
        if (this.days != null) {
            tProtocol.a(f2778c);
            tProtocol.a(this.days.byteValue());
        }
        if (this.startMinutes != null) {
            tProtocol.a(f2779d);
            tProtocol.a(this.startMinutes.shortValue());
        }
        if (this.durationMinutes != null) {
            tProtocol.a(f2780e);
            tProtocol.a(this.durationMinutes.shortValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3923a(1, f2776a);
    }

    public final String m3923a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("NotificationDoNotDisturbRange");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("days");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.days == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.days, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("startMinutes");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.startMinutes == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.startMinutes, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("durationMinutes");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.durationMinutes == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.durationMinutes, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3921a() {
        if (this.days == null) {
            throw new TProtocolException(6, "Required field 'days' was not present! Struct: " + toString());
        } else if (this.startMinutes == null) {
            throw new TProtocolException(6, "Required field 'startMinutes' was not present! Struct: " + toString());
        } else if (this.durationMinutes == null) {
            throw new TProtocolException(6, "Required field 'durationMinutes' was not present! Struct: " + toString());
        }
    }
}
