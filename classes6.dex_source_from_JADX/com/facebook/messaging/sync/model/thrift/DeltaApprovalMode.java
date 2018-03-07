package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: ui_thread_waiting_time */
public class DeltaApprovalMode implements TBase, Serializable, Cloneable {
    public static boolean f2502a = true;
    private static final TStruct f2503b = new TStruct("DeltaApprovalMode");
    private static final TField f2504c = new TField("messageMetadata", (byte) 12, (short) 1);
    private static final TField f2505d = new TField("mode", (byte) 8, (short) 2);
    public final MessageMetadata messageMetadata;
    public final Integer mode;

    private DeltaApprovalMode(MessageMetadata messageMetadata, Integer num) {
        this.messageMetadata = messageMetadata;
        this.mode = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaApprovalMode)) {
            return false;
        }
        DeltaApprovalMode deltaApprovalMode = (DeltaApprovalMode) obj;
        boolean z = false;
        if (deltaApprovalMode != null) {
            Object obj2;
            Object obj3 = this.messageMetadata != null ? 1 : null;
            if (deltaApprovalMode.messageMetadata != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageMetadata.m3920a(deltaApprovalMode.messageMetadata))) {
                if (this.mode != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaApprovalMode.mode != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.mode.equals(deltaApprovalMode.mode))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaApprovalMode m3697b(TProtocol tProtocol) {
        Integer num = null;
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
            DeltaApprovalMode deltaApprovalMode = new DeltaApprovalMode(messageMetadata, num);
            deltaApprovalMode.m3696a();
            return deltaApprovalMode;
        }
    }

    public final void m3699a(TProtocol tProtocol) {
        m3696a();
        tProtocol.a();
        if (this.messageMetadata != null) {
            tProtocol.a(f2504c);
            this.messageMetadata.m3919a(tProtocol);
        }
        if (this.mode != null) {
            tProtocol.a(f2505d);
            tProtocol.a(this.mode.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3698a(1, f2502a);
    }

    public final String m3698a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaApprovalMode");
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
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("mode");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.mode == null) {
            stringBuilder.append("null");
        } else {
            str2 = (String) ApprovalMode.f2455b.get(this.mode);
            if (str2 != null) {
                stringBuilder.append(str2);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.mode);
            if (str2 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3696a() {
        if (this.messageMetadata == null) {
            throw new TProtocolException(6, "Required field 'messageMetadata' was not present! Struct: " + toString());
        } else if (this.mode == null) {
            throw new TProtocolException(6, "Required field 'mode' was not present! Struct: " + toString());
        } else if (this.mode != null && !ApprovalMode.f2454a.contains(this.mode)) {
            throw new TProtocolException("The field 'mode' has been assigned the invalid value " + this.mode);
        }
    }
}
