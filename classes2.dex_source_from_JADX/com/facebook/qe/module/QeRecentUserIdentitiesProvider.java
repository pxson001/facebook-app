package com.facebook.qe.module;

import com.facebook.abtest.qe.log.RecentUIDsUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: unsupported encoding */
public class QeRecentUserIdentitiesProvider {
    public final RecentUIDsUtil f1854a;

    public static QeRecentUserIdentitiesProvider m3748b(InjectorLike injectorLike) {
        return new QeRecentUserIdentitiesProvider(RecentUIDsUtil.m3749a(injectorLike));
    }

    @Inject
    public QeRecentUserIdentitiesProvider(RecentUIDsUtil recentUIDsUtil) {
        this.f1854a = recentUIDsUtil;
    }
}
