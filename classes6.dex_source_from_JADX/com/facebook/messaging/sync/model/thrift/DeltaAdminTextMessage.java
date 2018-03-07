package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ul */
public class DeltaAdminTextMessage implements TBase, Serializable, Cloneable {
    public static boolean f2496a = true;
    private static final TStruct f2497b = new TStruct("DeltaAdminTextMessage");
    private static final TField f2498c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2499d = new TField("type", (byte) 11, (short) 2);
    private static final TField f2500e = new TField("untypedData", (byte) 13, (short) 3);
    private static final TField f2501f = new TField("ttl", (byte) 8, (short) 4);
    public final MessageMetadata messageMetadata;
    public final Integer ttl;
    public final String type;
    public final Map<String, String> untypedData;

    private DeltaAdminTextMessage(MessageMetadata messageMetadata, String str, Map<String, String> map, Integer num) {
        this.messageMetadata = messageMetadata;
        this.type = str;
        this.untypedData = map;
        this.ttl = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaAdminTextMessage)) {
            return false;
        }
        DeltaAdminTextMessage deltaAdminTextMessage = (DeltaAdminTextMessage) obj;
        boolean z = false;
        if (deltaAdminTextMessage != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaAdminTextMessage.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaAdminTextMessage.messageMetadata))) {
                if (this.type != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaAdminTextMessage.type != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.type.equals(deltaAdminTextMessage.type))) {
                    if (this.untypedData != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaAdminTextMessage.untypedData != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.untypedData.equals(deltaAdminTextMessage.untypedData))) {
                        if (this.ttl != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deltaAdminTextMessage.ttl != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.ttl.equals(deltaAdminTextMessage.ttl))) {
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

    public static DeltaAdminTextMessage m3693b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        Map map = null;
        String str = null;
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
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        TMap g = tProtocol.g();
                        map = new HashMap(Math.max(0, g.f5052c * 2));
                        int i = 0;
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
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaAdminTextMessage deltaAdminTextMessage = new DeltaAdminTextMessage(messageMetadata, str, map, num);
            deltaAdminTextMessage.m3692a();
            return deltaAdminTextMessage;
        }
    }

    public final void m3695a(TProtocol tProtocol) {
        m3692a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2498c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.type == null || this.type == null)) {
            tProtocol.a(f2499d);
            tProtocol.a(this.type);
        }
        if (!(this.untypedData == null || this.untypedData == null)) {
            tProtocol.a(f2500e);
            tProtocol.a(new TMap((byte) 11, (byte) 11, this.untypedData.size()));
            for (Entry entry : this.untypedData.entrySet()) {
                tProtocol.a((String) entry.getKey());
                tProtocol.a((String) entry.getValue());
            }
        }
        if (!(this.ttl == null || this.ttl == null)) {
            tProtocol.a(f2501f);
            tProtocol.a(this.ttl.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3694a(1, f2496a);
    }

    public final String m3694a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaAdminTextMessage");
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
        if (this.type != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("type");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.type == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.type, i + 1, z));
            }
        }
        if (this.untypedData != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("untypedData");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.untypedData == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.untypedData, i + 1, z));
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
                str2 = (String) MessageLifetime.f2765b.get(this.ttl);
                if (str2 != null) {
                    stringBuilder.append(str2);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.ttl);
                if (str2 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3692a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.ttl != null && !MessageLifetime.f2764a.contains(this.ttl)) {
            throw new TProtocolException("The field 'ttl' has been assigned the invalid value " + this.ttl);
        }
    }
}
