package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: uSTMatrix */
public class DeltaGenericMapMutation implements TBase, Serializable, Cloneable {
    public static boolean f2537a = true;
    private static final TStruct f2538b = new TStruct("DeltaGenericMapMutation");
    private static final TField f2539c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2540d = new TField("mutation", (byte) 12, (short) 2);
    public final MessageMetadata messageMetadata;
    public final GenericMapMutation mutation;

    private DeltaGenericMapMutation(MessageMetadata messageMetadata, GenericMapMutation genericMapMutation) {
        this.messageMetadata = messageMetadata;
        this.mutation = genericMapMutation;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaGenericMapMutation)) {
            return false;
        }
        DeltaGenericMapMutation deltaGenericMapMutation = (DeltaGenericMapMutation) obj;
        boolean z = false;
        if (deltaGenericMapMutation != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaGenericMapMutation.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaGenericMapMutation.messageMetadata))) {
                if (this.mutation != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaGenericMapMutation.mutation != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.mutation.m3895a(deltaGenericMapMutation.mutation))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaGenericMapMutation m3718b(TProtocol tProtocol) {
        GenericMapMutation genericMapMutation = null;
        tProtocol.r();
        MessageMetadata messageMetadata = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        messageMetadata = MessageMetadata.m3917b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        genericMapMutation = GenericMapMutation.m3888b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaGenericMapMutation deltaGenericMapMutation = new DeltaGenericMapMutation(messageMetadata, genericMapMutation);
            deltaGenericMapMutation.m3717a();
            return deltaGenericMapMutation;
        }
    }

    public final void m3720a(TProtocol tProtocol) {
        m3717a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2539c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.mutation != null) {
            tProtocol.a(f2540d);
            this.mutation.m3828a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3719a(1, f2537a);
    }

    public final String m3719a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaGenericMapMutation");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("messageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.messageMetadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.messageMetadata, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("mutation");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.mutation == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.mutation, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3717a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.mutation == null) {
            throw new TProtocolException(6, "Required field 'mutation' was not present! Struct: " + toString());
        }
    }
}
