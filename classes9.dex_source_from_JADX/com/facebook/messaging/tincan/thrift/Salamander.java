package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: city_input_controller_fragment_tag */
public class Salamander implements TBase, Serializable, Cloneable {
    public static boolean f18201a = true;
    private static final TStruct f18202b = new TStruct("Salamander");
    private static final TField f18203c = new TField("type", (byte) 8, (short) 2);
    private static final TField f18204d = new TField("body", (byte) 12, (short) 3);
    private static final TField f18205e = new TField("sender_hmac_key", (byte) 11, (short) 4);
    private static final TField f18206f = new TField("ephemeral_lifetime_micros", (byte) 10, (short) 5);
    public final SalamanderBody body;
    public final Long ephemeral_lifetime_micros;
    public final byte[] sender_hmac_key;
    public final Integer type;

    public Salamander(Integer num, SalamanderBody salamanderBody, byte[] bArr, Long l) {
        this.type = num;
        this.body = salamanderBody;
        this.sender_hmac_key = bArr;
        this.ephemeral_lifetime_micros = l;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Salamander)) {
            return false;
        }
        Salamander salamander = (Salamander) obj;
        boolean z = false;
        if (salamander != null) {
            Object obj2;
            Object obj3 = this.type != null ? 1 : null;
            if (salamander.type != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.type.equals(salamander.type))) {
                if (this.body != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (salamander.body != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.body.m18161a(salamander.body))) {
                    if (this.sender_hmac_key != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (salamander.sender_hmac_key != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.sender_hmac_key, salamander.sender_hmac_key))) {
                        if (this.ephemeral_lifetime_micros != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (salamander.ephemeral_lifetime_micros != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.ephemeral_lifetime_micros.equals(salamander.ephemeral_lifetime_micros))) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static Salamander m18145b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        byte[] bArr = null;
        SalamanderBody salamanderBody = null;
        Integer num = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        SalamanderBody salamanderBody2 = new SalamanderBody();
                        SalamanderBody salamanderBody3 = new SalamanderBody();
                        salamanderBody3.setField_ = 0;
                        salamanderBody3.value_ = null;
                        tProtocol.r();
                        TField f2 = tProtocol.f();
                        salamanderBody3.value_ = salamanderBody3.m18158a(tProtocol, f2);
                        if (salamanderBody3.value_ != null) {
                            salamanderBody3.setField_ = f2.c;
                        }
                        tProtocol.f();
                        tProtocol.e();
                        salamanderBody = salamanderBody3;
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            Salamander salamander = new Salamander(num, salamanderBody, bArr, l);
            salamander.m18144a();
            return salamander;
        }
    }

    public final void m18147a(TProtocol tProtocol) {
        m18144a();
        tProtocol.a();
        if (this.type != null) {
            tProtocol.a(f18203c);
            tProtocol.a(this.type.intValue());
        }
        if (this.body != null) {
            tProtocol.a(f18204d);
            this.body.a(tProtocol);
        }
        if (this.sender_hmac_key != null) {
            tProtocol.a(f18205e);
            tProtocol.a(this.sender_hmac_key);
        }
        if (this.ephemeral_lifetime_micros != null) {
            tProtocol.a(f18206f);
            tProtocol.a(this.ephemeral_lifetime_micros.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18146a(1, f18201a);
    }

    public final String m18146a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("Salamander");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("type");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) SalamanderType.f18215b.get(this.type);
            if (str3 != null) {
                stringBuilder.append(str3);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.type);
            if (str3 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("body");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.body == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.body, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("sender_hmac_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sender_hmac_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.sender_hmac_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("ephemeral_lifetime_micros");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.ephemeral_lifetime_micros == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.ephemeral_lifetime_micros, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m18144a() {
        if (this.type != null && !SalamanderType.f18214a.contains(this.type)) {
            throw new TProtocolException("The field 'type' has been assigned the invalid value " + this.type);
        }
    }
}
