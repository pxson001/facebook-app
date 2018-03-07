package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: upgrade_accept */
public class ThreadKey implements TBase, Serializable, Cloneable {
    public static boolean f2811a = true;
    private static final TStruct f2812b = new TStruct("ThreadKey");
    private static final TField f2813c = new TField("otherUserFbId", (byte) 10, (short) 1);
    private static final TField f2814d = new TField("threadFbId", (byte) 10, (short) 2);
    public final Long otherUserFbId;
    public final Long threadFbId;

    private ThreadKey(Long l, Long l2) {
        this.otherUserFbId = l;
        this.threadFbId = l2;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ThreadKey)) {
            return m3939a((ThreadKey) obj);
        }
        return false;
    }

    public final boolean m3939a(ThreadKey threadKey) {
        if (threadKey == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.otherUserFbId != null;
        if (threadKey.otherUserFbId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.otherUserFbId.equals(threadKey.otherUserFbId))) {
            return false;
        }
        if (this.threadFbId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (threadKey.threadFbId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.threadFbId.equals(threadKey.threadFbId))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static ThreadKey m3936b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Long l2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
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
            return new ThreadKey(l2, l);
        }
    }

    public final void m3938a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.otherUserFbId == null || this.otherUserFbId == null)) {
            tProtocol.a(f2813c);
            tProtocol.a(this.otherUserFbId.longValue());
        }
        if (!(this.threadFbId == null || this.threadFbId == null)) {
            tProtocol.a(f2814d);
            tProtocol.a(this.threadFbId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3937a(1, f2811a);
    }

    public final String m3937a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ThreadKey");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.otherUserFbId != null) {
            stringBuilder.append(a);
            stringBuilder.append("otherUserFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.otherUserFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.otherUserFbId, i + 1, z));
            }
            obj = null;
        }
        if (this.threadFbId != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("threadFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadFbId, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
