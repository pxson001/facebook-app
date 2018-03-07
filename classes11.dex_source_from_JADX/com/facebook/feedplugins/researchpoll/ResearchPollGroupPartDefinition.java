package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: campaignID */
public class ResearchPollGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLResearchPollFeedUnit>, Void, FeedEnvironment> {
    private static ResearchPollGroupPartDefinition f9038e;
    private static final Object f9039f = new Object();
    private final ResearchPollResultsHScrollPartDefinition f9040a;
    private final ResearchPollSingleResultPartDefinition f9041b;
    private final ResearchPollSurveySelectorPartDefinition f9042c;
    private final ResearchPollHeaderPartDefinition<FeedEnvironment> f9043d;

    private static ResearchPollGroupPartDefinition m9742b(InjectorLike injectorLike) {
        return new ResearchPollGroupPartDefinition(ResearchPollHeaderPartDefinition.m9745a(injectorLike), ResearchPollSurveySelectorPartDefinition.m9813a(injectorLike), ResearchPollSingleResultPartDefinition.m9778a(injectorLike), ResearchPollResultsHScrollPartDefinition.m9771a(injectorLike));
    }

    public final Object m9743a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f9043d, feedProps);
        baseMultiRowSubParts.a(this.f9041b, feedProps);
        baseMultiRowSubParts.a(this.f9040a, feedProps);
        baseMultiRowSubParts.a(this.f9042c, graphQLResearchPollFeedUnit);
        return null;
    }

    @Inject
    public ResearchPollGroupPartDefinition(ResearchPollHeaderPartDefinition researchPollHeaderPartDefinition, ResearchPollSurveySelectorPartDefinition researchPollSurveySelectorPartDefinition, ResearchPollSingleResultPartDefinition researchPollSingleResultPartDefinition, ResearchPollResultsHScrollPartDefinition researchPollResultsHScrollPartDefinition) {
        this.f9040a = researchPollResultsHScrollPartDefinition;
        this.f9041b = researchPollSingleResultPartDefinition;
        this.f9042c = researchPollSurveySelectorPartDefinition;
        this.f9043d = researchPollHeaderPartDefinition;
    }

    public final boolean m9744a(Object obj) {
        return true;
    }

    public static ResearchPollGroupPartDefinition m9741a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9039f) {
                ResearchPollGroupPartDefinition researchPollGroupPartDefinition;
                if (a2 != null) {
                    researchPollGroupPartDefinition = (ResearchPollGroupPartDefinition) a2.a(f9039f);
                } else {
                    researchPollGroupPartDefinition = f9038e;
                }
                if (researchPollGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9742b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9039f, b3);
                        } else {
                            f9038e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
