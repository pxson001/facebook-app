package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: total_file_size */
public class TagCount implements TBase, Serializable, Cloneable {
    public static boolean f2803a = true;
    private static final TStruct f2804b = new TStruct("TagCount");
    private static final TField f2805c = new TField("count", (byte) 8, (short) 1);
    private static final TField f2806d = new TField("hasMore", (byte) 2, (short) 2);
    public final Integer count;
    public final Boolean hasMore;

    private TagCount(Integer num, Boolean bool) {
        this.count = num;
        this.hasMore = bool;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TagCount)) {
            return false;
        }
        TagCount tagCount = (TagCount) obj;
        boolean z = false;
        if (tagCount != null) {
            Object obj2;
            Object obj3 = this.count != null ? 1 : null;
            if (tagCount.count != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.count.equals(tagCount.count))) {
                if (this.hasMore != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (tagCount.hasMore != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.hasMore.equals(tagCount.hasMore))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static TagCount m3933b(TProtocol tProtocol) {
        Boolean bool = null;
        tProtocol.r();
        Integer num = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
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
            TagCount tagCount = new TagCount(num, bool);
            tagCount.m3932a();
            return tagCount;
        }
    }

    public final void m3935a(TProtocol tProtocol) {
        m3932a();
        tProtocol.a();
        if (this.count != null) {
            tProtocol.a(f2805c);
            tProtocol.a(this.count.intValue());
        }
        if (!(this.hasMore == null || this.hasMore == null)) {
            tProtocol.a(f2806d);
            tProtocol.a(this.hasMore.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3934a(1, f2803a);
    }

    public final String m3934a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("TagCount");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("count");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.count == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.count, i + 1, z));
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
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3932a() {
        if (this.count == null) {
            throw new TProtocolException(6, "Required field 'count' was not present! Struct: " + toString());
        }
    }
}
