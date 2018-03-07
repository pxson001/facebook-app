package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.content.SecurePendingIntent;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.neue.threadsettings.extras.MessengerThreadSettingsExtras.ThreadSettingsType;
import com.facebook.messaging.notify.JoinRequestNotification;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$4 implements MessagingNotificationUtil$BitmapCallback {
    final /* synthetic */ ThreadKey f6205a;
    final /* synthetic */ JoinRequestNotification f6206b;
    final /* synthetic */ DefaultMessagingNotificationHandler f6207c;

    DefaultMessagingNotificationHandler$4(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, ThreadKey threadKey, JoinRequestNotification joinRequestNotification) {
        this.f6207c = defaultMessagingNotificationHandler;
        this.f6205a = threadKey;
        this.f6206b = joinRequestNotification;
    }

    public final void mo234a(CloseableReference<CloseableImage> closeableReference) {
        try {
            Bitmap a;
            CloseableImage closeableImage = (CloseableImage) closeableReference.a();
            if (closeableImage instanceof CloseableBitmap) {
                a = ((CloseableBitmap) closeableImage).a();
            } else {
                a = null;
            }
            m5927a(a);
        } finally {
            CloseableReference.c(closeableReference);
        }
    }

    public final void mo233a() {
        m5927a(null);
    }

    private void m5927a(@Nullable Bitmap bitmap) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f6207c.e;
        int i = 2130843533;
        PendingIntent a = SecurePendingIntent.a(this.f6207c.b, 0, new Intent().setFlags(67108864).setAction(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.B)).putExtra("thread_key_for_settings", this.f6205a).putExtra("thread_settings_type_for_settings", ThreadSettingsType.GROUP).putExtra("start_fragment", 1001), 134217728);
        PendingIntent d = DefaultMessagingNotificationHandler.d(this.f6207c, "join_requests");
        Builder a2 = new Builder(this.f6207c.b).a(this.f6206b.a).b(this.f6206b.b).a(i);
        a2.d = a;
        a2 = a2.b(d).c(true);
        if (bitmap != null) {
            a2.g = bitmap;
        }
        this.f6207c.f.a(a2);
        this.f6207c.d.a(null, 10031, a2.c());
        this.f6206b.d = true;
        this.f6206b.i();
    }
}
