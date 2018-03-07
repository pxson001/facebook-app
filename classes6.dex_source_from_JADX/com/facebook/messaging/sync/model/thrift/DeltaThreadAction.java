package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: trimmedvideo */
public class DeltaThreadAction implements TBase, Serializable, Cloneable {
    public static boolean f2646a = true;
    private static final TStruct f2647b = new TStruct("DeltaThreadAction");
    private static final TField f2648c = new TField("threadKey", (byte) 12, (short) 1);
    private static final TField f2649d = new TField("action", (byte) 8, (short) 2);
    public final Integer action;
    public final ThreadKey threadKey;

    private DeltaThreadAction(ThreadKey threadKey, Integer num) {
        this.threadKey = threadKey;
        this.action = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeltaThreadAction)) {
            return false;
        }
        DeltaThreadAction deltaThreadAction = (DeltaThreadAction) obj;
        boolean z = false;
        if (deltaThreadAction != null) {
            Object obj2;
            Object obj3 = this.threadKey != null ? 1 : null;
            if (deltaThreadAction.threadKey != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadKey.m3939a(deltaThreadAction.threadKey))) {
                if (this.action != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deltaThreadAction.action != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.action.equals(deltaThreadAction.action))) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaThreadAction m3800b(TProtocol tProtocol) {
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
            DeltaThreadAction deltaThreadAction = new DeltaThreadAction(threadKey, num);
            deltaThreadAction.m3799a();
            return deltaThreadAction;
        }
    }

    public final void m3802a(TProtocol tProtocol) {
        m3799a();
        tProtocol.a();
        if (!(this.threadKey == null || this.threadKey == null)) {
            tProtocol.a(f2648c);
            this.threadKey.m3938a(tProtocol);
        }
        if (!(this.action == null || this.action == null)) {
            tProtocol.a(f2649d);
            tProtocol.a(this.action.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3801a(1, f2646a);
    }

    public final String m3801a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaThreadAction");
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
        if (this.action != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("action");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.action == null) {
                stringBuilder.append("null");
            } else {
                str2 = (String) ThreadAction.f2808b.get(this.action);
                if (str2 != null) {
                    stringBuilder.append(str2);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.action);
                if (str2 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m3799a() {
        if (this.action != null && !ThreadAction.f2807a.contains(this.action)) {
            throw new TProtocolException("The field 'action' has been assigned the invalid value " + this.action);
        }
    }
}
