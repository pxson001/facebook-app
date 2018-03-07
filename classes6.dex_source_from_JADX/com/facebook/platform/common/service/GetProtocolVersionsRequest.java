package com.facebook.platform.common.service;

import android.os.Message;

/* compiled from: stories-live(stories-topic(%s)) */
public class GetProtocolVersionsRequest extends PlatformServiceRequest {
    protected final int mo296a() {
        return 65539;
    }

    protected final boolean mo297a(Message message) {
        return true;
    }

    public static Message m5993b(Message message) {
        Message obtain = Message.obtain(message);
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.what = 65539;
        return obtain;
    }
}
