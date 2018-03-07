package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transcode_bit_rate_bps */
public class GenericMapKeyMutation implements TBase, Serializable, Cloneable {
    public static boolean f2729a = true;
    private static final TStruct f2730b = new TStruct("GenericMapKeyMutation");
    private static final TField f2731c = new TField("key", (byte) 11, (short) 1);
    private static final TField f2732d = new TField("op", (byte) 12, (short) 2);
    public final String key;
    public final GenericMapMutationOp op;

    private GenericMapKeyMutation(String str, GenericMapMutationOp genericMapMutationOp) {
        this.key = str;
        this.op = genericMapMutationOp;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GenericMapKeyMutation)) {
            return false;
        }
        GenericMapKeyMutation genericMapKeyMutation = (GenericMapKeyMutation) obj;
        boolean z = false;
        if (genericMapKeyMutation != null) {
            Object obj2;
            Object obj3 = this.key != null ? 1 : null;
            if (genericMapKeyMutation.key != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.key.equals(genericMapKeyMutation.key))) {
                if (this.op != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (genericMapKeyMutation.op != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.op.m3902a(genericMapKeyMutation.op))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static GenericMapKeyMutation m3885b(TProtocol tProtocol) {
        GenericMapMutationOp genericMapMutationOp = null;
        tProtocol.r();
        String str = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 2:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        GenericMapMutationOp genericMapMutationOp2 = new GenericMapMutationOp();
                        TUnion genericMapMutationOp3 = new GenericMapMutationOp();
                        genericMapMutationOp3.setField_ = 0;
                        genericMapMutationOp3.value_ = null;
                        tProtocol.r();
                        TField f2 = tProtocol.f();
                        genericMapMutationOp3.value_ = genericMapMutationOp3.mo155a(tProtocol, f2);
                        if (genericMapMutationOp3.value_ != null) {
                            genericMapMutationOp3.setField_ = f2.c;
                        }
                        tProtocol.f();
                        tProtocol.e();
                        genericMapMutationOp = genericMapMutationOp3;
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            GenericMapKeyMutation genericMapKeyMutation = new GenericMapKeyMutation(str, genericMapMutationOp);
            genericMapKeyMutation.m3884a();
            return genericMapKeyMutation;
        }
    }

    public final void m3887a(TProtocol tProtocol) {
        m3884a();
        tProtocol.a();
        if (this.key != null) {
            tProtocol.a(f2731c);
            tProtocol.a(this.key);
        }
        if (!(this.op == null || this.op == null)) {
            tProtocol.a(f2732d);
            this.op.m3828a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3886a(1, f2729a);
    }

    public final String m3886a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GenericMapKeyMutation");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.key, i + 1, z));
        }
        if (this.op != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("op");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.op == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.op, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3884a() {
        if (this.key == null) {
            throw new TProtocolException(6, "Required field 'key' was not present! Struct: " + toString());
        }
    }
}
