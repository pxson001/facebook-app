package com.facebook.platform.common.service;

import android.os.Message;

/* compiled from: stories-topic(%s) */
public class GetLikeStateServiceRequest extends PlatformServiceRequest {
    protected final int mo296a() {
        return 65543;
    }

    protected final boolean mo297a(Message message) {
        return true;
    }

    public static Message m5990b(Message message) {
        Message obtain = Message.obtain(message);
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.what = 65543;
        return obtain;
    }
}
