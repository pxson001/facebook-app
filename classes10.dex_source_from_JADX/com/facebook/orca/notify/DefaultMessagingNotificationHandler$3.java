package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.content.SecurePendingIntent;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PaymentNotification.Type;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$3 extends BaseBitmapDataSubscriber {
    final /* synthetic */ PaymentNotification f6202a;
    final /* synthetic */ int f6203b;
    final /* synthetic */ DefaultMessagingNotificationHandler f6204c;

    DefaultMessagingNotificationHandler$3(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, PaymentNotification paymentNotification, int i) {
        this.f6204c = defaultMessagingNotificationHandler;
        this.f6202a = paymentNotification;
        this.f6203b = i;
    }

    protected final void m5923a(@Nullable Bitmap bitmap) {
        m5922b(bitmap);
    }

    protected final void m5924f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        m5922b(null);
    }

    private void m5922b(@Nullable Bitmap bitmap) {
        PaymentNotification paymentNotification = this.f6202a;
        Uri a = paymentNotification.b == Type.REQUEST ? PaymentRequestUtil.a(paymentNotification.i) ? PaymentNotification.a("requests", paymentNotification.a) : paymentNotification.d != null ? Uri.parse(MessengerLinks.z).buildUpon().appendPath(paymentNotification.d).build() : Uri.parse(MessengerLinks.x).buildUpon().appendPath(paymentNotification.c).build() : paymentNotification.b == Type.TRANSFER ? PaymentNotification.a("transfers", paymentNotification.a) : null;
        Uri uri = a;
        if (uri != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("from_notification", true);
            PendingIntent a2 = SecurePendingIntent.a(this.f6204c.b, 0, intent, 134217728);
            Builder a3 = new Builder(this.f6204c.b).a(this.f6202a.e).b(this.f6202a.f).e(this.f6202a.g).a(this.f6203b).a(new BigTextStyle().b(this.f6202a.f));
            a3.g = bitmap;
            a3 = a3;
            a3.d = a2;
            this.f6204c.d.a(this.f6202a.a, 10003, a3.c(true).c());
            this.f6202a.k = true;
            this.f6202a.i();
        }
    }
}
