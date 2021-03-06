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

/* compiled from: tutorial_nux/ */
public class DeltaPinnedGroups implements TBase, Serializable, Cloneable {
    public static boolean f2613a = true;
    private static final TStruct f2614b = new TStruct("DeltaPinnedGroups");
    private static final TField f2615c = new TField("threadKeys", (byte) 15, (short) 1);
    public final List<ThreadKey> threadKeys;

    private DeltaPinnedGroups(List<ThreadKey> list) {
        this.threadKeys = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPinnedGroups)) {
            return false;
        }
        DeltaPinnedGroups deltaPinnedGroups = (DeltaPinnedGroups) obj;
        boolean z = false;
        if (deltaPinnedGroups != null) {
            Object obj2 = this.threadKeys != null ? 1 : null;
            Object obj3;
            if (deltaPinnedGroups.threadKeys != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.threadKeys.equals(deltaPinnedGroups.threadKeys))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPinnedGroups m3777b(TProtocol tProtocol) {
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
            return new DeltaPinnedGroups(list);
        }
    }

    public final void m3779a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKeys == null || this.threadKeys == null)) {
            tProtocol.a(f2615c);
            tProtocol.a(new TList((byte) 12, this.threadKeys.size()));
            for (ThreadKey a : this.threadKeys) {
                a.m3938a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3778a(1, f2613a);
    }

    public final String m3778a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPinnedGroups");
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
