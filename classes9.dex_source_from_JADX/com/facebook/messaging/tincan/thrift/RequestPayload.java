package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: city_street_search */
public class RequestPayload implements TBase, Serializable, Cloneable {
    public static boolean f18191a = true;
    private static final TStruct f18192b = new TStruct("RequestPayload");
    private static final TField f18193c = new TField("pre_key_bundle", (byte) 12, (short) 2);
    private static final TField f18194d = new TField("suggested_codename", (byte) 11, (short) 3);
    public final RequestPreKeyBundle pre_key_bundle;
    public final String suggested_codename;

    public RequestPayload(RequestPreKeyBundle requestPreKeyBundle, String str) {
        this.pre_key_bundle = requestPreKeyBundle;
        this.suggested_codename = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RequestPayload)) {
            return false;
        }
        RequestPayload requestPayload = (RequestPayload) obj;
        boolean z = false;
        if (requestPayload != null) {
            Object obj2;
            Object obj3 = this.pre_key_bundle != null ? 1 : null;
            if (requestPayload.pre_key_bundle != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.pre_key_bundle.m18143a(requestPayload.pre_key_bundle))) {
                if (this.suggested_codename != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (requestPayload.suggested_codename != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_codename.equals(requestPayload.suggested_codename))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static RequestPayload m18138b(TProtocol tProtocol) {
        String str = null;
        tProtocol.r();
        RequestPreKeyBundle requestPreKeyBundle = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        byte[] bArr = null;
                        tProtocol.r();
                        byte[] bArr2 = null;
                        byte[] bArr3 = null;
                        byte[] bArr4 = null;
                        while (true) {
                            TField f2 = tProtocol.f();
                            if (f2.b == (byte) 0) {
                                tProtocol.e();
                                requestPreKeyBundle = new RequestPreKeyBundle(bArr4, bArr3, bArr2, bArr);
                                break;
                            }
                            switch (f2.c) {
                                case (short) 2:
                                    if (f2.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    bArr4 = tProtocol.q();
                                    break;
                                case (short) 4:
                                    if (f2.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    bArr3 = tProtocol.q();
                                    break;
                                case (short) 6:
                                    if (f2.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    bArr2 = tProtocol.q();
                                    break;
                                case (short) 7:
                                    if (f2.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    bArr = tProtocol.q();
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f2.b);
                                    break;
                            }
                        }
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new RequestPayload(requestPreKeyBundle, str);
        }
    }

    public final void m18140a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.pre_key_bundle != null) {
            tProtocol.a(f18193c);
            this.pre_key_bundle.m18142a(tProtocol);
        }
        if (this.suggested_codename != null) {
            tProtocol.a(f18194d);
            tProtocol.a(this.suggested_codename);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18139a(1, f18191a);
    }

    public final String m18139a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("RequestPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("pre_key_bundle");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.pre_key_bundle == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.pre_key_bundle, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("suggested_codename");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.suggested_codename == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.suggested_codename, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
