package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: uberbar */
public class DeltaBroadcastMessage implements TBase, Serializable, Cloneable {
    public static boolean f2511a = true;
    private static final TStruct f2512b = new TStruct("DeltaBroadcastMessage");
    private static final TField f2513c = new TField("messageMetadatas", (byte) 15, (short) 1);
    private static final TField f2514d = new TField("body", (byte) 11, (short) 2);
    private static final TField f2515e = new TField("stickerId", (byte) 10, (short) 4);
    private static final TField f2516f = new TField("attachments", (byte) 15, (short) 5);
    public final List<Attachment> attachments;
    public final String body;
    public final List<MessageMetadata> messageMetadatas;
    public final Long stickerId;

    private DeltaBroadcastMessage(List<MessageMetadata> list, String str, Long l, List<Attachment> list2) {
        this.messageMetadatas = list;
        this.body = str;
        this.stickerId = l;
        this.attachments = list2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaBroadcastMessage)) {
            return false;
        }
        DeltaBroadcastMessage deltaBroadcastMessage = (DeltaBroadcastMessage) obj;
        boolean z = false;
        if (deltaBroadcastMessage != null) {
            Object obj2;
            Object obj3 = this.messageMetadatas != null ? 1 : null;
            if (deltaBroadcastMessage.messageMetadatas != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadatas.equals(deltaBroadcastMessage.messageMetadatas))) {
                if (this.body != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaBroadcastMessage.body != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.body.equals(deltaBroadcastMessage.body))) {
                    if (this.stickerId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaBroadcastMessage.stickerId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.stickerId.equals(deltaBroadcastMessage.stickerId))) {
                        if (this.attachments != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaBroadcastMessage.attachments != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.attachments.equals(deltaBroadcastMessage.attachments))) {
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

    public static DeltaBroadcastMessage m3704b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        Long l = null;
        String str = null;
        List list2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                TList h;
                List arrayList;
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list2 = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list2 = arrayList;
                            }
                            arrayList.add(MessageMetadata.m3917b(tProtocol));
                            i++;
                        }
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        h = tProtocol.h();
                        arrayList = new ArrayList(Math.max(0, h.b));
                        int i2 = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i2 >= h.b) {
                                list = arrayList;
                            }
                            arrayList.add(Attachment.m3671b(tProtocol));
                            i2++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new DeltaBroadcastMessage(list2, str, l, list);
        }
    }

    public final void m3706a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.messageMetadatas == null || this.messageMetadatas == null)) {
            tProtocol.a(f2513c);
            tProtocol.a(new TList((byte) 12, this.messageMetadatas.size()));
            for (MessageMetadata a : this.messageMetadatas) {
                a.m3919a(tProtocol);
            }
        }
        if (!(this.body == null || this.body == null)) {
            tProtocol.a(f2514d);
            tProtocol.a(this.body);
        }
        if (!(this.stickerId == null || this.stickerId == null)) {
            tProtocol.a(f2515e);
            tProtocol.a(this.stickerId.longValue());
        }
        if (!(this.attachments == null || this.attachments == null)) {
            tProtocol.a(f2516f);
            tProtocol.a(new TList((byte) 12, this.attachments.size()));
            for (Attachment a2 : this.attachments) {
                a2.m3673a(tProtocol);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3705a(1, f2511a);
    }

    public final String m3705a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaBroadcastMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.messageMetadatas != null) {
            stringBuilder.append(a);
            stringBuilder.append("messageMetadatas");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageMetadatas == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.messageMetadatas, i + 1, z));
            }
            obj2 = null;
        }
        if (this.body != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("body");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.body == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.body, i + 1, z));
            }
            obj2 = null;
        }
        if (this.stickerId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("stickerId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.stickerId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.stickerId, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.attachments != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("attachments");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attachments == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attachments, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
