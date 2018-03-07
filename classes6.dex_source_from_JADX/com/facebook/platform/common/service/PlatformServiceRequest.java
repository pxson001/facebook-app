package com.facebook.platform.common.service;

import android.os.Bundle;
import android.os.Message;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.platform.common.PlatformConstants;

/* compiled from: storyCacheIds */
public abstract class PlatformServiceRequest {
    public String f4080a;
    public String f4081b;
    private int f4082c;
    private int f4083d;
    public Message f4084e;

    protected abstract int mo296a();

    protected abstract boolean mo297a(Message message);

    public final String m5987b() {
        return this.f4080a;
    }

    public final String m5988c() {
        return this.f4081b;
    }

    public final Message m5989d() {
        return this.f4084e;
    }

    private void m5983b(Message message) {
        this.f4084e = message;
    }

    public final boolean m5986a(Message message, String str) {
        Bundle data = message.getData();
        this.f4081b = str;
        this.f4082c = message.arg1;
        if (PlatformConstants.f3998a.contains(Integer.valueOf(this.f4082c))) {
            this.f4083d = message.arg2;
            Object obj = data.get("com.facebook.platform.extra.APPLICATION_ID");
            if (obj instanceof String) {
                this.f4080a = (String) obj;
                if (!mo297a(message)) {
                    return false;
                }
                if (data.containsKey("com.facebook.platform.protocol.PROTOCOL_VALIDATE")) {
                    obj = data.get("com.facebook.platform.protocol.PROTOCOL_VALIDATE");
                    if (!(obj instanceof Boolean)) {
                        m5981a(message, "com.facebook.platform.protocol.PROTOCOL_VALIDATE", Boolean.class, obj);
                        return false;
                    } else if (((Boolean) obj).booleanValue()) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("com.facebook.platform.protocol.PROTOCOL_VALIDATED", true);
                        Message obtain = Message.obtain(null, mo296a());
                        obtain.arg1 = 20121101;
                        obtain.arg2 = message.arg2;
                        obtain.setData(bundle);
                        this.f4084e = obtain;
                        return false;
                    }
                }
                return true;
            }
            m5981a(message, "com.facebook.platform.extra.APPLICATION_ID", String.class, obj);
            return false;
        }
        m5982a(message, "Unknown protocol version in '%s': %d", "Message.arg1", Integer.valueOf(this.f4082c));
        return false;
    }

    private void m5982a(Message message, String str, Object... objArr) {
        String a = StringFormatUtil.a(str, objArr);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_TYPE", "ProtocolError");
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", a);
        Message obtain = Message.obtain(null, mo296a());
        obtain.arg1 = 20121101;
        obtain.arg2 = message.arg2;
        obtain.setData(bundle);
        this.f4084e = obtain;
    }

    private void m5981a(Message message, String str, Class<?> cls, Object obj) {
        if (obj == null) {
            m5982a(message, "Expected non-null '%s' extra, actual value was null.", str);
            return;
        }
        m5982a(message, "Expected '%s' extra to be type '%s', actual value was type '%s'.", str, cls.getSimpleName(), obj.getClass().getSimpleName());
    }
}
