package com.facebook.feedback.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.events.FeedbackEvents.LoadMoreCommentsEvent;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.feedback.events.FeedbackEvents.UpdateThreadedFeedbackEvent;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.offlinemode.comments.OfflineCommentsExecutorHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.event.CommentEvents.AddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.DeleteCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionAddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionAddPublicContentCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.GraphQLSubscriptionFriendsTypingEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: rotated_stickers_count */
public class RootFeedbackEventSubscriber implements FeedbackEventSubscriber {
    public static final String f4670a = RootFeedbackEventSubscriber.class.getName();
    public final Function<GraphQLFeedback, Void> f4671b;
    public final CommentAdapter f4672c;
    public final CommentListScrollStateController f4673d;
    public final AbstractFbErrorReporter f4674e;
    public final FeedbackNewCommentsPillController f4675f;
    private final FeedbackTypingPillController f4676g;
    private final EventsStream f4677h;
    public final FeedbackMutator f4678i;
    public final UfiPerfUtil f4679j;
    private final OfflineCommentsExecutorHelper f4680k;
    private final List<Subscription> f4681l = new ArrayList();
    public final FeedbackEventSubscriberDelegate f4682m;
    public final QeAccessor f4683n;
    public final Lazy<FBSoundUtil> f4684o;
    public TypingIndicatorController f4685p;
    public GraphQLFeedback f4686q;
    private boolean f4687r;

    /* compiled from: rotated_stickers_count */
    class C04471 implements Action<AddCommentEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4659a;

        C04471(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4659a = rootFeedbackEventSubscriber;
        }

        public final void m5191a(Object obj) {
            GraphQLComment graphQLComment = ((AddCommentEvent) obj).a;
            this.f4659a.f4682m.mo236a(graphQLComment);
            if (this.f4659a.f4673d != null) {
                this.f4659a.f4673d.m4880a(graphQLComment);
            }
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04482 implements Action<UpdateCommentEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4660a;

        C04482(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4660a = rootFeedbackEventSubscriber;
        }

        public final void m5192a(Object obj) {
            UpdateCommentEvent updateCommentEvent = (UpdateCommentEvent) obj;
            if (updateCommentEvent.a.l() == null) {
                this.f4660a.f4674e.b(RootFeedbackEventSubscriber.f4670a, "Updated comment must have a non null feedback");
            } else {
                this.f4660a.f4682m.mo238a(updateCommentEvent);
            }
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04493 implements Action<DeleteCommentEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4661a;

        C04493(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4661a = rootFeedbackEventSubscriber;
        }

        public final void m5193a(Object obj) {
            this.f4661a.f4682m.mo237a((DeleteCommentEvent) obj);
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04504 implements Action<LoadMoreCommentsEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4662a;

        C04504(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4662a = rootFeedbackEventSubscriber;
        }

        public final void m5194a(Object obj) {
            LoadMoreCommentsEvent loadMoreCommentsEvent = (LoadMoreCommentsEvent) obj;
            if (this.f4662a.f4673d != null) {
                CommentListScrollStateController commentListScrollStateController = this.f4662a.f4673d;
                int i = 0;
                if (commentListScrollStateController.f4281c != null) {
                    int q = commentListScrollStateController.f4281c.q();
                    int p = (commentListScrollStateController.f4281c.p() + q) - 1;
                    int a = commentListScrollStateController.f4280b.mo196a();
                    int count = (commentListScrollStateController.f4279a.getCount() + a) - 1;
                    if ((Math.min(p, count) >= Math.max(q, a) ? 1 : 0) != 0) {
                        while (i < commentListScrollStateController.f4281c.p()) {
                            p = q + i;
                            if (p >= a && p <= count) {
                                GraphQLComment c = commentListScrollStateController.f4279a.m4796c(p - a);
                                if (c != null) {
                                    commentListScrollStateController.f4283e = commentListScrollStateController.f4281c.f(i).getTop();
                                    commentListScrollStateController.f4282d = c;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                }
            }
            this.f4662a.f4671b.apply(this.f4662a.f4678i.a(this.f4662a.f4686q, loadMoreCommentsEvent.a, loadMoreCommentsEvent.a));
            this.f4662a.f4679j.E();
            if (this.f4662a.f4673d != null) {
                this.f4662a.f4673d.m4882e();
            }
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04515 implements Action<UpdateThreadedFeedbackEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4663a;

        C04515(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4663a = rootFeedbackEventSubscriber;
        }

        public final void m5195a(Object obj) {
            this.f4663a.f4682m.mo235a((UpdateThreadedFeedbackEvent) obj);
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04526 implements Action<UpdateLikeFeedbackEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4664a;

        C04526(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4664a = rootFeedbackEventSubscriber;
        }

        public final void m5196a(Object obj) {
            UpdateLikeFeedbackEvent updateLikeFeedbackEvent = (UpdateLikeFeedbackEvent) obj;
            FeedbackMutator feedbackMutator = this.f4664a.f4678i;
            this.f4664a.f4671b.apply(FeedbackMutator.a(this.f4664a.f4686q, updateLikeFeedbackEvent.a));
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04537 implements Action<GraphQLSubscriptionAddCommentEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4665a;

        C04537(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4665a = rootFeedbackEventSubscriber;
        }

        public final void m5197a(Object obj) {
            GraphQLComment graphQLComment = ((GraphQLSubscriptionAddCommentEvent) obj).a;
            boolean a = GraphQLHelper.a(this.f4665a.f4686q, graphQLComment);
            this.f4665a.f4682m.mo236a(graphQLComment);
            if (this.f4665a.f4675f != null && this.f4665a.f4672c != null && !a) {
                this.f4665a.f4675f.m5124a(graphQLComment);
                this.f4665a.f4672c.m4793a(graphQLComment);
                if (this.f4665a.f4683n.a(ExperimentsForFeedbackTestModule.u, false)) {
                    ((FBSoundUtil) this.f4665a.f4684o.get()).b("live_comment");
                }
            }
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04548 implements Action<GraphQLSubscriptionAddPublicContentCommentEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4666a;

        C04548(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4666a = rootFeedbackEventSubscriber;
        }

        public final void m5198a(Object obj) {
            GraphQLComment graphQLComment = ((GraphQLSubscriptionAddPublicContentCommentEvent) obj).a;
            boolean a = GraphQLHelper.a(this.f4666a.f4686q, graphQLComment);
            this.f4666a.f4682m.mo239b(graphQLComment);
            if (this.f4666a.f4675f != null && this.f4666a.f4672c != null && !a) {
                this.f4666a.f4675f.m5124a(graphQLComment);
                this.f4666a.f4672c.m4793a(graphQLComment);
                if (this.f4666a.f4683n.a(ExperimentsForFeedbackTestModule.u, true)) {
                    ((FBSoundUtil) this.f4666a.f4684o.get()).b("live_comment");
                }
            }
        }
    }

    /* compiled from: rotated_stickers_count */
    class C04559 implements Action<GraphQLSubscriptionFriendsTypingEvent> {
        final /* synthetic */ RootFeedbackEventSubscriber f4667a;

        C04559(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4667a = rootFeedbackEventSubscriber;
        }

        public final void m5199a(Object obj) {
            this.f4667a.f4685p.m5325a(((GraphQLSubscriptionFriendsTypingEvent) obj).a);
        }
    }

    /* compiled from: rotated_stickers_count */
    interface FeedbackEventSubscriberDelegate {
        void mo235a(UpdateThreadedFeedbackEvent updateThreadedFeedbackEvent);

        void mo236a(GraphQLComment graphQLComment);

        void mo237a(DeleteCommentEvent deleteCommentEvent);

        void mo238a(UpdateCommentEvent updateCommentEvent);

        void mo239b(GraphQLComment graphQLComment);
    }

    /* compiled from: rotated_stickers_count */
    class DefaultDelegate implements FeedbackEventSubscriberDelegate {
        final /* synthetic */ RootFeedbackEventSubscriber f4668a;

        public final void mo238a(UpdateCommentEvent updateCommentEvent) {
            Object l;
            GraphQLComment graphQLComment = updateCommentEvent.a;
            if (StringUtil.a(this.f4668a.f4686q.z_(), graphQLComment.l().z_())) {
                l = graphQLComment.l();
            } else {
                l = this.f4668a.f4678i.c(this.f4668a.f4686q, updateCommentEvent.a);
            }
            this.f4668a.f4671b.apply(l);
        }

        public DefaultDelegate(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4668a = rootFeedbackEventSubscriber;
        }

        public final void mo236a(GraphQLComment graphQLComment) {
            this.f4668a.f4671b.apply(this.f4668a.f4678i.c(this.f4668a.f4686q, graphQLComment));
        }

        public final void mo239b(GraphQLComment graphQLComment) {
            this.f4668a.f4671b.apply(this.f4668a.f4678i.d(this.f4668a.f4686q, graphQLComment));
        }

        public final void mo237a(DeleteCommentEvent deleteCommentEvent) {
            this.f4668a.f4671b.apply(this.f4668a.f4678i.e(this.f4668a.f4686q, deleteCommentEvent.a));
        }

        public final void mo235a(UpdateThreadedFeedbackEvent updateThreadedFeedbackEvent) {
            this.f4668a.f4671b.apply(this.f4668a.f4678i.b(this.f4668a.f4686q, updateThreadedFeedbackEvent.a));
        }
    }

    /* compiled from: rotated_stickers_count */
    class RecentCommentsDelegate implements FeedbackEventSubscriberDelegate {
        final /* synthetic */ RootFeedbackEventSubscriber f4669a;

        public final void mo238a(UpdateCommentEvent updateCommentEvent) {
            Object l;
            GraphQLComment graphQLComment = updateCommentEvent.a;
            if (StringUtil.a(this.f4669a.f4686q.z_(), graphQLComment.l().z_())) {
                l = graphQLComment.l();
            } else if (GraphQLHelper.a(this.f4669a.f4686q, graphQLComment)) {
                l = this.f4669a.f4678i.b(this.f4669a.f4686q, graphQLComment);
            } else if (this.f4669a.f4672c != null) {
                CommentAdapter commentAdapter = this.f4669a.f4672c;
                if (commentAdapter.f4173e != null) {
                    commentAdapter.f4173e = commentAdapter.f4173e.b(commentAdapter.f4172d.b((GraphQLFeedback) commentAdapter.f4173e.a, graphQLComment));
                    commentAdapter.f4174f.mo198a(commentAdapter.f4173e);
                }
                return;
            } else {
                return;
            }
            this.f4669a.f4671b.apply(l);
        }

        public RecentCommentsDelegate(RootFeedbackEventSubscriber rootFeedbackEventSubscriber) {
            this.f4669a = rootFeedbackEventSubscriber;
        }

        public final void mo236a(GraphQLComment graphQLComment) {
            GraphQLPageInfo h = GraphQLHelper.h(this.f4669a.f4686q);
            if (GraphQLHelper.a(this.f4669a.f4686q, graphQLComment) || h == null || !h.c() || this.f4669a.f4672c == null) {
                this.f4669a.f4671b.apply(this.f4669a.f4678i.c(this.f4669a.f4686q, graphQLComment));
                return;
            }
            CommentAdapter commentAdapter = this.f4669a.f4672c;
            if (commentAdapter.f4173e != null) {
                commentAdapter.f4173e = commentAdapter.f4173e.b(commentAdapter.f4172d.c((GraphQLFeedback) commentAdapter.f4173e.a, graphQLComment));
                commentAdapter.f4174f.mo198a(commentAdapter.f4173e);
            }
        }

        public final void mo239b(GraphQLComment graphQLComment) {
            this.f4669a.f4671b.apply(this.f4669a.f4678i.d(this.f4669a.f4686q, graphQLComment));
        }

        public final void mo237a(DeleteCommentEvent deleteCommentEvent) {
            GraphQLFeedback e = this.f4669a.f4678i.e(this.f4669a.f4686q, deleteCommentEvent.a);
            if (this.f4669a.f4672c != null) {
                CommentAdapter commentAdapter = this.f4669a.f4672c;
                GraphQLComment graphQLComment = deleteCommentEvent.a;
                if (commentAdapter.f4173e != null) {
                    commentAdapter.f4173e = commentAdapter.f4173e.b(commentAdapter.f4172d.e((GraphQLFeedback) commentAdapter.f4173e.a, graphQLComment));
                    commentAdapter.f4174f.mo198a(commentAdapter.f4173e);
                }
            }
            this.f4669a.f4671b.apply(e);
        }

        public final void mo235a(UpdateThreadedFeedbackEvent updateThreadedFeedbackEvent) {
            GraphQLFeedback b = this.f4669a.f4678i.b(this.f4669a.f4686q, updateThreadedFeedbackEvent.a);
            if (this.f4669a.f4672c != null) {
                CommentAdapter commentAdapter = this.f4669a.f4672c;
                GraphQLFeedback graphQLFeedback = updateThreadedFeedbackEvent.a;
                if (commentAdapter.f4173e != null) {
                    commentAdapter.f4173e = commentAdapter.f4173e.b(commentAdapter.f4172d.b((GraphQLFeedback) commentAdapter.f4173e.a, graphQLFeedback));
                    commentAdapter.f4174f.mo198a(commentAdapter.f4173e);
                }
            }
            this.f4669a.f4671b.apply(b);
        }
    }

    @Inject
    public RootFeedbackEventSubscriber(@Assisted Function<GraphQLFeedback, Void> function, @Assisted CommentAdapter commentAdapter, @Assisted CommentListScrollStateController commentListScrollStateController, @Assisted FeedbackNewCommentsPillController feedbackNewCommentsPillController, @Assisted FeedbackTypingPillController feedbackTypingPillController, EventsStream eventsStream, FbErrorReporter fbErrorReporter, FeedbackMutator feedbackMutator, UfiPerfUtil ufiPerfUtil, OfflineCommentsExecutorHelper offlineCommentsExecutorHelper, QeAccessor qeAccessor, Lazy<FBSoundUtil> lazy, TypingIndicatorControllerProvider typingIndicatorControllerProvider) {
        this.f4671b = function;
        this.f4672c = commentAdapter;
        this.f4673d = commentListScrollStateController;
        this.f4674e = fbErrorReporter;
        this.f4677h = eventsStream;
        this.f4678i = feedbackMutator;
        this.f4679j = ufiPerfUtil;
        this.f4680k = offlineCommentsExecutorHelper;
        this.f4675f = feedbackNewCommentsPillController;
        this.f4676g = feedbackTypingPillController;
        this.f4683n = qeAccessor;
        this.f4682m = qeAccessor.a(ExperimentsForFeedbackTestModule.f, false) ? new RecentCommentsDelegate(this) : new DefaultDelegate(this);
        this.f4684o = lazy;
        if (this.f4673d != null) {
            this.f4685p = typingIndicatorControllerProvider.m5326a(this.f4673d, this.f4676g, this.f4672c);
        }
    }

    public final void m5220a(GraphQLFeedback graphQLFeedback) {
        this.f4686q = graphQLFeedback;
        if (graphQLFeedback == null) {
            m5216c();
        } else if (!this.f4687r) {
            m5217d();
        }
    }

    public final void mo234a() {
        m5216c();
    }

    private void m5216c() {
        for (Subscription a : this.f4681l) {
            this.f4677h.a(a);
        }
        this.f4681l.clear();
        this.f4680k.b.remove(this);
        this.f4687r = false;
        if (this.f4685p != null) {
            TypingIndicatorController typingIndicatorController = this.f4685p;
            HandlerDetour.a(typingIndicatorController.f4788d, typingIndicatorController.f4790f);
            typingIndicatorController.f4791g.b(FunnelRegistry.t);
        }
    }

    private void m5217d() {
        m5215a(AddCommentEvent.class, new C04471(this));
        m5215a(UpdateCommentEvent.class, new C04482(this));
        m5215a(DeleteCommentEvent.class, new C04493(this));
        m5215a(LoadMoreCommentsEvent.class, new C04504(this));
        m5215a(UpdateThreadedFeedbackEvent.class, new C04515(this));
        m5215a(UpdateLikeFeedbackEvent.class, new C04526(this));
        m5215a(GraphQLSubscriptionAddCommentEvent.class, new C04537(this));
        m5215a(GraphQLSubscriptionAddPublicContentCommentEvent.class, new C04548(this));
        if (this.f4673d != null && (this.f4683n.a(ExperimentsForFeedbackTestModule.Y, false) || this.f4683n.a(ExperimentsForFeedbackTestModule.X, false))) {
            TypingIndicatorController typingIndicatorController = this.f4685p;
            typingIndicatorController.f4791g.a(FunnelRegistry.t);
            typingIndicatorController.f4791g.a(FunnelRegistry.t, typingIndicatorController.f4792h ? "Typing_Indicator_Cell_Shown_With_Text" : "Typing_Indicator_Cell_Shown_Without_Text");
            typingIndicatorController.f4791g.b(FunnelRegistry.t, "Viewing_Comments");
            m5215a(GraphQLSubscriptionFriendsTypingEvent.class, new C04559(this));
        }
        this.f4680k.a(this);
        this.f4687r = true;
    }

    public final void m5219a(GraphQLComment graphQLComment) {
        this.f4671b.apply(this.f4678i.b(this.f4686q, graphQLComment));
    }

    private <E extends KeyedEvent<String>> void m5215a(Class<E> cls, Action<E> action) {
        Subscription a = this.f4677h.a(cls, this.f4686q.z_(), action);
        Subscription a2 = this.f4677h.a(cls, this.f4686q.j(), action);
        this.f4681l.add(a);
        this.f4681l.add(a2);
    }
}
