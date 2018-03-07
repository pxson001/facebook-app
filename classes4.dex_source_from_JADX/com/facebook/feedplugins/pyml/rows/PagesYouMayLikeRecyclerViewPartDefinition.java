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
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.ui.itemlistfeedunits.gating.ExperimentsForNewsFeedModule;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: old_tab */
public class PagesYouMayLikeRecyclerViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit>, Void, E, HScrollRecyclerView> {
    private static PagesYouMayLikeRecyclerViewPartDefinition f6264c;
    private static final Object f6265d = new Object();
    private final PagesYouMayLikeHScrollPartDefinition<HScrollRecyclerView, E> f6266a;
    private final QeAccessor f6267b;

    private static PagesYouMayLikeRecyclerViewPartDefinition m6715b(InjectorLike injectorLike) {
        return new PagesYouMayLikeRecyclerViewPartDefinition(PagesYouMayLikeHScrollPartDefinition.m6673a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m6717a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6266a, (FeedUnitAndChangePageListener) obj);
        return null;
    }

    @Inject
    public PagesYouMayLikeRecyclerViewPartDefinition(PagesYouMayLikeHScrollPartDefinition pagesYouMayLikeHScrollPartDefinition, QeAccessor qeAccessor) {
        this.f6266a = pagesYouMayLikeHScrollPartDefinition;
        this.f6267b = qeAccessor;
    }

    public final ViewType<HScrollRecyclerView> m6716a() {
        return HScrollRecyclerViewRowType.f11901a;
    }

    public final boolean m6718a(Object obj) {
        return this.f6267b.a(ExperimentsForNewsFeedModule.f6258a, false);
    }

    public static PagesYouMayLikeRecyclerViewPartDefinition m6714a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeRecyclerViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6265d) {
                PagesYouMayLikeRecyclerViewPartDefinition pagesYouMayLikeRecyclerViewPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeRecyclerViewPartDefinition = (PagesYouMayLikeRecyclerViewPartDefinition) a2.a(f6265d);
                } else {
                    pagesYouMayLikeRecyclerViewPartDefinition = f6264c;
                }
                if (pagesYouMayLikeRecyclerViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6715b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6265d, b3);
                        } else {
                            f6264c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeRecyclerViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
