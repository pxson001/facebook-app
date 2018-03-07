package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feedplugins.pyml.rows.contentbased.ContentBasedPagesYouMayLikePartDefinition;
import com.facebook.feedplugins.pyml.rows.contentbased.PymlFallbackPagePartDefinition;
import com.facebook.feedplugins.pyml.rows.contentbased.PymlPhotoPagePartDefinition;
import com.facebook.feedplugins.pyml.rows.contentbased.PymlSharePagePartDefinition;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.PymlSeeAllPagePartDefinition;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ko */
public class PagesYouMayLikeDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static PagesYouMayLikeDeclaration f18345e;
    private static final Object f18346f = new Object();
    private final Lazy<PagesYouMayLikePartDefinition<FeedEnvironment>> f18347a;
    private final Lazy<PagesYouMayLikeSmallFormatPartDefinition<FeedEnvironment>> f18348b;
    private final Provider<TriState> f18349c;
    private final Lazy<ContentBasedPagesYouMayLikePartDefinition> f18350d;

    private static PagesYouMayLikeDeclaration m25724b(InjectorLike injectorLike) {
        return new PagesYouMayLikeDeclaration(IdBasedLazy.m1808a(injectorLike, 1984), IdBasedLazy.m1808a(injectorLike, 1988), IdBasedProvider.m1811a(injectorLike, 678), IdBasedLazy.m1808a(injectorLike, 6492));
    }

    @Inject
    public PagesYouMayLikeDeclaration(Lazy<PagesYouMayLikePartDefinition> lazy, Lazy<PagesYouMayLikeSmallFormatPartDefinition> lazy2, Provider<TriState> provider, Lazy<ContentBasedPagesYouMayLikePartDefinition> lazy3) {
        this.f18347a = lazy;
        this.f18348b = lazy2;
        this.f18349c = provider;
        this.f18350d = lazy3;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPYMLWithLargeImageFeedUnit.class, this.f18347a);
        if (this.f18349c.get() == TriState.YES) {
            rootPartRegistrationController.m25196a(GraphQLCreativePagesYouMayLikeFeedUnit.class, this.f18348b);
        }
        rootPartRegistrationController.m25196a(GraphQLPagesYouMayLikeFeedUnit.class, this.f18350d);
    }

    public static PagesYouMayLikeDeclaration m25723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18346f) {
                PagesYouMayLikeDeclaration pagesYouMayLikeDeclaration;
                if (a2 != null) {
                    pagesYouMayLikeDeclaration = (PagesYouMayLikeDeclaration) a2.mo818a(f18346f);
                } else {
                    pagesYouMayLikeDeclaration = f18345e;
                }
                if (pagesYouMayLikeDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25724b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18346f, b3);
                        } else {
                            f18345e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlPagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlHeaderPartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlSmallFormatPagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlFallbackPagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlPhotoPagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlSharePagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PymlSeeAllPagePartDefinition.a);
    }
}
