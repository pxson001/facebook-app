package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: uMVPMatrix */
public class DeltaGenieMessage implements TBase, Serializable, Cloneable {
    public static boolean f2541a = true;
    private static final TStruct f2542b = new TStruct("DeltaGenieMessage");
    private static final TField f2543c = new TField("deltaNewMessage", (byte) 12, (short) 1);
    private static final TField f2544d = new TField("genieFbId", (byte) 10, (short) 2);
    public final DeltaNewMessage deltaNewMessage;
    public final Long genieFbId;

    private DeltaGenieMessage(DeltaNewMessage deltaNewMessage, Long l) {
        this.deltaNewMessage = deltaNewMessage;
        this.genieFbId = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaGenieMessage)) {
            return false;
        }
        DeltaGenieMessage deltaGenieMessage = (DeltaGenieMessage) obj;
        boolean z = false;
        if (deltaGenieMessage != null) {
            Object obj2;
            Object obj3 = this.deltaNewMessage != null ? 1 : null;
            if (deltaGenieMessage.deltaNewMessage != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deltaNewMessage.m3751a(deltaGenieMessage.deltaNewMessage))) {
                if (this.genieFbId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaGenieMessage.genieFbId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.genieFbId.equals(deltaGenieMessage.genieFbId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaGenieMessage m3722b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        DeltaNewMessage deltaNewMessage = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        deltaNewMessage = DeltaNewMessage.m3748b(tProtocol);
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
            DeltaGenieMessage deltaGenieMessage = new DeltaGenieMessage(deltaNewMessage, l);
            deltaGenieMessage.m3721a();
            return deltaGenieMessage;
        }
    }

    public final void m3724a(TProtocol tProtocol) {
        m3721a();
        tProtocol.a();
        if (this.deltaNewMessage != null) {
            tProtocol.a(f2543c);
            this.deltaNewMessage.m3750a(tProtocol);
        }
        if (this.genieFbId != null) {
            tProtocol.a(f2544d);
            tProtocol.a(this.genieFbId.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3723a(1, f2541a);
    }

    public final String m3723a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaGenieMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("deltaNewMessage");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.deltaNewMessage == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.deltaNewMessage, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("genieFbId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.genieFbId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.genieFbId, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3721a() {
        if (this.deltaNewMessage == null) {
            throw new TProtocolException(6, "Required field 'deltaNewMessage' was not present! Struct: " + toString());
        } else if (this.genieFbId == null) {
            throw new TProtocolException(6, "Required field 'genieFbId' was not present! Struct: " + toString());
        }
    }
}
