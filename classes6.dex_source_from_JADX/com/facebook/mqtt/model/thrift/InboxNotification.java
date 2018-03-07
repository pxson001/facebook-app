package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: title=' */
public class InboxNotification implements TBase, Serializable, Cloneable {
    public static boolean f2894a = true;
    private static final TStruct f2895b = new TStruct("InboxNotification");
    private static final TField f2896c = new TField("unread", (byte) 8, (short) 1);
    private static final TField f2897d = new TField("unseen", (byte) 8, (short) 2);
    private static final TField f2898e = new TField("seenTimestamp", (byte) 10, (short) 3);
    private static final TField f2899f = new TField("recentUnread", (byte) 8, (short) 4);
    private static final TField f2900g = new TField("realtimeViewerFbid", (byte) 10, (short) 5);
    public final Long realtimeViewerFbid;
    public final Integer recentUnread;
    public final Long seenTimestamp;
    public final Integer unread;
    public final Integer unseen;

    private InboxNotification(Integer num, Integer num2, Long l, Integer num3, Long l2) {
        this.unread = num;
        this.unseen = num2;
        this.seenTimestamp = l;
        this.recentUnread = num3;
        this.realtimeViewerFbid = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InboxNotification)) {
            return false;
        }
        InboxNotification inboxNotification = (InboxNotification) obj;
        boolean z = false;
        if (inboxNotification != null) {
            Object obj2;
            Object obj3 = this.unread != null ? 1 : null;
            if (inboxNotification.unread != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unread.equals(inboxNotification.unread))) {
                if (this.unseen != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (inboxNotification.unseen != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unseen.equals(inboxNotification.unseen))) {
                    if (this.seenTimestamp != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (inboxNotification.seenTimestamp != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.seenTimestamp.equals(inboxNotification.seenTimestamp))) {
                        if (this.recentUnread != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (inboxNotification.recentUnread != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.recentUnread.equals(inboxNotification.recentUnread))) {
                            if (this.realtimeViewerFbid != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (inboxNotification.realtimeViewerFbid != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.realtimeViewerFbid.equals(inboxNotification.realtimeViewerFbid))) {
                                z = true;
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

    public static InboxNotification m3978b(TProtocol tProtocol) {
        Long l = null;
        tProtocol.r();
        Integer num = null;
        Long l2 = null;
        Integer num2 = null;
        Integer num3 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new InboxNotification(num3, num2, l2, num, l);
        }
    }

    public final void m3980a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.unread == null || this.unread == null)) {
            tProtocol.a(f2896c);
            tProtocol.a(this.unread.intValue());
        }
        if (!(this.unseen == null || this.unseen == null)) {
            tProtocol.a(f2897d);
            tProtocol.a(this.unseen.intValue());
        }
        if (!(this.seenTimestamp == null || this.seenTimestamp == null)) {
            tProtocol.a(f2898e);
            tProtocol.a(this.seenTimestamp.longValue());
        }
        if (!(this.recentUnread == null || this.recentUnread == null)) {
            tProtocol.a(f2899f);
            tProtocol.a(this.recentUnread.intValue());
        }
        if (!(this.realtimeViewerFbid == null || this.realtimeViewerFbid == null)) {
            tProtocol.a(f2900g);
            tProtocol.a(this.realtimeViewerFbid.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3979a(1, f2894a);
    }

    public final String m3979a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("InboxNotification");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.unread != null) {
            stringBuilder.append(a);
            stringBuilder.append("unread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unread == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.unread, i + 1, z));
            }
            obj2 = null;
        }
        if (this.unseen != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("unseen");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unseen == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.unseen, i + 1, z));
            }
            obj2 = null;
        }
        if (this.seenTimestamp != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("seenTimestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.seenTimestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.seenTimestamp, i + 1, z));
            }
            obj2 = null;
        }
        if (this.recentUnread != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("recentUnread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.recentUnread == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.recentUnread, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.realtimeViewerFbid != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("realtimeViewerFbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.realtimeViewerFbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.realtimeViewerFbid, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
