package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_existing_fields_page_id */
public class DeltaPagesManagerEvent implements TBase, Serializable, Cloneable {
    public static boolean f2601a = true;
    private static final TStruct f2602b = new TStruct("DeltaPagesManagerEvent");
    private static final TField f2603c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2604d = new TField("jsonBlob", (byte) 11, (short) 2);
    public final String jsonBlob;
    public final ThreadKey threadKey;

    private DeltaPagesManagerEvent(ThreadKey threadKey, String str) {
        this.threadKey = threadKey;
        this.jsonBlob = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPagesManagerEvent)) {
            return false;
        }
        DeltaPagesManagerEvent deltaPagesManagerEvent = (DeltaPagesManagerEvent) obj;
        boolean z = false;
        if (deltaPagesManagerEvent != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaPagesManagerEvent.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaPagesManagerEvent.threadKey))) {
                if (this.jsonBlob != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPagesManagerEvent.jsonBlob != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.jsonBlob.equals(deltaPagesManagerEvent.jsonBlob))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPagesManagerEvent m3766b(TProtocol tProtocol) {
        String str = null;
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
            DeltaPagesManagerEvent deltaPagesManagerEvent = new DeltaPagesManagerEvent(threadKey, str);
            deltaPagesManagerEvent.m3765a();
            return deltaPagesManagerEvent;
        }
    }

    public final void m3768a(TProtocol tProtocol) {
        m3765a();
        tProtocol.a();
        if (this.threadKey != null) {
            tProtocol.a(f2603c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.jsonBlob == null || this.jsonBlob == null)) {
            tProtocol.a(f2604d);
            tProtocol.a(this.jsonBlob);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3767a(1, f2601a);
    }

    public final String m3767a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPagesManagerEvent");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("threadKey");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.threadKey == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
        }
        if (this.jsonBlob != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("jsonBlob");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.jsonBlob == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.jsonBlob, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3765a() {
        if (this.threadKey == null) {
            throw new TProtocolException(6, "Required field 'threadKey' was not present! Struct: " + toString());
        }
    }
}
