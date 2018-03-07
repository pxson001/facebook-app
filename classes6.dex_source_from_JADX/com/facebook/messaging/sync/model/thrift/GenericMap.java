package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: transcode_dimension */
public class GenericMap implements TBase, Serializable, Cloneable {
    public static boolean f2726a = true;
    private static final TStruct f2727b = new TStruct("GenericMap");
    private static final TField f2728c = new TField("data", (byte) 13, (short) 1);
    public final Map<String, GenericMapValue> data;

    private GenericMap(Map<String, GenericMapValue> map) {
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GenericMap)) {
            return false;
        }
        GenericMap genericMap = (GenericMap) obj;
        boolean z = false;
        if (genericMap != null) {
            Object obj2 = this.data != null ? 1 : null;
            Object obj3;
            if (genericMap.data != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.data.equals(genericMap.data))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static GenericMap m3881b(TProtocol tProtocol) {
        Map map = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
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
                            hashMap.put(tProtocol.p(), GenericMapValue.m3903b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new GenericMap(map);
        }
    }

    public final void m3883a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.data == null || this.data == null)) {
            tProtocol.a(f2728c);
            tProtocol.a(new TMap((byte) 11, (byte) 12, this.data.size()));
            for (Entry entry : this.data.entrySet()) {
                tProtocol.a((String) entry.getKey());
                ((GenericMapValue) entry.getValue()).m3828a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3882a(1, f2726a);
    }

    public final String m3882a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GenericMap");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.data != null) {
            stringBuilder.append(a);
            stringBuilder.append("data");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.data == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.data, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
