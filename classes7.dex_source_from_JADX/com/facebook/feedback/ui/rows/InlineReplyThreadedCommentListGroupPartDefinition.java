package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_enabled */
public class InlineReplyThreadedCommentListGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, CommentsEnvironment> {
    private static InlineReplyThreadedCommentListGroupPartDefinition f5060f;
    private static final Object f5061g = new Object();
    private final CommentGroupPartDefinition f5062a;
    private final LoadMoreCommentsPartDefinition f5063b;
    private final InlineReplyComposerPartDefinition f5064c;
    private final RepliesCountPartDefinition f5065d;
    public final InlineReplyExpansionExperimentUtil f5066e;

    /* compiled from: ridge_enabled */
    public class Props {
        public final GraphQLComment f5056a;
        public final GraphQLFeedback f5057b;
        public final FeedProps<GraphQLComment> f5058c;
        public final CommentOrderType f5059d;

        public Props(FeedProps<GraphQLComment> feedProps, CommentOrderType commentOrderType) {
            this.f5058c = feedProps;
            this.f5056a = (GraphQLComment) feedProps.a;
            this.f5057b = CommentProps.b(feedProps);
            this.f5059d = commentOrderType;
        }
    }

    private static InlineReplyThreadedCommentListGroupPartDefinition m5544b(InjectorLike injectorLike) {
        return new InlineReplyThreadedCommentListGroupPartDefinition(CommentGroupPartDefinition.m5426a(injectorLike), LoadMoreCommentsPartDefinition.m5549a(injectorLike), InlineReplyComposerPartDefinition.m5536a(injectorLike), RepliesCountPartDefinition.m5566a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m5545a(com.facebook.multirow.api.BaseMultiRowSubParts r13, java.lang.Object r14, com.facebook.multirow.api.AnyEnvironment r15) {
        /*
        r12 = this;
        r14 = (com.facebook.feedback.ui.rows.InlineReplyThreadedCommentListGroupPartDefinition.Props) r14;
        r15 = (com.facebook.feedback.ui.environment.BaseCommentsEnvironment) r15;
        r0 = r14.f5056a;
        r2 = r0.l();
        r0 = r12.f5065d;
        r1 = r14.f5058c;
        r13.a(r0, r1);
        r0 = new com.facebook.feedback.ui.rows.LoadMoreCommentsPartDefinition$Props;
        r1 = com.facebook.api.ufiservices.common.CommentLoadDirection.LOAD_AFTER;
        r3 = com.facebook.feedback.ui.rows.CommentLevel.THREADED;
        r0.<init>(r2, r1, r3);
        r1 = com.facebook.feedback.ui.rows.LoadMoreCommentsPartDefinition.m5550a(r0);
        if (r1 == 0) goto L_0x0025;
    L_0x0020:
        r1 = r12.f5063b;
        r13.a(r1, r0);
    L_0x0025:
        r0 = r14.f5056a;
        r0 = r0.l();
        r0 = com.facebook.graphql.model.GraphQLHelper.i(r0);
        r3 = r0.reverse();
        r4 = r3.size();
        r0 = 0;
        r1 = r0;
    L_0x0039:
        if (r1 >= r4) goto L_0x005a;
    L_0x003b:
        r0 = r3.get(r1);
        r0 = (com.facebook.graphql.model.GraphQLComment) r0;
        r5 = r12.f5062a;
        r6 = r14.f5058c;
        r7 = r14.f5056a;
        r7 = r7.l();
        r6 = r6.a(r7);
        r0 = r6.a(r0);
        r13.a(r5, r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0039;
    L_0x005a:
        r0 = new com.facebook.feedback.ui.rows.LoadMoreCommentsPartDefinition$Props;
        r1 = com.facebook.api.ufiservices.common.CommentLoadDirection.LOAD_BEFORE;
        r3 = com.facebook.feedback.ui.rows.CommentLevel.THREADED;
        r0.<init>(r2, r1, r3);
        r1 = com.facebook.feedback.ui.rows.LoadMoreCommentsPartDefinition.m5550a(r0);
        if (r1 == 0) goto L_0x006e;
    L_0x0069:
        r1 = r12.f5063b;
        r13.a(r1, r0);
    L_0x006e:
        r8 = r12.f5066e;
        r8 = r8.c();
        if (r8 == 0) goto L_0x00b2;
    L_0x0076:
        r9 = r15.f4814k;
        r10 = r2.z_();
        r9 = com.facebook.common.util.StringUtil.a(r9, r10);
        r8 = r9;
        if (r8 != 0) goto L_0x00a0;
    L_0x0083:
        r8 = com.facebook.graphql.model.GraphQLHelper.g(r2);
        if (r8 <= 0) goto L_0x00b2;
    L_0x0089:
        r8 = r12.f5066e;
        r9 = 0;
        r10 = r8.c();
        if (r10 == 0) goto L_0x009d;
    L_0x0092:
        r10 = r8.a;
        r11 = com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule.p;
        r10 = r10.a(r11, r9);
        if (r10 == 0) goto L_0x009d;
    L_0x009c:
        r9 = 1;
    L_0x009d:
        r8 = r9;
        if (r8 == 0) goto L_0x00b2;
    L_0x00a0:
        r8 = 1;
    L_0x00a1:
        r0 = r8;
        if (r0 == 0) goto L_0x00b0;
    L_0x00a4:
        r0 = r12.f5064c;
        r1 = new com.facebook.feedback.ui.rows.InlineReplyComposerPartDefinition$Props;
        r2 = r14.f5056a;
        r1.<init>(r2);
        r13.a(r0, r1);
    L_0x00b0:
        r0 = 0;
        return r0;
    L_0x00b2:
        r8 = 0;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.rows.InlineReplyThreadedCommentListGroupPartDefinition.a(com.facebook.multirow.api.BaseMultiRowSubParts, java.lang.Object, com.facebook.multirow.api.AnyEnvironment):java.lang.Object");
    }

    public final boolean m5546a(Object obj) {
        return this.f5066e.b() && ((Props) obj).f5056a.l() != null;
    }

    @Inject
    public InlineReplyThreadedCommentListGroupPartDefinition(CommentGroupPartDefinition commentGroupPartDefinition, LoadMoreCommentsPartDefinition loadMoreCommentsPartDefinition, InlineReplyComposerPartDefinition inlineReplyComposerPartDefinition, RepliesCountPartDefinition repliesCountPartDefinition, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f5062a = commentGroupPartDefinition;
        this.f5063b = loadMoreCommentsPartDefinition;
        this.f5064c = inlineReplyComposerPartDefinition;
        this.f5065d = repliesCountPartDefinition;
        this.f5066e = inlineReplyExpansionExperimentUtil;
    }

    public static InlineReplyThreadedCommentListGroupPartDefinition m5543a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineReplyThreadedCommentListGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5061g) {
                InlineReplyThreadedCommentListGroupPartDefinition inlineReplyThreadedCommentListGroupPartDefinition;
                if (a2 != null) {
                    inlineReplyThreadedCommentListGroupPartDefinition = (InlineReplyThreadedCommentListGroupPartDefinition) a2.a(f5061g);
                } else {
                    inlineReplyThreadedCommentListGroupPartDefinition = f5060f;
                }
                if (inlineReplyThreadedCommentListGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5544b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5061g, b3);
                        } else {
                            f5060f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineReplyThreadedCommentListGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
