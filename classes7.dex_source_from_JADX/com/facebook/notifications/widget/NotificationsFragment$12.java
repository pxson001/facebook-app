package com.facebook.notifications.widget;

import android.support.v4.app.LoaderManager;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.notifications.loader.NotificationsLoader;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$12 implements FutureCallback<OperationResult> {
    final /* synthetic */ NotificationsFragment f9042a;

    /* compiled from: method/mobile.zeroBalanceDetection */
    class C07231 implements RetryClickedListener {
        final /* synthetic */ NotificationsFragment$12 f9041a;

        C07231(NotificationsFragment$12 notificationsFragment$12) {
            this.f9041a = notificationsFragment$12;
        }

        public final void m10876a() {
            NotificationsFragment.aG(this.f9041a.f9042a);
        }
    }

    NotificationsFragment$12(NotificationsFragment notificationsFragment) {
        this.f9042a = notificationsFragment;
    }

    public void onSuccess(Object obj) {
        short s;
        OperationResult operationResult = (OperationResult) obj;
        this.f9042a.br = false;
        this.f9042a.bi.b();
        if (this.f9042a.n() != null && this.f9042a.n().v() > 0) {
            this.f9042a.n().b(this.f9042a.bi);
        }
        FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
        if (fetchGraphQLNotificationsResult != null) {
            NotificationStories notificationStories = fetchGraphQLNotificationsResult.a;
            if (notificationStories != null && (notificationStories.newStories == null || notificationStories.newStories.isEmpty())) {
                this.f9042a.bz = true;
            }
            if (fetchGraphQLNotificationsResult.freshness == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) {
                List a;
                if (this.f9042a.mx_()) {
                    LoaderManager E = this.f9042a.E();
                    if (E != null) {
                        ((NotificationsLoader) E.b(100)).y = notificationStories.newStories.size();
                    }
                }
                NotificationsFragment notificationsFragment = this.f9042a;
                if (notificationStories.a() != null) {
                    a = notificationStories.a();
                } else {
                    a = new ArrayList();
                }
                notificationsFragment.bF = a;
                NotificationsFragment.ao(this.f9042a);
                s = (short) 26;
            } else {
                s = (short) 27;
            }
        } else {
            s = (short) 2;
        }
        this.f9042a.aA.b(3473421, s);
    }

    public void onFailure(Throwable th) {
        this.f9042a.aA.b(3473421, (short) 3);
        this.f9042a.bz = true;
        this.f9042a.br = false;
        if (this.f9042a.z()) {
            this.f9042a.bi.a(this.f9042a.b(2131230811), new C07231(this));
        }
    }
}
