package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel.NodesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.ui.rows.views.CommentHeaderBaseView;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.gametime.ui.components.view.GametimeSportsPlayView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntity.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImportantReactorsConnection;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLResharesOfContentConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel.LikersModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel.ResharesModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFeedbackFieldsModel.TopLevelCommentsModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel.PreviewCommentModel;
import com.facebook.reaction.protocol.graphql.ReactionConversionHelper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAKE_PICTURE */
public class GametimeSportsPlayUnitComponentPartDefinition extends MultiRowSinglePartDefinition<Props, State, HasContext, GametimeSportsPlayView> {
    public static final ViewType f25136a = new C30101();
    public static final CallerContext f25137b = CallerContext.a(GametimeSportsPlayUnitComponentPartDefinition.class);
    private static GametimeSportsPlayUnitComponentPartDefinition f25138k;
    private static final Object f25139l = new Object();
    private final BaseReactionsFooterPartDefinition f25140c;
    private final BlingBarFlyoutPartDefinition f25141d;
    private final ClickListenerPartDefinition f25142e;
    private final FooterBackgroundPartDefinition<ReactionsFooterView> f25143f;
    private final PillsBlingBarPartDefinitionHelper f25144g;
    public final SecureContextHelper f25145h;
    private final GametimeSportsPlayContentViewComponentPartDefinition f25146i;
    public final ViewPermalinkIntentFactory f25147j;

    /* compiled from: TAKE_PICTURE */
    final class C30101 extends ViewType {
        C30101() {
        }

        public final View m27110a(Context context) {
            return new GametimeSportsPlayView(new ContextThemeWrapper(context, 2131626511));
        }
    }

    /* compiled from: TAKE_PICTURE */
    public class Props {
        public final GametimeDataFactFragment f25132a;
        public final Style f25133b;

        public Props(GametimeDataFactFragment gametimeDataFactFragment, Style style) {
            this.f25132a = gametimeDataFactFragment;
            this.f25133b = style;
        }
    }

    /* compiled from: TAKE_PICTURE */
    public class State {
        public final GraphQLFeedback f25134a;
        public final boolean f25135b;

        public State(GraphQLFeedback graphQLFeedback, boolean z) {
            this.f25134a = graphQLFeedback;
            this.f25135b = z;
        }
    }

    /* compiled from: TAKE_PICTURE */
    public enum Style {
        SHOW_COMMENT,
        WITH_BORDER,
        WITH_INSET_BORDER
    }

    private static GametimeSportsPlayUnitComponentPartDefinition m27113b(InjectorLike injectorLike) {
        return new GametimeSportsPlayUnitComponentPartDefinition(BaseReactionsFooterPartDefinition.a(injectorLike), BlingBarFlyoutPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike), PillsBlingBarPartDefinitionHelper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), GametimeSportsPlayContentViewComponentPartDefinition.m27103a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m27115a(com.facebook.multirow.api.SubParts r11, java.lang.Object r12, com.facebook.multirow.api.AnyEnvironment r13) {
        /*
        r10 = this;
        r12 = (com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Props) r12;
        r13 = (com.facebook.feed.environment.HasContext) r13;
        r0 = 1;
        r1 = 0;
        r2 = r12.f25132a;
        r3 = m27112a(r2);
        r4 = 2131562500; // 0x7f0d1004 float:1.875043E38 double:1.053131803E-314;
        r5 = r10.f25146i;
        r11.a(r4, r5, r2);
        r4 = 2131562501; // 0x7f0d1005 float:1.8750433E38 double:1.0531318037E-314;
        r5 = r10.f25141d;
        r6 = com.facebook.feed.rows.core.props.FeedProps.c(r3);
        r11.a(r4, r5, r6);
        r4 = 2131562502; // 0x7f0d1006 float:1.8750435E38 double:1.053131804E-314;
        r5 = r10.f25140c;
        r6 = new com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition$Props;
        r7 = com.facebook.feed.rows.core.props.FeedProps.c(r3);
        r6.<init>(r7, r0);
        r11.a(r4, r5, r6);
        r4 = 2131562502; // 0x7f0d1006 float:1.8750435E38 double:1.053131804E-314;
        r5 = r10.f25143f;
        r6 = new com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition$Props;
        r7 = com.facebook.feed.rows.core.props.FeedProps.c(r3);
        r8 = com.facebook.feedplugins.base.footer.FooterLevel.HAS_FOLLOWUP_SECTION;
        r6.<init>(r7, r8);
        r11.a(r4, r5, r6);
        r4 = r12.f25133b;
        r5 = com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Style.SHOW_COMMENT;
        if (r4 != r5) goto L_0x00ab;
    L_0x004a:
        r4 = r2.j();
        if (r4 == 0) goto L_0x00ad;
    L_0x0050:
        r9 = r4.b();
        if (r9 == 0) goto L_0x00ad;
    L_0x0056:
        r9 = r4.b();
        r9 = r9.eT_();
        if (r9 == 0) goto L_0x00ad;
    L_0x0060:
        r9 = r4.b();
        r9 = r9.eT_();
        r9 = r9.a();
        r9 = com.google.common.base.Strings.isNullOrEmpty(r9);
        if (r9 != 0) goto L_0x00ad;
    L_0x0072:
        r9 = r4.b();
        r9 = r9.d();
        r9 = com.google.common.base.Strings.isNullOrEmpty(r9);
        if (r9 != 0) goto L_0x00ad;
    L_0x0080:
        r9 = r4.c();
        r9 = r9.a();
        r9 = com.google.common.base.Strings.isNullOrEmpty(r9);
        if (r9 != 0) goto L_0x00ad;
    L_0x008e:
        r9 = 1;
    L_0x008f:
        r4 = r9;
        if (r4 == 0) goto L_0x00ab;
    L_0x0092:
        if (r0 == 0) goto L_0x00a1;
    L_0x0094:
        r4 = 2131562503; // 0x7f0d1007 float:1.8750437E38 double:1.0531318047E-314;
        r5 = r10.f25142e;
        r6 = new com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition$2;
        r6.<init>(r10, r2, r13);
        r11.a(r4, r5, r6);
    L_0x00a1:
        r2 = new com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition$State;
        r3 = r3.l();
        r2.<init>(r3, r0);
        return r2;
    L_0x00ab:
        r0 = r1;
        goto L_0x0092;
    L_0x00ad:
        r9 = 0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.a(com.facebook.multirow.api.SubParts, java.lang.Object, com.facebook.multirow.api.AnyEnvironment):java.lang.Object");
    }

    public final /* bridge */ /* synthetic */ void m27116a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 92901147);
        Props props = (Props) obj;
        State state = (State) obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        GametimeSportsPlayView gametimeSportsPlayView = (GametimeSportsPlayView) view;
        GametimeDataFactFragment gametimeDataFactFragment = props.f25132a;
        PillsBlingBarPartDefinitionHelper.a(state.f25134a, Integer.valueOf(0), gametimeSportsPlayView.f25294b);
        CommentHeaderBaseView commentHeaderBaseView = gametimeSportsPlayView.f25296d;
        if (state.f25135b) {
            PreviewCommentModel j = gametimeDataFactFragment.j();
            commentHeaderBaseView.a(null, Uri.parse(j.b().eT_().a()), f25137b);
            CharSequence d = j.b().d();
            commentHeaderBaseView.q.setText(d);
            commentHeaderBaseView.q.setContentDescription(d);
            commentHeaderBaseView.setBody(j.c().a());
            commentHeaderBaseView.setVisibility(0);
        } else {
            commentHeaderBaseView.setVisibility(8);
        }
        LinearLayout linearLayout = gametimeSportsPlayView.f25293a;
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        if (props.f25133b == Style.WITH_BORDER || props.f25133b == Style.WITH_INSET_BORDER) {
            int i;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            linearLayout.setLayoutParams(layoutParams);
            if (props.f25133b == Style.WITH_BORDER) {
                i = 2130840540;
            } else {
                i = 2130840539;
            }
            linearLayout.setBackgroundResource(i);
        } else {
            int dimensionPixelOffset = hasContext.getContext().getResources().getDimensionPixelOffset(2131434006);
            layoutParams.topMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setBackgroundResource(0);
        }
        Logger.a(8, EntryType.MARK_POP, 1728670692, a);
    }

    public final boolean m27117a(Object obj) {
        GametimeDataFactFragment gametimeDataFactFragment = ((Props) obj).f25132a;
        return (gametimeDataFactFragment == null || gametimeDataFactFragment.m() == null || gametimeDataFactFragment.m().d() == null || gametimeDataFactFragment.g() == null || Strings.isNullOrEmpty(gametimeDataFactFragment.eP_()) || gametimeDataFactFragment.b() == null || Strings.isNullOrEmpty(gametimeDataFactFragment.b().eS_()) || gametimeDataFactFragment.b().d() == null || Strings.isNullOrEmpty(gametimeDataFactFragment.b().d().a())) ? false : true;
    }

    public static GametimeSportsPlayUnitComponentPartDefinition m27111a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeSportsPlayUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25139l) {
                GametimeSportsPlayUnitComponentPartDefinition gametimeSportsPlayUnitComponentPartDefinition;
                if (a2 != null) {
                    gametimeSportsPlayUnitComponentPartDefinition = (GametimeSportsPlayUnitComponentPartDefinition) a2.a(f25139l);
                } else {
                    gametimeSportsPlayUnitComponentPartDefinition = f25138k;
                }
                if (gametimeSportsPlayUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27113b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25139l, b3);
                        } else {
                            f25138k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeSportsPlayUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GametimeSportsPlayUnitComponentPartDefinition(BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition, BlingBarFlyoutPartDefinition blingBarFlyoutPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, SecureContextHelper secureContextHelper, GametimeSportsPlayContentViewComponentPartDefinition gametimeSportsPlayContentViewComponentPartDefinition, ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f25140c = baseReactionsFooterPartDefinition;
        this.f25141d = blingBarFlyoutPartDefinition;
        this.f25142e = clickListenerPartDefinition;
        this.f25143f = footerBackgroundPartDefinition;
        this.f25144g = pillsBlingBarPartDefinitionHelper;
        this.f25145h = secureContextHelper;
        this.f25146i = gametimeSportsPlayContentViewComponentPartDefinition;
        this.f25147j = viewPermalinkIntentFactory;
    }

    public final ViewType m27114a() {
        return f25136a;
    }

    private static GraphQLStory m27112a(GametimeDataFactFragment gametimeDataFactFragment) {
        GraphQLFeedback graphQLFeedback;
        Builder builder = new Builder();
        builder.m = gametimeDataFactFragment.m().d().c();
        builder = builder;
        GraphQLObjectType.Builder builder2 = new GraphQLObjectType.Builder();
        builder2.a = 2006245554;
        builder.S = builder2.a();
        GraphQLEntity a = builder.a();
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.g = gametimeDataFactFragment.b().d().a();
        GraphQLImage a2 = builder3.a();
        GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
        builder4.at = gametimeDataFactFragment.b().eS_();
        builder4 = builder4;
        builder4.ad = a2;
        GraphQLActor a3 = builder4.a();
        GraphQLStory.Builder builder5 = new GraphQLStory.Builder();
        builder5.K = gametimeDataFactFragment.m().c();
        builder5 = builder5;
        builder5.o = gametimeDataFactFragment.m().b();
        builder5 = builder5;
        GametimeDataFactFeedbackFieldsModel g = gametimeDataFactFragment.g();
        if (g == null) {
            graphQLFeedback = null;
        } else {
            GraphQLImportantReactorsConnection graphQLImportantReactorsConnection;
            GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
            GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection;
            GraphQLResharesOfContentConnection graphQLResharesOfContentConnection;
            GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
            GraphQLPage graphQLPage;
            GraphQLUser graphQLUser;
            GraphQLFeedback.Builder builder6 = new GraphQLFeedback.Builder();
            builder6.d = g.b();
            builder6.b(g.c());
            builder6.f = g.d();
            builder6.g = g.bT_();
            builder6.h = g.g();
            builder6.f(g.bU_());
            builder6.j = g.q();
            builder6.k = g.bV_();
            builder6.n = g.j();
            builder6.p = g.r();
            builder6.j(g.k());
            builder6.v = g.l();
            ImportantReactorsModel s = g.s();
            if (s == null) {
                graphQLImportantReactorsConnection = null;
            } else {
                GraphQLImportantReactorsConnection.Builder builder7 = new GraphQLImportantReactorsConnection.Builder();
                if (s.a() != null) {
                    ImmutableList.Builder builder8 = ImmutableList.builder();
                    for (int i = 0; i < s.a().size(); i++) {
                        GraphQLActor graphQLActor;
                        NodesModel nodesModel = (NodesModel) s.a().get(i);
                        if (nodesModel == null) {
                            graphQLActor = null;
                        } else {
                            GraphQLActor.Builder builder9 = new GraphQLActor.Builder();
                            builder9.aH = nodesModel.a();
                            builder9.V = nodesModel.b();
                            graphQLActor = builder9.a();
                        }
                        builder8.c(graphQLActor);
                    }
                    builder7.d = builder8.b();
                }
                graphQLImportantReactorsConnection = builder7.a();
            }
            builder6.w = graphQLImportantReactorsConnection;
            builder6.m(g.m());
            builder6.A = g.n();
            LikersModel t = g.t();
            if (t == null) {
                graphQLLikersOfContentConnection = null;
            } else {
                GraphQLLikersOfContentConnection.Builder builder10 = new GraphQLLikersOfContentConnection.Builder();
                builder10.a(t.a());
                graphQLLikersOfContentConnection = builder10.a();
            }
            builder6.C = graphQLLikersOfContentConnection;
            ReactorsModel u = g.u();
            if (u == null) {
                graphQLReactorsOfContentConnection = null;
            } else {
                GraphQLReactorsOfContentConnection.Builder builder11 = new GraphQLReactorsOfContentConnection.Builder();
                builder11.a(u.a());
                graphQLReactorsOfContentConnection = builder11.a();
            }
            builder6.E = graphQLReactorsOfContentConnection;
            builder6.G = g.o();
            ResharesModel v = g.v();
            if (v == null) {
                graphQLResharesOfContentConnection = null;
            } else {
                GraphQLResharesOfContentConnection.Builder builder12 = new GraphQLResharesOfContentConnection.Builder();
                builder12.a(v.a());
                graphQLResharesOfContentConnection = builder12.a();
            }
            builder6.H = graphQLResharesOfContentConnection;
            if (g.w() != null) {
                ImmutableList.Builder builder13 = ImmutableList.builder();
                for (int i2 = 0; i2 < g.w().size(); i2++) {
                    GraphQLFeedbackReaction graphQLFeedbackReaction;
                    SupportedReactionsModel supportedReactionsModel = (SupportedReactionsModel) g.w().get(i2);
                    if (supportedReactionsModel == null) {
                        graphQLFeedbackReaction = null;
                    } else {
                        GraphQLFeedbackReaction.Builder builder14 = new GraphQLFeedbackReaction.Builder();
                        builder14.d = supportedReactionsModel.a();
                        graphQLFeedbackReaction = builder14.a();
                    }
                    builder13.c(graphQLFeedbackReaction);
                }
                builder6.K = builder13.b();
            }
            TopLevelCommentsModel x = g.x();
            if (x == null) {
                graphQLTopLevelCommentsConnection = null;
            } else {
                GraphQLTopLevelCommentsConnection.Builder builder15 = new GraphQLTopLevelCommentsConnection.Builder();
                builder15.a(x.a());
                graphQLTopLevelCommentsConnection = builder15.a();
            }
            builder6.L = graphQLTopLevelCommentsConnection;
            builder6.M = ReactionConversionHelper.a(g.y());
            ViewerActsAsPage p = g.p();
            if (p == null) {
                graphQLPage = null;
            } else {
                GraphQLPage.Builder builder16 = new GraphQLPage.Builder();
                builder16.Z = p.b();
                builder16.aF = p.c();
                builder16.bv = ReactionConversionHelper.a(p.d());
                graphQLPage = builder16.a();
            }
            builder6.P = graphQLPage;
            ViewerActsAsPersonModel z = g.z();
            if (z == null) {
                graphQLUser = null;
            } else {
                GraphQLUser.Builder builder17 = new GraphQLUser.Builder();
                builder17.ar = z.a();
                graphQLUser = builder17.a();
            }
            builder6.Q = graphQLUser;
            builder6.a(g.A());
            graphQLFeedback = builder6.a();
        }
        builder5.D = graphQLFeedback;
        builder5 = builder5;
        builder5.f = ImmutableList.of(a3);
        GraphQLStory.Builder builder18 = builder5;
        builder18.al = a;
        return builder18.a();
    }
}
