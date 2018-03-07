package com.facebook.redspace.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.StoriesModel.NodesModel;
import com.facebook.ultralight.Inject;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: ProfilePhotoDownloaded */
public class RedSpaceFeedProfileUnreadStoriesHelper {
    private static final Function<NodesModel, String> f11763d = new C13931();
    private static RedSpaceFeedProfileUnreadStoriesHelper f11764e;
    private static final Object f11765f = new Object();
    @Inject
    public RedSpaceOptimisticBadgeStore f11766a;
    @Inject
    public QeAccessor f11767b;
    private final Set<String> f11768c = new HashSet();

    /* compiled from: ProfilePhotoDownloaded */
    final class C13931 implements Function<NodesModel, String> {
        C13931() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            NodesModel nodesModel = (NodesModel) obj;
            if (nodesModel == null) {
                return null;
            }
            if (nodesModel.j() == null || nodesModel.j().j() == null) {
                return nodesModel.k();
            }
            return nodesModel.j().j();
        }
    }

    private static RedSpaceFeedProfileUnreadStoriesHelper m12203b(InjectorLike injectorLike) {
        RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper = new RedSpaceFeedProfileUnreadStoriesHelper();
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        redSpaceFeedProfileUnreadStoriesHelper.f11766a = RedSpaceOptimisticBadgeStore.a(injectorLike);
        redSpaceFeedProfileUnreadStoriesHelper.f11767b = qeAccessor;
        return redSpaceFeedProfileUnreadStoriesHelper;
    }

    public final int m12204a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        if (redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().m() == null || redSpaceFeedProfileFragmentModel.m().m().a() == null) {
            return 0;
        }
        if (redSpaceFeedProfileFragmentModel.m().m().a().j() || !this.f11767b.a(ExperimentsForRedSpaceExperimentsModule.c, true)) {
            return redSpaceFeedProfileFragmentModel.m().m().a().a();
        }
        this.f11768c.clear();
        this.f11768c.addAll(Collections2.a(redSpaceFeedProfileFragmentModel.m().m().j(), f11763d));
        return Sets.c(this.f11768c, this.f11766a.b).size();
    }

    public static RedSpaceFeedProfileUnreadStoriesHelper m12202a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFeedProfileUnreadStoriesHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11765f) {
                RedSpaceFeedProfileUnreadStoriesHelper redSpaceFeedProfileUnreadStoriesHelper;
                if (a2 != null) {
                    redSpaceFeedProfileUnreadStoriesHelper = (RedSpaceFeedProfileUnreadStoriesHelper) a2.a(f11765f);
                } else {
                    redSpaceFeedProfileUnreadStoriesHelper = f11764e;
                }
                if (redSpaceFeedProfileUnreadStoriesHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12203b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11765f, b3);
                        } else {
                            f11764e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFeedProfileUnreadStoriesHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
