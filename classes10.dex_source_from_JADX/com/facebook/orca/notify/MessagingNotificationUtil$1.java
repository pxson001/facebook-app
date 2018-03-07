package com.facebook.orca.notify;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* compiled from: non_critical/ */
class MessagingNotificationUtil$1 extends BasePostprocessor {
    final /* synthetic */ Bitmap f6250a;
    final /* synthetic */ int f6251b;
    final /* synthetic */ MessagingNotificationUtil f6252c;

    MessagingNotificationUtil$1(MessagingNotificationUtil messagingNotificationUtil, Bitmap bitmap, int i) {
        this.f6252c = messagingNotificationUtil;
        this.f6250a = bitmap;
        this.f6251b = i;
    }

    public final void m5953a(Bitmap bitmap, Bitmap bitmap2) {
        MessagingNotificationUtil.a(this.f6252c, bitmap2, this.f6250a, bitmap, this.f6251b);
    }
}
