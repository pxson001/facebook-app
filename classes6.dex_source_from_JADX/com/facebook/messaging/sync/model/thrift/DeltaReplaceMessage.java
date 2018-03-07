package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: turn_off_on_last_owner_unsubscribed */
public class DeltaReplaceMessage implements TBase, Serializable, Cloneable {
    public static boolean f2630a = true;
    private static final TStruct f2631b = new TStruct("DeltaReplaceMessage");
    private static final TField f2632c = new TField("newMessage", (byte) 12, (short) 1);
    private static final TField f2633d = new TField("replacedMessageId", (byte) 11, (short) 2);
    public final DeltaNewMessage newMessage;
    public final String replacedMessageId;

    private DeltaReplaceMessage(DeltaNewMessage deltaNewMessage, String str) {
        this.newMessage = deltaNewMessage;
        this.replacedMessageId = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaReplaceMessage)) {
            return false;
        }
        DeltaReplaceMessage deltaReplaceMessage = (DeltaReplaceMessage) obj;
        boolean z = false;
        if (deltaReplaceMessage != null) {
            Object obj2;
            Object obj3 = this.newMessage != null ? 1 : null;
            if (deltaReplaceMessage.newMessage != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.newMessage.m3751a(deltaReplaceMessage.newMessage))) {
                if (this.replacedMessageId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaReplaceMessage.replacedMessageId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.replacedMessageId.equals(deltaReplaceMessage.replacedMessageId))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaReplaceMessage m3788b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        DeltaNewMessage deltaNewMessage = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        deltaNewMessage = DeltaNewMessage.m3748b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaReplaceMessage deltaReplaceMessage = new DeltaReplaceMessage(deltaNewMessage, str);
            deltaReplaceMessage.m3787a();
            return deltaReplaceMessage;
        }
    }

    public final void m3790a(TProtocol tProtocol) {
        m3787a();
        tProtocol.a();
        if (this.newMessage != null) {
            tProtocol.a(f2632c);
            this.newMessage.m3750a(tProtocol);
        }
        if (this.replacedMessageId != null) {
            tProtocol.a(f2633d);
            tProtocol.a(this.replacedMessageId);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3789a(1, f2630a);
    }

    public final String m3789a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaReplaceMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("newMessage");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.newMessage == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.newMessage, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("replacedMessageId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.replacedMessageId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.replacedMessageId, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3787a() {
        if (this.newMessage == null) {
            throw new TProtocolException(6, "Required field 'newMessage' was not present! Struct: " + toString());
        } else if (this.replacedMessageId == null) {
            throw new TProtocolException(6, "Required field 'replacedMessageId' was not present! Struct: " + toString());
        }
    }
}
