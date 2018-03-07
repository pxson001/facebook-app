package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: tincan_send_failed_nonretriable */
public class MarkThreadResponse implements TBase, Serializable, Cloneable {
    public static boolean f2919a = true;
    private static final TStruct f2920b = new TStruct("MarkThreadResponse");
    private static final TField f2921c = new TField("isSucceeded", (byte) 2, (short) 1);
    private static final TField f2922d = new TField("latestActionId", (byte) 10, (short) 2);
    private static final TField f2923e = new TField("requestActionId", (byte) 10, (short) 3);
    private static final TField f2924f = new TField("threadId", (byte) 11, (short) 4);
    private static final TField f2925g = new TField("errStr", (byte) 11, (short) 5);
    public final String errStr;
    public final Boolean isSucceeded;
    public final Long latestActionId;
    public final Long requestActionId;
    public final String threadId;

    private MarkThreadResponse(Boolean bool, Long l, Long l2, String str, String str2) {
        this.isSucceeded = bool;
        this.latestActionId = l;
        this.requestActionId = l2;
        this.threadId = str;
        this.errStr = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MarkThreadResponse)) {
            return false;
        }
        MarkThreadResponse markThreadResponse = (MarkThreadResponse) obj;
        boolean z = false;
        if (markThreadResponse != null) {
            Object obj2;
            Object obj3 = this.isSucceeded != null ? 1 : null;
            if (markThreadResponse.isSucceeded != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isSucceeded.equals(markThreadResponse.isSucceeded))) {
                if (this.latestActionId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (markThreadResponse.latestActionId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.latestActionId.equals(markThreadResponse.latestActionId))) {
                    if (this.requestActionId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (markThreadResponse.requestActionId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.requestActionId.equals(markThreadResponse.requestActionId))) {
                        if (this.threadId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (markThreadResponse.threadId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadId.equals(markThreadResponse.threadId))) {
                            if (this.errStr != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (markThreadResponse.errStr != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.errStr.equals(markThreadResponse.errStr))) {
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

    public static MarkThreadResponse m3986b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        String str2 = null;
        Long l = null;
        Long l2 = null;
        Boolean bool = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 5:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new MarkThreadResponse(bool, l2, l, str2, str);
        }
    }

    public final void m3988a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.isSucceeded != null) {
            tProtocol.a(f2921c);
            tProtocol.a(this.isSucceeded.booleanValue());
        }
        if (!(this.latestActionId == null || this.latestActionId == null)) {
            tProtocol.a(f2922d);
            tProtocol.a(this.latestActionId.longValue());
        }
        if (!(this.requestActionId == null || this.requestActionId == null)) {
            tProtocol.a(f2923e);
            tProtocol.a(this.requestActionId.longValue());
        }
        if (this.threadId != null) {
            tProtocol.a(f2924f);
            tProtocol.a(this.threadId);
        }
        if (this.errStr != null) {
            tProtocol.a(f2925g);
            tProtocol.a(this.errStr);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3987a(1, f2919a);
    }

    public final String m3987a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("MarkThreadResponse");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("isSucceeded");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.isSucceeded == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.isSucceeded, i + 1, z));
        }
        if (this.latestActionId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("latestActionId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.latestActionId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.latestActionId, i + 1, z));
            }
        }
        if (this.requestActionId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("requestActionId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.requestActionId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.requestActionId, i + 1, z));
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("threadId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.threadId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.threadId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("errStr");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.errStr == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.errStr, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
