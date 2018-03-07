package com.facebook.feedback.ui;

import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchCommentsParams;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.events.FeedbackEvents.LoadMoreCommentsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: routes= */
public class LoadMoreCommentsController {
    public EventsStream f4600a;
    public FeedbackErrorUtil f4601b;
    public FeedbackLoader f4602c;
    private TasksManager f4603d;
    private UfiPerfUtil f4604e;
    public InlineReplyExpansionExperimentUtil f4605f;

    /* compiled from: routes= */
    public class C04423 implements AsyncFunction<GraphQLFeedback, GraphQLFeedback> {
        final /* synthetic */ LoadMoreCommentsController f4599a;

        public C04423(LoadMoreCommentsController loadMoreCommentsController) {
            this.f4599a = loadMoreCommentsController;
        }

        public final ListenableFuture m5151a(@Nullable Object obj) {
            return this.f4599a.f4602c.a((GraphQLFeedback) obj);
        }
    }

    public static LoadMoreCommentsController m5152b(InjectorLike injectorLike) {
        return new LoadMoreCommentsController(EventsStream.a(injectorLike), FeedbackErrorUtil.m5076b(injectorLike), FeedbackLoader.a(injectorLike), TasksManager.b(injectorLike), UfiPerfUtil.a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike));
    }

    @Inject
    public LoadMoreCommentsController(EventsStream eventsStream, FeedbackErrorUtil feedbackErrorUtil, FeedbackLoader feedbackLoader, TasksManager tasksManager, UfiPerfUtil ufiPerfUtil, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f4600a = eventsStream;
        this.f4601b = feedbackErrorUtil;
        this.f4602c = feedbackLoader;
        this.f4603d = tasksManager;
        this.f4604e = ufiPerfUtil;
        this.f4605f = inlineReplyExpansionExperimentUtil;
    }

    public final void m5153a(final GraphQLFeedback graphQLFeedback, final CommentLoadDirection commentLoadDirection) {
        PerformanceLogger performanceLogger = this.f4604e.a;
        MarkerConfig a = new MarkerConfig(3735577, "UfiLoadMoreComments").a(new String[]{"story_feedback_flyout"});
        a.n = true;
        performanceLogger.c(a);
        this.f4603d.a((commentLoadDirection == CommentLoadDirection.LOAD_AFTER ? "fetch_after_comments_" : "fetch_before_comments_") + graphQLFeedback.z_(), new Callable<ListenableFuture>(this) {
            final /* synthetic */ LoadMoreCommentsController f4595c;

            public Object call() {
                String a;
                String str;
                LoadMoreCommentsController loadMoreCommentsController = this.f4595c;
                GraphQLFeedback graphQLFeedback = graphQLFeedback;
                CommentLoadDirection commentLoadDirection = commentLoadDirection;
                CommentOrderType order = CommentOrderType.getOrder(graphQLFeedback);
                if (commentLoadDirection == CommentLoadDirection.LOAD_AFTER) {
                    a = GraphQLHelper.h(graphQLFeedback).a();
                } else {
                    a = GraphQLHelper.h(graphQLFeedback).v_();
                }
                FeedbackLoader feedbackLoader = loadMoreCommentsController.f4602c;
                String z_ = graphQLFeedback.z_();
                String str2 = commentLoadDirection == CommentLoadDirection.LOAD_BEFORE ? a : null;
                if (commentLoadDirection == CommentLoadDirection.LOAD_BEFORE) {
                    str = null;
                } else {
                    str = a;
                }
                ListenableFuture a2 = GraphQLQueryExecutor.a(feedbackLoader.i.a(feedbackLoader.f.a(new FetchCommentsParams(z_, 25, str2, str, DataFreshnessParam.STALE_DATA_OKAY, order, commentLoadDirection))));
                if (order.equals(CommentOrderType.RANKED_ORDER) && loadMoreCommentsController.f4605f.b()) {
                    a2 = Futures.b(a2, new C04423(loadMoreCommentsController));
                }
                return a2;
            }
        }, new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
            final /* synthetic */ LoadMoreCommentsController f4598c;

            protected final void m5149a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback == null) {
                    m5150a(new NullPointerException("Fetch more comments returned null for id " + graphQLFeedback.z_()));
                } else {
                    this.f4598c.f4600a.a(new LoadMoreCommentsEvent(graphQLFeedback, commentLoadDirection));
                }
            }

            protected final void m5150a(Throwable th) {
                this.f4598c.f4601b.m5078a(th);
            }
        });
    }
}
