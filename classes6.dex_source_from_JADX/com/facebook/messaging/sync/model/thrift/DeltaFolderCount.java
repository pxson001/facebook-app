package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: uTexMatrix */
public class DeltaFolderCount implements TBase, Serializable, Cloneable {
    public static boolean f2526a = true;
    private static final TStruct f2527b = new TStruct("DeltaFolderCount");
    private static final TField f2528c = new TField("threadFolder", (byte) 8, (short) 1);
    private static final TField f2529d = new TField("count", (byte) 8, (short) 2);
    private static final TField f2530e = new TField("hasMore", (byte) 2, (short) 3);
    private static final TField f2531f = new TField("counts", (byte) 13, (short) 4);
    public final Integer count;
    public final Map<Integer, TagCount> counts;
    public final Boolean hasMore;
    public final Integer threadFolder;

    private DeltaFolderCount(Integer num, Integer num2, Boolean bool, Map<Integer, TagCount> map) {
        this.threadFolder = num;
        this.count = num2;
        this.hasMore = bool;
        this.counts = map;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaFolderCount)) {
            return false;
        }
        DeltaFolderCount deltaFolderCount = (DeltaFolderCount) obj;
        boolean z = false;
        if (deltaFolderCount != null) {
            Object obj2;
            Object obj3 = this.threadFolder != null ? 1 : null;
            if (deltaFolderCount.threadFolder != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadFolder.equals(deltaFolderCount.threadFolder))) {
                if (this.count != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaFolderCount.count != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.count.equals(deltaFolderCount.count))) {
                    if (this.hasMore != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaFolderCount.hasMore != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.hasMore.equals(deltaFolderCount.hasMore))) {
                        if (this.counts != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaFolderCount.counts != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.counts.equals(deltaFolderCount.counts))) {
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

    public static DeltaFolderCount m3711b(TProtocol tProtocol) {
        Map map = null;
        tProtocol.r();
        Boolean bool = null;
        Integer num = null;
        Integer num2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        Map hashMap = new HashMap(Math.max(0, g.f5052c * 2));
                        int i = 0;
                        while (true) {
                            if (g.f5052c < 0) {
                                if (!TProtocol.s()) {
                                    map = hashMap;
                                    break;
                                }
                            } else if (i >= g.f5052c) {
                                map = hashMap;
                            }
                            hashMap.put(Integer.valueOf(tProtocol.m()), TagCount.m3933b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaFolderCount deltaFolderCount = new DeltaFolderCount(num2, num, bool, map);
            deltaFolderCount.m3710a();
            return deltaFolderCount;
        }
    }

    public final void m3713a(TProtocol tProtocol) {
        m3710a();
        tProtocol.a();
        if (this.threadFolder != null) {
            tProtocol.a(f2528c);
            tProtocol.a(this.threadFolder.intValue());
        }
        if (!(this.count == null || this.count == null)) {
            tProtocol.a(f2529d);
            tProtocol.a(this.count.intValue());
        }
        if (!(this.hasMore == null || this.hasMore == null)) {
            tProtocol.a(f2530e);
            tProtocol.a(this.hasMore.booleanValue());
        }
        if (!(this.counts == null || this.counts == null)) {
            tProtocol.a(f2531f);
            tProtocol.a(new TMap((byte) 8, (byte) 12, this.counts.size()));
            for (Entry entry : this.counts.entrySet()) {
                tProtocol.a(((Integer) entry.getKey()).intValue());
                ((TagCount) entry.getValue()).m3935a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3712a(1, f2526a);
    }

    public final String m3712a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaFolderCount");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("threadFolder");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.threadFolder == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) ThreadFolder.f2810b.get(this.threadFolder);
            if (str3 != null) {
                stringBuilder.append(str3);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.threadFolder);
            if (str3 != null) {
                stringBuilder.append(")");
            }
        }
        if (this.count != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("count");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.count == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.count, i + 1, z));
            }
        }
        if (this.hasMore != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("hasMore");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.hasMore == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.hasMore, i + 1, z));
            }
        }
        if (this.counts != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("counts");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.counts == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.counts, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3710a() {
        if (this.threadFolder == null) {
            throw new TProtocolException(6, "Required field 'threadFolder' was not present! Struct: " + toString());
        } else if (this.threadFolder != null && !ThreadFolder.f2809a.contains(this.threadFolder)) {
            throw new TProtocolException("The field 'threadFolder' has been assigned the invalid value " + this.threadFolder);
        }
    }
}
