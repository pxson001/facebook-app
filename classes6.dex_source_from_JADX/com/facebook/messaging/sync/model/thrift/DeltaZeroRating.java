package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transfer */
public class DeltaZeroRating implements TBase, Serializable, Cloneable {
    public static boolean f2717a = true;
    private static final TStruct f2718b = new TStruct("DeltaZeroRating");
    private static final TField f2719c = new TField("numFreeMessagesRemaining", (byte) 8, (short) 1);
    public final Integer numFreeMessagesRemaining;

    public DeltaZeroRating(Integer num) {
        this.numFreeMessagesRemaining = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaZeroRating)) {
            return false;
        }
        DeltaZeroRating deltaZeroRating = (DeltaZeroRating) obj;
        boolean z = false;
        if (deltaZeroRating != null) {
            Object obj2 = this.numFreeMessagesRemaining != null ? 1 : null;
            Object obj3;
            if (deltaZeroRating.numFreeMessagesRemaining != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.numFreeMessagesRemaining.equals(deltaZeroRating.numFreeMessagesRemaining))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3876a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.numFreeMessagesRemaining == null || this.numFreeMessagesRemaining == null)) {
            tProtocol.a(f2719c);
            tProtocol.a(this.numFreeMessagesRemaining.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3875a(1, f2717a);
    }

    public final String m3875a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaZeroRating");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.numFreeMessagesRemaining != null) {
            stringBuilder.append(a);
            stringBuilder.append("numFreeMessagesRemaining");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.numFreeMessagesRemaining == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.numFreeMessagesRemaining, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
