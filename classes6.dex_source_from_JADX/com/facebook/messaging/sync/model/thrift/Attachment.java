package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: variant_labels */
public class Attachment implements TBase, Serializable, Cloneable {
    public static boolean f2458a = true;
    private static final TStruct f2459b = new TStruct("Attachment");
    private static final TField f2460c = new TField("id", (byte) 11, (short) 1);
    private static final TField f2461d = new TField("mimeType", (byte) 11, (short) 2);
    private static final TField f2462e = new TField("filename", (byte) 11, (short) 3);
    private static final TField f2463f = new TField("fbid", (byte) 10, (short) 4);
    private static final TField f2464g = new TField("fileSize", (byte) 10, (short) 5);
    private static final TField f2465h = new TField("attributionInfo", (byte) 12, (short) 6);
    private static final TField f2466i = new TField("xmaGraphQL", (byte) 11, (short) 7);
    private static final TField f2467j = new TField("imageMetadata", (byte) 12, (short) 10);
    private static final TField f2468k = new TField("videoMetadata", (byte) 12, (short) 11);
    private static final TField f2469l = new TField("audioMetadata", (byte) 12, (short) 12);
    private static final TField f2470m = new TField("data", (byte) 13, (short) 13);
    public final AttachmentAppAttribution attributionInfo;
    public final AudioMetadata audioMetadata;
    public final Map<String, String> data;
    public final Long fbid;
    public final Long fileSize;
    public final String filename;
    public final String id;
    public final ImageMetadata imageMetadata;
    public final String mimeType;
    public final VideoMetadata videoMetadata;
    public final String xmaGraphQL;

    private Attachment(String str, String str2, String str3, Long l, Long l2, AttachmentAppAttribution attachmentAppAttribution, String str4, ImageMetadata imageMetadata, VideoMetadata videoMetadata, AudioMetadata audioMetadata, Map<String, String> map) {
        this.id = str;
        this.mimeType = str2;
        this.filename = str3;
        this.fbid = l;
        this.fileSize = l2;
        this.attributionInfo = attachmentAppAttribution;
        this.xmaGraphQL = str4;
        this.imageMetadata = imageMetadata;
        this.videoMetadata = videoMetadata;
        this.audioMetadata = audioMetadata;
        this.data = map;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Attachment)) {
            return m3674a((Attachment) obj);
        }
        return false;
    }

    public final boolean m3674a(Attachment attachment) {
        if (attachment == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.id != null;
        if (attachment.id != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.id.equals(attachment.id))) {
            return false;
        }
        if (this.mimeType != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.mimeType != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.mimeType.equals(attachment.mimeType))) {
            return false;
        }
        if (this.filename != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.filename != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.filename.equals(attachment.filename))) {
            return false;
        }
        if (this.fbid != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.fbid != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fbid.equals(attachment.fbid))) {
            return false;
        }
        if (this.fileSize != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.fileSize != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fileSize.equals(attachment.fileSize))) {
            return false;
        }
        if (this.attributionInfo != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.attributionInfo != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.attributionInfo.m3679a(attachment.attributionInfo))) {
            return false;
        }
        if (this.xmaGraphQL != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.xmaGraphQL != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.xmaGraphQL.equals(attachment.xmaGraphQL))) {
            return false;
        }
        if (this.imageMetadata != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.imageMetadata != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.imageMetadata.m3916a(attachment.imageMetadata))) {
            return false;
        }
        if (this.videoMetadata != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.videoMetadata != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.videoMetadata.m3944a(attachment.videoMetadata))) {
            return false;
        }
        if (this.audioMetadata != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.audioMetadata != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.audioMetadata.m3683a(attachment.audioMetadata))) {
            return false;
        }
        if (this.data != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (attachment.data != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.data.equals(attachment.data))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static Attachment m3671b(TProtocol tProtocol) {
        String str = null;
        String str2 = null;
        String str3 = null;
        Long l = null;
        Long l2 = null;
        AttachmentAppAttribution attachmentAppAttribution = null;
        String str4 = null;
        ImageMetadata imageMetadata = null;
        VideoMetadata videoMetadata = null;
        AudioMetadata audioMetadata = null;
        Map map = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 3:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        attachmentAppAttribution = AttachmentAppAttribution.m3676b(tProtocol);
                        break;
                    case (short) 7:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str4 = tProtocol.p();
                        break;
                    case (short) 10:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        imageMetadata = ImageMetadata.m3913b(tProtocol);
                        break;
                    case (short) 11:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        videoMetadata = VideoMetadata.m3941b(tProtocol);
                        break;
                    case (short) 12:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        audioMetadata = AudioMetadata.m3680b(tProtocol);
                        break;
                    case (short) 13:
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
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new Attachment(str, str2, str3, l, l2, attachmentAppAttribution, str4, imageMetadata, videoMetadata, audioMetadata, map);
        }
    }

    public final void m3673a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.id == null || this.id == null)) {
            tProtocol.a(f2460c);
            tProtocol.a(this.id);
        }
        if (!(this.mimeType == null || this.mimeType == null)) {
            tProtocol.a(f2461d);
            tProtocol.a(this.mimeType);
        }
        if (!(this.filename == null || this.filename == null)) {
            tProtocol.a(f2462e);
            tProtocol.a(this.filename);
        }
        if (!(this.fbid == null || this.fbid == null)) {
            tProtocol.a(f2463f);
            tProtocol.a(this.fbid.longValue());
        }
        if (!(this.fileSize == null || this.fileSize == null)) {
            tProtocol.a(f2464g);
            tProtocol.a(this.fileSize.longValue());
        }
        if (!(this.attributionInfo == null || this.attributionInfo == null)) {
            tProtocol.a(f2465h);
            this.attributionInfo.m3678a(tProtocol);
        }
        if (!(this.xmaGraphQL == null || this.xmaGraphQL == null)) {
            tProtocol.a(f2466i);
            tProtocol.a(this.xmaGraphQL);
        }
        if (!(this.imageMetadata == null || this.imageMetadata == null)) {
            tProtocol.a(f2467j);
            this.imageMetadata.m3915a(tProtocol);
        }
        if (!(this.videoMetadata == null || this.videoMetadata == null)) {
            tProtocol.a(f2468k);
            this.videoMetadata.m3943a(tProtocol);
        }
        if (!(this.audioMetadata == null || this.audioMetadata == null)) {
            tProtocol.a(f2469l);
            this.audioMetadata.m3682a(tProtocol);
        }
        if (!(this.data == null || this.data == null)) {
            tProtocol.a(f2470m);
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
        return m3672a(1, f2458a);
    }

    public final String m3672a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("Attachment");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.id != null) {
            stringBuilder.append(a);
            stringBuilder.append("id");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.id == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.id, i + 1, z));
            }
            obj2 = null;
        }
        if (this.mimeType != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("mimeType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.mimeType == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.mimeType, i + 1, z));
            }
            obj2 = null;
        }
        if (this.filename != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("filename");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.filename == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.filename, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fbid != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.fbid, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fileSize != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fileSize");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fileSize == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.fileSize, i + 1, z));
            }
            obj2 = null;
        }
        if (this.attributionInfo != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("attributionInfo");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attributionInfo == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attributionInfo, i + 1, z));
            }
            obj2 = null;
        }
        if (this.xmaGraphQL != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("xmaGraphQL");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.xmaGraphQL == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.xmaGraphQL, i + 1, z));
            }
            obj2 = null;
        }
        if (this.imageMetadata != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("imageMetadata");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.imageMetadata == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.imageMetadata, i + 1, z));
            }
            obj2 = null;
        }
        if (this.videoMetadata != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("videoMetadata");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.videoMetadata == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.videoMetadata, i + 1, z));
            }
            obj2 = null;
        }
        if (this.audioMetadata != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("audioMetadata");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.audioMetadata == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.audioMetadata, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.data != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
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
}
