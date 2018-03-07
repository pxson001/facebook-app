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

/* compiled from: use_device_location */
public class MessageMetadata implements TBase, Serializable, Cloneable {
    public static boolean f2766a = true;
    private static final TStruct f2767b = new TStruct("MessageMetadata");
    private static final TField f2768c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2769d = new TField("messageId", (byte) 11, (short) 2);
    private static final TField f2770e = new TField("offlineThreadingId", (byte) 10, (short) 3);
    private static final TField f2771f = new TField("actorFbId", (byte) 10, (short) 4);
    private static final TField f2772g = new TField("timestamp", (byte) 10, (short) 5);
    private static final TField f2773h = new TField("shouldBuzzDevice", (byte) 2, (short) 6);
    private static final TField f2774i = new TField("adminText", (byte) 11, (short) 7);
    private static final TField f2775j = new TField("tags", (byte) 15, (short) 8);
    public final Long actorFbId;
    public final String adminText;
    public final String messageId;
    public final Long offlineThreadingId;
    public final Boolean shouldBuzzDevice;
    public final List<String> tags;
    public final ThreadKey threadKey;
    public final Long timestamp;

    private MessageMetadata(ThreadKey threadKey, String str, Long l, Long l2, Long l3, Boolean bool, String str2, List<String> list) {
        this.threadKey = threadKey;
        this.messageId = str;
        this.offlineThreadingId = l;
        this.actorFbId = l2;
        this.timestamp = l3;
        this.shouldBuzzDevice = bool;
        this.adminText = str2;
        this.tags = list;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof MessageMetadata)) {
            return m3920a((MessageMetadata) obj);
        }
        return false;
    }

    public final boolean m3920a(MessageMetadata messageMetadata) {
        if (messageMetadata == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.threadKey != null;
        if (messageMetadata.threadKey != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.threadKey.m3939a(messageMetadata.threadKey))) {
            return false;
        }
        if (this.messageId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.messageId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.messageId.equals(messageMetadata.messageId))) {
            return false;
        }
        if (this.offlineThreadingId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.offlineThreadingId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.offlineThreadingId.equals(messageMetadata.offlineThreadingId))) {
            return false;
        }
        if (this.actorFbId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.actorFbId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.actorFbId.equals(messageMetadata.actorFbId))) {
            return false;
        }
        if (this.timestamp != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.timestamp != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.timestamp.equals(messageMetadata.timestamp))) {
            return false;
        }
        if (this.shouldBuzzDevice != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.shouldBuzzDevice != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.shouldBuzzDevice.equals(messageMetadata.shouldBuzzDevice))) {
            return false;
        }
        if (this.adminText != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.adminText != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.adminText.equals(messageMetadata.adminText))) {
            return false;
        }
        if (this.tags != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (messageMetadata.tags != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.tags.equals(messageMetadata.tags))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static MessageMetadata m3917b(TProtocol tProtocol) {
        List list = null;
        tProtocol.r();
        String str = null;
        Boolean bool = null;
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        String str2 = null;
        ThreadKey threadKey = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        threadKey = ThreadKey.m3936b(tProtocol);
                        break;
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l3 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 7:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 8:
                        if (f.b != (byte) 15) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
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
                            list.add(tProtocol.p());
                            i++;
                        }
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new MessageMetadata(threadKey, str2, l3, l2, l, bool, str, list);
        }
    }

    public final void m3919a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2768c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.messageId == null || this.messageId == null)) {
            tProtocol.a(f2769d);
            tProtocol.a(this.messageId);
        }
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f2770e);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.actorFbId == null || this.actorFbId == null)) {
            tProtocol.a(f2771f);
            tProtocol.a(this.actorFbId.longValue());
        }
        if (!(this.timestamp == null || this.timestamp == null)) {
            tProtocol.a(f2772g);
            tProtocol.a(this.timestamp.longValue());
        }
        if (!(this.shouldBuzzDevice == null || this.shouldBuzzDevice == null)) {
            tProtocol.a(f2773h);
            tProtocol.a(this.shouldBuzzDevice.booleanValue());
        }
        if (!(this.adminText == null || this.adminText == null)) {
            tProtocol.a(f2774i);
            tProtocol.a(this.adminText);
        }
        if (!(this.tags == null || this.tags == null)) {
            tProtocol.a(f2775j);
            tProtocol.a(new TList((byte) 11, this.tags.size()));
            for (String a : this.tags) {
                tProtocol.a(a);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3918a(1, f2766a);
    }

    public final String m3918a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("MessageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj2 = null;
        }
        if (this.messageId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("messageId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.messageId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.offlineThreadingId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("offlineThreadingId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.offlineThreadingId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.offlineThreadingId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.actorFbId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("actorFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actorFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actorFbId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.timestamp != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("timestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.timestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.timestamp, i + 1, z));
            }
            obj2 = null;
        }
        if (this.shouldBuzzDevice != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("shouldBuzzDevice");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.shouldBuzzDevice == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.shouldBuzzDevice, i + 1, z));
            }
            obj2 = null;
        }
        if (this.adminText != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("adminText");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.adminText == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.adminText, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.tags != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("tags");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.tags == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.tags, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
