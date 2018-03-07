package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.Arrays;

/* compiled from: transcodeInfo */
public class GenericMapValue extends TUnion {
    public static boolean f2741a = true;
    private static final TStruct f2742b = new TStruct("GenericMapValue");
    private static final TField f2743c = new TField("asMap", (byte) 12, (short) 1);
    private static final TField f2744d = new TField("asString", (byte) 11, (short) 2);
    private static final TField f2745e = new TField("asLong", (byte) 10, (short) 3);
    private static final TField f2746f = new TField("asBinary", (byte) 11, (short) 4);

    private GenericMap m3904c() {
        if (this.setField_ == 1) {
            return (GenericMap) this.value_;
        }
        throw new RuntimeException("Cannot get field 'asMap' because union is currently set to " + mo154a(this.setField_).a);
    }

    private String m3905d() {
        if (this.setField_ == 2) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'asString' because union is currently set to " + mo154a(this.setField_).a);
    }

    private Long m3906e() {
        if (this.setField_ == 3) {
            return (Long) this.value_;
        }
        throw new RuntimeException("Cannot get field 'asLong' because union is currently set to " + mo154a(this.setField_).a);
    }

    private byte[] m3907f() {
        if (this.setField_ == 4) {
            return (byte[]) this.value_;
        }
        throw new RuntimeException("Cannot get field 'asBinary' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final Object mo155a(TProtocol tProtocol, TField tField) {
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f2743c.b) {
                    return GenericMap.m3881b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 2:
                if (tField.b == f2744d.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 3:
                if (tField.b == f2745e.b) {
                    return Long.valueOf(tProtocol.n());
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 4:
                if (tField.b == f2746f.b) {
                    return tProtocol.q();
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
        }
    }

    protected final void mo156a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                ((GenericMap) this.value_).m3883a(tProtocol);
                return;
            case (short) 2:
                tProtocol.a((String) this.value_);
                return;
            case (short) 3:
                tProtocol.a(((Long) this.value_).longValue());
                return;
            case (short) 4:
                tProtocol.a((byte[]) this.value_);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField mo154a(int i) {
        switch (i) {
            case 1:
                return f2743c;
            case 2:
                return f2744d;
            case 3:
                return f2745e;
            case 4:
                return f2746f;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GenericMapValue)) {
            return false;
        }
        boolean z;
        GenericMapValue genericMapValue = (GenericMapValue) obj;
        if (this.setField_ != genericMapValue.setField_ || ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) genericMapValue.value_) : this.value_.equals(genericMapValue.value_))) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static GenericMapValue m3903b(TProtocol tProtocol) {
        GenericMapValue genericMapValue = new GenericMapValue();
        TUnion genericMapValue2 = new GenericMapValue();
        genericMapValue2.setField_ = 0;
        genericMapValue2.value_ = null;
        tProtocol.r();
        TField f = tProtocol.f();
        genericMapValue2.value_ = genericMapValue2.mo155a(tProtocol, f);
        if (genericMapValue2.value_ != null) {
            genericMapValue2.setField_ = f.c;
        }
        tProtocol.f();
        tProtocol.e();
        return genericMapValue2;
    }

    public String toString() {
        return m3910a(1, f2741a);
    }

    public final String m3910a(int i, boolean z) {
        int i2;
        int i3 = 0;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GenericMapValue");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("asMap");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3904c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3904c(), i + 1, z));
            }
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.setField_ == 2) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("asString");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3905d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3905d(), i + 1, z));
            }
            i2 = 0;
        }
        if (this.setField_ == 3) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("asLong");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3906e() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3906e(), i + 1, z));
            }
            i2 = 0;
        }
        if (this.setField_ == 4) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("asBinary");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3907f() == null) {
                stringBuilder.append("null");
            } else {
                i2 = Math.min(m3907f().length, 128);
                while (i3 < i2) {
                    if (i3 != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(Integer.toHexString(m3907f()[i3]).length() > 1 ? Integer.toHexString(m3907f()[i3]).substring(Integer.toHexString(m3907f()[i3]).length() - 2).toUpperCase() : "0" + Integer.toHexString(m3907f()[i3]).toUpperCase());
                    i3++;
                }
                if (m3907f().length > 128) {
                    stringBuilder.append(" ...");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
