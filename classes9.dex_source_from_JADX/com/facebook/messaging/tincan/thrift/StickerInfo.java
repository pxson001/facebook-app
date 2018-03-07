package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: chset */
public class StickerInfo implements TBase, Serializable, Cloneable {
    public static boolean f18223a = true;
    private static final TStruct f18224b = new TStruct("StickerInfo");
    private static final TField f18225c = new TField("fbid", (byte) 10, (short) 2);
    public final Long fbid;

    public StickerInfo(Long l) {
        this.fbid = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StickerInfo)) {
            return false;
        }
        StickerInfo stickerInfo = (StickerInfo) obj;
        boolean z = false;
        if (stickerInfo != null) {
            Object obj2 = this.fbid != null ? 1 : null;
            Object obj3;
            if (stickerInfo.fbid != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.fbid.equals(stickerInfo.fbid))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m18175a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.fbid != null) {
            tProtocol.a(f18225c);
            tProtocol.a(this.fbid.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18174a(1, f18223a);
    }

    public final String m18174a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("StickerInfo");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("fbid");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.fbid == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.fbid, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
