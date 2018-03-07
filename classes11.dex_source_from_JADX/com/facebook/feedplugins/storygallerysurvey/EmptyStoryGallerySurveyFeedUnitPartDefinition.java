package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
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
/* compiled from: boosted_page_like_promotion_info */
public class EmptyStoryGallerySurveyFeedUnitPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f9476a = new C11281();
    private static EmptyStoryGallerySurveyFeedUnitPartDefinition f9477c;
    private static final Object f9478d = new Object();
    private final BackgroundPartDefinition f9479b;

    /* compiled from: boosted_page_like_promotion_info */
    final class C11281 extends ViewType {
        C11281() {
        }

        public final View m10023a(Context context) {
            return LayoutInflater.from(context).inflate(2130903972, null);
        }
    }

    private static EmptyStoryGallerySurveyFeedUnitPartDefinition m10025b(InjectorLike injectorLike) {
        return new EmptyStoryGallerySurveyFeedUnitPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m10027a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9479b, new StylingData((FeedProps) obj, PaddingStyle.p, Position.BOTTOM));
        return null;
    }

    @Inject
    public EmptyStoryGallerySurveyFeedUnitPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f9479b = backgroundPartDefinition;
    }

    public final ViewType m10026a() {
        return f9476a;
    }

    public final boolean m10028a(Object obj) {
        return false;
    }

    public static EmptyStoryGallerySurveyFeedUnitPartDefinition m10024a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EmptyStoryGallerySurveyFeedUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9478d) {
                EmptyStoryGallerySurveyFeedUnitPartDefinition emptyStoryGallerySurveyFeedUnitPartDefinition;
                if (a2 != null) {
                    emptyStoryGallerySurveyFeedUnitPartDefinition = (EmptyStoryGallerySurveyFeedUnitPartDefinition) a2.a(f9478d);
                } else {
                    emptyStoryGallerySurveyFeedUnitPartDefinition = f9477c;
                }
                if (emptyStoryGallerySurveyFeedUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10025b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9478d, b3);
                        } else {
                            f9477c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = emptyStoryGallerySurveyFeedUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
