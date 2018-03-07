package com.facebook.rtc.models.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: application/vnd.wap.hashed-certificate */
public class WebrtcMessageServerExtension implements TBase, Serializable, Cloneable {
    public static boolean f19845a = true;
    private static final TStruct f19846b = new TStruct("WebrtcMessageServerExtension");
    private static final TField f19847c = new TField("phoneAppPayload", (byte) 12, (short) 1);
    public final PhoneAppPayload phoneAppPayload;

    public WebrtcMessageServerExtension(PhoneAppPayload phoneAppPayload) {
        this.phoneAppPayload = phoneAppPayload;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WebrtcMessageServerExtension)) {
            return false;
        }
        WebrtcMessageServerExtension webrtcMessageServerExtension = (WebrtcMessageServerExtension) obj;
        boolean z = false;
        if (webrtcMessageServerExtension != null) {
            Object obj2 = this.phoneAppPayload != null ? 1 : null;
            Object obj3;
            if (webrtcMessageServerExtension.phoneAppPayload != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.phoneAppPayload.m19569a(webrtcMessageServerExtension.phoneAppPayload))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m19571a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.phoneAppPayload == null || this.phoneAppPayload == null)) {
            tProtocol.a(f19847c);
            this.phoneAppPayload.m19568a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m19570a(1, f19845a);
    }

    public final String m19570a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("WebrtcMessageServerExtension");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.phoneAppPayload != null) {
            stringBuilder.append(a);
            stringBuilder.append("phoneAppPayload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.phoneAppPayload == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.phoneAppPayload, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
