package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.CenterDistanceVideoDisplaySelector;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: t_id.%d/admins */
public class ChannelFeedImpressionLoggerPartDefinition<V extends View> extends BaseSinglePartDefinition<Props, VideoViewController, AnyEnvironment, V> {
    private static ChannelFeedImpressionLoggerPartDefinition f2345c;
    private static final Object f2346d = new Object();
    public final VideoDisplayedCoordinator<V> f2347a;
    private final ChannelFeedImpressionLoggerControllerProvider f2348b;

    @Immutable
    /* compiled from: t_id.%d/admins */
    public final class Props {
        public final String f2343a;
        public final FeedProps<GraphQLStory> f2344b;

        public Props(String str, FeedProps<GraphQLStory> feedProps) {
            this.f2343a = str;
            this.f2344b = feedProps;
        }
    }

    private static ChannelFeedImpressionLoggerPartDefinition m2303b(InjectorLike injectorLike) {
        return new ChannelFeedImpressionLoggerPartDefinition(CenterDistanceVideoDisplaySelector.b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), (ChannelFeedImpressionLoggerControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedImpressionLoggerControllerProvider.class));
    }

    public final Object m2304a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return new ChannelFeedImpressionLoggerController(props.f2343a, props.f2344b, FeedUnitSponsoredImpressionLogger.a(this.f2348b));
    }

    public final /* bridge */ /* synthetic */ void m2305a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -574668567);
        this.f2347a.a(view, (VideoViewController) obj2);
        Logger.a(8, EntryType.MARK_POP, -941819786, a);
    }

    @Inject
    public ChannelFeedImpressionLoggerPartDefinition(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, ChannelFeedImpressionLoggerControllerProvider channelFeedImpressionLoggerControllerProvider) {
        this.f2348b = channelFeedImpressionLoggerControllerProvider;
        this.f2347a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
    }

    public static ChannelFeedImpressionLoggerPartDefinition m2302a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedImpressionLoggerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2346d) {
                ChannelFeedImpressionLoggerPartDefinition channelFeedImpressionLoggerPartDefinition;
                if (a2 != null) {
                    channelFeedImpressionLoggerPartDefinition = (ChannelFeedImpressionLoggerPartDefinition) a2.a(f2346d);
                } else {
                    channelFeedImpressionLoggerPartDefinition = f2345c;
                }
                if (channelFeedImpressionLoggerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2303b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2346d, b3);
                        } else {
                            f2345c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedImpressionLoggerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
