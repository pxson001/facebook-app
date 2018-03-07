package com.facebook.orca.notify;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.notify.IncomingCallNotification;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$7 extends BaseBitmapDataSubscriber {
    final /* synthetic */ IncomingCallNotification f6215a;
    final /* synthetic */ long f6216b;
    final /* synthetic */ DefaultMessagingNotificationHandler f6217c;

    DefaultMessagingNotificationHandler$7(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, IncomingCallNotification incomingCallNotification, long j) {
        this.f6217c = defaultMessagingNotificationHandler;
        this.f6215a = incomingCallNotification;
        this.f6216b = j;
    }

    protected final void m5937a(@Nullable Bitmap bitmap) {
        m5936b(bitmap);
    }

    protected final void m5938f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        m5936b(null);
    }

    private void m5936b(@Nullable Bitmap bitmap) {
        DefaultMessagingNotificationHandler.a(this.f6217c, bitmap, this.f6215a, this.f6216b);
    }
}
