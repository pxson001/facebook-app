package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: click_log_in_dialog_log_in_button */
public class ActionResultPayload implements TBase, Serializable, Cloneable {
    public static boolean f18097a = true;
    private static final TStruct f18098b = new TStruct("ActionResultPayload");
    private static final TField f18099c = new TField("action_result", (byte) 8, (short) 2);
    public final Integer action_result;

    private ActionResultPayload(Integer num) {
        this.action_result = num;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ActionResultPayload)) {
            return false;
        }
        ActionResultPayload actionResultPayload = (ActionResultPayload) obj;
        boolean z = false;
        if (actionResultPayload != null) {
            Object obj2 = this.action_result != null ? 1 : null;
            Object obj3;
            if (actionResultPayload.action_result != null) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if ((obj2 == null && r5 == null) || !(obj2 == null || r5 == null || !this.action_result.equals(actionResultPayload.action_result))) {
                z = true;
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static ActionResultPayload m18069b(TProtocol tProtocol) {
        Integer num = null;
        tProtocol.r();
        while (true) {
            TField f = tProtocol.f();
            if (f.b != (byte) 0) {
                switch (f.c) {
                    case (short) 2:
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
            ActionResultPayload actionResultPayload = new ActionResultPayload(num);
            actionResultPayload.m18068a();
            return actionResultPayload;
        }
    }

    public final void m18071a(TProtocol tProtocol) {
        m18068a();
        tProtocol.a();
        if (this.action_result != null) {
            tProtocol.a(f18099c);
            tProtocol.a(this.action_result.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18070a(1, f18097a);
    }

    public final String m18070a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ActionResultPayload");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("action_result");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.action_result == null) {
            stringBuilder.append("null");
        } else {
            str2 = (String) ActionResult.f18096b.get(this.action_result);
            if (str2 != null) {
                stringBuilder.append(str2);
                stringBuilder.append(" (");
            }
            stringBuilder.append(this.action_result);
            if (str2 != null) {
                stringBuilder.append(")");
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m18068a() {
        if (this.action_result != null && !ActionResult.f18095a.contains(this.action_result)) {
            throw new TProtocolException("The field 'action_result' has been assigned the invalid value " + this.action_result);
        }
    }
}
