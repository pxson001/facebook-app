package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.ModuleInfo;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.logging.analytics.PageViewReferrerUtils;
import com.facebook.pages.identity.fragments.about.PageAboutFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: pages_navigation_source */
public class PageIdentityFragmentFactory implements IFragmentFactory {
    private final PageViewReferrerUtils f3958a;
    private final AdminedPagesRamCache f3959b;
    private final PagesExperimentUtils f3960c;

    @Inject
    public PageIdentityFragmentFactory(PageViewReferrerUtils pageViewReferrerUtils, AdminedPagesRamCache adminedPagesRamCache, PagesExperimentUtils pagesExperimentUtils) {
        this.f3958a = pageViewReferrerUtils;
        this.f3959b = adminedPagesRamCache;
        this.f3960c = pagesExperimentUtils;
    }

    public final Fragment m4899a(Intent intent) {
        long j = intent.getExtras().getLong("com.facebook.katana.profile.id", -1);
        Preconditions.checkArgument(j != -1);
        Bundle extras = intent.getExtras();
        Fragment pageIdentityFragment = (this.f3959b.b(String.valueOf(j)) != null || extras.getBoolean("extra_is_admin")) ? new PageIdentityFragment() : this.f3960c.e() ? new PagesSurfaceFragment() : new PageAboutFragment();
        if (!extras.containsKey("page_view_referrer")) {
            PageViewReferrer pageViewReferrer;
            String str = "page_view_referrer";
            ModuleInfo c = this.f3958a.b.c();
            if (c == null || c.a == null || !PageViewReferrerUtils.a.containsKey(c.a)) {
                pageViewReferrer = PageViewReferrer.UNKNOWN;
            } else {
                pageViewReferrer = (PageViewReferrer) PageViewReferrerUtils.a.get(c.a);
            }
            extras.putSerializable(str, pageViewReferrer);
        }
        extras.putParcelable("page_fragment_uuid", new ParcelUuid(SafeUUIDGenerator.a()));
        pageIdentityFragment.g(extras);
        return pageIdentityFragment;
    }
}
