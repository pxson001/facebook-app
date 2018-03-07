package com.facebook.orca.notify;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.notify.IncomingCallNotification;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$6 implements MessagingNotificationUtil$BitmapCallback {
    final /* synthetic */ IncomingCallNotification f6212a;
    final /* synthetic */ long f6213b;
    final /* synthetic */ DefaultMessagingNotificationHandler f6214c;

    DefaultMessagingNotificationHandler$6(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, IncomingCallNotification incomingCallNotification, long j) {
        this.f6214c = defaultMessagingNotificationHandler;
        this.f6212a = incomingCallNotification;
        this.f6213b = j;
    }

    public final void mo234a(CloseableReference<CloseableImage> closeableReference) {
        Bitmap bitmap = null;
        try {
            if (closeableReference.a() instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) closeableReference.a()).a();
            }
            m5933a(bitmap);
        } finally {
            closeableReference.close();
        }
    }

    public final void mo233a() {
        m5933a(null);
    }

    private void m5933a(@Nullable Bitmap bitmap) {
        DefaultMessagingNotificationHandler.a(this.f6214c, bitmap, this.f6212a, this.f6213b);
    }
}
