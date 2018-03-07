package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.content.SecurePendingIntent;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.notify.FriendInstallNotification;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$2 extends BaseBitmapDataSubscriber {
    final /* synthetic */ Intent f6198a;
    final /* synthetic */ FriendInstallNotification f6199b;
    final /* synthetic */ int f6200c;
    final /* synthetic */ DefaultMessagingNotificationHandler f6201d;

    DefaultMessagingNotificationHandler$2(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, Intent intent, FriendInstallNotification friendInstallNotification, int i) {
        this.f6201d = defaultMessagingNotificationHandler;
        this.f6198a = intent;
        this.f6199b = friendInstallNotification;
        this.f6200c = i;
    }

    protected final void m5920a(@Nullable Bitmap bitmap) {
        m5919b(bitmap);
    }

    protected final void m5921f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        m5919b(null);
    }

    private void m5919b(@Nullable Bitmap bitmap) {
        PendingIntent a = SecurePendingIntent.a(this.f6201d.b, 0, this.f6198a, 134217728);
        Builder a2 = new Builder(this.f6201d.b).a(this.f6199b.b).b(this.f6199b.c).e(this.f6199b.d).a(this.f6200c).a(new BigTextStyle().b(this.f6199b.c));
        a2.g = bitmap;
        a2 = a2;
        a2.d = a;
        this.f6201d.d.a(this.f6199b.a, 10003, a2.c(true).c());
        this.f6199b.f = true;
        this.f6199b.i();
    }
}
