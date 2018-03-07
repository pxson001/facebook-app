package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transcode_success */
public class FailedSend implements TBase, Serializable, Cloneable {
    public static boolean f2720a = true;
    private static final TStruct f2721b = new TStruct("FailedSend");
    private static final TField f2722c = new TField("offlineThreadingId", (byte) 10, (short) 1);
    private static final TField f2723d = new TField("errorMessage", (byte) 11, (short) 2);
    private static final TField f2724e = new TField("isRetryable", (byte) 2, (short) 3);
    private static final TField f2725f = new TField("errorCode", (byte) 8, (short) 4);
    public final Integer errorCode;
    public final String errorMessage;
    public final Boolean isRetryable;
    public final Long offlineThreadingId;

    private FailedSend(Long l, String str, Boolean bool, Integer num) {
        this.offlineThreadingId = l;
        this.errorMessage = str;
        this.isRetryable = bool;
        this.errorCode = num;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof FailedSend)) {
            return m3880a((FailedSend) obj);
        }
        return false;
    }

    public final boolean m3880a(FailedSend failedSend) {
        if (failedSend == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.offlineThreadingId != null;
        if (failedSend.offlineThreadingId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.offlineThreadingId.equals(failedSend.offlineThreadingId))) {
            return false;
        }
        if (this.errorMessage != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (failedSend.errorMessage != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.errorMessage.equals(failedSend.errorMessage))) {
            return false;
        }
        if (this.isRetryable != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (failedSend.isRetryable != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.isRetryable.equals(failedSend.isRetryable))) {
            return false;
        }
        if (this.errorCode != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (failedSend.errorCode != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.errorCode.equals(failedSend.errorCode))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static FailedSend m3877b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        Boolean bool = null;
        String str = null;
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
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new FailedSend(l, str, bool, num);
        }
    }

    public final void m3879a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f2722c);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.errorMessage == null || this.errorMessage == null)) {
            tProtocol.a(f2723d);
            tProtocol.a(this.errorMessage);
        }
        if (!(this.isRetryable == null || this.isRetryable == null)) {
            tProtocol.a(f2724e);
            tProtocol.a(this.isRetryable.booleanValue());
        }
        if (!(this.errorCode == null || this.errorCode == null)) {
            tProtocol.a(f2725f);
            tProtocol.a(this.errorCode.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3878a(1, f2720a);
    }

    public final String m3878a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("FailedSend");
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
        if (this.errorMessage != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("errorMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.errorMessage == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.errorMessage, i + 1, z));
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
        } else {
            obj = obj2;
        }
        if (this.errorCode != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("errorCode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.errorCode == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.errorCode, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
