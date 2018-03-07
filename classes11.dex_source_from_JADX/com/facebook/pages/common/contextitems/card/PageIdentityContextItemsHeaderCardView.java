package com.facebook.pages.common.contextitems.card;

import android.content.Context;
import android.graphics.Canvas;
import android.os.ParcelUuid;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryInterfaces.ContextItemsConnectionFragment.Edges;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionFragmentModel.EdgesModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.entitycards.contextitems.handler.ContextItemsOnClickListener;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter.EntityData;
import com.facebook.entitycards.contextitems.ui.ContextItemsContainer;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLRating.Builder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.EventsSubscribeStatusChangedEventSubscriber;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PhotoMenuUploadStartedEventSubscriber;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PlaceQuestionAnsweredEventSubscriber;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.pages.identity.contextitems.handler.PageContextItemsClickHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: spotify_save */
public class PageIdentityContextItemsHeaderCardView extends CustomLinearLayout implements PageHeaderCardView {
    public static final List<GraphQLEntityCardContextItemType> f1480h = Arrays.asList(new GraphQLEntityCardContextItemType[]{GraphQLEntityCardContextItemType.PLACE_CITY_QUESTION, GraphQLEntityCardContextItemType.PLACE_STREET_ADDRESS_QUESTION, GraphQLEntityCardContextItemType.PLACE_ZIP_CODE_QUESTION});
    @Inject
    ContextItemsAdapter f1481a;
    @Inject
    PageScopedEventBus f1482b;
    @Inject
    Lazy<FbErrorReporter> f1483c;
    @Inject
    public Lazy<PageContextItemsClickHandler> f1484d;
    @Inject
    Lazy<ViewerContextUtil> f1485e;
    @Inject
    Toaster f1486f;
    @Inject
    @ForUiThread
    Lazy<Executor> f1487g;
    private boolean f1488i;
    private boolean f1489j;
    public ParcelUuid f1490k;
    public PageContextItemsViewModel f1491l;
    private PhotoMenuUploadStartedEventSubscriber f1492m;
    private PlaceQuestionAnsweredEventSubscriber f1493n;
    private EventsSubscribeStatusChangedEventSubscriber f1494o;
    private ContextItemsContainer f1495p;
    private View f1496q;

    /* compiled from: spotify_save */
    class C02031 implements ContextItemsOnClickListener {
        final /* synthetic */ PageIdentityContextItemsHeaderCardView f1469a;

        C02031(PageIdentityContextItemsHeaderCardView pageIdentityContextItemsHeaderCardView) {
            this.f1469a = pageIdentityContextItemsHeaderCardView;
        }

        public final void m2152a(final View view, final ContextItemFieldsModel contextItemFieldsModel) {
            if (ProfilePermissions.a(this.f1469a.f1491l.f1477e)) {
                final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f1469a.getContext(), 2131235433);
                ((ViewerContextUtil) this.f1469a.f1485e.get()).a(String.valueOf(this.f1469a.f1491l.f1473a), new ViewerContextWaiter(this) {
                    final /* synthetic */ C02031 f1468d;

                    public final void m2149a(ViewerContext viewerContext) {
                        PageIdentityContextItemsHeaderCardView.m2171a(this.f1468d.f1469a, view, contextItemFieldsModel, viewerContext);
                    }

                    public final void m2148a() {
                        if (this.f1468d.f1469a.getContext() != null) {
                            dialogBasedProgressIndicator.a();
                        }
                    }

                    public final void m2151b(ViewerContext viewerContext) {
                        if (this.f1468d.f1469a.getContext() != null) {
                            dialogBasedProgressIndicator.b();
                            PageIdentityContextItemsHeaderCardView.m2171a(this.f1468d.f1469a, view, contextItemFieldsModel, viewerContext);
                        }
                    }

                    public final void m2150b() {
                        if (this.f1468d.f1469a.getContext() != null) {
                            dialogBasedProgressIndicator.b();
                            this.f1468d.f1469a.f1486f.a(new ToastBuilder(this.f1468d.f1469a.getContext().getResources().getString(2131235536)));
                        }
                    }
                }, (Executor) this.f1469a.f1487g.get());
                return;
            }
            PageIdentityContextItemsHeaderCardView.m2171a(this.f1469a, view, contextItemFieldsModel, null);
        }
    }

    /* compiled from: spotify_save */
    public class PageContextItemsViewModel {
        public final long f1473a;
        public final String f1474b;
        public final String f1475c;
        public final ContextItemsConnectionWithPageInfoFragmentModel f1476d;
        public final ImmutableList<String> f1477e;
        public final GraphQLRating f1478f;
        public final DefaultLocationFieldsModel f1479g;

        public PageContextItemsViewModel(long j, String str, String str2, ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel, ImmutableList<String> immutableList, GraphQLRating graphQLRating, DefaultLocationFieldsModel defaultLocationFieldsModel) {
            this.f1473a = j;
            this.f1474b = str;
            this.f1475c = str2;
            this.f1476d = contextItemsConnectionWithPageInfoFragmentModel;
            this.f1477e = immutableList;
            this.f1478f = graphQLRating;
            this.f1479g = defaultLocationFieldsModel;
        }

        public final long m2156a() {
            return this.f1473a;
        }

        public final String m2157b() {
            return this.f1474b;
        }

        public final String m2158c() {
            return this.f1475c;
        }

        public final ContextItemsConnectionWithPageInfoFragmentModel m2159d() {
            return this.f1476d;
        }

        public final ImmutableList<String> m2160e() {
            return this.f1477e;
        }

        public final GraphQLRating m2161f() {
            return this.f1478f;
        }

        public final DefaultLocationFieldsModel m2162g() {
            return this.f1479g;
        }
    }

    private static <T extends View> void m2173a(Class<T> cls, T t) {
        m2174a((Object) t, t.getContext());
    }

    private static void m2174a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityContextItemsHeaderCardView) obj).m2170a(ContextItemsAdapter.b(fbInjector), PageScopedEventBus.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedLazy.a(fbInjector, 9062), IdBasedLazy.a(fbInjector, 9011), Toaster.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 3863));
    }

    static /* synthetic */ void m2171a(PageIdentityContextItemsHeaderCardView pageIdentityContextItemsHeaderCardView, View view, ContextItemFieldsModel contextItemFieldsModel, ViewerContext viewerContext) {
        PageContextItemHandlingData pageContextItemHandlingData = new PageContextItemHandlingData(pageIdentityContextItemsHeaderCardView.f1491l.m2156a(), pageIdentityContextItemsHeaderCardView.f1491l.f1474b, pageIdentityContextItemsHeaderCardView.f1491l.m2158c(), pageIdentityContextItemsHeaderCardView.f1491l.m2162g(), null, viewerContext, false, false);
        pageContextItemHandlingData.j = pageIdentityContextItemsHeaderCardView.f1490k;
        ((PageContextItemsClickHandler) pageIdentityContextItemsHeaderCardView.f1484d.get()).a(view, contextItemFieldsModel, pageContextItemHandlingData);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.f1489j && this.f1488i) {
            if (this.f1490k == null) {
                ((AbstractFbErrorReporter) this.f1483c.get()).b(getClass().getName(), "UUID in context heaeder view is null");
            }
            this.f1482b.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f1490k, HeaderPerfLoggingEventType.CONTEXT_ITEMS_DISPATCH_DRAW, Optional.of(DataFreshnessResult.FROM_SERVER)));
            this.f1489j = true;
        }
    }

    public PageIdentityContextItemsHeaderCardView(Context context) {
        super(context);
        m2177c();
    }

    public PageIdentityContextItemsHeaderCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2177c();
    }

    public PageIdentityContextItemsHeaderCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2177c();
    }

    private void m2177c() {
        m2173a(PageIdentityContextItemsHeaderCardView.class, (View) this);
        setContentView(2130906011);
        setOrientation(1);
        this.f1495p = (ContextItemsContainer) a(2131565484);
        this.f1496q = a(2131565485);
        this.f1495p.setAdapter(this.f1481a);
        this.f1495p.a("newsfeed", "");
        this.f1495p.g = new C02031(this);
    }

    public void setContainerBorderVisibility(boolean z) {
        this.f1496q.setVisibility(z ? 0 : 8);
    }

    public void setParentFragment(FbFragment fbFragment) {
        this.f1490k = ((PagesFragmentWithUuid) fbFragment).mo55h();
    }

    public void setPageFragmentUuid(ParcelUuid parcelUuid) {
        this.f1490k = parcelUuid;
    }

    public final void mo29a(PageHeaderData pageHeaderData) {
        GraphQLRating a;
        long j = pageHeaderData.a;
        String D = pageHeaderData.e.D();
        String i = pageHeaderData.i();
        ContextItemsConnectionWithPageInfoFragmentModel t = pageHeaderData.e.t();
        ImmutableList af = pageHeaderData.e.af();
        if (pageHeaderData.e.F() != null) {
            Builder builder = new Builder();
            builder.d = pageHeaderData.e.F().a();
            builder = builder;
            builder.f = pageHeaderData.e.F().j();
            a = builder.a();
        } else {
            a = null;
        }
        m2182a(new PageContextItemsViewModel(j, D, i, t, af, a, pageHeaderData.e.B()));
    }

    public final void m2182a(PageContextItemsViewModel pageContextItemsViewModel) {
        this.f1491l = pageContextItemsViewModel;
        this.f1488i = true;
        this.f1481a.a(pageContextItemsViewModel.f1476d, ContextItemSurfaces.PAGE_HEADER, new EntityData(String.valueOf(pageContextItemsViewModel.f1473a), this.f1491l.f1478f));
        m2178d();
        if (pageContextItemsViewModel.f1476d != null && pageContextItemsViewModel.f1476d.a() != null) {
            m2172a(pageContextItemsViewModel.f1476d.a());
        }
    }

    public final void m2181a() {
        this.f1495p.a();
    }

    private void m2172a(ImmutableList<? extends Edges> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) immutableList.get(i);
            if (edgesModel.a() != null) {
                ContextItemFieldsModel a = edgesModel.a();
                if (f1480h.contains(a.d())) {
                    m2179e();
                } else if (a.d() == GraphQLEntityCardContextItemType.PAGE_EVENTS_CALENDAR_SUBSCRIPTION) {
                    m2180f();
                }
            }
        }
    }

    private void m2178d() {
        this.f1482b.b(this.f1492m);
        this.f1492m = new PhotoMenuUploadStartedEventSubscriber(this, Long.valueOf(this.f1491l.f1473a)) {
            final /* synthetic */ PageIdentityContextItemsHeaderCardView f1470b;

            public final void m2153b(FbEvent fbEvent) {
                this.f1470b.f1491l = PageIdentityContextItemsHeaderCardView.m2175b(this.f1470b.f1491l, Arrays.asList(new GraphQLEntityCardContextItemType[]{GraphQLEntityCardContextItemType.ADMIN_TIP_ADD_PHOTO_MENU}));
                this.f1470b.m2182a(this.f1470b.f1491l);
            }
        };
        this.f1482b.a(this.f1492m);
    }

    private void m2179e() {
        this.f1482b.b(this.f1493n);
        this.f1493n = new PlaceQuestionAnsweredEventSubscriber(this, Long.valueOf(this.f1491l.f1473a)) {
            final /* synthetic */ PageIdentityContextItemsHeaderCardView f1471b;

            public final void m2154b(FbEvent fbEvent) {
                this.f1471b.f1491l = PageIdentityContextItemsHeaderCardView.m2175b(this.f1471b.f1491l, PageIdentityContextItemsHeaderCardView.f1480h);
                this.f1471b.m2182a(this.f1471b.f1491l);
            }
        };
        this.f1482b.a(this.f1493n);
    }

    private void m2180f() {
        this.f1482b.b(this.f1494o);
        this.f1494o = new EventsSubscribeStatusChangedEventSubscriber(this, Long.valueOf(this.f1491l.f1473a)) {
            final /* synthetic */ PageIdentityContextItemsHeaderCardView f1472b;

            public final void m2155b(FbEvent fbEvent) {
                EventsSubscribeStatusChangedEvent eventsSubscribeStatusChangedEvent = (EventsSubscribeStatusChangedEvent) fbEvent;
                this.f1472b.f1491l = this.f1472b.m2165a(this.f1472b.f1491l, GraphQLEntityCardContextItemType.PAGE_EVENTS_CALENDAR_SUBSCRIPTION, eventsSubscribeStatusChangedEvent.b);
                this.f1472b.m2182a(this.f1472b.f1491l);
            }
        };
        this.f1482b.a(this.f1494o);
    }

    public static PageContextItemsViewModel m2175b(@Nullable PageContextItemsViewModel pageContextItemsViewModel, List<GraphQLEntityCardContextItemType> list) {
        if (pageContextItemsViewModel == null || pageContextItemsViewModel.f1476d == null) {
            return pageContextItemsViewModel;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = pageContextItemsViewModel.f1476d.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.j() == null || !list.contains(edgesModel.j().d())) {
                builder.c(edgesModel);
            }
        }
        ContextItemsConnectionWithPageInfoFragmentModel.Builder builder2 = new ContextItemsConnectionWithPageInfoFragmentModel.Builder();
        builder2 = ContextItemsConnectionWithPageInfoFragmentModel.Builder.a(pageContextItemsViewModel.f1476d);
        builder2.a = builder.b();
        return new PageContextItemsViewModel(pageContextItemsViewModel.f1473a, pageContextItemsViewModel.f1474b, pageContextItemsViewModel.f1475c, builder2.a(), pageContextItemsViewModel.f1477e, pageContextItemsViewModel.f1478f, pageContextItemsViewModel.f1479g);
    }

    private PageContextItemsViewModel m2165a(@Nullable PageContextItemsViewModel pageContextItemsViewModel, GraphQLEntityCardContextItemType graphQLEntityCardContextItemType, GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus) {
        if (pageContextItemsViewModel == null || pageContextItemsViewModel.f1476d == null) {
            return pageContextItemsViewModel;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList a = pageContextItemsViewModel.f1476d.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            ContextItemFieldsModel j = edgesModel.j();
            if (j == null || graphQLEntityCardContextItemType != j.d()) {
                builder.c(edgesModel);
            } else {
                ContextItemFieldsModel.Builder builder2 = new ContextItemFieldsModel.Builder();
                ContextItemFieldsModel.Builder a2 = ContextItemFieldsModel.Builder.a(j);
                a2.f = m2164a(graphQLEventsCalendarSubscriptionStatus);
                j = a2.a();
                EdgesModel.Builder builder3 = new EdgesModel.Builder();
                EdgesModel.Builder a3 = EdgesModel.Builder.a(edgesModel);
                a3.a = j;
                builder.c(a3.a());
            }
        }
        ContextItemsConnectionWithPageInfoFragmentModel.Builder builder4 = new ContextItemsConnectionWithPageInfoFragmentModel.Builder();
        builder4 = ContextItemsConnectionWithPageInfoFragmentModel.Builder.a(pageContextItemsViewModel.f1476d);
        builder4.a = builder.b();
        return new PageContextItemsViewModel(pageContextItemsViewModel.m2156a(), pageContextItemsViewModel.f1474b, pageContextItemsViewModel.f1475c, builder4.a(), pageContextItemsViewModel.f1477e, pageContextItemsViewModel.f1478f, pageContextItemsViewModel.f1479g);
    }

    private DefaultTextWithEntitiesFieldsModel m2164a(GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus) {
        if (graphQLEventsCalendarSubscriptionStatus == GraphQLEventsCalendarSubscriptionStatus.NONE) {
            DefaultTextWithEntitiesFieldsModel.Builder builder = new DefaultTextWithEntitiesFieldsModel.Builder();
            builder.a = getResources().getString(2131235534);
            return builder.a();
        }
        builder = new DefaultTextWithEntitiesFieldsModel.Builder();
        builder.a = getResources().getString(2131235534);
        return builder.a();
    }

    private void m2170a(ContextItemsAdapter contextItemsAdapter, PageScopedEventBus pageScopedEventBus, Lazy<FbErrorReporter> lazy, Lazy<PageContextItemsClickHandler> lazy2, Lazy<ViewerContextUtil> lazy3, Toaster toaster, Lazy<Executor> lazy4) {
        this.f1481a = contextItemsAdapter;
        this.f1482b = pageScopedEventBus;
        this.f1483c = lazy;
        this.f1484d = lazy2;
        this.f1485e = lazy3;
        this.f1486f = toaster;
        this.f1487g = lazy4;
    }
}
