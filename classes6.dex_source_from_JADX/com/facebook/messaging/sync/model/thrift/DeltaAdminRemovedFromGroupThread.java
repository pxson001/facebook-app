package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ul_bwe */
public class DeltaAdminRemovedFromGroupThread implements TBase, Serializable, Cloneable {
    public static boolean f2492a = true;
    private static final TStruct f2493b = new TStruct("DeltaAdminRemovedFromGroupThread");
    private static final TField f2494c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2495d = new TField("removedAdminFbIds", (byte) 15, (short) 2);
    public final MessageMetadata messageMetadata;
    public final List<Long> removedAdminFbIds;

    private DeltaAdminRemovedFromGroupThread(MessageMetadata messageMetadata, List<Long> list) {
        this.messageMetadata = messageMetadata;
        this.removedAdminFbIds = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaAdminRemovedFromGroupThread)) {
            return false;
        }
        DeltaAdminRemovedFromGroupThread deltaAdminRemovedFromGroupThread = (DeltaAdminRemovedFromGroupThread) obj;
        boolean z = false;
        if (deltaAdminRemovedFromGroupThread != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaAdminRemovedFromGroupThread.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaAdminRemovedFromGroupThread.messageMetadata))) {
                if (this.removedAdminFbIds != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaAdminRemovedFromGroupThread.removedAdminFbIds != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.removedAdminFbIds.equals(deltaAdminRemovedFromGroupThread.removedAdminFbIds))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaAdminRemovedFromGroupThread m3689b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        MessageMetadata messageMetadata = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        messageMetadata = MessageMetadata.m3917b(tProtocol);
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
                            arrayList.add(Long.valueOf(tProtocol.n()));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaAdminRemovedFromGroupThread deltaAdminRemovedFromGroupThread = new DeltaAdminRemovedFromGroupThread(messageMetadata, list);
            deltaAdminRemovedFromGroupThread.m3688a();
            return deltaAdminRemovedFromGroupThread;
        }
    }

    public final void m3691a(TProtocol tProtocol) {
        m3688a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2494c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.removedAdminFbIds != null) {
            tProtocol.a(f2495d);
            tProtocol.a(new TList((byte) 10, this.removedAdminFbIds.size()));
            for (Long longValue : this.removedAdminFbIds) {
                tProtocol.a(longValue.longValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3690a(1, f2492a);
    }

    public final String m3690a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaAdminRemovedFromGroupThread");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("messageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.messageMetadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.messageMetadata, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("removedAdminFbIds");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.removedAdminFbIds == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.removedAdminFbIds, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3688a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.removedAdminFbIds == null) {
            throw new TProtocolException(6, "Required field 'removedAdminFbIds' was not present! Struct: " + toString());
        }
    }
}
