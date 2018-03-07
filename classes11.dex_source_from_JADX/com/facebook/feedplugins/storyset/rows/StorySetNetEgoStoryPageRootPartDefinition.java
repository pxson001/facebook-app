package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.graphqlstory.page.GraphQLHscrollTopStoryPageTextPartDefinition;
import com.facebook.feedplugins.storyset.rows.components.StorySetPageHeaderComponentPartDefinition;
import com.facebook.feedplugins.storyset.rows.ui.NetEgoStoryPageView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: autoCorrect */
public class StorySetNetEgoStoryPageRootPartDefinition extends BaseSinglePartDefinition<StorySetPageProps, Void, FeedEnvironment, NetEgoStoryPageView> {
    private static StorySetNetEgoStoryPageRootPartDefinition f9703g;
    private static final Object f9704h = new Object();
    public final AndroidComponentsExperimentHelper f9705a;
    private final StorySetPageHeaderPartDefinition f9706b;
    private final GraphQLHscrollTopStoryPageTextPartDefinition f9707c;
    private final StorySetPageFooterPartDefinition f9708d;
    private final BackgroundPartDefinition f9709e;
    private final StorySetPageHeaderComponentPartDefinition f9710f;

    private static StorySetNetEgoStoryPageRootPartDefinition m10169b(InjectorLike injectorLike) {
        return new StorySetNetEgoStoryPageRootPartDefinition(AndroidComponentsExperimentHelper.a(injectorLike), StorySetPageHeaderPartDefinition.m10179a(injectorLike), GraphQLHscrollTopStoryPageTextPartDefinition.a(injectorLike), StorySetPageFooterPartDefinition.m10176a(injectorLike), BackgroundPartDefinition.a(injectorLike), StorySetPageHeaderComponentPartDefinition.m10242a(injectorLike));
    }

    public final Object m10170a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps feedProps = storySetPageProps.f9733b;
        StorySetPageProps storySetPageProps2 = new StorySetPageProps(storySetPageProps.f9732a, storySetPageProps.f9734c, storySetPageProps.f9735d, false);
        if (this.f9705a.m()) {
            subParts.a(2131564191, this.f9710f, storySetPageProps2);
        } else {
            subParts.a(2131562634, this.f9706b, storySetPageProps2);
        }
        subParts.a(2131564192, this.f9707c, feedProps);
        subParts.a(this.f9708d, storySetPageProps2.f9733b);
        subParts.a(this.f9709e, new StylingData(Builder.e().h().i()));
        return null;
    }

    @Inject
    public StorySetNetEgoStoryPageRootPartDefinition(AndroidComponentsExperimentHelper androidComponentsExperimentHelper, StorySetPageHeaderPartDefinition storySetPageHeaderPartDefinition, GraphQLHscrollTopStoryPageTextPartDefinition graphQLHscrollTopStoryPageTextPartDefinition, StorySetPageFooterPartDefinition storySetPageFooterPartDefinition, BackgroundPartDefinition backgroundPartDefinition, StorySetPageHeaderComponentPartDefinition storySetPageHeaderComponentPartDefinition) {
        this.f9705a = androidComponentsExperimentHelper;
        this.f9706b = storySetPageHeaderPartDefinition;
        this.f9707c = graphQLHscrollTopStoryPageTextPartDefinition;
        this.f9708d = storySetPageFooterPartDefinition;
        this.f9709e = backgroundPartDefinition;
        this.f9710f = storySetPageHeaderComponentPartDefinition;
    }

    public static StorySetNetEgoStoryPageRootPartDefinition m10168a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetNetEgoStoryPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9704h) {
                StorySetNetEgoStoryPageRootPartDefinition storySetNetEgoStoryPageRootPartDefinition;
                if (a2 != null) {
                    storySetNetEgoStoryPageRootPartDefinition = (StorySetNetEgoStoryPageRootPartDefinition) a2.a(f9704h);
                } else {
                    storySetNetEgoStoryPageRootPartDefinition = f9703g;
                }
                if (storySetNetEgoStoryPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10169b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9704h, b3);
                        } else {
                            f9703g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetNetEgoStoryPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
