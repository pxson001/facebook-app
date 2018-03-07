package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feed.MarkResearchPollCompletedParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.researchpoll.views.ResearchPollSurveyView;
import com.facebook.graphql.enums.GraphQLResearchPollQuestionType;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceQuestion;
import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceResponse;
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
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: c6d32153b0019b3d9c984dc70d441e93 */
public class ResearchPollSurveyPartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<GraphQLResearchPollFeedUnit, State, E, ResearchPollSurveyView> {
    public static final ViewType f9120a = new C11001();
    private static ResearchPollSurveyPartDefinition f9121d;
    private static final Object f9122e = new Object();
    public final ResearchPollLoggerUtil f9123b;
    private final OneButtonFooterStylerPartDefinition f9124c;

    /* compiled from: c6d32153b0019b3d9c984dc70d441e93 */
    final class C11001 extends ViewType {
        C11001() {
        }

        public final View m9798a(Context context) {
            return new ResearchPollSurveyView(context);
        }
    }

    /* compiled from: c6d32153b0019b3d9c984dc70d441e93 */
    /* synthetic */ class C11034 {
        static final /* synthetic */ int[] f9112a = new int[GraphQLResearchPollQuestionType.values().length];

        static {
            try {
                f9112a[GraphQLResearchPollQuestionType.RADIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9112a[GraphQLResearchPollQuestionType.CHECKBOX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: c6d32153b0019b3d9c984dc70d441e93 */
    public class State {
        public final ResearchPollPersistentState f9113a;
        public final OnClickListener f9114b;
        public final OnClickListener f9115c;
        public final String f9116d;
        public final String f9117e;
        public final String f9118f;
        public final String f9119g;

        public State(ResearchPollPersistentState researchPollPersistentState, OnClickListener onClickListener, OnClickListener onClickListener2, String str, String str2, String str3, String str4) {
            this.f9113a = researchPollPersistentState;
            this.f9114b = onClickListener;
            this.f9115c = onClickListener2;
            this.f9116d = str;
            this.f9117e = str2;
            this.f9118f = str3;
            this.f9119g = str4;
        }
    }

    private static ResearchPollSurveyPartDefinition m9807b(InjectorLike injectorLike) {
        return new ResearchPollSurveyPartDefinition(ResearchPollLoggerUtil.m9760a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike));
    }

    public final Object m9809a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f9124c, null);
        final ResearchPollPersistentState researchPollPersistentState = (ResearchPollPersistentState) ((HasPersistentState) hasInvalidate).a(new ResearchPollStoryKey(graphQLResearchPollFeedUnit), graphQLResearchPollFeedUnit);
        if (!(researchPollPersistentState.f9072c && researchPollPersistentState.f9073d.equals(graphQLResearchPollFeedUnit.g()))) {
            researchPollPersistentState.f9072c = true;
            researchPollPersistentState.f9073d = graphQLResearchPollFeedUnit.g();
            this.f9123b.m9762a(graphQLResearchPollFeedUnit.H().l(), "poll_loaded");
        }
        if (researchPollPersistentState.m9766c() == null) {
            researchPollPersistentState.f9071b = ResearchPollUnitHelper.m9819a(graphQLResearchPollFeedUnit, graphQLResearchPollFeedUnit.H().k().k());
        }
        return new State(researchPollPersistentState, new OnClickListener(this) {
            final /* synthetic */ ResearchPollSurveyPartDefinition f9107d;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1329685826);
                researchPollPersistentState.f9074e = true;
                GraphQLResearchPollMultipleChoiceQuestion a2 = ResearchPollUnitHelper.m9818a(researchPollPersistentState, graphQLResearchPollFeedUnit, researchPollPersistentState.f9071b);
                ResearchPollPersistentState researchPollPersistentState = researchPollPersistentState;
                if (a2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                researchPollPersistentState.f9077h = z;
                hasInvalidate.a(new Object[]{graphQLResearchPollFeedUnit});
                LogUtils.a(1360626121, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ ResearchPollSurveyPartDefinition f9111d;

            public void onClick(View view) {
                boolean z;
                boolean z2 = true;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1542266411);
                Integer num = (Integer) view.getTag();
                GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = researchPollPersistentState.f9071b;
                boolean z3 = graphQLResearchPollMultipleChoiceQuestion.n() == GraphQLResearchPollQuestionType.RADIO;
                if (z3) {
                    researchPollPersistentState.m9767d();
                }
                String k = ((GraphQLResearchPollMultipleChoiceResponse) graphQLResearchPollMultipleChoiceQuestion.p().a().get(num.intValue())).k();
                if (z3 || !researchPollPersistentState.m9765b(k)) {
                    z = true;
                } else {
                    z = false;
                }
                researchPollPersistentState.f9070a.put(k, Boolean.valueOf(z));
                researchPollPersistentState.f9075f = num;
                GraphQLResearchPollMultipleChoiceQuestion a2 = ResearchPollUnitHelper.m9818a(researchPollPersistentState, graphQLResearchPollFeedUnit, graphQLResearchPollMultipleChoiceQuestion);
                ResearchPollPersistentState researchPollPersistentState = researchPollPersistentState;
                if (!(a2 == null && graphQLResearchPollMultipleChoiceQuestion.n() == GraphQLResearchPollQuestionType.RADIO && graphQLResearchPollFeedUnit.L())) {
                    z2 = false;
                }
                researchPollPersistentState.f9077h = z2;
                hasInvalidate.hL_();
                LogUtils.a(808861114, a);
            }
        }, graphQLResearchPollFeedUnit.F(), graphQLResearchPollFeedUnit.B(), graphQLResearchPollFeedUnit.N(), graphQLResearchPollFeedUnit.E());
    }

    public final void m9812b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ResearchPollSurveyView researchPollSurveyView = (ResearchPollSurveyView) view;
        researchPollSurveyView.setCallToActionViewListener(null);
        researchPollSurveyView.setVoteButtonListener(null);
        researchPollSurveyView.setOnAnswerClickListener(null);
    }

    public static ResearchPollSurveyPartDefinition m9799a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollSurveyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9122e) {
                ResearchPollSurveyPartDefinition researchPollSurveyPartDefinition;
                if (a2 != null) {
                    researchPollSurveyPartDefinition = (ResearchPollSurveyPartDefinition) a2.a(f9122e);
                } else {
                    researchPollSurveyPartDefinition = f9121d;
                }
                if (researchPollSurveyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9807b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9122e, b3);
                        } else {
                            f9121d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollSurveyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ResearchPollSurveyPartDefinition(ResearchPollLoggerUtil researchPollLoggerUtil, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition) {
        this.f9123b = researchPollLoggerUtil;
        this.f9124c = oneButtonFooterStylerPartDefinition;
    }

    public static final boolean m9806a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        return graphQLResearchPollFeedUnit.K() || (graphQLResearchPollFeedUnit.H().p() != null && graphQLResearchPollFeedUnit.H().p().a().size() > 0);
    }

    public final /* synthetic */ boolean m9811a(Object obj) {
        return true;
    }

    public final ViewType m9808a() {
        return f9120a;
    }

    private void m9804a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, State state, ResearchPollSurveyView researchPollSurveyView) {
        ResearchPollPersistentState researchPollPersistentState = state.f9113a;
        GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = researchPollPersistentState.f9071b;
        if (researchPollPersistentState.f9076g) {
            m9800a(researchPollPersistentState, graphQLResearchPollFeedUnit, researchPollSurveyView);
        }
        if (researchPollPersistentState.f9074e) {
            m9801a(researchPollSurveyView, researchPollPersistentState, graphQLResearchPollFeedUnit);
        }
        if (researchPollPersistentState.f9075f.intValue() != -1) {
            m9802a(researchPollSurveyView, researchPollPersistentState.f9075f, researchPollPersistentState, graphQLResearchPollFeedUnit);
        }
        researchPollSurveyView.setVoteButtonEnabled(researchPollPersistentState.m9768e());
        researchPollSurveyView.f9147c.setText(graphQLResearchPollMultipleChoiceQuestion.o());
        researchPollSurveyView.setVoteButtonListener(state.f9114b);
        researchPollSurveyView.setOnAnswerClickListener(state.f9115c);
        researchPollSurveyView.f9149e.setText(state.f9116d);
        researchPollSurveyView.f9150f.setText(state.f9118f);
        researchPollSurveyView.f9148d.setText(state.f9119g);
        researchPollSurveyView.f9152h.setText(state.f9117e);
        if (graphQLResearchPollFeedUnit.U().b || researchPollPersistentState.f9077h) {
            m9805a(graphQLResearchPollFeedUnit, researchPollSurveyView);
        }
    }

    private void m9801a(ResearchPollSurveyView researchPollSurveyView, ResearchPollPersistentState researchPollPersistentState, GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        researchPollPersistentState.f9074e = false;
        GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = researchPollPersistentState.f9071b;
        String l = graphQLResearchPollFeedUnit.H().l();
        ResearchPollLoggerUtil researchPollLoggerUtil = this.f9123b;
        String l2 = graphQLResearchPollFeedUnit.z().l();
        Preconditions.checkNotNull(graphQLResearchPollMultipleChoiceQuestion);
        Builder builder = ImmutableList.builder();
        ImmutableList a = graphQLResearchPollMultipleChoiceQuestion.p().a();
        for (int i = 0; i < a.size(); i++) {
            if (researchPollSurveyView.f9153i.m9824c(i)) {
                builder.c(((GraphQLResearchPollMultipleChoiceResponse) a.get(i)).k());
            }
        }
        researchPollLoggerUtil.m9763a(l, l2, builder.b(), graphQLResearchPollMultipleChoiceQuestion.k());
        this.f9123b.m9762a(l, "vote");
        researchPollSurveyView.setOnAnswerClickListener(null);
        GraphQLResearchPollMultipleChoiceQuestion a2 = ResearchPollUnitHelper.m9818a(researchPollPersistentState, graphQLResearchPollFeedUnit, researchPollPersistentState.f9071b);
        if (a2 != null) {
            researchPollPersistentState.m9767d();
            m9803a(graphQLResearchPollFeedUnit, researchPollPersistentState, a2, researchPollSurveyView);
        }
    }

    private void m9805a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, ResearchPollSurveyView researchPollSurveyView) {
        ResearchPollLoggerUtil researchPollLoggerUtil = this.f9123b;
        String g = graphQLResearchPollFeedUnit.g();
        String graphQLObjectType = graphQLResearchPollFeedUnit.getType().toString();
        Bundle bundle = new Bundle();
        bundle.putParcelable("markResearchPollCompletedParamsKey", new MarkResearchPollCompletedParams(g, graphQLObjectType));
        BlueServiceOperationFactoryDetour.a(researchPollLoggerUtil.f9067a, "feed_mark_research_poll_completed", bundle, ErrorPropagation.BY_EXCEPTION, researchPollLoggerUtil.f9068b, 570905040).a(true).a();
        this.f9123b.m9762a(graphQLResearchPollFeedUnit.H().l(), "completed_poll");
        researchPollSurveyView.m9828a();
    }

    private void m9802a(ResearchPollSurveyView researchPollSurveyView, Integer num, ResearchPollPersistentState researchPollPersistentState, GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        researchPollPersistentState.f9075f = Integer.valueOf(-1);
        GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = researchPollPersistentState.f9071b;
        Object obj = graphQLResearchPollMultipleChoiceQuestion.n() == GraphQLResearchPollQuestionType.RADIO ? 1 : null;
        if (obj != null) {
            researchPollSurveyView.f9153i.m9823a(num);
        }
        String k = ((GraphQLResearchPollMultipleChoiceResponse) graphQLResearchPollMultipleChoiceQuestion.p().a().get(num.intValue())).k();
        this.f9123b.m9764a(researchPollPersistentState.m9765b(k), num.intValue(), graphQLResearchPollMultipleChoiceQuestion.k(), k, graphQLResearchPollFeedUnit.H().l());
        if (obj != null && graphQLResearchPollFeedUnit.L()) {
            m9801a(researchPollSurveyView, researchPollPersistentState, graphQLResearchPollFeedUnit);
        }
    }

    public static void m9803a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, ResearchPollPersistentState researchPollPersistentState, GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion, ResearchPollSurveyView researchPollSurveyView) {
        switch (C11034.f9112a[graphQLResearchPollMultipleChoiceQuestion.n().ordinal()]) {
            case 1:
                researchPollSurveyView.setVoteButtonActive(!graphQLResearchPollFeedUnit.L());
                researchPollSurveyView.setQuestionHint(graphQLResearchPollFeedUnit.G());
                break;
            case 2:
                researchPollSurveyView.setVoteButtonActive(true);
                researchPollSurveyView.setQuestionHint(graphQLResearchPollFeedUnit.A());
                break;
        }
        researchPollPersistentState.f9071b = graphQLResearchPollMultipleChoiceQuestion;
        researchPollSurveyView.f9153i.setQuestionText(graphQLResearchPollMultipleChoiceQuestion.o());
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (int i = 0; i < graphQLResearchPollMultipleChoiceQuestion.p().a().size(); i++) {
            GraphQLResearchPollMultipleChoiceResponse graphQLResearchPollMultipleChoiceResponse = (GraphQLResearchPollMultipleChoiceResponse) graphQLResearchPollMultipleChoiceQuestion.p().a().get(i);
            builder.b(graphQLResearchPollMultipleChoiceResponse.j(), Boolean.valueOf(researchPollPersistentState.m9765b(graphQLResearchPollMultipleChoiceResponse.k())));
        }
        researchPollSurveyView.f9153i.setAnswers(builder.b());
        researchPollSurveyView.f9153i.setVisibility(1 != null ? 0 : 8);
        researchPollSurveyView.setVoteButtonEnabled(researchPollPersistentState.m9768e());
    }

    private static void m9800a(ResearchPollPersistentState researchPollPersistentState, GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, ResearchPollSurveyView researchPollSurveyView) {
        researchPollSurveyView.f9146b.setVisibility(null != null ? 0 : 8);
        if (graphQLResearchPollFeedUnit.H().n() != 0) {
            researchPollSurveyView.m9828a();
            return;
        }
        ImmutableList a;
        researchPollSurveyView.setVoteButtonActive(true);
        researchPollSurveyView.f9149e.setVisibility(1 != null ? 0 : 8);
        researchPollSurveyView.f9151g.setVisibility(null != null ? 0 : 8);
        if (graphQLResearchPollFeedUnit.H().p() != null) {
            a = graphQLResearchPollFeedUnit.H().p().a();
        } else {
            a = RegularImmutableList.a;
        }
        GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = researchPollPersistentState.f9071b;
        String k = graphQLResearchPollFeedUnit.H().k().k();
        if (graphQLResearchPollMultipleChoiceQuestion != null && !k.equals(graphQLResearchPollMultipleChoiceQuestion.k())) {
            k = graphQLResearchPollMultipleChoiceQuestion.k();
        } else if (!a.isEmpty()) {
            k = ((GraphQLResearchPollMultipleChoiceQuestion) a.get(a.size() - 1)).k();
        }
        m9803a(graphQLResearchPollFeedUnit, researchPollPersistentState, ResearchPollUnitHelper.m9819a(graphQLResearchPollFeedUnit, k), researchPollSurveyView);
    }
}
