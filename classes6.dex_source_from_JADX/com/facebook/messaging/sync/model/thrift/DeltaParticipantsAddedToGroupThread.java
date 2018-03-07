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

/* compiled from: typeaheadSessionId */
public class DeltaParticipantsAddedToGroupThread implements TBase, Serializable, Cloneable {
    public static boolean f2609a = true;
    private static final TStruct f2610b = new TStruct("DeltaParticipantsAddedToGroupThread");
    private static final TField f2611c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2612d = new TField("addedParticipants", (byte) 15, (short) 2);
    public final List<ParticipantInfo> addedParticipants;
    public final MessageMetadata messageMetadata;

    private DeltaParticipantsAddedToGroupThread(MessageMetadata messageMetadata, List<ParticipantInfo> list) {
        this.messageMetadata = messageMetadata;
        this.addedParticipants = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaParticipantsAddedToGroupThread)) {
            return false;
        }
        DeltaParticipantsAddedToGroupThread deltaParticipantsAddedToGroupThread = (DeltaParticipantsAddedToGroupThread) obj;
        boolean z = false;
        if (deltaParticipantsAddedToGroupThread != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaParticipantsAddedToGroupThread.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaParticipantsAddedToGroupThread.messageMetadata))) {
                if (this.addedParticipants != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaParticipantsAddedToGroupThread.addedParticipants != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.addedParticipants.equals(deltaParticipantsAddedToGroupThread.addedParticipants))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaParticipantsAddedToGroupThread m3774b(TProtocol tProtocol) {
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
            DeltaParticipantsAddedToGroupThread deltaParticipantsAddedToGroupThread = new DeltaParticipantsAddedToGroupThread(messageMetadata, list);
            deltaParticipantsAddedToGroupThread.m3773a();
            return deltaParticipantsAddedToGroupThread;
        }
    }

    public final void m3776a(TProtocol tProtocol) {
        m3773a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2611c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.addedParticipants == null || this.addedParticipants == null)) {
            tProtocol.a(f2612d);
            tProtocol.a(new TList((byte) 12, this.addedParticipants.size()));
            for (ParticipantInfo a : this.addedParticipants) {
                a.m3927a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3775a(1, f2609a);
    }

    public final String m3775a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaParticipantsAddedToGroupThread");
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
        if (this.addedParticipants != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("addedParticipants");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.addedParticipants == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.addedParticipants, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3773a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        }
    }
}
