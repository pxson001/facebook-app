package com.facebook.orca.notify;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.ephemeral.EphemeralProgressUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.NewEphemeralMessageNotification;
import javax.annotation.Nullable;

/* compiled from: nodeId */
public class EphemeralMessageNotificationManager$2 implements MessagingNotificationUtil$BitmapCallback {
    final /* synthetic */ Builder f6231a;
    final /* synthetic */ NewEphemeralMessageNotification f6232b;
    final /* synthetic */ ThreadKey f6233c;
    final /* synthetic */ EphemeralMessageNotificationManager f6234d;

    public EphemeralMessageNotificationManager$2(EphemeralMessageNotificationManager ephemeralMessageNotificationManager, Builder builder, NewEphemeralMessageNotification newEphemeralMessageNotification, ThreadKey threadKey) {
        this.f6234d = ephemeralMessageNotificationManager;
        this.f6231a = builder;
        this.f6232b = newEphemeralMessageNotification;
        this.f6233c = threadKey;
    }

    public final void mo234a(CloseableReference<CloseableImage> closeableReference) {
        Bitmap bitmap = null;
        try {
            if (closeableReference.a() instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) closeableReference.a()).a();
            }
            m5945a(bitmap);
        } finally {
            closeableReference.close();
        }
    }

    public final void mo233a() {
        m5945a(null);
    }

    private void m5945a(@Nullable Bitmap bitmap) {
        EphemeralMessageNotificationManager ephemeralMessageNotificationManager;
        this.f6231a.g = bitmap;
        Message message = this.f6232b.c;
        int a = this.f6234d.b.a(message);
        if (a == 0) {
            this.f6234d.a(this.f6233c);
            ephemeralMessageNotificationManager = this.f6234d;
            Builder builder = this.f6231a;
            String a2 = ephemeralMessageNotificationManager.d.a(message.e, message.b);
            builder.b(ephemeralMessageNotificationManager.f.getString(2131231885, new Object[]{a2}));
            builder.a(0, 0, false);
        } else {
            this.f6231a.a(message.J.intValue(), a, false);
            EphemeralMessageNotificationManager.a(this.f6234d, this.f6232b, this.f6233c, this.f6231a, EphemeralProgressUtil.b(message));
        }
        ephemeralMessageNotificationManager = this.f6234d;
        ThreadKey threadKey = this.f6233c;
        ephemeralMessageNotificationManager.e.a(threadKey.toString(), 10023, this.f6231a.c());
    }
}
