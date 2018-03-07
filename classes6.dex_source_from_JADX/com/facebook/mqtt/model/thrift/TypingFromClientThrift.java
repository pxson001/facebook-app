package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: timeline_cover_photo */
public class TypingFromClientThrift implements TBase, Serializable, Cloneable {
    public static boolean f2991a = true;
    private static final TStruct f2992b = new TStruct("TypingFromClientThrift");
    private static final TField f2993c = new TField("recipient", (byte) 10, (short) 1);
    private static final TField f2994d = new TField("sender", (byte) 10, (short) 2);
    private static final TField f2995e = new TField("state", (byte) 8, (short) 3);
    public final Long recipient;
    public final Long sender;
    public final Integer state;

    public TypingFromClientThrift(Long l, Long l2, Integer num) {
        this.recipient = l;
        this.sender = l2;
        this.state = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TypingFromClientThrift)) {
            return false;
        }
        TypingFromClientThrift typingFromClientThrift = (TypingFromClientThrift) obj;
        boolean z = false;
        if (typingFromClientThrift != null) {
            Object obj2;
            Object obj3 = this.recipient != null ? 1 : null;
            if (typingFromClientThrift.recipient != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.recipient.equals(typingFromClientThrift.recipient))) {
                if (this.sender != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (typingFromClientThrift.sender != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.sender.equals(typingFromClientThrift.sender))) {
                    if (this.state != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (typingFromClientThrift.state != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.state.equals(typingFromClientThrift.state))) {
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

    public final void m4017a(TProtocol tProtocol) {
        m4015a();
        tProtocol.a();
        if (this.recipient != null) {
            tProtocol.a(f2993c);
            tProtocol.a(this.recipient.longValue());
        }
        if (!(this.sender == null || this.sender == null)) {
            tProtocol.a(f2994d);
            tProtocol.a(this.sender.longValue());
        }
        if (this.state != null) {
            tProtocol.a(f2995e);
            tProtocol.a(this.state.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4016a(1, f2991a);
    }

    public final String m4016a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("TypingFromClientThrift");
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
        if (this.sender != null) {
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
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("state");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.state == null) {
            stringBuilder.append("null");
        } else {
            str2 = (String) TypingNotifState.f2997b.get(this.state);
            if (str2 != null) {
                stringBuilder.append(str2);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.state);
            if (str2 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m4015a() {
        if (this.state != null && !TypingNotifState.f2996a.contains(this.state)) {
            throw new TProtocolException("The field 'state' has been assigned the invalid value " + this.state);
        }
    }
}
