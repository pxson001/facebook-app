package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: too_slow_request */
public class Callability implements TBase, Serializable, Cloneable {
    public static boolean f2865a = true;
    private static final TStruct f2866b = new TStruct("Callability");
    private static final TField f2867c = new TField("userId", (byte) 10, (short) 1);
    private static final TField f2868d = new TField("has_permission", (byte) 2, (short) 2);
    private static final TField f2869e = new TField("is_callable_mobile", (byte) 2, (short) 3);
    private static final TField f2870f = new TField("is_callable_webrtc", (byte) 2, (short) 4);
    private static final TField f2871g = new TField("reason_code", (byte) 8, (short) 5);
    public final Boolean has_permission;
    public final Boolean is_callable_mobile;
    public final Boolean is_callable_webrtc;
    public final Integer reason_code;
    public final Long userId;

    public Callability(Long l, Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        this.userId = l;
        this.has_permission = bool;
        this.is_callable_mobile = bool2;
        this.is_callable_webrtc = bool3;
        this.reason_code = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Callability)) {
            return false;
        }
        Callability callability = (Callability) obj;
        boolean z = false;
        if (callability != null) {
            Object obj2;
            Object obj3 = this.userId != null ? 1 : null;
            if (callability.userId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.userId.equals(callability.userId))) {
                if (this.has_permission != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (callability.has_permission != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.has_permission.equals(callability.has_permission))) {
                    if (this.is_callable_mobile != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (callability.is_callable_mobile != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.is_callable_mobile.equals(callability.is_callable_mobile))) {
                        if (this.is_callable_webrtc != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (callability.is_callable_webrtc != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.is_callable_webrtc.equals(callability.is_callable_webrtc))) {
                            if (this.reason_code != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (callability.reason_code != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.reason_code.equals(callability.reason_code))) {
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

    public final void m3965a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.userId != null) {
            tProtocol.a(f2867c);
            tProtocol.a(this.userId.longValue());
        }
        if (this.has_permission != null) {
            tProtocol.a(f2868d);
            tProtocol.a(this.has_permission.booleanValue());
        }
        if (this.is_callable_mobile != null) {
            tProtocol.a(f2869e);
            tProtocol.a(this.is_callable_mobile.booleanValue());
        }
        if (this.is_callable_webrtc != null) {
            tProtocol.a(f2870f);
            tProtocol.a(this.is_callable_webrtc.booleanValue());
        }
        if (this.reason_code != null) {
            tProtocol.a(f2871g);
            tProtocol.a(this.reason_code.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3964a(1, f2865a);
    }

    public final String m3964a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("Callability");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("userId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.userId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.userId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("has_permission");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.has_permission == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.has_permission, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("is_callable_mobile");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.is_callable_mobile == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.is_callable_mobile, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("is_callable_webrtc");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.is_callable_webrtc == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.is_callable_webrtc, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("reason_code");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.reason_code == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.reason_code, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
