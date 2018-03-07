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
/* compiled from: became_visible */
public class NetEgoStorySetStoryPageRootPartDefinition extends BaseSinglePartDefinition<NetEgoStorySetPageProps, Void, FeedEnvironment, NetEgoStoryPageView> {
    private static NetEgoStorySetStoryPageRootPartDefinition f9574f;
    private static final Object f9575g = new Object();
    private final AndroidComponentsExperimentHelper f9576a;
    private final NetEgoStorySetPageHeaderPartDefinition f9577b;
    private final GraphQLHscrollTopStoryPageTextPartDefinition f9578c;
    private final StorySetPageFooterPartDefinition f9579d;
    private final BackgroundPartDefinition f9580e;

    private static NetEgoStorySetStoryPageRootPartDefinition m10095b(InjectorLike injectorLike) {
        return new NetEgoStorySetStoryPageRootPartDefinition(AndroidComponentsExperimentHelper.a(injectorLike), NetEgoStorySetPageHeaderPartDefinition.m10086a(injectorLike), GraphQLHscrollTopStoryPageTextPartDefinition.a(injectorLike), StorySetPageFooterPartDefinition.m10176a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m10096a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NetEgoStorySetPageProps netEgoStorySetPageProps = (NetEgoStorySetPageProps) obj;
        FeedProps feedProps = netEgoStorySetPageProps.f9564b;
        NetEgoStorySetPageProps netEgoStorySetPageProps2 = new NetEgoStorySetPageProps(netEgoStorySetPageProps.f9563a, netEgoStorySetPageProps.f9565c, netEgoStorySetPageProps.f9566d, false);
        subParts.a(2131562634, this.f9577b, netEgoStorySetPageProps2);
        subParts.a(2131564192, this.f9578c, feedProps);
        subParts.a(this.f9579d, netEgoStorySetPageProps2.f9564b);
        subParts.a(this.f9580e, new StylingData(Builder.e().h().i()));
        return null;
    }

    @Inject
    public NetEgoStorySetStoryPageRootPartDefinition(AndroidComponentsExperimentHelper androidComponentsExperimentHelper, NetEgoStorySetPageHeaderPartDefinition netEgoStorySetPageHeaderPartDefinition, GraphQLHscrollTopStoryPageTextPartDefinition graphQLHscrollTopStoryPageTextPartDefinition, StorySetPageFooterPartDefinition storySetPageFooterPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f9576a = androidComponentsExperimentHelper;
        this.f9577b = netEgoStorySetPageHeaderPartDefinition;
        this.f9578c = graphQLHscrollTopStoryPageTextPartDefinition;
        this.f9579d = storySetPageFooterPartDefinition;
        this.f9580e = backgroundPartDefinition;
    }

    public final boolean m10097a() {
        return this.f9576a.m();
    }

    public static NetEgoStorySetStoryPageRootPartDefinition m10094a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NetEgoStorySetStoryPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9575g) {
                NetEgoStorySetStoryPageRootPartDefinition netEgoStorySetStoryPageRootPartDefinition;
                if (a2 != null) {
                    netEgoStorySetStoryPageRootPartDefinition = (NetEgoStorySetStoryPageRootPartDefinition) a2.a(f9575g);
                } else {
                    netEgoStorySetStoryPageRootPartDefinition = f9574f;
                }
                if (netEgoStorySetStoryPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10095b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9575g, b3);
                        } else {
                            f9574f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = netEgoStorySetStoryPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
