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

/* compiled from: click_cancel_in_payment_error_dialog */
public class Packet implements TBase, Serializable, Cloneable {
    public static boolean f18138a = true;
    private static final TStruct f18139b = new TStruct("Packet");
    private static final TField f18140c = new TField("version", (byte) 8, (short) 1);
    private static final TField f18141d = new TField("sig_to", (byte) 12, (short) 2);
    private static final TField f18142e = new TField("msg_to", (byte) 12, (short) 3);
    private static final TField f18143f = new TField("msg_from", (byte) 12, (short) 4);
    private static final TField f18144g = new TField("date_micros", (byte) 10, (short) 5);
    private static final TField f18145h = new TField("type", (byte) 8, (short) 6);
    private static final TField f18146i = new TField("body", (byte) 12, (short) 7);
    private static final TField f18147j = new TField("sender_hmac", (byte) 11, (short) 8);
    private static final TField f18148k = new TField("facebook_hmac", (byte) 11, (short) 9);
    private static final TField f18149l = new TField("sender_packet_id", (byte) 11, (short) 10);
    private static final TField f18150m = new TField("has_prekey_material", (byte) 2, (short) 11);
    public final PacketBody body;
    public final Long date_micros;
    public final byte[] facebook_hmac;
    public final Boolean has_prekey_material;
    public final MessagingCollectionAddress msg_from;
    public final MessagingCollectionAddress msg_to;
    public final byte[] sender_hmac;
    public final byte[] sender_packet_id;
    public final SignalingCollectionAddress sig_to;
    public final Integer type;
    public final Integer version;

    public Packet(Integer num, SignalingCollectionAddress signalingCollectionAddress, MessagingCollectionAddress messagingCollectionAddress, MessagingCollectionAddress messagingCollectionAddress2, Long l, Integer num2, PacketBody packetBody, byte[] bArr, byte[] bArr2, byte[] bArr3, Boolean bool) {
        this.version = num;
        this.sig_to = signalingCollectionAddress;
        this.msg_to = messagingCollectionAddress;
        this.msg_from = messagingCollectionAddress2;
        this.date_micros = l;
        this.type = num2;
        this.body = packetBody;
        this.sender_hmac = bArr;
        this.facebook_hmac = bArr2;
        this.sender_packet_id = bArr3;
        this.has_prekey_material = bool;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Packet)) {
            return false;
        }
        Packet packet = (Packet) obj;
        boolean z = false;
        if (packet != null) {
            Object obj2;
            Object obj3 = this.version != null ? 1 : null;
            if (packet.version != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.version.equals(packet.version))) {
                if (this.sig_to != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (packet.sig_to != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.sig_to.m18169a(packet.sig_to))) {
                    if (this.msg_to != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (packet.msg_to != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.msg_to.m18090a(packet.msg_to))) {
                        if (this.msg_from != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (packet.msg_from != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.msg_from.m18090a(packet.msg_from))) {
                            if (this.date_micros != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (packet.date_micros != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.date_micros.equals(packet.date_micros))) {
                                if (this.type != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (packet.type != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.type.equals(packet.type))) {
                                    if (this.body != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (packet.body != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.body.m18118a(packet.body))) {
                                        if (this.sender_hmac != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (packet.sender_hmac != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.sender_hmac, packet.sender_hmac))) {
                                            if (this.facebook_hmac != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (packet.facebook_hmac != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.facebook_hmac, packet.facebook_hmac))) {
                                                if (this.sender_packet_id != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (packet.sender_packet_id != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.sender_packet_id, packet.sender_packet_id))) {
                                                    if (this.has_prekey_material != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (packet.has_prekey_material != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.has_prekey_material.equals(packet.has_prekey_material))) {
                                                        z = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
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

    public static Packet m18092b(TProtocol tProtocol) {
        Integer num = null;
        SignalingCollectionAddress signalingCollectionAddress = null;
        MessagingCollectionAddress messagingCollectionAddress = null;
        MessagingCollectionAddress messagingCollectionAddress2 = null;
        Long l = null;
        Integer num2 = null;
        PacketBody packetBody = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        Boolean bool = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        signalingCollectionAddress = SignalingCollectionAddress.m18166b(tProtocol);
                        break;
                    case (short) 3:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        messagingCollectionAddress = MessagingCollectionAddress.m18087b(tProtocol);
                        break;
                    case (short) 4:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        messagingCollectionAddress2 = MessagingCollectionAddress.m18087b(tProtocol);
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 7:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        packetBody = PacketBody.m18099b(tProtocol);
                        break;
                    case (short) 8:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    case (short) 9:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr2 = tProtocol.q();
                        break;
                    case (short) 10:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr3 = tProtocol.q();
                        break;
                    case (short) 11:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            Packet packet = new Packet(num, signalingCollectionAddress, messagingCollectionAddress, messagingCollectionAddress2, l, num2, packetBody, bArr, bArr2, bArr3, bool);
            packet.m18091a();
            return packet;
        }
    }

    public final void m18094a(TProtocol tProtocol) {
        m18091a();
        tProtocol.a();
        if (this.version != null) {
            tProtocol.a(f18140c);
            tProtocol.a(this.version.intValue());
        }
        if (this.sig_to != null) {
            tProtocol.a(f18141d);
            this.sig_to.m18168a(tProtocol);
        }
        if (this.msg_to != null) {
            tProtocol.a(f18142e);
            this.msg_to.m18089a(tProtocol);
        }
        if (this.msg_from != null) {
            tProtocol.a(f18143f);
            this.msg_from.m18089a(tProtocol);
        }
        if (this.date_micros != null) {
            tProtocol.a(f18144g);
            tProtocol.a(this.date_micros.longValue());
        }
        if (this.type != null) {
            tProtocol.a(f18145h);
            tProtocol.a(this.type.intValue());
        }
        if (this.body != null) {
            tProtocol.a(f18146i);
            this.body.a(tProtocol);
        }
        if (this.sender_hmac != null) {
            tProtocol.a(f18147j);
            tProtocol.a(this.sender_hmac);
        }
        if (this.facebook_hmac != null) {
            tProtocol.a(f18148k);
            tProtocol.a(this.facebook_hmac);
        }
        if (this.sender_packet_id != null) {
            tProtocol.a(f18149l);
            tProtocol.a(this.sender_packet_id);
        }
        if (this.has_prekey_material != null) {
            tProtocol.a(f18150m);
            tProtocol.a(this.has_prekey_material.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18093a(1, f18138a);
    }

    public final String m18093a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("Packet");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("version");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.version == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.version, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("sig_to");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sig_to == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.sig_to, i + 1, z));
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
        stringBuilder.append("msg_from");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.msg_from == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.msg_from, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("date_micros");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.date_micros == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.date_micros, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("type");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            String str3 = (String) PacketType.f18168b.get(this.type);
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
        stringBuilder.append("sender_hmac");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sender_hmac == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.sender_hmac, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("facebook_hmac");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.facebook_hmac == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.facebook_hmac, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("sender_packet_id");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.sender_packet_id == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.sender_packet_id, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("has_prekey_material");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.has_prekey_material == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.has_prekey_material, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m18091a() {
        if (this.type != null && !PacketType.f18167a.contains(this.type)) {
            throw new TProtocolException("The field 'type' has been assigned the invalid value " + this.type);
        }
    }
}
