package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: clearCacheResetFeedLoader */
public class ReceiptPayload implements TBase, Serializable, Cloneable {
    public static boolean f18177a = true;
    private static final TStruct f18178b = new TStruct("ReceiptPayload");
    private static final TField f18179c = new TField("unix_time_micros", (byte) 10, (short) 2);
    public final Long unix_time_micros;

    public ReceiptPayload(Long l) {
        this.unix_time_micros = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ReceiptPayload)) {
            return false;
        }
        ReceiptPayload receiptPayload = (ReceiptPayload) obj;
        boolean z = false;
        if (receiptPayload != null) {
            Object obj2 = this.unix_time_micros != null ? 1 : null;
            Object obj3;
            if (receiptPayload.unix_time_micros != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.unix_time_micros.equals(receiptPayload.unix_time_micros))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18132a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.unix_time_micros != null) {
            tProtocol.a(f18179c);
            tProtocol.a(this.unix_time_micros.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18131a(1, f18177a);
    }

    public final String m18131a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ReceiptPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("unix_time_micros");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.unix_time_micros == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.unix_time_micros, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
