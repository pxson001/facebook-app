package com.facebook.feedback.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feedback.events.FeedbackEvents.LoadMoreCommentsEvent;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLInterestingRepliesConnection;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.event.CommentEvents.AddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.DeleteCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: section_load_error */
public class CommentFeedbackEventSubscriber {
    public static final String f4263a = CommentFeedbackEventSubscriber.class.getName();
    public final Function<GraphQLComment, Void> f4264b;
    public final AbstractFbErrorReporter f4265c;
    private final EventsStream f4266d;
    public final FeedbackMutator f4267e;
    public final UfiPerfUtil f4268f;
    private final List<Subscription> f4269g = new ArrayList();
    public GraphQLComment f4270h;
    private boolean f4271i;

    /* compiled from: section_load_error */
    class C03811 implements Action<AddCommentEvent> {
        final /* synthetic */ CommentFeedbackEventSubscriber f4258a;

        C03811(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber) {
            this.f4258a = commentFeedbackEventSubscriber;
        }

        public final void m4862a(Object obj) {
            GraphQLFeedback a = this.f4258a.f4267e.a(this.f4258a.f4270h.l(), ((AddCommentEvent) obj).a);
            Builder a2 = Builder.a(this.f4258a.f4270h);
            a2.o = a;
            this.f4258a.f4264b.apply(a2.a());
        }
    }

    /* compiled from: section_load_error */
    class C03822 implements Action<UpdateCommentEvent> {
        final /* synthetic */ CommentFeedbackEventSubscriber f4259a;

        C03822(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber) {
            this.f4259a = commentFeedbackEventSubscriber;
        }

        public final void m4863a(Object obj) {
            UpdateCommentEvent updateCommentEvent = (UpdateCommentEvent) obj;
            GraphQLComment graphQLComment = updateCommentEvent.a;
            if (graphQLComment.l() == null) {
                this.f4259a.f4265c.b(CommentFeedbackEventSubscriber.f4263a, "Updated comment must have a non null feedback");
            } else if (StringUtil.a(this.f4259a.f4270h.l().z_(), graphQLComment.l().z_())) {
                this.f4259a.f4264b.apply(graphQLComment);
            } else {
                GraphQLFeedback b = this.f4259a.f4267e.b(this.f4259a.f4270h.l(), updateCommentEvent.a);
                Builder a = Builder.a(this.f4259a.f4270h);
                a.o = b;
                Builder builder = a;
                if (this.f4259a.f4270h.z() != null) {
                    builder.q = CommentFeedbackEventSubscriber.m4867a(this.f4259a, this.f4259a.f4270h.z(), graphQLComment, ReplyModifyType.UPDATE);
                }
                this.f4259a.f4264b.apply(builder.a());
            }
        }
    }

    /* compiled from: section_load_error */
    class C03833 implements Action<DeleteCommentEvent> {
        final /* synthetic */ CommentFeedbackEventSubscriber f4260a;

        C03833(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber) {
            this.f4260a = commentFeedbackEventSubscriber;
        }

        public final void m4864a(Object obj) {
            DeleteCommentEvent deleteCommentEvent = (DeleteCommentEvent) obj;
            GraphQLFeedback e = this.f4260a.f4267e.e(this.f4260a.f4270h.l(), deleteCommentEvent.a);
            Builder a = Builder.a(this.f4260a.f4270h);
            a.o = e;
            Builder builder = a;
            if (this.f4260a.f4270h.z() != null) {
                builder.q = CommentFeedbackEventSubscriber.m4867a(this.f4260a, this.f4260a.f4270h.z(), deleteCommentEvent.a, ReplyModifyType.DELETE);
            }
            this.f4260a.f4264b.apply(builder.a());
        }
    }

    /* compiled from: section_load_error */
    class C03844 implements Action<UpdateLikeFeedbackEvent> {
        final /* synthetic */ CommentFeedbackEventSubscriber f4261a;

        C03844(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber) {
            this.f4261a = commentFeedbackEventSubscriber;
        }

        public final void m4865a(Object obj) {
            UpdateLikeFeedbackEvent updateLikeFeedbackEvent = (UpdateLikeFeedbackEvent) obj;
            FeedbackMutator feedbackMutator = this.f4261a.f4267e;
            GraphQLFeedback a = FeedbackMutator.a(this.f4261a.f4270h.l(), updateLikeFeedbackEvent.a);
            Builder a2 = Builder.a(this.f4261a.f4270h);
            a2.o = a;
            this.f4261a.f4264b.apply(a2.a());
        }
    }

    /* compiled from: section_load_error */
    class C03855 implements Action<LoadMoreCommentsEvent> {
        final /* synthetic */ CommentFeedbackEventSubscriber f4262a;

        C03855(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber) {
            this.f4262a = commentFeedbackEventSubscriber;
        }

        public final void m4866a(Object obj) {
            LoadMoreCommentsEvent loadMoreCommentsEvent = (LoadMoreCommentsEvent) obj;
            GraphQLFeedback a = this.f4262a.f4267e.a(this.f4262a.f4270h.l(), loadMoreCommentsEvent.a, loadMoreCommentsEvent.a);
            Builder a2 = Builder.a(this.f4262a.f4270h);
            a2.o = a;
            this.f4262a.f4264b.apply(a2.a());
            this.f4262a.f4268f.E();
        }
    }

    /* compiled from: section_load_error */
    enum ReplyModifyType {
        UPDATE,
        DELETE
    }

    @Inject
    public CommentFeedbackEventSubscriber(@Assisted Function<GraphQLComment, Void> function, EventsStream eventsStream, FbErrorReporter fbErrorReporter, FeedbackMutator feedbackMutator, UfiPerfUtil ufiPerfUtil) {
        this.f4264b = function;
        this.f4265c = fbErrorReporter;
        this.f4266d = eventsStream;
        this.f4267e = feedbackMutator;
        this.f4268f = ufiPerfUtil;
    }

    public final void m4872a(GraphQLComment graphQLComment) {
        this.f4270h = graphQLComment;
        if (graphQLComment == null || graphQLComment.l() == null) {
            m4869c();
        } else if (!this.f4271i) {
            m4870d();
        }
    }

    public final void m4871a() {
        m4869c();
    }

    private void m4869c() {
        for (Subscription a : this.f4269g) {
            this.f4266d.a(a);
        }
        this.f4269g.clear();
        this.f4271i = false;
    }

    private void m4870d() {
        m4868a(AddCommentEvent.class, new C03811(this));
        m4868a(UpdateCommentEvent.class, new C03822(this));
        m4868a(DeleteCommentEvent.class, new C03833(this));
        m4868a(UpdateLikeFeedbackEvent.class, new C03844(this));
        m4868a(LoadMoreCommentsEvent.class, new C03855(this));
        this.f4271i = true;
    }

    public static GraphQLInterestingRepliesConnection m4867a(CommentFeedbackEventSubscriber commentFeedbackEventSubscriber, GraphQLInterestingRepliesConnection graphQLInterestingRepliesConnection, GraphQLComment graphQLComment, ReplyModifyType replyModifyType) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int a = graphQLInterestingRepliesConnection.a();
        ImmutableList j = graphQLInterestingRepliesConnection.j();
        int size = j.size();
        int i = 0;
        while (i < size) {
            int i2;
            GraphQLComment graphQLComment2 = (GraphQLComment) j.get(i);
            if (!graphQLComment.equals(graphQLComment2)) {
                builder.c(graphQLComment2);
                i2 = a;
            } else if (replyModifyType.equals(ReplyModifyType.UPDATE)) {
                builder.c(graphQLComment);
                i2 = a;
            } else {
                i2 = replyModifyType.equals(ReplyModifyType.DELETE) ? a - 1 : a;
            }
            i++;
            a = i2;
        }
        GraphQLInterestingRepliesConnection z = commentFeedbackEventSubscriber.f4270h.z();
        GraphQLInterestingRepliesConnection.Builder builder2 = new GraphQLInterestingRepliesConnection.Builder();
        z.h();
        builder2.d = z.a();
        builder2.e = z.j();
        BaseModel.Builder.a(builder2, z);
        GraphQLInterestingRepliesConnection.Builder builder3 = builder2;
        builder3.e = builder.b();
        builder3 = builder3;
        builder3.d = a;
        return new GraphQLInterestingRepliesConnection(builder3);
    }

    private <E extends KeyedEvent<String>> void m4868a(Class<E> cls, Action<E> action) {
        if (this.f4270h.l().z_() != null) {
            this.f4269g.add(this.f4266d.a(cls, this.f4270h.l().z_(), action));
        }
        if (this.f4270h.l().j() != null) {
            this.f4269g.add(this.f4266d.a(cls, this.f4270h.l().j(), action));
        }
    }
}
