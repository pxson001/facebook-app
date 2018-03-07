package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
/* compiled from: ble_supported */
public class StoryGallerySurveyFeedUnitSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, Void, FeedEnvironment> {
    private static StoryGallerySurveyFeedUnitSelectorPartDefinition f9498c;
    private static final Object f9499d = new Object();
    private final EmptyStoryGallerySurveyFeedUnitPartDefinition f9500a;
    private final StoryGallerySurveyFeedUnitPartDefinition f9501b;

    private static StoryGallerySurveyFeedUnitSelectorPartDefinition m10054b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitSelectorPartDefinition(StoryGallerySurveyFeedUnitPartDefinition.m10042a(injectorLike), EmptyStoryGallerySurveyFeedUnitPartDefinition.m10024a(injectorLike));
    }

    public final Object m10055a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f9501b, feedProps).a(this.f9500a, feedProps);
        return null;
    }

    @Inject
    public StoryGallerySurveyFeedUnitSelectorPartDefinition(StoryGallerySurveyFeedUnitPartDefinition storyGallerySurveyFeedUnitPartDefinition, EmptyStoryGallerySurveyFeedUnitPartDefinition emptyStoryGallerySurveyFeedUnitPartDefinition) {
        this.f9500a = emptyStoryGallerySurveyFeedUnitPartDefinition;
        this.f9501b = storyGallerySurveyFeedUnitPartDefinition;
    }

    public final boolean m10056a(Object obj) {
        return true;
    }

    public static StoryGallerySurveyFeedUnitSelectorPartDefinition m10053a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9499d) {
                StoryGallerySurveyFeedUnitSelectorPartDefinition storyGallerySurveyFeedUnitSelectorPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitSelectorPartDefinition = (StoryGallerySurveyFeedUnitSelectorPartDefinition) a2.a(f9499d);
                } else {
                    storyGallerySurveyFeedUnitSelectorPartDefinition = f9498c;
                }
                if (storyGallerySurveyFeedUnitSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10054b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9499d, b3);
                        } else {
                            f9498c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
