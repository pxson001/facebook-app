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

/* compiled from: unfriended_user */
public class AttachmentAppAttribution implements TBase, Serializable, Cloneable {
    public static boolean f2471a = true;
    private static final TStruct f2472b = new TStruct("AttachmentAppAttribution");
    private static final TField f2473c = new TField("attributionAppId", (byte) 10, (short) 1);
    private static final TField f2474d = new TField("attributionMetadata", (byte) 11, (short) 2);
    private static final TField f2475e = new TField("attributionAppName", (byte) 11, (short) 3);
    private static final TField f2476f = new TField("attributionAppIconURI", (byte) 11, (short) 4);
    private static final TField f2477g = new TField("androidPackageName", (byte) 11, (short) 5);
    private static final TField f2478h = new TField("iOSStoreId", (byte) 10, (short) 6);
    private static final TField f2479i = new TField("otherUserAppScopedFbIds", (byte) 13, (short) 7);
    private static final TField f2480j = new TField("visibility", (byte) 12, (short) 8);
    private static final TField f2481k = new TField("replyActionType", (byte) 8, (short) 9);
    private static final TField f2482l = new TField("customReplyAction", (byte) 11, (short) 10);
    public final String androidPackageName;
    public final String attributionAppIconURI;
    public final Long attributionAppId;
    public final String attributionAppName;
    public final String attributionMetadata;
    public final String customReplyAction;
    public final Long iOSStoreId;
    public final Map<Long, Long> otherUserAppScopedFbIds;
    public final Integer replyActionType;
    public final AppAttributionVisibility visibility;

    private AttachmentAppAttribution(Long l, String str, String str2, String str3, String str4, Long l2, Map<Long, Long> map, AppAttributionVisibility appAttributionVisibility, Integer num, String str5) {
        this.attributionAppId = l;
        this.attributionMetadata = str;
        this.attributionAppName = str2;
        this.attributionAppIconURI = str3;
        this.androidPackageName = str4;
        this.iOSStoreId = l2;
        this.otherUserAppScopedFbIds = map;
        this.visibility = appAttributionVisibility;
        this.replyActionType = num;
        this.customReplyAction = str5;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AttachmentAppAttribution)) {
            return m3679a((AttachmentAppAttribution) obj);
        }
        return false;
    }

    public final boolean m3679a(AttachmentAppAttribution attachmentAppAttribution) {
        if (attachmentAppAttribution == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.attributionAppId != null;
        if (attachmentAppAttribution.attributionAppId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attributionAppId.equals(attachmentAppAttribution.attributionAppId))) {
            return false;
        }
        if (this.attributionMetadata != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.attributionMetadata != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attributionMetadata.equals(attachmentAppAttribution.attributionMetadata))) {
            return false;
        }
        if (this.attributionAppName != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.attributionAppName != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attributionAppName.equals(attachmentAppAttribution.attributionAppName))) {
            return false;
        }
        if (this.attributionAppIconURI != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.attributionAppIconURI != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attributionAppIconURI.equals(attachmentAppAttribution.attributionAppIconURI))) {
            return false;
        }
        if (this.androidPackageName != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.androidPackageName != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.androidPackageName.equals(attachmentAppAttribution.androidPackageName))) {
            return false;
        }
        if (this.iOSStoreId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.iOSStoreId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.iOSStoreId.equals(attachmentAppAttribution.iOSStoreId))) {
            return false;
        }
        if (this.otherUserAppScopedFbIds != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.otherUserAppScopedFbIds != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.otherUserAppScopedFbIds.equals(attachmentAppAttribution.otherUserAppScopedFbIds))) {
            return false;
        }
        if (this.visibility != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.visibility != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.visibility.m3670a(attachmentAppAttribution.visibility))) {
            return false;
        }
        if (this.replyActionType != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.replyActionType != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.replyActionType.equals(attachmentAppAttribution.replyActionType))) {
            return false;
        }
        if (this.customReplyAction != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachmentAppAttribution.customReplyAction != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.customReplyAction.equals(attachmentAppAttribution.customReplyAction))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static AttachmentAppAttribution m3676b(TProtocol tProtocol) {
        Long l = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Long l2 = null;
        Map map = null;
        AppAttributionVisibility appAttributionVisibility = null;
        Integer num = null;
        String str5 = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 5:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str4 = tProtocol.p();
                        break;
                    case (short) 6:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 7:
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
                            map.put(Long.valueOf(tProtocol.n()), Long.valueOf(tProtocol.n()));
                            i++;
                        }
                    case (short) 8:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        appAttributionVisibility = AppAttributionVisibility.m3667b(tProtocol);
                        break;
                    case (short) 9:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 10:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str5 = tProtocol.p();
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            AttachmentAppAttribution attachmentAppAttribution = new AttachmentAppAttribution(l, str, str2, str3, str4, l2, map, appAttributionVisibility, num, str5);
            attachmentAppAttribution.m3675a();
            return attachmentAppAttribution;
        }
    }

    public final void m3678a(TProtocol tProtocol) {
        m3675a();
        tProtocol.a();
        if (this.attributionAppId != null) {
            tProtocol.a(f2473c);
            tProtocol.a(this.attributionAppId.longValue());
        }
        if (!(this.attributionMetadata == null || this.attributionMetadata == null)) {
            tProtocol.a(f2474d);
            tProtocol.a(this.attributionMetadata);
        }
        if (!(this.attributionAppName == null || this.attributionAppName == null)) {
            tProtocol.a(f2475e);
            tProtocol.a(this.attributionAppName);
        }
        if (!(this.attributionAppIconURI == null || this.attributionAppIconURI == null)) {
            tProtocol.a(f2476f);
            tProtocol.a(this.attributionAppIconURI);
        }
        if (!(this.androidPackageName == null || this.androidPackageName == null)) {
            tProtocol.a(f2477g);
            tProtocol.a(this.androidPackageName);
        }
        if (!(this.iOSStoreId == null || this.iOSStoreId == null)) {
            tProtocol.a(f2478h);
            tProtocol.a(this.iOSStoreId.longValue());
        }
        if (!(this.otherUserAppScopedFbIds == null || this.otherUserAppScopedFbIds == null)) {
            tProtocol.a(f2479i);
            tProtocol.a(new TMap((byte) 10, (byte) 10, this.otherUserAppScopedFbIds.size()));
            for (Entry entry : this.otherUserAppScopedFbIds.entrySet()) {
                tProtocol.a(((Long) entry.getKey()).longValue());
                tProtocol.a(((Long) entry.getValue()).longValue());
            }
        }
        if (!(this.visibility == null || this.visibility == null)) {
            tProtocol.a(f2480j);
            this.visibility.m3669a(tProtocol);
        }
        if (!(this.replyActionType == null || this.replyActionType == null)) {
            tProtocol.a(f2481k);
            tProtocol.a(this.replyActionType.intValue());
        }
        if (!(this.customReplyAction == null || this.customReplyAction == null)) {
            tProtocol.a(f2482l);
            tProtocol.a(this.customReplyAction);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3677a(1, f2471a);
    }

    public final String m3677a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AttachmentAppAttribution");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("attributionAppId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.attributionAppId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.attributionAppId, i + 1, z));
        }
        if (this.attributionMetadata != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("attributionMetadata");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attributionMetadata == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attributionMetadata, i + 1, z));
            }
        }
        if (this.attributionAppName != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("attributionAppName");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attributionAppName == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attributionAppName, i + 1, z));
            }
        }
        if (this.attributionAppIconURI != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("attributionAppIconURI");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attributionAppIconURI == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attributionAppIconURI, i + 1, z));
            }
        }
        if (this.androidPackageName != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("androidPackageName");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.androidPackageName == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.androidPackageName, i + 1, z));
            }
        }
        if (this.iOSStoreId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("iOSStoreId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.iOSStoreId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.iOSStoreId, i + 1, z));
            }
        }
        if (this.otherUserAppScopedFbIds != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("otherUserAppScopedFbIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.otherUserAppScopedFbIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.otherUserAppScopedFbIds, i + 1, z));
            }
        }
        if (this.visibility != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("visibility");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.visibility == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.visibility, i + 1, z));
            }
        }
        if (this.replyActionType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("replyActionType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.replyActionType == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) AttributionReplyActionType.f2484b.get(this.replyActionType);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.replyActionType);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.customReplyAction != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("customReplyAction");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.customReplyAction == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.customReplyAction, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3675a() {
        if (this.attributionAppId == null) {
            throw new TProtocolException(6, "Required field 'attributionAppId' was not present! Struct: " + toString());
        } else if (this.replyActionType != null && !AttributionReplyActionType.f2483a.contains(this.replyActionType)) {
            throw new TProtocolException("The field 'replyActionType' has been assigned the invalid value " + this.replyActionType);
        }
    }
}
