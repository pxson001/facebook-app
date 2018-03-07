package com.facebook.orca.notify;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threads.ThreadCustomization;

/* compiled from: new_user_id */
class ThreadSystemTrayNotificationManager$2 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    final /* synthetic */ Builder f6284a;
    final /* synthetic */ CharSequence f6285b;
    final /* synthetic */ WearableExtender f6286c;
    final /* synthetic */ Message f6287d;
    final /* synthetic */ ThreadCustomization f6288e;
    final /* synthetic */ int f6289f;
    final /* synthetic */ ThreadSystemTrayMessageList f6290g;
    final /* synthetic */ ThreadSystemTrayNotificationManager f6291h;

    ThreadSystemTrayNotificationManager$2(ThreadSystemTrayNotificationManager threadSystemTrayNotificationManager, Builder builder, CharSequence charSequence, WearableExtender wearableExtender, Message message, ThreadCustomization threadCustomization, int i, ThreadSystemTrayMessageList threadSystemTrayMessageList) {
        this.f6291h = threadSystemTrayNotificationManager;
        this.f6284a = builder;
        this.f6285b = charSequence;
        this.f6286c = wearableExtender;
        this.f6287d = message;
        this.f6288e = threadCustomization;
        this.f6289f = i;
        this.f6290g = threadSystemTrayMessageList;
    }

    protected final void m5969e(DataSource<CloseableReference<CloseableImage>> dataSource) {
        CloseableReference closeableReference = (CloseableReference) dataSource.d();
        if (closeableReference == null || !(closeableReference.a() instanceof CloseableBitmap)) {
            this.f6284a.a(new BigTextStyle().b(this.f6285b));
        } else {
            try {
                Bitmap a = ((CloseableBitmap) closeableReference.a()).a();
                this.f6284a.a(new BigPictureStyle().a(a).a(this.f6285b));
                this.f6286c.a(ThreadSystemTrayNotificationManager.a(this.f6291h, a));
            } finally {
                closeableReference.close();
            }
        }
        ThreadSystemTrayNotificationManager.a(this.f6291h, this.f6287d, this.f6288e, this.f6289f, this.f6290g, this.f6286c);
    }

    protected final void m5970f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        this.f6284a.a(new BigTextStyle().b(this.f6285b));
        ThreadSystemTrayNotificationManager.a(this.f6291h, this.f6287d, this.f6288e, this.f6289f, this.f6290g, this.f6286c);
    }
}
