package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feedplugins.graphqlstory.page.GraphQLStoryPageTextPartDefinition;
import com.facebook.feedplugins.storyset.rows.components.StorySetPageHeaderComponentPartDefinition;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageView;
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
/* compiled from: batch_rerun */
public class StorySetBasicPagePartDefinition<E extends CanLikePage & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasIsAsync> extends BaseSinglePartDefinition<StorySetPageProps, Void, E, StoryPageView> {
    private static StorySetBasicPagePartDefinition f9617i;
    private static final Object f9618j = new Object();
    private final AndroidComponentsExperimentHelper f9619a;
    private final StorySetPageSocialContextPartDefinition f9620b;
    private final StorySetPageHeaderPartDefinition<E> f9621c;
    private final GraphQLStoryPageTextPartDefinition f9622d;
    private final StorySetPageFooterPartDefinition<E, StoryPageView> f9623e;
    private final StorySetLabelWithButtonPartDefinition f9624f;
    private final StorySetBackgroundPartDefinition f9625g;
    private final StorySetPageHeaderComponentPartDefinition<E> f9626h;

    private static StorySetBasicPagePartDefinition m10123b(InjectorLike injectorLike) {
        return new StorySetBasicPagePartDefinition(AndroidComponentsExperimentHelper.a(injectorLike), StorySetBackgroundPartDefinition.m10119a(injectorLike), StorySetPageSocialContextPartDefinition.m10189a(injectorLike), StorySetPageHeaderPartDefinition.m10179a(injectorLike), GraphQLStoryPageTextPartDefinition.a(injectorLike), StorySetPageFooterPartDefinition.m10176a(injectorLike), StorySetLabelWithButtonPartDefinition.m10156a(injectorLike), StorySetPageHeaderComponentPartDefinition.m10242a(injectorLike));
    }

    public final Object m10124a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps feedProps = storySetPageProps.f9733b;
        subParts.a(this.f9620b, feedProps);
        if (m10125a()) {
            subParts.a(2131564191, this.f9626h, storySetPageProps);
        } else {
            subParts.a(2131562634, this.f9621c, storySetPageProps);
        }
        subParts.a(2131564192, this.f9622d, feedProps);
        subParts.a(2131567715, this.f9624f, StoryProps.i(feedProps));
        subParts.a(this.f9623e, storySetPageProps.f9733b);
        subParts.a(this.f9625g, null);
        return null;
    }

    @Inject
    public StorySetBasicPagePartDefinition(AndroidComponentsExperimentHelper androidComponentsExperimentHelper, StorySetBackgroundPartDefinition storySetBackgroundPartDefinition, StorySetPageSocialContextPartDefinition storySetPageSocialContextPartDefinition, StorySetPageHeaderPartDefinition storySetPageHeaderPartDefinition, GraphQLStoryPageTextPartDefinition graphQLStoryPageTextPartDefinition, StorySetPageFooterPartDefinition storySetPageFooterPartDefinition, StorySetLabelWithButtonPartDefinition storySetLabelWithButtonPartDefinition, StorySetPageHeaderComponentPartDefinition storySetPageHeaderComponentPartDefinition) {
        this.f9619a = androidComponentsExperimentHelper;
        this.f9620b = storySetPageSocialContextPartDefinition;
        this.f9621c = storySetPageHeaderPartDefinition;
        this.f9622d = graphQLStoryPageTextPartDefinition;
        this.f9623e = storySetPageFooterPartDefinition;
        this.f9624f = storySetLabelWithButtonPartDefinition;
        this.f9625g = storySetBackgroundPartDefinition;
        this.f9626h = storySetPageHeaderComponentPartDefinition;
    }

    public static StorySetBasicPagePartDefinition m10122a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetBasicPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9618j) {
                StorySetBasicPagePartDefinition storySetBasicPagePartDefinition;
                if (a2 != null) {
                    storySetBasicPagePartDefinition = (StorySetBasicPagePartDefinition) a2.a(f9618j);
                } else {
                    storySetBasicPagePartDefinition = f9617i;
                }
                if (storySetBasicPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10123b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9618j, b3);
                        } else {
                            f9617i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetBasicPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m10125a() {
        return this.f9619a.m();
    }
}
