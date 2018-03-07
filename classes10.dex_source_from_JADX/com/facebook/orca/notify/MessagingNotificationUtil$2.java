package com.facebook.orca.notify;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.List;

/* compiled from: non_critical/ */
public class MessagingNotificationUtil$2 extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    final /* synthetic */ MessagingNotificationUtil$BitmapCallback f6253a;
    final /* synthetic */ int f6254b;
    final /* synthetic */ MessagingNotificationUtil f6255c;

    public MessagingNotificationUtil$2(MessagingNotificationUtil messagingNotificationUtil, MessagingNotificationUtil$BitmapCallback messagingNotificationUtil$BitmapCallback, int i) {
        this.f6255c = messagingNotificationUtil;
        this.f6253a = messagingNotificationUtil$BitmapCallback;
        this.f6254b = i;
    }

    protected final void m5954e(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
        if (dataSource == null || dataSource.d() == null) {
            this.f6253a.mo233a();
            return;
        }
        List<CloseableReference> list = (List) dataSource.d();
        try {
            if (list.isEmpty()) {
                this.f6253a.mo233a();
            } else {
                CloseableReference b = MessagingNotificationUtil.b(this.f6255c, list, this.f6254b);
                if (b != null) {
                    this.f6253a.mo234a(b);
                } else {
                    this.f6253a.mo233a();
                }
            }
            for (CloseableReference close : list) {
                close.close();
            }
        } catch (Throwable th) {
            for (CloseableReference close2 : list) {
                close2.close();
            }
        }
    }

    protected final void m5955f(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
        this.f6253a.mo233a();
    }
}
