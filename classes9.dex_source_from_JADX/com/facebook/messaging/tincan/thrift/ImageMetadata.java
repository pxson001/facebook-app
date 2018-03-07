package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: click_create_account_button */
public class ImageMetadata implements TBase, Serializable, Cloneable {
    public static boolean f18118a = true;
    private static final TStruct f18119b = new TStruct("ImageMetadata");
    private static final TField f18120c = new TField("width", (byte) 8, (short) 2);
    private static final TField f18121d = new TField("height", (byte) 8, (short) 3);
    public final Integer height;
    public final Integer width;

    public ImageMetadata(Integer num, Integer num2) {
        this.width = num;
        this.height = num2;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ImageMetadata)) {
            return m18081a((ImageMetadata) obj);
        }
        return false;
    }

    public final boolean m18081a(ImageMetadata imageMetadata) {
        if (imageMetadata == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.width != null;
        if (imageMetadata.width != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.width.equals(imageMetadata.width))) {
            return false;
        }
        if (this.height != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.height != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.height.equals(imageMetadata.height))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static ImageMetadata m18078b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        Integer num2 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
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
            return new ImageMetadata(num2, num);
        }
    }

    public final void m18080a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.width == null || this.width == null)) {
            tProtocol.a(f18120c);
            tProtocol.a(this.width.intValue());
        }
        if (!(this.height == null || this.height == null)) {
            tProtocol.a(f18121d);
            tProtocol.a(this.height.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18079a(1, f18118a);
    }

    public final String m18079a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ImageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
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
            obj = null;
        }
        if (this.height != null) {
            if (obj == null) {
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
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
