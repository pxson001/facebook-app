package com.facebook.orca.notify;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messengerwear.support.MessengerWearHelper;
import com.facebook.messengerwear.support.MessengerWearPrefKeys;
import javax.annotation.Nullable;

/* compiled from: new_user_id */
class ThreadSystemTrayNotificationManager$1 implements MessagingNotificationUtil$BitmapCallback {
    final /* synthetic */ boolean f6278a;
    final /* synthetic */ NewMessageNotification f6279b;
    final /* synthetic */ Builder f6280c;
    final /* synthetic */ WearableExtender f6281d;
    final /* synthetic */ DefaultMessagingNotificationHandler$10 f6282e;
    final /* synthetic */ ThreadSystemTrayNotificationManager f6283f;

    ThreadSystemTrayNotificationManager$1(ThreadSystemTrayNotificationManager threadSystemTrayNotificationManager, boolean z, NewMessageNotification newMessageNotification, Builder builder, WearableExtender wearableExtender, DefaultMessagingNotificationHandler$10 defaultMessagingNotificationHandler$10) {
        this.f6283f = threadSystemTrayNotificationManager;
        this.f6278a = z;
        this.f6279b = newMessageNotification;
        this.f6280c = builder;
        this.f6281d = wearableExtender;
        this.f6282e = defaultMessagingNotificationHandler$10;
    }

    public final void mo234a(CloseableReference<CloseableImage> closeableReference) {
        Bitmap bitmap = null;
        try {
            if (closeableReference.a() instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) closeableReference.a()).a();
            }
            m5966a(bitmap);
        } finally {
            closeableReference.close();
        }
    }

    public final void mo233a() {
        m5966a(null);
    }

    private void m5966a(@Nullable Bitmap bitmap) {
        if (!this.f6278a) {
            MessengerWearHelper messengerWearHelper = this.f6283f.v;
            boolean z = false;
            if (messengerWearHelper.c() && messengerWearHelper.c.a(MessengerWearPrefKeys.b, false)) {
                z = true;
            }
            if (z) {
                this.f6283f.a(this.f6279b, bitmap);
            }
        }
        this.f6283f.a(this.f6280c, this.f6279b, this.f6281d, bitmap);
        this.f6282e.m5918a(this.f6281d);
    }
}
