package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: blurTextInput */
public class StoryGallerySurveyFeedUnitHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryGallerySurveyFeedUnit>, Void, HasPositionInformation, TextWithMenuButtonView> {
    private static final PaddingStyle f9484a = PaddingStyle.j;
    private static StoryGallerySurveyFeedUnitHeaderPartDefinition f9485c;
    private static final Object f9486d = new Object();
    private final BackgroundPartDefinition f9487b;

    private static StoryGallerySurveyFeedUnitHeaderPartDefinition m10037b(InjectorLike injectorLike) {
        return new StoryGallerySurveyFeedUnitHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m10039a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9487b, new StylingData((FeedProps) obj, f9484a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10040a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -152651785);
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.a(((GraphQLStoryGallerySurveyFeedUnit) ((FeedProps) obj).a).t().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 601768824, a);
    }

    @Inject
    public StoryGallerySurveyFeedUnitHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f9487b = backgroundPartDefinition;
    }

    public final boolean m10041a(Object obj) {
        return true;
    }

    public final ViewType m10038a() {
        return TextWithMenuButtonView.b;
    }

    public static StoryGallerySurveyFeedUnitHeaderPartDefinition m10036a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyFeedUnitHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9486d) {
                StoryGallerySurveyFeedUnitHeaderPartDefinition storyGallerySurveyFeedUnitHeaderPartDefinition;
                if (a2 != null) {
                    storyGallerySurveyFeedUnitHeaderPartDefinition = (StoryGallerySurveyFeedUnitHeaderPartDefinition) a2.a(f9486d);
                } else {
                    storyGallerySurveyFeedUnitHeaderPartDefinition = f9485c;
                }
                if (storyGallerySurveyFeedUnitHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10037b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9486d, b3);
                        } else {
                            f9485c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyFeedUnitHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
