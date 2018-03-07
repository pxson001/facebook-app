package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transition_ms */
public class DeltaThreadMuteSettings implements TBase, Serializable, Cloneable {
    public static boolean f2661a = true;
    private static final TStruct f2662b = new TStruct("DeltaThreadMuteSettings");
    private static final TField f2663c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2664d = new TField("expireTime", (byte) 10, (short) 2);
    public final Long expireTime;
    public final ThreadKey threadKey;

    private DeltaThreadMuteSettings(ThreadKey threadKey, Long l) {
        this.threadKey = threadKey;
        this.expireTime = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadMuteSettings)) {
            return false;
        }
        DeltaThreadMuteSettings deltaThreadMuteSettings = (DeltaThreadMuteSettings) obj;
        boolean z = false;
        if (deltaThreadMuteSettings != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaThreadMuteSettings.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaThreadMuteSettings.threadKey))) {
                if (this.expireTime != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaThreadMuteSettings.expireTime != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.expireTime.equals(deltaThreadMuteSettings.expireTime))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadMuteSettings m3814b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        ThreadKey threadKey = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        threadKey = ThreadKey.m3936b(tProtocol);
                        break;
                    case (short) 2:
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
            return new DeltaThreadMuteSettings(threadKey, l);
        }
    }

    public final void m3816a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2663c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.expireTime == null || this.expireTime == null)) {
            tProtocol.a(f2664d);
            tProtocol.a(this.expireTime.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3815a(1, f2661a);
    }

    public final String m3815a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadMuteSettings");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj = null;
        }
        if (this.expireTime != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("expireTime");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.expireTime == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.expireTime, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
