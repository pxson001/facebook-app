package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: keyEquivalence */
public class StoryGallerySurveyInFeedDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static StoryGallerySurveyInFeedDeclaration f18488b;
    private static final Object f18489c = new Object();
    private final Lazy<StoryGallerySurveyFeedUnitSelectorPartDefinition> f18490a;

    private static StoryGallerySurveyInFeedDeclaration m25956b(InjectorLike injectorLike) {
        return new StoryGallerySurveyInFeedDeclaration(IdBasedLazy.m1808a(injectorLike, 6565));
    }

    @Inject
    public StoryGallerySurveyInFeedDeclaration(Lazy<StoryGallerySurveyFeedUnitSelectorPartDefinition> lazy) {
        this.f18490a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(StoryGallerySurveyFeedUnitContentPartDefinition.a);
        listItemRowController.m16558a(StoryGallerySurveyFeedUnitPrivacyPartDefinition.a);
        listItemRowController.m16558a(EmptyStoryGallerySurveyFeedUnitPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLStoryGallerySurveyFeedUnit.class, this.f18490a);
    }

    public static StoryGallerySurveyInFeedDeclaration m25955a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyInFeedDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18489c) {
                StoryGallerySurveyInFeedDeclaration storyGallerySurveyInFeedDeclaration;
                if (a2 != null) {
                    storyGallerySurveyInFeedDeclaration = (StoryGallerySurveyInFeedDeclaration) a2.mo818a(f18489c);
                } else {
                    storyGallerySurveyInFeedDeclaration = f18488b;
                }
                if (storyGallerySurveyInFeedDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25956b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18489c, b3);
                        } else {
                            f18488b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyInFeedDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
