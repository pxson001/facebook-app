package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
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
/* compiled from: c1508da31fa2d46f5f4426b3839bca9a */
public class ResearchPollSurveySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLResearchPollFeedUnit, Void, FeedEnvironment> {
    private static ResearchPollSurveySelectorPartDefinition f9125c;
    private static final Object f9126d = new Object();
    private final ResearchPollSurveyOpenPartDefinition f9127a;
    private final ResearchPollSurveyClosedPartDefinition f9128b;

    private static ResearchPollSurveySelectorPartDefinition m9814b(InjectorLike injectorLike) {
        return new ResearchPollSurveySelectorPartDefinition(ResearchPollSurveyClosedPartDefinition.m9786a(injectorLike), ResearchPollSurveyOpenPartDefinition.m9793a(injectorLike));
    }

    public final Object m9815a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f9127a, graphQLResearchPollFeedUnit).a(this.f9128b, graphQLResearchPollFeedUnit);
        return null;
    }

    @Inject
    public ResearchPollSurveySelectorPartDefinition(ResearchPollSurveyClosedPartDefinition researchPollSurveyClosedPartDefinition, ResearchPollSurveyOpenPartDefinition researchPollSurveyOpenPartDefinition) {
        this.f9127a = researchPollSurveyOpenPartDefinition;
        this.f9128b = researchPollSurveyClosedPartDefinition;
    }

    public final boolean m9816a(Object obj) {
        return true;
    }

    public static ResearchPollSurveySelectorPartDefinition m9813a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollSurveySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9126d) {
                ResearchPollSurveySelectorPartDefinition researchPollSurveySelectorPartDefinition;
                if (a2 != null) {
                    researchPollSurveySelectorPartDefinition = (ResearchPollSurveySelectorPartDefinition) a2.a(f9126d);
                } else {
                    researchPollSurveySelectorPartDefinition = f9125c;
                }
                if (researchPollSurveySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9814b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9126d, b3);
                        } else {
                            f9125c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollSurveySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
