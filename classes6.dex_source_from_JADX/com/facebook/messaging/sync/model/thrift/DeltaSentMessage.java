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

/* compiled from: turn_off_joinable_by_owner */
public class DeltaSentMessage implements TBase, Serializable, Cloneable {
    public static boolean f2640a = true;
    private static final TStruct f2641b = new TStruct("DeltaSentMessage");
    private static final TField f2642c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2643d = new TField("attachments", (byte) 15, (short) 2);
    private static final TField f2644e = new TField("ttl", (byte) 8, (short) 3);
    private static final TField f2645f = new TField("data", (byte) 13, (short) 4);
    public final List<Attachment> attachments;
    public final Map<String, String> data;
    public final MessageMetadata messageMetadata;
    public final Integer ttl;

    private DeltaSentMessage(MessageMetadata messageMetadata, List<Attachment> list, Integer num, Map<String, String> map) {
        this.messageMetadata = messageMetadata;
        this.attachments = list;
        this.ttl = num;
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaSentMessage)) {
            return false;
        }
        DeltaSentMessage deltaSentMessage = (DeltaSentMessage) obj;
        boolean z = false;
        if (deltaSentMessage != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaSentMessage.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaSentMessage.messageMetadata))) {
                if (this.attachments != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaSentMessage.attachments != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.attachments.equals(deltaSentMessage.attachments))) {
                    if (this.ttl != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaSentMessage.ttl != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.ttl.equals(deltaSentMessage.ttl))) {
                        if (this.data != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaSentMessage.data != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.data.equals(deltaSentMessage.data))) {
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

    public static DeltaSentMessage m3796b(TProtocol tProtocol) {
        Map map = null;
        tProtocol.r();
        Integer num = null;
        List list = null;
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
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TList h = tProtocol.h();
                        List arrayList = new ArrayList(Math.max(0, h.b));
                        int i = 0;
                        while (true) {
                            if (h.b < 0) {
                                if (!TProtocol.t()) {
                                    list = arrayList;
                                    break;
                                }
                            } else if (i >= h.b) {
                                list = arrayList;
                            }
                            arrayList.add(Attachment.m3671b(tProtocol));
                            i++;
                        }
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        Map hashMap = new HashMap(Math.max(0, g.f5052c * 2));
                        int i2 = 0;
                        while (true) {
                            if (g.f5052c < 0) {
                                if (!TProtocol.s()) {
                                    map = hashMap;
                                    break;
                                }
                            } else if (i2 >= g.f5052c) {
                                map = hashMap;
                            }
                            hashMap.put(tProtocol.p(), tProtocol.p());
                            i2++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaSentMessage deltaSentMessage = new DeltaSentMessage(messageMetadata, list, num, map);
            deltaSentMessage.m3795a();
            return deltaSentMessage;
        }
    }

    public final void m3798a(TProtocol tProtocol) {
        m3795a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2642c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.attachments == null || this.attachments == null)) {
            tProtocol.a(f2643d);
            tProtocol.a(new TList((byte) 12, this.attachments.size()));
            for (Attachment a : this.attachments) {
                a.m3673a(tProtocol);
            }
        }
        if (!(this.ttl == null || this.ttl == null)) {
            tProtocol.a(f2644e);
            tProtocol.a(this.ttl.intValue());
        }
        if (!(this.data == null || this.data == null)) {
            tProtocol.a(f2645f);
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
        return m3797a(1, f2640a);
    }

    public final String m3797a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaSentMessage");
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

    private void m3795a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.ttl != null && !MessageLifetime.f2764a.contains(this.ttl)) {
            throw new TProtocolException("The field 'ttl' has been assigned the invalid value " + this.ttl);
        }
    }
}
