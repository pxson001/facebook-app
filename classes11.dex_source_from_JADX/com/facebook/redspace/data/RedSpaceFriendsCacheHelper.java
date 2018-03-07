package com.facebook.redspace.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.C13951;
import com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpacePageInfoModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;

@ContextScoped
/* compiled from: ProfilePermissions null when timeline is using it */
public class RedSpaceFriendsCacheHelper {
    private static RedSpaceFriendsCacheHelper f11769d;
    private static final Object f11770e = new Object();
    @Inject
    public RedSpaceMemoryFriendsCache f11771a;
    @Inject
    public QeAccessor f11772b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f11773c = UltralightRuntime.b;

    private static RedSpaceFriendsCacheHelper m12207b(InjectorLike injectorLike) {
        RedSpaceFriendsCacheHelper redSpaceFriendsCacheHelper = new RedSpaceFriendsCacheHelper();
        RedSpaceMemoryFriendsCache a = RedSpaceMemoryFriendsCache.a(injectorLike);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 609);
        redSpaceFriendsCacheHelper.f11771a = a;
        redSpaceFriendsCacheHelper.f11772b = qeAccessor;
        redSpaceFriendsCacheHelper.f11773c = b;
        return redSpaceFriendsCacheHelper;
    }

    public final void m12209a(RedSpaceFriendsSection redSpaceFriendsSection, C13951 c13951) {
        m12208b();
        RedSpacePageInfoModel c = this.f11771a.c(redSpaceFriendsSection.getApiName());
        if (c == null) {
            RedSpaceFriendsFetcherHelper.m12229b(c13951.f11783c, c13951.f11781a, c13951.f11782b);
            return;
        }
        RedSpaceFriendsFetcherHelper.m12228a(c13951.f11783c, new RedSpaceFriendsFetchResult(this.f11771a.b(redSpaceFriendsSection.getApiName()), c, this.f11771a.d(redSpaceFriendsSection.getApiName()), this.f11771a.d), c13951.f11781a, c13951.f11782b);
    }

    public static RedSpaceFriendsCacheHelper m12206a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFriendsCacheHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11770e) {
                RedSpaceFriendsCacheHelper redSpaceFriendsCacheHelper;
                if (a2 != null) {
                    redSpaceFriendsCacheHelper = (RedSpaceFriendsCacheHelper) a2.a(f11770e);
                } else {
                    redSpaceFriendsCacheHelper = f11769d;
                }
                if (redSpaceFriendsCacheHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12207b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11770e, b3);
                        } else {
                            f11769d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFriendsCacheHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m12211a(RedSpaceFriendsSection... redSpaceFriendsSectionArr) {
        for (RedSpaceFriendsSection apiName : redSpaceFriendsSectionArr) {
            this.f11771a.a(apiName.getApiName());
        }
    }

    public final void m12210a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f11771a.a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection.getApiName());
    }

    @VisibleForTesting
    private long m12205a() {
        return ((long) this.f11772b.a(ExperimentsForRedSpaceExperimentsModule.f, 60)) * 60000;
    }

    private void m12208b() {
        if (((Clock) this.f11773c.get()).a() - this.f11771a.e(RedSpaceFriendsSection.TOP.getApiName()) > m12205a()) {
            m12211a(RedSpaceFriendsSection.TOP, RedSpaceFriendsSection.OTHERS);
        }
    }
}
