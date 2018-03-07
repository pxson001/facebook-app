package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyQuestionPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: in_social_search_experiment */
public class InlineSurveyGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static InlineSurveyGroupPartDefinition f20253e;
    private static final Object f20254f = new Object();
    private final InlineSurveyQuestionPartDefinition f20255a;
    private final InlineSurveyFooterPartDefinition f20256b;
    private final InlineSurveyFeedbackPartDefinition f20257c;
    private GraphQLStoryActionLink f20258d;

    private static InlineSurveyGroupPartDefinition m27924b(InjectorLike injectorLike) {
        return new InlineSurveyGroupPartDefinition(InlineSurveyQuestionPartDefinition.m27928a(injectorLike), InlineSurveyFooterPartDefinition.m27937a(injectorLike), InlineSurveyFeedbackPartDefinition.m27953a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        InlineSurveyPersistentState inlineSurveyPersistentState = (InlineSurveyPersistentState) ((FeedEnvironment) anyEnvironment).mo2425a(new InlineSurveyKey((GraphQLStory) feedProps.f13444a), (CacheableEntity) feedProps.f13444a);
        if (Strings.isNullOrEmpty(this.f20258d.aM())) {
            z = false;
        } else {
            z = true;
        }
        inlineSurveyPersistentState.a = z;
        baseMultiRowSubParts.m19112a(this.f20255a, new Props(true, feedProps, this.f20258d.aO(), this.f20258d.aN(), inlineSurveyPersistentState));
        baseMultiRowSubParts.m19112a(this.f20255a, new Props(false, feedProps, this.f20258d.aM(), this.f20258d.aL(), inlineSurveyPersistentState));
        baseMultiRowSubParts.m19112a(this.f20256b, new InlineSurveyFooterPartDefinition.Props(feedProps, inlineSurveyPersistentState));
        baseMultiRowSubParts.m19112a(this.f20257c, new InlineSurveyFeedbackPartDefinition.Props(feedProps, inlineSurveyPersistentState));
        return null;
    }

    public final boolean mo2536a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        this.f20258d = m27925b(feedProps);
        return (this.f20258d == null || PropertyHelper.m21261a((GraphQLStory) feedProps.f13444a).f14870s) ? false : true;
    }

    @Inject
    public InlineSurveyGroupPartDefinition(InlineSurveyQuestionPartDefinition inlineSurveyQuestionPartDefinition, InlineSurveyFooterPartDefinition inlineSurveyFooterPartDefinition, InlineSurveyFeedbackPartDefinition inlineSurveyFeedbackPartDefinition) {
        this.f20255a = inlineSurveyQuestionPartDefinition;
        this.f20256b = inlineSurveyFooterPartDefinition;
        this.f20257c = inlineSurveyFeedbackPartDefinition;
    }

    public static InlineSurveyGroupPartDefinition m27923a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSurveyGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20254f) {
                InlineSurveyGroupPartDefinition inlineSurveyGroupPartDefinition;
                if (a2 != null) {
                    inlineSurveyGroupPartDefinition = (InlineSurveyGroupPartDefinition) a2.mo818a(f20254f);
                } else {
                    inlineSurveyGroupPartDefinition = f20253e;
                }
                if (inlineSurveyGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27924b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20254f, b3);
                        } else {
                            f20253e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSurveyGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @VisibleForTesting
    private static GraphQLStoryActionLink m27925b(FeedProps<GraphQLStory> feedProps) {
        ImmutableList E = ((GraphQLStory) feedProps.f13444a).m22319E();
        int size = E.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) E.get(i);
            if (graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == 1695485490) {
                return graphQLStoryActionLink;
            }
        }
        return null;
    }
}
