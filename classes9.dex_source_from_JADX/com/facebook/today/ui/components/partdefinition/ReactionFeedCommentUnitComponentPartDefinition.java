package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.rows.views.CommentActionsView;
import com.facebook.feedback.ui.rows.views.CommentHeaderBaseView;
import com.facebook.feedback.ui.rows.views.CommentHeaderView;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionConversionHelper;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel;
import com.facebook.today.common.HasNotifications;
import com.facebook.today.persistentstate.ReactionFeedCommentKey;
import com.facebook.today.persistentstate.ReactionFeedCommentPersistentState;
import com.facebook.today.ui.components.view.TodayFeedCommentView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilder.Delegate;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableBuilderParams;
import com.facebook.ufiservices.flyout.views.CommentMetadataSpannableUtil;
import com.facebook.ufiservices.module.AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.google.common.base.Strings;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: translated_uri */
public class ReactionFeedCommentUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasNotifications & HasPersistentState & HasReactionInteractionTracker & HasReactionSession & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, TodayFeedCommentView> {
    public static final ViewType f1333a = new C01271();
    public static final CallerContext f1334b = CallerContext.a(ReactionFeedCommentUnitComponentPartDefinition.class);
    private static ReactionFeedCommentUnitComponentPartDefinition f1335l;
    private static final Object f1336m = new Object();
    public final AttachmentStyleUtil f1337c;
    private final BasicReactionActionPartDefinition f1338d;
    private final ClickListenerPartDefinition f1339e;
    public final CommentDelegate f1340f;
    private final CommentMetadataSpannableUtil f1341g;
    private final Context f1342h;
    private final LinkifyUtil f1343i;
    private final ReactionActionHandler f1344j;
    private final TextPartDefinition f1345k;

    /* compiled from: translated_uri */
    final class C01271 extends ViewType {
        C01271() {
        }

        public final View m1458a(Context context) {
            return new TodayFeedCommentView(new ContextThemeWrapper(context, 2131626277));
        }
    }

    /* compiled from: translated_uri */
    final class C01336 implements OnClickListener {
        final /* synthetic */ AtomicBoolean f1325a;
        final /* synthetic */ ReactionFeedCommentPersistentState f1326b;
        final /* synthetic */ CharSequence f1327c;

        C01336(AtomicBoolean atomicBoolean, ReactionFeedCommentPersistentState reactionFeedCommentPersistentState, CharSequence charSequence) {
            this.f1325a = atomicBoolean;
            this.f1326b = reactionFeedCommentPersistentState;
            this.f1327c = charSequence;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 612252849);
            this.f1325a.set(true);
            this.f1326b.f1227a = true;
            TodayFeedCommentView b = ReactionFeedCommentUnitComponentPartDefinition.m1474b(view);
            if (b == null || b.f1367b == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1258447906, a);
                return;
            }
            final CommentHeaderView commentHeaderView = b.f1367b;
            commentHeaderView.post(new Runnable(this) {
                final /* synthetic */ C01336 f1324b;

                public void run() {
                    commentHeaderView.setBody(this.f1324b.f1327c);
                }
            });
            LogUtils.a(112066661, a);
        }
    }

    /* compiled from: translated_uri */
    public class State {
        public final CharSequence f1328a;
        public final CharSequence f1329b;
        public final GraphQLComment f1330c;
        public final List<Spannable> f1331d;
        public final AtomicBoolean f1332e;

        public State(CharSequence charSequence, CharSequence charSequence2, GraphQLComment graphQLComment, List<Spannable> list, AtomicBoolean atomicBoolean) {
            this.f1328a = charSequence;
            this.f1329b = charSequence2;
            this.f1330c = graphQLComment;
            this.f1331d = list;
            this.f1332e = atomicBoolean;
        }
    }

    private static ReactionFeedCommentUnitComponentPartDefinition m1473b(InjectorLike injectorLike) {
        return new ReactionFeedCommentUnitComponentPartDefinition(AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider.a(injectorLike), BasicReactionActionPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), CommentDelegate.b(injectorLike), CommentMetadataSpannableUtil.b(injectorLike), (Context) injectorLike.getInstance(Context.class), LinkifyUtil.a(injectorLike), ReactionActionHandler.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public static ReactionFeedCommentUnitComponentPartDefinition m1468a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFeedCommentUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1336m) {
                ReactionFeedCommentUnitComponentPartDefinition reactionFeedCommentUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFeedCommentUnitComponentPartDefinition = (ReactionFeedCommentUnitComponentPartDefinition) a2.a(f1336m);
                } else {
                    reactionFeedCommentUnitComponentPartDefinition = f1335l;
                }
                if (reactionFeedCommentUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1473b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1336m, b3);
                        } else {
                            f1335l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFeedCommentUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final /* bridge */ /* synthetic */ void m1478a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1006195534);
        State state = (State) obj2;
        TodayFeedCommentView todayFeedCommentView = (TodayFeedCommentView) view;
        CommentHeaderBaseView commentHeaderBaseView = todayFeedCommentView.f1367b;
        commentHeaderBaseView.a(null, null, f1334b);
        CharSequence charSequence = (state.f1328a == null || state.f1332e.get()) ? state.f1329b : state.f1328a;
        commentHeaderBaseView.setBody(charSequence);
        commentHeaderBaseView.setVerifiedBadgeVisibility(state.f1330c.A());
        commentHeaderBaseView.setPinnedIconVisibility(state.f1330c.C());
        commentHeaderBaseView.a(FeedProps.c(state.f1330c), this.f1337c);
        CommentActionsView commentActionsView = todayFeedCommentView.f1366a;
        List list = state.f1331d;
        if (ViewCompat.h(todayFeedCommentView) == 1) {
            z = true;
        } else {
            z = false;
        }
        commentActionsView.setMetadataText(CommentMetadataSpannableUtil.a(list, z));
        Logger.a(8, EntryType.MARK_POP, 608316596, a);
    }

    public final boolean m1479a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CommentModel T = reactionUnitComponentNode.b.T();
        return (T == null || T.g() == null || T.g().gh_() == null || T.b() == null || Strings.isNullOrEmpty(T.b().d()) || T.gb_() == null || reactionUnitComponentNode.b.v() == null) ? false : true;
    }

    @Inject
    public ReactionFeedCommentUnitComponentPartDefinition(AttachmentStyleUtil attachmentStyleUtil, BasicReactionActionPartDefinition basicReactionActionPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, CommentDelegate commentDelegate, CommentMetadataSpannableUtil commentMetadataSpannableUtil, Context context, LinkifyUtil linkifyUtil, ReactionActionHandler reactionActionHandler, TextPartDefinition textPartDefinition) {
        this.f1337c = attachmentStyleUtil;
        this.f1338d = basicReactionActionPartDefinition;
        this.f1339e = clickListenerPartDefinition;
        this.f1340f = commentDelegate;
        this.f1341g = commentMetadataSpannableUtil;
        this.f1342h = context;
        this.f1343i = linkifyUtil;
        this.f1344j = reactionActionHandler;
        this.f1345k = textPartDefinition;
    }

    private State m1467a(SubParts<E> subParts, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        CharSequence charSequence;
        Spannable a;
        GraphQLComment a2 = ReactionConversionHelper.a(reactionUnitComponentNode.f().T());
        ReactionFeedCommentPersistentState reactionFeedCommentPersistentState = (ReactionFeedCommentPersistentState) ((HasPersistentState) e).a(new ReactionFeedCommentKey(reactionUnitComponentNode.f().U()), reactionUnitComponentNode);
        AtomicBoolean atomicBoolean = new AtomicBoolean(reactionFeedCommentPersistentState.m1387a().asBoolean(a2.k()));
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(reactionFeedCommentPersistentState.m1388b());
        a2 = m1472b(a2, atomicBoolean);
        CharSequence a3 = LinkifyUtil.a(this.f1343i.a(LinkifyTargetBuilder.a(a2.r()), null, 2131361848, false));
        if (a2.s() != null) {
            CharSequence a4 = LinkifyUtil.a(this.f1343i.a(LinkifyUtilConverter.c(a2.s()), true, null, 0));
            charSequence = a4;
            a = this.f1343i.a(a4, m1466a(a4, atomicBoolean2, reactionFeedCommentPersistentState), 90, this.f1342h.getResources().getString(2131233707));
        } else {
            charSequence = null;
            a = null;
        }
        final E e2 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final OnClickListener c01282 = new OnClickListener(this) {
            final /* synthetic */ ReactionFeedCommentUnitComponentPartDefinition f1307c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 805302481);
                if (((HasNotifications) e2).a(reactionUnitComponentNode2.c, true)) {
                    ((HasInvalidate) e2).a(new FeedProps[]{FeedProps.c(reactionUnitComponentNode2)});
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1588105624, a);
            }
        };
        e2 = e;
        reactionUnitComponentNode2 = reactionUnitComponentNode;
        final OnClickListener c01293 = new OnClickListener(this) {
            final /* synthetic */ ReactionFeedCommentUnitComponentPartDefinition f1311d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1212567265);
                c01282.onClick(view);
                ReactionFeedCommentUnitComponentPartDefinition reactionFeedCommentUnitComponentPartDefinition = this.f1311d;
                ReactionFeedCommentUnitComponentPartDefinition.m1471a(e2, reactionUnitComponentNode2);
                ReactionFeedCommentUnitComponentPartDefinition.m1475b(this.f1311d, e2, reactionUnitComponentNode2);
                Logger.a(2, EntryType.UI_INPUT_END, 516293744, a);
            }
        };
        final E e3 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode3 = reactionUnitComponentNode;
        C01304 c01304 = new OnClickListener(this) {
            final /* synthetic */ ReactionFeedCommentUnitComponentPartDefinition f1315d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2076268355);
                if (((TextView) view).hasSelection()) {
                    ReactionFeedCommentUnitComponentPartDefinition reactionFeedCommentUnitComponentPartDefinition = this.f1315d;
                    ReactionFeedCommentUnitComponentPartDefinition.m1471a(e3, reactionUnitComponentNode3);
                    Logger.a(2, EntryType.UI_INPUT_END, 1796339025, a);
                    return;
                }
                c01293.onClick(view);
                LogUtils.a(242252699, a);
            }
        };
        List a5 = m1469a(a2, c01293, reactionUnitComponentNode, e, atomicBoolean, reactionFeedCommentPersistentState);
        subParts.a(this.f1338d, new Props(reactionUnitComponentNode.f().v(), null, reactionUnitComponentNode.k(), reactionUnitComponentNode.l(), c01282, null));
        subParts.a(2131560434, this.f1339e, c01304);
        subParts.a(2131560435, this.f1339e, c01304);
        subParts.a(2131560434, this.f1345k, a3);
        return new State(a, charSequence, a2, a5, atomicBoolean2);
    }

    public final ViewType m1476a() {
        return f1333a;
    }

    private List<Spannable> m1469a(GraphQLComment graphQLComment, OnClickListener onClickListener, ReactionUnitComponentNode reactionUnitComponentNode, E e, AtomicBoolean atomicBoolean, ReactionFeedCommentPersistentState reactionFeedCommentPersistentState) {
        final OnClickListener onClickListener2 = onClickListener;
        final E e2 = e;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final GraphQLComment graphQLComment2 = graphQLComment;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        final ReactionFeedCommentPersistentState reactionFeedCommentPersistentState2 = reactionFeedCommentPersistentState;
        C01315 c01315 = new Delegate(this) {
            final /* synthetic */ ReactionFeedCommentUnitComponentPartDefinition f1322g;

            public final void m1459a(View view) {
                onClickListener2.onClick(view);
            }

            public final void m1462b(View view) {
                boolean z = true;
                ((HasReactionInteractionTracker) e2).kE_().a(reactionUnitComponentNode2.c, reactionUnitComponentNode2.d, null, UnitInteractionType.LIKE_COMMENT_TAP);
                ReactionFeedCommentUnitComponentPartDefinition reactionFeedCommentUnitComponentPartDefinition = this.f1322g;
                ReactionFeedCommentUnitComponentPartDefinition.m1471a(e2, reactionUnitComponentNode2);
                this.f1322g.f1340f.a(graphQLComment2, graphQLComment2.O());
                atomicBoolean2.set(!atomicBoolean2.get());
                reactionFeedCommentPersistentState2.f1228b = TriState.valueOf(atomicBoolean2.get());
                TodayFeedCommentView b = ReactionFeedCommentUnitComponentPartDefinition.m1474b(view);
                if (b != null && b.f1366a != null) {
                    CommentActionsView commentActionsView = b.f1366a;
                    List a = this.f1322g.m1469a(ReactionFeedCommentUnitComponentPartDefinition.m1472b(graphQLComment2, atomicBoolean2), onClickListener2, reactionUnitComponentNode2, e2, atomicBoolean2, reactionFeedCommentPersistentState2);
                    if (ViewCompat.h(b) != 1) {
                        z = false;
                    }
                    commentActionsView.setMetadataText(CommentMetadataSpannableUtil.a(a, z));
                }
            }

            public final void m1460a(View view, FeedbackReaction feedbackReaction) {
            }

            public final void m1463c(View view) {
                onClickListener2.onClick(view);
            }

            public final void m1464d(View view) {
            }

            public final void m1465e(View view) {
                ((HasReactionInteractionTracker) e2).kE_().a(reactionUnitComponentNode2.c, reactionUnitComponentNode2.d, null, UnitInteractionType.REPLY_COMMMENT_TAP);
                onClickListener2.onClick(view);
            }

            public final void m1461a(View view, String str, String str2) {
                onClickListener2.onClick(view);
            }
        };
        CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams = new CommentMetadataSpannableBuilderParams(new ContextThemeWrapper(this.f1342h, 2131626277));
        commentMetadataSpannableBuilderParams.b = c01315;
        return this.f1341g.a(commentMetadataSpannableBuilderParams, graphQLComment, graphQLComment);
    }

    public static void m1471a(E e, ReactionUnitComponentNode reactionUnitComponentNode) {
        ((HasNotifications) e).a();
        ((HasNotifications) e).b(reactionUnitComponentNode.c);
    }

    public static void m1475b(ReactionFeedCommentUnitComponentPartDefinition reactionFeedCommentUnitComponentPartDefinition, CanLaunchReactionIntent canLaunchReactionIntent, ReactionUnitComponentNode reactionUnitComponentNode) {
        canLaunchReactionIntent.a(reactionUnitComponentNode.c, reactionUnitComponentNode.d, reactionFeedCommentUnitComponentPartDefinition.f1344j.a(reactionUnitComponentNode.b.v(), ((HasContext) canLaunchReactionIntent).getContext(), null, ((HasReactionSession) canLaunchReactionIntent).p().a, ((HasReactionSession) canLaunchReactionIntent).p().c, reactionUnitComponentNode.c, reactionUnitComponentNode.d, ((HasReactionAnalyticsParams) canLaunchReactionIntent).r()));
    }

    public static GraphQLComment m1472b(GraphQLComment graphQLComment, AtomicBoolean atomicBoolean) {
        int i = 1;
        int aa_ = graphQLComment.aa_() - (graphQLComment.k() ? 1 : 0);
        if (!atomicBoolean.get()) {
            i = 0;
        }
        aa_ += i;
        Builder a = Builder.a(graphQLComment);
        GraphQLFeedback.Builder a2 = GraphQLFeedback.Builder.a(graphQLComment.l());
        a2.C = GraphQLLikersOfContentConnection.Builder.a(graphQLComment.l().C()).a(aa_).a();
        a.o = a2.j(atomicBoolean.get()).a();
        return a.a();
    }

    private static OnClickListener m1466a(CharSequence charSequence, AtomicBoolean atomicBoolean, ReactionFeedCommentPersistentState reactionFeedCommentPersistentState) {
        return new C01336(atomicBoolean, reactionFeedCommentPersistentState, charSequence);
    }

    @Nullable
    public static TodayFeedCommentView m1474b(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TodayFeedCommentView) {
                return (TodayFeedCommentView) parent;
            }
        }
        return null;
    }
}
