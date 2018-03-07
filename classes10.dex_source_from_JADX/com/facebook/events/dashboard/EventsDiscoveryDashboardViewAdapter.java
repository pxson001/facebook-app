package com.facebook.events.dashboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.dashboard.multirow.EventsDashboardItem;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollectionProvider;
import com.facebook.events.dashboard.multirow.EventsDashboardPartDefinitionKey;
import com.facebook.events.dashboard.multirow.EventsDashboardRootPartSelector;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGenerated;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGeneratedProvider;
import com.facebook.events.feed.ui.EventsFeedListType;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPromptsModel.EventPromptsModel.NodesModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUnitTagHelper;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.ads.identifier.service.START */
public class EventsDiscoveryDashboardViewAdapter extends Adapter<ViewHolder> {
    private static final LayoutParams f16849a = new LayoutParams(-1, -2);
    private final MultipleRowsStoriesRecycleCallback f16850b;
    public DashboardFilterType f16851c;
    private DashboardFilterType f16852d;
    private Context f16853e;
    private String f16854f;
    public EventsDashboardEnvironmentGenerated f16855g;
    private EventsDashboardEnvironmentGeneratedProvider f16856h;
    private EventAnalyticsParams f16857i;
    public EventsDashboardItemCollection f16858j;
    private EventsDashboardPerformanceLogger f16859k;
    private EventsDashboardSequenceLogger f16860l;
    private EventEventLogger f16861m;
    public FutureCallback<GraphQLResult<ReactionUnitFragment>> f16862n = m17229l();
    public GraphQLSubscriptionHolder f16863o;
    public MultiRowAdapter f16864p;
    public MultiRowAdapterBuilder f16865q;
    private MultiRowImagePrefetcherFactory f16866r;
    private MultiRowImagePrefetcherWrapper f16867s;
    private EventsDiscoveryDashboardFragment f16868t;
    @Nullable
    private ReactionSession f16869u;
    @Nullable
    private ReactionInteractionTracker f16870v;
    public Lazy<EventsDashboardRootPartSelector> f16871w;

    /* compiled from: com.google.android.gms.ads.identifier.service.START */
    class C23581 implements Runnable {
        final /* synthetic */ EventsDiscoveryDashboardViewAdapter f16846a;

        C23581(EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter) {
            this.f16846a = eventsDiscoveryDashboardViewAdapter;
        }

        public void run() {
            if (this.f16846a.f16864p != null) {
                EventsDiscoveryDashboardViewAdapter.m17230m(this.f16846a);
            }
        }
    }

    /* compiled from: com.google.android.gms.ads.identifier.service.START */
    class C23592 implements Delegate {
        final /* synthetic */ EventsDiscoveryDashboardViewAdapter f16847a;

        C23592(EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter) {
            this.f16847a = eventsDiscoveryDashboardViewAdapter;
        }

        public final void m17224a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        }
    }

    /* compiled from: com.google.android.gms.ads.identifier.service.START */
    class C23603 implements FutureCallback<GraphQLResult<ReactionUnitFragment>> {
        final /* synthetic */ EventsDiscoveryDashboardViewAdapter f16848a;

        C23603(EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter) {
            this.f16848a = eventsDiscoveryDashboardViewAdapter;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f16848a.f16858j.m17369a((ReactionUnitFragment) graphQLResult.e);
                EventsDiscoveryDashboardViewAdapter.m17230m(this.f16848a);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    @Inject
    public EventsDiscoveryDashboardViewAdapter(@Assisted DashboardFilterType dashboardFilterType, @Assisted Boolean bool, @Assisted Context context, @Assisted EventAnalyticsParams eventAnalyticsParams, @Assisted EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, @Nullable @Assisted ReactionSession reactionSession, @Assisted String str, @Nullable @Assisted ReactionInteractionTracker reactionInteractionTracker, EventsDashboardEnvironmentGeneratedProvider eventsDashboardEnvironmentGeneratedProvider, EventsDashboardItemCollectionProvider eventsDashboardItemCollectionProvider, EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, EventEventLogger eventEventLogger, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, MultiRowAdapterBuilder multiRowAdapterBuilder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, Lazy<EventsDashboardRootPartSelector> lazy) {
        this.f16851c = dashboardFilterType;
        this.f16853e = context;
        this.f16857i = eventAnalyticsParams;
        this.f16868t = eventsDiscoveryDashboardFragment;
        this.f16869u = reactionSession;
        this.f16854f = str;
        this.f16856h = eventsDashboardEnvironmentGeneratedProvider;
        this.f16858j = eventsDashboardItemCollectionProvider.m17379a(bool, this.f16851c);
        this.f16859k = eventsDashboardPerformanceLogger;
        this.f16860l = eventsDashboardSequenceLogger;
        this.f16861m = eventEventLogger;
        this.f16863o = graphQLSubscriptionHolder;
        this.f16866r = multiRowImagePrefetcherFactory;
        this.f16865q = multiRowAdapterBuilder;
        this.f16850b = multipleRowsStoriesRecycleCallback;
        this.f16871w = lazy;
        this.f16870v = reactionInteractionTracker;
        m17225g();
    }

    private void m17225g() {
        this.f16867s = this.f16866r.a();
        m17226h();
        if (this.f16864p == null) {
            Builder a = this.f16865q.a(this.f16871w, this.f16858j);
            a.f = this.f16855g;
            this.f16864p = a.e();
        }
    }

    public final ViewHolder m17231a(ViewGroup viewGroup, int i) {
        View a = this.f16864p.a(i, viewGroup);
        a.setLayoutParams(f16849a);
        return new EventsDiscoveryDashboardRowViewHolder(a, viewGroup, i);
    }

    public final void m17233a(ViewHolder viewHolder, int i) {
        EventsDiscoveryDashboardRowViewHolder eventsDiscoveryDashboardRowViewHolder = (EventsDiscoveryDashboardRowViewHolder) viewHolder;
        int i2 = eventsDiscoveryDashboardRowViewHolder.f16845m;
        ViewGroup viewGroup = eventsDiscoveryDashboardRowViewHolder.f16844l;
        this.f16864p.getItem(i);
        this.f16864p.a(i, this.f16864p.getItem(i), eventsDiscoveryDashboardRowViewHolder.a, eventsDiscoveryDashboardRowViewHolder.f16845m, eventsDiscoveryDashboardRowViewHolder.f16844l);
        int s_ = this.f16864p.s_(i);
        if (s_ >= 0 && s_ < this.f16858j.m17365a()) {
            EventsDashboardItem eventsDashboardItem = (EventsDashboardItem) this.f16858j.m17366a(s_);
            if (eventsDashboardItem != null && eventsDashboardItem.f17050b == EventsDashboardPartDefinitionKey.f17085g && this.f16870v != null) {
                this.f16870v.a((ReactionUnitFragment) eventsDashboardItem.f17049a, s_, i);
            }
        }
    }

    public int getItemViewType(int i) {
        return this.f16864p.getItemViewType(i);
    }

    public final int aZ_() {
        return this.f16864p == null ? 0 : this.f16864p.getCount();
    }

    public final void m17232a(ViewHolder viewHolder) {
        super.a(viewHolder);
        if (viewHolder instanceof EventsDiscoveryDashboardRowViewHolder) {
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        } else {
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        }
    }

    private void m17226h() {
        ReactionInteractionTracker reactionInteractionTracker;
        String name;
        EventsDashboardEnvironmentGeneratedProvider eventsDashboardEnvironmentGeneratedProvider = this.f16856h;
        Context context = this.f16853e;
        EventsFeedListType b = EventsFeedListType.m17802b();
        C23581 c23581 = new C23581(this);
        MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper = this.f16867s;
        Delegate j = m17227j();
        Context context2 = this.f16853e;
        EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment = this.f16868t;
        if (this.f16868t == null) {
            reactionInteractionTracker = null;
        } else {
            reactionInteractionTracker = this.f16868t.getInteractionTracker();
        }
        ReactionSession reactionSession = this.f16869u;
        EventAnalyticsParams eventAnalyticsParams = this.f16857i;
        EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment2 = this.f16868t;
        String str = this.f16857i.c;
        String str2 = this.f16857i.e;
        if (this.f16869u != null) {
            name = this.f16869u.w().name();
        } else {
            name = "unknown";
        }
        ReactionAnalyticsParams reactionAnalyticsParams = new ReactionAnalyticsParams(str, str2, name, "unknown", null);
        this.f16855g = eventsDashboardEnvironmentGeneratedProvider.m17472a(context, b, c23581, null, multiRowImagePrefetcherWrapper, j, context2, eventsDiscoveryDashboardFragment, reactionInteractionTracker, reactionSession, eventAnalyticsParams, eventsDiscoveryDashboardFragment2, reactionAnalyticsParams, this.f16858j);
    }

    public final void m17235a(Event event) {
        if (event != null && this.f16858j != null) {
            this.f16858j.m17371a(event.a, event);
            m17230m(this);
        }
    }

    public final boolean m17243b(DashboardFilterType dashboardFilterType) {
        return this.f16858j != null ? this.f16858j.f17064m.containsKey(dashboardFilterType) : false;
    }

    public final void m17244c(DashboardFilterType dashboardFilterType) {
        if (this.f16858j != null) {
            EventsDashboardItemCollection eventsDashboardItemCollection = this.f16858j;
            if (eventsDashboardItemCollection.f17064m.containsKey(dashboardFilterType)) {
                eventsDashboardItemCollection.f17055d = eventsDashboardItemCollection.f17065n == DashboardFilterType.UPCOMING ? eventsDashboardItemCollection.f17056e : new ArrayList();
                eventsDashboardItemCollection.f17059h = (List) eventsDashboardItemCollection.f17064m.get(dashboardFilterType);
            }
            m17228k();
            this.f16859k.m17099c(dashboardFilterType.name());
        }
    }

    public final boolean m17245d(DashboardFilterType dashboardFilterType) {
        return this.f16858j != null && this.f16858j.f17058g.containsKey(dashboardFilterType);
    }

    public final void m17236a(ImmutableList<Event> immutableList) {
        Preconditions.checkNotNull(this.f16855g);
        this.f16858j.m17370a((ImmutableList) immutableList);
        if (this.f16851c == DashboardFilterType.UPCOMING) {
            this.f16860l.m17151a(LoadingState.RENDERING);
        }
        m17228k();
    }

    public final void m17234a(DashboardFilterType dashboardFilterType, ImmutableList<NodesModel> immutableList) {
        Preconditions.checkNotNull(this.f16855g);
        if (immutableList != null && !immutableList.isEmpty()) {
            this.f16858j.m17367a(dashboardFilterType, (NodesModel) immutableList.get(0));
            m17228k();
        }
    }

    public final void m17239a(List<EventUserWithBirthdayFragmentModel> list, String str) {
        Preconditions.checkNotNull(this.f16855g);
        EventsDashboardItemCollection eventsDashboardItemCollection = this.f16858j;
        eventsDashboardItemCollection.f17055d = new ArrayList();
        eventsDashboardItemCollection.f17057f = new ArrayList(list.size());
        eventsDashboardItemCollection.m17376b(list, str);
        m17228k();
    }

    public final void m17241b(List<EventUserWithBirthdayFragmentModel> list, String str) {
        Preconditions.checkNotNull(this.f16855g);
        this.f16858j.m17376b(list, str);
        m17228k();
    }

    public final void m17238a(List<ReactionUnitFragment> list) {
        this.f16858j.m17375b((List) list);
        for (ReactionUnitFragment reactionUnitFragment : list) {
            this.f16863o.a(this.f16862n, reactionUnitFragment.d(), new GraphQLResult(reactionUnitFragment, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, ReactionUnitTagHelper.a(reactionUnitFragment)));
        }
        m17230m(this);
    }

    private Delegate m17227j() {
        return new C23592(this);
    }

    public final void m17240b(ImmutableList<Event> immutableList) {
        Preconditions.checkNotNull(this.f16855g);
        this.f16858j.m17372a((List) immutableList);
        m17228k();
    }

    public final void m17237a(String str) {
        Preconditions.checkNotNull(this.f16855g);
        if (str != null) {
            this.f16858j.m17374b(str);
            m17230m(this);
        }
    }

    public final void m17242b(boolean z) {
        if (this.f16858j.m17377b(z)) {
            m17230m(this);
        }
    }

    private void m17228k() {
        m17230m(this);
        this.f16861m.m18128a(this.f16851c.name(), this.f16858j.f17055d.size(), this.f16854f, this.f16857i.b.f.getParamValue());
        if (this.f16852d != this.f16851c) {
            this.f16859k.m17099c(this.f16851c.name());
            this.f16852d = this.f16851c;
        }
    }

    private FutureCallback<GraphQLResult<ReactionUnitFragment>> m17229l() {
        return new C23603(this);
    }

    public static void m17230m(EventsDiscoveryDashboardViewAdapter eventsDiscoveryDashboardViewAdapter) {
        eventsDiscoveryDashboardViewAdapter.f16864p.notifyDataSetChanged();
        eventsDiscoveryDashboardViewAdapter.notifyDataSetChanged();
    }

    public final void m17246f() {
        this.f16863o.a();
    }
}
