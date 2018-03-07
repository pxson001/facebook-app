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

/* compiled from: uConstMatrix */
public class DeltaMarkFolderSeen implements TBase, Serializable, Cloneable {
    public static boolean f2550a = true;
    private static final TStruct f2551b = new TStruct("DeltaMarkFolderSeen");
    private static final TField f2552c = new TField("folders", (byte) 15, (short) 1);
    private static final TField f2553d = new TField("timestamp", (byte) 10, (short) 2);
    public final List<Integer> folders;
    public final Long timestamp;

    private DeltaMarkFolderSeen(List<Integer> list, Long l) {
        this.folders = list;
        this.timestamp = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaMarkFolderSeen)) {
            return false;
        }
        DeltaMarkFolderSeen deltaMarkFolderSeen = (DeltaMarkFolderSeen) obj;
        boolean z = false;
        if (deltaMarkFolderSeen != null) {
            Object obj2;
            Object obj3 = this.folders != null ? 1 : null;
            if (deltaMarkFolderSeen.folders != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.folders.equals(deltaMarkFolderSeen.folders))) {
                if (this.timestamp != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaMarkFolderSeen.timestamp != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.timestamp.equals(deltaMarkFolderSeen.timestamp))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaMarkFolderSeen m3729b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        List list = null;
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
                        list = new ArrayList(Math.max(0, h.b));
                        int i = 0;
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
            return new DeltaMarkFolderSeen(list, l);
        }
    }

    public final void m3731a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.folders == null || this.folders == null)) {
            tProtocol.a(f2552c);
            tProtocol.a(new TList((byte) 8, this.folders.size()));
            for (Integer intValue : this.folders) {
                tProtocol.a(intValue.intValue());
            }
        }
        if (!(this.timestamp == null || this.timestamp == null)) {
            tProtocol.a(f2553d);
            tProtocol.a(this.timestamp.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3730a(1, f2550a);
    }

    public final String m3730a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaMarkFolderSeen");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.folders != null) {
            stringBuilder.append(a);
            stringBuilder.append("folders");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.folders == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.folders, i + 1, z));
            }
            obj = null;
        }
        if (this.timestamp != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("timestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.timestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.timestamp, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
