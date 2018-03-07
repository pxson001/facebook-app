package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: turn_on_joinable_by_owner */
public class DeltaReadReceipt implements TBase, Serializable, Cloneable {
    public static boolean f2624a = true;
    private static final TStruct f2625b = new TStruct("DeltaReadReceipt");
    private static final TField f2626c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2627d = new TField("actorFbId", (byte) 10, (short) 2);
    private static final TField f2628e = new TField("actionTimestampMs", (byte) 10, (short) 3);
    private static final TField f2629f = new TField("watermarkTimestampMs", (byte) 10, (short) 4);
    public final Long actionTimestampMs;
    public final Long actorFbId;
    public final ThreadKey threadKey;
    public final Long watermarkTimestampMs;

    private DeltaReadReceipt(ThreadKey threadKey, Long l, Long l2, Long l3) {
        this.threadKey = threadKey;
        this.actorFbId = l;
        this.actionTimestampMs = l2;
        this.watermarkTimestampMs = l3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaReadReceipt)) {
            return false;
        }
        DeltaReadReceipt deltaReadReceipt = (DeltaReadReceipt) obj;
        boolean z = false;
        if (deltaReadReceipt != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaReadReceipt.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaReadReceipt.threadKey))) {
                if (this.actorFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaReadReceipt.actorFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actorFbId.equals(deltaReadReceipt.actorFbId))) {
                    if (this.actionTimestampMs != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaReadReceipt.actionTimestampMs != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actionTimestampMs.equals(deltaReadReceipt.actionTimestampMs))) {
                        if (this.watermarkTimestampMs != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaReadReceipt.watermarkTimestampMs != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.watermarkTimestampMs.equals(deltaReadReceipt.watermarkTimestampMs))) {
                            z = true;
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

    public static DeltaReadReceipt m3784b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Long l2 = null;
        Long l3 = null;
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
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
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
            return new DeltaReadReceipt(threadKey, l3, l2, l);
        }
    }

    public final void m3786a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2626c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.actorFbId == null || this.actorFbId == null)) {
            tProtocol.a(f2627d);
            tProtocol.a(this.actorFbId.longValue());
        }
        if (!(this.actionTimestampMs == null || this.actionTimestampMs == null)) {
            tProtocol.a(f2628e);
            tProtocol.a(this.actionTimestampMs.longValue());
        }
        if (!(this.watermarkTimestampMs == null || this.watermarkTimestampMs == null)) {
            tProtocol.a(f2629f);
            tProtocol.a(this.watermarkTimestampMs.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3785a(1, f2624a);
    }

    public final String m3785a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaReadReceipt");
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
        if (this.actorFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("actorFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actorFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actorFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.actionTimestampMs != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("actionTimestampMs");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actionTimestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actionTimestampMs, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.watermarkTimestampMs != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("watermarkTimestampMs");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.watermarkTimestampMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.watermarkTimestampMs, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
