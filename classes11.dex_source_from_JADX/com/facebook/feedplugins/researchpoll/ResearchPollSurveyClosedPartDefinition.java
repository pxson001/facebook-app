package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feed.SubmitResearchPollResponseParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.researchpoll.views.ResearchPollSurveyView;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: cacheFetch */
public class ResearchPollSurveyClosedPartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<GraphQLResearchPollFeedUnit, OnClickListener, E, ResearchPollSurveyView> {
    private static ResearchPollSurveyClosedPartDefinition f9097c;
    private static final Object f9098d = new Object();
    private final ResearchPollSurveyPartDefinition f9099a;
    public final ResearchPollLoggerUtil f9100b;

    private static ResearchPollSurveyClosedPartDefinition m9787b(InjectorLike injectorLike) {
        return new ResearchPollSurveyClosedPartDefinition(ResearchPollSurveyPartDefinition.m9799a(injectorLike), ResearchPollLoggerUtil.m9760a(injectorLike));
    }

    public final Object m9789a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f9099a, graphQLResearchPollFeedUnit);
        return new OnClickListener(this) {
            final /* synthetic */ ResearchPollSurveyClosedPartDefinition f9096c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -85676541);
                String l = graphQLResearchPollFeedUnit.z().l();
                String l2 = graphQLResearchPollFeedUnit.H().l();
                ResearchPollLoggerUtil researchPollLoggerUtil = this.f9096c.f9100b;
                Bundle bundle = new Bundle();
                bundle.putParcelable("submitResearchPollResponseParamsKey", new SubmitResearchPollResponseParams(l2, null, Boolean.valueOf(true), l, null));
                BlueServiceOperationFactoryDetour.a(researchPollLoggerUtil.f9067a, "feed_submit_research_poll_response", bundle, ErrorPropagation.BY_EXCEPTION, researchPollLoggerUtil.f9068b, 1595449107).a(true).a();
                this.f9096c.f9100b.m9762a(l2, "open_poll");
                ((ResearchPollPersistentState) ((HasPersistentState) hasInvalidate).a(new ResearchPollStoryKey(graphQLResearchPollFeedUnit), graphQLResearchPollFeedUnit)).f9076g = true;
                hasInvalidate.a(new Object[]{graphQLResearchPollFeedUnit});
                Logger.a(2, EntryType.UI_INPUT_END, -1417340258, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m9790a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1241515101);
        ((ResearchPollSurveyView) view).setCallToActionViewListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 1593998994, a);
    }

    public final boolean m9791a(Object obj) {
        return (1 == 0 || ResearchPollSurveyPartDefinition.m9806a((GraphQLResearchPollFeedUnit) obj)) ? false : true;
    }

    public final void m9792b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ResearchPollSurveyView) view).setCallToActionViewListener(null);
    }

    @Inject
    public ResearchPollSurveyClosedPartDefinition(ResearchPollSurveyPartDefinition researchPollSurveyPartDefinition, ResearchPollLoggerUtil researchPollLoggerUtil) {
        this.f9100b = researchPollLoggerUtil;
        this.f9099a = researchPollSurveyPartDefinition;
    }

    public final ViewType m9788a() {
        return this.f9099a.m9808a();
    }

    public static ResearchPollSurveyClosedPartDefinition m9786a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollSurveyClosedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9098d) {
                ResearchPollSurveyClosedPartDefinition researchPollSurveyClosedPartDefinition;
                if (a2 != null) {
                    researchPollSurveyClosedPartDefinition = (ResearchPollSurveyClosedPartDefinition) a2.a(f9098d);
                } else {
                    researchPollSurveyClosedPartDefinition = f9097c;
                }
                if (researchPollSurveyClosedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9787b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9098d, b3);
                        } else {
                            f9097c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollSurveyClosedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
