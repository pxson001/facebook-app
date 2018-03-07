package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: click_confirm_code_button */
public class LookupResponsePayload implements TBase, Serializable, Cloneable {
    public static boolean f18126a = true;
    private static final TStruct f18127b = new TStruct("LookupResponsePayload");
    private static final TField f18128c = new TField("nonce", (byte) 11, (short) 2);
    private static final TField f18129d = new TField("msg_to", (byte) 12, (short) 3);
    private static final TField f18130e = new TField("suggested_codename", (byte) 11, (short) 4);
    private static final TField f18131f = new TField("identity_key", (byte) 11, (short) 5);
    private static final TField f18132g = new TField("signed_pre_key_with_id", (byte) 12, (short) 9);
    private static final TField f18133h = new TField("pre_key_with_id", (byte) 12, (short) 10);
    public final byte[] identity_key;
    public final MessagingCollectionAddress msg_to;
    public final byte[] nonce;
    public final PublicKeyWithID pre_key_with_id;
    public final SignedPublicKeyWithID signed_pre_key_with_id;
    public final String suggested_codename;

    private LookupResponsePayload(byte[] bArr, MessagingCollectionAddress messagingCollectionAddress, String str, byte[] bArr2, SignedPublicKeyWithID signedPublicKeyWithID, PublicKeyWithID publicKeyWithID) {
        this.nonce = bArr;
        this.msg_to = messagingCollectionAddress;
        this.suggested_codename = str;
        this.identity_key = bArr2;
        this.signed_pre_key_with_id = signedPublicKeyWithID;
        this.pre_key_with_id = publicKeyWithID;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LookupResponsePayload)) {
            return false;
        }
        LookupResponsePayload lookupResponsePayload = (LookupResponsePayload) obj;
        boolean z = false;
        if (lookupResponsePayload != null) {
            Object obj2;
            Object obj3 = this.nonce != null ? 1 : null;
            if (lookupResponsePayload.nonce != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.nonce, lookupResponsePayload.nonce))) {
                if (this.msg_to != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (lookupResponsePayload.msg_to != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.msg_to.m18090a(lookupResponsePayload.msg_to))) {
                    if (this.suggested_codename != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (lookupResponsePayload.suggested_codename != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_codename.equals(lookupResponsePayload.suggested_codename))) {
                        if (this.identity_key != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (lookupResponsePayload.identity_key != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.identity_key, lookupResponsePayload.identity_key))) {
                            if (this.signed_pre_key_with_id != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (lookupResponsePayload.signed_pre_key_with_id != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.signed_pre_key_with_id.m18173a(lookupResponsePayload.signed_pre_key_with_id))) {
                                if (this.pre_key_with_id != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (lookupResponsePayload.pre_key_with_id != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.pre_key_with_id.m18130a(lookupResponsePayload.pre_key_with_id))) {
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

    public static LookupResponsePayload m18084b(TProtocol tProtocol) {
        PublicKeyWithID publicKeyWithID = null;
        tProtocol.r();
        SignedPublicKeyWithID signedPublicKeyWithID = null;
        byte[] bArr = null;
        String str = null;
        MessagingCollectionAddress messagingCollectionAddress = null;
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
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        messagingCollectionAddress = MessagingCollectionAddress.m18087b(tProtocol);
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 5:
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
            return new LookupResponsePayload(bArr2, messagingCollectionAddress, str, bArr, signedPublicKeyWithID, publicKeyWithID);
        }
    }

    public final void m18086a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.nonce != null) {
            tProtocol.a(f18128c);
            tProtocol.a(this.nonce);
        }
        if (this.msg_to != null) {
            tProtocol.a(f18129d);
            this.msg_to.m18089a(tProtocol);
        }
        if (this.suggested_codename != null) {
            tProtocol.a(f18130e);
            tProtocol.a(this.suggested_codename);
        }
        if (this.identity_key != null) {
            tProtocol.a(f18131f);
            tProtocol.a(this.identity_key);
        }
        if (this.signed_pre_key_with_id != null) {
            tProtocol.a(f18132g);
            this.signed_pre_key_with_id.m18172a(tProtocol);
        }
        if (this.pre_key_with_id != null) {
            tProtocol.a(f18133h);
            this.pre_key_with_id.m18129a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18085a(1, f18126a);
    }

    public final String m18085a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("LookupResponsePayload");
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
        stringBuilder.append("msg_to");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.msg_to == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.msg_to, i + 1, z));
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
        stringBuilder.append("pre_key_with_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.pre_key_with_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.pre_key_with_id, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
