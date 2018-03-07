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

/* compiled from: unable to find RGB8888 /%d EGLConfig */
public class DeltaAdminAddedToGroupThread implements TBase, Serializable, Cloneable {
    public static boolean f2488a = true;
    private static final TStruct f2489b = new TStruct("DeltaAdminAddedToGroupThread");
    private static final TField f2490c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2491d = new TField("addedAdmins", (byte) 15, (short) 2);
    public final List<ParticipantInfo> addedAdmins;
    public final MessageMetadata messageMetadata;

    private DeltaAdminAddedToGroupThread(MessageMetadata messageMetadata, List<ParticipantInfo> list) {
        this.messageMetadata = messageMetadata;
        this.addedAdmins = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaAdminAddedToGroupThread)) {
            return false;
        }
        DeltaAdminAddedToGroupThread deltaAdminAddedToGroupThread = (DeltaAdminAddedToGroupThread) obj;
        boolean z = false;
        if (deltaAdminAddedToGroupThread != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaAdminAddedToGroupThread.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaAdminAddedToGroupThread.messageMetadata))) {
                if (this.addedAdmins != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaAdminAddedToGroupThread.addedAdmins != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.addedAdmins.equals(deltaAdminAddedToGroupThread.addedAdmins))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaAdminAddedToGroupThread m3685b(TProtocol tProtocol) {
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
                            arrayList.add(ParticipantInfo.m3925b(tProtocol));
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaAdminAddedToGroupThread deltaAdminAddedToGroupThread = new DeltaAdminAddedToGroupThread(messageMetadata, list);
            deltaAdminAddedToGroupThread.m3684a();
            return deltaAdminAddedToGroupThread;
        }
    }

    public final void m3687a(TProtocol tProtocol) {
        m3684a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2490c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.addedAdmins != null) {
            tProtocol.a(f2491d);
            tProtocol.a(new TList((byte) 12, this.addedAdmins.size()));
            for (ParticipantInfo a : this.addedAdmins) {
                a.m3927a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3686a(1, f2488a);
    }

    public final String m3686a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaAdminAddedToGroupThread");
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
        stringBuilder.append("addedAdmins");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.addedAdmins == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.addedAdmins, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3684a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.addedAdmins == null) {
            throw new TProtocolException(6, "Required field 'addedAdmins' was not present! Struct: " + toString());
        }
    }
}
