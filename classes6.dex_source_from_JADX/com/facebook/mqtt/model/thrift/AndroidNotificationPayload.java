package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: topContextItemType */
public class AndroidNotificationPayload implements TBase, Serializable, Cloneable {
    public static boolean f2855a = true;
    private static final TStruct f2856b = new TStruct("AndroidNotificationPayload");
    private static final TField f2857c = new TField("type", (byte) 11, (short) 1);
    private static final TField f2858d = new TField("time", (byte) 10, (short) 2);
    private static final TField f2859e = new TField("message", (byte) 11, (short) 3);
    private static final TField f2860f = new TField("unread_count", (byte) 8, (short) 4);
    private static final TField f2861g = new TField("target_uid", (byte) 10, (short) 5);
    private static final TField f2862h = new TField("href", (byte) 11, (short) 6);
    private static final TField f2863i = new TField("params", (byte) 13, (short) 7);
    private static final TField f2864j = new TField("is_logged_out_push", (byte) 2, (short) 8);
    public final String href;
    public final Boolean is_logged_out_push;
    public final String message;
    public final Map<String, String> params;
    public final Long target_uid;
    public final Long time;
    public final String type;
    public final Integer unread_count;

    private AndroidNotificationPayload(String str, Long l, String str2, Integer num, Long l2, String str3, Map<String, String> map, Boolean bool) {
        this.type = str;
        this.time = l;
        this.message = str2;
        this.unread_count = num;
        this.target_uid = l2;
        this.href = str3;
        this.params = map;
        this.is_logged_out_push = bool;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AndroidNotificationPayload)) {
            return m3963a((AndroidNotificationPayload) obj);
        }
        return false;
    }

    public final boolean m3963a(AndroidNotificationPayload androidNotificationPayload) {
        if (androidNotificationPayload == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.type != null;
        if (androidNotificationPayload.type != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.type.equals(androidNotificationPayload.type))) {
            return false;
        }
        if (this.time != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.time != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.time.equals(androidNotificationPayload.time))) {
            return false;
        }
        if (this.message != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.message != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.message.equals(androidNotificationPayload.message))) {
            return false;
        }
        if (this.unread_count != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.unread_count != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.unread_count.equals(androidNotificationPayload.unread_count))) {
            return false;
        }
        if (this.target_uid != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.target_uid != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.target_uid.equals(androidNotificationPayload.target_uid))) {
            return false;
        }
        if (this.href != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.href != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.href.equals(androidNotificationPayload.href))) {
            return false;
        }
        if (this.params != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.params != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.params.equals(androidNotificationPayload.params))) {
            return false;
        }
        if (this.is_logged_out_push != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidNotificationPayload.is_logged_out_push != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.is_logged_out_push.equals(androidNotificationPayload.is_logged_out_push))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static AndroidNotificationPayload m3960b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        Map map = null;
        String str = null;
        Long l = null;
        Integer num = null;
        String str2 = null;
        Long l2 = null;
        String str3 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 7:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        map = new HashMap(Math.max(0, g.f5052c * 2));
                        int i = 0;
                        while (true) {
                            if (g.f5052c >= 0) {
                                if (i >= g.f5052c) {
                                    break;
                                }
                            } else if (!TProtocol.s()) {
                                break;
                            }
                            map.put(tProtocol.p(), tProtocol.p());
                            i++;
                        }
                    case (short) 8:
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
            return new AndroidNotificationPayload(str3, l2, str2, num, l, str, map, bool);
        }
    }

    public final void m3962a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.type != null) {
            tProtocol.a(f2857c);
            tProtocol.a(this.type);
        }
        if (this.time != null) {
            tProtocol.a(f2858d);
            tProtocol.a(this.time.longValue());
        }
        if (this.message != null) {
            tProtocol.a(f2859e);
            tProtocol.a(this.message);
        }
        if (this.unread_count != null) {
            tProtocol.a(f2860f);
            tProtocol.a(this.unread_count.intValue());
        }
        if (this.target_uid != null) {
            tProtocol.a(f2861g);
            tProtocol.a(this.target_uid.longValue());
        }
        if (!(this.href == null || this.href == null)) {
            tProtocol.a(f2862h);
            tProtocol.a(this.href);
        }
        if (!(this.params == null || this.params == null)) {
            tProtocol.a(f2863i);
            tProtocol.a(new TMap((byte) 11, (byte) 11, this.params.size()));
            for (Entry entry : this.params.entrySet()) {
                tProtocol.a((String) entry.getKey());
                tProtocol.a((String) entry.getValue());
            }
        }
        if (!(this.is_logged_out_push == null || this.is_logged_out_push == null)) {
            tProtocol.a(f2864j);
            tProtocol.a(this.is_logged_out_push.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3961a(1, f2855a);
    }

    public final String m3961a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AndroidNotificationPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("type");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.type, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("time");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.time == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.time, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("message");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.message == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.message, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("unread_count");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.unread_count == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.unread_count, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("target_uid");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.target_uid == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.target_uid, i + 1, z));
        }
        if (this.href != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("href");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.href == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.href, i + 1, z));
            }
        }
        if (this.params != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("params");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.params == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.params, i + 1, z));
            }
        }
        if (this.is_logged_out_push != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("is_logged_out_push");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.is_logged_out_push == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.is_logged_out_push, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
