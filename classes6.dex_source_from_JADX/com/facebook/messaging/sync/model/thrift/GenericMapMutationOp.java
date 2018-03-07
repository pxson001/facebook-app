package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.Arrays;

/* compiled from: transcodeStartCount */
public class GenericMapMutationOp extends TUnion {
    public static boolean f2737a = true;
    private static final TStruct f2738b = new TStruct("GenericMapMutationOp");
    private static final TField f2739c = new TField("newValue", (byte) 12, (short) 1);
    private static final TField f2740d = new TField("mutation", (byte) 12, (short) 2);

    public final Object mo155a(TProtocol tProtocol, TField tField) {
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f2739c.b) {
                    return GenericMapValue.m3903b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 2:
                if (tField.b == f2740d.b) {
                    return GenericMapMutation.m3888b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
        }
    }

    private GenericMapValue m3896c() {
        if (this.setField_ == 1) {
            return (GenericMapValue) this.value_;
        }
        throw new RuntimeException("Cannot get field 'newValue' because union is currently set to " + mo154a(this.setField_).a);
    }

    private GenericMapMutation m3897d() {
        if (this.setField_ == 2) {
            return (GenericMapMutation) this.value_;
        }
        throw new RuntimeException("Cannot get field 'mutation' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final boolean m3902a(GenericMapMutationOp genericMapMutationOp) {
        return this.setField_ == genericMapMutationOp.setField_ && ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) genericMapMutationOp.value_) : this.value_.equals(genericMapMutationOp.value_));
    }

    protected final void mo156a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                ((GenericMapValue) this.value_).m3828a(tProtocol);
                return;
            case (short) 2:
                ((GenericMapMutation) this.value_).m3828a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField mo154a(int i) {
        switch (i) {
            case 1:
                return f2739c;
            case 2:
                return f2740d;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericMapMutationOp) {
            return m3902a((GenericMapMutationOp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return m3900a(1, f2737a);
    }

    public final String m3900a(int i, boolean z) {
        Object obj = 1;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GenericMapMutationOp");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("newValue");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3896c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3896c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 2) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("mutation");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3897d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3897d(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
