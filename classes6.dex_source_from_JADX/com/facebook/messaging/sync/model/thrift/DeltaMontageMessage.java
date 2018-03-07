package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_title_bar_text */
public class DeltaMontageMessage implements TBase, Serializable, Cloneable {
    public static boolean f2568a = true;
    private static final TStruct f2569b = new TStruct("DeltaMontageMessage");
    private static final TField f2570c = new TField("newMessage", (byte) 12, (short) 1);
    public final DeltaNewMessage newMessage;

    private DeltaMontageMessage(DeltaNewMessage deltaNewMessage) {
        this.newMessage = deltaNewMessage;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaMontageMessage)) {
            return false;
        }
        DeltaMontageMessage deltaMontageMessage = (DeltaMontageMessage) obj;
        boolean z = false;
        if (deltaMontageMessage != null) {
            Object obj2 = this.newMessage != null ? 1 : null;
            Object obj3;
            if (deltaMontageMessage.newMessage != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.newMessage.m3751a(deltaMontageMessage.newMessage))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaMontageMessage m3742b(TProtocol tProtocol) {
        DeltaNewMessage deltaNewMessage = null;
        tProtocol.r();
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
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaMontageMessage deltaMontageMessage = new DeltaMontageMessage(deltaNewMessage);
            deltaMontageMessage.m3741a();
            return deltaMontageMessage;
        }
    }

    public final void m3744a(TProtocol tProtocol) {
        m3741a();
        tProtocol.a();
        if (this.newMessage != null) {
            tProtocol.a(f2570c);
            this.newMessage.m3750a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3743a(1, f2568a);
    }

    public final String m3743a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaMontageMessage");
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
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3741a() {
        if (this.newMessage == null) {
            throw new TProtocolException(6, "Required field 'newMessage' was not present! Struct: " + toString());
        }
    }
}
