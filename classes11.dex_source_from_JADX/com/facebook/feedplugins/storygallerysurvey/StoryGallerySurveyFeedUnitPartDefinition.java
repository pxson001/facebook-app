package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
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
/* compiled from: blurOnSubmit */
public class StoryGallerySurveyFeedUnitPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, Void, FeedEnvironment> {
    private static StoryGallerySurveyFeedUnitPartDefinition f9488e;
    private static final Object f9489f = new Object();
    private final StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition f9490a;
    private final StoryGallerySurveyFeedUnitPrivacyPartDefinition f9491b;
    private final StoryGallerySurveyFeedUnitContentPartDefinition f9492c;
    private final StoryGallerySurveyFeedUnitHeaderPartDefinition f9493d;

    private static StoryGallerySurveyFeedUnitPartDefinition m10043b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitPartDefinition(StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition.m10057a(injectorLike), StoryGallerySurveyFeedUnitPrivacyPartDefinition.m10047a(injectorLike), StoryGallerySurveyFeedUnitContentPartDefinition.m10030a(injectorLike), StoryGallerySurveyFeedUnitHeaderPartDefinition.m10036a(injectorLike));
    }

    public final Object m10044a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f9493d, feedProps);
        baseMultiRowSubParts.a(this.f9492c, feedProps);
        baseMultiRowSubParts.a(this.f9491b, feedProps);
        baseMultiRowSubParts.a(this.f9490a, graphQLStoryGallerySurveyFeedUnit);
        return null;
    }

    @Inject
    public StoryGallerySurveyFeedUnitPartDefinition(StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition, StoryGallerySurveyFeedUnitPrivacyPartDefinition storyGallerySurveyFeedUnitPrivacyPartDefinition, StoryGallerySurveyFeedUnitContentPartDefinition storyGallerySurveyFeedUnitContentPartDefinition, StoryGallerySurveyFeedUnitHeaderPartDefinition storyGallerySurveyFeedUnitHeaderPartDefinition) {
        this.f9490a = storyGallerySurveyFeedUnitTwoButtonFooterPartDefinition;
        this.f9491b = storyGallerySurveyFeedUnitPrivacyPartDefinition;
        this.f9492c = storyGallerySurveyFeedUnitContentPartDefinition;
        this.f9493d = storyGallerySurveyFeedUnitHeaderPartDefinition;
    }

    public final boolean m10045a(Object obj) {
        return true;
    }

    public static StoryGallerySurveyFeedUnitPartDefinition m10042a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9489f) {
                StoryGallerySurveyFeedUnitPartDefinition storyGallerySurveyFeedUnitPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitPartDefinition = (StoryGallerySurveyFeedUnitPartDefinition) a2.a(f9489f);
                } else {
                    storyGallerySurveyFeedUnitPartDefinition = f9488e;
                }
                if (storyGallerySurveyFeedUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10043b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9489f, b3);
                        } else {
                            f9488e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
