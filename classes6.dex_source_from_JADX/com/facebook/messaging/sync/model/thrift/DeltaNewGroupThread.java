package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: typeahead_source */
public class DeltaNewGroupThread implements TBase, Serializable, Cloneable {
    public static boolean f2571a = true;
    private static final TStruct f2572b = new TStruct("DeltaNewGroupThread");
    private static final TField f2573c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2574d = new TField("participants", (byte) 15, (short) 2);
    public final List<ParticipantInfo> participants;
    public final ThreadKey threadKey;

    public DeltaNewGroupThread(ThreadKey threadKey, List<ParticipantInfo> list) {
        this.threadKey = threadKey;
        this.participants = list;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaNewGroupThread)) {
            return false;
        }
        DeltaNewGroupThread deltaNewGroupThread = (DeltaNewGroupThread) obj;
        boolean z = false;
        if (deltaNewGroupThread != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaNewGroupThread.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaNewGroupThread.threadKey))) {
                if (this.participants != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaNewGroupThread.participants != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.participants.equals(deltaNewGroupThread.participants))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3746a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2573c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.participants == null || this.participants == null)) {
            tProtocol.a(f2574d);
            tProtocol.a(new TList((byte) 12, this.participants.size()));
            for (ParticipantInfo a : this.participants) {
                a.m3927a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3745a(1, f2571a);
    }

    public final String m3745a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNewGroupThread");
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
        if (this.participants != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("participants");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.participants == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.participants, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
