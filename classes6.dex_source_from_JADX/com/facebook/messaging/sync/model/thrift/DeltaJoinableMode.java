package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: uKernel */
public class DeltaJoinableMode implements TBase, Serializable, Cloneable {
    public static boolean f2545a = true;
    private static final TStruct f2546b = new TStruct("DeltaJoinableMode");
    private static final TField f2547c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2548d = new TField("link", (byte) 11, (short) 2);
    private static final TField f2549e = new TField("mode", (byte) 8, (short) 3);
    public final String link;
    public final MessageMetadata messageMetadata;
    public final Integer mode;

    private DeltaJoinableMode(MessageMetadata messageMetadata, String str, Integer num) {
        this.messageMetadata = messageMetadata;
        this.link = str;
        this.mode = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaJoinableMode)) {
            return false;
        }
        DeltaJoinableMode deltaJoinableMode = (DeltaJoinableMode) obj;
        boolean z = false;
        if (deltaJoinableMode != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaJoinableMode.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaJoinableMode.messageMetadata))) {
                if (this.link != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaJoinableMode.link != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.link.equals(deltaJoinableMode.link))) {
                    if (this.mode != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deltaJoinableMode.mode != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.mode.equals(deltaJoinableMode.mode))) {
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

    public static DeltaJoinableMode m3726b(TProtocol tProtocol) {
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
            DeltaJoinableMode deltaJoinableMode = new DeltaJoinableMode(messageMetadata, str, num);
            deltaJoinableMode.m3725a();
            return deltaJoinableMode;
        }
    }

    public final void m3728a(TProtocol tProtocol) {
        m3725a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2547c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (!(this.link == null || this.link == null)) {
            tProtocol.a(f2548d);
            tProtocol.a(this.link);
        }
        if (!(this.mode == null || this.mode == null)) {
            tProtocol.a(f2549e);
            tProtocol.a(this.mode.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3727a(1, f2545a);
    }

    public final String m3727a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaJoinableMode");
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
        if (this.link != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("link");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.link == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.link, i + 1, z));
            }
        }
        if (this.mode != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("mode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.mode == null) {
                stringBuilder.append("null");
            } else {
                str2 = (String) JoinableMode.f2763b.get(this.mode);
                if (str2 != null) {
                    stringBuilder.append(str2);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.mode);
                if (str2 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3725a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.mode != null && !JoinableMode.f2762a.contains(this.mode)) {
            throw new TProtocolException("The field 'mode' has been assigned the invalid value " + this.mode);
        }
    }
}
