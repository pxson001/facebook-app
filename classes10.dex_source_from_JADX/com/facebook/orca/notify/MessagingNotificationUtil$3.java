package com.facebook.orca.notify;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;

/* compiled from: non_critical/ */
class MessagingNotificationUtil$3 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    final /* synthetic */ MessagingNotificationUtil$BitmapCallback f6256a;
    final /* synthetic */ MessagingNotificationUtil f6257b;

    MessagingNotificationUtil$3(MessagingNotificationUtil messagingNotificationUtil, MessagingNotificationUtil$BitmapCallback messagingNotificationUtil$BitmapCallback) {
        this.f6257b = messagingNotificationUtil;
        this.f6256a = messagingNotificationUtil$BitmapCallback;
    }

    protected final void m5956e(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource != null) {
            CloseableReference closeableReference = (CloseableReference) dataSource.d();
            if (closeableReference == null || !(closeableReference.a() instanceof CloseableBitmap)) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                this.f6256a.mo233a();
                return;
            }
            this.f6256a.mo234a(closeableReference);
        }
    }

    protected final void m5957f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        this.f6256a.mo233a();
    }
}
