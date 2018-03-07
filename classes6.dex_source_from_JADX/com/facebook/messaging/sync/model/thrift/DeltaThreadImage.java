package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: travel_class */
public class DeltaThreadImage implements TBase, Serializable, Cloneable {
    public static boolean f2657a = true;
    private static final TStruct f2658b = new TStruct("DeltaThreadImage");
    private static final TField f2659c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2660d = new TField("image", (byte) 12, (short) 2);
    public final Attachment image;
    public final MessageMetadata messageMetadata;

    private DeltaThreadImage(MessageMetadata messageMetadata, Attachment attachment) {
        this.messageMetadata = messageMetadata;
        this.image = attachment;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadImage)) {
            return false;
        }
        DeltaThreadImage deltaThreadImage = (DeltaThreadImage) obj;
        boolean z = false;
        if (deltaThreadImage != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaThreadImage.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaThreadImage.messageMetadata))) {
                if (this.image != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaThreadImage.image != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.image.m3674a(deltaThreadImage.image))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadImage m3811b(TProtocol tProtocol) {
        Attachment attachment = null;
        tProtocol.r();
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
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        attachment = Attachment.m3671b(tProtocol);
                        break;
                    default:
                        TProtocolUtil.m7816a(tProtocol, f.b);
                        break;
                }
            }
            tProtocol.e();
            DeltaThreadImage deltaThreadImage = new DeltaThreadImage(messageMetadata, attachment);
            deltaThreadImage.m3810a();
            return deltaThreadImage;
        }
    }

    public final void m3813a(TProtocol tProtocol) {
        m3810a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2659c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.image == null || this.image == null)) {
            tProtocol.a(f2660d);
            this.image.m3673a(tProtocol);
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3812a(1, f2657a);
    }

    public final String m3812a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadImage");
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
        if (this.image != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("image");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.image == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.image, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3810a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        }
    }
}
