package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.pager.PagerRowType;
import com.facebook.feed.rows.pager.RowViewPager;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onError MEDIA_ERROR_UNSUPPORTED */
public class PagesYouMayLikeViewPagerPartDefinition<E extends HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit>, Void, E, RowViewPager> {
    private static PagesYouMayLikeViewPagerPartDefinition f6189b;
    private static final Object f6190c = new Object();
    private final PagesYouMayLikeHScrollPartDefinition<RowViewPager, E> f6191a;

    private static PagesYouMayLikeViewPagerPartDefinition m6666b(InjectorLike injectorLike) {
        return new PagesYouMayLikeViewPagerPartDefinition(PagesYouMayLikeHScrollPartDefinition.m6673a(injectorLike));
    }

    public final Object m6668a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6191a, (FeedUnitAndChangePageListener) obj);
        return null;
    }

    @Inject
    public PagesYouMayLikeViewPagerPartDefinition(PagesYouMayLikeHScrollPartDefinition pagesYouMayLikeHScrollPartDefinition) {
        this.f6191a = pagesYouMayLikeHScrollPartDefinition;
    }

    public final ViewType<RowViewPager> m6667a() {
        return PagerRowType.f6291a;
    }

    public final boolean m6669a(Object obj) {
        return true;
    }

    public static PagesYouMayLikeViewPagerPartDefinition m6665a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeViewPagerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6190c) {
                PagesYouMayLikeViewPagerPartDefinition pagesYouMayLikeViewPagerPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeViewPagerPartDefinition = (PagesYouMayLikeViewPagerPartDefinition) a2.a(f6190c);
                } else {
                    pagesYouMayLikeViewPagerPartDefinition = f6189b;
                }
                if (pagesYouMayLikeViewPagerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6666b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6190c, b3);
                        } else {
                            f6189b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeViewPagerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
