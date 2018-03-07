package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_intro_card_fav_photo */
public class ThreadPresenceFromClientThrift implements TBase, Serializable, Cloneable {
    public static boolean f2980a = true;
    private static final TStruct f2981b = new TStruct("ThreadPresenceFromClientThrift");
    private static final TField f2982c = new TField("recipient", (byte) 10, (short) 1);
    private static final TField f2983d = new TField("sender", (byte) 10, (short) 2);
    private static final TField f2984e = new TField("state", (byte) 8, (short) 3);
    public final Long recipient;
    public final Long sender;
    public final Integer state;

    public ThreadPresenceFromClientThrift(Long l, Long l2, Integer num) {
        this.recipient = l;
        this.sender = l2;
        this.state = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ThreadPresenceFromClientThrift)) {
            return false;
        }
        ThreadPresenceFromClientThrift threadPresenceFromClientThrift = (ThreadPresenceFromClientThrift) obj;
        boolean z = false;
        if (threadPresenceFromClientThrift != null) {
            Object obj2;
            Object obj3 = this.recipient != null ? 1 : null;
            if (threadPresenceFromClientThrift.recipient != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.recipient.equals(threadPresenceFromClientThrift.recipient))) {
                if (this.sender != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (threadPresenceFromClientThrift.sender != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.sender.equals(threadPresenceFromClientThrift.sender))) {
                    if (this.state != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (threadPresenceFromClientThrift.state != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.state.equals(threadPresenceFromClientThrift.state))) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m4009a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.recipient != null) {
            tProtocol.a(f2982c);
            tProtocol.a(this.recipient.longValue());
        }
        if (this.sender != null) {
            tProtocol.a(f2983d);
            tProtocol.a(this.sender.longValue());
        }
        if (this.state != null) {
            tProtocol.a(f2984e);
            tProtocol.a(this.state.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4008a(1, f2980a);
    }

    public final String m4008a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ThreadPresenceFromClientThrift");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("recipient");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.recipient == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.recipient, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("sender");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sender == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.sender, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("state");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.state == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.state, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
