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

/* compiled from: types */
public class DeltaMarkUnread implements TBase, Serializable, Cloneable {
    public static boolean f2560a = true;
    private static final TStruct f2561b = new TStruct("DeltaMarkUnread");
    private static final TField f2562c = new TField("threadKeys", (byte) 15, (short) 1);
    private static final TField f2563d = new TField("folders", (byte) 15, (short) 2);
    public final List<Integer> folders;
    public final List<ThreadKey> threadKeys;

    private DeltaMarkUnread(List<ThreadKey> list, List<Integer> list2) {
        this.threadKeys = list;
        this.folders = list2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaMarkUnread)) {
            return false;
        }
        DeltaMarkUnread deltaMarkUnread = (DeltaMarkUnread) obj;
        boolean z = false;
        if (deltaMarkUnread != null) {
            Object obj2;
            Object obj3 = this.threadKeys != null ? 1 : null;
            if (deltaMarkUnread.threadKeys != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKeys.equals(deltaMarkUnread.threadKeys))) {
                if (this.folders != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaMarkUnread.folders != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.folders.equals(deltaMarkUnread.folders))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaMarkUnread m3735b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        List list2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                TList h;
                List arrayList;
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list2 = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list2 = arrayList;
                            }
                            arrayList.add(ThreadKey.m3936b(tProtocol));
                            i++;
                        }
                    case (short) 2:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        arrayList = new ArrayList(Math.max(0, h.b));
                        int i2 = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i2 >= h.b) {
                                list = arrayList;
                            }
                            arrayList.add(Integer.valueOf(tProtocol.m()));
                            i2++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaMarkUnread(list2, list);
        }
    }

    public final void m3737a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKeys == null || this.threadKeys == null)) {
            tProtocol.a(f2562c);
            tProtocol.a(new TList((byte) 12, this.threadKeys.size()));
            for (ThreadKey a : this.threadKeys) {
                a.m3938a(tProtocol);
            }
        }
        if (!(this.folders == null || this.folders == null)) {
            tProtocol.a(f2563d);
            tProtocol.a(new TList((byte) 8, this.folders.size()));
            for (Integer intValue : this.folders) {
                tProtocol.a(intValue.intValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3736a(1, f2560a);
    }

    public final String m3736a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaMarkUnread");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
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
            obj = null;
        }
        if (this.folders != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("folders");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.folders == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.folders, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
