package com.facebook.feedplugins.survey;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feed.MarkSurveyCompletedParams;
import com.facebook.api.feed.SubmitSurveyResponseParams;
import com.facebook.api.feed.SubmitSurveyResponseResult;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStructuredSurvey;
import com.facebook.graphql.model.GraphQLStructuredSurveyQuestion;
import com.facebook.graphql.model.GraphQLStructuredSurveyResponseOption;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
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
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_loader_manager */
public class SurveyPagePartDefinition<E extends HasPersistentState & HasPositionInformation & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLSurveyFeedUnit>, State, E, SurveyFeedUnitView> {
    public static final ViewType f9918a = new C11481();
    private static SurveyPagePartDefinition f9919f;
    private static final Object f9920g = new Object();
    public final Toaster f9921b;
    public final DefaultBlueServiceOperationFactory f9922c;
    private final BackgroundPartDefinition f9923d;
    private final Executor f9924e;

    /* compiled from: android_loader_manager */
    final class C11481 extends ViewType {
        C11481() {
        }

        public final View m10279a(Context context) {
            return new SurveyFeedUnitView(context);
        }
    }

    /* compiled from: android_loader_manager */
    public class State {
        public final SurveyPersistentState f9916a;
        public final OnClickListener f9917b;

        public State(SurveyPersistentState surveyPersistentState, OnClickListener onClickListener) {
            this.f9916a = surveyPersistentState;
            this.f9917b = onClickListener;
        }
    }

    private static SurveyPagePartDefinition m10287b(InjectorLike injectorLike) {
        return new SurveyPagePartDefinition(Toaster.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), BackgroundPartDefinition.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m10286a(String str, String str2, final GraphQLSurveyFeedUnit graphQLSurveyFeedUnit, final SurveyPersistentState surveyPersistentState, final E e) {
        if (surveyPersistentState.f9925a != com.facebook.feedplugins.survey.SurveyPersistentState.State.SAVING) {
            String v;
            surveyPersistentState.f9925a = com.facebook.feedplugins.survey.SurveyPersistentState.State.SAVING;
            if (Strings.isNullOrEmpty(surveyPersistentState.f9927c)) {
                v = graphQLSurveyFeedUnit.v();
            } else {
                v = surveyPersistentState.f9927c;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("submitSurveyResponseParamsKey", new SubmitSurveyResponseParams(graphQLSurveyFeedUnit.s() != null ? graphQLSurveyFeedUnit.s().k() : null, str, str2, v));
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f9922c, "feed_submit_survey_response", bundle, 1820597467).a(), new OperationResultFutureCallback(this) {
                final /* synthetic */ SurveyPagePartDefinition f9915d;

                protected final void m10281a(Object obj) {
                    boolean z;
                    OperationResult operationResult = (OperationResult) obj;
                    surveyPersistentState.f9929e = true;
                    SurveyPagePartDefinition surveyPagePartDefinition = this.f9915d;
                    GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = graphQLSurveyFeedUnit;
                    SurveyPersistentState surveyPersistentState = surveyPersistentState;
                    if (surveyPersistentState.f9925a == com.facebook.feedplugins.survey.SurveyPersistentState.State.SAVING) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("markSurveyCompletedParamsKey", new MarkSurveyCompletedParams(graphQLSurveyFeedUnit.g(), graphQLSurveyFeedUnit.getType().toString()));
                    BlueServiceOperationFactoryDetour.a(surveyPagePartDefinition.f9922c, "feed_mark_survey_completed", bundle, 771714624).a(true).a();
                    surveyPersistentState.f9925a = com.facebook.feedplugins.survey.SurveyPersistentState.State.NONE;
                    SubmitSurveyResponseResult submitSurveyResponseResult = (SubmitSurveyResponseResult) operationResult.h();
                    surveyPersistentState.f9927c = submitSurveyResponseResult.a;
                    surveyPersistentState.f9928d = submitSurveyResponseResult.b;
                    if (submitSurveyResponseResult.b != null) {
                        surveyPersistentState.f9926b++;
                    } else {
                        surveyPersistentState.f9925a = com.facebook.feedplugins.survey.SurveyPersistentState.State.COMPLETE;
                    }
                    ((HasInvalidate) e).a(new Object[]{graphQLSurveyFeedUnit});
                }

                protected final void m10280a(ServiceException serviceException) {
                    boolean z;
                    surveyPersistentState.f9929e = true;
                    SurveyPagePartDefinition surveyPagePartDefinition = this.f9915d;
                    SurveyPersistentState surveyPersistentState = surveyPersistentState;
                    if (surveyPersistentState.f9925a == com.facebook.feedplugins.survey.SurveyPersistentState.State.SAVING) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    surveyPersistentState.f9925a = com.facebook.feedplugins.survey.SurveyPersistentState.State.NONE;
                    surveyPagePartDefinition.f9921b.b(new ToastBuilder(2131233389));
                    ((HasInvalidate) e).a(new Object[]{graphQLSurveyFeedUnit});
                }
            }, this.f9924e);
        }
    }

    public final Object m10289a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        final GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) feedProps.a;
        subParts.a(this.f9923d, new StylingData(feedProps, PaddingStyle.a));
        final SurveyPersistentState surveyPersistentState = (SurveyPersistentState) hasPersistentState.a(new SurveyStoryKey(graphQLSurveyFeedUnit), graphQLSurveyFeedUnit);
        return new State(surveyPersistentState, new OnClickListener(this) {
            final /* synthetic */ SurveyPagePartDefinition f9911d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 470465990);
                this.f9911d.m10286a((String) view.getTag(2131558532), (String) view.getTag(2131558533), graphQLSurveyFeedUnit, surveyPersistentState, hasPersistentState);
                Logger.a(2, EntryType.UI_INPUT_END, 371824506, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m10290a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1643079889);
        m10283a((FeedProps) obj, (State) obj2, (SurveyFeedUnitView) view);
        Logger.a(8, EntryType.MARK_POP, 1666240294, a);
    }

    public final void m10292b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((SurveyFeedUnitView) view).setAnswerClickListener(null);
    }

    public static SurveyPagePartDefinition m10282a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SurveyPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9920g) {
                SurveyPagePartDefinition surveyPagePartDefinition;
                if (a2 != null) {
                    surveyPagePartDefinition = (SurveyPagePartDefinition) a2.a(f9920g);
                } else {
                    surveyPagePartDefinition = f9919f;
                }
                if (surveyPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10287b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9920g, b3);
                        } else {
                            f9919f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = surveyPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SurveyPagePartDefinition(Toaster toaster, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, BackgroundPartDefinition backgroundPartDefinition, Executor executor) {
        this.f9921b = toaster;
        this.f9922c = defaultBlueServiceOperationFactory;
        this.f9923d = backgroundPartDefinition;
        this.f9924e = executor;
    }

    public final ViewType m10288a() {
        return f9918a;
    }

    public final boolean m10291a(Object obj) {
        return true;
    }

    private void m10283a(FeedProps<GraphQLSurveyFeedUnit> feedProps, State state, SurveyFeedUnitView surveyFeedUnitView) {
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) feedProps.a;
        SurveyPersistentState surveyPersistentState = state.f9916a;
        if (surveyPersistentState.f9929e) {
            int childCount = surveyFeedUnitView.f9880b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = surveyFeedUnitView.f9880b.getChildAt(i);
                if (null == null) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setEnabled(z);
            }
            surveyPersistentState.f9929e = false;
        }
        m10284a(surveyFeedUnitView, state, graphQLSurveyFeedUnit);
    }

    private void m10284a(SurveyFeedUnitView surveyFeedUnitView, State state, GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
        GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion;
        String str = state.f9916a.f9928d;
        GraphQLStructuredSurvey s = graphQLSurveyFeedUnit.s();
        if (StringUtil.a(str)) {
            GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion2;
            if (s.j() == null || s.j().a() == null || s.j().a().isEmpty()) {
                graphQLStructuredSurveyQuestion2 = null;
            } else {
                graphQLStructuredSurveyQuestion2 = GraphQLHelper.a(s, ((GraphQLStructuredSurveyQuestion) s.j().a().get(0)).k());
            }
            graphQLStructuredSurveyQuestion = graphQLStructuredSurveyQuestion2;
        } else {
            graphQLStructuredSurveyQuestion = GraphQLHelper.a(s, str);
        }
        GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion3 = graphQLStructuredSurveyQuestion;
        if (graphQLSurveyFeedUnit.E().b || state.f9916a.f9925a == com.facebook.feedplugins.survey.SurveyPersistentState.State.COMPLETE || graphQLStructuredSurveyQuestion3 == null) {
            surveyFeedUnitView.setQuestionActive(false);
            surveyFeedUnitView.setCompleteLayoutActive(true);
        } else {
            surveyFeedUnitView.f9879a.setText(graphQLStructuredSurveyQuestion3.j().a());
            surveyFeedUnitView.setQuestionActive(true);
            surveyFeedUnitView.setCompleteLayoutActive(false);
            ImmutableList o = graphQLStructuredSurveyQuestion3.o();
            int size = o.size();
            int i = 0;
            while (i < 5) {
                surveyFeedUnitView.m10256a(i, i < size ? (GraphQLStructuredSurveyResponseOption) o.get(i) : null, graphQLStructuredSurveyQuestion3.k());
                i++;
            }
        }
        surveyFeedUnitView.setAnswerClickListener(state.f9917b);
    }
}
