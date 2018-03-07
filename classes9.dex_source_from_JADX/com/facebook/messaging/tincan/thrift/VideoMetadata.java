package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: checkout_selections */
public class VideoMetadata implements TBase, Serializable, Cloneable {
    public static boolean f18227a = true;
    private static final TStruct f18228b = new TStruct("VideoMetadata");
    private static final TField f18229c = new TField("width", (byte) 8, (short) 2);
    private static final TField f18230d = new TField("height", (byte) 8, (short) 3);
    private static final TField f18231e = new TField("duration_ms", (byte) 8, (short) 4);
    private static final TField f18232f = new TField("rotation", (byte) 8, (short) 5);
    public final Integer duration_ms;
    public final Integer height;
    public final Integer rotation;
    public final Integer width;

    private VideoMetadata(Integer num, Integer num2, Integer num3, Integer num4) {
        this.width = num;
        this.height = num2;
        this.duration_ms = num3;
        this.rotation = num4;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof VideoMetadata)) {
            return m18187a((VideoMetadata) obj);
        }
        return false;
    }

    public final boolean m18187a(VideoMetadata videoMetadata) {
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
        if (this.duration_ms != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (videoMetadata.duration_ms != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.duration_ms.equals(videoMetadata.duration_ms))) {
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

    public static VideoMetadata m18184b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        Integer num2 = null;
        Integer num3 = null;
        Integer num4 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num4 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new VideoMetadata(num4, num3, num2, num);
        }
    }

    public final void m18186a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.width == null || this.width == null)) {
            tProtocol.a(f18229c);
            tProtocol.a(this.width.intValue());
        }
        if (!(this.height == null || this.height == null)) {
            tProtocol.a(f18230d);
            tProtocol.a(this.height.intValue());
        }
        if (!(this.duration_ms == null || this.duration_ms == null)) {
            tProtocol.a(f18231e);
            tProtocol.a(this.duration_ms.intValue());
        }
        if (!(this.rotation == null || this.rotation == null)) {
            tProtocol.a(f18232f);
            tProtocol.a(this.rotation.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18185a(1, f18227a);
    }

    public final String m18185a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
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
                stringBuilder.append(TBaseHelper.a(this.width, i + 1, z));
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
                stringBuilder.append(TBaseHelper.a(this.height, i + 1, z));
            }
            obj2 = null;
        }
        if (this.duration_ms != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("duration_ms");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.duration_ms == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.duration_ms, i + 1, z));
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
                stringBuilder.append(TBaseHelper.a(this.rotation, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
