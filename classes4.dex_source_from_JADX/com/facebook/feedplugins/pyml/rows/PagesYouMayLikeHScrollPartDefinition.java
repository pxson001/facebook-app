package com.facebook.feedplugins.pyml.rows;

import android.content.Context;
import android.view.View;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.pager.PersistentPagerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle.FullWidthPageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition$Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.ui.itemlistfeedunits.gating.ExperimentsForNewsFeedModule;
import com.facebook.feed.util.HScrollUnitCacheUtils;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.hscroll.ExperimentsForHScrollModule;
import com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher;
import com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher.1;
import com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher.2;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition.Props;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: onError MEDIA_ERROR_UNKNOWN */
public class PagesYouMayLikeHScrollPartDefinition<V extends View, E extends HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext> extends BaseSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit>, Void, E, V> {
    private static PagesYouMayLikeHScrollPartDefinition f6192r;
    private static final Object f6193s = new Object();
    private final PaddingStyle f6194a;
    private final BackgroundPartDefinition f6195b;
    private final Context f6196c;
    public final TasksManager<GraphQLPage> f6197d;
    public final FeedUnitDataController f6198e;
    public final PymlPagePartDefinition<E> f6199f;
    public final PaginatedPYMLWithLargeImageFeedUnitFetcher f6200g;
    public final boolean f6201h;
    public final FeedLoggingViewportEventListener f6202i;
    private final FeedRenderUtils f6203j;
    public final HScrollUnitCacheUtils f6204k;
    private final float f6205l;
    private final PageSwitcherPartDefinition f6206m;
    private final PersistentPagerPartDefinition<Object, E> f6207n;
    private final PersistentRecyclerPartDefinition<Object, E> f6208o;
    private final QeAccessor f6209p;
    private boolean f6210q;

    /* compiled from: onError MEDIA_ERROR_UNKNOWN */
    final class C02872 implements ContextStateKey<String, Controller> {
        final /* synthetic */ String f6410a;

        C02872(String str) {
            this.f6410a = str;
        }

        public final Object m6853a() {
            return new Controller();
        }

        public final Object m6854b() {
            return this.f6410a;
        }
    }

    private static PagesYouMayLikeHScrollPartDefinition m6676b(InjectorLike injectorLike) {
        return new PagesYouMayLikeHScrollPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedRenderUtils.a(injectorLike), HScrollUnitCacheUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 3561), FeedUnitDataController.a(injectorLike), IdBasedProvider.a(injectorLike, 680), PaginatedPYMLWithLargeImageFeedUnitFetcher.m6678a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PymlPagePartDefinition.m6684a(injectorLike), PageSwitcherPartDefinition.m6658a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PersistentPagerPartDefinition.m6707a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m6677a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SinglePartDefinition singlePartDefinition;
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = (FeedUnitAndChangePageListener) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        this.f6210q = this.f6209p.a(ExperimentsForNewsFeedModule.f6258a, false);
        subParts.a(this.f6195b, new StylingData(feedUnitAndChangePageListener.f6289a, this.f6194a, Position.TOP));
        Controller controller = (Controller) ((HasPersistentState) hasPositionInformation).a(m6670a((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a), (CacheableEntity) feedUnitAndChangePageListener.f6289a.a);
        subParts.a(this.f6206m, controller);
        PageStyle a = m6671a();
        if (this.f6210q) {
            singlePartDefinition = this.f6208o;
        } else {
            singlePartDefinition = this.f6207n;
        }
        subParts.a(singlePartDefinition, new PersistentRecyclerPartDefinition$Props(a, ((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a).ac_(), m6672a(feedUnitAndChangePageListener, controller), ((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a).g(), (CacheableEntity) feedUnitAndChangePageListener.f6289a.a));
        if (this.f6201h && this.f6209p.a(ExperimentsForHScrollModule.f6428e, false)) {
            if (!this.f6200g.f6213b.contains(((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a).g())) {
                m6674a((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a, 0, this.f6200g);
            }
        }
        return null;
    }

    public static PagesYouMayLikeHScrollPartDefinition m6673a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayLikeHScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6193s) {
                PagesYouMayLikeHScrollPartDefinition pagesYouMayLikeHScrollPartDefinition;
                if (a2 != null) {
                    pagesYouMayLikeHScrollPartDefinition = (PagesYouMayLikeHScrollPartDefinition) a2.a(f6193s);
                } else {
                    pagesYouMayLikeHScrollPartDefinition = f6192r;
                }
                if (pagesYouMayLikeHScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6676b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6193s, b3);
                        } else {
                            f6192r = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayLikeHScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagesYouMayLikeHScrollPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, Context context, FeedRenderUtils feedRenderUtils, HScrollUnitCacheUtils hScrollUnitCacheUtils, Provider<TasksManager> provider, FeedUnitDataController feedUnitDataController, Provider<TriState> provider2, PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PymlPagePartDefinition pymlPagePartDefinition, PageSwitcherPartDefinition pageSwitcherPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PersistentPagerPartDefinition persistentPagerPartDefinition, QeAccessor qeAccessor) {
        this.f6195b = backgroundPartDefinition;
        this.f6196c = context;
        this.f6198e = feedUnitDataController;
        this.f6199f = pymlPagePartDefinition;
        this.f6197d = (TasksManager) provider.get();
        this.f6200g = paginatedPYMLWithLargeImageFeedUnitFetcher;
        this.f6203j = feedRenderUtils;
        this.f6204k = hScrollUnitCacheUtils;
        this.f6201h = ((TriState) provider2.get()).asBoolean(false);
        this.f6202i = feedLoggingViewportEventListener;
        this.f6205l = defaultPaddingStyleResolver.c();
        this.f6194a = Builder.e().a((-this.f6205l) - defaultPaddingStyleResolver.d()).i();
        this.f6206m = pageSwitcherPartDefinition;
        this.f6208o = persistentRecyclerPartDefinition;
        this.f6207n = persistentPagerPartDefinition;
        this.f6209p = qeAccessor;
    }

    private PageStyle m6671a() {
        return !this.f6210q ? new FullWidthPageStyle() : PageStyle.m14677a(SizeUtil.c(this.f6196c, (float) this.f6203j.a()), false, this.f6210q);
    }

    private PersistentRecyclerPartDefinition$Callbacks<Object, E> m6672a(FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener, Controller controller) {
        final GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.f6289a.a;
        final ImmutableList x = graphQLPYMLWithLargeImageFeedUnit.x();
        final FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener2 = feedUnitAndChangePageListener;
        final Controller controller2 = controller;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ PagesYouMayLikeHScrollPartDefinition f6415e;

            public final void mo566a(PageSubParts<E> pageSubParts) {
                for (int i = 0; i < x.size(); i++) {
                    boolean z;
                    PymlPagePartDefinition pymlPagePartDefinition = this.f6415e.f6199f;
                    SuggestedPageUnitItem suggestedPageUnitItem = (SuggestedPageUnitItem) x.get(i);
                    FeedProps feedProps = feedUnitAndChangePageListener2.f6289a;
                    TasksManager tasksManager = this.f6415e.f6197d;
                    int b = PagesYouMayLikeHScrollPartDefinition.m6675b(this.f6415e);
                    Controller controller = controller2;
                    boolean z2 = !this.f6415e.f6198e.a(graphQLPYMLWithLargeImageFeedUnit).s;
                    if (this.f6415e.f6198e.a(graphQLPYMLWithLargeImageFeedUnit).r()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pageSubParts.m14702a(pymlPagePartDefinition, new Props(suggestedPageUnitItem, feedProps, tasksManager, b, i, controller, z2, z));
                }
            }

            public final void m6863c(int i) {
                this.f6415e.f6202i.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener2.f6289a.a, i);
                this.f6415e.f6204k.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener2.f6289a.a, i);
                VisibleItemHelper.a((ScrollableItemListFeedUnit) feedUnitAndChangePageListener2.f6289a.a, x, i);
                if (this.f6415e.f6201h) {
                    PagesYouMayLikeHScrollPartDefinition.m6674a((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener2.f6289a.a, i, this.f6415e.f6200g);
                }
                if (feedUnitAndChangePageListener2.f6290b != null) {
                    feedUnitAndChangePageListener2.f6290b.a(i, x.size());
                }
            }
        };
    }

    public static ContextStateKey<String, Controller> m6670a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        return new C02872(PagesYouMayLikeHScrollPartDefinition.class + graphQLPYMLWithLargeImageFeedUnit.g());
    }

    public static int m6675b(PagesYouMayLikeHScrollPartDefinition pagesYouMayLikeHScrollPartDefinition) {
        int a = pagesYouMayLikeHScrollPartDefinition.f6203j.a();
        return pagesYouMayLikeHScrollPartDefinition.f6210q ? a : a - pagesYouMayLikeHScrollPartDefinition.f6203j.a(pagesYouMayLikeHScrollPartDefinition.f6196c, 3);
    }

    public static void m6674a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit, int i, PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher) {
        Object obj = null;
        if (paginatedPYMLWithLargeImageFeedUnitFetcher.f6224m.a(ExperimentsForHScrollModule.f6426c, 8) > 0) {
            int a = paginatedPYMLWithLargeImageFeedUnitFetcher.f6224m.a(ExperimentsForHScrollModule.f6429f, 5);
            if (!paginatedPYMLWithLargeImageFeedUnitFetcher.f6212a.contains(graphQLPYMLWithLargeImageFeedUnit.g()) && a + i >= graphQLPYMLWithLargeImageFeedUnit.x().size() - 1) {
                obj = 1;
            }
        }
        if (obj != null) {
            if (paginatedPYMLWithLargeImageFeedUnitFetcher.f6214c.contains(graphQLPYMLWithLargeImageFeedUnit.g()) || graphQLPYMLWithLargeImageFeedUnit.x().size() >= paginatedPYMLWithLargeImageFeedUnitFetcher.f6224m.a(ExperimentsForHScrollModule.f6424a, 25)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                paginatedPYMLWithLargeImageFeedUnitFetcher.f6212a.add(graphQLPYMLWithLargeImageFeedUnit.g());
                paginatedPYMLWithLargeImageFeedUnitFetcher.f6213b.add(graphQLPYMLWithLargeImageFeedUnit.g());
                paginatedPYMLWithLargeImageFeedUnitFetcher.f6221j.a(null, new 1(paginatedPYMLWithLargeImageFeedUnitFetcher, graphQLPYMLWithLargeImageFeedUnit), new 2(paginatedPYMLWithLargeImageFeedUnitFetcher, graphQLPYMLWithLargeImageFeedUnit));
            }
        }
    }
}
