package com.facebook.feed.permalink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.permalink.PermalinkEventsBuilder;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.ufiservices.FetchSingleCommentParams;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.Sets;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.annotations.ForPermalink;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.events.FeedbackEvents.UpdateThreadedFeedbackEvent;
import com.facebook.feedback.ui.BaseCommentNavigationDelegate;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentAdapter;
import com.facebook.feedback.ui.CommentAdapterFactory;
import com.facebook.feedback.ui.CommentEventSubscriber;
import com.facebook.feedback.ui.CommentEventSubscriberProvider;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.CommentsHelperProvider;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.feedback.ui.ThreadedParentCommentNavigationDelegate;
import com.facebook.feedback.ui.ThreadedParentCommentNavigationDelegateProvider;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironmentProvider;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.abtest.Notifications2gImprovementsExperimentController;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorController;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin_tapped_photo */
public class ThreadedCommentsPermalinkFragment extends FbFragment implements AnalyticsFragment, AnalyticsFragmentWithExtraData, CanHandleBackPressed, FragmentWithDebugInfo, Bindable<GraphQLComment> {
    @Inject
    CommentAdapterFactory f19667a;
    private CommentEventSubscriber aA;
    public MultiAdapterListAdapter aB;
    private FetchSingleCommentParams aC;
    private Set<Bindable<FeedProps<GraphQLFeedback>>> aD;
    public final RetryClickedListener aE = new RetryTrigger(this);
    private LoadingIndicatorState aF;
    public LoadingIndicatorController aG;
    private boolean aH;
    public GraphQLComment aI;
    private GraphQLComment aJ;
    private FeedbackLoggingParams aK;
    public String aL;
    @Inject
    ObjectMapper al;
    @Inject
    BaseCommentsEnvironmentProvider am;
    @Inject
    public AnalyticsLogger an;
    @Inject
    public PermalinkEventsBuilder ao;
    @Inject
    Notifications2gImprovementsExperimentController ap;
    @Inject
    InlineReplyExpansionExperimentUtil aq;
    @Inject
    PermalinkThreadedCommentNavigationDelegateProvider ar;
    private BetterListView as;
    public FbSwipeRefreshLayout at;
    private LoadingIndicatorView au;
    private ContextThemeWrapper av;
    private BaseCommentsEnvironment aw;
    public CommentAdapter ax;
    public CommentsHelper ay;
    private ThreadedCommentsPermalinkAdapter az;
    @Inject
    CommentsHelperProvider f19668b;
    @Inject
    CommentEventSubscriberProvider f19669c;
    @Inject
    EventsStream f19670d;
    @Inject
    FeedbackControllerProvider f19671e;
    @Inject
    FeedbackMutator f19672f;
    @Inject
    ThreadedParentCommentNavigationDelegateProvider f19673g;
    @Inject
    @ForPermalink
    FeedLifecycleSubscribers f19674h;
    @Inject
    ThreadedCommentsPermalinkAdapterProvider f19675i;

    /* compiled from: admin_tapped_photo */
    class C17011 implements Runnable {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19660a;

        C17011(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19660a = threadedCommentsPermalinkFragment;
        }

        public void run() {
            AdapterDetour.a(this.f19660a.aB, 1710833785);
        }
    }

    /* compiled from: admin_tapped_photo */
    class C17022 implements ScrollingProxy {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19661a;

        C17022(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19661a = threadedCommentsPermalinkFragment;
        }

        public final int mo196a() {
            Preconditions.checkNotNull(this.f19661a.aB, "list adapter has not been initialized yet");
            return this.f19661a.aB.a(this.f19661a.ax);
        }
    }

    /* compiled from: admin_tapped_photo */
    class C17033 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19662a;

        C17033(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19662a = threadedCommentsPermalinkFragment;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            FeedbackMutator feedbackMutator = this.f19662a.f19672f;
            Builder a = Builder.a(this.f19662a.aI);
            a.o = graphQLFeedback;
            this.f19662a.m22942a(a.a());
            return null;
        }
    }

    /* compiled from: admin_tapped_photo */
    class C17044 implements Function<GraphQLComment, Void> {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19663a;

        C17044(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19663a = threadedCommentsPermalinkFragment;
        }

        public Object apply(@Nullable Object obj) {
            this.f19663a.m22942a((GraphQLComment) obj);
            return null;
        }
    }

    /* compiled from: admin_tapped_photo */
    class C17055 implements OnRefreshListener {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19664a;

        C17055(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19664a = threadedCommentsPermalinkFragment;
        }

        public final void m22929a() {
            ThreadedCommentsPermalinkFragment.aq(this.f19664a);
        }
    }

    /* compiled from: admin_tapped_photo */
    class C17066 extends AbstractDisposableFutureCallback<GraphQLComment> {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19665a;

        C17066(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19665a = threadedCommentsPermalinkFragment;
        }

        protected final void m22930a(Object obj) {
            ThreadedCommentsPermalinkFragment.m22935c(this.f19665a, (GraphQLComment) obj);
        }

        protected final void m22931a(Throwable th) {
            if (this.f19665a.hn_()) {
                this.f19665a.aG.a(this.f19665a.b(2131230811), this.f19665a.aE);
                if (this.f19665a.at != null) {
                    this.f19665a.at.setRefreshing(false);
                }
                if (this.f19665a.aI != null && this.f19665a.ap.b()) {
                    ThreadedCommentsPermalinkFragment.m22935c(this.f19665a, this.f19665a.aI);
                }
            }
        }
    }

    /* compiled from: admin_tapped_photo */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ ThreadedCommentsPermalinkFragment f19666a;

        public RetryTrigger(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
            this.f19666a = threadedCommentsPermalinkFragment;
        }

        public final void m22932a() {
            ThreadedCommentsPermalinkFragment.aq(this.f19666a);
        }
    }

    public static void m22934a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadedCommentsPermalinkFragment) obj).m22933a(CommentAdapterFactory.m4798a(injectorLike), (CommentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentsHelperProvider.class), (CommentEventSubscriberProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentEventSubscriberProvider.class), EventsStream.a(injectorLike), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FeedbackMutator.a(injectorLike), (ThreadedParentCommentNavigationDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadedParentCommentNavigationDelegateProvider.class), (FeedLifecycleSubscribers) MultiRowFeedLifecycleSubscribers.a(injectorLike), (ThreadedCommentsPermalinkAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThreadedCommentsPermalinkAdapterProvider.class), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (BaseCommentsEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PermalinkEventsBuilder.a(injectorLike), Notifications2gImprovementsExperimentController.a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike), (PermalinkThreadedCommentNavigationDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PermalinkThreadedCommentNavigationDelegateProvider.class));
    }

    private void m22933a(CommentAdapterFactory commentAdapterFactory, CommentsHelperProvider commentsHelperProvider, CommentEventSubscriberProvider commentEventSubscriberProvider, EventsStream eventsStream, FeedbackControllerProvider feedbackControllerProvider, FeedbackMutator feedbackMutator, ThreadedParentCommentNavigationDelegateProvider threadedParentCommentNavigationDelegateProvider, FeedLifecycleSubscribers feedLifecycleSubscribers, ThreadedCommentsPermalinkAdapterProvider threadedCommentsPermalinkAdapterProvider, ObjectMapper objectMapper, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, AnalyticsLogger analyticsLogger, PermalinkEventsBuilder permalinkEventsBuilder, Notifications2gImprovementsExperimentController notifications2gImprovementsExperimentController, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil, PermalinkThreadedCommentNavigationDelegateProvider permalinkThreadedCommentNavigationDelegateProvider) {
        this.f19667a = commentAdapterFactory;
        this.f19668b = commentsHelperProvider;
        this.f19669c = commentEventSubscriberProvider;
        this.f19670d = eventsStream;
        this.f19671e = feedbackControllerProvider;
        this.f19672f = feedbackMutator;
        this.f19673g = threadedParentCommentNavigationDelegateProvider;
        this.f19674h = feedLifecycleSubscribers;
        this.f19675i = threadedCommentsPermalinkAdapterProvider;
        this.al = objectMapper;
        this.am = baseCommentsEnvironmentProvider;
        this.an = analyticsLogger;
        this.ao = permalinkEventsBuilder;
        this.ap = notifications2gImprovementsExperimentController;
        this.aq = inlineReplyExpansionExperimentUtil;
        this.ar = permalinkThreadedCommentNavigationDelegateProvider;
    }

    public final void m22945c(Bundle bundle) {
        super.c(bundle);
        Class cls = ThreadedCommentsPermalinkFragment.class;
        m22934a((Object) this, getContext());
        if (bundle == null) {
            bundle = this.s;
        }
        if (bundle != null) {
            this.aC = (FetchSingleCommentParams) bundle.getParcelable("commentParams");
            this.aF = (LoadingIndicatorState) bundle.getParcelable("loadingState");
            this.aK = (FeedbackLoggingParams) bundle.getParcelable("feedbackLoggingParams");
        }
        this.aI = this.aC.h;
        this.aJ = this.aC.i;
        FeedbackLoggingParams.Builder a = FeedbackLoggingParams.Builder.a(this.aK);
        a.c = "story_view";
        a = a;
        a.b = "permalink_ufi";
        a = a;
        a.d = FeedbackDisplayType.THREADED_PERMALINK;
        this.aK = a.a();
        BaseCommentNavigationDelegate a2 = this.ar.m22919a(getContext());
        this.aw = this.am.m5348a(as(), a2, new C17011(this));
        this.ax = this.f19667a.m4801a(a2, this.aw, null);
        this.ay = this.f19668b.m4974a(this, this.ax, this.aw, new C17022(this), new C17033(this));
        this.ay.m4959a(this.aK);
        this.az = this.f19675i.m22927a(this.aC, new ThreadedParentCommentNavigationDelegate(a2, this.ay), this.aK);
        this.az.f19657h = 2131626110;
        this.ax.m4792a(this.aK);
        this.aB = MultiAdapterListAdapter.a(new FbListAdapter[]{this.az, this.ax});
        ((PermalinkThreadedCommentNavigationDelegate) a2).f19648a = this.ay;
        this.aG = new LoadingIndicatorController(this.aF, this.aE);
        this.aA = new CommentEventSubscriber(this.aC.b, new C17044(this), EventsStream.a(this.f19669c));
        this.aD = Sets.a(new Bindable[]{this.ay});
        this.aL = this.aC.j;
        if (!this.aH) {
            aq(this);
        }
    }

    public final View m22939a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -245776439);
        View inflate = LayoutInflater.from(as()).inflate(2130906173, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 228608984, a);
        return inflate;
    }

    public final void m22941a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.as = (BetterListView) e(2131558482);
        this.at = (FbSwipeRefreshLayout) e(2131565839);
        this.au = (LoadingIndicatorView) e(2131565840);
        this.as.setAdapter(this.aB);
        this.as.setEmptyView(this.au);
        this.at.e = new C17055(this);
        this.aG.a(this.au);
        this.ay.m4958a(view, new ListViewProxy(this.as));
        m22942a(this.aI);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1897081334);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131233577);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -116072689, a);
    }

    public final void m22940a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.ay.m4957a(i, i2, intent);
    }

    public final void m22936G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1305396539);
        super.G();
        this.f19674h.a();
        this.ay.m4969d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -345129881, a);
    }

    public final void m22937H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1859068381);
        super.H();
        this.ay.m4968c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 155659137, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 460805596);
        super.mY_();
        this.ay.m4956a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1967197302, a);
    }

    public final void m22938I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -576776301);
        super.I();
        CommentEventSubscriber commentEventSubscriber = this.aA;
        for (Subscription a2 : commentEventSubscriber.f4253b) {
            commentEventSubscriber.f4252a.a(a2);
        }
        commentEventSubscriber.f4253b.clear();
        this.ay.m4967b();
        this.ax.jc_();
        if (!(this.aI == null || this.aq.a())) {
            this.f19670d.a(new UpdateThreadedFeedbackEvent(this.aI.l(), this.aC.b));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1867343288, a);
    }

    public final void m22946e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("commentParams", this.aC);
        bundle.putParcelable("loadingState", this.aF);
    }

    public final void m22942a(GraphQLComment graphQLComment) {
        Object obj = null;
        this.aI = graphQLComment;
        this.az.m22925a(graphQLComment != null ? FeedProps.c(graphQLComment) : null);
        GraphQLFeedback l = graphQLComment == null ? null : graphQLComment.l();
        this.aA.m4860a(graphQLComment);
        if (!(this.ay == null || this.aI == null || this.aI.p() == null || !GraphQLStoryUtil.q(this.aI.p()))) {
            this.ay.m4962a(Long.valueOf(Long.parseLong(this.aI.p().aJ().b())));
        }
        l = CommentsHelper.m4953a(l, this.aC.g, this.aJ, this.ap);
        if (l != null) {
            obj = FeedProps.c(l);
        }
        for (Bindable a : this.aD) {
            a.mo198a(obj);
        }
    }

    public final boolean O_() {
        return this.ay != null && this.ay.m4966a(getContext());
    }

    public final Map<String, Object> m22944c() {
        Map<String, Object> hashMap = new HashMap();
        if (this.aL != null) {
            hashMap.put("source_group_id", this.aL);
        }
        return hashMap;
    }

    public static void aq(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment) {
        threadedCommentsPermalinkFragment.aG.a();
        threadedCommentsPermalinkFragment.f19671e.m5074a(FeedbackControllerParams.f4498a).m5070a(threadedCommentsPermalinkFragment.aC.b, threadedCommentsPermalinkFragment.aC.a, threadedCommentsPermalinkFragment.aC.g, threadedCommentsPermalinkFragment.aC.k, new C17066(threadedCommentsPermalinkFragment));
    }

    public static void m22935c(ThreadedCommentsPermalinkFragment threadedCommentsPermalinkFragment, GraphQLComment graphQLComment) {
        threadedCommentsPermalinkFragment.m22942a(graphQLComment);
        if (!(graphQLComment == null || threadedCommentsPermalinkFragment.aL == null)) {
            PermalinkEventsBuilder permalinkEventsBuilder = threadedCommentsPermalinkFragment.ao;
            String y = graphQLComment.y();
            String str = threadedCommentsPermalinkFragment.aL;
            HoneyClientEvent b = new HoneyClientEvent("story_permalink_opened").b("comment_id", y);
            b.c = "story_view";
            b = b;
            PermalinkEventsBuilder.a(b, str);
            threadedCommentsPermalinkFragment.an.a(b);
        }
        threadedCommentsPermalinkFragment.aG.b();
        if (threadedCommentsPermalinkFragment.at != null) {
            threadedCommentsPermalinkFragment.at.setRefreshing(false);
        }
        threadedCommentsPermalinkFragment.ay.m4964a(threadedCommentsPermalinkFragment.aC.g);
        threadedCommentsPermalinkFragment.aH = true;
    }

    public final String am_() {
        return "story_view";
    }

    public Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Comment Params", this.aC.l());
        hashMap.put("Has Fetched Feedback: ", this.aH ? "True" : "False");
        if (this.aI != null) {
            try {
                hashMap.put("Threaded Comments Permalink", this.al.g().a().a(this.aI));
            } catch (IOException e) {
            }
        }
        return hashMap;
    }

    private Context as() {
        if (this.av == null) {
            this.av = new ContextThemeWrapper(getContext(), 2131626112);
        }
        return this.av;
    }
}
