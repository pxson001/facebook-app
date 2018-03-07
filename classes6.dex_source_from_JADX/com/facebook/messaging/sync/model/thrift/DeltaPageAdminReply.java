package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: typeahead_parent_category_viewed */
public class DeltaPageAdminReply implements TBase, Serializable, Cloneable {
    public static boolean f2596a = true;
    private static final TStruct f2597b = new TStruct("DeltaPageAdminReply");
    private static final TField f2598c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2599d = new TField("activityToken", (byte) 11, (short) 2);
    private static final TField f2600e = new TField("replyType", (byte) 8, (short) 3);
    public final String activityToken;
    public final MessageMetadata messageMetadata;
    public final Integer replyType;

    private DeltaPageAdminReply(MessageMetadata messageMetadata, String str, Integer num) {
        this.messageMetadata = messageMetadata;
        this.activityToken = str;
        this.replyType = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaPageAdminReply)) {
            return false;
        }
        DeltaPageAdminReply deltaPageAdminReply = (DeltaPageAdminReply) obj;
        boolean z = false;
        if (deltaPageAdminReply != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaPageAdminReply.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaPageAdminReply.messageMetadata))) {
                if (this.activityToken != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaPageAdminReply.activityToken != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.activityToken.equals(deltaPageAdminReply.activityToken))) {
                    if (this.replyType != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaPageAdminReply.replyType != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.replyType.equals(deltaPageAdminReply.replyType))) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaPageAdminReply m3762b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
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
            DeltaPageAdminReply deltaPageAdminReply = new DeltaPageAdminReply(messageMetadata, str, num);
            deltaPageAdminReply.m3761a();
            return deltaPageAdminReply;
        }
    }

    public final void m3764a(TProtocol tProtocol) {
        m3761a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2598c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.activityToken == null || this.activityToken == null)) {
            tProtocol.a(f2599d);
            tProtocol.a(this.activityToken);
        }
        if (!(this.replyType == null || this.replyType == null)) {
            tProtocol.a(f2600e);
            tProtocol.a(this.replyType.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3763a(1, f2596a);
    }

    public final String m3763a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaPageAdminReply");
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
        if (this.activityToken != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("activityToken");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.activityToken == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.activityToken, i + 1, z));
            }
        }
        if (this.replyType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("replyType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.replyType == null) {
                stringBuilder.append("null");
            } else {
                str2 = (String) PageAdminReplyType.f2782b.get(this.replyType);
                if (str2 != null) {
                    stringBuilder.append(str2);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.replyType);
                if (str2 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3761a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.replyType != null && !PageAdminReplyType.f2781a.contains(this.replyType)) {
            throw new TProtocolException("The field 'replyType' has been assigned the invalid value " + this.replyType);
        }
    }
}
