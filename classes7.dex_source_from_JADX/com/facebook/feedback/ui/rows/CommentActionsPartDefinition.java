package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentActionsView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
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
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilder.Delegate;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilderParams;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableUtil;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_session_started */
public class CommentActionsPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLComment>, List<Spannable>, CommentsEnvironment, CommentActionsView> {
    public static final ViewType f4836a = new C04731();
    private static CommentActionsPartDefinition f4837d;
    private static final Object f4838e = new Object();
    private final CommentStylingPartDefinition f4839b;
    public final CommentMetadataSpannableUtil f4840c;

    /* compiled from: ridge_session_started */
    final class C04731 extends ViewType {
        C04731() {
        }

        public final View m5374a(Context context) {
            return new CommentActionsView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static CommentActionsPartDefinition m5383b(InjectorLike injectorLike) {
        return new CommentActionsPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), CommentMetadataSpannableUtil.b(injectorLike));
    }

    public final Object m5385a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLFeedback graphQLFeedback;
        GraphQLComment graphQLComment;
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        subParts.a(this.f4839b, new Props(CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps)) ? CommentRowPadding.PROFILE_PICTURE_OFFSET : CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET));
        final GraphQLFeedback b = CommentProps.b(feedProps);
        final GraphQLComment graphQLComment2 = (GraphQLComment) feedProps.a;
        if (CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps))) {
            graphQLFeedback = b;
            graphQLComment = graphQLComment2;
        } else {
            FeedProps feedProps2 = feedProps.b;
            while (feedProps2 != null && !(feedProps2.a instanceof GraphQLComment)) {
                feedProps2 = feedProps2.b;
            }
            if (feedProps2 == null) {
                graphQLFeedback = b;
                graphQLComment = graphQLComment2;
            } else {
                GraphQLComment graphQLComment3 = (GraphQLComment) feedProps2.a;
                graphQLFeedback = CommentProps.b(feedProps2);
                graphQLComment = graphQLComment3;
            }
        }
        final BaseCommentsEnvironment baseCommentsEnvironment2 = baseCommentsEnvironment;
        C04742 c04742 = new Delegate(this) {
            final /* synthetic */ CommentActionsPartDefinition f4835f;

            public final void m5375a(View view) {
                baseCommentsEnvironment2.m5336a(graphQLComment2);
            }

            public final void m5378b(View view) {
                baseCommentsEnvironment2.m5337a(graphQLComment2, b);
            }

            public final void m5376a(View view, FeedbackReaction feedbackReaction) {
            }

            public final void m5379c(View view) {
                baseCommentsEnvironment2.m5345b(graphQLComment2);
            }

            public final void m5380d(View view) {
            }

            public final void m5381e(View view) {
                baseCommentsEnvironment2.m5346b(graphQLComment, graphQLFeedback);
            }

            public final void m5377a(View view, String str, String str2) {
                baseCommentsEnvironment2.m5339a(graphQLComment2, str, str2);
            }
        };
        CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams = new CommentMetadataSpannableBuilderParams(baseCommentsEnvironment.getContext());
        commentMetadataSpannableBuilderParams.b = c04742;
        return this.f4840c.a(commentMetadataSpannableBuilderParams, graphQLComment2, graphQLComment);
    }

    public final /* bridge */ /* synthetic */ void m5386a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, 726870314);
        List list = (List) obj2;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        CommentActionsView commentActionsView = (CommentActionsView) view;
        if (CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel((FeedProps) obj))) {
            i = baseCommentsEnvironment.f4812i.f4820a;
        } else {
            i = baseCommentsEnvironment.f4812i.f4821b;
        }
        commentActionsView.setPadding(commentActionsView.getPaddingLeft(), commentActionsView.getPaddingTop(), commentActionsView.getPaddingRight(), i);
        commentActionsView.setMetadataText(CommentMetadataSpannableUtil.a(list, ViewCompat.h(commentActionsView) == 1));
        Logger.a(8, EntryType.MARK_POP, -1447713055, a);
    }

    @Inject
    public CommentActionsPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, CommentMetadataSpannableUtil commentMetadataSpannableUtil) {
        this.f4839b = commentStylingPartDefinition;
        this.f4840c = commentMetadataSpannableUtil;
    }

    public final ViewType m5384a() {
        return f4836a;
    }

    public static CommentActionsPartDefinition m5382a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentActionsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4838e) {
                CommentActionsPartDefinition commentActionsPartDefinition;
                if (a2 != null) {
                    commentActionsPartDefinition = (CommentActionsPartDefinition) a2.a(f4838e);
                } else {
                    commentActionsPartDefinition = f4837d;
                }
                if (commentActionsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5383b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4838e, b3);
                        } else {
                            f4837d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentActionsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5387a(Object obj) {
        return true;
    }
}
