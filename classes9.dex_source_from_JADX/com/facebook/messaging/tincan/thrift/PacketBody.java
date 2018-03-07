package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.Arrays;

/* compiled from: clear_theme */
public class PacketBody extends TUnion {
    public static boolean f18151a = true;
    private static final TStruct f18152b = new TStruct("PacketBody");
    private static final TField f18153c = new TField("salamander_payload", (byte) 11, (short) 1);
    private static final TField f18154d = new TField("request_payload", (byte) 12, (short) 2);
    private static final TField f18155e = new TField("accept_payload", (byte) 12, (short) 3);
    private static final TField f18156f = new TField("caller_id_payload", (byte) 12, (short) 6);
    private static final TField f18157g = new TField("status_sender_packet_id", (byte) 11, (short) 8);
    private static final TField f18158h = new TField("status_payload", (byte) 11, (short) 9);
    private static final TField f18159i = new TField("receipt_payload", (byte) 12, (short) 10);
    private static final TField f18160j = new TField("ping_payload", (byte) 11, (short) 11);
    private static final TField f18161k = new TField("register_payload", (byte) 12, (short) 12);
    private static final TField f18162l = new TField("register_response_payload", (byte) 12, (short) 13);
    private static final TField f18163m = new TField("lookup_payload", (byte) 12, (short) 14);
    private static final TField f18164n = new TField("lookup_response_payload", (byte) 12, (short) 15);
    private static final TField f18165o = new TField("primary_device_change_payload", (byte) 12, (short) 16);
    private static final TField f18166p = new TField("action_result_payload", (byte) 12, (short) 17);

    public static PacketBody m18098a(byte[] bArr) {
        PacketBody packetBody = new PacketBody();
        packetBody.m18104c(bArr);
        return packetBody;
    }

    public static PacketBody m18097a(RequestPayload requestPayload) {
        PacketBody packetBody = new PacketBody();
        packetBody.m18103b(requestPayload);
        return packetBody;
    }

    private String m18106i() {
        if (this.setField_ == 9) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'status_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private String m18107j() {
        if (this.setField_ == 11) {
            return (String) this.value_;
        }
        throw new RuntimeException("Cannot get field 'ping_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private RegisterPayload m18108k() {
        if (this.setField_ == 12) {
            return (RegisterPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'register_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private RegisterResponsePayload m18109l() {
        if (this.setField_ == 13) {
            return (RegisterResponsePayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'register_response_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private LookupPayload m18110m() {
        if (this.setField_ == 14) {
            return (LookupPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'lookup_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private LookupResponsePayload m18111n() {
        if (this.setField_ == 15) {
            return (LookupResponsePayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'lookup_response_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private PrimaryDeviceChangePayload m18112o() {
        if (this.setField_ == 16) {
            return (PrimaryDeviceChangePayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'primary_device_change_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    private ActionResultPayload m18113p() {
        if (this.setField_ == 17) {
            return (ActionResultPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'action_result_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final boolean m18118a(PacketBody packetBody) {
        return this.setField_ == packetBody.setField_ && ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) packetBody.value_) : this.value_.equals(packetBody.value_));
    }

    public final byte[] m18119c() {
        if (this.setField_ == 1) {
            return (byte[]) this.value_;
        }
        throw new RuntimeException("Cannot get field 'salamander_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final RequestPayload m18120d() {
        if (this.setField_ == 2) {
            return (RequestPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'request_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final AcceptPayload m18121e() {
        if (this.setField_ == 3) {
            return (AcceptPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'accept_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final CallerIDPayload m18122f() {
        if (this.setField_ == 6) {
            return (CallerIDPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'caller_id_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final byte[] m18123g() {
        if (this.setField_ == 8) {
            return (byte[]) this.value_;
        }
        throw new RuntimeException("Cannot get field 'status_sender_packet_id' because union is currently set to " + m18114a(this.setField_).a);
    }

    public final ReceiptPayload m18124h() {
        if (this.setField_ == 10) {
            return (ReceiptPayload) this.value_;
        }
        throw new RuntimeException("Cannot get field 'receipt_payload' because union is currently set to " + m18114a(this.setField_).a);
    }

    public static PacketBody m18095a(AcceptPayload acceptPayload) {
        PacketBody packetBody = new PacketBody();
        packetBody.m18101b(acceptPayload);
        return packetBody;
    }

    public static PacketBody m18100b(byte[] bArr) {
        PacketBody packetBody = new PacketBody();
        packetBody.m18105d(bArr);
        return packetBody;
    }

    public static PacketBody m18096a(ReceiptPayload receiptPayload) {
        PacketBody packetBody = new PacketBody();
        packetBody.m18102b(receiptPayload);
        return packetBody;
    }

    public final Object m18115a(TProtocol tProtocol, TField tField) {
        String str;
        byte[] bArr;
        TField f;
        Long l;
        TField f2;
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f18153c.b) {
                    return tProtocol.q();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 2:
                if (tField.b == f18154d.b) {
                    return RequestPayload.m18138b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 3:
                if (tField.b == f18155e.b) {
                    str = null;
                    tProtocol.r();
                    bArr = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 2:
                                    if (f.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    bArr = tProtocol.q();
                                    break;
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
                        return new AcceptPayload(bArr, str);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 6:
                if (tField.b == f18156f.b) {
                    return CallerIDPayload.m18075b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 8:
                if (tField.b == f18157g.b) {
                    return tProtocol.q();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 9:
                if (tField.b == f18158h.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 10:
                if (tField.b == f18159i.b) {
                    l = null;
                    tProtocol.r();
                    while (true) {
                        f2 = tProtocol.f();
                        if (f2.b != (byte) 0) {
                            switch (f2.c) {
                                case (short) 2:
                                    if (f2.b != (byte) 10) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    l = Long.valueOf(tProtocol.n());
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f2.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new ReceiptPayload(l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 11:
                if (tField.b == f18160j.b) {
                    return tProtocol.p();
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 12:
                if (tField.b == f18161k.b) {
                    return RegisterPayload.m18133b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 13:
                if (tField.b == f18162l.b) {
                    byte[] bArr2 = null;
                    tProtocol.r();
                    while (true) {
                        f2 = tProtocol.f();
                        if (f2.b != (byte) 0) {
                            switch (f2.c) {
                                case (short) 2:
                                    if (f2.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f2.b);
                                        break;
                                    }
                                    bArr2 = tProtocol.q();
                                    break;
                                default:
                                    TProtocolUtil.a(tProtocol, f2.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new RegisterResponsePayload(bArr2);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 14:
                if (tField.b == f18163m.b) {
                    l = null;
                    tProtocol.r();
                    bArr = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 2:
                                    if (f.b != (byte) 11) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    bArr = tProtocol.q();
                                    break;
                                case (short) 3:
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
                        return new LookupPayload(bArr, l);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 15:
                if (tField.b == f18164n.b) {
                    return LookupResponsePayload.m18084b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 16:
                if (tField.b == f18165o.b) {
                    str = null;
                    tProtocol.r();
                    MessagingCollectionAddress messagingCollectionAddress = null;
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 2:
                                    if (f.b != (byte) 12) {
                                        TProtocolUtil.a(tProtocol, f.b);
                                        break;
                                    }
                                    messagingCollectionAddress = MessagingCollectionAddress.m18087b(tProtocol);
                                    break;
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
                        return new PrimaryDeviceChangePayload(messagingCollectionAddress, str);
                    }
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            case (short) 17:
                if (tField.b == f18166p.b) {
                    return ActionResultPayload.m18069b(tProtocol);
                }
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.a(tProtocol, tField.b);
                return null;
        }
    }

    protected final void m18117a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                tProtocol.a((byte[]) this.value_);
                return;
            case (short) 2:
                ((RequestPayload) this.value_).m18140a(tProtocol);
                return;
            case (short) 3:
                ((AcceptPayload) this.value_).m18067a(tProtocol);
                return;
            case (short) 6:
                ((CallerIDPayload) this.value_).m18077a(tProtocol);
                return;
            case (short) 8:
                tProtocol.a((byte[]) this.value_);
                return;
            case (short) 9:
                tProtocol.a((String) this.value_);
                return;
            case (short) 10:
                ((ReceiptPayload) this.value_).m18132a(tProtocol);
                return;
            case (short) 11:
                tProtocol.a((String) this.value_);
                return;
            case (short) 12:
                ((RegisterPayload) this.value_).m18135a(tProtocol);
                return;
            case (short) 13:
                ((RegisterResponsePayload) this.value_).m18137a(tProtocol);
                return;
            case (short) 14:
                ((LookupPayload) this.value_).m18083a(tProtocol);
                return;
            case (short) 15:
                ((LookupResponsePayload) this.value_).m18086a(tProtocol);
                return;
            case (short) 16:
                ((PrimaryDeviceChangePayload) this.value_).m18126a(tProtocol);
                return;
            case (short) 17:
                ((ActionResultPayload) this.value_).m18071a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField m18114a(int i) {
        switch (i) {
            case 1:
                return f18153c;
            case 2:
                return f18154d;
            case 3:
                return f18155e;
            case 6:
                return f18156f;
            case 8:
                return f18157g;
            case 9:
                return f18158h;
            case 10:
                return f18159i;
            case 11:
                return f18160j;
            case 12:
                return f18161k;
            case 13:
                return f18162l;
            case 14:
                return f18163m;
            case 15:
                return f18164n;
            case 16:
                return f18165o;
            case 17:
                return f18166p;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    private void m18104c(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.setField_ = 1;
        this.value_ = bArr;
    }

    private void m18103b(RequestPayload requestPayload) {
        if (requestPayload == null) {
            throw new NullPointerException();
        }
        this.setField_ = 2;
        this.value_ = requestPayload;
    }

    private void m18101b(AcceptPayload acceptPayload) {
        if (acceptPayload == null) {
            throw new NullPointerException();
        }
        this.setField_ = 3;
        this.value_ = acceptPayload;
    }

    private void m18105d(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.setField_ = 8;
        this.value_ = bArr;
    }

    private void m18102b(ReceiptPayload receiptPayload) {
        if (receiptPayload == null) {
            throw new NullPointerException();
        }
        this.setField_ = 10;
        this.value_ = receiptPayload;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PacketBody) {
            return m18118a((PacketBody) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public static PacketBody m18099b(TProtocol tProtocol) {
        PacketBody packetBody = new PacketBody();
        PacketBody packetBody2 = new PacketBody();
        packetBody2.setField_ = 0;
        packetBody2.value_ = null;
        tProtocol.r();
        TField f = tProtocol.f();
        packetBody2.value_ = packetBody2.m18115a(tProtocol, f);
        if (packetBody2.value_ != null) {
            packetBody2.setField_ = f.c;
        }
        tProtocol.f();
        tProtocol.e();
        return packetBody2;
    }

    public String toString() {
        return m18116a(1, f18151a);
    }

    public final String m18116a(int i, boolean z) {
        Object obj = 1;
        Object obj2 = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("PacketBody");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("salamander_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18119c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18119c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 2) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("request_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18120d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18120d(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 3) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("accept_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18121e() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18121e(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 6) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("caller_id_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18122f() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18122f(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 8) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("status_sender_packet_id");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18123g() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18123g(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 9) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("status_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18106i() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18106i(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 10) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("receipt_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18124h() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18124h(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 11) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("ping_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18107j() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18107j(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 12) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("register_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18108k() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18108k(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 13) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("register_response_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18109l() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18109l(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 14) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("lookup_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18110m() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18110m(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 15) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("lookup_response_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18111n() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18111n(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 16) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("primary_device_change_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18112o() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18112o(), i + 1, z));
            }
        } else {
            obj2 = obj;
        }
        if (this.setField_ == 17) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("action_result_payload");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m18113p() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(m18113p(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
