package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: click_email_row */
public class CallerIDPayload implements TBase, Serializable, Cloneable {
    public static boolean f18112a = true;
    private static final TStruct f18113b = new TStruct("CallerIDPayload");
    private static final TField f18114c = new TField("user_id", (byte) 10, (short) 2);
    private static final TField f18115d = new TField("first_name", (byte) 11, (short) 3);
    private static final TField f18116e = new TField("last_name", (byte) 11, (short) 4);
    public final String first_name;
    public final String last_name;
    public final Long user_id;

    private CallerIDPayload(Long l, String str, String str2) {
        this.user_id = l;
        this.first_name = str;
        this.last_name = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CallerIDPayload)) {
            return false;
        }
        CallerIDPayload callerIDPayload = (CallerIDPayload) obj;
        boolean z = false;
        if (callerIDPayload != null) {
            Object obj2;
            Object obj3 = this.user_id != null ? 1 : null;
            if (callerIDPayload.user_id != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.user_id.equals(callerIDPayload.user_id))) {
                if (this.first_name != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (callerIDPayload.first_name != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.first_name.equals(callerIDPayload.first_name))) {
                    if (this.last_name != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (callerIDPayload.last_name != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.last_name.equals(callerIDPayload.last_name))) {
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

    public static CallerIDPayload m18075b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        String str2 = null;
        Long l = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new CallerIDPayload(l, str2, str);
        }
    }

    public final void m18077a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.user_id != null) {
            tProtocol.a(f18114c);
            tProtocol.a(this.user_id.longValue());
        }
        if (this.first_name != null) {
            tProtocol.a(f18115d);
            tProtocol.a(this.first_name);
        }
        if (this.last_name != null) {
            tProtocol.a(f18116e);
            tProtocol.a(this.last_name);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18076a(1, f18112a);
    }

    public final String m18076a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("CallerIDPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("user_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.user_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.user_id, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("first_name");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.first_name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.first_name, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("last_name");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.last_name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.last_name, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
