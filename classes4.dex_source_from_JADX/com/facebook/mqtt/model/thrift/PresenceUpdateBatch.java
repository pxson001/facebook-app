package com.facebook.mqtt.model.thrift;

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

/* compiled from: fetchStickerPacksAsync (DOWNLOADED) started */
public class PresenceUpdateBatch implements TBase, Serializable, Cloneable {
    public static boolean f11719a = true;
    private static final TStruct f11720b = new TStruct("PresenceUpdateBatch");
    private static final TField f11721c = new TField("isIncrementalUpdate", (byte) 2, (short) 1);
    private static final TField f11722d = new TField("updates", (byte) 15, (short) 2);
    public final Boolean isIncrementalUpdate;
    public final List<PresenceUpdate> updates;

    private PresenceUpdateBatch(Boolean bool, List<PresenceUpdate> list) {
        this.isIncrementalUpdate = bool;
        this.updates = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PresenceUpdateBatch)) {
            return false;
        }
        PresenceUpdateBatch presenceUpdateBatch = (PresenceUpdateBatch) obj;
        boolean z = false;
        if (presenceUpdateBatch != null) {
            Object obj2;
            Object obj3 = this.isIncrementalUpdate != null ? 1 : null;
            if (presenceUpdateBatch.isIncrementalUpdate != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isIncrementalUpdate.equals(presenceUpdateBatch.isIncrementalUpdate))) {
                if (this.updates != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (presenceUpdateBatch.updates != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.updates.equals(presenceUpdateBatch.updates))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static PresenceUpdateBatch m12265b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        Boolean bool = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.a(tProtocol, f.b);
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
                            arrayList.add(PresenceUpdate.b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new PresenceUpdateBatch(bool, list);
        }
    }

    public final void m12267a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.isIncrementalUpdate == null || this.isIncrementalUpdate == null)) {
            tProtocol.a(f11721c);
            tProtocol.a(this.isIncrementalUpdate.booleanValue());
        }
        if (!(this.updates == null || this.updates == null)) {
            tProtocol.a(f11722d);
            tProtocol.a(new TList((byte) 12, this.updates.size()));
            for (PresenceUpdate a : this.updates) {
                a.a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m12266a(1, f11719a);
    }

    public final String m12266a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PresenceUpdateBatch");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.isIncrementalUpdate != null) {
            stringBuilder.append(a);
            stringBuilder.append("isIncrementalUpdate");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isIncrementalUpdate == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.isIncrementalUpdate, i + 1, z));
            }
            obj = null;
        }
        if (this.updates != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("updates");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.updates == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.updates, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
