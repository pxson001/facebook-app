package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.CommentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.abtest.ExperimentsForReactionsTestModule;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.prefs.FeedbackReactionsPrefKeys;
import com.facebook.feedback.reactions.ui.FeedbackFooterMode;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.reactions.ui.ReactionMutateListener;
import com.facebook.feedback.reactions.ui.TokenPileDrawable;
import com.facebook.feedback.reactions.ui.TokenPileHelper;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsFooterInteractionLoggerProvider;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger;
import com.facebook.feedback.reactions.ui.logging.ReactionsNuxLogger$ClickTarget;
import com.facebook.feedback.reactions.util.FeedbackReactionsUtils;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentActionsWithReactionsView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.Liveness;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilder.Delegate;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilderParams;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ridge_session_id */
public class CommentActionsWithReactionsPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLComment>, State, CommentsEnvironment, CommentActionsWithReactionsView> {
    public static final ViewType f4855a = new C04751();
    private static CommentActionsWithReactionsPartDefinition f4856o;
    private static final Object f4857p = new Object();
    private final CommentStylingPartDefinition f4858b;
    private final CommentMetadataSpannableUtil f4859c;
    private final FeedbackReactionsController f4860d;
    private final ReactionsFooterInteractionLoggerProvider f4861e;
    public final ReactionsExperimentUtil f4862f;
    public final IFeedIntentBuilder f4863g;
    public final SecureContextHelper f4864h;
    private final NumberTruncationUtil f4865i;
    private final Provider<TokenPileDrawable> f4866j;
    private final TokenPileHelper f4867k;
    public final FeedbackReactionsUtils f4868l;
    public final InterstitialManager f4869m;
    public final ReactionsNuxLogger f4870n;

    /* compiled from: ridge_session_id */
    final class C04751 extends ViewType {
        C04751() {
        }

        public final View m5388a(Context context) {
            return new CommentActionsWithReactionsView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: ridge_session_id */
    public class State {
        public final ImmutableList<FeedbackReaction> f4851a;
        public final ReactionMutateListener f4852b;
        public final List<Spannable> f4853c;
        public final ReactionsFooterInteractionLogger f4854d;

        public State(ImmutableList<FeedbackReaction> immutableList, ReactionMutateListener reactionMutateListener, List<Spannable> list, ReactionsFooterInteractionLogger reactionsFooterInteractionLogger) {
            this.f4851a = immutableList;
            this.f4852b = reactionMutateListener;
            this.f4853c = list;
            this.f4854d = reactionsFooterInteractionLogger;
        }
    }

    private static CommentActionsWithReactionsPartDefinition m5399b(InjectorLike injectorLike) {
        return new CommentActionsWithReactionsPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), CommentMetadataSpannableUtil.b(injectorLike), FeedbackReactionsController.a(injectorLike), (ReactionsFooterInteractionLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsFooterInteractionLoggerProvider.class), ReactionsExperimentUtil.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), NumberTruncationUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 1788), TokenPileHelper.a(injectorLike), FeedbackReactionsUtils.a(injectorLike), InterstitialManager.a(injectorLike), ReactionsNuxLogger.a(injectorLike));
    }

    public final Object m5401a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String z_;
        final FeedProps feedProps = (FeedProps) obj;
        final BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        subParts.a(this.f4858b, new Props(CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps)) ? CommentRowPadding.PROFILE_PICTURE_OFFSET : CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET));
        if (((GraphQLComment) feedProps.a).l() != null) {
            this.f4860d.a(((GraphQLComment) feedProps.a).l().K());
        }
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        String str = CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps)) ? "feedback_top_level_comments" : "feedback_threaded_comments";
        ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider = this.f4861e;
        String y = graphQLComment.y();
        if (graphQLComment.l() != null) {
            z_ = graphQLComment.l().z_();
        } else {
            z_ = null;
        }
        return new State(null, new ReactionMutateListener(this) {
            final /* synthetic */ CommentActionsWithReactionsPartDefinition f4843c;

            public final void m5389a(View view, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
                if (feedbackReaction != FeedbackReaction.d) {
                    this.f4843c.f4868l.a.edit().putBoolean(FeedbackReactionsPrefKeys.d, true).commit();
                    baseCommentsEnvironment.m5338a((GraphQLComment) feedProps.a, CommentProps.b(feedProps), feedbackReaction);
                }
            }
        }, m5398a(feedProps, baseCommentsEnvironment, str), reactionsFooterInteractionLoggerProvider.a(y, z_, str));
    }

    public final /* bridge */ /* synthetic */ void m5402a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, -667183112);
        State state = (State) obj2;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        CommentActionsWithReactionsView commentActionsWithReactionsView = (CommentActionsWithReactionsView) view;
        if (CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel((FeedProps) obj))) {
            i = baseCommentsEnvironment.f4812i.f4820a;
        } else {
            i = baseCommentsEnvironment.f4812i.f4821b;
        }
        commentActionsWithReactionsView.setPadding(commentActionsWithReactionsView.getPaddingLeft(), commentActionsWithReactionsView.getPaddingTop(), commentActionsWithReactionsView.getPaddingRight(), i);
        commentActionsWithReactionsView.f5155h = state.f4851a;
        commentActionsWithReactionsView.f5157j = state.f4852b;
        commentActionsWithReactionsView.f5156i = state.f4854d;
        List list = state.f4853c;
        if (ViewCompat.h(commentActionsWithReactionsView) == 1) {
            z = true;
        } else {
            z = false;
        }
        CharSequence a2 = CommentMetadataSpannableUtil.a(list, z);
        commentActionsWithReactionsView.f5152e.setText(a2);
        commentActionsWithReactionsView.f5152e.setContentDescription(a2);
        commentActionsWithReactionsView.setMode(FeedbackFooterMode.DEFAULT);
        Logger.a(8, EntryType.MARK_POP, -36489457, a);
    }

    public final void m5404b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CommentActionsWithReactionsView) view).m5609a();
    }

    public static CommentActionsWithReactionsPartDefinition m5397a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentActionsWithReactionsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4857p) {
                CommentActionsWithReactionsPartDefinition commentActionsWithReactionsPartDefinition;
                if (a2 != null) {
                    commentActionsWithReactionsPartDefinition = (CommentActionsWithReactionsPartDefinition) a2.a(f4857p);
                } else {
                    commentActionsWithReactionsPartDefinition = f4856o;
                }
                if (commentActionsWithReactionsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5399b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4857p, b3);
                        } else {
                            f4856o = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentActionsWithReactionsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentActionsWithReactionsPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, CommentMetadataSpannableUtil commentMetadataSpannableUtil, FeedbackReactionsController feedbackReactionsController, ReactionsFooterInteractionLoggerProvider reactionsFooterInteractionLoggerProvider, ReactionsExperimentUtil reactionsExperimentUtil, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, NumberTruncationUtil numberTruncationUtil, Provider<TokenPileDrawable> provider, TokenPileHelper tokenPileHelper, FeedbackReactionsUtils feedbackReactionsUtils, InterstitialManager interstitialManager, ReactionsNuxLogger reactionsNuxLogger) {
        this.f4858b = commentStylingPartDefinition;
        this.f4859c = commentMetadataSpannableUtil;
        this.f4860d = feedbackReactionsController;
        this.f4861e = reactionsFooterInteractionLoggerProvider;
        this.f4862f = reactionsExperimentUtil;
        this.f4863g = iFeedIntentBuilder;
        this.f4864h = secureContextHelper;
        this.f4865i = numberTruncationUtil;
        this.f4866j = provider;
        this.f4867k = tokenPileHelper;
        this.f4868l = feedbackReactionsUtils;
        this.f4869m = interstitialManager;
        this.f4870n = reactionsNuxLogger;
    }

    public final ViewType m5400a() {
        return f4855a;
    }

    public final boolean m5403a(Object obj) {
        return this.f4862f.g();
    }

    private List<Spannable> m5398a(FeedProps<GraphQLComment> feedProps, CommentsEnvironment commentsEnvironment, String str) {
        GraphQLFeedback graphQLFeedback;
        GraphQLComment graphQLComment;
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
        final BaseCommentsEnvironment baseCommentsEnvironment = commentsEnvironment;
        final String str2 = str;
        C04773 c04773 = new Delegate(this) {
            final /* synthetic */ CommentActionsWithReactionsPartDefinition f4850g;

            public final void m5390a(View view) {
                baseCommentsEnvironment.m5336a(graphQLComment2);
            }

            public final void m5393b(View view) {
                baseCommentsEnvironment.m5337a(graphQLComment2, b);
            }

            public final void m5391a(View view, FeedbackReaction feedbackReaction) {
                baseCommentsEnvironment.m5338a(graphQLComment2, b, feedbackReaction);
                if (feedbackReaction.e == 1) {
                    CommentActionsWithReactionsPartDefinition commentActionsWithReactionsPartDefinition = this.f4850g;
                    GraphQLFeedback graphQLFeedback = b;
                    if (!commentActionsWithReactionsPartDefinition.f4868l.c()) {
                        commentActionsWithReactionsPartDefinition.f4862f.b.a(Liveness.Live, ExperimentsForReactionsTestModule.c);
                        CommentReactionsNuxInterstitialController commentReactionsNuxInterstitialController = (CommentReactionsNuxInterstitialController) commentActionsWithReactionsPartDefinition.f4869m.a(new InterstitialTrigger(Action.COMMENT_UFI_LIKE_CLICKED), CommentReactionsNuxInterstitialController.class);
                        if (commentReactionsNuxInterstitialController != null) {
                            commentReactionsNuxInterstitialController.m5371a(view, graphQLFeedback);
                            commentActionsWithReactionsPartDefinition.f4870n.a("feedback_comments", graphQLFeedback.z_(), ReactionsNuxLogger$ClickTarget.COMMENT_FOOTER, commentReactionsNuxInterstitialController.m5372b());
                            commentActionsWithReactionsPartDefinition.f4869m.a().a(commentReactionsNuxInterstitialController.m5372b());
                        }
                    }
                }
            }

            public final void m5394c(View view) {
                baseCommentsEnvironment.m5345b(graphQLComment2);
            }

            public final void m5395d(View view) {
                Intent a = this.f4850g.f4863g.a(graphQLComment2.l(), str2);
                a.putExtra("fragment_title", view.getContext().getString(2131233292));
                this.f4850g.f4864h.a(a, view.getContext());
            }

            public final void m5396e(View view) {
                baseCommentsEnvironment.m5346b(graphQLComment, graphQLFeedback);
            }

            public final void m5392a(View view, String str, String str2) {
                baseCommentsEnvironment.m5339a(graphQLComment2, str, str2);
            }
        };
        CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams = new CommentMetadataSpannableBuilderParams(commentsEnvironment.getContext());
        commentMetadataSpannableBuilderParams.b = c04773;
        commentMetadataSpannableBuilderParams.d = this.f4865i.a(GraphQLHelper.q(graphQLComment2.l()));
        if (this.f4862f.h()) {
            TokenPileDrawable tokenPileDrawable = (TokenPileDrawable) this.f4866j.get();
            tokenPileDrawable.a(this.f4867k.a(graphQLComment2.l()));
            commentMetadataSpannableBuilderParams.c = tokenPileDrawable;
        } else {
            commentMetadataSpannableBuilderParams.c = null;
        }
        return this.f4859c.a(commentMetadataSpannableBuilderParams, graphQLComment2, graphQLComment, this.f4860d.a(FeedbackReaction.a(graphQLComment2.l()).intValue()));
    }
}
