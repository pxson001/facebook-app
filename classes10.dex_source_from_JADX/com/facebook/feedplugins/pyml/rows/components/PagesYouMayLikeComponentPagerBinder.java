package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import com.facebook.common.util.TriState;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.widget.PagerBinder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher;
import com.facebook.feedplugins.pyml.rows.PagesYouMayLikeHScrollPartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition.Props;
import com.facebook.feedplugins.pyml.rows.components.PageYouMayLikeComponent.Builder;
import com.facebook.feedplugins.pyml.rows.components.PageYouMayLikeComponent.State;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitItem;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.settings.APPLICATION_DETAILS_SETTINGS */
public class PagesYouMayLikeComponentPagerBinder<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends PagerBinder {
    public final ImmutableList<GraphQLPYMLWithLargeImageFeedUnitItem> f19810a;
    private final TasksManager<GraphQLPage> f19811b;
    private final FeedRenderUtils f19812c;
    private final OnPageChangeListener f19813d = new PageChangeListener(this);
    public final boolean f19814e;
    public final PaginatedPYMLWithLargeImageFeedUnitFetcher f19815f;
    private final PageYouMayLikeComponent f19816g;
    public final FeedLoggingViewportEventListener f19817h;
    private final boolean f19818i;
    public FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> f19819j;
    private E f19820k;
    private Controller f19821l;

    /* compiled from: android.settings.APPLICATION_DETAILS_SETTINGS */
    class PageChangeListener implements OnPageChangeListener {
        final /* synthetic */ PagesYouMayLikeComponentPagerBinder f19809a;

        public PageChangeListener(PagesYouMayLikeComponentPagerBinder pagesYouMayLikeComponentPagerBinder) {
            this.f19809a = pagesYouMayLikeComponentPagerBinder;
        }

        public final void m20052a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            this.f19809a.f19817h.a((ScrollableItemListFeedUnit) this.f19809a.f19819j.a.a, i);
            VisibleItemHelper.a((ScrollableItemListFeedUnit) this.f19809a.f19819j.a.a, this.f19809a.f19810a, i);
            if (this.f19809a.f19814e) {
                PagesYouMayLikeHScrollPartDefinition.a((GraphQLPYMLWithLargeImageFeedUnit) this.f19809a.f19819j.a.a, i, this.f19809a.f19815f);
            }
            if (this.f19809a.f19819j.b != null) {
                this.f19809a.f19819j.b.a(i, this.f19809a.f19810a.size());
            }
        }

        public final void m20053b(int i) {
        }
    }

    protected final /* synthetic */ void m20059f(ViewGroup viewGroup) {
        m20056a((ViewPager) viewGroup);
    }

    protected final /* synthetic */ void m20060g(ViewGroup viewGroup) {
        m20057b((ViewPager) viewGroup);
    }

    @Inject
    public PagesYouMayLikeComponentPagerBinder(@Assisted Context context, @Assisted int i, @Assisted float f, @Assisted FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener, @Assisted E e, @Assisted boolean z, Provider<TasksManager> provider, Provider<TriState> provider2, FeedRenderUtils feedRenderUtils, PaginatedPYMLWithLargeImageFeedUnitFetcher paginatedPYMLWithLargeImageFeedUnitFetcher, PageYouMayLikeComponent pageYouMayLikeComponent, FeedLoggingViewportEventListener feedLoggingViewportEventListener) {
        super(context, i, f);
        this.f19811b = (TasksManager) provider.get();
        this.f19819j = feedUnitAndChangePageListener;
        this.f19810a = ((GraphQLPYMLWithLargeImageFeedUnit) feedUnitAndChangePageListener.a.a()).x();
        this.f19820k = e;
        this.f19812c = feedRenderUtils;
        this.f19814e = ((TriState) provider2.get()).asBoolean(false);
        this.f19815f = paginatedPYMLWithLargeImageFeedUnitFetcher;
        this.f19816g = pageYouMayLikeComponent;
        this.f19821l = (Controller) ((HasPersistentState) this.f19820k).a(PagesYouMayLikeHScrollPartDefinition.a((GraphQLPYMLWithLargeImageFeedUnit) this.f19819j.a.a()), (CacheableEntity) this.f19819j.a.a());
        this.f19817h = feedLoggingViewportEventListener;
        this.f19818i = z;
    }

    protected final int m20054a() {
        return this.f19810a.size();
    }

    public final Component<?> m20055a(ComponentContext componentContext, int i) {
        Props props = new Props((SuggestedPageUnitItem) this.f19810a.get(i), this.f19819j.a, this.f19811b, this.f19812c.a(), i, this.f19821l, this.f19818i, this.f19818i);
        PageYouMayLikeComponent pageYouMayLikeComponent = this.f19816g;
        State state = new State(pageYouMayLikeComponent);
        Builder builder = (Builder) pageYouMayLikeComponent.f19767c.a();
        if (builder == null) {
            builder = new Builder(pageYouMayLikeComponent);
        }
        Builder.m20016a(builder, componentContext, 0, state);
        return builder.m20018a(props).m20017a((HasFeedListType) this.f19820k).d();
    }

    protected final boolean m20058c() {
        return false;
    }

    protected final void m20056a(ViewPager viewPager) {
        super.a(viewPager);
        this.i = this.f19813d;
        this.f19821l.a = viewPager;
    }

    protected final void m20057b(ViewPager viewPager) {
        super.b(viewPager);
        this.i = null;
        this.f19821l.a = null;
    }
}
