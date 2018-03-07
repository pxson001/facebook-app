package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_profile_photo */
public class SendMessageResponse implements TBase, Serializable, Cloneable {
    public static boolean f2967a = true;
    private static final TStruct f2968b = new TStruct("SendMessageResponse");
    private static final TField f2969c = new TField("offlineThreadingId", (byte) 10, (short) 1);
    private static final TField f2970d = new TField("sendSucceeded", (byte) 2, (short) 2);
    private static final TField f2971e = new TField("errno", (byte) 8, (short) 3);
    private static final TField f2972f = new TField("errStr", (byte) 11, (short) 4);
    private static final TField f2973g = new TField("isRetryable", (byte) 2, (short) 5);
    private static final TField f2974h = new TField("fbTraceMeta", (byte) 11, (short) 6);
    private static final TField f2975i = new TField("isSICheckInMqttFailed", (byte) 2, (short) 7);
    public final String errStr;
    public final Integer errno;
    public final String fbTraceMeta;
    public final Boolean isRetryable;
    public final Boolean isSICheckInMqttFailed;
    public final Long offlineThreadingId;
    public final Boolean sendSucceeded;

    private SendMessageResponse(Long l, Boolean bool, Integer num, String str, Boolean bool2, String str2, Boolean bool3) {
        this.offlineThreadingId = l;
        this.sendSucceeded = bool;
        this.errno = num;
        this.errStr = str;
        this.isRetryable = bool2;
        this.fbTraceMeta = str2;
        this.isSICheckInMqttFailed = bool3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SendMessageResponse)) {
            return false;
        }
        SendMessageResponse sendMessageResponse = (SendMessageResponse) obj;
        boolean z = false;
        if (sendMessageResponse != null) {
            Object obj2;
            Object obj3 = this.offlineThreadingId != null ? 1 : null;
            if (sendMessageResponse.offlineThreadingId != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.offlineThreadingId.equals(sendMessageResponse.offlineThreadingId))) {
                if (this.sendSucceeded != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (sendMessageResponse.sendSucceeded != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.sendSucceeded.equals(sendMessageResponse.sendSucceeded))) {
                    if (this.errno != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (sendMessageResponse.errno != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.errno.equals(sendMessageResponse.errno))) {
                        if (this.errStr != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (sendMessageResponse.errStr != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.errStr.equals(sendMessageResponse.errStr))) {
                            if (this.isRetryable != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (sendMessageResponse.isRetryable != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isRetryable.equals(sendMessageResponse.isRetryable))) {
                                if (this.fbTraceMeta != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (sendMessageResponse.fbTraceMeta != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.fbTraceMeta.equals(sendMessageResponse.fbTraceMeta))) {
                                    if (this.isSICheckInMqttFailed != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (sendMessageResponse.isSICheckInMqttFailed != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isSICheckInMqttFailed.equals(sendMessageResponse.isSICheckInMqttFailed))) {
                                        z = true;
                                    }
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

    public static SendMessageResponse m4003b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        String str = null;
        Boolean bool2 = null;
        String str2 = null;
        Integer num = null;
        Boolean bool3 = null;
        Long l = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool3 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 5:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool2 = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 7:
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
            return new SendMessageResponse(l, bool3, num, str2, bool2, str, bool);
        }
    }

    public final void m4005a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f2969c);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.sendSucceeded == null || this.sendSucceeded == null)) {
            tProtocol.a(f2970d);
            tProtocol.a(this.sendSucceeded.booleanValue());
        }
        if (!(this.errno == null || this.errno == null)) {
            tProtocol.a(f2971e);
            tProtocol.a(this.errno.intValue());
        }
        if (!(this.errStr == null || this.errStr == null)) {
            tProtocol.a(f2972f);
            tProtocol.a(this.errStr);
        }
        if (!(this.isRetryable == null || this.isRetryable == null)) {
            tProtocol.a(f2973g);
            tProtocol.a(this.isRetryable.booleanValue());
        }
        if (!(this.fbTraceMeta == null || this.fbTraceMeta == null)) {
            tProtocol.a(f2974h);
            tProtocol.a(this.fbTraceMeta);
        }
        if (!(this.isSICheckInMqttFailed == null || this.isSICheckInMqttFailed == null)) {
            tProtocol.a(f2975i);
            tProtocol.a(this.isSICheckInMqttFailed.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4004a(1, f2967a);
    }

    public final String m4004a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SendMessageResponse");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.offlineThreadingId != null) {
            stringBuilder.append(a);
            stringBuilder.append("offlineThreadingId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.offlineThreadingId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.offlineThreadingId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.sendSucceeded != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("sendSucceeded");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.sendSucceeded == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.sendSucceeded, i + 1, z));
            }
            obj2 = null;
        }
        if (this.errno != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("errno");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.errno == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.errno, i + 1, z));
            }
            obj2 = null;
        }
        if (this.errStr != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("errStr");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.errStr == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.errStr, i + 1, z));
            }
            obj2 = null;
        }
        if (this.isRetryable != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("isRetryable");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isRetryable == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isRetryable, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fbTraceMeta != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fbTraceMeta");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbTraceMeta == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.fbTraceMeta, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.isSICheckInMqttFailed != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("isSICheckInMqttFailed");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isSICheckInMqttFailed == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isSICheckInMqttFailed, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
