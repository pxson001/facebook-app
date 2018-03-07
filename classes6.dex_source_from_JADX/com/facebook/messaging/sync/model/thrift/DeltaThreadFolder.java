package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: tray_sticker_matches_shown */
public class DeltaThreadFolder implements TBase, Serializable, Cloneable {
    public static boolean f2653a = true;
    private static final TStruct f2654b = new TStruct("DeltaThreadFolder");
    private static final TField f2655c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2656d = new TField("folder", (byte) 8, (short) 2);
    public final Integer folder;
    public final ThreadKey threadKey;

    private DeltaThreadFolder(ThreadKey threadKey, Integer num) {
        this.threadKey = threadKey;
        this.folder = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadFolder)) {
            return false;
        }
        DeltaThreadFolder deltaThreadFolder = (DeltaThreadFolder) obj;
        boolean z = false;
        if (deltaThreadFolder != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaThreadFolder.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaThreadFolder.threadKey))) {
                if (this.folder != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaThreadFolder.folder != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.folder.equals(deltaThreadFolder.folder))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadFolder m3807b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        ThreadKey threadKey = null;
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 1:
                        if (f.b != (byte) 12) {
                            TProtocolUtil.m7816a(tProtocol, f.b);
                            break;
                        }
                        threadKey = ThreadKey.m3936b(tProtocol);
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
            DeltaThreadFolder deltaThreadFolder = new DeltaThreadFolder(threadKey, num);
            deltaThreadFolder.m3806a();
            return deltaThreadFolder;
        }
    }

    public final void m3809a(TProtocol tProtocol) {
        m3806a();
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2655c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.folder == null || this.folder == null)) {
            tProtocol.a(f2656d);
            tProtocol.a(this.folder.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3808a(1, f2653a);
    }

    public final String m3808a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadFolder");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj = 1;
        if (this.threadKey != null) {
            stringBuilder.append(a);
            stringBuilder.append("threadKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadKey, i + 1, z));
            }
            obj = null;
        }
        if (this.folder != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("folder");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.folder == null) {
                stringBuilder.append("null");
            } else {
                str2 = (String) ThreadFolder.f2810b.get(this.folder);
                if (str2 != null) {
                    stringBuilder.append(str2);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.folder);
                if (str2 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3806a() {
        if (this.folder != null && !ThreadFolder.f2809a.contains(this.folder)) {
            throw new TProtocolException("The field 'folder' has been assigned the invalid value " + this.folder);
        }
    }
}
