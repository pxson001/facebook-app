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

/* compiled from: typeahead_use_current_city_inference */
public class DeltaMessageDelete implements TBase, Serializable, Cloneable {
    public static boolean f2564a = true;
    private static final TStruct f2565b = new TStruct("DeltaMessageDelete");
    private static final TField f2566c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2567d = new TField("messageIds", (byte) 15, (short) 2);
    public final List<String> messageIds;
    public final ThreadKey threadKey;

    private DeltaMessageDelete(ThreadKey threadKey, List<String> list) {
        this.threadKey = threadKey;
        this.messageIds = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaMessageDelete)) {
            return false;
        }
        DeltaMessageDelete deltaMessageDelete = (DeltaMessageDelete) obj;
        boolean z = false;
        if (deltaMessageDelete != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaMessageDelete.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaMessageDelete.threadKey))) {
                if (this.messageIds != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaMessageDelete.messageIds != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageIds.equals(deltaMessageDelete.messageIds))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaMessageDelete m3738b(TProtocol tProtocol) {
        List list = null;
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
                            arrayList.add(tProtocol.p());
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaMessageDelete(threadKey, list);
        }
    }

    public final void m3740a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2566c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.messageIds == null || this.messageIds == null)) {
            tProtocol.a(f2567d);
            tProtocol.a(new TList((byte) 11, this.messageIds.size()));
            for (String a : this.messageIds) {
                tProtocol.a(a);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3739a(1, f2564a);
    }

    public final String m3739a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaMessageDelete");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj = null;
        }
        if (this.messageIds != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("messageIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.messageIds, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
