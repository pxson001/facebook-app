package com.facebook.feedplugins.base.blingbar;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hashtag_feed_hashtag */
public class BlingBarFlyoutAndVideoLauncherPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, View> {
    private static BlingBarFlyoutAndVideoLauncherPartDefinition f21206e;
    private static final Object f21207f = new Object();
    public final FlyoutLauncher f21208a;
    private final ClickListenerPartDefinition f21209b;
    public final GraphQLStoryUtil f21210c;
    public final FeedDiscoveryFunnelLoggerUtil f21211d;

    private static BlingBarFlyoutAndVideoLauncherPartDefinition m28933b(InjectorLike injectorLike) {
        return new BlingBarFlyoutAndVideoLauncherPartDefinition(FlyoutLauncher.m28357a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f21209b, new 1(this, graphQLStory, (CanShowVideoInFullScreen) anyEnvironment, feedProps));
        return null;
    }

    @Inject
    public BlingBarFlyoutAndVideoLauncherPartDefinition(FlyoutLauncher flyoutLauncher, ClickListenerPartDefinition clickListenerPartDefinition, GraphQLStoryUtil graphQLStoryUtil, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil) {
        this.f21208a = flyoutLauncher;
        this.f21209b = clickListenerPartDefinition;
        this.f21210c = graphQLStoryUtil;
        this.f21211d = feedDiscoveryFunnelLoggerUtil;
    }

    public static BlingBarFlyoutAndVideoLauncherPartDefinition m28932a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarFlyoutAndVideoLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21207f) {
                BlingBarFlyoutAndVideoLauncherPartDefinition blingBarFlyoutAndVideoLauncherPartDefinition;
                if (a2 != null) {
                    blingBarFlyoutAndVideoLauncherPartDefinition = (BlingBarFlyoutAndVideoLauncherPartDefinition) a2.mo818a(f21207f);
                } else {
                    blingBarFlyoutAndVideoLauncherPartDefinition = f21206e;
                }
                if (blingBarFlyoutAndVideoLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28933b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21207f, b3);
                        } else {
                            f21206e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarFlyoutAndVideoLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
