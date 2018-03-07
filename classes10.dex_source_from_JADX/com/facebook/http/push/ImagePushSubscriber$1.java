package com.facebook.http.push;

import android.net.Uri;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;

/* compiled from: StorefrontCollection */
class ImagePushSubscriber$1 implements Runnable {
    final /* synthetic */ String f23389a;
    final /* synthetic */ String f23390b;
    final /* synthetic */ ImagePushSubscriber f23391c;

    ImagePushSubscriber$1(ImagePushSubscriber imagePushSubscriber, String str, String str2) {
        this.f23391c = imagePushSubscriber;
        this.f23389a = str;
        this.f23390b = str2;
    }

    public void run() {
        ImagePushLogger imagePushLogger = this.f23391c.c;
        String str = this.f23389a;
        String str2 = this.f23390b;
        HoneyClientEventFast a = imagePushLogger.f23388a.a("android_image_push_promise", false);
        if (a.a()) {
            a.a("tag", str);
            a.a("url", str2);
            a.b();
        }
        ImageRequestBuilder a2 = ImageRequestBuilder.a(Uri.parse(this.f23390b));
        a2.i = Priority.HIGH;
        this.f23391c.a.a(a2.m(), CallerContext.b(ImagePushSubscriber.class, this.f23389a), Priority.HIGH).a(new ImagePushSubscriber$ClosingSubscriber(), DirectExecutor.INSTANCE);
    }
}
