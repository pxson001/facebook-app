package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pyml.rows.PymlSmallFormatPagePartDefinition.Props;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: onPrepared */
public class PagesYouMayLikeSmallFormatHScrollPartDefinition<V extends View, E extends HasPositionInformation & HasPersistentState & HasContext> extends BaseSinglePartDefinition<FeedProps<GraphQLCreativePagesYouMayLikeFeedUnit>, Void, E, V> {
    private static PagesYouMayLikeSmallFormatHScrollPartDefinition f6138h;
    private static final Object f6139i = new Object();
    private final BackgroundPartDefinition f6140a;
    public final TasksManager<GraphQLPage> f6141b;
    public final PymlSmallFormatPagePartDefinition f6142c;
    public final FeedLoggingViewportEventListener f6143d;
    private final PersistentRecyclerPartDefinition<Object, E> f6144e;
    private final PageSwitcherPartDefinition f6145f;
    private final PageStyleFactory f6146g;

    private static PagesYouMayLikeSmallFormatHScrollPartDefinition m6618b(InjectorLike injectorLike) {
        return new PagesYouMayLikeSmallFormatHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 3561), PymlSmallFormatPagePartDefinition.m6621a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageSwitcherPartDefinition.m6658a(injectorLike));
    }

    public final Object m6619a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) feedProps.a;
        HasPersistentState hasPersistentState = (HasPersistentState) ((HasPositionInformation) anyEnvironment);
        final String str = getClass() + graphQLCreativePagesYouMayLikeFeedUnit.g();
        final Controller controller = (Controller) hasPersistentState.a(new ContextStateKey<String, Controller>(this) {
            final /* synthetic */ PagesYouMayLikeSmallFormatHScrollPartDefinition f6359b;

            public final Object m6832a() {
                return new Controller();
            }

            public final Object m6833b() {
                return str;
            }
        }, graphQLCreativePagesYouMayLikeFeedUnit);
        subParts.a(this.f6145f, controller);
        PaddingStyle paddingStyle = PageStyle.f13886a;
        subParts.a(this.f6140a, new StylingData(feedProps, paddingStyle));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f6144e;
        PageStyle a = this.f6146g.a(paddingStyle);
        int ac_ = graphQLCreativePagesYouMayLikeFeedUnit.ac_();
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.m14984a(graphQLCreativePagesYouMayLikeFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new PersistentRecyclerPartDefinition$Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ PagesYouMayLikeSmallFormatHScrollPartDefinition f6364d;

            public final void mo566a(PageSubParts<E> pageSubParts) {
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.m14702a(this.f6364d.f6142c, new Props(graphQLCreativePagesYouMayLikeFeedUnit, (SuggestedPageUnitItem) a2.get(i), this.f6364d.f6141b, controller));
                }
            }

            public final void m6836c(int i) {
                this.f6364d.f6143d.a(graphQLCreativePagesYouMayLikeFeedUnit, i);
                VisibleItemHelper.a(graphQLCreativePagesYouMayLikeFeedUnit, a2, i);
            }
        }, graphQLCreativePagesYouMayLikeFeedUnit.g(), graphQLCreativePagesYouMayLikeFeedUnit));
        return null;
    }

    public static PagesYouMayLikeSmallFormatHScrollPartDefinition m6617a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeSmallFormatHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6139i) {
                PagesYouMayLikeSmallFormatHScrollPartDefinition pagesYouMayLikeSmallFormatHScrollPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeSmallFormatHScrollPartDefinition = (PagesYouMayLikeSmallFormatHScrollPartDefinition) a2.a(f6139i);
                } else {
                    pagesYouMayLikeSmallFormatHScrollPartDefinition = f6138h;
                }
                if (pagesYouMayLikeSmallFormatHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6618b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6139i, b3);
                        } else {
                            f6138h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeSmallFormatHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagesYouMayLikeSmallFormatHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, Provider<TasksManager> provider, PymlSmallFormatPagePartDefinition pymlSmallFormatPagePartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition) {
        this.f6140a = backgroundPartDefinition;
        this.f6142c = pymlSmallFormatPagePartDefinition;
        this.f6145f = pageSwitcherPartDefinition;
        this.f6141b = (TasksManager) provider.get();
        this.f6143d = feedLoggingViewportEventListener;
        this.f6146g = pageStyleFactory;
        this.f6144e = persistentRecyclerPartDefinition;
    }
}
