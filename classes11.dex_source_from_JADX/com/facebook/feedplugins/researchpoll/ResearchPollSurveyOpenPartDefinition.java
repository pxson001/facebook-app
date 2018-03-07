package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cacheEnabled */
public class ResearchPollSurveyOpenPartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<GraphQLResearchPollFeedUnit, Void, E, ResearchPollSurveyView> {
    private static ResearchPollSurveyOpenPartDefinition f9101b;
    private static final Object f9102c = new Object();
    private final ResearchPollSurveyPartDefinition f9103a;

    private static ResearchPollSurveyOpenPartDefinition m9794b(InjectorLike injectorLike) {
        return new ResearchPollSurveyOpenPartDefinition(ResearchPollSurveyPartDefinition.m9799a(injectorLike));
    }

    public final Object m9796a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.a(this.f9103a, graphQLResearchPollFeedUnit);
        if (!graphQLResearchPollFeedUnit.U().b) {
            ((ResearchPollPersistentState) ((HasPersistentState) hasInvalidate).a(new ResearchPollStoryKey(graphQLResearchPollFeedUnit), graphQLResearchPollFeedUnit)).f9076g = true;
        }
        return null;
    }

    public final boolean m9797a(Object obj) {
        return 1 != 0 && ResearchPollSurveyPartDefinition.m9806a((GraphQLResearchPollFeedUnit) obj);
    }

    @Inject
    public ResearchPollSurveyOpenPartDefinition(ResearchPollSurveyPartDefinition researchPollSurveyPartDefinition) {
        this.f9103a = researchPollSurveyPartDefinition;
    }

    public final ViewType m9795a() {
        return this.f9103a.m9808a();
    }

    public static ResearchPollSurveyOpenPartDefinition m9793a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollSurveyOpenPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9102c) {
                ResearchPollSurveyOpenPartDefinition researchPollSurveyOpenPartDefinition;
                if (a2 != null) {
                    researchPollSurveyOpenPartDefinition = (ResearchPollSurveyOpenPartDefinition) a2.a(f9102c);
                } else {
                    researchPollSurveyOpenPartDefinition = f9101b;
                }
                if (researchPollSurveyOpenPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9794b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9102c, b3);
                        } else {
                            f9101b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollSurveyOpenPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
