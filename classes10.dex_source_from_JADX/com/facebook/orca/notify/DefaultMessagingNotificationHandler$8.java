package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.config.application.Product;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.AlertDisposition;
import com.facebook.messaging.notify.CalleeReadyNotification;
import javax.annotation.Nullable;

/* compiled from: not recognized */
class DefaultMessagingNotificationHandler$8 extends BaseBitmapDataSubscriber {
    final /* synthetic */ CalleeReadyNotification f6218a;
    final /* synthetic */ ThreadKey f6219b;
    final /* synthetic */ long f6220c;
    final /* synthetic */ DefaultMessagingNotificationHandler f6221d;

    DefaultMessagingNotificationHandler$8(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, CalleeReadyNotification calleeReadyNotification, ThreadKey threadKey, long j) {
        this.f6221d = defaultMessagingNotificationHandler;
        this.f6218a = calleeReadyNotification;
        this.f6219b = threadKey;
        this.f6220c = j;
    }

    protected final void m5940a(@Nullable Bitmap bitmap) {
        m5939b(bitmap);
    }

    protected final void m5941f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        m5939b(null);
    }

    private void m5939b(@Nullable Bitmap bitmap) {
        int i;
        int i2 = VERSION.SDK_INT > 19 ? 2130844003 : 2130843998;
        if (this.f6218a.d) {
            i = 2130844023;
        } else {
            i = i2;
        }
        PendingIntent a = this.f6221d.a(this.f6219b, this.f6220c, 0, null);
        PendingIntent a2 = this.f6221d.a(this.f6220c, this.f6218a.f);
        PendingIntent a3 = this.f6221d.a(this.f6220c, this.f6218a.d, this.f6218a.f);
        Builder a4 = new Builder(this.f6221d.b).a(this.f6218a.a).b(this.f6218a.b).a(i);
        a4.d = a3;
        Builder b = a4.b(a2);
        b.j = 2;
        b = b.a(this.f6218a.e);
        b.y = this.f6221d.b.getResources().getColor(2131362502);
        Builder c = b.c(true);
        if (bitmap != null) {
            c.g = bitmap;
        }
        if (this.f6221d.B.j == Product.MESSENGER) {
            c.a(AppGlyphResolver.a(), this.f6221d.b.getString(2131232104), a);
            c.a(i, this.f6221d.b.getString(2131232043), a3);
        }
        DefaultMessagingNotificationHandler defaultMessagingNotificationHandler = this.f6221d;
        this.f6221d.f.a(c, new AlertDisposition(), null, this.f6219b, new Uri.Builder().scheme("android.resource").authority(defaultMessagingNotificationHandler.c.getResourcePackageName(2131165304)).appendPath(defaultMessagingNotificationHandler.c.getResourceTypeName(2131165304)).appendPath(defaultMessagingNotificationHandler.c.getResourceEntryName(2131165304)).build());
        this.f6221d.d.a(this.f6218a.c, 10025, c.c());
        this.f6218a.i();
    }
}
