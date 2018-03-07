package com.facebook.feedplugins.survey;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
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
/* compiled from: animationType */
public class SurveyGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLSurveyFeedUnit>, Void, FeedEnvironment> {
    private static SurveyGroupPartDefinition f9882c;
    private static final Object f9883d = new Object();
    private final SurveyPagePartDefinition<FeedEnvironment> f9884a;
    private final SurveyHeaderPartDefinition<FeedEnvironment> f9885b;

    private static SurveyGroupPartDefinition m10258b(InjectorLike injectorLike) {
        return new SurveyGroupPartDefinition(SurveyHeaderPartDefinition.m10261a(injectorLike), SurveyPagePartDefinition.m10282a(injectorLike));
    }

    public final Object m10259a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        baseMultiRowSubParts.a(this.f9885b, feedProps);
        baseMultiRowSubParts.a(this.f9884a, feedProps);
        return null;
    }

    @Inject
    public SurveyGroupPartDefinition(SurveyHeaderPartDefinition surveyHeaderPartDefinition, SurveyPagePartDefinition surveyPagePartDefinition) {
        this.f9884a = surveyPagePartDefinition;
        this.f9885b = surveyHeaderPartDefinition;
    }

    public final boolean m10260a(Object obj) {
        return true;
    }

    public static SurveyGroupPartDefinition m10257a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SurveyGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9883d) {
                SurveyGroupPartDefinition surveyGroupPartDefinition;
                if (a2 != null) {
                    surveyGroupPartDefinition = (SurveyGroupPartDefinition) a2.a(f9883d);
                } else {
                    surveyGroupPartDefinition = f9882c;
                }
                if (surveyGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10258b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9883d, b3);
                        } else {
                            f9882c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = surveyGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
