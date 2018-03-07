package com.facebook.messaging.media.upload;

import com.facebook.messaging.media.upload.util.MediaUploadKey;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: launch_mode_extra */
class TwoPhaseSendHandler$2 implements Callable<List<MediaUploadKey>> {
    final /* synthetic */ String f12064a;
    final /* synthetic */ TwoPhaseSendHandler f12065b;

    TwoPhaseSendHandler$2(TwoPhaseSendHandler twoPhaseSendHandler, String str) {
        this.f12065b = twoPhaseSendHandler;
        this.f12064a = str;
    }

    public Object call() {
        this.f12065b.l.a(this.f12064a, Boolean.valueOf(false));
        return new CopyOnWriteArrayList();
    }
}
