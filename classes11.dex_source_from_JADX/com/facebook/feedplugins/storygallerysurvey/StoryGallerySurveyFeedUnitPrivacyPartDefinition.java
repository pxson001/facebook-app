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
import com.facebook.feedplugins.storygallerysurvey.ui.StoryGallerySurveyFeedUnitPrivacySectionView;
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
/* compiled from: bluetooth_supported */
public class StoryGallerySurveyFeedUnitPrivacyPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, String, HasPositionInformation, StoryGallerySurveyFeedUnitPrivacySectionView> {
    public static final ViewType f9494a = new C11301();
    private static StoryGallerySurveyFeedUnitPrivacyPartDefinition f9495c;
    private static final Object f9496d = new Object();
    private final BackgroundPartDefinition f9497b;

    /* compiled from: bluetooth_supported */
    final class C11301 extends ViewType {
        C11301() {
        }

        public final View m10046a(Context context) {
            return new StoryGallerySurveyFeedUnitPrivacySectionView(context);
        }
    }

    private static StoryGallerySurveyFeedUnitPrivacyPartDefinition m10048b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitPrivacyPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m10050a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) feedProps.a;
        subParts.a(this.f9497b, new StylingData(feedProps, PaddingStyle.a));
        return graphQLStoryGallerySurveyFeedUnit.m() != null ? graphQLStoryGallerySurveyFeedUnit.m().a() : null;
    }

    public final /* bridge */ /* synthetic */ void m10051a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 994987067);
        ((StoryGallerySurveyFeedUnitPrivacySectionView) view).f9537h.setText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, 466546778, a);
    }

    @Inject
    public StoryGallerySurveyFeedUnitPrivacyPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f9497b = backgroundPartDefinition;
    }

    public final ViewType m10049a() {
        return f9494a;
    }

    public final boolean m10052a(Object obj) {
        return true;
    }

    public static StoryGallerySurveyFeedUnitPrivacyPartDefinition m10047a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitPrivacyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9496d) {
                StoryGallerySurveyFeedUnitPrivacyPartDefinition storyGallerySurveyFeedUnitPrivacyPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitPrivacyPartDefinition = (StoryGallerySurveyFeedUnitPrivacyPartDefinition) a2.a(f9496d);
                } else {
                    storyGallerySurveyFeedUnitPrivacyPartDefinition = f9495c;
                }
                if (storyGallerySurveyFeedUnitPrivacyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10048b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9496d, b3);
                        } else {
                            f9495c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitPrivacyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
