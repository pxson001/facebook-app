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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: transcodeFailCount */
public class ImageMetadata implements TBase, Serializable, Cloneable {
    public static boolean f2747a = true;
    private static final TStruct f2748b = new TStruct("ImageMetadata");
    private static final TField f2749c = new TField("width", (byte) 8, (short) 1);
    private static final TField f2750d = new TField("height", (byte) 8, (short) 2);
    private static final TField f2751e = new TField("imageURIMap", (byte) 13, (short) 3);
    private static final TField f2752f = new TField("imageSource", (byte) 8, (short) 4);
    private static final TField f2753g = new TField("rawImageURI", (byte) 11, (short) 5);
    private static final TField f2754h = new TField("rawImageURIFormat", (byte) 11, (short) 6);
    private static final TField f2755i = new TField("animatedImageURIMap", (byte) 13, (short) 7);
    private static final TField f2756j = new TField("imageURIMapFormat", (byte) 11, (short) 8);
    private static final TField f2757k = new TField("animatedImageURIMapFormat", (byte) 11, (short) 9);
    private static final TField f2758l = new TField("renderAsSticker", (byte) 2, (short) 10);
    private static final TField f2759m = new TField("miniPreview", (byte) 11, (short) 11);
    public final Map<Integer, String> animatedImageURIMap;
    public final String animatedImageURIMapFormat;
    public final Integer height;
    public final Integer imageSource;
    public final Map<Integer, String> imageURIMap;
    public final String imageURIMapFormat;
    public final byte[] miniPreview;
    public final String rawImageURI;
    public final String rawImageURIFormat;
    public final Boolean renderAsSticker;
    public final Integer width;

    private ImageMetadata(Integer num, Integer num2, Map<Integer, String> map, Integer num3, String str, String str2, Map<Integer, String> map2, String str3, String str4, Boolean bool, byte[] bArr) {
        this.width = num;
        this.height = num2;
        this.imageURIMap = map;
        this.imageSource = num3;
        this.rawImageURI = str;
        this.rawImageURIFormat = str2;
        this.animatedImageURIMap = map2;
        this.imageURIMapFormat = str3;
        this.animatedImageURIMapFormat = str4;
        this.renderAsSticker = bool;
        this.miniPreview = bArr;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ImageMetadata)) {
            return m3916a((ImageMetadata) obj);
        }
        return false;
    }

    public final boolean m3916a(ImageMetadata imageMetadata) {
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
        if (this.imageURIMap != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.imageURIMap != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.imageURIMap.equals(imageMetadata.imageURIMap))) {
            return false;
        }
        if (this.imageSource != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.imageSource != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.imageSource.equals(imageMetadata.imageSource))) {
            return false;
        }
        if (this.rawImageURI != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.rawImageURI != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.rawImageURI.equals(imageMetadata.rawImageURI))) {
            return false;
        }
        if (this.rawImageURIFormat != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.rawImageURIFormat != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.rawImageURIFormat.equals(imageMetadata.rawImageURIFormat))) {
            return false;
        }
        if (this.animatedImageURIMap != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.animatedImageURIMap != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.animatedImageURIMap.equals(imageMetadata.animatedImageURIMap))) {
            return false;
        }
        if (this.imageURIMapFormat != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.imageURIMapFormat != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.imageURIMapFormat.equals(imageMetadata.imageURIMapFormat))) {
            return false;
        }
        if (this.animatedImageURIMapFormat != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.animatedImageURIMapFormat != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.animatedImageURIMapFormat.equals(imageMetadata.animatedImageURIMapFormat))) {
            return false;
        }
        if (this.renderAsSticker != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.renderAsSticker != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.renderAsSticker.equals(imageMetadata.renderAsSticker))) {
            return false;
        }
        if (this.miniPreview != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (imageMetadata.miniPreview != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.miniPreview, imageMetadata.miniPreview))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public static ImageMetadata m3913b(TProtocol tProtocol) {
        Integer num = null;
        Integer num2 = null;
        Map map = null;
        Integer num3 = null;
        String str = null;
        String str2 = null;
        Map map2 = null;
        String str3 = null;
        String str4 = null;
        Boolean bool = null;
        byte[] bArr = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                TMap g;
                int i;
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 2:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num2 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 3:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        g = tProtocol.g();
                        map = new HashMap(Math.max(0, g.f5052c * 2));
                        i = 0;
                        while (true) {
                            if (g.f5052c >= 0) {
                                if (i >= g.f5052c) {
                                    break;
                                }
                            } else if (!TProtocol.s()) {
                                break;
                            }
                            map.put(Integer.valueOf(tProtocol.m()), tProtocol.p());
                            i++;
                        }
                    case (short) 4:
                        if (f.b != (byte) 8) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        num3 = Integer.valueOf(tProtocol.m());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 6:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 7:
                        if (f.b != (byte) 13) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        g = tProtocol.g();
                        map2 = new HashMap(Math.max(0, g.f5052c * 2));
                        i = 0;
                        while (true) {
                            if (g.f5052c >= 0) {
                                if (i >= g.f5052c) {
                                    break;
                                }
                            } else if (!TProtocol.s()) {
                                break;
                            }
                            map2.put(Integer.valueOf(tProtocol.m()), tProtocol.p());
                            i++;
                        }
                    case (short) 8:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str3 = tProtocol.p();
                        break;
                    case (short) 9:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        str4 = tProtocol.p();
                        break;
                    case (short) 10:
                        if (f.b != (byte) 2) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bool = Boolean.valueOf(tProtocol.j());
                        break;
                    case (short) 11:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            ImageMetadata imageMetadata = new ImageMetadata(num, num2, map, num3, str, str2, map2, str3, str4, bool, bArr);
            imageMetadata.m3912a();
            return imageMetadata;
        }
    }

    public final void m3915a(TProtocol tProtocol) {
        m3912a();
        tProtocol.a();
        if (!(this.width == null || this.width == null)) {
            tProtocol.a(f2749c);
            tProtocol.a(this.width.intValue());
        }
        if (!(this.height == null || this.height == null)) {
            tProtocol.a(f2750d);
            tProtocol.a(this.height.intValue());
        }
        if (!(this.imageURIMap == null || this.imageURIMap == null)) {
            tProtocol.a(f2751e);
            tProtocol.a(new TMap((byte) 8, (byte) 11, this.imageURIMap.size()));
            for (Entry entry : this.imageURIMap.entrySet()) {
                tProtocol.a(((Integer) entry.getKey()).intValue());
                tProtocol.a((String) entry.getValue());
            }
        }
        if (!(this.imageSource == null || this.imageSource == null)) {
            tProtocol.a(f2752f);
            tProtocol.a(this.imageSource.intValue());
        }
        if (!(this.rawImageURI == null || this.rawImageURI == null)) {
            tProtocol.a(f2753g);
            tProtocol.a(this.rawImageURI);
        }
        if (!(this.rawImageURIFormat == null || this.rawImageURIFormat == null)) {
            tProtocol.a(f2754h);
            tProtocol.a(this.rawImageURIFormat);
        }
        if (!(this.animatedImageURIMap == null || this.animatedImageURIMap == null)) {
            tProtocol.a(f2755i);
            tProtocol.a(new TMap((byte) 8, (byte) 11, this.animatedImageURIMap.size()));
            for (Entry entry2 : this.animatedImageURIMap.entrySet()) {
                tProtocol.a(((Integer) entry2.getKey()).intValue());
                tProtocol.a((String) entry2.getValue());
            }
        }
        if (!(this.imageURIMapFormat == null || this.imageURIMapFormat == null)) {
            tProtocol.a(f2756j);
            tProtocol.a(this.imageURIMapFormat);
        }
        if (!(this.animatedImageURIMapFormat == null || this.animatedImageURIMapFormat == null)) {
            tProtocol.a(f2757k);
            tProtocol.a(this.animatedImageURIMapFormat);
        }
        if (!(this.renderAsSticker == null || this.renderAsSticker == null)) {
            tProtocol.a(f2758l);
            tProtocol.a(this.renderAsSticker.booleanValue());
        }
        if (!(this.miniPreview == null || this.miniPreview == null)) {
            tProtocol.a(f2759m);
            tProtocol.a(this.miniPreview);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3914a(1, f2747a);
    }

    public final String m3914a(int i, boolean z) {
        int i2;
        int i3 = 0;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ImageMetadata");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
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
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.height != null) {
            if (i2 == 0) {
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
            i2 = 0;
        }
        if (this.imageURIMap != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("imageURIMap");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.imageURIMap == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.imageURIMap, i + 1, z));
            }
            i2 = 0;
        }
        if (this.imageSource != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("imageSource");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.imageSource == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) ImageSource.f2761b.get(this.imageSource);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.imageSource);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
            i2 = 0;
        }
        if (this.rawImageURI != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("rawImageURI");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.rawImageURI == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.rawImageURI, i + 1, z));
            }
            i2 = 0;
        }
        if (this.rawImageURIFormat != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("rawImageURIFormat");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.rawImageURIFormat == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.rawImageURIFormat, i + 1, z));
            }
            i2 = 0;
        }
        if (this.animatedImageURIMap != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("animatedImageURIMap");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.animatedImageURIMap == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.animatedImageURIMap, i + 1, z));
            }
            i2 = 0;
        }
        if (this.imageURIMapFormat != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("imageURIMapFormat");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.imageURIMapFormat == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.imageURIMapFormat, i + 1, z));
            }
            i2 = 0;
        }
        if (this.animatedImageURIMapFormat != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("animatedImageURIMapFormat");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.animatedImageURIMapFormat == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.animatedImageURIMapFormat, i + 1, z));
            }
            i2 = 0;
        }
        if (this.renderAsSticker != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("renderAsSticker");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.renderAsSticker == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.renderAsSticker, i + 1, z));
            }
            i2 = 0;
        }
        if (this.miniPreview != null) {
            if (i2 == 0) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("miniPreview");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.miniPreview == null) {
                stringBuilder.append("null");
            } else {
                int min = Math.min(this.miniPreview.length, 128);
                while (i3 < min) {
                    if (i3 != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(Integer.toHexString(this.miniPreview[i3]).length() > 1 ? Integer.toHexString(this.miniPreview[i3]).substring(Integer.toHexString(this.miniPreview[i3]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.miniPreview[i3]).toUpperCase());
                    i3++;
                }
                if (this.miniPreview.length > 128) {
                    stringBuilder.append(" ...");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3912a() {
        if (this.imageSource != null && !ImageSource.f2760a.contains(this.imageSource)) {
            throw new TProtocolException("The field 'imageSource' has been assigned the invalid value " + this.imageSource);
        }
    }
}
