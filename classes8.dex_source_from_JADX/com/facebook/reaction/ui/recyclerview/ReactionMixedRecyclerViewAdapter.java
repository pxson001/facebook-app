package com.facebook.reaction.ui.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.logging.StoryLikeHistoryLogger.Type;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUnitTagHelper;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger.Event;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.common.ReactionValidationResult;
import com.facebook.reaction.common.ReactionViewTypeConstants;
import com.facebook.reaction.feed.ReactionFeedAdapterFactory;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironment;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.feed.nodes.ReactionFeedStoryNode;
import com.facebook.reaction.feed.nodes.ReactionPagesFeedStoryNode;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsAnalytics.StoryAction;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: key_load_feed_header */
public class ReactionMixedRecyclerViewAdapter extends AbstractReactionRecyclerViewAdapter {
    public SearchResultsLogger f10467A;
    public final StoryLikeHistoryLogger f10468B;
    public final StoryMutationHelper f10469C;
    private FeedUnitMutatedEventSubscriber f10470D;
    private Context f10471j;
    private DefaultReactionFeedEnvironment f10472k;
    private DefaultReactionFeedEnvironmentProvider f10473l;
    private ReactionFeedActionHandlerProvider f10474m;
    private ReactionFeedAdapterFactory f10475n;
    private FeedEventBus f10476o;
    private NewsFeedStoryLikeClickSubscriber f10477p;
    private FeedListType f10478q;
    private BaseFeedStoryMenuHelper f10479r;
    public MultiRowRecyclerViewAdapter f10480s;
    private MultipleRowsStoriesRecycleCallback f10481t;
    private FeedStorySubscriber f10482u;
    public FutureCallback<GraphQLResult<ReactionUnitFragment>> f10483v = m12341u();
    public GraphQLSubscriptionHolder f10484w;
    private boolean f10485x;
    private final MultipleRowsStoriesRecycleCallback f10486y;
    public ReactionItemCollection f10487z;

    /* compiled from: key_load_feed_header */
    class C22481 implements OnStoryChangeListener {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21179a;

        C22481(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21179a = reactionMixedRecyclerViewAdapter;
        }

        public final void m24802a(GraphQLStory graphQLStory) {
            this.f21179a.f10487z.m22970a(graphQLStory);
            this.f21179a.mo720k();
        }
    }

    /* compiled from: key_load_feed_header */
    class C22492 implements Runnable {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21180a;

        C22492(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21180a = reactionMixedRecyclerViewAdapter;
        }

        public void run() {
            this.f21180a.mo720k();
        }
    }

    /* compiled from: key_load_feed_header */
    class C22513 implements Delegate {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21183a;

        C22513(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21183a = reactionMixedRecyclerViewAdapter;
        }

        public final void m24804a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            ViewGroup cardViewGroup = this.f21183a.f10458d.getCardViewGroup();
            if (cardViewGroup instanceof BetterRecyclerView) {
                ((BetterRecyclerView) cardViewGroup).a(new OnScrollListener(this) {
                    final /* synthetic */ C22513 f21182b;

                    public final void m24803a(RecyclerView recyclerView, int i, int i2) {
                        super.a(recyclerView, i, i2);
                        hasScrollListenerSupportImpl.b();
                    }
                });
            }
        }
    }

    /* compiled from: key_load_feed_header */
    class C22524 extends FeedUnitMutatedEventSubscriber {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21184a;

        C22524(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21184a = reactionMixedRecyclerViewAdapter;
        }

        public final void m24805b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if (feedUnitMutatedEvent.a instanceof GraphQLStory) {
                this.f21184a.f10487z.m22970a((GraphQLStory) feedUnitMutatedEvent.a);
                this.f21184a.mo720k();
            }
        }
    }

    /* compiled from: key_load_feed_header */
    public class C22535 implements RecyclerListener {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21185a;

        public C22535(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21185a = reactionMixedRecyclerViewAdapter;
        }

        public final void m24806a(ViewHolder viewHolder) {
            MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
        }
    }

    /* compiled from: key_load_feed_header */
    class C22546 implements FutureCallback<GraphQLResult<ReactionUnitFragment>> {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21186a;

        C22546(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21186a = reactionMixedRecyclerViewAdapter;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                this.f21186a.f10487z.m22972a((ReactionUnitFragment) graphQLResult.e);
                this.f21186a.mo720k();
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: key_load_feed_header */
    class NewsFeedStoryLikeClickSubscriber extends LikeClickedEventSubscriber {
        final /* synthetic */ ReactionMixedRecyclerViewAdapter f21191a;

        public NewsFeedStoryLikeClickSubscriber(ReactionMixedRecyclerViewAdapter reactionMixedRecyclerViewAdapter) {
            this.f21191a = reactionMixedRecyclerViewAdapter;
        }

        public final void m24811b(FbEvent fbEvent) {
            GraphQLStory graphQLStory;
            final LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
            final String str = likeClickedEvent.c == null ? likeClickedEvent.a : likeClickedEvent.c;
            ReactionItemCollection reactionItemCollection = this.f21191a.f10487z;
            if (str == null) {
                graphQLStory = null;
            } else {
                for (ReactionItem f : reactionItemCollection.f18945a) {
                    graphQLStory = f.mo1116f();
                    if (graphQLStory != null && str.equals(graphQLStory.g())) {
                        break;
                    }
                }
                graphQLStory = null;
            }
            GraphQLStory graphQLStory2 = graphQLStory;
            if (graphQLStory2 != null) {
                final String j = graphQLStory2.l().j();
                this.f21191a.f10469C.a(StoryProps.a(FeedProps.c(graphQLStory2), likeClickedEvent.a), likeClickedEvent.d, likeClickedEvent.f, null, null, new MutationCallback<FeedUnit>(this) {
                    final /* synthetic */ NewsFeedStoryLikeClickSubscriber f21190d;

                    public final void m24807a(Object obj) {
                        if (this.f21190d.f21191a.f10462h != null) {
                            StoryAction storyAction;
                            SearchResultsLogger searchResultsLogger = this.f21190d.f21191a.f10467A;
                            SearchResultsMutableContext searchResultsMutableContext = this.f21190d.f21191a.f10462h;
                            ReactionItemCollection reactionItemCollection = this.f21190d.f21191a.f10487z;
                            String str = str;
                            int i = 0;
                            while (i < reactionItemCollection.f18945a.size()) {
                                GraphQLStory f = ((ReactionItem) reactionItemCollection.f18945a.get(i)).mo1116f();
                                if (f != null && str.equals(f.g())) {
                                    break;
                                }
                                i++;
                            }
                            i = -1;
                            int i2 = i;
                            str = str;
                            if (likeClickedEvent.d) {
                                storyAction = StoryAction.LIKED;
                            } else {
                                storyAction = StoryAction.UNLIKED;
                            }
                            searchResultsLogger.m25477a(searchResultsMutableContext, i2, str, storyAction, null, null);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void m24810c(Object obj) {
                    }

                    public final void m24809b(Object obj) {
                        this.f21190d.f21191a.f10468B.a(j, this.f21190d.f21191a, likeClickedEvent.d, null, Type.SUCCESS);
                    }

                    public final void m24808a(Object obj, ServiceException serviceException) {
                        this.f21190d.f21191a.f10468B.a(j, this.f21190d.f21191a, likeClickedEvent.d, serviceException.getMessage(), Type.FAILURE);
                    }
                });
            }
        }
    }

    @Inject
    public ReactionMixedRecyclerViewAdapter(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted ReactionCardContainer reactionCardContainer, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider, ReactionExperimentController reactionExperimentController, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedAdapterFactory reactionFeedAdapterFactory, FeedEventBus feedEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedStorySubscriber feedStorySubscriber, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback2, ReactionItemCollection reactionItemCollection, ReactionUtil reactionUtil, SearchResultsLogger searchResultsLogger, ReactionUnitValidator reactionUnitValidator, StoryLikeHistoryLogger storyLikeHistoryLogger, StoryMutationHelper storyMutationHelper) {
        super(reactionCardContainer, reactionAnalyticsLogger, clock, reactionExperimentController, reactionUtil, reactionUnitValidator);
        this.f10471j = context;
        this.f10473l = defaultReactionFeedEnvironmentProvider;
        this.f10474m = reactionFeedActionHandlerProvider;
        this.f10475n = reactionFeedAdapterFactory;
        this.f10476o = feedEventBus;
        this.f10484w = graphQLSubscriptionHolder;
        this.f10478q = feedListType;
        this.f10479r = baseFeedStoryMenuHelper;
        this.f10481t = multipleRowsStoriesRecycleCallback;
        this.f10482u = feedStorySubscriber;
        this.f10486y = multipleRowsStoriesRecycleCallback2;
        this.f10487z = reactionItemCollection;
        this.f10467A = searchResultsLogger;
        this.f10468B = storyLikeHistoryLogger;
        this.f10469C = storyMutationHelper;
    }

    public final boolean mo711a(ReactionSession reactionSession) {
        boolean z;
        this.a = reactionSession;
        mo719j();
        ImmutableList p = reactionSession.m22569p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            m12357b((ReactionStories) p.get(i));
        }
        this.f10480s = mo724q();
        ViewGroup cardViewGroup = this.f10458d.getCardViewGroup();
        if (cardViewGroup instanceof RecyclerView) {
            ((RecyclerView) cardViewGroup).setRecyclerListener(new C22535(this));
        }
        this.f10482u.d = new C22481(this);
        if (this.f10487z.m22974b()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            m12340h(this.f10487z.m22967a());
        }
        return z;
    }

    public final void mo710a(ReactionStories reactionStories) {
        Preconditions.checkNotNull(this.f10455a);
        int a = this.f10487z.m22967a();
        m12357b(reactionStories);
        mo720k();
        m12340h(this.f10487z.m22967a() - a);
    }

    public final void mo714b(ReactionSession reactionSession) {
        this.a = reactionSession;
        jc_();
        this.f10480s = mo724q();
        this.f10485x = false;
    }

    public final void mo709a(ReactionAnalyticsParams reactionAnalyticsParams) {
        this.c = reactionAnalyticsParams;
    }

    protected MultiRowRecyclerViewAdapter mo724q() {
        this.f10472k = this.f10473l.m23149a(this.f10471j, this.f10478q, this.f10479r, new C22492(this), this.f10457c, this.f10474m.m23162a(this.f10471j, this.f10458d), this.f10458d.getInteractionTracker(), this.f10455a, m12370r());
        return this.f10475n.m22964a(this.f10472k, this.f10487z, null);
    }

    public final void jc_() {
        if (this.f10480s != null) {
            this.f10480s.jc_();
        }
        this.f10485x = true;
    }

    public final boolean ba_() {
        return this.f10485x;
    }

    private void m12340h(int i) {
        if (this.f10458d.getInteractionTracker() != null) {
            this.f10458d.getInteractionTracker().m18923a(i, this.f10459e.a());
        }
    }

    public int mo715d() {
        return this.f10480s == null ? 0 : this.f10480s.aZ_();
    }

    public final int mo716e() {
        return this.f10487z.m22967a();
    }

    public final ReactionItem mo717e(int i) {
        return this.f10487z.m22973b(i);
    }

    public int getItemViewType(int i) {
        if (m12363g(i)) {
            return ReactionViewTypeConstants.f18879b;
        }
        if (i > m12323g()) {
            if (this.f10458d.getInteractionTracker() != null) {
                ReactionInteractionTracker interactionTracker = this.f10458d.getInteractionTracker();
                if (interactionTracker.f16109n) {
                    interactionTracker.f16102g.f18800a.a(ReactionAnalyticsLogger.m22811a(Event.REACTION_SCROLLED_TO_BOTTOM, interactionTracker.f16107l.f18658a, "reaction_overlay", interactionTracker.f16107l.f18660c));
                    interactionTracker.f16109n = false;
                }
            }
            return ReactionViewTypeConstants.f18878a;
        } else if (i < m12321f() && m12331o()) {
            return i == m12325i() ? ReactionViewTypeConstants.f18880c : ReactionViewTypeConstants.f18881d;
        } else {
            return this.f10480s.getItemViewType(i - m12321f());
        }
    }

    protected boolean m12363g(int i) {
        return i > m12323g() && this.f10455a.f18673p;
    }

    public ViewHolder m12342a(ViewGroup viewGroup, int i) {
        if (i == ReactionViewTypeConstants.f18881d) {
            return new ReactionSimpleViewHolder(m12316b(viewGroup.getContext()));
        }
        if (i == ReactionViewTypeConstants.f18880c) {
            return new ReactionSimpleViewHolder(m12308a(viewGroup.getContext()));
        }
        ReactionLoadingViewHolder reactionLoadingViewHolder = null;
        if (i == ReactionViewTypeConstants.f18879b) {
            reactionLoadingViewHolder = new ReactionLoadingViewHolder(View.inflate(viewGroup.getContext(), 2130906703, null));
        } else if (i == ReactionViewTypeConstants.f18878a) {
            reactionLoadingViewHolder = new ReactionLoadingViewHolder(new View(viewGroup.getContext()));
        }
        ViewHolder viewHolder = reactionLoadingViewHolder;
        if (viewHolder == null) {
            return this.f10480s.a(viewGroup, i);
        }
        return viewHolder;
    }

    public final void m12346a(ViewHolder viewHolder, int i) {
        if (!(viewHolder instanceof ReactionSimpleViewHolder)) {
            if (viewHolder instanceof ReactionLoadingViewHolder) {
                m12332p();
                return;
            }
            int f = i - m12321f();
            this.f10480s.a(viewHolder, f);
            int s_ = this.f10480s.s_(f);
            if (s_ >= 0 && s_ < this.f10487z.m22967a()) {
                ReactionUnitDefaultFields k = this.f10487z.m22973b(s_).mo1117k();
                ReactionInteractionTracker interactionTracker = this.f10458d.getInteractionTracker();
                if (interactionTracker != null) {
                    interactionTracker.m18933a(k, s_, i);
                }
            }
        }
    }

    public final void m12345a(ViewHolder viewHolder) {
        super.a(viewHolder);
        MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
    }

    public boolean mo712a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return m12339c(reactionUnitFragment, str, cardSearchType);
    }

    public final boolean mo713a(String str, CardSearchType cardSearchType) {
        return m12339c(null, str, cardSearchType);
    }

    @Nullable
    public final ReactionUnitFragment mo707a(String str) {
        int b = m12354b(str, CardSearchType.UNIT_ID);
        if (b < 0 || b >= mo716e()) {
            return null;
        }
        return mo717e(b).mo1117k();
    }

    protected final Delegate m12370r() {
        return new C22513(this);
    }

    protected boolean m12358b(@Nullable ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        int b = m12354b(str, cardSearchType);
        if (b < 0) {
            return false;
        }
        m12350a(str, b);
        if (reactionUnitFragment != null) {
            m12349a(reactionUnitFragment, b);
        }
        return true;
    }

    private boolean m12339c(@Nullable ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        boolean b = m12358b(reactionUnitFragment, str, cardSearchType);
        if (b) {
            mo720k();
        }
        return b;
    }

    protected final int m12354b(String str, CardSearchType cardSearchType) {
        int f = m12321f();
        for (int i = f; i <= m12323g(); i++) {
            int s_ = this.f10480s.s_(i - f);
            if (s_ < 0 || s_ >= this.f10487z.m22967a()) {
                return -1;
            }
            ReactionUnitFragment k = this.f10487z.m22973b(s_).mo1117k();
            if (str.equals(cardSearchType == CardSearchType.SETTINGS_TOKEN ? k.j() : k.d())) {
                return s_;
            }
        }
        return -1;
    }

    public final void mo719j() {
        this.f10484w.b();
        this.f10487z.m22976c();
    }

    public final void mo721l() {
        this.f10484w.d();
    }

    public final void mo722m() {
        this.f10484w.e();
    }

    public final void mo723n() {
        this.f10484w.a();
    }

    public final void a_(RecyclerView recyclerView) {
        super.a_(recyclerView);
        this.f10477p = new NewsFeedStoryLikeClickSubscriber(this);
        this.f10476o.a(this.f10477p);
        this.f10470D = new C22524(this);
        this.f10476o.a(this.f10470D);
    }

    public final void m12355b(RecyclerView recyclerView) {
        super.b(recyclerView);
        this.f10476o.b(this.f10477p);
        this.f10476o.b(this.f10470D);
        this.f10482u.a();
    }

    public final int mo718f(int i) {
        if (i < 0 || this.f10480s == null) {
            return 0;
        }
        return this.f10480s.s_(i);
    }

    public final void mo708a(Configuration configuration) {
        if (this.f10480s != null) {
            this.f10480s.a(configuration);
        }
        notifyDataSetChanged();
    }

    protected void m12357b(ReactionStories reactionStories) {
        ImmutableList a = reactionStories.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitFragment a2 = ((EdgesModel) a.get(i)).a();
            if (a2 != null) {
                m12349a(a2, this.f10487z.m22967a());
            }
        }
    }

    public final void m12349a(ReactionUnitFragment reactionUnitFragment, int i) {
        GraphQLStory b = m12336b(reactionUnitFragment);
        if (b != null) {
            m12334a(b, reactionUnitFragment, i);
            return;
        }
        ReactionPagesFeedStoryNode c = m12338c(reactionUnitFragment);
        if (c != null) {
            m12335a(c, reactionUnitFragment, i);
            return;
        }
        if (m12337c(reactionUnitFragment, i) >= 0) {
            ReactionUnitFragment reactionUnitFragment2 = reactionUnitFragment;
            this.f10484w.a(this.f10483v, reactionUnitFragment.d(), new GraphQLResult(reactionUnitFragment2, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, ReactionUnitTagHelper.m22631a(reactionUnitFragment)));
        }
    }

    private void m12334a(GraphQLStory graphQLStory, ReactionUnitFragment reactionUnitFragment, int i) {
        FetchTimeMsHelper.a(graphQLStory, this.f10459e.a());
        this.f10487z.m22969a(i, new ReactionFeedStoryNode(graphQLStory, reactionUnitFragment));
        m12333a(graphQLStory, reactionUnitFragment);
    }

    private void m12335a(ReactionPagesFeedStoryNode reactionPagesFeedStoryNode, ReactionUnitFragment reactionUnitFragment, int i) {
        FetchTimeMsHelper.a(reactionPagesFeedStoryNode.mo1116f(), this.f10459e.a());
        this.f10487z.m22969a(i, reactionPagesFeedStoryNode);
        m12333a(reactionPagesFeedStoryNode.mo1116f(), reactionUnitFragment);
    }

    private void m12333a(GraphQLStory graphQLStory, ReactionUnitFragment reactionUnitFragment) {
        this.f10482u.a(graphQLStory, true);
        if (this.f10458d.getInteractionTracker() != null) {
            this.f10458d.getInteractionTracker().m18932a((ReactionUnitDefaultFields) reactionUnitFragment);
            ReactionInteractionTracker interactionTracker = this.f10458d.getInteractionTracker();
            String d = reactionUnitFragment.d();
            reactionUnitFragment.n();
            interactionTracker.mo983b(d, 1);
        }
    }

    private int m12337c(ReactionUnitFragment reactionUnitFragment, int i) {
        ReactionValidationResult a = this.f10463i.m22914a((ReactionUnitDefaultFields) reactionUnitFragment);
        if ("SUCCESS".equals(a.f18877d)) {
            this.f10487z.m22969a(i, new ReactionCardNode(reactionUnitFragment, a));
            if (this.f10458d.getInteractionTracker() == null) {
                return i;
            }
            this.f10458d.getInteractionTracker().m18932a((ReactionUnitDefaultFields) reactionUnitFragment);
            return i;
        }
        if (this.f10458d.getInteractionTracker() != null) {
            ReactionInteractionTracker interactionTracker = this.f10458d.getInteractionTracker();
            String str = a.f18877d;
            if (Strings.isNullOrEmpty(reactionUnitFragment.d()) || Strings.isNullOrEmpty(reactionUnitFragment.n())) {
                interactionTracker.f16098c.a(ReactionInteractionTracker.f16096a, "Null unit id or unit type when adding invalid story");
            } else {
                interactionTracker.f16115t.add(reactionUnitFragment.n());
                if (!Strings.isNullOrEmpty(str)) {
                    interactionTracker.f16114s.add(str);
                }
            }
        }
        return -1;
    }

    protected final void m12350a(String str, int i) {
        this.f10487z.m22977c(i);
        this.f10484w.b(str);
    }

    @Nullable
    @VisibleForTesting
    private static GraphQLStory m12336b(ReactionUnitFragment reactionUnitFragment) {
        ReactionAttachmentsModel fx_ = reactionUnitFragment.fx_();
        if (fx_ != null) {
            Object obj;
            if (GraphQLReactionStoryAttachmentsStyle.FEED_STORY_SINGLE == fx_.d()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                GraphQLStory l;
                ImmutableList b = fx_.b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    ReactionStoryAttachmentFragmentModel a = ((ReactionAttachmentsModel.EdgesModel) b.get(i)).a();
                    if (a != null && a.l() != null && !Strings.isNullOrEmpty(a.l().g())) {
                        l = a.l();
                        break;
                    }
                }
                l = null;
                return l;
            }
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    private static ReactionPagesFeedStoryNode m12338c(ReactionUnitFragment reactionUnitFragment) {
        ReactionAttachmentsModel fx_ = reactionUnitFragment.fx_();
        if (fx_ != null) {
            if ((GraphQLReactionStoryAttachmentsStyle.PAGE_POST_STORY == fx_.d() ? 1 : null) != null) {
                ImmutableList b = fx_.b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    ReactionStoryAttachmentFragmentModel a = ((ReactionAttachmentsModel.EdgesModel) b.get(i)).a();
                    if (a != null && a.B() != null && !Strings.isNullOrEmpty(a.B().g())) {
                        return new ReactionPagesFeedStoryNode(a.B(), reactionUnitFragment, a.t());
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final void mo720k() {
        this.f10480s.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    private FutureCallback<GraphQLResult<ReactionUnitFragment>> m12341u() {
        return new C22546(this);
    }
}
