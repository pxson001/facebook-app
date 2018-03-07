package com.facebook.messaging.media.photoquality;

import com.facebook.messaging.model.threadkey.ThreadKey;
import java.util.concurrent.Callable;

/* compiled from: logging_tag */
class PhotoQualityServiceHandler$2 implements Callable<PhotoQualityQueryResult> {
    final /* synthetic */ ThreadKey f11794a;
    final /* synthetic */ PhotoQualityServiceHandler f11795b;

    PhotoQualityServiceHandler$2(PhotoQualityServiceHandler photoQualityServiceHandler, ThreadKey threadKey) {
        this.f11795b = photoQualityServiceHandler;
        this.f11794a = threadKey;
    }

    public Object call() {
        return (PhotoQualityQueryResult) this.f11795b.b.a(this.f11795b.g, Long.valueOf(this.f11794a.i()));
    }
}
