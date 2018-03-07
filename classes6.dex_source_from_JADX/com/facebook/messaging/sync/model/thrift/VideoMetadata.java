package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: total_assets_downloaded */
public class VideoMetadata implements TBase, Serializable, Cloneable {
    public static boolean f2815a = true;
    private static final TStruct f2816b = new TStruct("VideoMetadata");
    private static final TField f2817c = new TField("width", (byte) 8, (short) 1);
    private static final TField f2818d = new TField("height", (byte) 8, (short) 2);
    private static final TField f2819e = new TField("durationMs", (byte) 8, (short) 3);
    private static final TField f2820f = new TField("thumbnailUri", (byte) 11, (short) 4);
    private static final TField f2821g = new TField("videoUri", (byte) 11, (short) 5);
    private static final TField f2822h = new TField("source", (byte) 8, (short) 6);
    private static final TField f2823i = new TField("rotation", (byte) 8, (short) 7);
    public final Integer durationMs;
    public final Integer height;
    public final Integer rotation;
    public final Integer source;
    public final String thumbnailUri;
    public final String videoUri;
    public final Integer width;

    private VideoMetadata(Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, Integer num5) {
        this.width = num;
        this.height = num2;
        this.durationMs = num3;
        this.thumbnailUri = str;
        this.videoUri = str2;
        this.source = num4;
        this.rotation = num5;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof VideoMetadata)) {
            return m3944a((VideoMetadata) obj);
        }
        return false;
    }

    public final boolean m3944a(VideoMetadata videoMetadata) {
        if (videoMetadata == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.width != null;
        if (videoMetadata.width != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.width.equals(videoMetadata.width))) {
            return false;
        }
        if (this.height != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.height != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.height.equals(videoMetadata.height))) {
            return false;
        }
        if (this.durationMs != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.durationMs != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.durationMs.equals(videoMetadata.durationMs))) {
            return false;
        }
        if (this.thumbnailUri != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.thumbnailUri != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.thumbnailUri.equals(videoMetadata.thumbnailUri))) {
            return false;
        }
        if (this.videoUri != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.videoUri != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.videoUri.equals(videoMetadata.videoUri))) {
            return false;
        }
        if (this.source != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.source != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.source.equals(videoMetadata.source))) {
            return false;
        }
        if (this.rotation != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.rotation != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.rotation.equals(videoMetadata.rotation))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static VideoMetadata m3941b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        Integer num2 = null;
        String str = null;
        String str2 = null;
        Integer num3 = null;
        Integer num4 = null;
        Integer num5 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num5 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num4 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 5:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 6:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 7:
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
            VideoMetadata videoMetadata = new VideoMetadata(num5, num4, num3, str2, str, num2, num);
            videoMetadata.m3940a();
            return videoMetadata;
        }
    }

    public final void m3943a(TProtocol tProtocol) {
        m3940a();
        tProtocol.a();
        if (!(this.width == null || this.width == null)) {
            tProtocol.a(f2817c);
            tProtocol.a(this.width.intValue());
        }
        if (!(this.height == null || this.height == null)) {
            tProtocol.a(f2818d);
            tProtocol.a(this.height.intValue());
        }
        if (!(this.durationMs == null || this.durationMs == null)) {
            tProtocol.a(f2819e);
            tProtocol.a(this.durationMs.intValue());
        }
        if (!(this.thumbnailUri == null || this.thumbnailUri == null)) {
            tProtocol.a(f2820f);
            tProtocol.a(this.thumbnailUri);
        }
        if (!(this.videoUri == null || this.videoUri == null)) {
            tProtocol.a(f2821g);
            tProtocol.a(this.videoUri);
        }
        if (!(this.source == null || this.source == null)) {
            tProtocol.a(f2822h);
            tProtocol.a(this.source.intValue());
        }
        if (!(this.rotation == null || this.rotation == null)) {
            tProtocol.a(f2823i);
            tProtocol.a(this.rotation.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3942a(1, f2815a);
    }

    public final String m3942a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("VideoMetadata");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.width != null) {
            stringBuilder.append(a);
            stringBuilder.append("width");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.width == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.width, i + 1, z));
            }
            obj2 = null;
        }
        if (this.height != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("height");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.height == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.height, i + 1, z));
            }
            obj2 = null;
        }
        if (this.durationMs != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("durationMs");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.durationMs == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.durationMs, i + 1, z));
            }
            obj2 = null;
        }
        if (this.thumbnailUri != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("thumbnailUri");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.thumbnailUri == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.thumbnailUri, i + 1, z));
            }
            obj2 = null;
        }
        if (this.videoUri != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("videoUri");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.videoUri == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.videoUri, i + 1, z));
            }
            obj2 = null;
        }
        if (this.source != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("source");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.source == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) VideoSource.f2825b.get(this.source);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.source);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        } else {
            obj = obj2;
        }
        if (this.rotation != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("rotation");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.rotation == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.rotation, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3940a() {
        if (this.source != null && !VideoSource.f2824a.contains(this.source)) {
            throw new TProtocolException("The field 'source' has been assigned the invalid value " + this.source);
        }
    }
}
