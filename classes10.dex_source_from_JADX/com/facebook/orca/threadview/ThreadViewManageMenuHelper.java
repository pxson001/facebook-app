package com.facebook.orca.threadview;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.review.util.ReviewGatekeepers;
import com.facebook.orca.notify.NotificationSettingsUtil;
import javax.inject.Inject;

/* compiled from: message has location share */
public class ThreadViewManageMenuHelper {
    public final NotificationSettingsUtil f7653a;
    public final ReviewGatekeepers f7654b;

    public static ThreadViewManageMenuHelper m7361a(InjectorLike injectorLike) {
        return new ThreadViewManageMenuHelper(NotificationSettingsUtil.b(injectorLike), new ReviewGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public ThreadViewManageMenuHelper(NotificationSettingsUtil notificationSettingsUtil, ReviewGatekeepers reviewGatekeepers) {
        this.f7653a = notificationSettingsUtil;
        this.f7654b = reviewGatekeepers;
    }
}
