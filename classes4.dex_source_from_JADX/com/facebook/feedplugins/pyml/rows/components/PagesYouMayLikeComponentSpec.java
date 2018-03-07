package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: old_api_psr */
public class PagesYouMayLikeComponentSpec<E extends HasFeedListType & HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext & HasIsAsync> {
    private static PagesYouMayLikeComponentSpec f6278b;
    private static final Object f6279c = new Object();
    public final PagesYouMayLikeComponentPagerBinderProvider f6280a;

    private static PagesYouMayLikeComponentSpec m6734b(InjectorLike injectorLike) {
        return new PagesYouMayLikeComponentSpec((PagesYouMayLikeComponentPagerBinderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesYouMayLikeComponentPagerBinderProvider.class));
    }

    @Inject
    public PagesYouMayLikeComponentSpec(PagesYouMayLikeComponentPagerBinderProvider pagesYouMayLikeComponentPagerBinderProvider) {
        this.f6280a = pagesYouMayLikeComponentPagerBinderProvider;
    }

    public static PagesYouMayLikeComponentSpec m6733a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6279c) {
                PagesYouMayLikeComponentSpec pagesYouMayLikeComponentSpec;
                if (a2 != null) {
                    pagesYouMayLikeComponentSpec = (PagesYouMayLikeComponentSpec) a2.a(f6279c);
                } else {
                    pagesYouMayLikeComponentSpec = f6278b;
                }
                if (pagesYouMayLikeComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6734b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6279c, b3);
                        } else {
                            f6278b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
