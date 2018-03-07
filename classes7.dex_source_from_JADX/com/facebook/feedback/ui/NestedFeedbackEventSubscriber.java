package com.facebook.feedback.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: route_name */
public class NestedFeedbackEventSubscriber implements FeedbackEventSubscriber {
    public final RootFeedbackEventSubscriberProvider f4623a;
    private final CommentFeedbackEventSubscriberProvider f4624b;
    public final Function<GraphQLFeedback, Void> f4625c;
    public final CommentAdapter f4626d;
    public final CommentListScrollStateController f4627e;
    public final FeedbackNewCommentsPillController f4628f;
    public final FeedbackTypingPillController f4629g;
    public final FeedbackMutator f4630h;
    public GraphQLFeedback f4631i;
    public FeedbackEventSubscriber f4632j;
    private Map<GraphQLComment, CommentFeedbackEventSubscriber> f4633k = new HashMap();

    /* compiled from: route_name */
    class C04451 implements Function<GraphQLComment, Void> {
        final /* synthetic */ NestedFeedbackEventSubscriber f4622a;

        C04451(NestedFeedbackEventSubscriber nestedFeedbackEventSubscriber) {
            this.f4622a = nestedFeedbackEventSubscriber;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            this.f4622a.f4625c.apply(this.f4622a.f4630h.c(this.f4622a.f4631i, (GraphQLComment) obj));
            return null;
        }
    }

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
        this.f4631i = graphQLFeedback;
        if (graphQLFeedback == null) {
            m5169b();
            return;
        }
        if (this.f4632j != null) {
            this.f4632j.mo198a(this.f4631i);
        } else {
            GraphQLFeedback graphQLFeedback2 = this.f4631i;
            this.f4632j = this.f4623a.m5222a(this.f4625c, this.f4626d, this.f4627e, this.f4628f, this.f4629g);
            this.f4632j.mo198a(graphQLFeedback2);
        }
        ImmutableList i = GraphQLHelper.i(this.f4631i);
        Iterator it = this.f4633k.entrySet().iterator();
        while (it.hasNext()) {
            GraphQLComment graphQLComment = (GraphQLComment) ((Entry) it.next()).getKey();
            if (!i.contains(graphQLComment)) {
                ((CommentFeedbackEventSubscriber) this.f4633k.get(graphQLComment)).m4871a();
                it.remove();
            }
        }
        ImmutableList i2 = GraphQLHelper.i(this.f4631i);
        int size = i2.size();
        for (int i3 = 0; i3 < size; i3++) {
            graphQLComment = (GraphQLComment) i2.get(i3);
            if (this.f4633k.containsKey(graphQLComment)) {
                ((CommentFeedbackEventSubscriber) this.f4633k.get(graphQLComment)).m4872a(graphQLComment);
            } else {
                m5168a(graphQLComment, new C04451(this));
            }
        }
    }

    @Inject
    public NestedFeedbackEventSubscriber(@Assisted Function<GraphQLFeedback, Void> function, @Assisted CommentAdapter commentAdapter, @Assisted CommentListScrollStateController commentListScrollStateController, @Assisted FeedbackNewCommentsPillController feedbackNewCommentsPillController, @Assisted FeedbackTypingPillController feedbackTypingPillController, RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, CommentFeedbackEventSubscriberProvider commentFeedbackEventSubscriberProvider, FeedbackMutator feedbackMutator) {
        this.f4625c = function;
        this.f4626d = commentAdapter;
        this.f4627e = commentListScrollStateController;
        this.f4623a = rootFeedbackEventSubscriberProvider;
        this.f4624b = commentFeedbackEventSubscriberProvider;
        this.f4630h = feedbackMutator;
        this.f4628f = feedbackNewCommentsPillController;
        this.f4629g = feedbackTypingPillController;
    }

    public final void mo234a() {
        m5169b();
    }

    private void m5169b() {
        if (this.f4632j != null) {
            this.f4632j.mo234a();
        }
        for (CommentFeedbackEventSubscriber a : this.f4633k.values()) {
            a.m4871a();
        }
        this.f4632j = null;
        this.f4633k.clear();
    }

    public final void m5171a(GraphQLComment graphQLComment) {
        this.f4625c.apply(this.f4630h.b(this.f4631i, graphQLComment));
    }

    private void m5168a(GraphQLComment graphQLComment, Function<GraphQLComment, Void> function) {
        CommentFeedbackEventSubscriberProvider commentFeedbackEventSubscriberProvider = this.f4624b;
        CommentFeedbackEventSubscriber commentFeedbackEventSubscriber = new CommentFeedbackEventSubscriber(function, EventsStream.a(commentFeedbackEventSubscriberProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(commentFeedbackEventSubscriberProvider), FeedbackMutator.a(commentFeedbackEventSubscriberProvider), UfiPerfUtil.a(commentFeedbackEventSubscriberProvider));
        this.f4633k.put(graphQLComment, commentFeedbackEventSubscriber);
        commentFeedbackEventSubscriber.m4872a(graphQLComment);
    }
}
