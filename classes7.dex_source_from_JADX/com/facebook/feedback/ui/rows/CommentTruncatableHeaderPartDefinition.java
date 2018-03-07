package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.CommentTruncatableHeaderView;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLComment;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_library_error */
public class CommentTruncatableHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLComment>, State, CommentsEnvironment, CommentTruncatableHeaderView> {
    private static CommentTruncatableHeaderPartDefinition f5028d;
    private static final Object f5029e = new Object();
    private final LinkifyUtil f5030a;
    private final QeAccessor f5031b;
    private final CommentHeaderBasePartDefinition f5032c;

    /* compiled from: ridge_library_error */
    public final class State {
        public final CharSequence f5024a;
        public CharSequence f5025b;
        public final GraphQLTranslatabilityType f5026c;
        public boolean f5027d;

        State(CharSequence charSequence, CharSequence charSequence2, GraphQLTranslatabilityType graphQLTranslatabilityType) {
            this.f5024a = charSequence;
            this.f5025b = charSequence2;
            this.f5026c = graphQLTranslatabilityType;
        }
    }

    private static CommentTruncatableHeaderPartDefinition m5514b(InjectorLike injectorLike) {
        return new CommentTruncatableHeaderPartDefinition(LinkifyUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommentHeaderBasePartDefinition.m5432a(injectorLike));
    }

    public final Object m5516a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        JsonNode jsonNode;
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        subParts.a(this.f5032c, feedProps);
        if (baseCommentsEnvironment.f4810g == null) {
            jsonNode = null;
        } else {
            jsonNode = baseCommentsEnvironment.f4810g.a;
        }
        Context context = baseCommentsEnvironment.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773278, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 2131361848);
        obtainStyledAttributes.recycle();
        CharSequence a = LinkifyUtil.a(this.f5030a.a(LinkifyUtilConverter.c(graphQLComment.s()), true, jsonNode, resourceId));
        return new State(a, m5513a(a), GraphQLHelper.a(graphQLComment));
    }

    public final /* bridge */ /* synthetic */ void m5517a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 118458454);
        State state = (State) obj2;
        CommentTruncatableHeaderView commentTruncatableHeaderView = (CommentTruncatableHeaderView) view;
        commentTruncatableHeaderView.m5656a(state.f5024a, state.f5025b, ((GraphQLComment) ((FeedProps) obj).a).y(), state.f5026c);
        if (state.f5027d) {
            commentTruncatableHeaderView.mo280h();
        }
        Logger.a(8, EntryType.MARK_POP, -1733638815, a);
    }

    public final boolean m5518a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!this.f5031b.a(ExperimentsForFeedbackTestModule.U, false)) {
            return false;
        }
        if (this.f5031b.a(ExperimentsForFeedbackTestModule.W, false)) {
            GraphQLFeedback graphQLFeedback = null;
            for (FeedProps feedProps2 = feedProps.b; feedProps2 != null; feedProps2 = feedProps2.b) {
                if (feedProps2.a instanceof GraphQLFeedback) {
                    graphQLFeedback = (GraphQLFeedback) feedProps2.a;
                }
            }
            GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
            Object obj2 = (graphQLFeedback2 == null || !CommentOrderType.isRanked(graphQLFeedback2)) ? null : 1;
            if (obj2 == null) {
                return false;
            }
        }
        return true;
    }

    public final void m5519b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        CommentTruncatableHeaderView commentTruncatableHeaderView = (CommentTruncatableHeaderView) view;
        if (commentTruncatableHeaderView.m5658i()) {
            state.f5025b = null;
        }
        state.f5027d = commentTruncatableHeaderView.m5626g();
        commentTruncatableHeaderView.setBody(null);
    }

    public static CommentTruncatableHeaderPartDefinition m5512a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentTruncatableHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5029e) {
                CommentTruncatableHeaderPartDefinition commentTruncatableHeaderPartDefinition;
                if (a2 != null) {
                    commentTruncatableHeaderPartDefinition = (CommentTruncatableHeaderPartDefinition) a2.a(f5029e);
                } else {
                    commentTruncatableHeaderPartDefinition = f5028d;
                }
                if (commentTruncatableHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5514b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5029e, b3);
                        } else {
                            f5028d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentTruncatableHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentTruncatableHeaderPartDefinition(LinkifyUtil linkifyUtil, QeAccessor qeAccessor, CommentHeaderBasePartDefinition commentHeaderBasePartDefinition) {
        this.f5030a = linkifyUtil;
        this.f5031b = qeAccessor;
        this.f5032c = commentHeaderBasePartDefinition;
    }

    public final ViewType m5515a() {
        return CommentTruncatableHeaderView.f5203m;
    }

    @Nullable
    private CharSequence m5513a(CharSequence charSequence) {
        int a = this.f5031b.a(ExperimentsForFeedbackTestModule.V, -1);
        OnClickListener onClickListener = CommentTruncatableHeaderView.f5204n;
        if (a == -1) {
            return this.f5030a.a(charSequence, onClickListener);
        }
        LinkifyUtil linkifyUtil = this.f5030a;
        return linkifyUtil.a(charSequence, onClickListener, a, linkifyUtil.g);
    }
}
