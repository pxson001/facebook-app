package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: rewrite_rule */
public class ThreadedCommentListGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, CommentsEnvironment> {
    private static ThreadedCommentListGroupPartDefinition f5109f;
    private static final Object f5110g = new Object();
    private final CommentGroupPartDefinition f5111a;
    private final CommentReplyPartDefinition f5112b;
    private final ViewMoreRepliesPartDefinition f5113c;
    public final FeedbackAnalyticsLogger f5114d;
    private final InlineReplyExpansionExperimentUtil f5115e;

    /* compiled from: rewrite_rule */
    public class Props {
        public final GraphQLComment f5105a;
        public final GraphQLFeedback f5106b;
        public final FeedProps<GraphQLComment> f5107c;
        public final CommentOrderType f5108d;

        public Props(FeedProps<GraphQLComment> feedProps, CommentOrderType commentOrderType) {
            this.f5107c = feedProps;
            this.f5105a = (GraphQLComment) feedProps.a;
            this.f5106b = CommentProps.b(feedProps);
            this.f5108d = commentOrderType;
        }
    }

    private static ThreadedCommentListGroupPartDefinition m5573b(InjectorLike injectorLike) {
        return new ThreadedCommentListGroupPartDefinition(CommentGroupPartDefinition.m5426a(injectorLike), CommentReplyPartDefinition.m5484a(injectorLike), ViewMoreRepliesPartDefinition.m5595a(injectorLike), FeedbackAnalyticsLogger.a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike));
    }

    public final Object m5576a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        ImmutableList b = m5574b(props);
        baseMultiRowSubParts.a(this.f5113c, new com.facebook.feedback.ui.rows.ViewMoreRepliesPartDefinition.Props(props.f5105a, b, m5575c(props), new OnClickListener(this) {
            final /* synthetic */ ThreadedCommentListGroupPartDefinition f5100c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 795228763);
                this.f5100c.f5114d.f(baseCommentsEnvironment.f4810g);
                baseCommentsEnvironment.m5346b(props.f5105a, props.f5106b);
                Logger.a(2, EntryType.UI_INPUT_END, 1853286837, a);
            }
        }));
        boolean a = this.f5115e.a();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            final GraphQLComment graphQLComment = (GraphQLComment) b.get(i);
            if (a) {
                baseMultiRowSubParts.a(this.f5111a, props.f5107c.a(props.f5105a.l()).a(graphQLComment));
            } else {
                baseMultiRowSubParts.a(this.f5112b, new com.facebook.feedback.ui.rows.CommentReplyPartDefinition.Props(graphQLComment, props.f5105a, CommentLevel.THREADED, new OnClickListener(this) {
                    final /* synthetic */ ThreadedCommentListGroupPartDefinition f5104d;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1527153910);
                        this.f5104d.f5114d.e(baseCommentsEnvironment.f4810g);
                        BaseCommentsEnvironment baseCommentsEnvironment = baseCommentsEnvironment;
                        GraphQLComment graphQLComment = props.f5105a;
                        GraphQLComment graphQLComment2 = graphQLComment;
                        GraphQLFeedback graphQLFeedback = props.f5106b;
                        if (baseCommentsEnvironment.f4805b != null) {
                            baseCommentsEnvironment.f4805b.mo224a(graphQLComment, graphQLComment2, graphQLFeedback, baseCommentsEnvironment.f4810g);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -1416620988, a);
                    }
                }));
            }
        }
        return null;
    }

    public final boolean m5577a(Object obj) {
        Props props = (Props) obj;
        return props.f5105a.l() != null && GraphQLHelper.g(props.f5105a.l()) > 0;
    }

    @Inject
    public ThreadedCommentListGroupPartDefinition(CommentGroupPartDefinition commentGroupPartDefinition, CommentReplyPartDefinition commentReplyPartDefinition, ViewMoreRepliesPartDefinition viewMoreRepliesPartDefinition, FeedbackAnalyticsLogger feedbackAnalyticsLogger, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f5111a = commentGroupPartDefinition;
        this.f5112b = commentReplyPartDefinition;
        this.f5113c = viewMoreRepliesPartDefinition;
        this.f5114d = feedbackAnalyticsLogger;
        this.f5115e = inlineReplyExpansionExperimentUtil;
    }

    public static ThreadedCommentListGroupPartDefinition m5572a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThreadedCommentListGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5110g) {
                ThreadedCommentListGroupPartDefinition threadedCommentListGroupPartDefinition;
                if (a2 != null) {
                    threadedCommentListGroupPartDefinition = (ThreadedCommentListGroupPartDefinition) a2.a(f5110g);
                } else {
                    threadedCommentListGroupPartDefinition = f5109f;
                }
                if (threadedCommentListGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5573b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5110g, b3);
                        } else {
                            f5109f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = threadedCommentListGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private ImmutableList<GraphQLComment> m5574b(Props props) {
        if (m5575c(props)) {
            return ImmutableList.of(props.f5105a.z().j().get(0));
        }
        ImmutableList i = GraphQLHelper.i(props.f5105a.l());
        int i2 = CommentOrderType.RANKED_ORDER.equals(props.f5108d) ? 1 : 3;
        return (i.size() <= i2 ? i : i.subList(0, i2)).reverse();
    }

    private static boolean m5575c(Props props) {
        return props.f5108d == CommentOrderType.RANKED_ORDER && GraphQLCommentHelper.k(props.f5105a);
    }
}
