package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: trending_finite_serp */
public class DeltaThreadDelete implements TBase, Serializable, Cloneable {
    public static boolean f2650a = true;
    private static final TStruct f2651b = new TStruct("DeltaThreadDelete");
    private static final TField f2652c = new TField("threadKeys", (byte) 15, (short) 1);
    public final List<ThreadKey> threadKeys;

    private DeltaThreadDelete(List<ThreadKey> list) {
        this.threadKeys = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadDelete)) {
            return false;
        }
        DeltaThreadDelete deltaThreadDelete = (DeltaThreadDelete) obj;
        boolean z = false;
        if (deltaThreadDelete != null) {
            Object obj2 = this.threadKeys != null ? 1 : null;
            Object obj3;
            if (deltaThreadDelete.threadKeys != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.threadKeys.equals(deltaThreadDelete.threadKeys))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadDelete m3803b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TList h = tProtocol.h();
                        List arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list = arrayList;
                            }
                            arrayList.add(ThreadKey.m3936b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaThreadDelete(list);
        }
    }

    public final void m3805a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKeys == null || this.threadKeys == null)) {
            tProtocol.a(f2652c);
            tProtocol.a(new TList((byte) 12, this.threadKeys.size()));
            for (ThreadKey a : this.threadKeys) {
                a.m3938a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3804a(1, f2650a);
    }

    public final String m3804a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadDelete");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.threadKeys != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKeys");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKeys == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKeys, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
