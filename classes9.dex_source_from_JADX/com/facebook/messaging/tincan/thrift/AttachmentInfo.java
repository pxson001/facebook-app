package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: click_log_in_dialog_cancel_button */
public class AttachmentInfo implements TBase, Serializable, Cloneable {
    public static boolean f18100a = true;
    private static final TStruct f18101b = new TStruct("AttachmentInfo");
    private static final TField f18102c = new TField("secret_key", (byte) 11, (short) 2);
    private static final TField f18103d = new TField("download_fbid", (byte) 10, (short) 4);
    private static final TField f18104e = new TField("download_size_bytes", (byte) 10, (short) 5);
    private static final TField f18105f = new TField("download_hash", (byte) 11, (short) 6);
    private static final TField f18106g = new TField("suggested_file_name", (byte) 11, (short) 8);
    private static final TField f18107h = new TField("file_mime_type", (byte) 11, (short) 9);
    private static final TField f18108i = new TField("thumbnail_data", (byte) 11, (short) 10);
    private static final TField f18109j = new TField("image_metadata", (byte) 12, (short) 11);
    private static final TField f18110k = new TField("video_metadata", (byte) 12, (short) 12);
    public final Long download_fbid;
    public final byte[] download_hash;
    public final Long download_size_bytes;
    public final String file_mime_type;
    public final ImageMetadata image_metadata;
    public final byte[] secret_key;
    public final String suggested_file_name;
    public final byte[] thumbnail_data;
    public final VideoMetadata video_metadata;

    public AttachmentInfo(byte[] bArr, Long l, Long l2, byte[] bArr2, String str, String str2, byte[] bArr3, ImageMetadata imageMetadata, VideoMetadata videoMetadata) {
        this.secret_key = bArr;
        this.download_fbid = l;
        this.download_size_bytes = l2;
        this.download_hash = bArr2;
        this.suggested_file_name = str;
        this.file_mime_type = str2;
        this.thumbnail_data = bArr3;
        this.image_metadata = imageMetadata;
        this.video_metadata = videoMetadata;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AttachmentInfo)) {
            return false;
        }
        AttachmentInfo attachmentInfo = (AttachmentInfo) obj;
        boolean z = false;
        if (attachmentInfo != null) {
            Object obj2;
            Object obj3 = this.secret_key != null ? 1 : null;
            if (attachmentInfo.secret_key != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.secret_key, attachmentInfo.secret_key))) {
                if (this.download_fbid != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (attachmentInfo.download_fbid != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.download_fbid.equals(attachmentInfo.download_fbid))) {
                    if (this.download_size_bytes != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (attachmentInfo.download_size_bytes != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.download_size_bytes.equals(attachmentInfo.download_size_bytes))) {
                        if (this.download_hash != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (attachmentInfo.download_hash != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.download_hash, attachmentInfo.download_hash))) {
                            if (this.suggested_file_name != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (attachmentInfo.suggested_file_name != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.suggested_file_name.equals(attachmentInfo.suggested_file_name))) {
                                if (this.file_mime_type != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (attachmentInfo.file_mime_type != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.file_mime_type.equals(attachmentInfo.file_mime_type))) {
                                    if (this.thumbnail_data != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (attachmentInfo.thumbnail_data != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !Arrays.equals(this.thumbnail_data, attachmentInfo.thumbnail_data))) {
                                        if (this.image_metadata != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (attachmentInfo.image_metadata != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.image_metadata.m18081a(attachmentInfo.image_metadata))) {
                                            if (this.video_metadata != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (attachmentInfo.video_metadata != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.video_metadata.m18187a(attachmentInfo.video_metadata))) {
                                                z = true;
                                            }
                                        }
                                    }
                                }
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

    public static AttachmentInfo m18072b(TProtocol tProtocol) {
        VideoMetadata videoMetadata = null;
        tProtocol.r();
        ImageMetadata imageMetadata = null;
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        byte[] bArr2 = null;
        Long l = null;
        Long l2 = null;
        byte[] bArr3 = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr3 = tProtocol.q();
                        break;
                    case (short) 4:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l2 = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 5:
                        if (f.b != (byte) 10) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        l = Long.valueOf(tProtocol.n());
                        break;
                    case (short) 6:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr2 = tProtocol.q();
                        break;
                    case (short) 8:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str2 = tProtocol.p();
                        break;
                    case (short) 9:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        str = tProtocol.p();
                        break;
                    case (short) 10:
                        if (f.b != (byte) 11) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        bArr = tProtocol.q();
                        break;
                    case (short) 11:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        imageMetadata = ImageMetadata.m18078b(tProtocol);
                        break;
                    case (short) 12:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.a(tProtocol, f.b);
                            break;
                        }
                        videoMetadata = VideoMetadata.m18184b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            return new AttachmentInfo(bArr3, l2, l, bArr2, str2, str, bArr, imageMetadata, videoMetadata);
        }
    }

    public final void m18074a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.secret_key != null) {
            tProtocol.a(f18102c);
            tProtocol.a(this.secret_key);
        }
        if (this.download_fbid != null) {
            tProtocol.a(f18103d);
            tProtocol.a(this.download_fbid.longValue());
        }
        if (this.download_size_bytes != null) {
            tProtocol.a(f18104e);
            tProtocol.a(this.download_size_bytes.longValue());
        }
        if (this.download_hash != null) {
            tProtocol.a(f18105f);
            tProtocol.a(this.download_hash);
        }
        if (this.suggested_file_name != null) {
            tProtocol.a(f18106g);
            tProtocol.a(this.suggested_file_name);
        }
        if (this.file_mime_type != null) {
            tProtocol.a(f18107h);
            tProtocol.a(this.file_mime_type);
        }
        if (this.thumbnail_data != null) {
            tProtocol.a(f18108i);
            tProtocol.a(this.thumbnail_data);
        }
        if (this.image_metadata != null) {
            tProtocol.a(f18109j);
            this.image_metadata.m18080a(tProtocol);
        }
        if (this.video_metadata != null) {
            tProtocol.a(f18110k);
            this.video_metadata.m18186a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18073a(1, f18100a);
    }

    public final String m18073a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("AttachmentInfo");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("secret_key");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.secret_key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.secret_key, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("download_fbid");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.download_fbid == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.download_fbid, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("download_size_bytes");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.download_size_bytes == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.download_size_bytes, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("download_hash");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.download_hash == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.download_hash, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("suggested_file_name");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.suggested_file_name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.suggested_file_name, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("file_mime_type");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.file_mime_type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.file_mime_type, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("thumbnail_data");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.thumbnail_data == null) {
            stringBuilder.append("null");
        } else {
            int min = Math.min(this.thumbnail_data.length, 128);
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(Integer.toHexString(this.thumbnail_data[i2]).length() > 1 ? Integer.toHexString(this.thumbnail_data[i2]).substring(Integer.toHexString(this.thumbnail_data[i2]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.thumbnail_data[i2]).toUpperCase());
            }
            if (this.thumbnail_data.length > 128) {
                stringBuilder.append(" ...");
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("image_metadata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.image_metadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.image_metadata, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("video_metadata");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.video_metadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.video_metadata, i + 1, z));
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
