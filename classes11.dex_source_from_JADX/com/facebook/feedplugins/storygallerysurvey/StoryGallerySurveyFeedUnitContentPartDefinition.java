package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.storygallerysurvey.ui.StoryGallerySurveyFeedUnitContentView;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: bookmarknux/ */
public class StoryGallerySurveyFeedUnitContentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, String, HasPositionInformation, StoryGallerySurveyFeedUnitContentView> {
    public static final ViewType f9480a = new C11291();
    private static StoryGallerySurveyFeedUnitContentPartDefinition f9481c;
    private static final Object f9482d = new Object();
    private final BackgroundPartDefinition f9483b;

    /* compiled from: bookmarknux/ */
    final class C11291 extends ViewType {
        C11291() {
        }

        public final View m10029a(Context context) {
            return new StoryGallerySurveyFeedUnitContentView(context);
        }
    }

    private static StoryGallerySurveyFeedUnitContentPartDefinition m10031b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitContentPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m10033a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) feedProps.a;
        subParts.a(this.f9483b, new StylingData(feedProps, PaddingStyle.a));
        return graphQLStoryGallerySurveyFeedUnit.r() != null ? graphQLStoryGallerySurveyFeedUnit.r().a() : null;
    }

    public final /* bridge */ /* synthetic */ void m10034a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 727950598);
        ((StoryGallerySurveyFeedUnitContentView) view).f9536h.setText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, -1632282463, a);
    }

    @Inject
    public StoryGallerySurveyFeedUnitContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f9483b = backgroundPartDefinition;
    }

    public final ViewType m10032a() {
        return f9480a;
    }

    public final boolean m10035a(Object obj) {
        return true;
    }

    public static StoryGallerySurveyFeedUnitContentPartDefinition m10030a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9482d) {
                StoryGallerySurveyFeedUnitContentPartDefinition storyGallerySurveyFeedUnitContentPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitContentPartDefinition = (StoryGallerySurveyFeedUnitContentPartDefinition) a2.a(f9482d);
                } else {
                    storyGallerySurveyFeedUnitContentPartDefinition = f9481c;
                }
                if (storyGallerySurveyFeedUnitContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10031b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9482d, b3);
                        } else {
                            f9481c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
