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

/* compiled from: uColorAdjust */
public class DeltaMarkRead implements TBase, Serializable, Cloneable {
    public static boolean f2554a = true;
    private static final TStruct f2555b = new TStruct("DeltaMarkRead");
    private static final TField f2556c = new TField("threadKeys", (byte) 15, (short) 1);
    private static final TField f2557d = new TField("folders", (byte) 15, (short) 2);
    private static final TField f2558e = new TField("watermarkTimestamp", (byte) 10, (short) 3);
    private static final TField f2559f = new TField("actionTimestamp", (byte) 10, (short) 4);
    public final Long actionTimestamp;
    public final List<Integer> folders;
    public final List<ThreadKey> threadKeys;
    public final Long watermarkTimestamp;

    private DeltaMarkRead(List<ThreadKey> list, List<Integer> list2, Long l, Long l2) {
        this.threadKeys = list;
        this.folders = list2;
        this.watermarkTimestamp = l;
        this.actionTimestamp = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaMarkRead)) {
            return false;
        }
        DeltaMarkRead deltaMarkRead = (DeltaMarkRead) obj;
        boolean z = false;
        if (deltaMarkRead != null) {
            Object obj2;
            Object obj3 = this.threadKeys != null ? 1 : null;
            if (deltaMarkRead.threadKeys != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKeys.equals(deltaMarkRead.threadKeys))) {
                if (this.folders != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaMarkRead.folders != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.folders.equals(deltaMarkRead.folders))) {
                    if (this.watermarkTimestamp != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaMarkRead.watermarkTimestamp != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.watermarkTimestamp.equals(deltaMarkRead.watermarkTimestamp))) {
                        if (this.actionTimestamp != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaMarkRead.actionTimestamp != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actionTimestamp.equals(deltaMarkRead.actionTimestamp))) {
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

    public static DeltaMarkRead m3732b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Long l2 = null;
        List list = null;
        List list2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                TList h;
                int i;
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        list2 = new ArrayList(Math.max(0, h.b));
                        i = 0;
                        while (true) {
                            if (h.b >= 0) {
                                if (i >= h.b) {
                                    break;
                                }
                            } else if (!TProtocol.t()) {
                                break;
                            }
                            list2.add(ThreadKey.m3936b(tProtocol));
                            i++;
                        }
                    case (short) 2:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        list = new ArrayList(Math.max(0, h.b));
                        i = 0;
                        while (true) {
                            if (h.b >= 0) {
                                if (i >= h.b) {
                                    break;
                                }
                            } else if (!TProtocol.t()) {
                                break;
                            }
                            list.add(Integer.valueOf(tProtocol.m()));
                            i++;
                        }
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
            return new DeltaMarkRead(list2, list, l2, l);
        }
    }

    public final void m3734a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKeys == null || this.threadKeys == null)) {
            tProtocol.a(f2556c);
            tProtocol.a(new TList((byte) 12, this.threadKeys.size()));
            for (ThreadKey a : this.threadKeys) {
                a.m3938a(tProtocol);
            }
        }
        if (!(this.folders == null || this.folders == null)) {
            tProtocol.a(f2557d);
            tProtocol.a(new TList((byte) 8, this.folders.size()));
            for (Integer intValue : this.folders) {
                tProtocol.a(intValue.intValue());
            }
        }
        if (!(this.watermarkTimestamp == null || this.watermarkTimestamp == null)) {
            tProtocol.a(f2558e);
            tProtocol.a(this.watermarkTimestamp.longValue());
        }
        if (!(this.actionTimestamp == null || this.actionTimestamp == null)) {
            tProtocol.a(f2559f);
            tProtocol.a(this.actionTimestamp.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3733a(1, f2554a);
    }

    public final String m3733a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaMarkRead");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
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
            obj2 = null;
        }
        if (this.folders != null) {
            if (obj2 == null) {
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
            obj2 = null;
        }
        if (this.watermarkTimestamp != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("watermarkTimestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.watermarkTimestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.watermarkTimestamp, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.actionTimestamp != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("actionTimestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actionTimestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actionTimestamp, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
