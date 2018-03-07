package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: reviewer */
public class TopLevelCommentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, CommentsEnvironment> {
    private static TopLevelCommentGroupPartDefinition f5120d;
    private static final Object f5121e = new Object();
    private final CommentGroupPartDefinition f5122a;
    private final ThreadedCommentListGroupPartDefinition f5123b;
    private final InlineReplyThreadedCommentListGroupPartDefinition f5124c;

    /* compiled from: reviewer */
    public class Props implements RootProps {
        public final FeedProps<GraphQLComment> f5116a;
        public final GraphQLComment f5117b;
        public final GraphQLFeedback f5118c;
        public final CommentOrderType f5119d;

        public Props(FeedProps<GraphQLComment> feedProps, CommentOrderType commentOrderType) {
            this.f5117b = (GraphQLComment) feedProps.a;
            this.f5116a = feedProps;
            this.f5118c = CommentProps.b(feedProps);
            this.f5119d = commentOrderType;
        }
    }

    private static TopLevelCommentGroupPartDefinition m5579b(InjectorLike injectorLike) {
        return new TopLevelCommentGroupPartDefinition(CommentGroupPartDefinition.m5426a(injectorLike), ThreadedCommentListGroupPartDefinition.m5572a(injectorLike), InlineReplyThreadedCommentListGroupPartDefinition.m5543a(injectorLike));
    }

    public final Object m5580a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        baseMultiRowSubParts.a(this.f5122a, props.f5116a);
        SubPartsSelector.a(baseMultiRowSubParts, this.f5124c, new com.facebook.feedback.ui.rows.InlineReplyThreadedCommentListGroupPartDefinition.Props(props.f5116a, props.f5119d)).a(this.f5123b, new com.facebook.feedback.ui.rows.ThreadedCommentListGroupPartDefinition.Props(props.f5116a, props.f5119d));
        return null;
    }

    @Inject
    public TopLevelCommentGroupPartDefinition(CommentGroupPartDefinition commentGroupPartDefinition, ThreadedCommentListGroupPartDefinition threadedCommentListGroupPartDefinition, InlineReplyThreadedCommentListGroupPartDefinition inlineReplyThreadedCommentListGroupPartDefinition) {
        this.f5122a = commentGroupPartDefinition;
        this.f5123b = threadedCommentListGroupPartDefinition;
        this.f5124c = inlineReplyThreadedCommentListGroupPartDefinition;
    }

    public final boolean m5581a(Object obj) {
        return true;
    }

    public static TopLevelCommentGroupPartDefinition m5578a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopLevelCommentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5121e) {
                TopLevelCommentGroupPartDefinition topLevelCommentGroupPartDefinition;
                if (a2 != null) {
                    topLevelCommentGroupPartDefinition = (TopLevelCommentGroupPartDefinition) a2.a(f5121e);
                } else {
                    topLevelCommentGroupPartDefinition = f5120d;
                }
                if (topLevelCommentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5579b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5121e, b3);
                        } else {
                            f5120d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topLevelCommentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
