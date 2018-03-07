package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: typeahead_selected_page_name */
public class DeltaNewMessage implements TBase, Serializable, Cloneable {
    public static boolean f2575a = true;
    private static final TStruct f2576b = new TStruct("DeltaNewMessage");
    private static final TField f2577c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2578d = new TField("body", (byte) 11, (short) 2);
    private static final TField f2579e = new TField("stickerId", (byte) 10, (short) 4);
    private static final TField f2580f = new TField("attachments", (byte) 15, (short) 5);
    private static final TField f2581g = new TField("ttl", (byte) 8, (short) 6);
    private static final TField f2582h = new TField("data", (byte) 13, (short) 7);
    public final List<Attachment> attachments;
    public final String body;
    public final Map<String, String> data;
    public final MessageMetadata messageMetadata;
    public final Long stickerId;
    public final Integer ttl;

    private DeltaNewMessage(MessageMetadata messageMetadata, String str, Long l, List<Attachment> list, Integer num, Map<String, String> map) {
        this.messageMetadata = messageMetadata;
        this.body = str;
        this.stickerId = l;
        this.attachments = list;
        this.ttl = num;
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof DeltaNewMessage)) {
            return m3751a((DeltaNewMessage) obj);
        }
        return false;
    }

    public final boolean m3751a(DeltaNewMessage deltaNewMessage) {
        if (deltaNewMessage == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.messageMetadata != null;
        if (deltaNewMessage.messageMetadata != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.messageMetadata.m3920a(deltaNewMessage.messageMetadata))) {
            return false;
        }
        if (this.body != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (deltaNewMessage.body != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.body.equals(deltaNewMessage.body))) {
            return false;
        }
        if (this.stickerId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (deltaNewMessage.stickerId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.stickerId.equals(deltaNewMessage.stickerId))) {
            return false;
        }
        if (this.attachments != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (deltaNewMessage.attachments != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attachments.equals(deltaNewMessage.attachments))) {
            return false;
        }
        if (this.ttl != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (deltaNewMessage.ttl != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.ttl.equals(deltaNewMessage.ttl))) {
            return false;
        }
        if (this.data != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (deltaNewMessage.data != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.data.equals(deltaNewMessage.data))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaNewMessage m3748b(TProtocol tProtocol) {
        Map map = null;
        tProtocol.r();
        Integer num = null;
        List list = null;
        Long l = null;
        String str = null;
        MessageMetadata messageMetadata = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                int i;
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
                        TList h = tProtocol.h();
                        list = new ArrayList(Math.max(0, h.b));
                        i = 0;
                        while (true) {
                            if (h.b >= 0) {
                                if (i >= h.b) {
                                    break;
                                }
                            } else if (!TProtocol.t()) {
                                break;
                            }
                            list.add(Attachment.m3671b(tProtocol));
                            i++;
                        }
                    case (short) 6:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 7:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        map = new HashMap(Math.max(0, g.f5052c * 2));
                        i = 0;
                        while (true) {
                            if (g.f5052c >= 0) {
                                if (i >= g.f5052c) {
                                    break;
                                }
                            } else if (!TProtocol.s()) {
                                break;
                            }
                            map.put(tProtocol.p(), tProtocol.p());
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaNewMessage deltaNewMessage = new DeltaNewMessage(messageMetadata, str, l, list, num, map);
            deltaNewMessage.m3747a();
            return deltaNewMessage;
        }
    }

    public final void m3750a(TProtocol tProtocol) {
        m3747a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2577c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.body == null || this.body == null)) {
            tProtocol.a(f2578d);
            tProtocol.a(this.body);
        }
        if (!(this.stickerId == null || this.stickerId == null)) {
            tProtocol.a(f2579e);
            tProtocol.a(this.stickerId.longValue());
        }
        if (!(this.attachments == null || this.attachments == null)) {
            tProtocol.a(f2580f);
            tProtocol.a(new TList((byte) 12, this.attachments.size()));
            for (Attachment a : this.attachments) {
                a.m3673a(tProtocol);
            }
        }
        if (!(this.ttl == null || this.ttl == null)) {
            tProtocol.a(f2581g);
            tProtocol.a(this.ttl.intValue());
        }
        if (!(this.data == null || this.data == null)) {
            tProtocol.a(f2582h);
            tProtocol.a(new TMap((byte) 11, (byte) 11, this.data.size()));
            for (Entry entry : this.data.entrySet()) {
                tProtocol.a((String) entry.getKey());
                tProtocol.a((String) entry.getValue());
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3749a(1, f2575a);
    }

    public final String m3749a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaNewMessage");
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
        if (this.body != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("body");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.body == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.body, i + 1, z));
            }
        }
        if (this.stickerId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("stickerId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.stickerId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.stickerId, i + 1, z));
            }
        }
        if (this.attachments != null) {
            stringBuilder.append("," + str);
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
        if (this.ttl != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("ttl");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.ttl == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) MessageLifetime.f2765b.get(this.ttl);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.ttl);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.data != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("data");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.data == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.data, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3747a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.ttl != null && !MessageLifetime.f2764a.contains(this.ttl)) {
            throw new TProtocolException("The field 'ttl' has been assigned the invalid value " + this.ttl);
        }
    }
}
