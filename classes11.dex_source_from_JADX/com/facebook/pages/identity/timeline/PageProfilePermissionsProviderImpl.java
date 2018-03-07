package com.facebook.pages.identity.timeline;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.context.TimelinePageContext.PageProfilePermissionsProvider;
import javax.annotation.Nullable;

/* compiled from: page_identity_share_fail */
public class PageProfilePermissionsProviderImpl implements PageProfilePermissionsProvider {
    @Nullable
    public ProfilePermissions f4220a = null;
    private final Lazy<FbErrorReporter> f4221b;

    public PageProfilePermissionsProviderImpl(@Nullable ProfilePermissions profilePermissions, Lazy<FbErrorReporter> lazy) {
        this.f4220a = profilePermissions;
        this.f4221b = lazy;
    }

    @Nullable
    public final ProfilePermissions mo28a() {
        if (this.f4220a == null) {
            ((AbstractFbErrorReporter) this.f4221b.get()).b(getClass().getName(), "ProfilePermissions null when timeline is using it");
        }
        return this.f4220a;
    }
}
