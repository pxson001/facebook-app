package com.facebook.orca.notify;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.AlertDisposition;
import javax.annotation.Nullable;

/* compiled from: not recognized */
public class DefaultMessagingNotificationHandler$9 extends BaseBitmapDataSubscriber {
    final /* synthetic */ ThreadKey f6222a;
    final /* synthetic */ String f6223b;
    final /* synthetic */ String f6224c;
    final /* synthetic */ int f6225d;
    final /* synthetic */ DefaultMessagingNotificationHandler f6226e;

    public DefaultMessagingNotificationHandler$9(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, ThreadKey threadKey, String str, String str2, int i) {
        this.f6226e = defaultMessagingNotificationHandler;
        this.f6222a = threadKey;
        this.f6223b = str;
        this.f6224c = str2;
        this.f6225d = i;
    }

    protected final void m5943a(@Nullable Bitmap bitmap) {
        m5942b(bitmap);
    }

    protected final void m5944f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        m5942b(null);
    }

    private void m5942b(@Nullable Bitmap bitmap) {
        PendingIntent b = this.f6226e.b(this.f6222a, null);
        Builder a = new Builder(this.f6226e.b).a(this.f6223b).b(this.f6224c).e(this.f6224c).a(this.f6225d).a(new BigTextStyle().b(this.f6224c));
        a.d = b;
        Builder c = a.c(true);
        if (bitmap != null) {
            c.g = bitmap;
        }
        this.f6226e.f.a(c, new AlertDisposition(), null, this.f6222a);
        this.f6226e.d.a(this.f6222a.toString(), 10020, c.c());
    }
}
