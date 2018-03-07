package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: uSceneMatrix */
public class DeltaForcedFetch implements TBase, Serializable, Cloneable {
    public static boolean f2532a = true;
    private static final TStruct f2533b = new TStruct("DeltaForcedFetch");
    private static final TField f2534c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2535d = new TField("messageId", (byte) 11, (short) 2);
    private static final TField f2536e = new TField("isLazy", (byte) 2, (short) 3);
    public final Boolean isLazy;
    public final String messageId;
    public final ThreadKey threadKey;

    private DeltaForcedFetch(ThreadKey threadKey, String str, Boolean bool) {
        this.threadKey = threadKey;
        this.messageId = str;
        this.isLazy = bool;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaForcedFetch)) {
            return false;
        }
        DeltaForcedFetch deltaForcedFetch = (DeltaForcedFetch) obj;
        boolean z = false;
        if (deltaForcedFetch != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaForcedFetch.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaForcedFetch.threadKey))) {
                if (this.messageId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaForcedFetch.messageId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageId.equals(deltaForcedFetch.messageId))) {
                    if (this.isLazy != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaForcedFetch.isLazy != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isLazy.equals(deltaForcedFetch.isLazy))) {
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

    public static DeltaForcedFetch m3714b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        String str = null;
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
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaForcedFetch(threadKey, str, bool);
        }
    }

    public final void m3716a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2534c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.messageId == null || this.messageId == null)) {
            tProtocol.a(f2535d);
            tProtocol.a(this.messageId);
        }
        if (!(this.isLazy == null || this.isLazy == null)) {
            tProtocol.a(f2536e);
            tProtocol.a(this.isLazy.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3715a(1, f2532a);
    }

    public final String m3715a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaForcedFetch");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
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
            obj2 = null;
        }
        if (this.messageId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("messageId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.messageId, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.isLazy != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("isLazy");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isLazy == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.isLazy, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
