package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: transitionTypes */
public class DeltaThreadName implements TBase, Serializable, Cloneable {
    public static boolean f2665a = true;
    private static final TStruct f2666b = new TStruct("DeltaThreadName");
    private static final TField f2667c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2668d = new TField("name", (byte) 11, (short) 2);
    public final MessageMetadata messageMetadata;
    public final String name;

    private DeltaThreadName(MessageMetadata messageMetadata, String str) {
        this.messageMetadata = messageMetadata;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadName)) {
            return false;
        }
        DeltaThreadName deltaThreadName = (DeltaThreadName) obj;
        boolean z = false;
        if (deltaThreadName != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaThreadName.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaThreadName.messageMetadata))) {
                if (this.name != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaThreadName.name != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.name.equals(deltaThreadName.name))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadName m3818b(TProtocol tProtocol) {
        String str = null;
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
            DeltaThreadName deltaThreadName = new DeltaThreadName(messageMetadata, str);
            deltaThreadName.m3817a();
            return deltaThreadName;
        }
    }

    public final void m3820a(TProtocol tProtocol) {
        m3817a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2667c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.name == null || this.name == null)) {
            tProtocol.a(f2668d);
            tProtocol.a(this.name);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3819a(1, f2665a);
    }

    public final String m3819a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadName");
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
        if (this.name != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("name");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.name == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.name, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3817a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        }
    }
}
