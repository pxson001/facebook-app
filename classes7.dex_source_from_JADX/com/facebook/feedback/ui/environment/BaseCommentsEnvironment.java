package com.facebook.feedback.ui.environment;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.impl.HasInvalidateImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.ui.BaseCommentNavigationDelegate;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.CommentDelegate.C03732;
import com.facebook.feedback.ui.LoadMoreCommentsController;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ridgebase */
public class BaseCommentsEnvironment implements HasContext, HasInvalidate, HasPersistentState, Bindable, AnyEnvironment, DirtyUnitObserver {
    @Nullable
    public Context f4804a;
    @Nullable
    public BaseCommentNavigationDelegate f4805b;
    public final CommentDelegate f4806c;
    public final LoadMoreCommentsController f4807d;
    @Nullable
    private HasInvalidateImpl f4808e;
    private final HasPersistentStateImpl f4809f;
    @Nullable
    public FeedbackLoggingParams f4810g;
    @Nullable
    public NotificationLogObject f4811h;
    @Nullable
    public CommentStylingResolver f4812i;
    private final InlineReplyExpansionExperimentUtil f4813j;
    @Nullable
    public String f4814k;

    @Inject
    public BaseCommentsEnvironment(@Assisted Context context, @Assisted BaseCommentNavigationDelegate baseCommentNavigationDelegate, @Assisted Runnable runnable, CommentDelegate commentDelegate, LoadMoreCommentsController loadMoreCommentsController, HasInvalidateImplProvider hasInvalidateImplProvider, HasPersistentStateImpl hasPersistentStateImpl, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f4804a = context;
        this.f4805b = baseCommentNavigationDelegate;
        this.f4806c = commentDelegate;
        this.f4807d = loadMoreCommentsController;
        this.f4808e = HasInvalidateImplProvider.a(runnable);
        this.f4809f = hasPersistentStateImpl;
        this.f4813j = inlineReplyExpansionExperimentUtil;
        this.f4812i = new CommentStylingResolver(context);
    }

    public final void m5335a() {
        this.f4804a = null;
        this.f4805b = null;
        this.f4808e = null;
        this.f4810g = null;
        this.f4811h = null;
        this.f4812i = null;
    }

    public final void m5337a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
        this.f4806c.m4852a(graphQLComment, graphQLFeedback);
    }

    public final void m5338a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction) {
        CommentDelegate commentDelegate = this.f4806c;
        GraphQLFeedback a = commentDelegate.f4246w.a(commentDelegate.f4245v.a(), graphQLComment.l(), ReactionsMutationController.a(graphQLComment.l(), FeedbackReaction.a(graphQLComment.l()).intValue(), feedbackReaction).a());
        Builder builder = new Builder();
        builder = Builder.a(graphQLComment);
        builder.o = a;
        commentDelegate.f4225b.a(new UpdateCommentEvent(builder.a(), graphQLFeedback.z_()));
        commentDelegate.f4247x.a(graphQLComment.l(), feedbackReaction, commentDelegate.f4248y, new C03732(commentDelegate, graphQLComment, graphQLFeedback));
    }

    public final void m5346b(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
        if (this.f4813j.c()) {
            if (graphQLComment.l() != null) {
                this.f4814k = graphQLComment.l().z_();
                hL_();
            }
        } else if (this.f4805b != null) {
            this.f4805b.mo225a(graphQLComment, graphQLFeedback, this.f4810g);
        }
    }

    public final void m5336a(GraphQLComment graphQLComment) {
        if (this.f4805b != null) {
            this.f4805b.m4707a(graphQLComment);
        }
    }

    public final void m5345b(GraphQLComment graphQLComment) {
        if (this.f4805b != null) {
            this.f4805b.mo226b(graphQLComment);
        }
    }

    public final void m5339a(GraphQLComment graphQLComment, String str, String str2) {
        if (this.f4805b != null) {
            this.f4805b.mo223a(this.f4804a, str, str2);
        }
    }

    public final void m5347e(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
        this.f4806c.m4853a(graphQLComment, graphQLFeedback, this.f4804a);
    }

    @Nullable
    public Context getContext() {
        return this.f4804a;
    }

    public final <K, T> T m5333a(ContextStateKey<K, T> contextStateKey) {
        return this.f4809f.a(contextStateKey);
    }

    public final <K, T> T m5334a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f4809f.a(contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean m5344a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f4809f.a(contextStateKey, t);
    }

    public final void hL_() {
        if (this.f4808e != null) {
            this.f4808e.hL_();
        }
    }

    public final void m5343a(Object... objArr) {
        if (this.f4808e != null) {
            this.f4808e.a(objArr);
        }
    }

    public final void m5342a(FeedProps... feedPropsArr) {
        if (this.f4808e != null) {
            this.f4808e.a(feedPropsArr);
        }
    }

    public final void m5340a(@Nullable DirtyListener dirtyListener) {
        if (this.f4808e != null) {
            this.f4808e.a(dirtyListener);
        }
    }

    public final void a_(boolean z) {
        if (this.f4808e != null) {
            this.f4808e.a_(z);
        }
    }
}
