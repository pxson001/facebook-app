package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: classify_session_id */
public class RegisterPayload implements TBase, Serializable, Cloneable {
    public static boolean f18180a = true;
    private static final TStruct f18181b = new TStruct("RegisterPayload");
    private static final TField f18182c = new TField("nonce", (byte) 11, (short) 2);
    private static final TField f18183d = new TField("suggested_codename", (byte) 11, (short) 3);
    private static final TField f18184e = new TField("identity_key", (byte) 11, (short) 4);
    private static final TField f18185f = new TField("signed_pre_key_with_id", (byte) 12, (short) 9);
    private static final TField f18186g = new TField("pre_keys", (byte) 15, (short) 10);
    private static final TField f18187h = new TField("last_resort_key", (byte) 12, (short) 11);
    public final byte[] identity_key;
    public final PublicKeyWithID last_resort_key;
    public final byte[] nonce;
    public final List<PublicKeyWithID> pre_keys;
    public final SignedPublicKeyWithID signed_pre_key_with_id;
    public final String suggested_codename;

    private RegisterPayload(byte[] bArr, String str, byte[] bArr2, SignedPublicKeyWithID signedPublicKeyWithID, List<PublicKeyWithID> list, PublicKeyWithID publicKeyWithID) {
        this.nonce = bArr;
        this.suggested_codename = str;
        this.identity_key = bArr2;
        this.signed_pre_key_with_id = signedPublicKeyWithID;
        this.pre_keys = list;
        this.last_resort_key = publicKeyWithID;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegisterPayload)) {
            return false;
        }
        RegisterPayload registerPayload = (RegisterPayload) obj;
        boolean z = false;
        if (registerPayload != null) {
            Object obj2;
            Object obj3 = this.nonce != null ? 1 : null;
            if (registerPayload.nonce != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.nonce, registerPayload.nonce))) {
                if (this.suggested_codename != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (registerPayload.suggested_codename != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_codename.equals(registerPayload.suggested_codename))) {
                    if (this.identity_key != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (registerPayload.identity_key != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.identity_key, registerPayload.identity_key))) {
                        if (this.signed_pre_key_with_id != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (registerPayload.signed_pre_key_with_id != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.signed_pre_key_with_id.m18173a(registerPayload.signed_pre_key_with_id))) {
                            if (this.pre_keys != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (registerPayload.pre_keys != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.pre_keys.equals(registerPayload.pre_keys))) {
                                if (this.last_resort_key != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (registerPayload.last_resort_key != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.last_resort_key.m18130a(registerPayload.last_resort_key))) {
                                    z = true;
                                }
                            }
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

    public static RegisterPayload m18133b(TProtocol tProtocol) {
        PublicKeyWithID publicKeyWithID = null;
        tProtocol.r();
        List list = null;
        SignedPublicKeyWithID signedPublicKeyWithID = null;
        byte[] bArr = null;
        String str = null;
        byte[] bArr2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr2 = tProtocol.q();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    case (short) 9:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        signedPublicKeyWithID = SignedPublicKeyWithID.m18170b(tProtocol);
                        break;
                    case (short) 10:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        TList h = tProtocol.h();
                        list = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b >= 0) {
                                if (i >= h.b) {
                                    break;
                                }
                            } else if (!TProtocol.t()) {
                                break;
                            }
                            list.add(PublicKeyWithID.m18127b(tProtocol));
                            i++;
                        }
                    case (short) 11:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        publicKeyWithID = PublicKeyWithID.m18127b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new RegisterPayload(bArr2, str, bArr, signedPublicKeyWithID, list, publicKeyWithID);
        }
    }

    public final void m18135a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.nonce != null) {
            tProtocol.a(f18182c);
            tProtocol.a(this.nonce);
        }
        if (this.suggested_codename != null) {
            tProtocol.a(f18183d);
            tProtocol.a(this.suggested_codename);
        }
        if (this.identity_key != null) {
            tProtocol.a(f18184e);
            tProtocol.a(this.identity_key);
        }
        if (this.signed_pre_key_with_id != null) {
            tProtocol.a(f18185f);
            this.signed_pre_key_with_id.m18172a(tProtocol);
        }
        if (this.pre_keys != null) {
            tProtocol.a(f18186g);
            tProtocol.a(new TList((byte) 12, this.pre_keys.size()));
            for (PublicKeyWithID a : this.pre_keys) {
                a.m18129a(tProtocol);
            }
        }
        if (this.last_resort_key != null) {
            tProtocol.a(f18187h);
            this.last_resort_key.m18129a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18134a(1, f18180a);
    }

    public final String m18134a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("RegisterPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("nonce");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.nonce == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.nonce, i + 1, z));
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
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("identity_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.identity_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.identity_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("signed_pre_key_with_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.signed_pre_key_with_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.signed_pre_key_with_id, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("pre_keys");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.pre_keys == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.pre_keys, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("last_resort_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.last_resort_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.last_resort_key, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
